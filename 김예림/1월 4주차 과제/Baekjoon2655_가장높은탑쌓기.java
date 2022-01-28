package AlgorithmStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Baekjoon2655_가장높은탑쌓기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] bricks = new int[N][4];
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			bricks[i][0] = Integer.parseInt(st.nextToken());
			bricks[i][1] = Integer.parseInt(st.nextToken());
			bricks[i][2] = Integer.parseInt(st.nextToken());
			bricks[i][3] = i + 1;
		}

		Arrays.sort(bricks, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return (a[0] <= b[0]) ? -1 : 1;
			}
		});

		int[][] result = new int[N][3];
		result[0][0] = 0;
		result[0][1] = bricks[0][3];
		result[0][2] = bricks[0][1];

		for (int i = 1; i < bricks.length; i++) {
			for (int k = 0; k < i; k++) {
				if (bricks[i][2] > bricks[k][2]) {
					if (result[i][2] < bricks[i][1] + result[k][2]) {	
						result[i][0] = k;
						result[i][1] = bricks[k][3];
						result[i][2] = bricks[i][1] + result[k][2];
					}
				}
			}
			if (result[i][2] == 0) {
				result[i][0] = i;
				result[i][1] = bricks[i][3];
				result[i][2] = bricks[i][1];
			}
		}
		int maxHeight = 0;
		int maxIndex = 0;
		for (int i = 0; i < result.length; i++) {

			if (result[i][2] > maxHeight) {
				maxHeight = result[i][2];
				maxIndex = i;
			}
		}
		ArrayList<Integer> list = new ArrayList<>();
		list.add(bricks[maxIndex][3]);
		while (true) {
			if (result[maxIndex][0] == maxIndex)
				break;
			maxIndex = result[maxIndex][0];
			list.add(bricks[maxIndex][3]);
		}
		System.out.println(list.size());
		Collections.reverse(list);
		for (int n : list)
			System.out.println(n);
	}
}