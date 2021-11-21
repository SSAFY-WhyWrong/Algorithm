package day_0625;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_3020 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		int[] top = new int[H + 1];
		int[] bottom = new int[H + 1];
		
		for(int i = 0; i < N/2; i++) {
			int a = Integer.parseInt(br.readLine());
			int b = Integer.parseInt(br.readLine());
			bottom[a]++;
			top[H - b + 1]++;
		}
		
		for(int i = 1; i <= H; i++) {
			top[i] += top[i - 1];
		}
		
		for(int i = H - 1; i > 0; i--) {
			bottom[i] += bottom[i + 1];
		}
		
		int ans = Integer.MAX_VALUE;
		int cnt = 0;
		for(int i = 1; i <= H; i++) {
			if(ans > top[i] + bottom[i]) {
				cnt = 1;
				ans = top[i] + bottom[i];
			} else if(ans == top[i] + bottom[i]){
				cnt++;
			}
		}
		System.out.println(ans + " " + cnt);
	}
}
