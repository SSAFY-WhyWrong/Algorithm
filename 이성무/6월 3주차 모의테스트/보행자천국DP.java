package 실패;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 보행자천국DP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = 3, n = 6;
		int[][] cityMap = { { 0, 2, 0, 0, 0, 2 }, { 0, 0, 2, 0, 1, 0 }, { 1, 0, 0, 2, 2, 0 } };
//		int[][] cityMap = new int[3][3];
		System.out.println(solution(m, n, cityMap));
	}

	private static int MOD = 20170805;
	private static Queue<xy> queue;
	private static int[] dx = { 1, 0 }; // 아래 , 오른쪽
	private static int[] dy = { 0, 1 };
	private static int[][][] answerMap;
	private static int[][] copyMap;

	private static class xy {
		int x, y, dir;

		public xy(int x, int y, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
		}

	}

	public static int solution(int m, int n, int[][] cityMap) {
		int answer = 0;
		answerMap = new int[2][m][n];
		copyMap = cityMap;
		bfs(m, n);
		answer = (answerMap[0][m - 1][n - 1] + answerMap[1][m - 1][n - 1]) % MOD;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < answerMap[i].length; j++) {
				System.out.println(Arrays.toString(answerMap[i][j]));
			}
		}
		return answer;
	}

	private static void bfs(int m, int n) {
		// TODO Auto-generated method stub
		queue = new LinkedList<>();
		queue.add(new xy(0, 1, 1));
		queue.add(new xy(1, 0, 0));
		answerMap[0][0][0] = 1;
		answerMap[1][0][0] = 1;
		answerMap[0][1][0] = 1;
		answerMap[1][0][1] = 1;
		int size, x, y, lx, ly, dir, cnt;
		xy a;
		while (!queue.isEmpty()) {
			a = queue.poll();
			x = a.x;
			y = a.y;
			dir = a.dir;
			for (int j = 0; j < 2; j++) {
				if (copyMap[x][y] == 2 && dir != j)
					continue;
				lx = x + dx[j];
				ly = y + dy[j];
				if (lx >= 0 && ly >= 0 && lx < m && ly < n) {
					if(copyMap[lx][ly]==1)continue;
					if (copyMap[x][y] == 0) {
						if (answerMap[j][lx][ly] == 0)
							queue.add(new xy(lx, ly, j));
						answerMap[j][lx][ly] += answerMap[dir][x][y];
						answerMap[j][lx][ly] %= MOD;
					} else if (copyMap[x][y] == 2) {
						if (dir != j)
							continue;
						if (answerMap[j][lx][ly] == 0)
							queue.add(new xy(lx, ly, j));
						answerMap[j][lx][ly] += answerMap[dir][x][y];
						answerMap[j][lx][ly] %= MOD;
					}
				}
			}
		}
	}
}
