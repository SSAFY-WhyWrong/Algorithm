package M07_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Programmers_크레인인형뽑기게임 {

	static int N, M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		int[][] board = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		M = Integer.parseInt(br.readLine());
		int[] move = new int[M];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<M; i++) {
			move[i] = Integer.parseInt(st.nextToken());
		}
		//입력 끝~~
		System.out.println(Solution(board,move));
	}

	private static int Solution(int[][] board, int[] move) {
		int answer = 0;

		//		Stack<Integer>[] crane = new Stack<Integer>[N];
		List<Stack<Integer>> crane = new ArrayList<Stack<Integer>>(N);

		for(int i=0; i<N; i++) {
			Stack<Integer> stack = new Stack<>();
			for(int j=N-1; j>=0; j--) {
				if(board[j][i] != 0) stack.add(board[j][i]);
			}
			crane.add(stack);
		}

		Stack<Integer> basket = new Stack<>();

		for(int i=0; i<move.length; i++) {
			int idx = move[i]-1;
			
			if(!crane.get(idx).isEmpty()) {
				int doll = crane.get(idx).pop();

				if(!basket.isEmpty()) {
					int pre = basket.peek();
					if(pre == doll) {
						answer += 2;
						basket.pop();						
					}else basket.push(doll);
				}else basket.push(doll);
			}
		}	

		return answer;
	}
}
/*
5
0 0 0 0 0
0 0 1 0 3
0 2 5 0 1
4 2 4 4 2
3 5 1 3 1
8
1 5 3 5 1 2 1 4
*/
