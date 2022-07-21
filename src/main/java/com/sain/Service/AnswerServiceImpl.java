package com.sain.Service;

import com.sain.Model.AnswerEntity;
import com.sain.Model.Response;
import com.sain.Model.ResumeEntity;
import com.sain.Model.UserEntity;
import com.sain.Repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Service
public class AnswerServiceImpl implements AnswerService{

    @Autowired
    private AnswerRepository answerRepository;

    @Transactional
    public Response save(AnswerEntity answerEntity) {
        return new Response(HttpStatus.CREATED, answerRepository.save(answerEntity));
    }

    @Override
    public Response update(ResumeEntity resumeEntity, AnswerEntity answerEntity) {
         if (answerEntity.getAnswerId() == null) {
             if(answerEntity.getVerified()){
                 answerEntity.setVerifiedDate(new Date());
             }
            answerEntity.setResumes(resumeEntity);
            return new Response(HttpStatus.OK, "Entity Saved", answerRepository.save(answerEntity));
        } else {
            Optional<AnswerEntity> optional = answerRepository.findById(answerEntity.getAnswerId());
            if (optional != null && optional.isPresent()) {
                optional.get().setDescription(answerEntity.getDescription());
                optional.get().setResult(answerEntity.getResult());
                optional.get().setUserMod(answerEntity.getUserMod());
                optional.get().setVerified(answerEntity.getVerified());
                optional.get().setObservation(answerEntity.getObservation());
                if(answerEntity.getVerified()){
                    if(optional.get().getVerifiedDate() == null) {
                        optional.get().setVerifiedDate(new Date());
                    }
                }
                return new Response(HttpStatus.OK, "Entity Updated", answerRepository.save(optional.get()));
            }else {
                return new Response(HttpStatus.NOT_FOUND, "Entity Not Found");
            }
        }
    }

    @Transactional(readOnly = true)
    public Response findByResume(ResumeEntity resumeEntity) {
        return new Response(HttpStatus.OK, answerRepository.findByResumes(resumeEntity));
    }
}
