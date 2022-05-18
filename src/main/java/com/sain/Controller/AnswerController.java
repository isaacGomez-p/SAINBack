package com.sain.Controller;

import com.sain.Model.AnswerEntity;
import com.sain.Model.Response;
import com.sain.Model.UserEntity;
import com.sain.Service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/answer")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @PostMapping(value = "/save")
    public Response saveAnswer(@RequestBody AnswerEntity answerEntity){
        return this.answerService.save(answerEntity);
    }

    @PostMapping(value = "/findByUser")
    public Response findByUser(@RequestBody UserEntity userEntity) { return this.answerService.findByUserId(userEntity); }

}
