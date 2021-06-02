package selected;

/**
 * Solution to: Permutation of a given string(character array) This solution can
 * be extended to any type of list or array elements
 * 
 * @author shrinidhikanchi
 *
 */
public class PermutationOfString {

	// Backtracking : n! solutions for permutations
	// Time complexity O(n*n!)
	public void permute(char[] str, int l, int r) {
		/*
		 * Typical backtracking approach
		 * Base condition
		 * Iterate over
		 * 		Do something on i
		 * 			Recursive call for next possibility
		 * 		Undo thing on i 
		 */
		// 1. Base condition
		if (l == r) {
			System.out.println(str);
			return;
		}
		// 2. Iterate over
		for (int i = l; i < r; i++) {
			// 3. Do something on i
			str = swap(str, l, i);
			// 4. Recursive call
			permute(str, l + 1, r);
			// 5. Undo on i
			str = swap(str, l, i);
		}
	}

	private char[] swap(char[] str, int l, int i) {
		char temp = str[l];
		str[l] = str[i];
		str[i] = temp;
		return str;
	}

	public static void main(String[] args) {
		char[] str = "HELP".toCharArray();
		PermutationOfString solution = new PermutationOfString();

		solution.permute(str, 0, str.length);
	}
}
