package org.example.controller;

import org.example.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author: hanchaowei
 * @date 2023/3/17
 * @description:
 */
@RestController
@RequestMapping("/file")
public class FileUploadController {

	@Autowired
	IFileService iFileService;

	@PostMapping("/upload")
	public String upload(@RequestParam("file") MultipartFile file) {
		return iFileService.upload(file);
	}

	@PostMapping("/uploadMultiple")
	public Object uploadMultiple(@RequestParam("file") MultipartFile[] file) {
		return iFileService.uploadMultiple(file);
	}
}
