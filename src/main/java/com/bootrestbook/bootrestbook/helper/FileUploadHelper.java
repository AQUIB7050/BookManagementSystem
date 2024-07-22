package com.bootrestbook.bootrestbook.helper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

    String upload_path = "/Users/aquibahmed/Desktop/SpringBoot/bootrestbook/src/main/resources/static/image";
    //public final String upload_path = new ClassPathResource("/static/image").getFile().getAbsolutePath();
    

    
    public boolean uploadFile(MultipartFile file){
        try{
            Files.copy(file.getInputStream(), Paths.get(upload_path+File.separator+file.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch(Exception e){
            e.printStackTrace();
            return false;
        }
        
    }  

}
