package com.sain.Service;

import com.sain.Model.Response;
import com.sain.Model.ResumeEntity;
import com.sain.Model.UserEntity;

public interface ResumeService {

    public Response save(ResumeEntity resumeEntity);

    public Response findByUser(UserEntity userEntity);

}
