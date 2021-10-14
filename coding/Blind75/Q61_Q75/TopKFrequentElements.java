package Blind75.Q61_Q75;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * Solution to: 68. https://leetcode.com/problems/top-k-frequent-elements/
 * 
 * Use of PriorityQue and defining custom sorting
 */
public class TopKFrequentElements {
	public int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> frequencies = new HashMap<>();
		for (int num : nums)
			frequencies.put(num, frequencies.getOrDefault(num, 0) + 1);
		PriorityQueue<Map.Entry<Integer, Integer>> sortedFreq = new PriorityQueue<>(
				(a, b) -> Integer.compare(b.getValue(), a.getValue()));
		for (Map.Entry<Integer, Integer> entry : frequencies.entrySet()) {
			sortedFreq.offer(entry);
		}
		int res[] = new int[k];
		for (int i = 0; i < k; i++)
			res[i] = sortedFreq.poll().getKey();

		return res;
	}

	public static void main(String[] args) {
		TopKFrequentElements solution = new TopKFrequentElements();
		int nums[] = { 1, 1, 1, 2, 2, 3 }, k = 2;
		int res[] = solution.topKFrequent(nums, k);
		for (int num : res) {
			System.out.print(num + " ");
		}
	}
}
