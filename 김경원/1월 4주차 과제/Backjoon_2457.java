import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Backjoon_2457 {
	
	static class Node implements Comparable<Node> {
		int start, end;
		
		Node(int start, int end){
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Node o) {
			
			return this.start - o.start;
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N;
		
		N = Integer.parseInt(br.readLine());
		
		
		List<Node> list = new ArrayList();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken(" "));
			start = start*100 + Integer.parseInt(st.nextToken(" "));
			int end = Integer.parseInt(st.nextToken(" "));
			end = end*100 + Integer.parseInt(st.nextToken(" "));
			
			if(end > 301){
				Node node = new Node(start,end);
				list.add(node);
			}
			
			
		}
		
		Collections.sort(list);
		int L = list.size();
		int idx = 0;
		
		int next = 0;
		int now = 301;
		int cnt = 0;
		while(idx < L && now <= 1130) {
			while(idx < L && list.get(idx).start <= now) {
				next = Math.max(next, list.get(idx).end);
				idx++;
			}
			
			if(next <= now) {
				break;
			}
			now = next;
			cnt++;
		}
		
		
		if(now <= 1130) {
			cnt = 0;
		}
		
		System.out.println(cnt);
		
	}
}
