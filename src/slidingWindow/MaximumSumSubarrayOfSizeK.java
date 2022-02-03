package slidingWindow;

/* Given an array of positive numbers and a positive number ‘k,’ find the maximum sum of any contiguous subarray of size ‘k’. */

public class MaximumSumSubarrayOfSizeK {

	public static void main(String[] args) {
	    System.out.println("Maximum sum of a subarray of size K: "
	            + MaximumSumSubarrayOfSizeK.findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 }));
	    System.out.println("Maximum sum of a subarray of size K: "
	            + MaximumSumSubarrayOfSizeK.findMaxSumSubArray(2, new int[] { 2, 3, 4, 1, 5 }));

	}
	
	public static int findMaxSumSubArray(int k, int[] arr) {
		int max = 0;
		int windowSum = 0;
		int windowStart = 0;
		
		for(int i = 0; i < arr.length; i++) {
			windowSum += arr[i];
			if(i > k - 1) {
				windowSum -= arr[windowStart];
				windowStart++;
				max = Math.max(windowSum, max);
			}
		}
		
		return max;
	}

}
