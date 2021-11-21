import java.util.*;
import java.io.*;

public class 백준_10026_적록색약 {

	static int N;
	static char[][] board;
	static boolean[][] visit, visitRG;
	static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		board = new char[N][N];
		visit = new boolean[N][N];
		visitRG = new boolean[N][N];
		
		for(int i=0;i<N;i++) {
			String tmp = bf.readLine();
			for(int j=0;j<N;j++) {
				board[i][j] = tmp.charAt(j);
			}
		}
		
		int cnt = 0, cntRG = 0;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visit[i][j]) {
					visit[i][j] = true;
					dfs(i, j);
					cnt++;
				}
				
				if(!visitRG[i][j]) {
					visitRG[i][j] = true;
					dfsRG(i, j);
					cntRG++;
				}
			}
		}
		
		System.out.println(cnt + " " + cntRG);
	}
	
	public static void dfs(int x, int y) {
		for(int d=0;d<4;d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
			if(visit[nx][ny]) continue;
			if(board[x][y] == board[nx][ny]) {
				visit[nx][ny] = true;
				dfs(nx, ny);
			}
		}
		
		return;
	}
	
	public static void dfsRG(int x, int y) {
		for(int d=0;d<4;d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
			if(visitRG[nx][ny]) continue;
			if(board[x][y] == board[nx][ny]) {
				visitRG[nx][ny] = true;
				dfsRG(nx, ny);
			} else if ((board[x][y] == 'R' && board[nx][ny] == 'G') ||
					(board[x][y] == 'G' && board[nx][ny] == 'R')) {
				visitRG[nx][ny] = true;
				dfsRG(nx, ny);
			}
		}
		
		return;
	}

}
