package org.example.service;

/**
 * @author: hanchaowei
 * @date 2024/5/12
 * @description:
 */

public interface ILeaderBoardService {


	/**
	 * 添加或更新积分
	 * @param userId
	 * @param score
	 */
	void addOrUpdateUserScore(String userId, double score);

	/**
	 * 获取用户积分
	 * @param userId
	 * @return
	 */
	double getUserScore(String userId);

	/**
	 * 获取指定范围的用户排名
	 * @param topN
	 * @return
	 */
	Iterable<String> getTopUsers(int topN);

	/**
	 *  获取用户排名
	 * @param userId
	 * @return
	 */
	int getUserRank(String userId);




















}
