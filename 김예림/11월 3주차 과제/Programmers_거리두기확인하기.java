package AlgorithmStudy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Programmers_거리두기확인하기 {
	
	static int[] di = {0,0,-1,1};
	static int[] dj = {-1,1,0,0};
	
	public static void main(String[] args) throws IOException {
		String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
							{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
							{"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
							{"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
							{"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
		
		int[] answer = solution(places);
		
		for(int i=0; i<answer.length; i++) {
			System.out.print(answer[i]+" ");
		}
	}
	
	public static int[] solution(String[][] places) {
		char[][] Class = new char[5][5];
		ArrayList<Integer> ans = new ArrayList<>();
		
		for(int n=0; n<5; n++) {
			String S[] = places[n];
			Queue<Point> q = new LinkedList<>();
			for(int i=0; i<5; i++) {
				String s = S[i];
				for(int j=0; j<5; j++) {
					Class[i][j] = s.charAt(j);
					
					if(Class[i][j]=='P') 
						q.offer(new Point(i, j));
				}
			}
			ans.add(check(q, Class));
		}
		
		int size = ans.size();
		int[] answer = new int[size];
		for(int i=0; i<size; i++) {
			answer[i] = ans.get(i);
		}
		return answer;
		
	}
	private static int check(Queue<Point> q, char[][] Class) {
		boolean away = true;
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			
			for(int d=0; d<4; d++) {
				int ni = cur.i + di[d];
				int nj = cur.j + dj[d];
				if(ni>=0 && ni<5 && nj>=0 && nj<5) {
					if(Class[ni][nj]=='P') away = false;
					else if(Class[ni][nj]=='O') {
						if(ni+1 != cur.i && ni+1<5 && Class[ni+1][nj]=='P') away = false;
						else if(ni-1 != cur.i && ni-1>=0 && Class[ni-1][nj]=='P') away = false;
						else if(nj+1 != cur.j && nj+1<5 && Class[ni][nj+1]=='P') away = false;
						else if(nj-1 != cur.j && nj-1>=0 && Class[ni][nj-1]=='P') away = false;
					}
				}
			}
			if(!away) break;
		}
		if(away) return 1;
		else return 0;
	}
	
	static class Point{
		int i;
		int j;
		public Point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
	}
}
