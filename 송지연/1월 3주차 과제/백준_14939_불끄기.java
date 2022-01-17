import java.util.*;
import java.io.*;

public class 백준_14939_불끄기 {

	static int answer;
	static boolean[] pSwitch;
	static boolean[][] bolb, copyBolb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		answer = Integer.MAX_VALUE;
		pSwitch = new boolean[10];
		bolb = new boolean[10][10];
		
		for(int i=0;i<10;i++) {
			String s = sc.next();
			for(int j=0;j<10;j++) {
				if(s.charAt(j) == 'O') {
					bolb[i][j] = true;
				}
			}
		}
		
		whatPush(0);
		
		if(answer == Integer.MAX_VALUE) answer = -1;
		System.out.println(answer);
	}
	
	public static void whatPush(int cnt) {
		if(cnt == 10) {
			
			int pushCnt = isOff();
			answer = Math.min(answer, pushCnt);
			
			return;
		}
		
		pSwitch[cnt] = true;
		whatPush(cnt+1);
		
		pSwitch[cnt] = false;
		whatPush(cnt+1);
	}
	
	public static int isOff() {
		int cnt = 0;
		copyBolb = new boolean[10][10];
		copy();
		
		for(int i=0;i<10;i++) {
			if(pSwitch[i]) {
				cnt++;
				push(0, i);
			}
		}
		
		for(int i=1;i<10;i++) {
			for(int j=0;j<10;j++) {
				if(copyBolb[i-1][j]) {
					cnt++;
					push(i, j);
				}
			}
		}
		
		for(int i=0;i<10;i++) {
			if(copyBolb[9][i]) return Integer.MAX_VALUE;
		}

		return cnt;
	}
	
	public static void copy() {
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				copyBolb[i][j] = bolb[i][j];
			}
		}
		
		return;
	}
	
	public static void push(int x, int y) {
		int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
		
		copyBolb[x][y] = copyBolb[x][y]?false:true;
		for(int d=0;d<4;d++) {
			int nx = dx[d] + x, ny = dy[d] + y;
			
			if(nx < 0 || nx >= 10 || ny < 0 || ny >= 10) continue;
			
			copyBolb[nx][ny] = copyBolb[nx][ny]?false:true;
		}
		
		return;
	}
}
