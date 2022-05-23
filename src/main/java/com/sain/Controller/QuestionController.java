package com.sain.Controller;

import com.sain.Model.QuestionsEntity;
import com.sain.Model.Response;
import com.sain.Repository.QuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/question")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class QuestionController {

    @Autowired
    private QuestionsRepository questionsRepository;

    @PostMapping(value = "/findAll")
    public Response findAll(@RequestBody QuestionsEntity questionsEntity) { return new Response(HttpStatus.OK, questionsRepository.findAll()); }

}
