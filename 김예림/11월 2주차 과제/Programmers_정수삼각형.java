
public class Programmers_정수삼각형 {
	public static void main(String[] args) {
		int[][] triangle = {{7,0,0,0,0}, {3,8,0,0,0}, {8,1,0,0,0}, {2,7,4,4,0}, {4,5,2,6,5}};
		
		System.out.println(solution(triangle));
	}
	public static int solution(int[][] triangle) {

		int N = triangle.length;
		int M = triangle[N-1].length;
		int[][] dp = new int[N][M];
		
		for(int j=0; j<M; j++) {
			dp[0][j] = triangle[0][j];
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		for(int i=1; i<N; i++) {
			dp[i][0] = triangle[i][0]+dp[i-1][0];
		}
		
		for(int i=1; i<N; i++) {
			for(int j=1; j<i+1; j++) {
				int n1 = dp[i-1][j-1];
				int n2 = dp[i-1][j];
				dp[i][j] = Math.max(n1+triangle[i][j], n2+triangle[i][j]);
			}
		}
		
		int answer = 0;
		for(int j=0; j<M; j++) {
			answer = Math.max(answer, dp[N-1][j]);
		}
		return answer;
	}
}
