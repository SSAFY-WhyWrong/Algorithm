import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Backjoon_14725 {
	
	static public class Node implements Comparable<Node>{
		String name;
		List<Node> leaf = new ArrayList<>();
		Set<String> set = new HashSet<>();
		
		public Node(String name){
			this.name = name;
		}
		
		public Node add(String name) {
			if(!set.contains(name)) {
				set.add(name);
				leaf.add(new Node(name));
				Collections.sort(leaf);
			}
			
			Node next = null;
			
			for(Node node : leaf) {				
				if(name.equals(node.name)) {
					next = node;
					break;
				}
			}
			
			
			return next;
			
		}
		
		
		
		@Override
		public int compareTo(Node o) {
			return name.compareTo(o.name);
		}
		
		
		
		
	}
	
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		HashMap<String, Integer> map = new HashMap<>();
		int idx=0;
		
		
		Node root = new Node("root");
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			
			int M = Integer.parseInt(st.nextToken(" "));
			
			Node now = root;			
			for(int j=0;j<M;j++) {
				String name = st.nextToken(" ");
				now = now.add(name);				
			}
			
			
		}
		print(root,0);
		System.out.println(sb);
		
	}
	
	
	static void print(Node node, int depth) {
		for(int i=1;i<depth;i++) {
			sb.append("--");
		}
		if(depth!=0) {
			sb.append(node.name).append('\n');
		}
		for(Node next : node.leaf) {
			print(next, depth+1);
		}
	}
	
}
