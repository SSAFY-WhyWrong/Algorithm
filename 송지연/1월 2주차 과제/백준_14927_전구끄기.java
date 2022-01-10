import java.util.*;
import java.io.*;

public class 백준_14927_전구끄기 {

	static int N, answer;
	static boolean[] click;
	static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
	static int[][] board;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		board = new int[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				board[i][j] = sc.nextInt();
			}
		}
		
		click = new boolean[N];
		answer = Integer.MAX_VALUE;
		firstClick(0);
		
		if(answer == Integer.MAX_VALUE) answer = -1;
		System.out.println(answer);
	}
	
	public static void firstClick(int target) {
		if(target == N) {
			int cnt = changeCnt();
			answer = Math.min(cnt, answer);
			
			return;
		}
		
		click[target] = true;
		firstClick(target + 1);
		
		click[target] = false;
		firstClick(target + 1);
	}
	
	public static void change(int x, int y) {
		
		board[x][y] = board[x][y] == 0 ? 1 : 0;
		
		for(int d=0;d<4;d++) {
			int nx = x + dx[d], ny = y + dy[d];
			
			if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
			
			 board[nx][ny] = board[nx][ny] == 0 ? 1 : 0;
		}
	}
	
	public static int changeCnt() {
		int res = 0;
		
		for(int i=0;i<N;i++) {
			if(click[i]) {
				change(0, i);
				res++;
			}
		}
		
		for(int i=1;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(board[i-1][j] == 1) {
					res++;
					change(i, j);
				}
			}
		}

		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(board[i][j] == 1) return Integer.MAX_VALUE;
			}
		}
		
		return res;
	}
}
