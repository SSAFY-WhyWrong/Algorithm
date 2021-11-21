package 성공;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B16197 {
	private static int N, M, answer = 11;
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };
	private static char[][] map;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		String str;
		char c;
		int x1 = -1, x2 = -1, y1 = -1, y2 = -1;
		for (int i = 0; i < N; i++) {
			str = br.readLine();
			for (int j = 0; j < M; j++) {
				c = str.charAt(j);
				if (c == 'o') {
					if (x1 == -1) {
						x1 = i;
						y1 = j;
					} else {
						x2 = i;
						y2 = j;
					}
					map[i][j] = '.';
				} else {
					map[i][j] = c;
				}
			}
		}
		playMap(x1, y1, x2, y2, 0);
		if (answer > 10) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}
	}

	private static void playMap(int x1, int y1, int x2, int y2, int cnt) {
		// TODO Auto-generated method stub
		if (answer <= cnt) {
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (x1 + dx[i] >= 0 && y1 + dy[i] >= 0 && x1 + dx[i] < N && y1 + dy[i] < M) { // 1 범위안
				if (x2 + dx[i] >= 0 && y2 + dy[i] >= 0 && x2 + dx[i] < N && y2 + dy[i] < M) {// 2 범위안
					if (map[x1 + dx[i]][y1 + dy[i]] == '.' && map[x2 + dx[i]][y2 + dy[i]] == '.') {
						playMap(x1 + dx[i], y1 + dy[i], x2 + dx[i], y2 + dy[i], cnt + 1);
					} else if (map[x1 + dx[i]][y1 + dy[i]] == '.') {
						playMap(x1 + dx[i], y1 + dy[i], x2, y2, cnt + 1);
					} else if (map[x2 + dx[i]][y2 + dy[i]] == '.') {
						playMap(x1, y1, x2 + dx[i], y2 + dy[i], cnt + 1);
					}
				} else { // 2 범위밖
					if (cnt + 1 < answer)
						answer = cnt + 1;
					return;
				}
			} else {// 1 범위밖
				if (x2 + dx[i] >= 0 && y2 + dy[i] >= 0 && x2 + dx[i] < N && y2 + dy[i] < M) {// 2범위안
					if (cnt + 1 < answer)
						answer = cnt + 1;
					return;
				} else {// 2범위밖
					continue;
				}
			}
		}
	}

}
