package AlgorithmStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon1756_피자굽기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int D = Integer.parseInt(st.nextToken()); //오븐의 깊이
		int N = Integer.parseInt(st.nextToken()); //피자반죽의 개수
		
		int[] oven = new int[D]; //깊이에 따른 오븐의 지름
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<D; i++) {
			oven[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=1; i<D; i++) {
			if(oven[i]>oven[i-1]) oven[i] = oven[i-1];
		}
		
		int limit = D-1;
		int min = Integer.MAX_VALUE;
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) {
			int pizza = Integer.parseInt(st.nextToken());
			
			int baked = -1;
			int start = 0;
			int end = limit;
			while(start<=end) {
				int mid = (start+end)/2;
				if(oven[mid] >= pizza) {
					baked = mid;
					start = mid+1;
				}else end = mid-1;
			}
			min = Math.min(min, baked);
			limit = baked-1;
		}
		System.out.println(++min);
	}
}
/*
2 2
1 1
2 2

7 3
5 6 4 3 6 2 3
3 2 5

7 3
5 6 4 3 6 2 3
3 3 3
 */
