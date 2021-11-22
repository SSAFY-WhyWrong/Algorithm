package AlgorithmStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2225_합분해 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] num = new int[N+1][K+1];
		for(int i=0; i<=N; i++) {
			num[i][0] = 1;
		}
		for(int i=0; i<=K; i++) {
			num[0][i] = 1;
		}
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=K; j++) {
				num[i][j] = (num[i-1][j] + num[i][j-1])%1000000000;
			}
		}
		System.out.println(num[N][K-1]);
	}
}
