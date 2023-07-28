package org.example.datastructure;


/**
 * @author: hanchaowei
 * @date 2023/7/28
 * @description:
 */

public class Task implements Comparable<Task> {
	private String description;
	private int priority;

	public Task(String description, int priority) {
		this.description = description;
		this.priority = priority;
	}

	public String getDescription() {
		return description;
	}

	public int getPriority() {
		return priority;
	}

	@Override
	public int compareTo(Task other) {
		// 优先级小的排在起前面
		return Integer.compare(priority, other.getPriority());
	}

	@Override
	public String toString() {
		return "Task{" + "description='" + description + '\'' + ", priority=" + priority + '}';
	}
}
