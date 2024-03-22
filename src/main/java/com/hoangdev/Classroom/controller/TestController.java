package com.hoangdev.Classroom.controller;


import com.hoangdev.Classroom.models.Res;
import com.hoangdev.Classroom.service.upload.UploadFileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

import static com.hoangdev.Classroom.utils.Helper.generateRandomFileName;


@RestController
@RequestMapping("/api")
public class TestController {
    @Autowired
    private UploadFileServiceImpl uploadFileService;

    @PostMapping("/upload-to-google-drive")
    public Object handleFileUpload(@RequestParam("file")MultipartFile multipartFile) throws Exception{

            if (multipartFile.isEmpty()) {
                return "FIle is empty";
            }
            String newFileName = generateRandomFileName(multipartFile.getOriginalFilename());
            File file = File.createTempFile("temp", null);
            multipartFile.transferTo(file);
            Res res = uploadFileService.uploadFileToDrive(file);
            System.out.println(res);
            return res;
    }


}
