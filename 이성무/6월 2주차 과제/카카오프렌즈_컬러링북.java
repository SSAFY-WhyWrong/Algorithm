package 성공;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 카카오프렌즈_컬러링북 {

	private static boolean[][] bool;
	private static int numberOfArea, maxSizeOfOneArea;
	private static int[] dx = {-1,1,0,0};
	private static int[] dy = {0,0,-1,1};
	private static int[][] map;
	private static class xy {
		int x, y;

		public xy(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}
	public static void main(String[] args) {
		int m = 6,n=4;
		int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
		solution(m,n,picture);
	}

	public static int[] solution(int m, int n, int[][] picture) {
		numberOfArea = 0;
		maxSizeOfOneArea = 0;
		map = picture;
		bool = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (bool[i][j]||picture[i][j]==0)
					continue;
				numberOfArea++;
				maxSizeOfOneArea= Math.max(maxSizeOfOneArea, go(i, j, picture[i][j]));
			}
		}

		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		return answer;
	}

	public static int go(int x, int y, int color) {
		xy a;
		int fx,fy,lx,ly,count=1;
		bool[x][y] = true;
		Queue<xy> queue = new LinkedList<>();
		queue.add(new xy(x, y));
		while(!queue.isEmpty()) {
			a = queue.poll();
			fx = a.x;
			fy = a.y;
			for (int i = 0; i < 4; i++) {
				lx = fx+dx[i];
				ly = fy+dy[i];
				if(lx>=0&&ly>=0&&lx<bool.length&&ly<bool[0].length&&!bool[lx][ly]&&map[lx][ly]==color) {
					count++;
					bool[lx][ly] = true;
					queue.add(new xy(lx,ly));
				}
			}
		}
		return count;
	}

}
