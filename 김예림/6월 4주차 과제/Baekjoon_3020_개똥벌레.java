package M06_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_3020_개똥벌레 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		int[] top = new int[N/2];
		int[] down = new int[N/2];
		for(int i=0; i<N/2; i++) {
			top[i] = Integer.parseInt(br.readLine()); //종유석
			down[i] = Integer.parseInt(br.readLine());//석순
		}
		Arrays.sort(top);
		Arrays.sort(down);
		
		int[] top_sum = new int[H+1];
		int[] down_sum = new int[H+1];
		
		for(int i=0; i<N/2; i++) {
			top_sum[H-top[i]+1]++;
			down_sum[down[i]]++;
		}
		
		for(int i=2; i<=H; i++) {
			top_sum[i] = top_sum[i-1] + top_sum[i];
			down_sum[H-i] = down_sum[H-i] + down_sum[H-i+1];
		}
		//누적합 배열 구하기
		int[] pass = new int[H+1];
		int min = Integer.MAX_VALUE;
		
		for(int i=1; i<=H; i++) {
			pass[i] = top_sum[i] + down_sum[i];
			
			min = Math.min(min, pass[i]);
		}
		
		int cnt = 0;
		
		for(int i=1; i<=H; i++) {
			if(min == pass[i]) cnt++;
		}
		System.out.println(min+" "+cnt);
	}
}
