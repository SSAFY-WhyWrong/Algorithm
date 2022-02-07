import java.util.*;
import java.io.*;

public class 백준_2457_공주님의정원 {

	private static PriorityQueue<Flower> pq;
	
	static class Flower implements Comparable<Flower>{
		int start;
		int end;
		
		public Flower(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public String toString() {
			return "Flower [start=" + start + ", end=" + end + "]";
		}

		@Override
		public int compareTo(Flower o) {
			if(this.start == o.start) return o.end - this.end;
			return this.start - o.start;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		Flower[] flowers = new Flower[N];
		pq = new PriorityQueue<>();
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int start = Integer.parseInt(st.nextToken()) * 100 + Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken()) * 100 + Integer.parseInt(st.nextToken());
			
			flowers[i] = new Flower(start, end);
			pq.add(new Flower(start, end));
		}
		
		Arrays.sort(flowers);
		
		int stdStart = 301, stdEnd = 1201;
		int answer = 0, idx = 0, standard = 0;
		
		while(stdStart < stdEnd) {
		
			for(int i=idx;i<N;i++) {
				if(flowers[i].start > stdStart) break;
				
				if(standard < flowers[i].end) {
					standard = flowers[i].end;
					idx = i+1;
				}
			}
			
			if(stdStart == standard) break;
			
			stdStart = standard;
			answer++;
		}
		
		if(stdStart < stdEnd) {
			System.out.println(0);
		} else {
			System.out.println(answer);
		}
	}

}
