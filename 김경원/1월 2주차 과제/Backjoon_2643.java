import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Backjoon_2643 {
	static public class Paper implements Comparable<Paper> {
		int x,y;
		
		public Paper(int x,int y) {
			if(x  >=  y) {
				this.x = x;	
				this.y = y;
			}else {
				this.x = y;
				this.y = x;
			}
		}
		
		@Override
		public int compareTo(Paper o) {
			
			if(this.x == o.x) {
				return this.y - o.y;
			}
			
			return this.x - o.x;
		}
		
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		int N = Integer.parseInt(br.readLine());
		List<Paper> papers = new ArrayList();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken(" "));
			int y = Integer.parseInt(st.nextToken(" "));
			papers.add(new Paper(x,y));
		}
		Collections.sort(papers);
		
		int answer = 1;
		int[] dp = new int[N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<i;j++) {
				if(papers.get(i).x >= papers.get(j).x && papers.get(i).y >= papers.get(j).y) {
					dp[i] = Math.max(dp[i], dp[j]);
				}
			}
			dp[i]++;
			answer = Math.max(dp[i],answer);
		}
		
		System.out.println(answer);
		
	}
}
