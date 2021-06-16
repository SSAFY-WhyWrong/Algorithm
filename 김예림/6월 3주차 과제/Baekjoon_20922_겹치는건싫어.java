package M06_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_20922_겹치는건싫어 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] limit = new int[100001];
		int[] num = new int[N];
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		//입력 끝
		
		int max = 0;
		int startIdx = 0;
		int endIdx = 0;
		limit[num[startIdx]]++;
		
		for(int i=1; i<N; i++) {
			if(limit[num[i]]<k) {
				endIdx = i;
				limit[num[endIdx]]++;
				max = Math.max(endIdx-startIdx+1, max);
			}else {
				while(true) {
					if(num[startIdx] == num[i]) {
						startIdx++;
						endIdx = i;
						break;
					}else {
						limit[num[startIdx]]--;
						startIdx++;
					}
				}
			}
		}
		System.out.println(max);
	}
}
