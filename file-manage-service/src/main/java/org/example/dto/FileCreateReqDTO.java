package org.example.dto;

import lombok.Data;

/**
 * @author: hanchaowei
 * @date 2023/3/18
 * @description:
 */

@Data
public class FileCreateReqDTO {

	/**
	 * 文件名称
	 */
	private String fileName;
	/**
	 * 文件本地路径名称
	 */
	private String fileRealName;

	/**
	 * 文件所在服务器名称(集群多实例，无法共享文件,通过nginx转发到真实的节点)
	 */
	private String serverName;
}
