package B2583영역구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int r, c, n;
	static int [][]arr, map;
	static int []di = {1,0,-1,0};
	static int []dj = {0,1,0,-1};
	static ArrayList<Integer> res = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new int[r][c];
		for(int k = 0; k < n; k++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			for(int i = y1; i < y2; i++) {
				for(int j = x1; j < x2; j++) {
					map[i][j] = 1;
				}
			}
		}
		
		int num = 1;
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(map[i][j] == 0) {
					num++;
					map[i][j] = num ;
					BFS(i, j, num);
					
				}
			}
		}
		System.out.println(num - 1);
		StringBuilder sb= new StringBuilder();
		Collections.sort(res);
		for(int i = 0; i < res.size(); i++) {
			sb.append(res.get(i) + " ");
		}
		System.out.println(sb.toString());
		
//		for(int i = 0; i <= r; i++) {
//			for(int j = 0; j <= c; j++) {
//				System.out.print(arr[i][j]);
//			}
//			System.out.println();
//		}
//		System.out.println();
//		for(int i = 0; i < map.length; i++) {
//			for(int j = 0; j < map[i].length; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
//		System.out.println();
	}
	private static void BFS(int y, int x, int num) {
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(y, x));
		int rs = 1;
		while(!q.isEmpty()) {
			Pair s = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int yy = s.y + di[i];
				int xx = s.x + dj[i];
				if(yy < 0 || xx < 0 || yy >= r || xx >= c || map[yy][xx] > 0)continue;
				map[yy][xx] = num ;
				q.add(new Pair(yy, xx));
				rs++;
			}
		}
		res.add(rs);
	}
	
}
class Pair{
	int y;
	int x;
	Pair(int y, int x){
		this.y = y;
		this.x = x;
	}
}
