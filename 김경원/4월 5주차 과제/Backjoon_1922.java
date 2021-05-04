import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Backjoon_1922 {
	static class Node implements Comparable<Node> {
		int from, to, weight;
		Node(){}
		Node(int from, int to, int weight){
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			
			return this.weight - o.weight;
		}
	}
	static int N,M;
	static List<Node> edge;
	
	static int parent[];
	
	static int findSet(int i) {
		if(parent[i]==i)
			return i;
		return parent[i] = findSet(parent[i]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot)
			return false;
		else {
			parent[bRoot] = aRoot;
			return true;
		}
		
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int from,to,weight;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken(" "));
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken(" "));
		
		edge = new ArrayList();
		
		parent = new int[N+1];
		for(int i=1;i<=N;i++)
			parent[i] = i;
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken(" "));
			to = Integer.parseInt(st.nextToken(" "));
			weight = Integer.parseInt(st.nextToken(" "));
			
			edge.add(new Node(from,to,weight));
		}
		
		Collections.sort(edge);
		
		int cnt=0;
		int result=0;
		
		for(int i=0;i<edge.size();i++) {
			if(cnt == N-1) break;
			from = edge.get(i).from;
			to = edge.get(i).to;
			weight = edge.get(i).weight;
			
			
			if(union(from,to)) {
				result += weight;
				cnt++;
			}
			
			
			
		}
		System.out.println(result);

		
	}
}
