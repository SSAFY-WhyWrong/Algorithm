import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] result = new int[n+1][n+1];
        
        // 배열 초기화
        for(int i=0;i<n+1;i++) {
            for(int j=0;j<n+1;j++) {
                if(i == 0 || j == 0 || i == j) result[i][j] = 1;
            }
        }
        
        for(int i=0;i<results.length;i++) {
            int a = results[i][0], b = results[i][1];
            
            result[a][b] = 1;
        }
        
        // 플로이드-와샬로 연결된 승패 기록
        for(int k=1;k<n+1;k++) {
            for(int i=1;i<n+1;i++) {
                for(int j=1;j<n+1;j++) {
                    if(result[i][k] == 1 && result[k][j] == 1) {
                        result[i][j] = 1;
                    }
                }
            }
        }
        
        for(int i=1;i<n+1;i++) {
            int cnt = 0;
            for(int j=1;j<n+1;j++) {
                if(result[i][j] == 1 || result[j][i] == 1) cnt++;
            }
            
            if(cnt == n) answer++;
        }
        
        return answer;
    }
}