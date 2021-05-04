import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_2583_영역구하기 {
	static boolean[][] map;
	static boolean[][] visit_map;
	static int M, N, K;
	static Queue<Node> q;
	static int[] dy = { 0, 0, -1, 1 };
	static int[] dx = { 1, -1, 0, 0 };
	static int cnt;
	static ArrayList<Integer> ans = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new boolean[M][N];
		visit_map = new boolean[M][N];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int left_x = Integer.parseInt(st.nextToken());
			int left_y = Integer.parseInt(st.nextToken());
			int right_x = Integer.parseInt(st.nextToken());
			int right_y = Integer.parseInt(st.nextToken());
			color_map(left_x, left_y, right_x, right_y);
		}
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == false && visit_map[i][j] == false) {
					q = new LinkedList<>();
					cnt = 1;
					q.offer(new Node(i, j));
					visit_map[i][j] = true;
					bfs();
				}
			}
		}
		Collections.sort(ans);
		
		System.out.println(ans.size());
		for(int i=0;i<ans.size();i++) {
			System.out.print(ans.get(i)+" ");
		}
	}

	static void color_map(int l_x, int l_y, int r_x, int r_y) {
		for (int i = l_y ; i < r_y; i++) {
			for (int j = l_x; j < r_x; j++) {
				map[i][j] = true;
			}
		}
	}

	static void bfs() {
		while (!q.isEmpty()) {
			Node per = q.poll();
			for (int i = 0; i < 4; i++) {
				int tmpy = per.y + dy[i];
				int tmpx = per.x + dx[i];
				if (tmpy >= 0 && tmpx >= 0 && tmpy < M && tmpx < N && map[tmpy][tmpx] == false
						&& visit_map[tmpy][tmpx] == false) {
					visit_map[tmpy][tmpx] = true;
					cnt += 1;
					q.offer(new Node(tmpy, tmpx));
				}
			}
		}
		ans.add(cnt);
	}

	static class Node {
		int y;
		int x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
