package Blind75.Q31_Q45;

public class MaxProductSubArray {
	public int maxProduct(int[] nums) {
		int result = Integer.MIN_VALUE;
		int min = 1, max = 1;
		for (int num : nums) {
			int temp = num * max;
			max = Math.max(temp, num * min);
			min = Math.min(temp, num * min);

			max = (num > max) ? num : max;
			min = (num < min) ? num : min;

			if (result < max)
				result = max;
		}
		return result;
	}

	public static void main(String[] args) {
		MaxProductSubArray solution = new MaxProductSubArray();
		int nums[] = {-4, -3, -2};
		System.out.println(solution.maxProduct(nums));
	}
}
