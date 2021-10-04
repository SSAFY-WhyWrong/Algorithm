import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Backjoon_2887 {
	
	static int root[];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N;
		
		N = Integer.parseInt(br.readLine());
		
		root = new int[N];
		
		List<Node> nodes = new ArrayList();
		List<Edge> edges = new ArrayList();
		
		for(int i=0;i<N;i++) {
			
			root[i] = i;
			
			st = new StringTokenizer(br.readLine());
			int x,y,z;
			x = Integer.parseInt(st.nextToken(" "));
			y = Integer.parseInt(st.nextToken(" "));
			z = Integer.parseInt(st.nextToken(" "));
			
			nodes.add(new Node(x,y,z,i));			
		}
		
		
		
		
//		for(int i=0;i<N;i++) {
//			for(int j=i+1;j<N;j++) {
//				int dist = Math.min(Math.abs(nodes.get(i).x - nodes.get(j).x), Math.min(Math.abs(nodes.get(i).y - nodes.get(j).y), Math.abs(nodes.get(i).z - nodes.get(j).z)));
//				edges.add(new Edge(i,j,dist));
//			}
//		}
		
		Collections.sort(nodes, (node1, node2)-> node1.x - node2.x);
		for(int i=0;i<N-1;i++) {
			System.out.println(nodes.get(i).num+" "+nodes.get(i+1).num);
			edges.add(new Edge(nodes.get(i).num,nodes.get(i+1).num,Math.abs(nodes.get(i).x - nodes.get(i+1).x)));
		}
		
		Collections.sort(nodes, (node1, node2)-> node1.y - node2.y);
		for(int i=0;i<N-1;i++) {
			edges.add(new Edge(nodes.get(i).num,nodes.get(i+1).num,Math.abs(nodes.get(i).y - nodes.get(i+1).y)));
		}
		
        Collections.sort(nodes, (node1, node2)-> node1.z - node2.z);
		for(int i=0;i<N-1;i++) {			
			edges.add(new Edge(nodes.get(i).num,nodes.get(i+1).num,Math.abs(nodes.get(i).z - nodes.get(i+1).z)));
		}
		

		Collections.sort(edges);

		
		int cnt = N;
		int idx=0;
		long result = 0;
		
		for(int i=0;i<edges.size();i++){
			Edge edge = edges.get(i);
			if(union(edge.from, edge.to)) {
				result += edge.dist;
			}
			
		}
		
		System.out.println(result);
		
		
	}
	
	static class Edge implements Comparable<Edge>{
		int from, to, dist;
		
		Edge(int from, int to, int dist){
			this.from = from;
			this.to = to;
			this.dist = dist;
		}

		@Override
		public int compareTo(Edge o) {
			return this.dist - o.dist;
		}
	}
	
	
	static class Node{
		int x,y,z, num;
		Node(){}
		Node(int x, int y, int z, int num){
			this.x = x;
			this.y = y;
			this.z = z;
            this.num = num;
		}
	}
	
	static public int getRoot(int x) {
		
		if(root[x]==x)
            return x;		
		
		return root[x] = getRoot(root[x]);
	}
	
	static public boolean union(int x,int y) {
		
		int xRoot = getRoot(x);
		int yRoot = getRoot(y);
		
		if(xRoot == yRoot)
			return false;
        
		
		
		root[xRoot] = Math.min(xRoot, yRoot);
		root[yRoot] = root[xRoot];
		
		
		
		return true;
	}
	
	
	
	
}
