package org.example.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author: hanchaowei
 * @date 2023/7/21
 * @description:
 */

public class RecursionFindTest {


	/**
	 * 假设,A推荐了B，B推荐了C，B的最终推荐人是A，C的最终推荐人也是A。需求是给定有个用户，找到这个用户的最终推荐人。
	 */




	//  假数据
	private static Map<Long, Long> referrals = new HashMap<>();

	static {
		// A 推荐了B
		referrals.put(1L,2L);
		// B 推荐了C
		referrals.put(2L, 3L);
		// C 没有推荐人
		referrals.put(3L,null);
		// 模拟死循环
//		referrals.put(3L,1L);
	}


	/**
	 * 查找最终推荐人
	 * @param actorId
	 * @return
	 */
	public Long getRootReferrerId(Long actorId) {
		HashSet<Long> visited = new HashSet<>();
		return findRootReferrerId(actorId, visited);
	}


	/**
	 * 递归查找最终推荐人。HashSet是为了数据问题导致无限循环。
	 * @param actorId
	 * @param visited
	 * @return
	 */
	private Long findRootReferrerId(Long actorId, HashSet<Long> visited) {
		if (visited.contains(actorId)) {
			throw new RuntimeException("检查到了死循环 for actorId " + actorId);
		}

		visited.add(actorId);

		Long referrerId = referrals.get(actorId);
		if (referrerId == null) {
			return actorId;
		}
		return findRootReferrerId(referrerId, visited);
	}

	public static void main(String[] args) {
		RecursionFindTest recursionFindTest = new RecursionFindTest();

		System.out.println(recursionFindTest.getRootReferrerId(1L));
		System.out.println(recursionFindTest.getRootReferrerId(2L));
		System.out.println(recursionFindTest.getRootReferrerId(3L));
	}


}
