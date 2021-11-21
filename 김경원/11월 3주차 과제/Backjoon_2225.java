import java.util.Scanner;

public class Backjoon_2225 {
	
	static final int MOD_NUMBER = 1000000000;
	
	public static void main(String[] args) {
		
		int N, K;
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		
		int[][] dp = new int[K+1][N+1];
		
		for(int i=1; i<=K;i++){
			dp[i][0] = 1;
		}
		
		
		
		
		for(int i=1;i<=K;i++) {
			for(int j=1;j<=N;j++) {
				dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % MOD_NUMBER ;
			}
		}
		
		System.out.println(dp[K][N]);
		
	}
}
