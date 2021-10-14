package Blind75.Q31_Q45;

import java.util.Arrays;
import java.util.List;

/*
 * Solution to: 35. https://leetcode.com/problems/word-break/
 * 
 * Dynamic programming with overlapping calculations.
 * Solved through book keeping method.
 */
public class WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {
		boolean possible[] = new boolean[s.length()];
        int len = s.length();
		
		for(int i=len-1;i>=0;i--) {
			for(String word:wordDict) {
                int wordLen = word.length();
                if(i+wordLen <=len){
				    int j=i, k=0;
				    while(k<wordLen && j<len && word.charAt(k)==s.charAt(j)) {
					    k++;
					    j++;
				    }
				    if(k==wordLen && (j==len || possible[j]==true)) {
						    possible[i] = true;
				    }
                }
			}
		}
		return possible[0];
	}


	public static void main(String[] args) {
		WordBreak solution = new WordBreak();
		String s = "babba";
		List<String> dict = Arrays.asList("a","bbb","bbbb");
		System.out.println(solution.wordBreak(s, dict));
	}
}