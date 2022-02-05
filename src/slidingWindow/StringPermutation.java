package slidingWindow;

/* Given a string and a pattern, find out if the string contains any permutation of the pattern. */

import java.util.*;

public class StringPermutation {

	public static void main(String[] args) {
		System.out.println("Permutation exist: " + StringPermutation.findPermutation("oidbcaf", "abc"));
	    System.out.println("Permutation exist: " + StringPermutation.findPermutation("odicf", "dc"));
	    System.out.println("Permutation exist: " + StringPermutation.findPermutation("bcdxabcdy", "bcdyabcdx"));
	    System.out.println("Permutation exist: " + StringPermutation.findPermutation("aaacb", "abc"));
	}

	private static boolean findPermutation(String str, String pattern) {
		
		Map<Character, Integer> patMap = new HashMap<>();
		for(int i = 0; i < pattern.length(); i++) {
			char patternChar = pattern.charAt(i);
			patMap.put(patternChar, patMap.getOrDefault(patternChar, 0) + 1);
		}
		
		int left = 0;
		Map<Character, Integer> charMap = new HashMap<>();		
		
		for(int right = 0; right < str.length(); right++) {
			char rightChar = str.charAt(right);
			charMap.put(rightChar, charMap.getOrDefault(rightChar, 0) + 1);
			if(right - left + 1 > pattern.length()) {
				char leftChar = str.charAt(left);
				left++;
				charMap.put(leftChar, charMap.get(leftChar) - 1);
				if(charMap.get(leftChar) == 0) {
					charMap.remove(leftChar);
				}
			}
			
			if(charMap.equals(patMap)) {
				return true;
			}
		}
		
		return false;
	}

}
