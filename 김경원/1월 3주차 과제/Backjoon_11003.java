import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Backjoon_11003 {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N, L;
		N = Integer.parseInt(st.nextToken(" "));
		L = Integer.parseInt(st.nextToken(" "));
		
		
		st = new StringTokenizer(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		Deque<int[] >dq = new ArrayDeque<>();
		
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(st.nextToken(" "));
			while(!dq.isEmpty() && dq.peekLast()[0] > num) {
				dq.pollLast();
			}
			
			dq.offer(new int[] {num, i});
			
			if(dq.peek()[1] <= i - L) {
				dq.poll();
			}
			
			sb.append(dq.peek()[0]).append(' ');
			
		}
		
		
		System.out.println(sb);
		
		
		
	}
}	
