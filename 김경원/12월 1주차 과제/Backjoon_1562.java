import java.io.IOException;
import java.util.Scanner;

public class Backjoon_1562 {
	
	static final int MOD_NUMBER = 1000000000;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		
		int N = sc.nextInt();
		int sum = 0;
		
		//사용된 숫자 판별 여부 비트, 첫 번째 숫자, 길이
		int[][][] dp = new int[1<<10][10][N+1];
		
		
		for(int j=0;j<=9;j++) {
			dp[1<<j][j][1] = 1;
		}
		
		
		for(int i=2;i<=N;i++) {
			for(int j=0;j<=9;j++) {
				for(int k=0;k<(1<<10);k++) {
					if(j!=0) {
						dp[k|1 << j][j][i] += dp[k][j-1][i-1] % MOD_NUMBER;
					}
					if(j!=9) {
						dp[k|1 << j][j][i] += dp[k][j+1][i-1] % MOD_NUMBER;
					}
					
					dp[k|1<<j][j][i] %= MOD_NUMBER;
				}
			}
		}
		
		for(int i=1;i<=9;i++) {
			sum+= dp[(1 << 10) - 1][i][N] % MOD_NUMBER;
			sum%=MOD_NUMBER;
		}
		System.out.println(sum);
		
		
	}	
}
