package org.example.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author: hanchaowei
 * @date 2023/3/18
 * @description:
 */

public interface IFileService {

	public String upload(MultipartFile file);
}
