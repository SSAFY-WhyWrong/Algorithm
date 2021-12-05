import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Programmers_순위 {
	public static void main(String[] args) {
		int n =5;
		int[][] results = {{4,3},{4,2},{3,2},{1,2},{2,5}};
		solution(n,results);
	}
	
    static public int solution(int n, int[][] results) {
        int answer = 0;
        
        int[] win = new int[n];
        int[] lose = new int[n];
        
        List<Integer>[] edge = new ArrayList[n];
        List<Integer>[] rEdge = new ArrayList[n];
        
        
        for(int i=0;i<n;i++) {
        	edge[i] = new ArrayList();
        	rEdge[i] = new ArrayList();
        }
        
        
        for(int i=0;i<results.length;i++) {
        	int a = results[i][0] - 1;
        	int b = results[i][1] - 1;
        	edge[a].add(b);
        	rEdge[b].add(a);
        }
        
        for(int i=0;i<n;i++) {
        	Set<Integer> set = new HashSet<>();
        	dfs(edge,i,set);
        	win[i] = set.size() - 1;
        	set.clear();
        	dfs(rEdge,i,set);
        	lose[i] = set.size() - 1;
        }
        
        for(int i=0;i<n;i++) {
        	if(win[i] + lose[i] == n-1) {
        		answer++;
        	}
        }
        
        System.out.println(answer);
        return answer;
    }
    
    static public void dfs(List<Integer>[] edge, int idx, Set<Integer> set) {
    	set.add(idx);
    	for(int next : edge[idx]) {
    		if(!set.contains(next)) {
    			dfs(edge,next,set);
    		}
    		
    	}
    	
    }
}
