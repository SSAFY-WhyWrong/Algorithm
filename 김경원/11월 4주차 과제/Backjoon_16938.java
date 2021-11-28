import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_16938 {
	static int N,L,R,X;
	static int[] A;
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//문제 수 N, 난이도 합은 L이상 ~ R이하, 가장 큰 격차가 X이상 
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken(" "));
		L = Integer.parseInt(st.nextToken(" "));
		R = Integer.parseInt(st.nextToken(" "));
		X = Integer.parseInt(st.nextToken(" "));
		
		
		A = new int[N];
		st = new StringTokenizer(br.readLine());
		
		
		for(int i=0;i<N;i++) {
			A[i] = Integer.parseInt(st.nextToken(" "));
		}
		
		result = 0;
		
		solve(0,0,1000000000,0,false);
		
		System.out.println(result);
		
		
	}
	
	static void solve(int idx, int sum, int min, int max, boolean flag) {		
		
		
		if(sum > R)
			return;
		
		if(flag && sum >= L && (max-min)>=X) {
			result++;
		}
		
		
		if(idx >= N)
			return;
		
				
		
		solve(idx+1, sum+A[idx], Math.min(min, A[idx]), Math.max(max, A[idx]), true);
		
		
		
		solve(idx+1, sum, min, max ,false);
		
														
	}
	
	
}

