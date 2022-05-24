package com.sain.Service;

import com.sain.Model.RequestEntity;
import com.sain.Model.Response;
import com.sain.Model.UserEntity;
import com.sain.Repository.UserRepository;
import com.sain.Utils.EncryptDecryptPwd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public Response save(UserEntity userEntity) {
        EncryptDecryptPwd encryptDecryptPwd = new EncryptDecryptPwd();
        userEntity.setPassword(encryptDecryptPwd.encryptKey(userEntity.getPassword()));
        return new Response(HttpStatus.CREATED, userRepository.save(userEntity));
    }

    @Transactional
    public Response login(UserEntity userEntity) {
        if(userEntity.getPassword() == null || userEntity.getPassword().equals("") || userEntity.getEmail() == null || userEntity.getEmail().equals("")){
            return new Response(HttpStatus.CONFLICT, "Password and Email required");
        }

        Optional<UserEntity> optional = userRepository.findByEmail(userEntity.getEmail());
        if(optional != null && optional.isPresent()){
            if(confirmCredentials(userEntity.getPassword(), optional.get())){
                return new Response(HttpStatus.OK, "Login passed!", optional.get());
            }else{
                return new Response(HttpStatus.CONFLICT, "Password does not match");
            }
        }else{
            return new Response(HttpStatus.NOT_FOUND, "Email does not exist");
        }
    }

    @Transactional(readOnly = true)
    public Response findByRole(RequestEntity requestEntity) {
        return new Response(HttpStatus.OK, "Data found", userRepository.findByRole(requestEntity.getId()));
    }

    private boolean confirmCredentials(String password, UserEntity userSaved){
        EncryptDecryptPwd encryptDecryptPwd = new EncryptDecryptPwd();
        return encryptDecryptPwd.decryptKey(userSaved.getPassword()).equals(password);
    }
}
