import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
       boolean visit[] = new boolean[n];
        
        for(int i=0;i<n;i++){
            if(visit[i]) continue;
            bfs(i,visit,computers,n);
            answer++;
        }
            
        
        
        
        return answer;
        
        
        
        
    }
    	static void bfs(int start, boolean[] visit, int[][] computers, int n) {
		Queue<Integer> q = new LinkedList();
		visit[start] = true;
		
		q.add(start);
		int now;
		while(!q.isEmpty()) {
			now = q.poll();
			for(int i=0;i<n;i++) {
				if(computers[now][i] == 1 && !visit[i]) {
					visit[i] = true;
					q.add(i);
				}
			}
		}
	}
}