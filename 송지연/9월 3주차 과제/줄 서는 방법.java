import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        ArrayList<Integer> nums = new ArrayList<>();
        
        for(int i=1;i<=n;i++) {
            nums.add(i);
        }
        
        int idx = 0;
        k -= 1;
        while(n > 0) {
            long num = f(n-1);
            answer[idx++] = nums.get((int)(k/num));
            nums.remove((int)(k/num));
            n -= 1;
            k %= num;
        }
        
        
        return answer;
    }
    
    public long f(int n) {
        long res = 1;
        
        for(int i=2;i<=n;i++) {
            res *= i;
        }
        
        return res;
    }
}