package Blind75.Q46_Q60;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * Solution to: 50. https://leetcode.com/problems/contains-duplicate/
 * 
 * Two approaches. Both are equally efficient on the trade off.
 */
public class ContainsDuplicate {
	// Time complexity: O(nlogn) Space complexity: O(1)
	public boolean containsDuplicate(int[] nums) {
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == nums[i + 1]) {
				return true;
			}
		}
		return false;
	}

	// Time complexity: O(n) Space complexity: O(n)
	public boolean containsDuplicate1(int[] nums) {
		Set<Integer> result = new HashSet<>();
		for (int num : nums) {
			if (!result.add(num))
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		ContainsDuplicate solution = new ContainsDuplicate();
		int nums[] = { 1, 2, 3, 1 };
		System.out.println(solution.containsDuplicate(nums));
	}
}
