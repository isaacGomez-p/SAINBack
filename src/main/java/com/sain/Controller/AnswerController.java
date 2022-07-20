package com.sain.Controller;

import com.sain.Model.AnswerEntity;
import com.sain.Model.Response;
import com.sain.Model.ResumeAnswerDTO;
import com.sain.Model.ResumeEntity;
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

    @PostMapping(value = "/update")
    public Response updateAnswer(@RequestBody ResumeAnswerDTO resumeAnswerDTO){
        return this.answerService.update(resumeAnswerDTO.getResumeEntity(), resumeAnswerDTO.getAnswerEntity());
    }

    @PostMapping(value = "/findByResume")
    public Response findBbyResume(@RequestBody ResumeEntity resumeEntity) { return this.answerService.findByResume(resumeEntity); }

}
