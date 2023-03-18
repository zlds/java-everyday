package org.example.service;

import org.example.dto.FileCreateReqDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.nio.file.Files;
import java.util.UUID;

/**
 * @author: hanchaowei
 * @date 2023/3/18
 * @description:
 */

@Service
public class IFileServiceImpl implements IFileService {

	@Value("${fileURL}")
	private String fileURL;
	@Override
	public String upload(MultipartFile file) {
		// 获取文件名称
		String originalFilename = file.getOriginalFilename();
		// 获取文件后缀,拼接路径生成新的文件名
		String suffixString = originalFilename.substring(originalFilename.lastIndexOf("."));
		String filePath = fileURL + UUID.randomUUID().toString().replace("-","") + suffixString;
		File dest = new File(filePath);
		try {
			Files.copy(file.getInputStream(), dest.toPath());
			// 数据库中记录文件名称(伪代码)
			FileCreateReqDTO fileCreateReqDTO = new FileCreateReqDTO();
			fileCreateReqDTO.setFileName(originalFilename);
			fileCreateReqDTO.setFileRealName(filePath);
			fileCreateReqDTO.setServerName(InetAddress.getLocalHost().getHostName());
			// fileMapper.insert(fileCreateReqDTO);
			return "文件所在主机节点: " + fileCreateReqDTO.getServerName() + " 文件名称: " + fileCreateReqDTO.getFileName() + " 文件路径: " + dest.getAbsolutePath();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}


	}
}
