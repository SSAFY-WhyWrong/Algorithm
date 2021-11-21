package M06_2;

import java.util.*;

class Solution {
    
    static int numberOfArea;
    static int maxSizeOfOneArea;
    static int[] di = {0,0,-1,1};
    static int[] dj = {1,-1,0,0};
    static int M, N;
    static int[][] pic;
    
    public int[] solution(int m, int n, int[][] picture) {
        numberOfArea = 0;
        maxSizeOfOneArea = 0;
        M = m;
        N = n;
        
        pic = new int[M][N];
        
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[i].length; j++) {
                pic[i][j] = picture[i][j];
            }
        }
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(pic[i][j] != 0){
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, bfs(i,j,pic[i][j]));
                }
            }
        } 

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    public static int bfs(int i, int j, int start){
        
        Queue<Point> q = new LinkedList<Point>();
        q.offer(new Point(i, j));
        pic[i][j] = 0;
        
        int cnt = 1;
        
        while(!q.isEmpty()){
            Point cur = q.poll();
            
            for(int d=0; d<4; d++){
                int ni = cur.i + di[d];
                int nj = cur.j + dj[d];
                if(ni>=0 && ni<M && nj>=0 && nj<N && pic[ni][nj]==start){
                    cnt++;
                    q.offer(new Point(ni, nj));
                    pic[ni][nj] = 0;
                }
            }
        }
        return cnt;
    }
    
    static class Point{
        int i;
        int j;
        public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
    }  
}