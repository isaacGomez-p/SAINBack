package com.sain.Service;

import com.sain.Model.*;
import com.sain.Repository.QuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class QuestionServiceImpl implements QuestionsService{

    @Autowired
    private QuestionsRepository questionsRepository;

    @Transactional(readOnly = true)
    public Response findAll(RequestEntity requestEntity) {
    Set<RoleEntity> roleEntitySet = new HashSet<>();
    roleEntitySet.add(getRoleName(requestEntity.getData()));
    List<QuestionsEntity> questionsEntityList = questionsRepository.findBySectionAndRoles(requestEntity.getId(), roleEntitySet);
    if(questionsEntityList.isEmpty())
        return new Response(HttpStatus.NO_CONTENT, "No Data Found!", null);
    else
        return new Response(HttpStatus.OK, "Data Found!", questionsEntityList);
    }

    private RoleEntity getRoleName(String data){
        RoleEntity roleEntity = new RoleEntity();
        switch (data){
            case "ADMIN":
                roleEntity.setName(Roles.ADMIN);
                break;
            case "CLIENTE":
                roleEntity.setName(Roles.CLIENTE);
                break;
            case "PROVEEDOR":
                roleEntity.setName(Roles.PROVEEDOR);
                break;
        }
        return roleEntity;
    }
}
