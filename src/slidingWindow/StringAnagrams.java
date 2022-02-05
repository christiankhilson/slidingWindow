package slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringAnagrams {

	public static void main(String[] args) {
		System.out.println(StringAnagrams.findStringAnagrams("ppqp", "pq"));
	    System.out.println(StringAnagrams.findStringAnagrams("abbcabc", "abc"));
	}

	private static List<Integer> findStringAnagrams(String str, String pattern) {
		List<Integer> resultIndices = new ArrayList<>();
		
		Map<Character, Integer> patMap = new HashMap<>();
		for(int i = 0; i < pattern.length(); i++) {
			char patternChar = pattern.charAt(i);
			patMap.put(patternChar, patMap.getOrDefault(patternChar, 0) + 1);
		}
		
		Map<Character, Integer> charMap = new HashMap<>();
		int left = 0;
		
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
				resultIndices.add(left);
			}
			
		}
		return resultIndices;
	}

}
