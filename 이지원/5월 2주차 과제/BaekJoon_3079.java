package day_0505;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon_3079 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long[] arr = new long[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		long start = 0;
		long end = M * arr[N - 1];
		long mid = 0;
		long answer = 0;
		long cnt = 0;

		while (start <= end) {
			mid = (start + end) / 2;
			cnt = 0;

			for (int i = 0; i < N; i++) {
				cnt += (mid / arr[i]);
			}

			if (cnt < M) {
				start = mid + 1;
			} else {
				answer = mid;
				end = mid - 1;
			}
		}
		System.out.println(answer);
	}
}
