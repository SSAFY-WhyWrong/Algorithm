package B2579계단오르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int r, max = 0;
	static int []arr;
	static int []dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		int total = 0;
		arr = new int[r + 1];
		dp = new int[r + 1];


		for(int i = 1; i <= r; i ++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dp[1] = arr[1];
		if(r >= 2) {
			dp[2] = arr[1] + arr[2];
		}
		for(int i = 3; i <= r; i ++) {
			dp[i] = Math.max(dp[i - 2], dp[i - 3] + arr[i - 1]) + arr[i];
		}
		System.out.println(dp[r]);
	}
}
