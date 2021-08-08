package M08_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baekjoon_17140_이차원배열과연산 {
	
	static int row, column, sumCnt;
	static int[][] map;
	static int[] Check;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		map = new int[101][101];
		for(int i=1; i<4; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=1; j<4; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		row = 3; //행
		column = 3; //열
		sumCnt = 0; //연산횟수
		
		while(true) {
			
			if(map[r][c] == k) break;
			if(row >= column) {
				//R연산 map 갱신 후 column max값으로 갱신
				sortR();
			}else {
				//C연산 map 갱신 후 row max값으로 갱신
				sortC();
			}
			sumCnt++;
			if(sumCnt > 100) {
				sumCnt = -1;
				break;
			}
		}
		System.out.println(sumCnt);
	}
	
	private static void sortC() {
		
		int tmpRow = 0;
		
		for(int i=1; i<=column; i++) {
			Check = new int[101];
			for(int j=1; j<=row; j++) {
				Check[map[j][i]]++;
			}
			ArrayList<SortNum> list = new ArrayList<>();
			int tmp = 0;
			for(int n=1; n<101; n++) {
				if(Check[n]!=0) {
					tmp++;
					list.add(new SortNum(n, Check[n]));
				}
			}
			Collections.sort(list);
			for(int j=1; j<=tmp; j++) {
				map[j*2-1][i] = list.get(j-1).num;
				map[j*2][i] = list.get(j-1).cnt;
			}
			for(int j=tmp*2+1; j<101; j++) {
				if(map[j][i]!=0) map[j][i] = 0;
			}
			tmpRow = Math.max(tmpRow, tmp*2);
		}
		row = tmpRow;
		if(row>101) row = 101;
	}

	private static void sortR() {
		
		int tmpCol = 0;
		
		for(int i=1; i<=row; i++) {
			Check = new int[101];
			for(int j=1; j<=column; j++) {
				Check[map[i][j]]++;
			}
			ArrayList<SortNum> list = new ArrayList<>();
			int tmp = 0;
			for(int n=1; n<101; n++) {
				if(Check[n]!=0) {
					tmp++;
					list.add(new SortNum(n, Check[n]));
				}
			}
			Collections.sort(list);
			for(int j=1; j<=tmp; j++) {
				map[i][j*2-1] = list.get(j-1).num;
				map[i][j*2] = list.get(j-1).cnt;
			}
			for(int j=tmp*2+1; j<101; j++) {
				if(map[i][j]!=0) map[i][j] = 0;
			}
			tmpCol = Math.max(tmpCol, tmp*2);
		}
		column = tmpCol;
		if(column>101) column = 101;
	}

	static class SortNum implements Comparable<SortNum>{
		int num, cnt;
		public SortNum(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(SortNum o) {
			if(this.cnt != o.cnt) return this.cnt-o.cnt; //나오는 횟수가 작은 순 대로
			else return this.num-o.num; //작은순서로 배열
		}
	}
}
