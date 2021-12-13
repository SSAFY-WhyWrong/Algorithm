import java.util.*;
import java.io.*;

public class 백준_1562_계단수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int MOD = 1000000000;
		long[][][] dp = new long[1 << 10][10][N+1];
		
		for(int i=0;i<10;i++) {
			dp[1 << i][i][1] = 1;
		}
		
		for(int i=1;i<N+1;i++) {
			for(int j=0;j<10;j++) {
				for(int k=0;k<(1<<10);k++) {
					int bit = k | (1 << j);
					if(j == 0) {
						dp[bit][j][i] = (dp[bit][j][i] + dp[k][j+1][i-1]) % MOD;
					} else if(j == 9) {
						dp[bit][j][i] = (dp[bit][j][i] + dp[k][j-1][i-1]) % MOD;
					} else {
						dp[bit][j][i] = (dp[bit][j][i] + dp[k][j-1][i-1] + dp[k][j+1][i-1]) % MOD;
					}
				}
			}
		}
		
		long sum = 0;
		for(int i=1;i<10;i++) {
			sum += dp[(1<<10) - 1][i][N] % MOD;
			sum %= MOD;
		}
		
		System.out.println(sum);
	}

}
