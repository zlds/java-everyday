package org.example.elastic.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

/**
 * @author: hanchaowei
 * @date 2023/4/8
 * @description:
 */

public class MySimpleJob implements SimpleJob {
	@Override
	public void execute(ShardingContext shardingContext) {
		System.out.println("执行作业任务，分片：" + shardingContext.getShardingItem());
	}
}
