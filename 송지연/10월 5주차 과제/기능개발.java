import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> work = new LinkedList<>();
        
        for(int i=0;i<progresses.length;i++) {
            int days = (int)Math.ceil((100.0 - progresses[i])/speeds[i]);
            work.add(days);
        }
        
        int maxWorkDays = (!work.isEmpty())?work.poll():-1;
        int cnt = 1;
        Queue<Integer> answerTmp = new LinkedList<>();
        while(!work.isEmpty()) {
            int workDays = work.poll();
            
            if(maxWorkDays >= workDays) {
                cnt++;
            } else {
                answerTmp.add(cnt);
                cnt = 1;
                maxWorkDays = workDays;
            }
        }
        
        answerTmp.add(cnt);
        int[] answer = new int[answerTmp.size()];
        for(int i=0;i<answer.length;i++) {
            answer[i] = answerTmp.poll();
        }
        
        return answer;
    }
}