package com.sain.Service;

import com.sain.Model.RequestEntity;
import com.sain.Model.Response;
import com.sain.Model.UserEntity;

public interface UserService {

    public Response save(UserEntity userEntity);
    public Response login(UserEntity userEntity);
    public Response findByRole(RequestEntity requestEntity);
    public Response update(UserEntity userEntity);

}
