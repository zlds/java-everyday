package org.example.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author: hanchaowei
 * @date 2023/3/19
 * @description:
 */

@TableName( "work_file_info")
@Data
public class WorkFileInfo {

	private Long id;

	/**
	 * 用户id
	 */
	private Long userId;

	/**
	 * 文件名称
	 */
	private String fileName;

	/**
	 * 文件真实名称
	 */
	private String fileRealName;

	/**
	 * 文件所在节点
	 */
	private String hostName;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 修改时间
	 */
	private Date updateTime;
}
