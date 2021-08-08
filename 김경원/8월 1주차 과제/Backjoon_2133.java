import java.util.Scanner;

public class Backjoon_2133 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int dp[] = new int[31];
		
		dp[0] = 1;
		dp[2] = 3;
		if (N % 2 == 0) {

			for (int i = 4; i <= N; i=i+2) {
				dp[i] = dp[i-2]*3;
				for(int j=4;j<= i;j=j+2) {
					dp[i] += dp[i-j]*2;
				}
			}
			
			System.out.println(dp[N]);
		}
		else {
			
			System.out.println(0);
			
		}

	}
}
