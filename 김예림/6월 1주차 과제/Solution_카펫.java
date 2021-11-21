package M05_5;

import java.util.*;

class Solution_카펫{
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int end = yellow;
        
        int idx = 1;
        while(true){
            if(yellow%idx == 0){
                int h = idx;
                int w = yellow/idx;
                
                int total = 2*h + 2*w + 4;
                if(total == brown) {
                    answer[0] = w+2;
                    answer[1] = h+2;
                    break;
                }
                
                end = yellow/idx;
            }
            idx++;
            if(idx>end) break;
        }        
        return answer;
    }
}