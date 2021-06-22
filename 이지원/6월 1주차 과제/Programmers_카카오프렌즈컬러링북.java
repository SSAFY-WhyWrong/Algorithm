package day_0608;

public class Programmers_카카오프렌즈컬러링북 {
	static int ans;
    static int[] di = {0,0,-1,1};
    static int[] dj = {-1,1,0,0};
    static boolean[][] visited;
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[] answer = new int[2];
        visited = new boolean[m][n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j] && picture[i][j] != 0){
                    ans = 1;
                    numberOfArea++;
                    dfs(i, j, m, n, picture);
                    maxSizeOfOneArea = Math.max(ans, maxSizeOfOneArea);
                }
            }
        }
        
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        
        return answer;
    }
    static void dfs(int i, int j, int m, int n, int[][] picture){
        visited[i][j] = true;
        for(int d = 0; d < 4; d++){
            int ni = i + di[d];
            int nj = j + dj[d];
            if(ni < 0 || nj < 0 || ni >= m || nj >= n) continue;
            if(visited[ni][nj]) continue;
            if(picture[i][j] == picture[ni][nj]){
                ans++;
                dfs(ni, nj, m, n, picture);
            }
        }
    }
}
