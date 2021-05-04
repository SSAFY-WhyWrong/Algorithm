package day_0502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BaekJoon_1922 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		boolean[] visited = new boolean[N + 1];
		ArrayList<Node>[] al = new ArrayList[N + 1];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int result = 0;
		int cnt = 0;
		
		for(int i = 0; i < N + 1; i++) {
			al[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			al[a].add(new Node(b, c));
			al[b].add(new Node(a, c));
		}
		
		pq.add(new Node(1, 0));
		
		while(true) {
			Node cur = pq.poll();
			if(visited[cur.v]) continue;
			
			visited[cur.v] = true;
			result += cur.weight;
			cnt++;
			
			for(Node next : al[cur.v]) {
				if(!visited[next.v]) {
					pq.add(next);
				}
			}
			if(cnt == N) {
				break;
			}
		}
		System.out.println(result);
		
	}
	static class Node implements Comparable<Node>{
		int v, weight;
		public Node(int v, int weight) {
			this.v = v;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			
			return this.weight - o.weight;
		}
	}
}
