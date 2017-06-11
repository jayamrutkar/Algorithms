package dp;

import java.util.Scanner;

public class MaximumSumIncreasingSeq {
	
	static int maxSumIncSequence(int[] arr, int n){
	
		int i, j, max =0;
		
		int[] maxSum = new int[n];
		
		for(i=0;i<n;i++){
			maxSum[i] = arr[i];
		}
		
		for(i=1; i<n; i++){
			for(j=0;j<i;j++){
				if(arr[i]>arr[j] && (maxSum[i]<maxSum[j]+arr[i])){
					maxSum[i] = maxSum[j]+arr[i];
				}
			}
		}

		max = maxSum[0];
		for(i=1; i<n; i++){
			if(max <maxSum[i]){
				max=maxSum[i];
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		System.out.println("How many?");
		int n = in.nextInt();
		
		System.out.println("Enter elements ");
		int[] arr= new int[n];
		for(int i=0;i<n;i++){
			arr[i] = in.nextInt();
		}
		
		System.out.println("Overlapping sub-problems : "+maxSumIncSequence(arr, n));
	}
}
