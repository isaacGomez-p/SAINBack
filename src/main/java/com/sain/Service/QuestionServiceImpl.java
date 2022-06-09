package com.sain.Service;

import com.sain.Model.*;
import com.sain.Repository.QuestionsRepository;
import com.sain.Repository.RoleRepository;
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

    @Autowired
    private RoleRepository roleRepository;

    @Transactional(readOnly = true)
    public Response findAll(RequestEntity requestEntity) {
    Set<RoleEntity> roleEntitySet = new HashSet<>();
    roleEntitySet.add(roleRepository.findById(Integer.parseInt(requestEntity.getData())).get());
    List<QuestionsEntity> questionsEntityList = questionsRepository.findByRolesIn(roleEntitySet);
    if(questionsEntityList.isEmpty())
        return new Response(HttpStatus.NO_CONTENT, "No Data Found!", null);
    else
        return new Response(HttpStatus.OK, "Data Found!", questionsEntityList);
    }

    @Transactional(readOnly = true)
    public Response getCount() {
        return new Response(HttpStatus.OK, questionsRepository.findAll().size());
    }
}
