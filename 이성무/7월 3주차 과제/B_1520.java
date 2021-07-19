package 실패;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_1520 {
	private static class xy implements Comparable<xy>{
		int x,y,val;

		public xy(int x, int y, int val) {
			super();
			this.x = x;
			this.y = y;
			this.val = val;
		}

		@Override
		public int compareTo(xy o) {
			// TODO Auto-generated method stub
			return o.val - this.val;
		}
		
	}
	private static int M,N;
	private static int[][] map,answer;
	private static PriorityQueue<xy> queue;
	private static int[] dx = {-1,1,0,0};
	private static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		answer = new int[M][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		queue = new PriorityQueue<>();
		queue.add(new xy(0,0,map[0][0]));
		answer[0][0] = 1;
		xy a;
		int lx,ly,x,y,val;
		while(!queue.isEmpty()) {
			a = queue.poll();
			x = a.x;
			y = a.y;
			val = a.val;
			for (int i = 0; i < 4; i++) {
				lx = x+dx[i];
				ly = y+dy[i];
				if(lx>=0&&ly>=0&&lx<M&&ly<N&&map[lx][ly]<val) {
					if(answer[lx][ly]==0) {
						queue.add(new xy(lx,ly,map[lx][ly]));						
					}
					answer[lx][ly] += answer[x][y];
				}
			}
		}
		System.out.println(answer[M-1][N-1]);
		
	}

}
