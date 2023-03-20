package org.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.model.WorkFileInfo;
import org.springframework.web.multipart.MultipartFile;

import java.net.UnknownHostException;

/**
 * @author: hanchaowei
 * @date 2023/3/18
 * @description:
 */

public interface IFileService extends IService<WorkFileInfo> {

	/**
	 * 单个文件上传
	 * @param file
	 * @return
	 */
	String upload(MultipartFile file);

	/**
	 * 多个文件上传
	 * @param multipartFiles
	 * @return
	 */
	Object uploadMultiple(MultipartFile[] multipartFiles);
}
