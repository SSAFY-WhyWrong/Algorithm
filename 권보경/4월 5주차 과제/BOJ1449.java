package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import java.util.StringTokenizer;

public class BOJ1449 {
	static int N, L;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			arr[i] =Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int now = arr[0];
		int cnt = 1;
		for(int i=1; i<N; i++) {
			if(arr[i]-now < L) continue;
			else {
				now = arr[i];
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}
