import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_1480 {
	
	static int[][][] dp;
	static int N,M,C;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken(" "));
		M = Integer.parseInt(st.nextToken(" "));
		C = Integer.parseInt(st.nextToken(" "));
		
		
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken(" "));
		}
		
		dp = new int[1<< N][M+1][C+1];
		
		
		solve(0,0,C);
		System.out.println(dp[0][0][C]);
		
		
	}
	
	static int solve(int bit, int idx, int remain) {
		if(bit == (1 << N) -1 || idx == M) {
			return 0;
		}
		
		if(dp[bit][idx][remain] != 0) {
			return dp[bit][idx][remain];
		}
		
		
		
		for(int i=0;i<N;i++) {
			if((bit & (1 << i) ) != 0) {
				continue;
			}
			
			
			int value = 0;
			
			if(remain >= arr[i]) {
				value = solve(bit | (1 <<i),  idx, remain -arr[i]) + 1;
			}else {
				value = solve(bit, idx+1, C);
			}
			
			dp[bit][idx][remain] = Math.max(dp[bit][idx][remain], value);
			
		}
		
		
		
		
		
		return dp[bit][idx][remain];
	}
	
	
	
}
