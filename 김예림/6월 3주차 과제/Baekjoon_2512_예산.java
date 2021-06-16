package M06_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_2512_예산 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int[] budget = new int[N];
		int max = 0;
		long sum = 0;
		for(int i=0; i<N; i++) {
			budget[i] = Integer.parseInt(st.nextToken());

			sum += budget[i];
			max = Math.max(max, budget[i]);
		}
		int totalBudget = Integer.parseInt(br.readLine());

		int start = 0;
		int end = max;
		int ans = 0;

		if(sum <= totalBudget) ans = max;
		else {
			while(true) {

				if(end-start <= 1) {
					ans = start;
					break;
				}

				int middle = (start+end)/2;
				int total = 0;

				for(int i=0; i<N; i++) {
					if(budget[i] > middle) total += middle;
					else total += budget[i];
				}
				
				if(total == totalBudget) {
					ans = middle;
					break;
				}
				else if(total < totalBudget) start = middle;
				else end = middle;

			}
		}
		System.out.println(ans);
	}
}
