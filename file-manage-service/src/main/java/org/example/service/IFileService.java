package org.example.service;

import org.springframework.web.multipart.MultipartFile;

import java.net.UnknownHostException;

/**
 * @author: hanchaowei
 * @date 2023/3/18
 * @description:
 */

public interface IFileService {

	/**
	 * 单个文件上传
	 * @param file
	 * @return
	 */
	public String upload(MultipartFile file);

	/**
	 * 多个文件上传
	 * @param multipartFiles
	 * @return
	 */
	public Object uploadMultiple(MultipartFile[] multipartFiles);
}
