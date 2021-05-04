import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_2579 {
	public static void main(String[] args)  throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N;
		N = Integer.parseInt(st.nextToken(" "));
		
		
		int arr[] = new int[N];
		int dp[] = new int[N+1];
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		
		dp[1] = arr[0];
		
		if(N>=2)
			dp[2] = arr[0]+arr[1];
		
		
		for(int i=3;i<=N;i++) {
			dp[i] = Math.max(dp[i-3]+arr[i-2], dp[i-2]) + arr[i-1];			
		}
		
		System.out.println(dp[N]);
		
	}
}
