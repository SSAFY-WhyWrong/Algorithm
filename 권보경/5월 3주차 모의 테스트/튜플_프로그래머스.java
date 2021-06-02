import java.util.*;

class Solution {
    static int size = 0;
    static Map<String,Integer> tuple = new HashMap<>();
    public int[] solution(String s) {
        
        
        getNum(s);
        
        int[] answer = new int[tuple.size()-1];
        int idx = 0;
        for(int i=tuple.size()-1; i>=0; i--) {
            for(Map.Entry<String, Integer> entry : tuple.entrySet()) {
                if(entry.getValue() == i)
                    // System.out.println(entry.getKey());
                    answer[idx++] = Integer.parseInt(entry.getKey());
            }
        }
        return answer;
    }
    
    public void getNum(String s) {
        
        String tmp = "";
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                tmp += c;
            } else {
                setNum(tmp);
                tmp = "";
            }
        }
    }
    
    public void setNum(String tmp) {
        if(tuple.containsKey(tmp)) { //이미 있는 원소라면 
            tuple.put(tmp, tuple.get(tmp)+1);
        } else { //새로운 원소라면 
            tuple.put(tmp,0);
        }
    }
}