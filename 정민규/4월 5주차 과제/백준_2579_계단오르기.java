import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_2579_계단오르기 {
	static int N;
	static int[] arr;
	static int[] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		dp = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		dp[0] = arr[0];
		if (N >= 2)
			dp[1] = Math.max(arr[0] + arr[1], arr[1]);
		if (N >= 3)
			dp[2] = Math.max(arr[0] + arr[2], arr[1] + arr[2]);
		for (int i = 3; i < N; i++) {
			dp[i] = Math.max(dp[i - 2] + arr[i], arr[i - 1] + arr[i] + dp[i - 3]);
		}
		System.out.println(dp[N - 1]);
	}
}
