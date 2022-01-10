package AlgorithmStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon2573_빙산 {

	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int[][] iceberg,melt,years;
	static int N, M, y, ice;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		iceberg = new int[N][M];

		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<M; j++) {
				int h = Integer.parseInt(st.nextToken());

				iceberg[i][j] = h;
			}
		}

		melt = new int[N][M]; //1년마다 녹아내리는 높이의 수 저장하는 배열
		years = new int[N][M];

		y = 0;
		while(true) {
			y++; //1년씩 늘어나요~!
			int cnt = 0; //몇 개의 빙산 덩어리가 생겼는지
			ice = 0;
			Sea();

			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(iceberg[i][j]>0) {
						iceberg[i][j] -= melt[i][j];
						if(iceberg[i][j] <= 0) {
							ice--;
							iceberg[i][j] = 0;
						}
					}
				}
			}
			if(ice <= 0) { //두 개의 빙산으로 나눠지지 않고 빙산이 전부 그대로 사라져 버릴 경우 break문!!!
				y = 0;
				break;
			}
			//빙산이 녹았다 이제 넣어보자
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(iceberg[i][j]>0 && years[i][j]<y) {
						Search(i, j);
						cnt++; //빙산 개수가 늘어나요옵
					}
				}
			}

			if(cnt >= 2) break;
		}
		System.out.println(y);
	}
	public static void Search(int i, int j) {

		Queue<Point> q = new LinkedList<Point>();
		q.offer(new Point(i,j));
		years[i][j] = y;

		while(!q.isEmpty()) {
			Point cur = q.poll();

			for(int d=0; d<4; d++) {
				int ni = cur.i + di[d];
				int nj = cur.j + dj[d];
				if(ni>=0 && ni<N && nj>=0 && nj<M && iceberg[ni][nj]>0 && years[ni][nj]<y) {
					q.offer(new Point(ni, nj));
					years[ni][nj] = y;
				}
			}
		}

	}
	public static void Sea() {

		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				melt[i][j] = 0; //melt 배열 초기화!!! 매우 중요!!!
				if(iceberg[i][j]>0) {
					ice++;
					for(int d=0; d<4; d++) {
						int ni = i + di[d];
						int nj = j + dj[d];
						if(ni>=0 && ni<N && nj>=0 && nj<M && iceberg[ni][nj]<=0) {
							melt[i][j]++;
						}
					}
				}
			}
		}

	}
	static class Point{
		int i;
		int j;
		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}
/*
5 7
0 0 0 0 0 0 0
0 4 4 4 4 0 0
0 4 0 4 4 4 0
0 4 4 4 4 0 0
0 0 0 0 0 0 0

5 7
0 0 0 0 0 0 0
0 4 4 4 4 0 0
0 4 0 0 4 0 0
0 4 4 4 4 0 0
0 0 0 0 0 0 0

이게 반복문에서 빠져나오지를 못함
 */
