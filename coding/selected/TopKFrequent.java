package selected;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Solution to: https://leetcode.com/problems/top-k-frequent-elements/
 * 
 * @author shrinidhikanchi
 *
 */
public class TopKFrequent {
	// Time complexity: O(klog(m)), where m is number of unique elements in nums
	public int[] topKFrequent(int[] nums, int k) {
		int[] result = new int[k];
		Map<Integer, Integer> pairs = new HashMap<Integer, Integer>();

		for (int num : nums) {
			pairs.put(num, pairs.getOrDefault(num, 0) + 1);
		}

		// Priority que defined with sorting to happen based on value
		PriorityQueue<Map.Entry<Integer, Integer>> pQue = new PriorityQueue<>(
				(a, b) -> Integer.compare(b.getValue(), a.getValue()));

		for (Map.Entry<Integer, Integer> pair : pairs.entrySet()) {
			pQue.offer(pair);
		}

		for (int i = 0; i < k; i++) {
			result[i] = pQue.poll().getKey();
		}

		return result;
	}

	public static void main(String[] args) {
		TopKFrequent solution = new TopKFrequent();
		int[] nums = { 1, 1, 1, 2, 2, 3 };
		for (int ele : solution.topKFrequent(nums, 2)) {
			System.out.print(ele + " ");
		}
	}
}
