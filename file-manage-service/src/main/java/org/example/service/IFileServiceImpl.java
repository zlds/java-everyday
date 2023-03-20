package org.example.service;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.dao.WorkFileInfoMapper;
import org.example.dto.FileCreateReqDTO;
import org.example.model.WorkFileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.nio.file.Files;
import java.util.*;

/**
 * @author: hanchaowei
 * @date 2023/3/18
 * @description:
 */

@Service
public class IFileServiceImpl extends ServiceImpl<WorkFileInfoMapper,WorkFileInfo> implements IFileService {

	@Autowired
	private WorkFileInfoMapper workFileInfoMapper;

	/**
	 * 运行上传文件后缀列表
	 */
	private static final String[] ALLOW_EXTENSIONS = new String[]{".jpg", ".png", ".txt", ".doc", ".docx", ".xls",
			".xlsx", ".ppt", ".pptx", ".pdf"};

	@Value("${fileURL}")
	private String fileURL;
	@Override
	public String upload(MultipartFile file) {
		// 获取文件名称
		String originalFilename = file.getOriginalFilename();
		// 获取文件后缀,拼接路径生成新的文件名
		String fileSuffix = originalFilename.substring(originalFilename.lastIndexOf("."));
		// 判断文件后缀是否合法
		if (!isAllow(fileSuffix.toLowerCase())) {
			return "不支持该文件类型";
		}
		String filePath = fileURL + UUID.randomUUID().toString().replace("-","") +
				fileSuffix;
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

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Object uploadMultiple(MultipartFile[] multipartFiles) {
		Map<String, String> map = new HashMap<>();
		List<WorkFileInfo> workFileInfoList = new ArrayList<>();
		for (MultipartFile multipartFile : multipartFiles) {
			String fileName = multipartFile.getOriginalFilename();
			String fileSuffix = fileName.substring(fileName.lastIndexOf("."));
			String newFileName = UUID.randomUUID().toString().replace("-","") + fileSuffix;
			try {
				multipartFile.transferTo(new File(fileURL + newFileName));
				// 入库
				WorkFileInfo workFileInfo = new WorkFileInfo();
				workFileInfo.setId(IdUtil.getSnowflake(1,1).nextId());
				workFileInfo.setFileName(fileName);
				workFileInfo.setFileRealName(newFileName);
				workFileInfo.setUserId(IdUtil.getSnowflake(1,1).nextId());
				workFileInfo.setHostName(InetAddress.getLocalHost().getHostName());
				workFileInfoList.add(workFileInfo);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
			map.put(fileName,newFileName);
		}
		this.saveBatch(workFileInfoList);
		return map;
	}

	private boolean isAllow(String fileSuffix) {
		for (String allowExtension : ALLOW_EXTENSIONS) {
			if (allowExtension.equals(fileSuffix)) {
				return true;
			}
		}
		return false;
	}
}
