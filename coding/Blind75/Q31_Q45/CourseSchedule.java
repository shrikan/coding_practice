package Blind75.Q31_Q45;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * Solution to: 45. https://leetcode.com/problems/course-schedule/
 */
public class CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		Map<Integer, Set<Integer>> preReq = new HashMap<>();
		for (int[] row : prerequisites) {
			Set<Integer> values = preReq.getOrDefault(row[1], new HashSet<>());
			values.add(row[0]);
			preReq.put(row[1], values);
		}
		int visited[] = new int[numCourses];
		for(Integer key: preReq.keySet()) {
			if(isCyclic(key, preReq, visited))
				return false;
		}
		return true;
	}

	private boolean isCyclic(int key, Map<Integer, Set<Integer>> preReq, int[] visited) {
		if(visited[key]==2 || !preReq.containsKey(key)) return false;
		if(visited[key] == 1) return true;
		Set<Integer> keys = preReq.get(key);
		visited[key]=1;
		for (Integer k : keys) {
			if (isCyclic(k, preReq, visited))
				return true;
		}
		visited[key] = 2;
		return false;
	}

	public static void main(String[] args) {
		CourseSchedule solution = new CourseSchedule();
		int prereq[][] = { { 1, 0 } }, numCourses = 2;
		System.out.println(solution.canFinish(numCourses, prereq));
	}
}
