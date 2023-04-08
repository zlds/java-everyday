package org.example.elastic.job;

import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.executor.ShardingContexts;
import com.dangdang.ddframe.job.lite.api.JobScheduler;
import com.dangdang.ddframe.job.lite.api.listener.AbstractDistributeOnceElasticJobListener;
import com.dangdang.ddframe.job.lite.api.listener.ElasticJobListener;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.reg.base.CoordinatorRegistryCenter;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;

/**
 * @author: hanchaowei
 * @date 2023/4/8
 * @description:
 */

public class ElasticJobConfig {
	public static void main(String[] args) {
		/**
		 * 配置作业
		 * jobName: 作业名称
		 * shardingTotalCount: 分片总数
		 * cron: cron表达式，用于控制作业触发时间
		 * shardingItemParameters: 分片序列号和参数用等号分隔，多个键值对用逗号分隔，分片序列号从0开始，不可大于或等于作业分片总数如：0=a,1=b,2=c
		 */
		String jobName = "my-job";
		int shardingTotalCount = 3;
		String cron = "0/5 * * * * ?";
		String shardingItemParameters = "0=A";

		// 配置注册中心
		CoordinatorRegistryCenter registryCenter = coordinatorRegistryCenter();
		registryCenter.init();
		// 配置监听器
		ElasticJobListener jobListener = createJobListener();
		// 创建作业调度器
		JobScheduler jobScheduler = new JobScheduler(registryCenter, createJobConfiguration(jobName, shardingTotalCount, cron,shardingItemParameters), jobListener);
		jobScheduler.init();
	}


	// 配置注册中心
	private static CoordinatorRegistryCenter coordinatorRegistryCenter() {
		// 定义zookeeper连接信息
		ZookeeperConfiguration zkConfig = new ZookeeperConfiguration("localhost:2181", "elastic-job-example");
		return new ZookeeperRegistryCenter(zkConfig);
	}

	private static LiteJobConfiguration createJobConfiguration(String jobName, int shardingTotalCount, String cron,String shardingItemParameters) {
		// 定义作业核心配置
		JobCoreConfiguration coreConfiguration = JobCoreConfiguration.newBuilder(jobName, cron, shardingTotalCount).shardingItemParameters(shardingItemParameters).build();
		// 定义SIMPLE类型配置
		SimpleJobConfiguration simpleJobConfig = new SimpleJobConfiguration(coreConfiguration, MySimpleJob.class.getCanonicalName());
		// 定义Lite作业根配置
		return LiteJobConfiguration.newBuilder(simpleJobConfig).overwrite(true).build();
	}

	/**
	 * 创建作业监听器(非必须)
	 * 用在作业执行的不同阶段执行特定的操作，如在作业开始执行前或执行完成后进行日志记录，通知或其他操作。
	 * @return
	 */
	private static ElasticJobListener createJobListener() {
		// 分布式锁的监听器，保证在分布式环境中仅执行一次(如3个分片，开始和结束只会在一个节点执行)。
		return new AbstractDistributeOnceElasticJobListener(1000L,1000L) {
			@Override
			public void doBeforeJobExecutedAtLastStarted(ShardingContexts shardingContexts) {
				System.out.println("作业开始执行: " + shardingContexts.getJobName());
			}
			@Override
			public void doAfterJobExecutedAtLastCompleted(ShardingContexts shardingContexts) {
				System.out.println("作业执行完成: " + shardingContexts.getJobName());
			}
		};
	}
}
