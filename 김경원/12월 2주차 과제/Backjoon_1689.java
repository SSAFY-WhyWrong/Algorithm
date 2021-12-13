import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Backjoon_1689 {
	
	static public class Node implements Comparable<Node>{
		int pos,num;
		Node(int pos, int num){
			this.pos = pos;
			this.num = num;
		}
		@Override
		public int compareTo(Node o) {			
			if(this.pos == o.pos) {
				return this.num - o.num;
			}
			return this.pos - o.pos;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N;
		
		N = Integer.parseInt(br.readLine());
		
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken(" "));
			int end = Integer.parseInt(st.nextToken(" "));
			
			pq.add(new Node(start,1));
			pq.add(new Node(end, -1));
			
			
		}
		
		int result = 0;
		int now = 0;
		
		while(!pq.isEmpty()) {
			
			now += pq.peek().num;
			pq.poll();
			result = Math.max(now, result);
			
		}
		
		System.out.println(result);
		
	}
}
