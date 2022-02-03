package slidingWindow;

/* Given a string, find the length of the longest substring in it with no more than K distinct characters. */

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {

	public static void main(String[] args) {
	    System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 2));
	    System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 1));
	    System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("cbbebi", 3));
	}

	private static int findLength(String str, int k) {
		Map<Character, Integer> charMap = new HashMap<>();
		int maxSize = 0;
		int left = 0;
		for(int right = 0; right < str.length(); right++) {
			char rightChar = str.charAt(right);
			charMap.put(rightChar, charMap.getOrDefault(rightChar, 0) + 1);
			while(charMap.size() > k) {
				char leftChar = str.charAt(left);
				left++;
				charMap.put(leftChar, charMap.get(leftChar) - 1);
				if(charMap.get(leftChar) == 0) {
					charMap.remove(leftChar);
				}
			}
			maxSize = Math.max(maxSize, right - left + 1);
		}
		return maxSize;
	}

}
