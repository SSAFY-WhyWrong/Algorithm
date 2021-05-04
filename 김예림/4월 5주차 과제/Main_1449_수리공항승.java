package M04_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1449_수리공항승 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] pipe = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) {
			pipe[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(pipe);
		
		int cnt = 1;
		double tape = pipe[0]-0.5+L;
		for(int i=1; i<N; i++) {
			if(tape<pipe[i]) {
				cnt++;
				tape = pipe[i]-0.5+L;
			} 
		}
		System.out.println(cnt);
	}
}
