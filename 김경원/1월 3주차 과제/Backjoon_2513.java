import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon_2513 {
	static int S;
	static class Node implements Comparable<Node>{
		int pos, num;
		Node(int pos, int num){
			this.pos = pos;
			this.num = num;
		}
		
		@Override
		public int compareTo(Node o) {
		
			return Math.abs(S- o.pos) - Math.abs(S - this.pos);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N,K;
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken(" "));
		K = Integer.parseInt(st.nextToken(" "));
		S = Integer.parseInt(st.nextToken(" "));
		
		Queue<Node> left = new PriorityQueue<>();
		Queue<Node> right = new  PriorityQueue<>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int pos = Integer.parseInt(st.nextToken(" "));
			int num = Integer.parseInt(st.nextToken(" "));
			
			if(pos < S) {
				left.add(new Node(pos,num));
			}else if(pos > S) {
				right.add(new Node(pos,num));
			}
			
		}
		
		int bus = 0;
		int answer = 0;
		int move = 0;
		while(!left.isEmpty()) {
			Node now = left.poll();
			move = Math.max(move, S -  now.pos);
			if(bus + now.num <= K) {
				bus += now.num;
			}
			else {
				left.add(new Node(now.pos, now.num - (K - bus)));
				answer += move * 2;
				move = 0;
				bus = 0;
			}
			
		}
		answer += move * 2;
		move = 0;
		bus = 0;
		
		while(!right.isEmpty()) {
			Node now = right.poll();
			move = Math.max(move, now.pos - S);
			
			if(bus + now.num <= K) {
				bus += now.num;
			}else {
				right.add(new Node(now.pos, now.num - (K - bus)));
				answer += move*2;
				move = 0;
				bus = 0;
			}
			
		}
		
		answer += move * 2;
		System.out.println(answer);
		
		
	}
}
