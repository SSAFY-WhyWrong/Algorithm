import java.util.LinkedList;
import java.util.Queue;

public class 카카오_코테2 {
	static String[][] places = { { "POXXX", "POXXX", "OXXXX", "XXXXX", "XXXXX" },
			{ "POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP" }, { "PXOPX", "OXOXP", "OXPXX", "OXXXP", "POOXX" },
			{ "OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO" }, { "PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP" } };
	static char[][] arr;
	static boolean[][] visit;
	static int[] dy_p = { -2, 0, 2, 0, -1, 1, 1, -1, -1, 0, 1, 0 };
	static int[] dx_p = { 0, 2, 0, -2, 1, 1, -1, -1, 0, 1, 0, -1 };

	static int[] dy_not = { -1, 0, 1, 0, -1 };
	static int[] dx_not = { 0, 1, 0, -1, 0 };
	static Queue<Node> q;

	static boolean end;

	public static void main(String[] args) {
		int[] answer = new int[5];
		for (int i = 0; i < 5; i++) {
			arr = new char[5][5];
			visit = new boolean[5][5];
			end = false;
			for (int j = 0; j < 5; j++) {
				arr[j] = places[i][j].toCharArray();
			}
			search();
			if (end == true) {
				answer[i] = 0;
			} else {
				answer[i] = 1;
			}
		}
		for (int k = 0; k < 5; k++) {
			System.out.print(answer[k] + " ");
		}
		System.out.println();
	}

	static void search() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (arr[i][j] == 'P' && visit[i][j] != true) {
					bfs(new Node(i, j));
				}
				if (end == true) {
					return;
				}
			}
		}
	}

	static void bfs(Node per) {
		q = new LinkedList<>();
		q.add(per);
		visit[per.y][per.x] = true;
		while (!q.isEmpty()) {
			Node tmp = q.poll();
			int y = tmp.y;
			int x = tmp.x;
			for (int i = 0; i < 12; i++) {
				int tmpy = y + dy_p[i];
				int tmpx = x + dx_p[i];
				if (tmpy >= 0 && tmpx >= 0 && tmpy < 5 && tmpx < 5 && arr[tmpy][tmpx] == 'P'
						&& visit[tmpy][tmpx] != true) {
					visit[tmpy][tmpx] = true;
					if (i < 4) {
						int cal_y = y + dy_not[i];
						int cal_x = x + dx_not[i];
						if (arr[cal_y][cal_x] == 'X') {
							q.add(new Node(tmpy, tmpx));
						} else {
							end = true;
							return;
						}
					} else if (i >= 4 && i < 8) {
						int tmpi = i % 4;
						int cal_y1 = y + dy_not[tmpi];
						int cal_x1 = x + dx_not[tmpi];

						int cal_y2 = y + dy_not[tmpi + 1];
						int cal_x2 = x + dx_not[tmpi + 1];

						if (arr[cal_y1][cal_x1] == 'X' && arr[cal_y2][cal_x2] == 'X') {
							q.add(new Node(tmpy, tmpx));
						} else {
							end = true;
							return;
						}
					} else if (i >= 8) {
						end=true;
						return;
					}
				}
			}
		}
	}

	static class Node {
		int y;
		int x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}

	}
}
/*
 * - 카카오 여름인턴 시험실 사회적거리두기 실시여부문제
- 2칸일때, 그 사이에 칸막이가 존재시에는 사회적거리두기로 허용된다.
- 그외에 1칸,2칸이하에 서로 앉아있을때는 사회적거리두기가 안된다.
- 2칸은 잘 세놓고 1칸을 안세서 조금 시간이 걸렸다. 문제 똑바로 읽기*/
