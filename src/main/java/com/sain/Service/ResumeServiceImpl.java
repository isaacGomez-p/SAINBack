package com.sain.Service;

import com.sain.Model.Response;
import com.sain.Model.ResumeEntity;
import com.sain.Model.UserEntity;
import com.sain.Repository.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class ResumeServiceImpl implements ResumeService{

    @Autowired
    private ResumeRepository resumeRepository;

    @Transactional
    public Response save(ResumeEntity resumeEntity) {
        resumeEntity.setCreationDate(new Date());
        return new Response(HttpStatus.CREATED, resumeRepository.save(resumeEntity));
    }

    @Transactional(readOnly = true)
    public Response findByUser(UserEntity userEntity) {
        return new Response(HttpStatus.OK, resumeRepository.findByUserAssign(userEntity));
    }
}