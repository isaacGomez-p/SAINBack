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

    @PostMapping(value = "/findByUserAssign")
    public Response findByUserAssign(@RequestBody UserEntity userEntity) { return this.resumeService.findByUserAssign(userEntity); }

    @PostMapping(value = "/findByUserCreate")
    public Response findByUserCreate(@RequestBody UserEntity userEntity) { return this.resumeService.findByUserCreate(userEntity); }

    @PostMapping(value = "/recCount")
    public Response recCount() { return this.resumeService.counters(); }

}
