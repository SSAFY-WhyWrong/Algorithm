import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon_1486 {

	static public class Node implements Comparable<Node> {
		int i, j, w, t;

		public Node(int i, int j, int w, int t) {
			this.i = i;
			this.j = j;
			this.w = w;
			this.t = t;
		}

		@Override
		public int compareTo(Node o) {
			return this.t - o.t;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 세로 , 가로, 최대 높이차 이동 거리, 시간
		int N, M, T, D;
		int[] ni = { -1, 1, 0, 0 };
		int[] nj = { 0, 0, -1, 1 };
		int result = 0;
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken(" "));
		M = Integer.parseInt(st.nextToken(" "));
		T = Integer.parseInt(st.nextToken(" "));
		D = Integer.parseInt(st.nextToken(" "));

		int[][] arr = new int[N][M];
		List<Node>[][] edge = new ArrayList[N][M];
		List<Node>[][] rEdge = new ArrayList[N][M];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = s.charAt(j) -'A';
				if(arr[i][j] > 25) {
					arr[i][j] -= 6;
				}
				edge[i][j] = new ArrayList<>();
				rEdge[i][j] = new ArrayList<>();
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int now = arr[i][j];
				for (int d = 0; d < 4; d++) {
					int next_i = i + ni[d];
					int next_j = j + nj[d];

					if (next_i < 0 || next_j < 0 || next_i >= N || next_j >= M || Math.abs(now - arr[next_i][next_j]) > T) {
						continue;
					}


					int weight = arr[i][j] >= arr[next_i][next_j] ? 1 : Math.abs(arr[i][j] - arr[next_i][next_j]);
					weight *= weight;

					edge[i][j].add(new Node(next_i, next_j, weight, 0));
					rEdge[next_i][next_j].add(new Node(i, j, weight, 0));

				}
			}
		}

		int[][] start = new int[N][M];
		int[][] back = new int[N][M];

		PriorityQueue<Node> q = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				start[i][j] = 10000000;
				back[i][j] = 10000000;
			}
		}

		q.add(new Node(0, 0, 0, 0));

		while (!q.isEmpty()) {

			Node now = q.poll();

			if (now.t > start[now.i][now.j]) {
				continue;
			}

			start[now.i][now.j] = now.t;

			for (Node node : edge[now.i][now.j]) {
				if (start[node.i][node.j] > now.t + node.w) {
					start[node.i][node.j] = now.t + node.w;
					q.add(new Node(node.i, node.j, 0, start[node.i][node.j]));
				}

			}

		}

//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(start[i][j] + " ");
//			}
//			System.out.println();
//		}

		
		q.add(new Node(0,0,0,0));
		
		while (!q.isEmpty()) {

			Node now = q.poll();

			if (now.t > back[now.i][now.j]) {
				continue;
			}

			back[now.i][now.j] = now.t;

			for (Node node : rEdge[now.i][now.j]) {
				if (back[node.i][node.j] > now.t + node.w) {
					back[node.i][node.j] = now.t + node.w;
					q.add(new Node(node.i, node.j, 0, back[node.i][node.j]));
				}

			}

		}

//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(back[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(start[i][j]+back[i][j] <= D) {
					result = Math.max(result, arr[i][j]);
				}
			}
		}
		System.out.println(result);
	}
}
