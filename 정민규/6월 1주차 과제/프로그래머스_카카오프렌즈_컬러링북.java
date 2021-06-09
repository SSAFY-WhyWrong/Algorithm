import java.util.Queue;
import java.util.LinkedList;

public class 프로그래머스_카카오프렌즈_컬러링북 {
	public static void main(String[] args) {
		int m = 6;
		int n = 4;
		int[][] picture = { { 1, 1, 1, 0 }, { 1, 2, 2, 0 }, { 1, 0, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 3 },
				{ 0, 0, 0, 3 } };

		int[] answer = solution(m, n, picture);
		System.out.println(answer[0] + " " + answer[1]);
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean[][] visited;
	static Queue<where> q;

	static int numberOfArea = 0;
	static int maxSizeOfOneArea = 0;

	static public int[] solution(int m, int n, int[][] picture) {

		int[] answer = new int[2];

		visited = new boolean[m][n];
		q = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j] != true && picture[i][j] != 0) {
					visited[i][j] = true;
					q.offer(new where(i, j));
					numberOfArea += 1;
					search(m, n, picture);
				}
			}
		}

		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;

		return answer;
	}

	static void search(int m, int n, int[][] picture) {
		int cnt = 1;
		while (!q.isEmpty()) {
			where per = q.poll();

			for (int i = 0; i < 4; i++) {
				int tmpy = per.y + dy[i];
				int tmpx = per.x + dx[i];
				if (tmpy >= 0 && tmpy < m && tmpx >= 0 && tmpx < n && picture[per.y][per.x] == picture[tmpy][tmpx]
						&& visited[tmpy][tmpx] != true) {
					visited[tmpy][tmpx] = true;
					cnt += 1;
					q.offer(new where(tmpy, tmpx));
				}
			}
		}
		maxSizeOfOneArea = maxSizeOfOneArea > cnt ? maxSizeOfOneArea : cnt;
	}

	static class where {
		int y;
		int x;

		public where(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

}
