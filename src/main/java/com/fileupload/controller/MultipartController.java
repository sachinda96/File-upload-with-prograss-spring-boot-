package com.fileupload.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@CrossOrigin
@RequestMapping(value = "/multipartfile")
public class MultipartController {

    private static String PATH_TO_UPLOAD = "Files/";

    @PostMapping
    public ResponseEntity<?> saveFile(@RequestParam(name = "file")MultipartFile multipartFile){

        try{

            byte[] bytes = multipartFile.getBytes();
            Path path = Paths.get(PATH_TO_UPLOAD + multipartFile.getOriginalFilename());
            Files.write(path, bytes);
            return new ResponseEntity<>("200", HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }


}
