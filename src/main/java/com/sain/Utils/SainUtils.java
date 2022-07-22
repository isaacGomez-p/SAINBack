package com.sain.Utils;

import com.sain.Model.FileEntity;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;

@Component
public class SainUtils {

    @Value("${files.directory}")
    private String FILE_PATH;

    public FileEntity saveFiles(FileEntity fileEntity){
        try {
            String dirName = FILE_PATH + File.separator  + "_" + File.separator;
            String fileName = fileEntity.getModuleId().toString() + "_";
            if(fileEntity.getFilee() != null) {
                if(fileEntity.getType() == null || fileEntity.getType().equals("")){
                    throw new Exception("Error");//ServiceException(TempEdgeErrorCode.ERROR_CODE_06, TempEdgeErrorKey.ERROR_KEY_03);
                }

                fileName = dirName + File.separator + fileName + "_" + fileEntity.getType();

                File directory = new File(fileName);
                if (!directory.exists()) {
                    fileEntity.setDtCreate(new Date());
                }else{
                    fileEntity.setDtModify(new Date());
                }

                if(fileEntity.getExtension() == null || fileEntity.getExtension().equals("")){
                    throw new Exception("Error");//throw new ServiceException(TempEdgeErrorCode.ERROR_CODE_06, TempEdgeErrorKey.ERROR_KEY_03);
                }

                fileName += "." + fileEntity.getExtension();
                fileName = fileName.trim();

                File savedDocs = new File(fileName);
                byte[] targetArray = fileEntity.getFilee();
                FileUtils.writeByteArrayToFile(savedDocs, targetArray);
                fileEntity.setFileName(savedDocs.getName());
                fileEntity.setLocation(fileName);
            }
        } catch (Exception e) {
            System.out.println("error");
        }
        return fileEntity;
    }
}
