package AlgorithmStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1480_보석모으기 {

	static int N,M,C;
	static int[] gem;
	static int[][][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		N = Integer.parseInt(st.nextToken()); //보석의 개수
		M = Integer.parseInt(st.nextToken()); //가방의 개수
		C = Integer.parseInt(st.nextToken()); //가방의 최대 한도

		st = new StringTokenizer(br.readLine()," ");
		gem = new int[N];
		for(int i=0; i<N; i++) {
			gem[i] = Integer.parseInt(st.nextToken());
		}

		dp = new int[M+1][1<<N][C+1]; //[선택한 가방 수][선택한 보석][남은 무게]

		System.out.println(pack(0,0,C));

	}

	public static int pack(int select, int bags, int c) {

		if((select == (1<<N)-1) || bags == M) return 0;

		if(dp[bags][select][c] != 0) return dp[bags][select][c];

		for(int i=0; i<N; i++) {
			if((select&(1<<i)) > 0) continue;
			
			if(c >= gem[i]) //가방의 용량이 남아있으면 계속 채우기
				dp[bags][select][c] = Math.max(dp[bags][select][c], pack(select|(1<<i), bags, c-gem[i])+1);
			else //새로운 가방을 탐색하는 경우
				dp[bags][select][c] = Math.max(dp[bags][select][c], pack(select, bags+1, C));

		}
		return dp[bags][select][c];
	}

}
