package com.sain.Service;

import com.sain.Model.AnswerEntity;
import com.sain.Model.Response;
import com.sain.Model.ResumeEntity;
import com.sain.Model.UserEntity;

public interface AnswerService {

    public Response save(AnswerEntity answerEntity);

    public Response update(ResumeEntity resumeEntity, AnswerEntity answerEntity);

    public Response findByResume(ResumeEntity resumeEntity);

}
