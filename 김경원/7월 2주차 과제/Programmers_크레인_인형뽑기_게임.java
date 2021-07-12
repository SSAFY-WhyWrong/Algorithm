import java.util.Stack;

public class Programmers_크레인_인형뽑기_게임 {
	public static void main(String[] args) {

	}

	public int solution(int[][] board, int[] moves) {
		int answer = 0;

		Stack<Integer> stack = new Stack();
		int moves_length = moves.length;

		int N = board.length;
		int x, y;
		int now;

		for (int m = 0; m < moves_length; m++) {
			x = moves[m] - 1;
			y = 0;
			for (int i = 0; i < N; i++) {
				if (board[i][x] != 0) {
					y = i;
					break;
				}
			}

			now = board[y][x];
			board[y][x] = 0;

			if (now == 0)
				continue;

			if (!stack.isEmpty() && stack.peek() == now) {
				stack.pop();
				answer += 2;
			} else {
				stack.add(now);
			}

		}

		return answer;
	}
}
