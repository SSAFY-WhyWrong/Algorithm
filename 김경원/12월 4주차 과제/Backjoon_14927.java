import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_14927 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] light = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				light[i][j] = Integer.parseInt(st.nextToken(" "));
			}
		}
		
		int result = Integer.MAX_VALUE;
		
		for(int bit=0;bit<1 << N;bit++) {
			
			int[][] copyLight = new int[N][N];
			int cnt=0;
			
			copyLight(light,copyLight,N);
			
			for(int j=0;j<N;j++) {
				if((bit & 1 << j ) > 0) {
					changeLightState(0,j,N,copyLight);
					cnt++;
				}
			}			
			
			for(int i=1;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(copyLight[i-1][j] == 1) {
						changeLightState(i,j,N,copyLight);
						cnt++;
					}
				}
			}
			
			if(isClear(copyLight,N)) {
				result = Math.min(result, cnt);
			}
			
			
		}
		
		if(result == Integer.MAX_VALUE) {
			result = -1;
		}
			System.out.println(result);
		
		
	}
	
	
	static boolean isClear(int[][] light, int N) {		
		
		for(int j=0;j<N;j++) {
			if(light[N-1][j] == 1) {
				return false;
			}
		}
		
		
		return true;
	}
	
	
	static void copyLight(int[][] original, int[][] temp, int N) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				temp[i][j] = original[i][j];				
			}
		}
	}
	
	
	static void changeLightState(int y, int x,int N, int[][] light) {
		
		light[y][x] = (light[y][x] - 1) * -1;
		
		
		if(y-1 >= 0) {
			light[y-1][x] = (light[y-1][x]-1)*-1;
		}
		
		if(x-1 >= 0) {
			light[y][x-1] = (light[y][x-1]-1)*-1;
		}
		
		if(y+1 < N) {
			light[y+1][x] = (light[y+1][x]-1)*-1;
		}
		
		if(x+1 < N) {
			light[y][x+1] = (light[y][x+1]-1)*-1;
		}
		
		
	}
	
	
}
