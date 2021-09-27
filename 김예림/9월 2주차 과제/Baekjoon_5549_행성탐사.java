package M09_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_5549_행성탐사 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int K = Integer.parseInt(br.readLine());

		char[][] planet = new char[N+1][M+1];
		int[][][] uni = new int[N+1][M+1][3];
		for(int i=1; i<=N; i++) {
			String tmp = br.readLine();
			for(int j=1; j<=M; j++) {
				char c = tmp.charAt(j-1);
				planet[i][j] = c;

				switch (c) {
				case 'J':
					uni[i][j][0]++;
					break;
				case 'O':
					uni[i][j][1]++;
					break;
				case 'I':
					uni[i][j][2]++;
					break;
				}
			}
		}
	
		for(int i=1; i<=N; i++) {
			for(int k=0; k<3; k++) {
				uni[i][1][k] += uni[i-1][1][k];
			}
		}
		for(int j=1; j<=M; j++) {
			for(int k=0; k<3; k++) {
				uni[1][j][k] += uni[1][j-1][k];
			}
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				for(int k=0; k<3; k++) {
					if(i>1 && j>1) uni[i][j][k] += uni[i-1][j][k] + uni[i][j-1][k] - uni[i-1][j-1][k];
				}
			}
		}
		
		
		StringBuilder sb = new StringBuilder();
		for(int k=0; k<K; k++) {
			st = new StringTokenizer(br.readLine()," ");
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			
			for(int n=0; n<3; n++) {
				int tmp = uni[c][d][n] - uni[a-1][d][n] - uni[c][b-1][n] + uni[a-1][b-1][n];
				sb.append(tmp+" ");
			}
			sb.append("\n");		
		}
		System.out.println(sb.toString());
	}
}
