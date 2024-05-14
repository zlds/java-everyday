package org.example.service;

import org.redisson.api.RScoredSortedSet;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

/**
 * @author: hanchaowei
 * @date 2024/5/12
 * @description:
 */
@Service
public class ILeaderBoardServiceImpl implements ILeaderBoardService {

	private static final String KEY = "userScores";

	@Autowired
	private RedissonClient redissonClient;

	@Override
	public void addOrUpdateUserScore(String userId, double score) {
		RScoredSortedSet<String> scoredSortedSet = redissonClient.getScoredSortedSet(KEY);
		scoredSortedSet.add(score, userId);
	}

	@Override
	public double getUserScore(String userId) {
		return 0;
	}

	@Override
	public Iterable<String> getTopUsers(int topN) {
		RScoredSortedSet<String> scoredSortedSet = redissonClient.getScoredSortedSet(KEY);

		return scoredSortedSet.entryRangeReversed(0, topN - 1)
				.stream().map(entry -> entry.getValue() + "has score:" + entry.getScore())
				.collect(Collectors.toList());
	}

	@Override
	public int getUserRank(String userId) {
		RScoredSortedSet<String> scoredSortedSet = redissonClient.getScoredSortedSet(KEY);
		// 从0开始
		return scoredSortedSet.revRank(userId) + 1;
	}

}
