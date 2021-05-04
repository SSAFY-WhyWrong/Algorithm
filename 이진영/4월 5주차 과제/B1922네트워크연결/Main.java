package B1922네트워크연결;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[][] adjMatrix = new int[N][N];
		boolean[] visited = new boolean[N];
		int [] minEdge = new int[N];
		
		st = new StringTokenizer(in.readLine());
		int line = Integer.parseInt(st.nextToken());
		for(int i = 0; i < line; i++) {
			st = new StringTokenizer(in.readLine());
			
				int y = Integer.parseInt(st.nextToken()) - 1;
				int x = Integer.parseInt(st.nextToken()) - 1;
				int m = Integer.parseInt(st.nextToken());
				
				adjMatrix[y][x] = m;
				adjMatrix[x][y] = m;
		}
		Arrays.fill(minEdge, Integer.MAX_VALUE);

		int result = 0;
		minEdge[0] = 0; //시작점으로 세팅
		
		for(int c = 0; c < N; c++) {
			
			int min = Integer.MAX_VALUE;
			int minVertex = 0; // 신장트리에 연결되지 않은 정점중 minEdge비용이 최소인 정점
			
			for(int i = 0; i < N; i++) {
				if(!visited[i] && min > minEdge[i]) {
					min = minEdge[i];
					minVertex = i;
				}
			}
			
			result += min;
			visited[minVertex] = true;
			
			for(int i = 0; i < N ; i++) {
				if(!visited[i] && adjMatrix[minVertex][i] != 0 && minEdge[i] > adjMatrix[minVertex][i]) {
					minEdge[i] = adjMatrix[minVertex][i];
				}
			}
		}
		System.out.println(result);
		
	}
}
