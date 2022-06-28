package com.sain.Service;

import com.sain.Model.RequestEntity;
import com.sain.Model.Response;
import com.sain.Model.ResumeEntity;
import com.sain.Model.UserEntity;

public interface ResumeService {

    public Response save(ResumeEntity resumeEntity);

    public Response findAll();

    public Response findByUserAssign(UserEntity userEntity);

    public Response findByUserCreate(UserEntity userEntity);

    public Response counters(RequestEntity requestEntity);

    public Response delete(RequestEntity requestEntity);

}
