import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_7579 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
						
		st = new StringTokenizer(br.readLine());
		
		int N,M;
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int memory[] = new int[N];
		int cost[] = new int[N];
		int total_cost =0;
		
		
		st = new StringTokenizer(br.readLine());
				
		for(int i=0;i<N;i++)
			memory[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			cost[i] = Integer.parseInt(st.nextToken());
			total_cost += cost[i];
		}
		
		int dp[] = new int[total_cost+1];
		
		for(int i=0;i<N;i++) {
			for(int j=total_cost; j>=cost[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j - cost[i]]+ memory[i]);
			}
		}
		
		for(int i=0;i<=total_cost;i++)
			if(dp[i] >=M) {
				System.out.println(i);
				break;
			}
		
		
		
		
	}
}
