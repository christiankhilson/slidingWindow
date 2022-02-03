package slidingWindow;

/* Given an array of positive numbers and a positive number ‘S,’ find the length of the smallest contiguous 
 * subarray whose sum is greater than or equal to ‘S’. Return 0 if no such subarray exists. */

public class MinSizeSubArraySum {

	  public static void main(String[] args) {
		    int result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
		    System.out.println("Smallest subarray length: " + result);
		    result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 8 });
		    System.out.println("Smallest subarray length: " + result);
		    result = MinSizeSubArraySum.findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 });
		    System.out.println("Smallest subarray length: " + result);
	  }

	private static int findMinSubArray(int s, int[] arr) {
		int min = Integer.MAX_VALUE;
		int left = 0;
		int total = 0;
		
		for(int right = 0; right < arr.length; right++) {
			total += arr[right];
			while(total >= s) {
				min = Math.min(min, right - left + 1);
				total -= arr[left];
				left++;
			}
		}
		return (min == Integer.MAX_VALUE) ? 0 : min;
	}

}
