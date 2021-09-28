package Blind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Solution to: 11. https://leetcode.com/problems/combination-sum/
 */
public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(candidates);
		combinationSumUtil(candidates, target, 0, new ArrayList<Integer>(), result);
		return result;
	}

	private void combinationSumUtil(int[] candidates, int target, int i, ArrayList<Integer> temp,
			List<List<Integer>> result) {
		if (target == 0) {
			result.add(new ArrayList<>(temp));
			return;
		}
		if (i == candidates.length || candidates[i] > target)
			return;
		temp.add(candidates[i]);
		combinationSumUtil(candidates, target - candidates[i], i, temp, result);
		temp.remove(temp.size() - 1);
		if(i < candidates.length-1 && candidates[i+1] <= target)
			combinationSumUtil(candidates, target, i + 1, temp, result);
	}

	public static void main(String[] args) {
		CombinationSum solution = new CombinationSum();
		int cands[] = { 2, 3, 6, 7 }, target = 7;
		List<List<Integer>> res = solution.combinationSum(cands, target);

		for (List<Integer> row : res) {
			for (Integer ele : row) {
				System.out.print(ele + " ");
			}
			System.out.println();
		}
	}
}
