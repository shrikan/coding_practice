package Facebook.Arrays_Strings;

/*
 * Solution to: https://leetcode.com/problems/product-of-array-except-self/
 * 
 * In the first pass, compute product till previous element and store it
 * In the second pass, compute product till current from last and multiply it to current
 */
public class ProductOfArrayExceptSelf {
	// Time complexity: O(n), space complexity: O(1)
	public int[] productExceptSelf(int[] nums) {
		int len = nums.length, res[] = new int[len], prod = 1;

		for (int i = 0; i < len; i++) {
			res[i] = prod;
			prod *= nums[i];
		}
		prod = 1;
		for (int i = len - 1; i >= 0; i--) {
			res[i] *= prod;
			prod *= nums[i];
		}
		return res;
	}

	public static void main(String[] args) {
		ProductOfArrayExceptSelf solution = new ProductOfArrayExceptSelf();
		int nums[] = { 1, 2, 3, 4 };

		for (int num : solution.productExceptSelf(nums)) {
			System.out.print(num + " ");
		}
	}
}
