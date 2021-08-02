package 실패;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class B19238 {
	private static int N, M, startx, starty, gas;
	private static int[][] map, pass;
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };
	private static Queue<xy> queue;

	private static class xy implements Comparable<xy> {
		int x, y;

		public xy(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(xy o) {
			// TODO Auto-generated method stub
			return this.x - o.x == 0 ? this.y - o.y : this.x - o.x;
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// 0은 빈칸, 1은 벽
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		gas = Integer.parseInt(st.nextToken());
		pass = new int[M][4];
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine(), " ");
		startx = Integer.parseInt(st.nextToken()) - 1;
		starty = Integer.parseInt(st.nextToken()) - 1;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 4; j++) {
				pass[i][j] = Integer.parseInt(st.nextToken());

			}
			map[pass[i][0]][pass[i][1]] = 2;
		}
		for (int i = 0; i < M; i++) {
			find();
		}
		System.out.println(gas);
	}

	private static void find() {
		queue = new LinkedList<>();
		queue.add(new xy(startx, starty));
		boolean[][] bool = new boolean[N][N];
		bool[startx][starty] = true;
		int x, y, lx, ly, size,cnt=0;
		xy a;
		PriorityQueue<xy> pq;
		while (!queue.isEmpty()) {
			size = queue.size();
			pq = new PriorityQueue<>();
			for (int i = 0; i < size; i++) {
				a = queue.poll();
				x = a.x;
				y = a.y;
				for (int j = 0; j < 4; j++) {
					lx = x + dx[j];
					ly = y + dy[j];
					if (lx >= 0 && ly >= 0 && lx < N && ly < N && map[lx][ly] != 1) {
						if (map[lx][ly] == 2) { // 출발지 도착
							pq.add(new xy(lx, ly));
						} else {
							queue.add(new xy(lx, ly));
						}
					}
				}

			}
			cnt++;
			if (pq.size() != 0) {
				a = pq.poll();
				gas-=cnt;
				if(gas<0) {
					System.out.println(-1);
					System.exit(0);
				}
				for (int i = 0; i < M; i++) {
					if (pass[i][0] == a.x && pass[i][1] == a.y) {
						go(pass[i][0], pass[i][1], pass[i][2], pass[i][3]);
						break;
					}
				}
			}
		}
	}

	private static void go(int stX, int stY, int enX, int enY) {
		queue = new LinkedList<>();
		boolean[][] bool = new boolean[N][N];
		bool[stX][stY] = true;
		queue.add(new xy(stX,stY));
		int x, y, lx, ly, size,cnt=0;
		xy a;
		while(!queue.isEmpty()) {
			size = queue.size();
			for (int i = 0; i < size; i++) {
				a = queue.poll();
				x = a.x;
				y = a.y;
				for (int j = 0; j < 4; j++) {
					lx = x + dx[j];
					ly = y + dy[j];
					if (lx >= 0 && ly >= 0 && lx < N && ly < N && map[lx][ly] != 1) {
						if (lx==enX&&ly==enY) { // 목적지 도착
							gas-=cnt+1;
							if(gas<0) {
								System.out.println(-1);
								System.exit(0);
							}
							gas+=cnt*2;
							startx = lx;
							starty = ly;
							map[stX][stY] = 0;
						} else {
							queue.add(new xy(lx, ly));
						}
					}
				}
			}
			cnt++;
		}
	}

}
