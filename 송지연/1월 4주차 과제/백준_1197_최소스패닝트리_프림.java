import java.util.*;
import java.io.*;

public class 백준_1197_최소스패닝트리_프림 {

	static class Node implements Comparable<Node>{
		int edge;
		int weight;
		
		public Node(int edge, int weight) {
			this.edge = edge;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		
		ArrayList<Node>[] nodes = new ArrayList[V+1];
		for(int i=1;i<V+1;i++) {
			nodes[i] = new ArrayList<>();
		}
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(bf.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			nodes[A].add(new Node(B, C));
			nodes[B].add(new Node(A, C));
		}
		
		long answer = 0;
		boolean[] visit = new boolean[V+1];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(1, 0));
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(visit[now.edge]) continue;
			
			answer += now.weight;
			visit[now.edge] = true;
			
			for(int i=0;i<nodes[now.edge].size();i++) {
				Node next = nodes[now.edge].get(i);
				if(!visit[next.edge]) {
					pq.add(next);
				}
			}
		}
		
		System.out.println(answer);
	}

}
