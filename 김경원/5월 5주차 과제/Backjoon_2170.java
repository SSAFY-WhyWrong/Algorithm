import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Backjoon_2170 {
	
	static class Node implements Comparable<Node>{
		int i,j;
		Node(int i,int j){
			this.i = i;
			this.j = j;
		}
		
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			if(this.i == o.i)
				return this.j - o.j;
			return this.i - o.i;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		List<Node> list = new ArrayList();
		int N;
		
		N = Integer.parseInt(br.readLine());
		int start, end;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken(" "));
			end = Integer.parseInt(st.nextToken(" "));
			if(end < start) {
				int temp = start;
				start = end;
				end = temp;
			}
			
			list.add(new Node(start,end));
		}
		
		Collections.sort(list);

		int result=0;
		start =-1000000000 ; end = -1000000000;
		for(int i=0;i<N;i++) {
			if(end < list.get(i).i) {
				result += end-start;
				start = list.get(i).i;
				end = list.get(i).j;
			}
			else
				end = Math.max(end, list.get(i).j);
		}
		result += end - start;
		System.out.println(result);
	}
}
