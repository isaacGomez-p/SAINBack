package com.sain.Controller;

import com.sain.Model.Response;
import com.sain.Model.ResumeEntity;
import com.sain.Model.UserEntity;
import com.sain.Service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resume")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @PostMapping(value = "/save")
    public Response saveResume(@RequestBody ResumeEntity resumeEntity){
        return this.resumeService.save(resumeEntity);
    }

    @PostMapping(value = "/findByUser")
    public Response findByUser(@RequestBody UserEntity userEntity) { return this.resumeService.findByUser(userEntity); }

}
