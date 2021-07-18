import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Programmers_미로_탈출 {
	public static void main(String[] args) {
		int n = 4;
		int start = 1;
		int end = 4;
		int roads[][] = {{1,2,1},{3,2,1},{2,4,1} };
		int traps[] = { 2,3 };
		
		
		solution(n, start, end, roads, traps);

	}

	static class Node implements Comparable<Node> {
		int idx, weight, bit;

		Node(int idx, int weight, int bit) {
			this.idx = idx;
			this.weight = weight;
			this.bit = bit;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}

	static public int solution(int n, int start, int end, int[][] roads, int[] traps) {
		int answer = 0;

		List<Node> edge[] = new ArrayList[n+1];
		List<Node> r_edge[] = new ArrayList[n+1];

		boolean isTrap[] = new boolean[n+1];
		int trap_idx[] = new int[n+1];
		for (int i = 0; i < traps.length; i++) {
			isTrap[traps[i]] = true;
			trap_idx[traps[i]] = i+1;
		}

		for (int i = 1; i <= n; i++) {
			edge[i] = new ArrayList();
			r_edge[i] = new ArrayList();
		}

		for (int i = 0; i < roads.length; i++) {
			int from = roads[i][0];
			int to = roads[i][1];
			int weight = roads[i][2];

			edge[from].add(new Node(to, weight, 0));
			r_edge[to].add(new Node(from, weight, 0));
		}

		int dist[][] = new int[n+1][1 << (traps.length+1)];
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < 1 << (traps.length+1); j++) {
				dist[i][j] = 100000000;
			}
		}

		PriorityQueue<Node> pq = new PriorityQueue();
		pq.add(new Node(start, 0, 0));
		dist[start][0] = 0;

		boolean isReverse = false;
		while (!pq.isEmpty()) {
			Node now = pq.poll();
			if(now.idx == end) {
				System.out.println(now.weight);
				return now.weight;
			}
			
			if (dist[now.idx][now.bit] < now.weight)
				continue;
			
			
			//정방향 있는 경우
			for (Node node : edge[now.idx]) {
				boolean temp = false;
				//현재 위치만 역방향인 경우 혹은 가려는 곳만 역방향이 된 경우
//				System.out.println(now.idx+" "+node.idx);
//				System.out.println((now.bit & 1 << trap_idx[node.idx])==0);
//				System.out.println(Integer.toBinaryString(now.bit));
				if((now.bit & 1 << trap_idx[now.idx])!=0 && (now.bit & 1 << trap_idx[node.idx])==0) continue;
				if((now.bit & 1 << trap_idx[now.idx])==0 && (now.bit & 1 << trap_idx[node.idx])!=0) continue;
				
				
				int bit = now.bit;
				if(isTrap[node.idx]) bit = bit ^ (1 << trap_idx[node.idx]);
				
				if(dist[node.idx][bit] > now.weight + node.weight) {
					dist[node.idx][bit] = now.weight + node.weight;
					pq.add(new Node(node.idx, dist[node.idx][bit], bit));
				}
				
				
			}
			
			//역방향이 있는 경우
			for (Node node : r_edge[now.idx]) {
				boolean temp = false;
				//양 쪽 모두 역방향인 경우, 양쪽 모두 정방향인 경우
				if((now.bit & 1 << trap_idx[now.idx])!=0 && (now.bit & 1 << trap_idx[node.idx])!=0) continue;
				if((now.bit & 1 << trap_idx[now.idx])==0 && (now.bit & 1 << trap_idx[node.idx])==0) continue;
				
				int bit = now.bit;
				if(isTrap[node.idx]) bit = bit ^ (1 << trap_idx[node.idx]);
				
				if(dist[node.idx][bit] > now.weight + node.weight) {
//					System.out.println(now.idx+" -> "+node.idx);
					dist[node.idx][bit] = now.weight + node.weight;
					pq.add(new Node(node.idx, dist[node.idx][bit], bit));
				}
			}
			

		}

		return answer;
	}
}
