package com.sain.Controller;

import com.sain.Model.RequestEntity;
import com.sain.Model.Response;
import com.sain.Service.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/question")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class QuestionController {

    @Autowired
    private QuestionsService questionsService;

    @PostMapping(value = "/findAll")
    public Response findAll(@RequestBody RequestEntity requestEntity) { return new Response(HttpStatus.OK, questionsService.findAll(requestEntity)); }

}
