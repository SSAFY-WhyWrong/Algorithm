package 실패;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_14499 {
	private static class Dice { //주사위 객체로 만들어서 관리
		int up, down, left, right, front, back;

		public Dice(int up, int down, int left, int right, int front, int back) {
			this.up = up;
			this.down = down;
			this.left = left;
			this.right = right;
			this.front = front;
			this.back = back;
		}
	}

	private static int[][] map;
	private static int N, M, K;
	private static int x, y, lx, ly;
	private static Dice dice;
	private static StringBuilder sb;
	private static int[] dx = { 0, 0, 0, -1, 1 };
	private static int[] dy = { 0, 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		dice = new Dice(0,0,0,0,0,0);
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < K; i++) {
			goDice(Integer.parseInt(st.nextToken()));
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}

	private static void goDice(int direct) { //명령어에 따라 이동
		lx = x + dx[direct];
		ly = y + dy[direct];

		if (lx < 0 || ly < 0 || lx >= N || ly >= M)
			return;

		switch (direct) {
		case 1:
			right();
			break;
		case 2:
			left();
			break;
		case 3:
			up();
			break;
		case 4:
			down();
			break;
		}
		mapSwitch(direct);
		sb.append(dice.up + "\n");
	}
	//맵 상태에 따라 수 변경 
	private static void mapSwitch(int direct) {
		if(map[lx][ly]==0) {
			map[lx][ly] = dice.down;
		}else {
		 dice.down = map[lx][ly];
		 map[lx][ly] = 0;
		}
		x = lx;
		y = ly;
	}
	// 구르면서 주사위 위치 변경 하드 코딩
	private static void down() {
		Dice copy = new Dice(dice.back,dice.front,dice.left,dice.right,dice.up,dice.down);
		dice = copy;
	}

	private static void up() {
		Dice copy = new Dice(dice.front,dice.back,dice.left,dice.right,dice.down,dice.up);
		dice = copy;
	}

	private static void left() {
		Dice copy = new Dice(dice.right,dice.left,dice.up,dice.down,dice.front,dice.back);
		dice = copy;

	}

	private static void right() {
		Dice copy = new Dice(dice.left,dice.right,dice.down,dice.up,dice.front,dice.back);
		dice = copy;

	}

}
