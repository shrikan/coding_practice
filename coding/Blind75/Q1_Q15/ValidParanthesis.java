package Blind75.Q1_Q15;

import java.util.HashMap;
import java.util.Stack;

/*
 * Solution to: 7. https://leetcode.com/problems/valid-parentheses/
 */
public class ValidParanthesis {
	public boolean isValid(String s) {
		if (s.length() % 2 != 0)
			return false;
		Stack<Character> parStack = new Stack<>();
		HashMap<Character, Character> parPairs = new HashMap<Character, Character>() {
			{
				put('}', '{');
				put(']', '[');
				put(')', '(');
			}
		};
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (parPairs.containsKey(c)) {
				if (parStack.isEmpty() || !parStack.pop().equals(parPairs.get(c))) {
					return false;
				}
			} else {
				parStack.push(c);
			}
		}
		return parStack.isEmpty();
	}

	public static void main(String[] args) {
		ValidParanthesis solution = new ValidParanthesis();
		System.out.println(solution.isValid("{[()]}"));
	}
}
