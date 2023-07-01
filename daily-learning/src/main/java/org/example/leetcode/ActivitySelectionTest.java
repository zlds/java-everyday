package org.example.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: hanchaowei
 * @date 2023/7/1
 * @description: 活动选择问题(贪心算法，每次选择结束时间最早的活动)
 */

public class ActivitySelectionTest {



	public static void printMaxActivities(Activity arr[]) {
		// 按照结束时间排序(升序)
		Arrays.sort(arr, new Comparator<Activity>() {
			@Override
			public int compare(Activity o1, Activity o2) {
				return o1.finish - o2.finish;
			}
		});
		System.out.println("活动选择为：");

		// 第一个活动总是被选中
		int i = 0;
		System.out.println(arr[i].toString() + " ");

		for (int j = 1; j < arr.length; j++) {
			// 如果下一个活动的开始时间大于等于上一个活动的结束时间进行打印
			if (arr[j].start >= arr[i].finish) {
				System.out.println(arr[j].toString() + " ");
				// 更新上次活动时间
				i = j;
			}
		}
	}

	public static void main(String[] args) {
		Activity arr[] = {new Activity(5,9), new Activity(1, 2),
				new Activity(3, 4), new Activity(0, 6),
				new Activity(5, 7), new Activity(8, 9)};

		printMaxActivities(arr);
	}


	/**
	 * 活动类
	 */
	public static class Activity {
		// 开始时间
		int start;
		// 结束时间
		int finish;

		public Activity(int start,int finish) {
			this.start = start;
			this.finish = finish;
		}

		@Override
		public String toString() {
			return "(" + start + "," + finish + ")";
		}
	}
}
