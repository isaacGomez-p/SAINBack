package com.sain.Service;

import com.sain.Model.*;
import com.sain.Repository.AnswerRepository;
import com.sain.Repository.QuestionsRepository;
import com.sain.Repository.ResumeRepository;
import com.sain.Utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ResumeServiceImpl implements ResumeService{

    @Autowired
    private ResumeRepository resumeRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private QuestionsRepository questionsRepository;

    private static final String USER_ASSIGN = "userAssign";
    private static final String USER_CREATE = "userCreate";
    private static final String ADMIN = "admin";

    @Transactional
    public Response save(ResumeEntity resumeEntity) {
        resumeEntity.setCreationDate(new Date());
        resumeEntity.setRecommendation(Constants.REC_REGISTERED);
        if(resumeEntity.getStatus() != null && !resumeEntity.getStatus().equals("")
                && resumeEntity.getAdminObservation() != null && !resumeEntity.getAdminObservation().equals("")){
            resumeEntity.setRecommendation(Constants.REC_FINISHED);
        }
        ResumeEntity savedResume = resumeRepository.save(resumeEntity);
        if(resumeEntity.getAnswerEntities() != null && !resumeEntity.getAnswerEntities().isEmpty()){
            resumeEntity.getAnswerEntities().forEach(answerEntity -> {
                answerEntity.setResumes(savedResume);
                if(answerEntity.getAnswerId() != null){
                    Optional<AnswerEntity> optional = answerRepository.findById(answerEntity.getAnswerId());
                    if(optional.isPresent()){
                        optional.get().setVerified(answerEntity.getVerified());
                        optional.get().setResult(answerEntity.getResult());
                        optional.get().setDescription(answerEntity.getDescription());
                        optional.get().setUserMod(answerEntity.getUserMod());
                        optional.get().setVerifiedDate(new Date());
                        answerRepository.save(optional.get());
                    }
                } else {
                    answerEntity.setCreationDate(new Date());
                    answerRepository.save(answerEntity);
                }
            });
        }

        return new Response(HttpStatus.CREATED, savedResume);
    }

    @Transactional
    public Response findAll() {
        return new Response(HttpStatus.OK, this.updateVerifiedAnswers(resumeRepository.findAll()));
    }

    @Transactional
    public Response findByUserAssign(UserEntity userEntity) {
        return new Response(HttpStatus.OK, this.updateVerifiedAnswers(resumeRepository.findByUserAssign(userEntity)));
    }

    @Transactional
    public Response findByUserCreate(UserEntity userEntity) {
        return new Response(HttpStatus.OK, this.updateVerifiedAnswers(resumeRepository.findByUserCreate(userEntity)));
    }

    @Transactional(readOnly = true)
    public Response counters(RequestEntity requestEntity) {
        List<Long> list = new ArrayList<>();
        if(requestEntity.getData().equals(USER_ASSIGN)){
            list.add(resumeRepository.findByRecommendationAndUserAssignId(Constants.REC_REGISTERED, requestEntity.getId()) == null ? 0 : resumeRepository.findByRecommendationAndUserAssignId(Constants.REC_REGISTERED, requestEntity.getId()));
            list.add(resumeRepository.findByRecommendationAndUserAssignId(Constants.REC_WAITING, requestEntity.getId()) == null ? 0 : resumeRepository.findByRecommendationAndUserAssignId(Constants.REC_WAITING, requestEntity.getId()));
            list.add(resumeRepository.findByRecommendationAndUserAssignId(Constants.REC_PROCESSING, requestEntity.getId()) == null ? 0 : resumeRepository.findByRecommendationAndUserAssignId(Constants.REC_PROCESSING, requestEntity.getId()));
            list.add(resumeRepository.findByRecommendationAndUserAssignId(Constants.REC_CHECKED, requestEntity.getId()) == null ? 0 : resumeRepository.findByRecommendationAndUserAssignId(Constants.REC_CHECKED, requestEntity.getId()));
            list.add(resumeRepository.findByRecommendationAndUserAssignId(Constants.REC_FINISHED, requestEntity.getId()) == null ? 0 : resumeRepository.findByRecommendationAndUserAssignId(Constants.REC_FINISHED, requestEntity.getId()));
        }
        if(requestEntity.getData().equals(USER_CREATE)){
            list.add(resumeRepository.findByRecommendationAndUserCreateId(Constants.REC_REGISTERED, requestEntity.getId()) == null ? 0 : resumeRepository.findByRecommendationAndUserCreateId(Constants.REC_REGISTERED, requestEntity.getId()));
            list.add(resumeRepository.findByRecommendationAndUserCreateId(Constants.REC_WAITING, requestEntity.getId()) == null ? 0 : resumeRepository.findByRecommendationAndUserCreateId(Constants.REC_WAITING, requestEntity.getId()));
            list.add(resumeRepository.findByRecommendationAndUserCreateId(Constants.REC_PROCESSING, requestEntity.getId()) == null ? 0 : resumeRepository.findByRecommendationAndUserCreateId(Constants.REC_PROCESSING, requestEntity.getId()));
            list.add(resumeRepository.findByRecommendationAndUserCreateId(Constants.REC_CHECKED, requestEntity.getId()) == null ? 0 : resumeRepository.findByRecommendationAndUserCreateId(Constants.REC_CHECKED, requestEntity.getId()));
            list.add(resumeRepository.findByRecommendationAndUserCreateId(Constants.REC_FINISHED, requestEntity.getId()) == null ? 0 : resumeRepository.findByRecommendationAndUserCreateId(Constants.REC_FINISHED, requestEntity.getId()));
        }
        if(requestEntity.getData().equals(ADMIN)){
            list.add(resumeRepository.findByRecommendation(Constants.REC_REGISTERED) == null ? 0 : resumeRepository.findByRecommendation(Constants.REC_REGISTERED));
            list.add(resumeRepository.findByRecommendation(Constants.REC_WAITING) == null ? 0 : resumeRepository.findByRecommendation(Constants.REC_WAITING));
            list.add(resumeRepository.findByRecommendation(Constants.REC_PROCESSING) == null ? 0 : resumeRepository.findByRecommendation(Constants.REC_PROCESSING));
            list.add(resumeRepository.findByRecommendation(Constants.REC_CHECKED) == null ? 0 : resumeRepository.findByRecommendation(Constants.REC_CHECKED));
            list.add(resumeRepository.findByRecommendation(Constants.REC_FINISHED) == null ? 0 : resumeRepository.findByRecommendation(Constants.REC_FINISHED));
        }
        return new Response(HttpStatus.OK, list);
    }

    @Transactional
    public Response delete(RequestEntity requestEntity) {
        resumeRepository.deleteById(requestEntity.getId());
        return new Response(HttpStatus.NO_CONTENT, "Resume Deleted");
    }

    private List<ResumeEntity> updateVerifiedAnswers(List<ResumeEntity> resumeEntityList){
        long questionsCount = questionsRepository.count();
        if(resumeEntityList != null && !resumeEntityList.isEmpty()){
            resumeEntityList.forEach(resumeEntity -> {
                AtomicInteger count = new AtomicInteger();
                resumeEntity.getAnswerEntities().forEach(answerEntity -> {
                    if(answerEntity.getVerified() != null && answerEntity.getVerified()){
                        count.getAndIncrement();
                    }
                });
                if(resumeEntity.getRecommendation() != null && !resumeEntity.getRecommendation().equals(Constants.REC_FINISHED)){
                    if(count.get() == questionsCount){
                        resumeEntity.setRecommendation(Constants.REC_CHECKED);
                    }else if(count.get() > 0 && count.get() < questionsCount){
                        resumeEntity.setRecommendation(Constants.REC_PROCESSING);
                    } else {
                        resumeEntity.setRecommendation(Constants.REC_WAITING);
                    }
                    resumeEntity.setVerified(count.get());
                }
            });
            resumeEntityList = resumeRepository.saveAll(resumeEntityList);
        }
        return resumeEntityList;
    }
}
