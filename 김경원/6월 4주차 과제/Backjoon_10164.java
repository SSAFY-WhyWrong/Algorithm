import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_10164 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N,M,K;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken(" "));
		M = Integer.parseInt(st.nextToken(" "));
		K = Integer.parseInt(st.nextToken(" "));
		
		int x,y;
		if(K == 0)
			x = y = 1;
		else{
			x = (K-1) / M + 1;
			y = (K-1) % M + 1;
		}
		int arr[][] = new int[N+1][M+1];
		
		arr[0][1]=1;
		
		for(int i=1;i<=x;i++) {
			for(int j=1;j<=y;j++) {
				arr[i][j] = arr[i-1][j] + arr[i][j-1];
			}
		}
		
		for(int i=x;i<=N;i++) {
			for(int j=y;j<=M;j++) {
				arr[i][j] = arr[i-1][j] + arr[i][j-1];
			}
			
		}
		
		
		
		System.out.println(arr[N][M]);
		
		
		
		
	}
}
