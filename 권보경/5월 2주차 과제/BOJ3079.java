package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ3079 {
	static int n, m;
	static long[] time;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken()); //입국심사대
		m = Integer.parseInt(st.nextToken()); //상근이와 친구들 
		time = new long[n];
		
		for(int i=0; i<n; i++) {
			time[i] = Integer.parseInt(br.readLine()); 
		}
		
		Arrays.sort(time); //심사시간이 최소로 정렬 
		
		long left = 0;
		long right = time[n-1]*m;
		long ans = 0;
		while(true) {
			if(left > right) break;
			long mid = (left + right) / 2; //중간값 
			
			long cnt = 0;
			for(int i=0; i<n; i++) {
				cnt += mid/time[i]; //i번째 심사대에서 mid시간동안 처리할 수 있는 사람 수 
			}
		
			if(cnt < m) {
				left = mid+1;
			} else {
				ans = mid;
				right = mid-1;
			}
		}
		
		System.out.println(ans);
	}
}
