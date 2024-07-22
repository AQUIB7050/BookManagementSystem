package com.bootrestbook.bootrestbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bootrestbook.bootrestbook.helper.FileUploadHelper;

@RestController
public class FileUploadController {

    @Autowired
    private FileUploadHelper fileUploadHelper;

    @PostMapping("/upload_file")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){

        try {
            if(file.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Please select a file then try again");
            }
    
            if(!(file.getContentType().equals("image/png"))){
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Please select a png file");
            }

            boolean f  = fileUploadHelper.uploadFile(file);
            if(f){
                return ResponseEntity.ok("File Uploaded Successfully");
            }
        
        } catch (Exception e){
            e.printStackTrace();
        }
        

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something Went Wrong please try again");

    }

}
