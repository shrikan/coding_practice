package Blind75.Q31_Q45;

/*
 * Solution to: 39. https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class MinimumInRotatedArray {
	public int findMin(int[] nums) {
		if (nums.length == 1)
			return nums[0];
		return findMinUtil(nums, 0, nums.length - 1);
	}

	private int findMinUtil(int nums[], int left, int right) {
		if (left == right) {
			return nums[left];
		}
		int mid = (left + right) / 2;
		if (mid > 0 && nums[mid - 1] > nums[mid])
			return nums[mid];
		if (nums[left] <= nums[mid] && nums[mid] <= nums[right]) {
			return nums[left];
		}
		if (nums[left] <= nums[mid]) {
			return findMinUtil(nums, mid + 1, right);
		}
		return findMinUtil(nums, left, mid - 1);
	}

	public static void main(String[] args) {
		MinimumInRotatedArray solution = new MinimumInRotatedArray();
		int nums[] = { 11, 13, 15, 17, 10 };
		System.out.println(solution.findMin(nums));
	}
}
