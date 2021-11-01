import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_1493 {
	
	static boolean isSuccess = true;
	static int cnt=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		int L,W,H,N;
		
		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken(" "));
		W = Integer.parseInt(st.nextToken(" "));
		H = Integer.parseInt(st.nextToken(" "));
		
		N = Integer.parseInt(br.readLine());
		
		int cube[] = new int[N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken(" ");
			cube[i] = Integer.parseInt(st.nextToken(" "));
		}
		
		
		int result = divide(L,W,H,N-1,cube);
		
		if(isSuccess)
			System.out.println(result);
		else 
			System.out.println(-1);
		
		
	}
	
	static int divide(int l, int w, int h, int r, int cube[]) {
		if(l == 0 || w == 0 || h == 0) return 0;
		
		for(int i=r; i >= 0; i--) {
			if(cube[i] !=0 && l >= (1 << i) && w >= (1 << i) && h >= (1 << i)) {
				cube[i]--;
				return divide(l-(1<<i), w, h, i, cube) + divide((1<<i), w-(1<<i), h, i, cube) + divide((1<<i), (1<<i), h- (1<<i), i, cube)+1;
			}
		}
		
		isSuccess = false;
		return 0;
	}
}
