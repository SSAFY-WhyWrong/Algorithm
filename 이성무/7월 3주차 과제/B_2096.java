package 실패;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_2096 {
	private static int N;
	private static int[][] input;
	private static int[][] outputMax;
	private static int[][] outputMin;
	private static int[] index = { 2, 3, 0 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		input = new int[N][3];
		outputMin = new int[N][3];
		outputMax = new int[N][3];
		String k;
		int max = 0, min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
				if (i == 0) {
					outputMax[i][j] = input[i][j];
					outputMin[i][j] = input[i][j];
					max = Math.max(input[i][j], max);
					min = Math.min(input[i][j], min);
				} else {
					outputMin[i][j] = Integer.MAX_VALUE;
				}
			}
		}
		if (N != 1) {
			min = Integer.MAX_VALUE;
			for (int i = 1; i < N; i++) {
				for (int j = 0; j < 3; j++) {
					for (int t = 0; t < 3; t++) {
						if (index[j] == t)
							continue;
						outputMax[i][j] = Math.max(outputMax[i][j], outputMax[i - 1][t]);
						outputMin[i][j] = Math.min(outputMin[i][j], outputMin[i - 1][t]);
					}
					outputMax[i][j] += input[i][j];
					outputMin[i][j] += input[i][j];
					max = Math.max(outputMax[i][j], max);
					if (i == N - 1)
						min = Math.min(outputMin[i][j], min);
				}
			}
		}
		System.out.println(max + " " + min);
	}

}
