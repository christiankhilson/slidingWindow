package slidingWindow;

import java.util.HashMap;
import java.util.Map;

/* Given a string with lowercase letters only, 
 * if you are allowed to replace no more than k letters with any letter, 
 * find the length of the longest substring having the same letters after replacement. */

public class CharacterReplacement {

	public static void main(String[] args) {
		System.out.println(CharacterReplacement.findLength("aabccbb", 2));
	    System.out.println(CharacterReplacement.findLength("abbcb", 1));
	    System.out.println(CharacterReplacement.findLength("abccde", 1));
	}

	private static int findLength(String string, int k) {
		int left = 0;
		int maxNum = 0;
		int maxLetter = 0;
		Map<Character, Integer> charMap = new HashMap<>();
		
		for(int right = 0; right < string.length(); right++) {
			char rightChar = string.charAt(right);
			charMap.put(rightChar, charMap.getOrDefault(rightChar, 0) + 1);
			maxLetter = Math.max(maxLetter, charMap.get(rightChar));
			
			if(right - left + 1 - maxLetter > k) {
				char leftChar = string.charAt(left);
				charMap.put(leftChar, charMap.get(leftChar) - 1);
				left++;
			}
			
			maxNum = Math.max(maxNum, right - left + 1);
		}
		
		return maxNum;
	}

}
