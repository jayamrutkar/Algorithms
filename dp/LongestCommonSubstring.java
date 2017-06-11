package dp;

import java.util.Scanner;

public class LongestCommonSubstring {

	static int max(int a, int b){
		if(a>b) return a;
		return b;
	}
	
	static int lcs(char[] c1, char[] c2, int m, int n){
		
		int[][] resLCS= new int[m+1][n+1];
		int result = 0;
		
		for(int i=0;i<=m;i++){
			for(int j=0;j<=n;j++){
				
				if(i==0 || j==0){
					resLCS[i][j] =0;
				}else if(c1[i-1]==c2[j-1]){
					resLCS[i][j] = resLCS[i-1][j-1]+1;
					result = max(result, resLCS[i][j]);
				}else{
					resLCS[i][j] = 0;
				}
				
			}
			
		}
		
		return result;
	}
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter string1 ");
		String s1 = in.nextLine();
		
		System.out.println("Enter string2 ");
		String s2 = in.nextLine();
		
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray(); 
		
		int m = c1.length;
		int n = c2.length;
		
		System.out.println("Longest common substring length is "+lcs(c1, c2, m, n));
		
	}
}
