package org.example.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author: hanchaowei
 * @date 2024/5/5
 * @description: 自动保存编辑器
 */

public class AutoSaveEditor {
	// 文件是否被修改过
	boolean changed = false;
	// 定时任务线程池
	ScheduledExecutorService ses =
			Executors.newSingleThreadScheduledExecutor();

	// 定时保存
	void startAutoSave() {
		ses.scheduleWithFixedDelay(() -> {
			autoSave();}, 5, 5, TimeUnit.SECONDS);
	}
	// 自动存盘操作
	void autoSave() {
		synchronized (this) {
			if (!changed) {
				return;
			}
			changed = false;
		}

		// 执行存盘操作
		System.out.println("auto save");
	}
	// 编辑
	void edit() {
		// 省略编辑
		change();
	}

	// 改变状态。基于Balking设计模式。
	void change() {
		synchronized (this) {
			changed = true;
		}
	}

	public static void main(String[] args) {
		AutoSaveEditor autoSaveEditor = new AutoSaveEditor();
		autoSaveEditor.startAutoSave();
		autoSaveEditor.edit();
	}

}
