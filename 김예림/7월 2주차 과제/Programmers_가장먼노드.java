package M07_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Programmers_가장먼노드 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int len = Integer.parseInt(br.readLine());
		
		int[][] edge = new int[len][2];
		
		for(int i=0; i<len; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<2; j++) {
				edge[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(Solution(n, edge));
		
	}
	
	private static int Solution(int n, int[][] edge) {
		
		int answer = 0;
		
		boolean[] visited = new boolean[n+1];
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		
		for(int i=0; i<=n; i++) {
			list.add(new ArrayList<>());
		}
		for(int i=0; i<edge.length; i++) {
			int from = edge[i][0];
			int to = edge[i][1];
			
			list.get(from).add(to);
			list.get(to).add(from);
		}
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		visited[1] = true;
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			for(int i=0; i<size; i++) {
				answer = size;
				int cur = q.poll();
				
				for(int j=0; j<list.get(cur).size(); j++) {
					int tmp = list.get(cur).get(j);
					if(!visited[tmp]) {
						q.offer(tmp);
						visited[tmp] = true;
					}
				}
				
			}
		}
		
		
		return answer;
		
	}
}
