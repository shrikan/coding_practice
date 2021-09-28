package Blind75.Q1_Q15;

/*
 * Solution to: 3. https://leetcode.com/problems/longest-palindromic-substring/
 */
public class PalindromicSubstring {
	public String longestPalindrome(String s) {
		char chars[] = s.toCharArray();
		int len = chars.length, longest = 0, start = 0, end = 0;
		;
		for (int i = 0; i < len; i++) {
			if(longest > 2*(len-i)-1) {
				break;
			}
			int palLen = getPal(i, chars);
			if (palLen > longest) {

				if (palLen % 2 == 0) {
					start = i - ((palLen / 2) - 1);
					end = i + (palLen / 2);
				} else {
					start = i - (palLen / 2);
					end = i + (palLen / 2);
				}
				longest = palLen;
			}
		}
		return s.substring(start, end+1);
	}

	private int getPal(int i, char[] chars) {
		int longest1 = 1, longest2 = 0, j = i - 1, k = i + 1, len = chars.length;
		while (j >= 0 && k < len && chars[j] == chars[k]) {
			j--;
			k++;
			longest1 += 2;
		}
		j = i;
		k = i + 1;
		while (j >= 0 && k < len && chars[j] == chars[k]) {
			j--;
			k++;
			longest2 += 2;
		}
		return (longest1 > longest2) ? longest1 : longest2;
	}

	public static void main(String[] args) {
		PalindromicSubstring solution = new PalindromicSubstring();
		System.out.println(solution.longestPalindrome("babad"));
	}
}
