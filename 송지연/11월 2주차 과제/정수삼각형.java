import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int[] dp = new int[triangle.length+1];
        
        for(int i=triangle.length-1;i>=0;i--) {
            int[] newDp = new int[triangle.length+1];
            
            for(int j=0;j<triangle[i].length;j++) {
                newDp[j] = triangle[i][j] + Math.max(dp[j], dp[j+1]);
            }
            
            for(int j=0;j<triangle.length+1;j++) {
                dp[j] = newDp[j];
            }
        }
        
        return dp[0];
    }
}