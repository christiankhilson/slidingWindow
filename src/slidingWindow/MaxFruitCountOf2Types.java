package slidingWindow;

import java.util.HashMap;
import java.util.Map;

/* Given an array of characters where each character represents a fruit tree, 
 * you are given two baskets, and your goal is to put maximum number of fruits in each basket.
 * The only restriction is that each basket can have only one type of fruit. */

public class MaxFruitCountOf2Types {

	public static void main(String[] args) {
    System.out.println("Maximum number of fruits: " + 
                          MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'A', 'C' }));
    System.out.println("Maximum number of fruits: " + 
                          MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));
  }

	private static int findLength(char[] cs) {
		int maxLength = 0;
		int left = 0;
		Map<Character, Integer> charMap = new HashMap<>();
		
		for(int right = 0; right < cs.length; right++) {
			char rightChar = cs[right];
			charMap.put(rightChar, charMap.getOrDefault(rightChar, 0) + 1);
			while(charMap.size() > 2) {
				char leftChar = cs[left];
				left++;
				charMap.put(leftChar, charMap.get(leftChar) - 1);
				if(charMap.get(leftChar) == 0) {
					charMap.remove(leftChar);
				}
			}
			maxLength = Math.max(maxLength, right - left + 1);
		}
		
		return maxLength;
	}

}
