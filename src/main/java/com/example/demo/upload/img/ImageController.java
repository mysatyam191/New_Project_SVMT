package com.example.demo.upload.img;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ImageController {

    @Autowired
    private ImageFileService imageFileService;

    @GetMapping("/upload")
    public String showUploadForm() {
        return "upload";
    }

    @PostMapping("/upload")
    public String uploadImage(@RequestParam("imageFile") MultipartFile file, Model model) {
        try {
            imageFileService.saveImage(file);
            model.addAttribute("message", "File uploaded successfully!");
        } catch (IOException e) {
            model.addAttribute("message", "File upload failed!");
        }
        return "upload";
    }

    @GetMapping("/gallery")
    public String showGallery(Model model) {
        List<ImageFile> images = imageFileService.getAllImages();
        List<String> imageStrings = images.stream()
            .map(image -> "data:" + image.getContentType() + ";base64," + Base64.getEncoder().encodeToString(image.getData()))
            .collect(Collectors.toList());
        model.addAttribute("images", imageStrings);
        return "gallery";
    }
}

