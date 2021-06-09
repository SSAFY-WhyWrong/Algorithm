
public class Programmers_등굣길 {
	public static void main(String[] args) {
		int m, n;
		int[][] puddles = { { 2, 2 }};
		;

		m = 4;
		n = 3;

		System.out.println(solution(m, n, puddles));
	}

	static public int solution(int m, int n, int[][] puddles) {
		int answer = 0;
		int x, y;
		long dp[][] = new long[n + 1][m + 1];
		boolean isPuddle[][] = new boolean[n + 1][m + 1];
		dp[1][1] = 1;

		
		for (int i = 0; i < puddles.length; i++) {
			y = puddles[i][0];
			x = puddles[i][1];
			isPuddle[x][y] = true;
		}

		for (int i = 0; i <= n; i++)
			dp[i][0] = 0;

		for (int j = 0; j <= m; j++)
			dp[0][j] = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (!isPuddle[i][j]) {
					dp[i][j] += dp[i - 1][j] % 1000000007 + dp[i][j - 1] % 1000000007;
					dp[i][j] %= 1000000007;

				}
			}
		}

//        for(int i=1;i<=n;i++) {
//        	for(int j=1;j<=m;j++)
//        		System.out.print(dp[i][j]+" ");
//        	System.out.println();
//        }

		answer = (int) dp[n][m] % 1000000007;

		return answer;
	}
}
