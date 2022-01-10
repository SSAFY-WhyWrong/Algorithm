package AlgorithmStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2616_소형기관차 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] train = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=1; i<=N; i++) {
			train[i] = Integer.parseInt(st.nextToken());
		}
		
		int K = Integer.parseInt(br.readLine());
		
		int[] people = new int[N+1];
		for(int i=1; i<=N; i++) {
			people[i] = train[i] + people[i-1];
		}
		
		int[][] dp = new int[4][N+1]; //[소형차의 개수][객차의 개수]
		for(int i=1; i<4; i++) {
			for(int j=i*K; j<=N; j++) { //여기서 인덱스를 다루기 쉽도록 모든 배열 인덱스를 1부터 시작!
				//j-K부터 j칸 까지의 손님의 합을 구하면서 비교
				dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j-K]+(people[j]-people[j-K]));
			}
		}
		System.out.println(dp[3][N]);
	}
}
