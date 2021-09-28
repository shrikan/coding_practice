package Blind75.Q1_Q15;

/*
 * Solution to: 4. https://leetcode.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		int left = 0, right = height.length - 1, maxWater = 0;
		while (left < right) {
			int temp;
			if (height[left] < height[right]) {
				temp = height[left];
				left++;
			} else {
				temp = height[right];
				right--;
			}
			if (temp * (right - left + 1) > maxWater) {
				maxWater = temp * (right - left + 1);
			}
		}
		return maxWater;
	}

	public static void main(String[] args) {
		ContainerWithMostWater solution = new ContainerWithMostWater();
		int height[] = { 1, 2, 1 };
		System.out.println(solution.maxArea(height));
	}
}
