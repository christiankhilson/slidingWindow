package slidingWindow;

import java.util.HashMap;
import java.util.Map;

/* Given a string, find the length of the longest substring, which has all distinct characters. */

public class NoRepeatSubstring {

	public static void main(String[] args) {
		System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("aabccbb"));
	    System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abcdef"));
	    System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abccde"));
	}

	private static int findLength(String string) {
		int maxLength = 0;
		Map<Character, Integer> charMap = new HashMap<>();
		
		for(int i = 0; i < string.length(); i++) {
			char rightChar = string.charAt(i);
			if(charMap.containsKey(rightChar)) {
				i = charMap.get(rightChar);
				charMap.clear();
			}
			
			charMap.put(rightChar, i + 1);
			maxLength = Math.max(maxLength, charMap.size());
		}
		return maxLength;
	}

}
