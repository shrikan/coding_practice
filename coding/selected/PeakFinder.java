package selected;

/**
 * Solution to: https://leetcode.com/problems/find-peak-element/
 * 
 * @author shrinidhikanchi
 *
 */
public class PeakFinder {
	// Time complexity: O(log n)
	private int findPeak(int[] arr, int l, int r) {
		// Make sure l and r wont cross each other and run into infinite loop
		if (l <= r && l >= 0 && r <= arr.length - 1) {
			int mid = (l + r) / 2;
			// Remember short circuit. In 'OR' if first one becomes true, it wont check for
			// second condition
			// If mid is 0th, left need not be checked : assumed to be true
			// If mid is nth, right need not be checked : assumed to be true
			if ((mid == 0 || arr[mid - 1] <= arr[mid]) && (mid == arr.length - 1 || arr[mid + 1] < arr[mid])) {
				return mid;
			}
			if (arr[mid + 1] >= arr[mid]) {
				return findPeak(arr, mid + 1, r);
			}
			return findPeak(arr, l, mid - 1);
		}
		return -1;
	}

	public static void main(String[] args) {
		PeakFinder solution = new PeakFinder();
		// Try any input here
		int[] arr = { 123 };
		System.out.println(solution.findPeak(arr, 0, arr.length - 1));
	}

}
