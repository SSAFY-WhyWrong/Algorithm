package M12_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1562_계단수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int VISIT = 1<<10; //마킹 상태를 체크
		long dp[][][] = new long[101][10][VISIT];
		long sum = 0;
		
		for(int i=1; i<10; i++) {
			dp[1][i][1<<i] = 1;
		}
		
		for(int i=2; i<=N; i++) { //2자리 숫자로 시작
			for(int j=0; j<=9; j++) { //0-9로 끝나는 경우의 수 다 해보기
				for(int k=0; k<VISIT; k++) { //마킹 상태
					//원소를 추가하는 부분 : j번 비트만 1, 나머지는 0으로 만들고 | 연산 진행 => j번 비트는 1로 변경, 나머지는 원래 상태 유지
					int bit = k | (1<<j); //OR연산-둘 다 0이라면 0, 아니면 1
					dp[i][j][bit] = (dp[i][j][bit]+
							((0<j?dp[i-1][j-1][k]:0)+(j<9?dp[i-1][j+1][k]:0) //j와 k가 범위를 넘어가는 경우를 빼기
									)%1000000000)%1000000000;
				}
			}
		}
		for(int i=0; i<10; i++) {
			sum = (sum + dp[N][i][VISIT-1]%1000000000);
		}
		System.out.println(sum);
	}
}
