package 실패;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B17822 {
	private static int N, M, T;
	private static int[][] circle;
	private static int[] di = { 1, -1, 0, 0 };
	private static int[] dj = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 행
		M = Integer.parseInt(st.nextToken()); // 열
		T = Integer.parseInt(st.nextToken()); // spin 갯수
		circle = new int[N][M]; // 2차원 배열로 원 표현
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				circle[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int t = 0; t < T; t++) { // 입력받으면서 돌림
			st = new StringTokenizer(br.readLine(), " ");
			spin(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		int answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				answer+=circle[i][j];
			}
		}
		System.out.println(answer);
	}

	// x의 배수의 원판들을 d 방향으로 k칸 회전시킨다. d> 0 시계 d>1 반시계
	// 회전 메소드
	private static void spin(int x, int d, int k) {
		int[] copy;
		int index = 1, lm;
		for (int i = x; i <= N; i = x*index) { //배수의 인덱스만 회전 시킨다.
			copy = new int[M]; //순차적으로 방문하니까 바로 변경못해서 복사해준다.
			for (int j = 0; j < M; j++) {
				lm = j + (di[d] * k); // 식으로 인덱스 조정
				if (lm >= M) //나머지 연산 대신 사용
					lm -= M;
				if (lm < 0) //나머지 연산 대신 사용
					lm += M;
				copy[lm] = circle[i-1][j]; //인덱스는 -1 해줘야 맞음
			}
			for (int j = 0; j < M; j++) { //복사를 집어넣는다.
				circle[i-1][j] = copy[j];
			}
			index++; //배수 형태를 갖추게
		}
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(circle[i]));
//		}
//		System.out.println();
		// 돌리고 숫자 지우기
		sameRemove();	
	}
	//bfs 형식으로 원판 탐색하기 위한 객체
	private static class xy {
		int x, y, val;

		public xy(int x, int y, int val) {
			super();
			this.x = x;
			this.y = y;
			this.val = val;
		}
	}
	//같은 수는 다 삭제 해주는 메소드
	private static void sameRemove() {
		int x, y, lx, ly, point, sum = 0, cnt = 0; // 지울 수 있는지 확인
		xy a;
		Queue<xy> queue = new LinkedList<>();
		//지웠는지 확인하는 배열 삭제해도 0인지 확인하기 때문에 상관없음
		boolean[][] remove = new boolean[N][M];
		//변화가 있는지 알 수 있게 하는 변수
		boolean isSame = true;
		//맵 돌면서 삭제되지 않은 수를 하나하나 방문함
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				//혹시나 변화가 없으면 평균을 내기 위함
				sum += circle[i][j];
				// 아직 생존자가 있으면
				if (circle[i][j] != 0) {
					//평균 내기 위한 남아 있는 수 카운트
					cnt++;
					queue.add(new xy(i, j, circle[i][j]));
					while (!queue.isEmpty()) {
						a = queue.poll();
						x = a.x;
						y = a.y;
						point = a.val;
						for (int k = 0; k < 4; k++) {
							lx = x + di[k];
							ly = y + dj[k];
							//4방 탐색시에 원판 형태를 보면 행방향으로는 끝과 처음이 연결되지 않음
							if (lx == N)
								continue;
							if (lx == -1)
								continue;
							if (ly == M)
								ly = 0;
							if (ly == -1)
								ly = M - 1;
							if (!remove[lx][ly] && point == circle[lx][ly]) {
								cnt++;
								queue.add(new xy(lx, ly, point));
								remove[lx][ly] = true;
								isSame = false;
								circle[lx][ly] = 0;
								//맞는게 있으면 처음 들어간 것도 0으로 바꿔줌
								if (circle[x][y] != 0)
									circle[x][y] = 0;
							}
						}
					}
				}
			}
		}
		// 변화가 없으면 범위를 줄여줌
		if (isSame) {
			//나머지까지 계산해야해서 int가 아님
			double aver = (float)sum / (float)cnt;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (circle[i][j] == 0)
						continue;
					if (circle[i][j] > aver)
						circle[i][j]--;
					else if (circle[i][j] < aver)
						circle[i][j]++;

				}
			}
		}
	}
}
