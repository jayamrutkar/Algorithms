package dp;

import java.util.Scanner;

public class LongestIncreasingSeq {
	
	static int maxRef = 1;
	
	static int findLIS(int[] arr, int n){
		maxRef = 1;
		
		_lis(arr, n);
		
		return maxRef;
	}
	
	
	private static int _lis(int[] arr, int n) {

		if(n==1){
			return 1;
		}
		
		int maxEnd = 1, res;
		
		for(int i=1;i<n;i++){
			res = _lis(arr, i);
			if(arr[i-1]<arr[n-1] && (res+1)>maxEnd){
				maxEnd = res+1;
			}
		}
		
		if(maxRef<maxEnd){
			maxRef = maxEnd;
		}
		
		return maxEnd;
	}

	
	static int lisOverlapping(int[] arr, int n){
		
		int[] lis = new int[n];
		for(int i=0;i<n;i++){
			lis[i] = 1;
		}
		
		for(int i=0;i<n;i++){
			for(int j=0;j<i;j++){
				if(arr[i]>arr[j] && lis[i]<lis[j]+1){
					lis[i] = lis[j]+1;
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		for(int i=0;i<n;i++){
			if(max<lis[i]){
				max = lis[i];
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
		
		findLIS(arr, n);
		System.out.println("Using Optimal Substructure property, LIS of sequence is "+maxRef);
		
		System.out.println("Adding overlapping solution, LIS of sequence is "+lisOverlapping(arr, n));
		in.close();
	}

}
