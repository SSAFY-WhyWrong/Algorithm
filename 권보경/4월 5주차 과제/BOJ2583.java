package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.security.auth.x500.X500Principal;

public class BOJ2583 {
	
	static int M,N,K,cnt=0;
	static int[][] map;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static ArrayList<Integer> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K= Integer.parseInt(st.nextToken());
		map = new int[M][N];
		list = new ArrayList<Integer>();
		
		for(int k=0; k<K; k++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int y1 = Integer.parseInt(st.nextToken()); //왼쪽 아래 
			int x1 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken()); //오른쪽 위 
			int x2 = Integer.parseInt(st.nextToken());
			
			x1 = Math.abs(M-x1);
			x2 = Math.abs(M-x2);
			
			for(int i=x2; i<x1; i++) {
				for(int j=y1; j<y2; j++) {
					map[i][j] = 1; 
				}
			}
		}
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]== 0) {
					cnt++;
					
					int tmp = 0;
					//bfs
					Queue<Point> queue = new LinkedList<>();
					queue.add(new Point(i, j));
					map[i][j] = 1;
					
					while(!queue.isEmpty()) {
						Point now = queue.poll();
						tmp++;
						
						for(int d=0; d<4; d++) {
							int nx = now.x + dx[d];
							int ny = now.y + dy[d];
							
							if(0>nx || 0>ny || nx >=M || ny>=N) continue;
							if(map[nx][ny] != 0) continue;
							
							queue.add(new Point(nx, ny));
							map[nx][ny] = 1;
						}
					}
					
					list.add(tmp);
				}
			}
		}
		Collections.sort(list);
		
		System.out.println(cnt);
		for(int a : list) {
			System.out.print(a + " ");
		}
		System.out.println();
		
	}

	public static class Point {
		int x, y;
		
		public Point(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
}
