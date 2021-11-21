package M06_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_16197_두동전 {

	static int N, M;
	static int[][] map;
	static Queue<Coin> q;
	static int[] di = {0,0,-1,1};
	static int[] dj = {-1,1,0,0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		q = new LinkedList<Coin>();

		map = new int[N][M];
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				if(s.charAt(j)=='#') map[i][j] = -1;
				else if(s.charAt(j)=='o') q.offer(new Coin(i, j));
			}
		}

		for(int i=0; i<2; i++) {
			Coin current = q.poll();
			bfs(current.i, current.j);
		}

		int min = Integer.MAX_VALUE;

		for(int i=0; i<N; i++) {
			if(map[i][0]!=-1 && map[i][0]!=0)
				min = Math.min(map[i][0], min);
			if(map[i][M-1]!=-1 && map[i][M-1]!=0)
				min = Math.min(map[i][M-1], min);
		}

		for(int j=0; j<M; j++) {
			if(map[0][j]!=-1 && map[0][j]!=0)
				min = Math.min(map[0][j], min);
			if(map[N-1][0]!=-1 && map[N-1][0]!=0)
				min = Math.min(map[N-1][j], min);
		}
		if(min == Integer.MAX_VALUE || min>10) System.out.println(-1);
		else System.out.println(min+1);

	}

	private static void bfs(int i, int j) {

		Queue<Coin> drop = new LinkedList<Coin>();
		drop.offer(new Coin(i,j));

		int cnt = 1;

		while(!drop.isEmpty()) {

			int size = drop.size();

			for(int s=0; s<size; s++) {
				Coin cur = drop.poll();

				for(int d=0; d<4; d++) {
					int ni = cur.i + di[d];
					int nj = cur.j + dj[d];
					if(ni>=0 && nj>=0 && ni<N && nj<M && map[ni][nj]!=-1) {
						if(map[ni][nj]>0) map[ni][nj] = Math.min(map[ni][nj], cnt);
						else map[ni][nj] = cnt;
					}
				}
			}
			cnt++;
		}
		return;
	}


	static class Coin{
		int i;
		int j;
		public Coin(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}
