package day_0622;

public class Programmers_등굣길 {
	class Solution {
	    public int solution(int m, int n, int[][] puddles) {
	        int answer = 0;
	        int[][] dp = new int[m + 1][n + 1];
	        dp[1][1] = 1;
	        boolean chk = false;
	        for(int i = 1; i <= m; i++){
	            for(int j = 1; j <= n; j++){
	                chk = false;
	                for(int k = 0; k < puddles.length; k++){
	                    if(i == puddles[k][0] && j == puddles[k][1]){
	                        chk = true;
	                        break;
	                    }
	                }
	                if(chk){
	                    continue;
	                }
	                dp[i][j] += (dp[i - 1][j]%1000000007 + dp[i][j-1]%1000000007);
	                dp[i][j] %= 1000000007;
	            }
	        }
	        answer = dp[m][n] %= 1000000007;
	        return answer;
	    }
	}
}
