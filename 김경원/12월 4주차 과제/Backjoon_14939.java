import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Backjoon_14939 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean[][] light = new boolean[10][10];
		
		for(int i=0;i<10;i++) {
			String str = br.readLine();
			for(int j=0;j<10;j++) {
				if(str.charAt(j) =='O') {
					light[i][j] = true;
				}
			}
		}
		
		int result = Integer.MAX_VALUE;
		
		for(int bit=0;bit<1 << 10;bit++) {
			
			boolean[][] copyLight = new boolean[10][10];
			int cnt=0;
			
			copyLight(light,copyLight);
			
			for(int j=0;j<10;j++) {
				if((bit & 1 << j ) > 0) {
					changeLightState(0,j,copyLight);
					cnt++;
				}
			}			
			
			for(int i=1;i<10;i++) {
				for(int j=0;j<10;j++) {
					if(copyLight[i-1][j]) {
						changeLightState(i,j,copyLight);
						cnt++;
					}
				}
			}
			
			if(isClear(copyLight)) {
				result = Math.min(result, cnt);
			}
			
			
		}
		
		if(result == Integer.MAX_VALUE) {
			result = -1;
		}
			System.out.println(result);
		
		
	}
	
	
	static boolean isClear(boolean[][] light) {		
		
		for(int j=0;j<10;j++) {
			if(light[9][j]) {
				return false;
			}
		}
		
		
		return true;
	}
	
	
	static void copyLight(boolean[][] original, boolean[][] temp) {
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				temp[i][j] = original[i][j];				
			}
		}
	}
	
	
	static void changeLightState(int y, int x, boolean[][] light) {
		
		light[y][x] = !light[y][x];
		
		
		if(y-1 >= 0) {
			light[y-1][x] = !light[y-1][x];
		}
		
		if(x-1 >= 0) {
			light[y][x-1] = !light[y][x-1];
		}
		
		if(y+1 < 10) {
			light[y+1][x] = !light[y+1][x];
		}
		
		if(x+1 < 10) {
			light[y][x+1] = !light[y][x+1];
		}
		
		
	}
	
	
}
