package AlgorithmStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon1689_겹치는선분 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Line> pq = new PriorityQueue<>();
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			
			pq.offer(new Line(num1,1));
			pq.offer(new Line(num2, -1));
		}
		
		int cnt = 0;
		int max = 0;
		for(int i=0; i<N; i++) {
			Line cur = pq.poll();
			cnt += cur.put;
			System.out.println(cnt);
			max = max<cnt?cnt:max;
		}
		
		System.out.println(max);
	}
	
	static class Line implements Comparable<Line>{
		int num;
		int put;
		public Line(int num, int put) {
			this.num = num;
			this.put = put;
		}
		@Override
		public int compareTo(Line o) {
			if(this.num == o.num) return this.put-o.put; //같은 숫자인 경우 end는 미포함이라 빼는거 먼저 해야됨
			return this.num-o.num;
		}
	}
}
