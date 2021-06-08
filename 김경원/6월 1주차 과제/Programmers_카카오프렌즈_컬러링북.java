import java.util.LinkedList;
import java.util.Queue;

public class Programmers_카카오프렌즈_컬러링북 {
	public static void main(String[] args) {
		
		int m = 6;
		int n = 4;;
		int[][] picture = {{1,1,1,0},{1,2,2,0},{1,0,0,1},{0,0,0,1},{0,0,0,3},{0,0,0,3}};
		
		
		
		int[] answer = solution(m,n,picture);
		System.out.println(answer[0]+" "+answer[1]);
		
		
	}
	static class Node{
		int i,j;
		Node(int i,int j){
			this.i=i;
			this.j=j;
		}
	}
	static public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        boolean visit[][] = new boolean[m][n];
        int ni[] = {-1,1,0,0};
        int nj[] = {0,0,-1,1};
        
        Queue<Node> q = new LinkedList();
        
        for(int i=0;i<m;i++) {
        	for(int j=0;j<n;j++) {
        		if(visit[i][j] || picture[i][j]==0) continue;
        		q.add(new Node(i,j));
        		int cnt=1;
        		visit[i][j] = true;
        		while(!q.isEmpty()) {
        			Node node = q.poll();
        			int x,y;
        			
        			for(int d=0;d<4;d++) {
        				x = node.i + ni[d];
        				y = node.j + nj[d];
        				if(x < 0 || y<0 || x>=m || y>=n || visit[x][y] || picture[i][j] != picture[x][y] )
        					continue;
        				
        				visit[x][y] = true;
        				cnt++;
        				q.add(new Node(x,y));
        			}        			
        		}
        		numberOfArea++;
        		maxSizeOfOneArea = Math.max(maxSizeOfOneArea, cnt);
        		
        	}
        }
             
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}
