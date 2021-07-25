import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Programmers_배달 {
	public static void main(String[] args) {

		int N = 5;
		int[][] road = { { 1, 2, 1 }, { 2, 3, 3 }, { 5, 2, 2 }, { 1, 4, 2 }, { 5, 3, 1 }, { 5, 4, 2 } };
		int K = 3;
		solution(N, road, K);
	}
	
	static class Node implements Comparable<Node> {
		int idx,weight;
		
		
		Node(int idx,int weight){
			this.idx = idx;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			
			return this.weight - o.weight;
		}
		
	}

	static public int solution(int N, int[][] road, int K) {
		int answer = 0;
		
		
		
		
		List<Node> edge[] = new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			edge[i] = new ArrayList();
		}
		
		for(int i=0;i<road.length;i++) {
			int from = road[i][0];
			int to = road[i][1];
			int weight = road[i][2];
			
			edge[from].add(new Node(to,weight));
			edge[to].add(new Node(from,weight));
		}
		
		int dist[] = new int[N+1];
		for(int i=1;i<=N;i++) {
			dist[i] = 100000;
		}
		
		
		PriorityQueue<Node> pq = new PriorityQueue();
		pq.add(new Node(1,0));
		dist[1] = 0;
		
		
		
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(now.weight  > dist[now.idx]) continue;
			
			
			
			for(Node node : edge[now.idx]) {
				if(node.weight + dist[now.idx]<dist[node.idx]) {
					dist[node.idx]= node.weight + dist[now.idx];
					pq.add(new Node(node.idx,dist[node.idx]));
				}
			}
		}
		
		
		for(int i=1;i<=N;i++) {
			if(dist[i]<=K)
				answer++;
		}
		
		System.out.println(answer);

		return answer;
	}
}
