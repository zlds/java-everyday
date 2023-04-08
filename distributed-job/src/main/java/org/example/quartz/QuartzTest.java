package org.example.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;


/**
 * @author: hanchaowei
 * @date 2023/4/7
 * @description:
 */

public class QuartzTest {

	/**
	 * 创建任务调度器
	 * @return
	 */
	public static Scheduler createScheduler() {
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		try {
			return schedulerFactory.getScheduler();
		} catch (SchedulerException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 创建任务
	 * @return
	 */
	public static JobDetail createJob() {
		JobBuilder jobBuilder = JobBuilder.newJob(MyJob.class);
		jobBuilder.withIdentity("job1", "group1");
		return jobBuilder.build();
	};

	/**
	 * 定时任务时间触发器
	 */
	public static Trigger createTrigger() {
		/**
		 * 每2秒执行一次
		 * 1、秒 0~59
		 * 2、分 0~59
		 * 3、小时 0~23
		 * 4、天 1~31
		 * 5、月 1~11
		 * 6、周 1~7  1=星期日
		 * 7、年（可选） 1970~2099
		 * 补充: SimpleTrigger 简单触发器，如每xx秒执行一次
		 */
		CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("*/2 * * * * ?");
		TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
		triggerBuilder.withIdentity("trigger1", "group1");
		triggerBuilder.startNow()
				.withSchedule(cronScheduleBuilder);
		return triggerBuilder.build();
	}



	public static void main(String[] args) {
		Scheduler scheduler = createScheduler();
		JobDetail job = createJob();
		Trigger trigger = createTrigger();
		try {
			// 关联任务和时间触发器
			scheduler.scheduleJob(job, trigger);
			// 启动任务
			scheduler.start();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

}
