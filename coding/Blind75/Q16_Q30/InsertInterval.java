package Blind75.Q16_Q30;

/*
 * Solution to: 18. https://leetcode.com/problems/insert-interval/
 * 
 * Identify the point of insertion and end of insertion.
 * Include all elements before start, new range from start to end, and elements after end.
 */
public class InsertInterval {
	public int[][] insert(int[][] intervals, int[] newInterval) {
		int i = 0, start = newInterval[0], end = newInterval[1], firstHalf = 0;

		while (i < intervals.length) {
			if (intervals[i][1] >= start) {
				if (intervals[i][0] < start)
					start = intervals[i][0];
				while (i < intervals.length && intervals[i][0] <= end) {
					if (intervals[i][1] > end)
						end = intervals[i][1];
					i++;
				}

				break;
			}
			i++;
			firstHalf++;
		}

		int res[][] = new int[firstHalf + (intervals.length - i) + 1][2], j = 0;
		for (; j < firstHalf; j++) {
			res[j] = intervals[j];
		}
		res[j][0] = start;
		res[j++][1] = end;
		for (; i < intervals.length; i++) {
			res[j++] = intervals[i];
		}
		return res;
	}

	public static void main(String[] args) {
		InsertInterval solution = new InsertInterval();
		int interavls[][] = { { 1, 5 } }, newInterval[] = { 0, 3 };
		interavls = solution.insert(interavls, newInterval);
		for (int row[] : interavls) {
			System.out.println(row[0] + " " + row[1]);
		}
	}
}
