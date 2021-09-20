package selected;

/*
 * Solution to: https://leetcode.com/problems/search-in-rotated-sorted-array/
 * 
 * 1. Check if mid element is the target
 * 2. Check if left part has rotation point( if nums[left] is bigger than nums[mid]
 * 		- if yes, right part is clear, so check if target lies in between mid and right
 *                                      - if no, then search in left part
 *      - if no, then left part is clear, so check if target lies in between left and mid
 *             							- if no, then search in right part
 *             
 * Tip: Iterative method is faster than recursive although both are O(log n)
 */
public class SearchInRotatedArray {
	public int search(int[] nums, int target) {
		System.out.println(searchUtil(nums, 0, nums.length - 1, target));
		return searchUtilItereative(nums, 0, nums.length - 1, target);
	}

	private int searchUtil(int[] nums, int left, int right, int target) {
		if (left > right)
			return -1;
		int mid = (left + right) / 2, ele = nums[mid];
		if (ele == target)
			return mid;
		if (nums[left] <= ele) {
			if (target >= nums[left] && target < ele)
				return searchUtil(nums, left, mid - 1, target);
			else
				return searchUtil(nums, mid + 1, right, target);
		} else {
			if (target > ele && target <= nums[right])
				return searchUtil(nums, mid + 1, right, target);
			else
				return searchUtil(nums, left, mid - 1, target);
		}
	}

	// Faster
	private int searchUtilItereative(int[] nums, int left, int right, int target) {
		int mid = (left + right) / 2;
		while (left <= right) {
			if (nums[mid] == target)
				break;
			if (nums[left] <= nums[mid]) {
				if (target >= nums[left] && target < nums[mid])
					right = mid - 1;
				else
					left = mid + 1;
			} else {
				if (target > nums[mid] && target <= nums[right])
					left = mid + 1;
				else
					right = mid - 1;
			}
			mid = (left + right) / 2;
		}
		if (left > right)
			return -1;
		return mid;
	}

	public static void main(String[] args) {
		SearchInRotatedArray solution = new SearchInRotatedArray();
		int nums[] = { 4, 5, 6, 7, 8, 0, 1, 2 };
		System.out.println(solution.search(nums, 2));
	}
}
