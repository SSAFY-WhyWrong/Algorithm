class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int num = (brown - 4) / 2; // 가로+세로
        
        for(int i=1; i<num; i++)
        {
            if(i * (num-i) == yellow) 
            {
                answer[0] = i+2;
                answer[1] = num-i+2;
                break;
            }
        }
        
        if(answer[0] < answer[1]) {
            int tmp = answer[0];
            answer[0] = answer[1];
            answer[1] = tmp;
        }

        return answer;
    }
}