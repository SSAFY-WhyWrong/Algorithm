package 성공;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_2583 {
	static int M, N, K, x, y, i, j;
	static int[][] map;
	static Queue<xy> queue;
	static ArrayList<Integer> list;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
//
	private static class xy {
		int x, y;

		public xy(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[M][N];
//		for (int i = 0; i < M; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		
//		}System.out.println();
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			i = Integer.parseInt(st.nextToken());
			j = Integer.parseInt(st.nextToken());
			for (int l = x; l < i; l++) {
				for (int p = y; p < j; p++) {
					map[p][l] = 1;
				}
			}
		}
//		for (int i = 0; i < M; i++) {
//			System.out.println(Arrays.toString(map[i]));
//			
//		}System.out.println();
		list = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0) {
					list.add(bfs(i, j));
				}
			}
		}
		Collections.sort(list);
		int size = list.size();
		sb.append(size + "\n");
		for (int i = 0; i < size; i++) {
			sb.append(list.get(i) + " ");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}

	private static Integer bfs(int startx, int starty) {
		queue = new LinkedList<>();
		queue.add(new xy(startx, starty));
		map[startx][starty] = 1;
		int cnt = 1, x, y, lx, ly;
		xy a;
		while (!queue.isEmpty()) {
			a = queue.poll();
			x = a.x;
			y = a.y;
			for (int i = 0; i < 4; i++) {
				lx = x + dx[i];
				ly = y + dy[i];
				if (lx >= 0 && ly >= 0 && lx < M && ly < N && map[lx][ly] == 0) {
					map[lx][ly] = 1;
					cnt++;
					queue.add(new xy(lx, ly));
				}
			}
		}
//		for (int i = 0; i < M; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}System.out.println();

		return cnt;
	}

}
