package selected;

import java.util.HashMap;
import java.util.Stack;

/**
 * Solution to: https://leetcode.com/problems/valid-parentheses/submissions/
 * 
 * @author shrinidhikanchi
 *
 */
public class ValidParanthesis {
	// Time complexity O(n)
	public boolean isValid(String s) {
		if (s.length() % 2 != 0)
			return false;
		Stack<Character> paranthesisStack = new Stack<Character>();
		HashMap<Character, Character> match = new HashMap<Character, Character>();
		match.put(')', '(');
		match.put('}', '{');
		match.put(']', '[');

		for (int i = 0; i < s.length(); i++) {
			if (match.containsKey(s.charAt(i))) {
				if (paranthesisStack.isEmpty() || paranthesisStack.pop() != match.get(s.charAt(i)))
					return false;
			} else {
				paranthesisStack.push(s.charAt(i));
			}
		}
		return paranthesisStack.empty();
	}

	public static void main(String[] args) {
		ValidParanthesis solution = new ValidParanthesis();
		System.out.println(solution.isValid("()"));
	}
}
