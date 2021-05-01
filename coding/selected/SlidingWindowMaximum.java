package selected;

import java.util.ArrayDeque;

/**
 * Solution to:
 * https://leetcode.com/problems/sliding-window-maximum/description/
 * 
 * @author shrinidhikanchi
 *
 */
public class SlidingWindowMaximum {
	// Time Complexity : O(n*k)
	public int[] maxSlidingWindowBruteforce(int[] nums, int k) {

		int[] res = new int[nums.length - k + 1];

		// Iterate through array while checking for max in the range k
		for (int i = 0; i < nums.length - k + 1; i++) {
			res[i] = maxOfAnArray(i, i + k, nums);
		}

		return res;
	}

	public int maxOfAnArray(int l, int r, int[] arr) {
		int maxElement = Integer.MIN_VALUE;
		for (; l < r; l++) {
			if (arr[l] > maxElement) {
				maxElement = arr[l];
			}
		}
		return maxElement;
	}

	// Using ArrayDeque
	// Time Complexity : O(n), Auxiliary Space complexity : O(k)
	public int[] maxSlidingWindow(int[] nums, int k) {
		int n = nums.length;
		ArrayDeque<Integer> indexDeque = new ArrayDeque<Integer>();
		int[] resultArray = new int[n - k + 1];
		int resultCounter = 0;

		for (int i = 0; i < n; i++) {
			// Remove items smaller than current element from Deque
			while (!indexDeque.isEmpty() && nums[indexDeque.peekLast()] < nums[i]) {
				indexDeque.removeLast();
			}

			indexDeque.addLast(i);
			// At the end of window, first element is highest in that window
			if (i >= k - 1) {
				int largestIndex = indexDeque.peekFirst();
				resultArray[resultCounter++] = nums[largestIndex];
				if (i - largestIndex == k - 1) {
					indexDeque.removeFirst();
				}
			}
		}
		return resultArray;
	}

	public static void main(String[] args) {
		SlidingWindowMaximum s = new SlidingWindowMaximum();
		int[] nums = { 1, 3, -2, 5, 8, 9 };
		int k = 3;
		int[] sol1 = s.maxSlidingWindowBruteforce(nums, k);
		for (int val : sol1) {
			System.out.print(val + " ");
		}
		System.out.println();

		int[] sol = s.maxSlidingWindow(nums, k);
		for (int val : sol) {
			System.out.print(val + " ");
		}
	}
}
