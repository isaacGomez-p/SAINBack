package com.sain.Service;

import com.sain.Model.AnswerEntity;
import com.sain.Model.Response;
import com.sain.Model.UserEntity;
import com.sain.Repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AnswerServiceImpl implements AnswerService{

    @Autowired
    private AnswerRepository answerRepository;

    @Transactional
    public Response save(AnswerEntity answerEntity) {
        return new Response(HttpStatus.CREATED, answerRepository.save(answerEntity));
    }

    @Transactional(readOnly = true)
    public Response findByUserId(UserEntity userId) {
        return null;
    }
}
