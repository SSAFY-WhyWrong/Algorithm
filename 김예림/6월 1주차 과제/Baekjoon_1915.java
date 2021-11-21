package M05_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1915 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] square = new int[N][M];
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				square[i][j] = s.charAt(j)-'0';
			}
		}

		int max = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(i-1>=0 && j-1>=0 && square[i][j]==1) {
					int tmp = Math.min(square[i][j-1], square[i-1][j]);
					square[i][j] = Math.min(square[i-1][j-1], tmp)+1;
				}

				if(max<square[i][j]) max = square[i][j];
			}
		}
		System.out.println(max*max);
	}
}
