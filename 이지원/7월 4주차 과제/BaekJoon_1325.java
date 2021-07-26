package day_0720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon_1325 {
	static int N, temp, dp[];
	static ArrayList<Integer>[] arr;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N];
		dp = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = new ArrayList<>();
		}
		for(int j = 0; j < M; j++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			arr[B - 1].add(A - 1);
		}
		for(int i = 0; i < N ; i++) {
			visited = new boolean[N];
			visited[i] = true;
			//dfs(i, i);
			bfs(i);
		}
		int max = 0;
		for(int i = 0; i < N ; i++) {
			max= Math.max(max, dp[i]);
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N ; i++) {
			if(max == dp[i]) {
				sb.append(i + 1 + " ");
			}
		}
		System.out.println(sb);
	}
	
	/*static int dfs(int i) {
		if(dp[i] != 0) return dp[i];
		dp[i] = 1;
		for(int d : arr[i]) {
			if(visited[d]) continue;
			visited[d] = true;
			dp[i] += dfs(d);
			visited[d] = false;
		}
		return dp[i];
	}*/
	
	static void bfs(int i) {
		Queue<Integer> q = new LinkedList<>();
		q.add(i);
		visited[i] = true;
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int d : arr[cur]) {
				if(visited[d]) continue;
				visited[d] = true;
				q.add(d);
				dp[i]++;
			}
		}
	}
	
	static void dfs(int i, int now) {
		for(int d : arr[now]) {
			visited[d] = true;
			dfs(i, d);
			dp[i]++;
		}
	}
	

}
