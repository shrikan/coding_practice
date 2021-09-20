package Facebook.Arrays_Strings;

/*
 * Solution to: https://leetcode.com/problems/next-permutation/
 * 
 * First, find the first index non increasing index from the last.
 * Then, find the first index from last which is larger than former index
 * Swap these two numbers and reverse the increasing sequence traversed earlier.
 */
public class NextPermutation {
	// Time complexity: O(n) and Space complexity: O(1)
	public void nextPermutation(int[] nums) {
		int left, right, last = nums.length - 1;
		left = right = last;
		while (left > 0 && nums[--left] >= nums[left + 1]) {
			left--;
		}
		if (left >= 0) {
			while (nums[left] >= nums[right]) {
				right--;
			}
			swap(nums, left++, right);
		} else {
			left = 0;
		}
		while (left < last) {
			swap(nums, left++, last--);
		}
	}

	private void swap(int[] nums, int left, int right) {
		int temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;
	}

	public static void main(String[] args) {
		NextPermutation solution = new NextPermutation();
		int[] nums = { 1, 5, 1 }; // 2,3,1 -> 3, 1, 2
		solution.nextPermutation(nums);
		for (int num : nums) {
			System.out.print(num + " ");
		}
	}
}
