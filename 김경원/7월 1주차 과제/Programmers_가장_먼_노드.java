import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Programmers_가장_먼_노드 {
	public static void main(String[] args) {
		int n = 6;
		int edge[][] = {{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}};
		solution(n,edge);
		
	}
    static public int solution(int n, int[][] edge) {
        int answer = 0;
        
        
        boolean visit[] = new boolean[n+1];
        Queue<Integer> q = new LinkedList();
        
        int edge_length = edge.length;
        
        
        List<Integer> edge_list[] = new ArrayList[edge_length+1];
        for(int i=1;i<=edge_length;i++)
        	edge_list[i] = new ArrayList();
        
        for(int i=0;i<edge_length;i++) {
        	edge_list[edge[i][0]].add(edge[i][1]);
        	edge_list[edge[i][1]].add(edge[i][0]);
        }
        
        
        visit[1] = true;
        q.add(1);
        
        int q_cnt;        
        while(!q.isEmpty()) {
        	
        	q_cnt = q.size();
        	answer = q_cnt;
        	for(int i=0;i<q_cnt;i++) {
        		int now = q.poll();
        		for(int num : edge_list[now]) {
        			if(!visit[num]) {
        				visit[num] = true;
        				q.add(num);
        			}
        		}
        	}
        }
        System.out.println(answer);
        
        return answer;
    }
}
