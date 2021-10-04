package M09_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_7579_앱 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //앱 개수
		int M = Integer.parseInt(st.nextToken()); //메모리
		
		st = new StringTokenizer(br.readLine());
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		App[] app = new App[N+1];
		
		for(int i=1; i<=N; i++) {
			int memory = Integer.parseInt(st.nextToken());
			int re = Integer.parseInt(st1.nextToken());
			app[i] = new App(memory, re);
		}
		//100*100 => 비용
		int[][] dp = new int[N+1][100001];
		int ans = Integer.MAX_VALUE;
		
		//0의 메모리는 어차피 다 0이라서 제외 후 1부터 시작
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=10000; j++) {
				if(app[i].restart <= j) {
					//같은 비용일 경우 최대값 저장
					dp[i][j] = Math.max(dp[i-1][j-app[i].restart]+app[i].memory, dp[i-1][j]);
				} else {
					dp[i][j] = dp[i-1][j];
				}
				//M보다 크면서 최소비용을 찾아야하기 때문에 M보다 크면 무조건 최소비용 비교
				if(dp[i][j] >= M) ans = Math.min(ans, j);
			}
		}
		System.out.println(ans);
	}
	
	static class App implements Comparable<App>{
		int memory;
		int restart;
		public App(int memory, int restart) {
			this.memory = memory;
			this.restart = restart;
		}
		@Override
		public int compareTo(App o) {
			return this.restart - o.restart;
		}
	}
}
