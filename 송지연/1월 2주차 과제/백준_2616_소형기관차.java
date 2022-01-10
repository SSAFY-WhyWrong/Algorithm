import java.util.*;
import java.io.*;

public class 백준_2616_소형기관차 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[] guestSum = new int[N+1];
		int[][] dp = new int[4][N+1];
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i=1;i<N+1;i++) {
			guestSum[i] = guestSum[i-1] + Integer.parseInt(st.nextToken());
		}
		
		int k = Integer.parseInt(bf.readLine());
		
		for(int i=1;i<4;i++) {
			for(int j=i*k;j<N+1;j++) {
				dp[i][j] = Math.max(dp[i][j-1], (guestSum[j] - guestSum[j-k]) + dp[i-1][j-k]);
			}
		}
		
		System.out.println(dp[3][N]);
		
	}

}
