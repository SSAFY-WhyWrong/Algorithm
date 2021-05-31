import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Backjoon_13160 {
	static class Node implements Comparable<Node>{
		int num,type;
		Node(int num,int type){
			this.num= num;
			this.type = type;
		}
		@Override
		public int compareTo(Node o) {
			if(this.num == o.num)
				return o.type - this.type;
			return this.num -o.num;
		}
	}
	
	static class Graph{
		int i,j;
		Graph(int i,int j){
			this.i = i;
			this.j = j;
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		List<Graph> list = new ArrayList();
		List<Node> line = new ArrayList();
		int now_cnt=0;
		int max_cnt=0;
		int point=0;
				
		
		int N;
		int start,end;
		N = Integer.parseInt(br.readLine());
		
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			
			list.add(new Graph(start,end));
			line.add(new Node(start,1));
			line.add(new Node(end,-1));
		}		
		
		Collections.sort(line);
		
		for(Node node : line) {
			now_cnt += node.type;
			if(now_cnt > max_cnt) {
				max_cnt = now_cnt;
				point = node.num;
			}
		}
		int idx =0 ;
		sb.append(max_cnt).append("\n");
		for(Graph graph : list) {
			idx++;
			if(graph.i <= point && graph.j >= point) {
				sb.append(idx).append(" ");
			}
		}
		
		System.out.println(sb);
		
		
		
		
	}
}
