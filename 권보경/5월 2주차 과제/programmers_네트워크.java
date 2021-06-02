class Solution {
    static boolean[] visited; //연결상태 확인 
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int answer = 0;
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                answer++;
                dfs(n, computers, i);
            }
        }
        return answer;
    }
    
    public void dfs(int n, int[][] computers, int num) {
        visited[num] = true;
        for(int i=0; i<n; i++) {
            if(!visited[i] && computers[num][i] == 1) {
                dfs(n,computers,i);
            }
        }
    }  
}