package day_0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon_2468 {
	static int[][] arr;
	static int N;
	static int[] di = {0, 0, -1, 1};
	static int[] dj = {-1, 1, 0, 0};
	static boolean[][] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		StringTokenizer st = null;
		int max = 0;
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(max < arr[i][j]) {
					max = arr[i][j];
				}
				min = Math.min(min, arr[i][j]);
			}
		}

		int ans = 0;
		int tmp = 0;
		int[][] temp = new int[N][N];
		
		for(int water = 0; water <= max; water++) {
			temp = new int[N][N];
			visited = new boolean[N][N];
			tmp = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(arr[i][j] <= water) {
						temp[i][j] = -1;
					}
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(!visited[i][j] && temp[i][j] == 0) {
						dfs(i, j, temp);
						tmp++;
					}
				}
			}
			ans = Math.max(ans, tmp);
		}
		System.out.println(ans);
	}
	
	static void dfs(int i, int j, int[][] temp) {
		visited[i][j] = true;
		for(int d = 0; d < 4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if(ni < 0 || nj < 0 || ni >= N || nj >= N) continue;
			if(visited[ni][nj]) continue;
			if(temp[ni][nj] == -1) continue;
			dfs(ni, nj, temp);
		}
	}
}
