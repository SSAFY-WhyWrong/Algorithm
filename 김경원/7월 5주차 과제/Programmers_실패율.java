import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Programmers_실패율 {
	
	public static void main(String[] args) {
		int N = 5;
		int stages[] = {2,1,2,6,2,4,3,3}; 
		
		solution(N,stages);
		
	}
	
	static class Node implements Comparable<Node>{
		double failure_late;
		int stage_no;
		
		Node(double failure_late, int stage_no){
			this.failure_late = failure_late;
			this.stage_no = stage_no;
		}

		@Override
		public int compareTo(Node o) {
			if(this.failure_late == o.failure_late)
				return this.stage_no - o.stage_no;
			
			else if(this.failure_late > o.failure_late)
				return -1;				
			
			else
				return 1;
		}
	}
	
    static public int[] solution(int N, int[] stages) {
        int[] answer = {};
        
        //실패율 = 스테이지에 도달했으나 클리어하지 못한 플레이어 수 / 스테이지에 도달한 플레이어 수
        //N+1은 마지막 스테이지까지 클리어한 사람 수
        
        int cnt[] = new int[N+2]; //도달한 플레이어 수
        int best[] = new int[N+2]; //최고 스테이지 수
        
        for(int i=0;i<stages.length;i++) {
        	cnt[stages[i]]++;
        	best[stages[i]]++;
        }
        
        for(int i=N+1;i>1;i--) {
        	cnt[i-1] += cnt[i];
        }
        
    
        
        List<Node> list = new ArrayList();
        
        for(int i=1;i<=N;i++) {
        	double failure_late;
        	if(cnt[i]==0)
        		failure_late = 0;
        	else
        		failure_late = (double)best[i] / cnt[i];
        	        	
        	list.add(new Node(failure_late,i));
        }
        
        Collections.sort(list);
        answer = new int[N];
        for(int i=0;i<list.size();i++) {
        	answer[i] = list.get(i).stage_no;
        	System.out.println(answer[i]);
        }
        
        return answer;
    }
}
