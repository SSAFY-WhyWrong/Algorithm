package BOJ;

import java.util.Scanner;

public class BOJ2579 {
	static int N;
	static int[] arr;
	static int[][] dp;
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		arr = new int[N];
		dp = new int[2][N];
		
		for(int i=0; i<N; i++) {
			arr[i] = scanner.nextInt(); 
		}
		
		dp[0][0] = arr[0];
		dp[1][0] = arr[0];
		dp[0][1] = arr[1];
		dp[1][1] = arr[0] + arr[1];
		
		for(int i=2; i<N; i++) {
			dp[0][i]= Math.max(dp[0][i-2], dp[1][i-2]) + arr[i];
			dp[1][i]= dp[0][i-1] + arr[i];// 무조건 한칸만 올라갈 수 있다 
		}
		
		System.out.println(Math.max(dp[0][N-1], dp[1][N-1]));
	}

}
