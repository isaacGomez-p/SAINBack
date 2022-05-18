package com.sain.Controller;

import com.sain.Model.Response;
import com.sain.Model.UserEntity;
import com.sain.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/save")
    public Response saveUser(@RequestBody UserEntity userEntity){
        return this.userService.save(userEntity);
    }

    @PostMapping(value = "/login")
    public Response login(@RequestBody UserEntity userEntity) { return this.userService.login(userEntity); }

}
