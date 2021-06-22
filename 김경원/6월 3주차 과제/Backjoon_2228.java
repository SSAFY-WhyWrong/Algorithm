import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_2228 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N, M;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken(" "));
		M = Integer.parseInt(st.nextToken(" "));

		int num[] = new int[N+1];
		int sum[] = new int[N+1];

		for (int i = 1; i <= N; i++) {
			num[i] = Integer.parseInt(br.readLine());
			sum[i] = sum[i-1] + num[i];
		}

		int dp[][] = new int[N+1][M+1];
		
		for(int j=1;j<=M;j++) {
			dp[0][j] = -3276800;
		}
		
			
		

		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				dp[i][j] = dp[i-1][j];
				if(j==1)
					dp[i][j] = Math.max(dp[i][j], sum[i]);
				for(int k=2;k<=i;k++) {
						dp[i][j] = Math.max(dp[i][j], dp[k-2][j-1] + (sum[i] - sum[k-1]));				
						
				}
			}
		}
		
		System.out.println(dp[N][M]);

	}
}
