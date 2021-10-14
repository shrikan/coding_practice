package Blind75.Q46_Q60;

/*
 * Solution to: 55. https://leetcode.com/problems/product-of-array-except-self/
 */
public class ProductOfAnArrayExceptItself {
	// Time complexity : O(n), space complexity: O(1)
	public int[] productExceptSelf(int[] nums) {
		int res[] = new int[nums.length], prev = 1;

		for (int i = 0; i < nums.length; i++) {
			res[i] = prev;
			prev *= nums[i];
		}
		prev = 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			res[i] *= prev;
			prev *= nums[i];
		}
		return res;
	}

	public static void main(String[] args) {
		ProductOfAnArrayExceptItself solution = new ProductOfAnArrayExceptItself();
		int nums[] = { 1, 2, 3, 4 };
		int res[] = solution.productExceptSelf(nums);
		for (int ele : res)
			System.out.print(ele + " ");
	}
}
