package AlgorithmStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1520_내리막길 {
	
	static int[] di = {0,0,-1,1};
	static int[] dj = {-1,1,0,0};
	static int N, M, way;
	static int[][] map, dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		dp = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1; 
				//도착지점과 탐색을 안 했다는 것을 나타냄 => -1
			}
		}

		System.out.println(dfs(0,0));
	}
	
	public static int dfs(int i, int j) {
		
		if(i==N-1 && j==M-1) return 1; 
		//도착지까지 도착했으면 해당 지점에서 도착지까지 1개의 경로가 생긴것이므로 return 1
		//이게 #49에 += 로 더해지면서 x,y에서 도착지까지의 경로의 수가 완성~!
		
		if(dp[i][j] != -1) return dp[i][j]; //이미 이전에 탐색한건 탐색한 결과 출력
		
		dp[i][j] = 0; 
		//탐색은 했으니 -1과는 다름! 근데 만약 밑에 코드로 += 가 안되면 탐색은 했지만 도착지와 연결된 경로가 없는 포인트가 됨!
		for(int d=0; d<4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if(ni>=0 && ni<N && nj>=0 && nj<M && map[i][j]>map[ni][nj]) {
				dp[i][j] += dfs(ni,nj);
			}
		}
		return dp[i][j];
	}
}
