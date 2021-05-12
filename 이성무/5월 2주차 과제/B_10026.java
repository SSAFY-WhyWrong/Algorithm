package 실패;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
//
public class B_10026 {
	static int N;
	static int num = 1;
	static Queue<xy> queue;
	static int[][] map;
	static char[][] cmap;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	private static class xy{
		int x,y;

		public xy(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		cmap = new char[N][N];
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			cmap[i] = br.readLine().toCharArray();
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				bfs(i,j);
			}
		}
		sb.append((num-1)+" ");
		num = 1;
		map = new int[N][N];
		colorChange();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				bfs(i,j);
			}
		}
		sb.append((num-1));
		System.out.println(sb);
	}
	
	private static void bfs(int i, int j) {
		if(map[i][j]!=0)return;
		
		queue = new LinkedList<>();
		queue.add(new xy(i,j));
		map[i][j] = num;
		xy a;
		int x,y,lx,ly;
		char color = cmap[i][j];
		while(!queue.isEmpty()) {
			a = queue.poll();
			x = a.x;
			y = a.y;
			for (int d = 0; d < 4; d++) {
				lx = x+dx[d];
				ly = y+dy[d];
				if(lx>=0&&ly>=0&&lx<N&&ly<N&&map[lx][ly]==0&&cmap[lx][ly]==color) {
					queue.add(new xy(lx,ly));
					map[lx][ly] = num;
				}
			}
		}
		
		num++;
	}
	private static void colorChange() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(cmap[i][j]=='R')cmap[i][j] = 'G';
			}
		}
	}

}
