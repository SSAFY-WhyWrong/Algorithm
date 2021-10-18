package M10_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon13904_과제 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Work> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			list.add(new Work(d, s));
		}
		int tot = 0;
		for(int i=N; i>=1; i--) {
			int max = 0, idx = 0;
			int size = list.size();
			for(int s=0; s<size; s++) {				
				if(list.get(s).day>=i) {
					if(max < list.get(s).score) {
						idx = s;
						max = list.get(s).score;
					}
				}
			}
			tot += max;
			if(max!=0) list.remove(idx);
		}
		System.out.println(tot);
	}
	
	
	static class Work{
		int day;
		int score;
		public Work(int day, int score) {
			this.day = day;
			this.score = score;
		}
	}
	
}
