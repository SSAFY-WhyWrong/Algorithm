package M10_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon2467_용액 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Number[] num = new Number[N];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			
			int k = 1;
			if(tmp<0) k=-1;
			num[i] = new Number(Math.abs(tmp), k);
		}
		Arrays.sort(num);
		
		int min = Integer.MAX_VALUE;
		int n1 = 0, n2 = 0;
		for(int i=1; i<N; i++) {
			int j = i-1;
			int tmp1 = num[i].num * num[i].kinds;
			while(true) {				
				if(j<0) break;
				
				int tmp2 = num[j].num * num[j].kinds;
				
				if((num[i].kinds != num[j].kinds) && min < Math.abs(tmp1+tmp2)) break;
				
				if(Math.abs(tmp1+tmp2) < min) {
					n1 = tmp1;
					n2 = tmp2;
					min = Math.abs(tmp1+tmp2);
					break;
				}
				j--;
			}
		}
		int[] answer = new int[2];
		answer[0] = n1;
		answer[1] = n2;
		Arrays.sort(answer);
		for(int i=0; i<2; i++) {
			System.out.print(answer[i]+" ");
		}
	}
	
	static class Number implements Comparable<Number>{
		int num;
		int kinds;
		public Number(int num, int kinds) {
			this.num = num;
			this.kinds = kinds;
		}
		@Override
		public int compareTo(Number o) {
			return this.num-o.num;
		}
	}
}
