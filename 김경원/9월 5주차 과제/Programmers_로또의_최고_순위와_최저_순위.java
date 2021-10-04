import java.util.HashSet;
import java.util.Set;

public class Programmers_로또의_최고_순위와_최저_순위 {
	public static void main(String[] args) {
		
		
		
	}
	
	 static public int[] solution(int[] lottos, int[] win_nums) {
	        int[] answer = new int[2];
	        int rank[] = {6,6,5,4,3,2,1};
	        
	        int zeroCnt = 0;
	        int sameCnt = 0;
	        Set<Integer> set = new HashSet();
	        
	        
	        for(int i=0;i<6;i++) {
	        	if(lottos[i] == 0) {
	        		zeroCnt++;
	        		continue;
	        	}
	        	
	        	set.add(lottos[i]);
	        }
	        
	        
	        
	        
	        for(int i=0;i<6;i++) {
	        	if(set.contains(win_nums[i])) {
	        		sameCnt++;
	        	}
	        }
	        
	        
	        answer[0] = rank[zeroCnt + sameCnt];
	        answer[1] = rank[sameCnt];
	        
	        System.out.println(answer[0]+" "+answer[1]);
	        
	        return answer;
	    }
}
