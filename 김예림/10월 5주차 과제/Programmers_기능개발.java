package M10_5;

import java.util.*;

public class Programmers_기능개발 {
	class Solution {
	    public int[] solution(int[] progresses, int[] speeds) {
	        
	        Queue<Integer> q = new LinkedList<Integer>();
	        
	        for(int i=0; i<progresses.length; i++){
	            if((100-progresses[i])%speeds[i] == 0)
	                q.offer((100-progresses[i])/speeds[i]);
	            else q.offer((100-progresses[i])/speeds[i]+1);
	        }
	        
	        ArrayList<Integer> list = new ArrayList<>();
	        
	        int valid = q.peek();
	        int cnt = 0;
	        
	        while(!q.isEmpty()){
	            if(valid>=q.peek()){
	                cnt++;
	                q.poll();
	            }else{
	                list.add(cnt);
	                valid = q.peek();
	                cnt = 0;
	            }     
	        }
	        list.add(cnt);
	        
	        int listSize = list.size();
	        
	        int[] answer = new int[listSize];
	        
	        for(int i=0; i<listSize; i++){
	            answer[i] = list.get(i);
	        }
	        return answer;
	    }
	}
}
