import java.util.*;
import java.io.*;

public class 백준_2573_빙산 {

	static int N, M;
	static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
	static int[][] board, aroundBoard;
	static boolean[][] visit;
	static Queue<int[]> q, zeroQ;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		aroundBoard = new int[N][M];
		q = new LinkedList<>();
		zeroQ = new LinkedList<>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(bf.readLine());
			
			for(int j=0;j<M;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] != 0) q.add(new int[] {i, j});
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				int zeroCnt = 0;
				
				for(int d=0;d<4;d++) {
					int nx = i + dx[d], ny = j + dy[d];
					
					if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
					if(board[nx][ny] == 0) zeroCnt++;
				}
				
				aroundBoard[i][j] = zeroCnt;
			}
		}
		
		System.out.println(melting());
	}
	
	public static int melting() {
		int year = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			// 녹이기
			for(int s=0;s<size;s++) {
				int[] now = q.poll();
				
				if(board[now[0]][now[1]] - aroundBoard[now[0]][now[1]] <= 0) {
					board[now[0]][now[1]] = 0;
					zeroQ.add(now);
				} else {
					board[now[0]][now[1]] -= aroundBoard[now[0]][now[1]];
					q.add(now);
				}
			}
			
			year++;
			
			// 덩어리 계산
			visit = new boolean[N][M];
			size = q.size();
			int cnt = 0;
			for(int s=0;s<size;s++) {
				int[] now = q.poll();

				if(!visit[now[0]][now[1]]) {
					countArea(now[0], now[1]);
					cnt++;
				}
				q.add(now);
			}
			
			if(cnt >= 2) return year;
			
			// 주변 빙산 계산
			while(!zeroQ.isEmpty()) {
				int[] now = zeroQ.poll();
				
				for(int d=0;d<4;d++) {
					int nx = now[0] + dx[d], ny = now[1] + dy[d];
					
					if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
					aroundBoard[nx][ny] += 1;
				}
			}
		}
		
		return 0;
	}
	
	public static void countArea(int x, int y) {
		visit[x][y] = true;
		
		for(int d=0;d<4;d++) {
			int nx = x + dx[d], ny = y + dy[d];
			
			if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
			if(board[nx][ny] != 0 && !visit[nx][ny]) countArea(nx, ny);
		}
		
		return;
	}
}
