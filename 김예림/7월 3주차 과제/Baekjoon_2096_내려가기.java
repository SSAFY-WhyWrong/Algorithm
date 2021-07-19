package M07_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_2096_내려가기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] dj = {-1,0,1};
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][3];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] min = new int[N][3];
		int[][] max = new int[N][3];
		
		//첫째 줄은 그대로 복사
		for(int i=0; i<3; i++) {
			min[0][i] = map[0][i];
			max[0][i] = map[0][i];
		}
		
		for(int i=1; i<N; i++) {
			Arrays.fill(min[i], Integer.MAX_VALUE);
		}
		
		for(int i=1; i<N; i++) {
			for(int j=0; j<3; j++) {
				for(int d=0; d<3; d++) {
					int curj = j + dj[d];
					if(curj>=0 && curj<3) {
						min[i][j] = Math.min(map[i][j]+min[i-1][curj], min[i][j]);
						max[i][j] = Math.max(map[i][j]+max[i-1][curj], max[i][j]);
					}
				}
			}
		}
//		for(int i=0; i<N; i++) {
//			for(int j=0; j<3; j++) {
//				System.out.print(max[i][j]+" ");
//			}
//			System.out.println();
//		}
//		for(int i=0; i<N; i++) {
//			for(int j=0; j<3; j++) {
//				System.out.print(min[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		int maxAns = 0;
		int minAns = Integer.MAX_VALUE;
		for(int i=0; i<3; i++) {
			maxAns = Math.max(max[N-1][i], maxAns);
			minAns = Math.min(min[N-1][i], minAns);
		}
		System.out.println(maxAns+" "+minAns);
	}
}
