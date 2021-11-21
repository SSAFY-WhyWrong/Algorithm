package 실패;

import java.util.LinkedList;
import java.util.Queue;

public class 등굣길 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = 4, n = 3;
		int[][] puddles = { { 2, 2 } };
		System.out.println(solution(m, n, puddles));
	}
	private static int[][] matrix;
	private static int[] dx = {1,0};
	private static int[] dy = {0,1};
	
	public static int solution(int m, int n, int[][] puddles) {
		int answer = 0;
		//각 맵을 오른쪽 아래로 도착한 경우
		matrix = new int[m][n];
		for (int i = 0; i < puddles.length; i++) {
			matrix[puddles[i][0]-1][puddles[i][1]-1] = Integer.MAX_VALUE;
		}
		matrix[0][0] =1;
		bfs(m,n);
		answer = matrix[m-1][n-1];
		return answer;
	}
	private static class xy{
		int x,y;

		public xy(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	private static void bfs(int m, int n) {
		// TODO Auto-generated method stub
		Queue<xy> queue = new LinkedList<>();
		queue.add(new xy(0,0));
		boolean[][] bool = new boolean[m][n];
		int size =0,lx,ly,x,y;
		xy a;
		while(!queue.isEmpty()) {
			size = queue.size();
			for (int i = 0; i < size; i++) {
				a = queue.poll();
				x = a.x;
				y = a.y;
				for (int j = 0; j < 2; j++) {
					lx = x+dx[j];
					ly = y+dy[j];
					if(lx>=0&&ly>=0&&lx<m&&ly<n&&matrix[lx][ly]!=Integer.MAX_VALUE) {
						matrix[lx][ly]+=matrix[x][y];
						matrix[lx][ly] %= 1000000007;
						if(!bool[lx][ly]) {
							bool[lx][ly] = true;
							queue.add(new xy(lx,ly));
						}
					}
				}
			}
			
		}
	}
}
