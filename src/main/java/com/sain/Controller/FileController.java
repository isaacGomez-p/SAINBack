package com.sain.Controller;

import com.sain.Model.FileEntity;
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

    @RequestMapping(value="/saveFile", method= RequestMethod.POST)
    public Response saveFile (@RequestPart("file") MultipartFile file, @RequestPart("data") FileEntity fileEntity) throws Exception {
        return fileService.save(file, fileEntity);
    }

    @RequestMapping(value="/findFile", method= RequestMethod.POST)
    public Response findFile (@RequestBody FileEntity fileEntity){
        return fileService.findByModuleIdAndModule(fileEntity);
    }

}
