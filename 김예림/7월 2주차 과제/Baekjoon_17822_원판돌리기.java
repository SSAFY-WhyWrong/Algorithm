package M07_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import org.w3c.dom.css.ElementCSSInlineStyle;

public class Baekjoon_17822_원판돌리기 {

	static int[][] circle;
	static boolean[][] checked;
	static int N, M, T;
	static int[] di = {-1,1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		N = Integer.parseInt(st.nextToken()); //반지름 = 원판의 갯수
		M = Integer.parseInt(st.nextToken()); //한 원판에 적힌 숫자의 개수
		T = Integer.parseInt(st.nextToken()); //회전하는 횟수

		circle = new int[N+1][M+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=1; j<=M; j++) {
				int num = Integer.parseInt(st.nextToken());
				circle[i][j] = num;
			}
		}
		for(int i=0; i<T; i++) {
			//원판 회전시키기
			st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken());//big이 x의 배수
			int d = Integer.parseInt(st.nextToken());//d방향으로 회전
			int k = Integer.parseInt(st.nextToken());//k칸 회전

			//회전시키고 나서
			if(d==0) turnRight(x, k);
			else turnLeft(x, k);
			
			//인접한 숫자들을 없애거나, 숫자 조절하기
			removeNum();
		}

		int ans = 0;
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				ans += circle[i][j];
			}
		}
		
		System.out.println(ans);
	}

	private static void removeNum() {

		checked = new boolean[N+1][M+1];
		boolean exist = false;
		int total = 0;
		int cnt = 0;

		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				if(circle[i][j]!=0) {
					cnt++;
					total+=circle[i][j];
					if(Check(i, j)) {
						//인접한 숫자들이 있는 경우
						//바로 0으로 만들지 말고 먼저 boolean함수로 체크한 다음 -> 인접하다고 체크된 애들 전부 지우기
						checked[i][j] = true;
						exist = true;
					}
				}
			}
		}

		if(!exist) {
			//인접한 숫자들이 없는 경우
			double avg = (float)total/(float)cnt;
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=M; j++) {
					if(circle[i][j]>0 && circle[i][j]>avg) circle[i][j]--;
					else if (circle[i][j]>0 && circle[i][j]<avg) circle[i][j]++;
				}
			}
		} else {
			//인접한 숫자들 체크해 둔 boolean 2차원 배열을 살피면서 숫자들 지우기
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=M; j++) {
					if(checked[i][j]) circle[i][j] = 0;
				}
			}
		}
	}

	private static void turnRight(int x, int k) {
		int[][] temp = new int[N+1][M+1];

		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				temp[i][j] = circle[i][j];
			}
		}

		for(int i=x; i<=N; i+=x) {
			for(int j=1; j<=M; j++) {
				int tmp = (j+k)%M;
				if(tmp==0) tmp = M;
				circle[i][tmp] = temp[i][j];
			}
		}
	}
	private static void turnLeft(int x, int k) {
		int[][] temp = new int[N+1][M+1];

		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				temp[i][j] = circle[i][j];
			}
		}

		for(int i=x; i<=N; i+=x) {
			for(int j=1; j<=M; j++) {
				int tmp = (j-k+M)%M;
				if(tmp==0) tmp = M;
				circle[i][tmp] = temp[i][j];
			}
		}
	}
	private static boolean Check(int i, int j) {

		boolean isChecked = false;

		for(int d=0; d<2; d++) {
			int ni = i + di[d];
			if(ni>=1 && ni<=N && circle[i][j]==circle[ni][j]) {
				isChecked = true;
				checked[ni][j] = true;
			}
		}
		for(int d=0; d<2; d++) {
			int nj = (j + di[d])%M;
			if(circle[i][j]==circle[i][nj]) {
				isChecked = true;
				checked[i][nj] = true;
			}
		}

		return isChecked;
	}
}
