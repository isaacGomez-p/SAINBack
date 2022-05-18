package com.sain.Service;

import com.sain.Model.AnswerEntity;
import com.sain.Model.Response;
import com.sain.Model.UserEntity;

public interface AnswerService {

    public Response save(AnswerEntity answerEntity);

    public Response findByUserId(UserEntity userEntity);

}
