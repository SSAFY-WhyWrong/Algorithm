import java.util.ArrayList;
import java.util.List;

public class Programmers_GPS_ver2 {
	public static void main(String[] args) {
		int n = 7;
		int m = 10;
		int edge_list[][] = {{1,2},{1,3},{2,3},{2,4},{3,4},{3,5},{4,6},{5,6},{5,7},{6,7}};
		int k = 6;
		int gps_log[] = {1,2,3,3,6,7};
		int result;
		result = solution(n,m,edge_list,k,gps_log);
		System.out.println(result);
		
		
	}
	
	static public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        int answer = 0;
        
        
        int start = gps_log[0];
        int end = gps_log[k-1];
        
        List<Integer> edge[] = new ArrayList[n+1];
        for(int i=1;i<=n;i++) {
        	edge[i] = new ArrayList();
        }
        
        for(int i=0;i<m;i++) {
        	edge[edge_list[i][0]].add(edge_list[i][1]);
        	edge[edge_list[i][1]].add(edge_list[i][0]);
        }
        
        for(int i=1;i<=n;i++) {
        	edge[i].add(i); //가만히 있는 경우
        }
        
        
        int[][] dp = new int[k][n+1];
        
        for(int i=0;i<k;i++) {
        	for(int j=1;j<=n;j++)
        		dp[i][j] = 100;
        }
        
        dp[0][start] = 0;
        
        for(int i=1;i<k-1;i++) {
        	for(int j=1;j<=n;j++) {
        		
        		for(int before : edge[j]) { //j까지 올 수 있는 경로 확인
        			dp[i][j] = Math.min(dp[i-1][before], dp[i][j]);
        			//i-1번째에서 출발하여 j까지 올 수 있는 경로 중에서 최소값 구함
        		}
        		
        		if(gps_log[i] != j) dp[i][j]+=1; //현재가 로그와 같지 않은 경우 바꿔야함
        		
        	}
        }
        
        for(int before : edge[end]) {
        	dp[k-1][end] = Math.min(dp[k-2][before], dp[k-1][end]);
        }
        
        
        answer = dp[k-1][end];
        if(answer == 100)
        	return -1;
        
        return answer;
 }
}
