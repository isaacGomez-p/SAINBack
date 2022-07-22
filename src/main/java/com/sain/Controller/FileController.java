package com.sain.Controller;

import com.sain.Model.FileEntity;
import com.sain.Model.RequestEntity;
import com.sain.Model.Response;
import com.sain.Service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/file")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class FileController {

    @Autowired
    private FileService fileService;

    @RequestMapping(value="/save", method= RequestMethod.POST)
    public Response saveFile (@RequestBody FileEntity fileEntity) throws Exception {
        return fileService.save(fileEntity);
    }

    @RequestMapping(value="/find", method= RequestMethod.POST)
    public Response findFile (@RequestBody FileEntity fileEntity){
        return fileService.findByModuleIdAndModule(fileEntity);
    }

    @RequestMapping(value="/findByModuleId", method= RequestMethod.POST)
    public Response findByModuleId (@RequestBody RequestEntity requestEntity){
        return fileService.findByModuleId(requestEntity);
    }

}
