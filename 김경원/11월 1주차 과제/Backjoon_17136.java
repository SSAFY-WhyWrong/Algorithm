import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_17136 {
	
	static int answer;
	static int arr[][] = new int[10][10];
	static int paper[] = {0,5,5,5,5,5};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		for(int i=0;i<10;i++) {
			st = new StringTokenizer(br.readLine());			
			for(int j=0;j<10;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken(" "));
			}
		}
		
		
		answer = Integer.MAX_VALUE;
		
		DFS(0,0);
		
		
		if(answer == Integer.MAX_VALUE)
			answer = -1;
		System.out.println(answer);
		
		
		
		
		
		
		
		
	}
	
	
	static public void DFS(int idx, int cnt) {
		if(idx == 100) {
			answer = Math.min(answer, cnt);
			return;
		}
		
		
		if(answer <= cnt)
			return;
		
		int x = idx/10;
		int y = idx%10;
		
		if(arr[x][y] == 1) {
			for(int i=5;i>0;i--) {
				if(isPossible(x,y,i)) {
					stateChange(x,y,i,0);
					paper[i]--;
					DFS(idx+1,cnt+1);					
					stateChange(x,y,i,1);
					paper[i]++;
				}
							
				
			}
		}
		else
			DFS(idx+1, cnt);
		
	}
	
	
	static public void stateChange(int x, int y, int size, int state) {		
		for(int i=x;i<x+size;i++) {
			for(int j=y;j<y+size;j++) {
				arr[i][j] = state;
			}
		}
	}
	
	
	
	static public boolean isPossible(int x, int y, int size) {
		
		if(paper[size] == 0) return false;
		
		for(int i=x; i<x + size; i++) {
			for(int j=y; j<y+size;j++) {
				if(i < 0 || j < 0 || i>=10 || j>= 10)
					return false;
				
				
				if(arr[i][j]!=1)
					return false;
				
			}
		}
		return true;
	}
	
	
}
