package Blind75.Q16_Q30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * Solution to: 17. https://leetcode.com/problems/merge-intervals/
 * 
 * Sort the arrays based on first value, then merge them linearly based on the value
 */
public class MergeIntervals {
	// Time complexity: O(n logn)
	public int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0])
					return Integer.compare(o1[1], o2[1]);
				return Integer.compare(o1[0], o2[0]);
			}
		});
		List<List<Integer>> resList = new ArrayList<>();
		int listIndex = 0;
		while (listIndex < intervals.length) {
			int start = intervals[listIndex][0], end = intervals[listIndex][1];
			listIndex++;
			while (listIndex < intervals.length && end >= intervals[listIndex][0]) {
				if (end < intervals[listIndex][1])
					end = intervals[listIndex][1];
				listIndex++;
			}
			List<Integer> temp = new ArrayList<Integer>();
			temp.add(start);
			temp.add(end);
			resList.add(temp);
		}

		int res[][] = new int[resList.size()][2], i = 0;
		for (List<Integer> row : resList) {
			res[i][0] = row.get(0);
			res[i++][1] = row.get(1);
		}
		return res;
	}

	public static void main(String[] args) {
		MergeIntervals solution = new MergeIntervals();
//		int intervals[][] = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
		int intervals[][] = { { 1, 4 }, { 2, 3 } };
		intervals = solution.merge(intervals);
		for (int[] row : intervals) {
			for (int ele : row) {
				System.out.print(ele + " ");
			}
			System.out.println();
		}
	}
}
