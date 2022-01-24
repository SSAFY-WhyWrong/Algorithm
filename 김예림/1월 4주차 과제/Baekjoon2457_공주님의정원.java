package AlgorithmStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baekjoon2457_공주님의정원 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		ArrayList<Flower> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int d1 = Integer.parseInt(st.nextToken());
			int d2 = Integer.parseInt(st.nextToken());
			int d3 = Integer.parseInt(st.nextToken());
			int d4 = Integer.parseInt(st.nextToken());

			int start = d1*100+d2;
			int end = d3*100+d4;
			
			list.add(new Flower(start, end));
		}
		Collections.sort(list);
		
		int theStart = 301; //3월1일
		int theEnd = 1201; //12월1일
		int maxDay = 0;
		int cnt = 0;
		int idx = 0; //어디까지 탐색했는지 가지치기를 하기 위한 인엑스 값
		
		while(true) {
			
			if(theStart >= theEnd) break;
			
			boolean flag = false; //조건을 만족하는 꽃이 있는지 검사
			for(int i=idx; i<N; i++) {
				if(list.get(i).start > theStart) break;
				
				if(maxDay < list.get(i).end) {
					flag = true;
					maxDay = list.get(i).end;
					idx = i+1;
				}
			}
			if(!flag) break;
			
			theStart = maxDay;
			cnt++;
		}
		if(maxDay < theEnd) System.out.println(0);
		else System.out.println(cnt);
		
	}
	static class Flower implements Comparable<Flower>{
		int start;
		int end;
		public Flower(int start, int end) {
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Flower o) {
			if(this.start==o.start) return o.end-this.end;
			return this.start-o.start;
		}
	}
}
