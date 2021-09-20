package Facebook.Arrays_Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Solution to: https://leetcode.com/problems/3sum/submissions/
 */
public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		int len = nums.length;
		Arrays.sort(nums);
		for (int i = 0; i < len - 2; i++) {
			if (i != 0 && nums[i - 1] == nums[i])
				continue;
			int j = i + 1, k = len - 1;
			while (j < k) {
				if (j != i + 1 && nums[j - 1] == nums[j]) {
					j++;
					continue;
				}
				if (k != len - 1 && nums[k + 1] == nums[k]) {
					k--;
					continue;
				}
				int sum = nums[i] + nums[j] + nums[k];
				if (sum == 0) {
					result.add(Arrays.asList(nums[i], nums[j], nums[k]));
					j++;
					k--;
				} else if (sum < 0)
					j++;
				else
					k--;
			}

		}
		return result;
	}

	public static void main(String[] args) {
		ThreeSum solution = new ThreeSum();
		int nums[] = { -1, 0, 1, 2, -1, -4 };
		for (List<Integer> sol : solution.threeSum(nums)) {
			for (Integer item : sol) {
				System.out.print(item + " ");
			}
			System.out.println();
		}
	}
}
