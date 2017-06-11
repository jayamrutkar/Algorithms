package dp;

import java.util.Scanner;

public class LargestSumContiguousArray {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("How many?");
		int n = in.nextInt();
		
		System.out.println("Enter array");
		int[] arr = new int[n];
		for(int i=0;i<n;i++){
			arr[i] = in.nextInt();
		}
		
		int maxEnding =0, maxSoFar = 0;
		int start=0, end =0 , p =0;
		
		for(int i=0;i<n;i++){
			maxEnding += arr[i];
			
			if(maxSoFar<maxEnding){
				maxSoFar = maxEnding;
				start = p;
				end = i;
			}
			if(maxEnding<0){
				maxEnding= 0;
				p = i+1;
			}
		}
		
		System.out.println("Max value "+maxSoFar);
		System.out.println("And elements are ");
		for(int i=start; i<=end; i++){
			System.out.print(arr[i]+" ");
		}
	}

}
