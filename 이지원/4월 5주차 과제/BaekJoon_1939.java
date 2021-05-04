package day_0502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon_1939 {
	static int N, M, arr[][], s, e;
	static long ans;
	static boolean[][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N][N];
		arr = new int[N][N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());
			if (arr[a][b] == 0) {
				arr[a][b] = arr[b][a] = c;
			} else {
				arr[a][b] = arr[b][a] = Math.max(c, arr[a][b]);
			}
		}
		st = new StringTokenizer(br.readLine(), " ");
		s = Integer.parseInt(st.nextToken()) - 1;
		e = Integer.parseInt(st.nextToken()) - 1;
		bfs();
		System.out.println(ans);
	}

	static void bfs() {
		Queue<pos> q = new LinkedList<>();
		q.add(new pos(s, 0));
		while (!q.isEmpty()) {
			pos cur = q.poll();
			if (cur.i == e) {
				ans = Math.max(ans, cur.weight);
			}
			for (int i = 0; i < N; i++) {
				if (cur.i == i)
					continue;
				if (arr[cur.i][i] == 0)
					continue;
				if (visited[cur.i][i])
					continue;

				visited[cur.i][i] = true;
				visited[i][cur.i] = true;
				if(cur.weight > arr[cur.i][i]) continue;
				if (arr[i][cur.i] >= cur.weight) {
					if (cur.weight == 0) { // 처음
						if (ans > arr[i][cur.i])
							continue;
						q.add(new pos(i, arr[i][cur.i]));
					} else {
						if (ans > cur.weight)
							continue;
						q.add(new pos(i, cur.weight));
					}
				}
			}
		}
	}

	static class pos {
		int i;
		long weight;

		public pos(int i, long weight) {
			this.i = i;
			this.weight = weight;
		}
	}

}
