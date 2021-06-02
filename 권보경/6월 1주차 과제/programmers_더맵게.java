import java.util.*; 

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        for (int i = 0; i < scoville.length; i++) {
            pq.offer(scoville[i]);
        }

        int tmp = 0;
        while(pq.peek()<K) {
            if(pq.size()==1){
                answer = -1;
                break;
            }

            tmp = pq.poll() + pq.poll()*2;
            pq.offer(tmp);
            answer++;
        }

        return answer;
    }
}