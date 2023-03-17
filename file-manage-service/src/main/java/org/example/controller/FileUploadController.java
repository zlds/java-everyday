package org.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: hanchaowei
 * @date 2023/3/17
 * @description:
 */
@RestController
@RequestMapping("/file")
public class FileUploadController {

	/**
	 * 允许上传的扩展名
	 */
	private static final String[] ALLOW_EXTENSION = {"jpg","jpeg","png","gif"};
	@Value("${fileURL}")
	private String fileURL;


	@GetMapping("/upload")
	public Object upload() {
		return fileURL;
	}
	
}
