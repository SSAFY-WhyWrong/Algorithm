
public class Programmers_정수_삼각형 {
	public static void main(String[] args) {
		
	}
	
    static public int solution(int[][] triangle) {
        int answer = 0;
        
        int len = triangle.length;
        
        int dp[][] = new int[len][len];
        
        
        for(int j=0;j<len;j++){
            dp[len-1][j] = triangle[len-1][j];
        }
        
        for(int i=len-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                dp[i][j] = Math.max(dp[i+1][j], dp[i+1][j+1]) + triangle[i][j];
            }
        }
        
        return answer = dp[0][0];
    }
	
}
