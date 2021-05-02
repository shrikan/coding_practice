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
		if (l == r) {
			System.out.println(str);
			return;
		}
		for (int i = l; i < r; i++) {
			str = swap(str, l, i);
			permute(str, l + 1, r);
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
