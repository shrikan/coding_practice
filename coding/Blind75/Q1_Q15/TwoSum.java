package Blind75.Q1_Q15;

import java.util.HashMap;

/*
 * Solution to: 1. https://leetcode.com/problems/two-sum/ 
 */
public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> pairs = new HashMap<>();
		int res[] = new int[2];
		for (int i = 0; i < nums.length; i++) {
			if (pairs.containsKey(target - nums[i])) {
				res[0] = pairs.get(target - nums[i]);
				res[1] = i;
				break;
			}
			pairs.put(nums[i], i);
		}
		return res;
	}

	public static void main(String[] args) {
		TwoSum solution = new TwoSum();
		int nums[] = { 3, 2, 4 }, target = 6;
		int[] res = solution.twoSum(nums, target);
		for (int ele : res) {
			System.out.println(ele);
		}
	}
}
