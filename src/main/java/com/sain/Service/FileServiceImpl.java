package com.sain.Service;

import com.sain.Model.FileEntity;
import com.sain.Model.RequestEntity;
import com.sain.Model.Response;
import com.sain.Repository.FileRepository;
import com.sain.Utils.SainUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class FileServiceImpl implements FileService{

    @Autowired
    private FileRepository fileRepository;
    @Autowired
    private SainUtils sainUtils;

    @Transactional
    public Response save(FileEntity fileEntity) throws Exception {
        if(fileEntity.getFilee() == null){
            throw new Exception("Error");//ServiceException(TempEdgeErrorCode.ERROR_CODE_06, TempEdgeErrorKey.ERROR_KEY_03);
        }
        fileEntity = sainUtils.saveFiles(fileEntity);
        Optional<FileEntity> fileEntity1 = fileRepository.findByModuleIdAndModuleAndType(fileEntity.getModuleId(), fileEntity.getModule(), fileEntity.getType());
        if(fileEntity1 != null && fileEntity1.isPresent()){
            fileEntity1.get().setFilee(fileEntity.getFilee());
            fileEntity1.get().setFileName(fileEntity.getFileName());
            fileEntity1.get().setLocation(fileEntity.getLocation());
            fileEntity1.get().setDtModify(new Date());
            fileEntity1.get().setExtension(fileEntity.getExtension());
            fileEntity1.get().setType(fileEntity.getType());
            fileRepository.save(fileEntity1.get());
        }else{
            fileRepository.save(fileEntity);
        }
        return new Response(HttpStatus.OK, "File Saved");
    }

    @Transactional(readOnly = true)
    public Response findByModuleIdAndModule(FileEntity fileEntity){
        List<FileEntity> filesList = this.setFiles(fileEntity);
        if(filesList != null && !filesList.isEmpty()) {
            return new Response(HttpStatus.OK, "Data Found", filesList);
        }else {
            return new Response(HttpStatus.NOT_FOUND, "Data not Found");
        }
    }

    public List<FileEntity> setFiles(FileEntity fileEntity) {
        List<FileEntity> filesList = fileRepository.findByModuleIdAndModule(fileEntity.getModuleId(), fileEntity.getModule());
        if(filesList != null && !filesList.isEmpty()) {
            filesList.forEach(fileEntity1 -> {
                try {
                    Path path = Paths.get(fileEntity1.getLocation());
                    byte[] data;
                    data = Files.readAllBytes(path);
                    fileEntity1.setFile(data);
                } catch (IOException e) {
                    System.out.println("e" + e.getMessage());
                }
                fileEntity1.setLocation(null);
            });
        }
        return filesList;
    }


    public Response findByModuleId(RequestEntity requestEntity) {
        List<FileEntity> fileEntityList = fileRepository.findByModuleId(requestEntity.getId());
        if(fileEntityList != null && fileEntityList.size() > 0){
            return new Response(HttpStatus.OK, "Datos encontrados", fileEntityList);
        }else{
            return new Response(HttpStatus.NOT_FOUND, "No hay archivos para esta persona");
        }
    }

}
