import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        LinkedList<Integer> list = new LinkedList<>();
        int size = operations.length;
        
        for(int i=0; i<size; i++) {
            String s = operations[i];
            
            if(s.charAt(0) == 'I') {
                int num = Integer.parseInt(s.substring(2));
                list.add(num);
                Collections.sort(list);
            } else if(!list.isEmpty()) {
                if(s.charAt(2) == '-') {
                    list.removeFirst();
                } else {
                    list.removeLast();
                }
            }
            
        }
        
        if(list.isEmpty()) {
            answer[0] = 0;
            answer[1] = 0;
        } else {
            answer[0] = list.get(list.size()-1);
            answer[1] = list.get(0);
        }
        
        return answer;
    }
}