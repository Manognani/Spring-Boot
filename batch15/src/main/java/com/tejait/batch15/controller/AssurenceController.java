package com.tejait.batch15.controller;
import com.tejait.batch15.model.Assurence;
import com.tejait.batch15.repository.AssurenceRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("uploadfile")
public class AssurenceController {

    AssurenceRepository repository;

    private final String UPLOAD_DIR = "/Downloads";

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {

        try {
            File directory = new File(UPLOAD_DIR);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            String filePath = UPLOAD_DIR + file.getOriginalFilename();
            file.transferTo(new File(filePath));

            return ResponseEntity.ok("File uploaded successfully: " + file.getOriginalFilename());

        } catch (IOException e) {
            return ResponseEntity.internalServerError().body("Upload failed!");
        }
    }

    @PostMapping("save")
    public ResponseEntity<Assurence> save(@RequestBody Assurence assu) {
          Assurence saved=repository.save(assu);
      return new ResponseEntity<>(saved, HttpStatus.CREATED);


    }
    @GetMapping("findall")
    public ResponseEntity<List<Assurence>> findAll(){
        List<Assurence> list=repository.findAll();
        return new ResponseEntity<>(list,HttpStatus.CREATED);

    }
}
