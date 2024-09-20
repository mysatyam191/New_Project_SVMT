package com.example.demo.upload.img;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ImageFileService {

    @Autowired
    private ImageFileRepository imageFileRepository;

    public void saveImage(MultipartFile file) throws IOException {
        ImageFile imageFile = new ImageFile(file.getOriginalFilename(), file.getBytes(), file.getContentType());
        imageFileRepository.save(imageFile);
    }

    public List<ImageFile> getAllImages() {
        return imageFileRepository.findAll();
    }
}

