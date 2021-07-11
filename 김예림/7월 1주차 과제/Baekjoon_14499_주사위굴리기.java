package M07_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_14499_주사위굴리기 {

	static int dice[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int[] di = {0,0,0,-1,1};
		int[] dj = {0,1,-1,0,0};

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());


		int[][] map = new int[N][M];
		dice = new int[7];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<K; i++) {
			int n = Integer.parseInt(st.nextToken());
			int nx = x + di[n];
			int ny = y + dj[n];
			if(nx>=0 && ny>=0 && nx<N && ny<M) {
				x = nx;
				y = ny;
				Roll(n);
				if(map[x][y]==0) map[x][y] = dice[6];
				else {
					dice[6] = map[x][y];
					map[x][y] = 0;
				}
				System.out.println(dice[1]);
			}
		}

	}

	private static void Roll(int n) {
		int[] temp = dice.clone();

		switch (n) {
		case 1:
			dice[3] = temp[1];
			dice[4] = temp[6];
			dice[1] = temp[4];
			dice[6] = temp[3];
			break;
		case 2:
			dice[4] = temp[1];
			dice[1] = temp[3];
			dice[3] = temp[6];
			dice[6] = temp[4];
			break;
		case 3:
			dice[6] = temp[2];
			dice[2] = temp[1];
			dice[1] = temp[5];
			dice[5] = temp[6];
			break;
		case 4:
			dice[6] = temp[5];
			dice[5] = temp[1];
			dice[1] = temp[2];
			dice[2] = temp[6];
			break;

		}
	}
}
