package com.rohit.InterviewQuestion;

/**
 * ServiceNow 2nd round
 * @author 2714r
 *
 */
public class FindSumOfRangeOfIndex {
	/**
	 * a[] = {2,5,12,14,20,25} =>500
	 * b[][] = {[1,3], [4,5]}
	 * 
	 * 
	 * 
	 * {2, 7, 19, 33.....}
	 * {..........6 5 3}
	 * 5,12,14 => 17+14= 31
	 */
	
	public static void main(String[] agrs) {
		int a[] = {2,5,12,14,20,25};
		int[][] b = {{1,3}, {3,4}};
		int n = a.length;
		
		int[] prefix = new int[n];
		int[] suffix = new int[n];
		
		prefix[0] = a[0];
		suffix[n-1] = a[n-1];
		int totalSum = a[0];
		for(int i=1; i<n; ++i) {
			prefix[i] = a[i]+prefix[i-1];
			suffix[n-i-1] = a[n-i-1]+suffix[n-i];
			totalSum = totalSum+a[i];
		}
		for(int i=0; i<b.length; ++i) {
			System.out.println("average is: "+getAverage(b[i], a, prefix, suffix, totalSum, n));
		}
		
	}
	
	/**
	 * get the average
	 * @param ind
	 * @param nums
	 * @param prefix
	 * @param suffix
	 * @param totalSum
	 * @return
	 */
	public static float getAverage(int[] ind, int[] nums, int[] prefix, int[] suffix, int totalSum, int n) {
		int s_ind = ind[0];
		int e_ind = ind[1];
		
		int p_sum = 0;
		int s_sum = 0;
		if(s_ind>0) {
			p_sum = prefix[s_ind-1];
		}
		if(e_ind<n-1) {
			s_sum = suffix[e_ind+1];
		}
		
		int t_sum = totalSum-p_sum-s_sum;
		return ((float)t_sum/(e_ind-s_ind+1));
	}

}
