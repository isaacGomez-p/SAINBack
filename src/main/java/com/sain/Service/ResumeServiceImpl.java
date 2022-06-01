package com.sain.Service;

import com.sain.Model.AnswerEntity;
import com.sain.Model.Response;
import com.sain.Model.ResumeEntity;
import com.sain.Model.UserEntity;
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

    @Transactional
    public Response save(ResumeEntity resumeEntity) {
        resumeEntity.setCreationDate(new Date());
        resumeEntity.setRecommendation(Constants.REC_WAITING);
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
    public Response counters() {
        List<Long> list = new ArrayList<>();

        list.add(resumeRepository.findByRecommendation(Constants.REC_WAITING));
        list.add(resumeRepository.findByRecommendation(Constants.REC_PROCESSING));
        list.add(resumeRepository.findByRecommendation(Constants.REC_FINISHED));
        return new Response(HttpStatus.OK, list);
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
                if(count.get() == questionsCount){
                    resumeEntity.setRecommendation(Constants.REC_FINISHED);
                }else if(count.get() > 0 && count.get() < questionsCount){
                    resumeEntity.setRecommendation(Constants.REC_PROCESSING);
                } else {
                    resumeEntity.setRecommendation(Constants.REC_WAITING);
                }
                resumeEntity.setVerified(count.get());
            });
            resumeEntityList = resumeRepository.saveAll(resumeEntityList);
        }
        return resumeEntityList;
    }
}
