import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[][] dp = new int[201][201]; // [k][n] -> k번 더해서 n을 구함
		for(int i=1;i<=k;i++)
			dp[i][0] = 1; // 0을 만드는 경우의 수는 1이기때문
		
		for(int i=1;i<=k;i++) {
			for(int j=1;j<=n;j++)
				dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % 1000000000;
		}
		
		System.out.println(dp[k][n]);
	}
}