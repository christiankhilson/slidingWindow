package slidingWindow;

import java.util.HashMap;
import java.util.Map;

/* Given an array containing 0s and 1s, 
 * if you are allowed to replace no more than ‘k’ 0s with 1s, 
 * find the length of the longest contiguous subarray having all 1s. */

public class ReplacingOnes {

	public static void main(String[] args) {
		System.out.println(ReplacingOnes.findLength(new int[] { 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1 }, 2));
	    System.out.println(ReplacingOnes.findLength(new int[] { 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1 }, 3));

	}

	private static int findLength(int[] arr, int k) {
		int left = 0;
		int max = 0;
		Map<Integer, Integer> intMap = new HashMap<>();
		
		for(int right = 0; right < arr.length; right++) {
			int rightInt = arr[right];
			intMap.put(rightInt, intMap.getOrDefault(rightInt, 0) + 1);
			while(intMap.get(0) > k) {
				int leftInt = arr[left];
				left++;
				intMap.put(leftInt, intMap.get(leftInt) - 1);
			}
			max = Math.max(max, right - left + 1);
		}
		return max;
	}
}
