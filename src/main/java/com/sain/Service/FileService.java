package com.sain.Service;

import com.sain.Model.FileEntity;
import com.sain.Model.RequestEntity;
import com.sain.Model.Response;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {

    public Response save(FileEntity fileEntity) throws Exception;
    public Response findByModuleIdAndModule(FileEntity fileEntity);
    public List<FileEntity> setFiles(FileEntity fileEntity);
    public Response findByModuleId(RequestEntity requestEntity);
}
