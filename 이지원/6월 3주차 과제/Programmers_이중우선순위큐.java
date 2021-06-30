package day_0622;

import java.util.*;

public class Programmers_이중우선순위큐 {
	class Solution {
	    public int[] solution(String[] operations) {
	        int[] answer = new int[2];
	        
	        PriorityQueue<Integer> pql = new PriorityQueue<>();
	        PriorityQueue<Integer> pqh = new PriorityQueue<>(Collections.reverseOrder());
	        StringTokenizer st = null;
	        for(int i = 0; i < operations.length; i++){
	            st = new StringTokenizer(operations[i], " ");
	            String temp = st.nextToken();
	            if(temp.equals("I")){
	                temp = st.nextToken();
	                pql.add(Integer.parseInt(temp));
	                pqh.add(Integer.parseInt(temp));
	            } else if(temp.equals("D")){
	                String tmp = st.nextToken();
	                if(tmp.equals("1")){
	                    pql.remove(pqh.poll());
	                } else if(tmp.equals("-1")){
	                    pqh.remove(pql.poll());
	                }
	            }
	        }
	        if(pqh.size() != 0 && pql.size() != 0){
	            answer[0] = pqh.poll();
	            answer[1] = pql.poll();
	        }
	        
	        return answer;
	    }
	}
}
