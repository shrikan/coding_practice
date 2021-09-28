package Blind75;

/*
 * Solution to: 10. https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class SearchInRotatedArray {
	public int search(int[] nums, int target) {
		return searchUtil(nums, target, 0, nums.length - 1);
	}

	private int searchUtil(int[] nums, int target, int left, int right) {
		if (left > right)
			return -1;
		int mid = (left + right) / 2;
		if (nums[mid] == target)
			return mid;
		if (nums[mid] < target) {
			if (nums[left] <= nums[mid] || target < nums[left]) {
				return searchUtil(nums, target, mid + 1, right);
			} else
				return searchUtil(nums, target, left, mid - 1);
		} else {
			if (nums[mid] <= nums[right] || target > nums[right]) {
				return searchUtil(nums, target, left, mid - 1);
			} else
				return searchUtil(nums, target, mid + 1, right);
		}
	}

	public static void main(String[] args) {
		SearchInRotatedArray solution = new SearchInRotatedArray();
		int nums[] = { 1, 3 }, target = 3;
		System.out.println(solution.search(nums, target));
	}
}
