import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_16197_두동전 {
	static int n, m;
	static char[][] arr;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int MIN = 11;

	static int[] y_arr = new int[2];
	static int[] x_arr = new int[2];
	static int cnt = 0;
	static Queue<PLACE> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new char[n][m];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				if (s.charAt(j) == 'o') {
					y_arr[cnt] = i;
					x_arr[cnt++] = j;
				}
				arr[i][j] = s.charAt(j);
			}
		}
		q.offer(new PLACE(y_arr[0], x_arr[0], y_arr[1], x_arr[1], 0));
		bfs();
		if (MIN == 11)
			MIN = -1;
		System.out.println(MIN);
	}

	static void bfs() {
		while (!q.isEmpty()) {
			PLACE place = q.poll();
			int y1 = place.y1;
			int x1 = place.x1;

			int y2 = place.y2;
			int x2 = place.x2;
			int tmp_cnt = place.cnt;

			if (tmp_cnt > 10) {
				if (MIN == 11)
					MIN = -1;
				return;
			}
			for (int i = 0; i < 4; i++) {
				int tmpy1 = y1 + dy[i];
				int tmpx1 = x1 + dx[i];

				int tmpy2 = y2 + dy[i];
				int tmpx2 = x2 + dx[i];

				if (tmpy1 >= 0 && tmpy2 >= 0 && tmpx1 >= 0 && tmpx2 >= 0 && tmpy1 < n && tmpy2 < n && tmpx1 < m
						&& tmpx2 < m && tmp_cnt + 1 <= 10) {
					if (arr[tmpy2][tmpx2] == '#') {
						tmpy2 = y2;
						tmpx2 = x2;
					}
					if (arr[tmpy1][tmpx1] == '#') {
						tmpy1 = y1;
						tmpx1 = x1;
					}
//					PLACE p = new PLACE(tmpy1, tmpx1, tmpy2, tmpx2, tmp_cnt + 1);
//					System.out.println(p.toString());

					q.add(new PLACE(tmpy1, tmpx1, tmpy2, tmpx2, tmp_cnt + 1));
				}
//				bfs 큐를 추가하는경우
				else if (tmp_cnt + 1 <= 10) {
					if (tmpy1 < n && tmpx1 < m && tmpy1 >= 0 && tmpx1 >= 0
							&& ((tmpy2 < 0 || tmpy2 >= n) || (tmpx2 < 0 || tmpx2 >= m))) {

						if (arr[tmpy1][tmpx1] == '#') {
							tmpy1 = y1;
							tmpx1 = x1;
						}

//						PLACE p = new PLACE(tmpy1, tmpx1, tmpy2, tmpx2, tmp_cnt + 1);
//						System.out.println(p.toString());

						MIN = MIN < tmp_cnt + 1 ? MIN : tmp_cnt + 1;
						return;
					} else if (tmpy2 < n && tmpx2 < m && tmpy2 >= 0 && tmpx2 >= 0
							&& ((tmpy1 < 0 || tmpy1 >= n) || (tmpx1 < 0 || tmpx1 >= m))) {
						if (arr[tmpy2][tmpx2] == '#') {
							tmpy2 = y2;
							tmpx2 = x2;
						}

//						PLACE p = new PLACE(tmpy1, tmpx1, tmpy2, tmpx2, tmp_cnt + 1);
//						System.out.println(p.toString());

						MIN = MIN < tmp_cnt + 1 ? MIN : tmp_cnt + 1;
						return;
					}
				}
//				bfs 동전 1개가 나간겨우 
			}
		}
	}

	static class PLACE {
		int y1;
		int x1;

		int y2;
		int x2;

		int cnt;

		public PLACE(int y1, int x1, int y2, int x2, int cnt) {
			this.y1 = y1;
			this.x1 = x1;
			this.y2 = y2;
			this.x2 = x2;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "PLACE [y1=" + y1 + ", x1=" + x1 + ", y2=" + y2 + ", x2=" + x2 + ", cnt=" + cnt + "]";
		}

	}
}
