import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_1756 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int D,N;
		st = new StringTokenizer(br.readLine());
		D = Integer.parseInt(st.nextToken(" "));
		N = Integer.parseInt(st.nextToken(" "));
		
		
		int[] arr = new int[D];
		int[] pizza = new int[N];
		
		
		
		
		st = new StringTokenizer(br.readLine());
		arr[0] = Integer.parseInt(st.nextToken(" "));
		for(int i=1;i<D;i++) {
			arr[i] = Integer.parseInt(st.nextToken(" "));
			arr[i] = Math.min(arr[i], arr[i-1]);
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			pizza[i] = Integer.parseInt(st.nextToken(" "));
		}
		
		int answer = check(D,N,arr,pizza);
		
		System.out.println(answer);
		
		
	}
	
	static int check(int D, int N, int[] arr, int[] pizza) {
		
		int idx = 0;		
		int answer = 0;
		
		for(int i=D-1;i>=0;i--) {
			if(pizza[idx] <= arr[i]) {
				answer = i+1;
				idx++;				
			}
			
			if(idx == N) {
				return answer;
			}
		}
		
		
		return 0;
	}
}
