import java.util.*;
import java.io.*;

public class 백준_1197_최소스패닝트리_크루스칼 {

	public static int[] parent;
	
	public static class Node implements Comparable<Node> {
		int now;
		int weight;
		int next;
		
		public Node(int now, int next, int weight) {
			this.now = now;
			this.weight = weight;
			this.next = next;
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
		
		Node[] nodes = new Node[E];
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(bf.readLine());
		
			nodes[i] = new Node(Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(nodes);
		
		parent = new int[V+1];
		for(int i=1;i<V+1;i++) {
			parent[i] = i;
		}
		
		long answer = 0;
		for(int i=0;i<E;i++) {
			if(findParent(nodes[i].now, nodes[i].next)) continue;
			
			answer += nodes[i].weight;
			unionParent(nodes[i].now, nodes[i].next);
		}
		
		System.out.println(answer);
	}
	
	// 부모를 찾는 함수
	public static int getParent(int x) {
		if(parent[x] == x) return x;
		return parent[x] = getParent(parent[x]);
	}
	
	// 두 부모 노드 합치기
	public static void unionParent(int a, int b) {
		a = getParent(a);
		b = getParent(b);
		
		if(a < b) {
			parent[b] = a;
		} else {
			parent[a] = b;
		}
	}
	
	// 부모 같은 지 확인
	public static boolean findParent(int a, int b) {
		a = getParent(a);
		b = getParent(b);
		
		if(a == b) return true;
		
		return false;
	}
}
