import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_1915 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N,M;
		int result=0;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken(" "));
		M = Integer.parseInt(st.nextToken(" "));
		
		int arr[][] = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken(" ");
			for(int j=0;j<M;j++) {
				arr[i][j] = s.charAt(j) - '0';
				if(arr[i][j]==1) result=1;
			}
		}
		
		int dp[][] = new int[N][M];
		
		for(int i=0;i<N;i++) {
			dp[i][0] = arr[i][0];
		}
		
		for(int j=0;j<M;j++) {
			dp[0][j] = arr[0][j];
		}
		
		
		for(int i=1;i<N;i++) {
			for(int j=1;j<M;j++) {
				if(arr[i][j]==1) {
					dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1],dp[i][j-1])) + 1;
					result = Math.max(result, dp[i][j]);
					//3군데 확인
				}
				
			}
		}
				
		
		result *= result;
		System.out.println(result);
		
		
		
	}
}
