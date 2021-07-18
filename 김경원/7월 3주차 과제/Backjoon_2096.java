import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_2096 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int arr[][] = new int[N][3];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++)
				arr[i][j] = Integer.parseInt(st.nextToken(" "));
		}
		
		int max[][] = new int[N][3];
		int min[][] = new int[N][3];
		for(int j=0;j<3;j++) {
			max[0][j] = arr[0][j];
			min[0][j] = arr[0][j];
		}
		
		int delta[] = {-1,0,1};
		
		for(int i=1;i<N;i++) {
			
			for(int j=0;j<3;j++) {
				max[i][j] = -1;
				min[i][j] = 100000*9;
				for(int d=0;d<3;d++) {
					int x = j + delta[d];
					if(x < 0 || x>=3) continue;
					
					max[i][j] = Math.max(max[i][j], max[i-1][x]);
					min[i][j] = Math.min(min[i][j], min[i-1][x]);
				}
				max[i][j] += arr[i][j];
				min[i][j] += arr[i][j];
				
			}
		}
		int max_result = -1;
		int min_result = 100000* 9;
		for(int j=0;j<3;j++) {
			max_result = Math.max(max_result, max[N-1][j]);
			min_result = Math.min(min_result, min[N-1][j]);
			
		}
		
		System.out.println(max_result+" "+min_result);
		
	}
}
