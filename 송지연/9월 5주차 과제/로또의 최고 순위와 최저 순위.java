class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {0, 0};
        boolean[] nums = new boolean[46];
        int zero_cnt = 0, win_cnt = 0;
        
        for(int i: win_nums) {
            nums[i] = true;
        }
        
        for(int i: lottos){
            if(i == 0)
                zero_cnt++;
            if(nums[i])
                win_cnt++;
        }
        
        int high = 7 - (zero_cnt + win_cnt);
        int low = 7 - win_cnt;
        
        if(high >= 6)
            high = 6;
        if(low >= 6)
            low = 6;
        
        answer[0] = high;
        answer[1] = low;

        return answer;
    }
}