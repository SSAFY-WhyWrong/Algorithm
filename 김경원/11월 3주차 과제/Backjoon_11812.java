import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_11812 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();
		
		long N;
		int K,Q;
		
		
		st = new StringTokenizer(br.readLine());
		
		N = Long.parseLong(st.nextToken(" "));
		K = Integer.parseInt(st.nextToken(" "));
		Q = Integer.parseInt(st.nextToken(" "));
		
				
		for(int i=0;i<Q;i++) {
			st = new StringTokenizer(br.readLine());
			long A,B;
			A = Long.parseLong(st.nextToken(" "));
			B = Long.parseLong(st.nextToken(" "));
			
			if(K==1) {
				sb.append(Math.abs(A-B)).append('\n');
				continue;
			}
			long cnt = 0;
			
			while(A!=B) {
				long a = Math.max(A, B);
				long b = Math.min(A, B);
				
				A = (a-2)/K + 1;
				B = b;
				
				cnt++;
				
			}
			sb.append(cnt).append('\n');
			
		}
		
		System.out.println(sb);
		
		
	}
}
