package M06_3;

import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        Object[] arr1;
        Object[] arr2;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> rpq =new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<operations.length; i++){
            String[] s = operations[i].split("\\s+");
            int tmp = Integer.parseInt(s[1]);
            
            if(s[0].equals("I")) {
                pq.add(tmp);
                rpq.add(tmp);
            } else if(s[0].equals("D") && !pq.isEmpty()){
                if(tmp == 1) {
                    int rm = rpq.peek();
                    pq.remove(rm);
                    rpq.remove(rm);
                } else if(tmp == -1) {
                    int rm = pq.peek();
                    pq.remove(rm);
                    rpq.remove(rm);
                }
            }
        }
             
        if(!pq.isEmpty()){
            answer[0] = rpq.peek();
            answer[1] = pq.peek();
        }else if(pq.isEmpty()){
            answer[0] = 0;
            answer[1] = 0;
        }
        
        return answer;
    }
}