package day_0625;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon_1963 {
	static boolean[] check;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		check = new boolean[10002];
		for(int i = 2; i * i < 10001; i++) {
			if(!check[i]) {
				for(int j = i * i; j <= 10001; j += i) {
					check[j] = true;
				}
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int target = Integer.parseInt(st.nextToken());
			int ans = bfs(start, target);
			if(ans== -1) {
				System.out.println("Impossible");
			} else {
				System.out.println(ans);
			}
			
			
		}
	}
	
	static int bfs(int start, int target) {
		Queue<Pos> q = new LinkedList<>();
		boolean[] visited = new boolean[10002];
		q.add(new Pos(start, 0));
		while(!q.isEmpty()) {
			Pos cur = q.poll();
			if(cur.num == target) {
				return cur.cnt;
			}
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j <= 9; j++) {
					if(i == 0 && j == 0) {
						continue;
					}
					int index = change(cur.num, i, j);
					if(!check[index] && !visited[index]) {
						visited[index] = true;
						q.add(new Pos(index, cur.cnt + 1));
					}
				}
			}
		}
		return -1;
	}
	
	static int change(int num, int i, int v) {
		StringBuilder sb = new StringBuilder(String.valueOf(num));
		sb.setCharAt(i, (char)(v + '0'));
		return Integer.parseInt(sb.toString());
	}
	
	static class Pos{
		int num, cnt;
		public Pos(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
	}
}
