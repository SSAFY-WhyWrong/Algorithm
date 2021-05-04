package 성공;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1449 {
	static int N, L,cnt;
	static boolean array[];
	static int value[];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		array = new boolean[1001];
		value = new int[N];
		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			value[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(value);
		for (int i = 0; i < N; i++) {
			if (!array[value[i]]) {
				int k = value[i];
				for (int j = k; j < L+k; j++) {
					if(j<=1000) {
						array[j] = true;						
					}
				}
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
