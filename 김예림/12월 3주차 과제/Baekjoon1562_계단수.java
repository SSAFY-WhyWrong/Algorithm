package AlgorithmStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1562_계단수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		//[숫자 길이][끝나는 숫자][사용된 숫자]
		long[][][] dp = new long[N+1][10][1<<10];
		int mod = 1000000000;

		for(int i=1; i<10; i++) {
			dp[1][i][1<<i] = 1; //1자리인 수
		}

		//0자리인 숫자는 없기 떄문에 1부터 시작해야해서 배열의 크기도 N+1
		for(int i=2; i<=N; i++) { //숫자의 길이
			for(int j=0; j<10; j++) { //끝나는 숫자
				for(int k=0; k<(1<<10); k++) { //i크기의 j로 시작하는 것이 k에서 비트로 표현된 숫자들로 이루어져 있다.
					int bit = k|(1<<j); //j로 시작하는 숫자니까 k의 비트에 있어야하는데 k의 비트에 없으면 추가하기 => |(or)
					if(j==0) {
						dp[i][j][bit] = (dp[i][j][bit] + dp[i-1][j+1][k])%mod;
					}else if(j==9) {
						dp[i][j][bit] = (dp[i][j][bit] + dp[i-1][j-1][k])%mod;
					}else {
						dp[i][j][bit] = (dp[i][j][bit] + dp[i-1][j+1][k] + dp[i-1][j-1][k])%mod;
					}
					// j가 0이면 이전 숫자가 없기 때문에 0을 더해주고
					// j가 9를 넘어가면 이후 숫자가 없기 때문에 이후 숫자에 0을 더해준다.
					//1. i-1자리 + 끝자리 +-1 => 계단 수이기 때문에
					//2. 숫자 j로 끝나기 전에 했던 계단 수
					//3. 1+2가 dp[i][j][k]
				}
			}
		}
		long tot = 0;
		for(int i=0; i<10; i++) {
			tot = (tot + dp[N][i][(1<<10)-1])%mod;
		}
		System.out.println(tot);
	}
}
