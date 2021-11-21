package 실패;

import java.util.Arrays;
import java.util.Stack;

public class 크레인인형뽑기게임 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		System.out.println(solution(board,moves));
	}

	public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int[] lastIndex = new int[board[0].length];
        Arrays.fill(lastIndex, board.length);
        for (int i = 0; i < board[0].length; i++) {
			for (int j = 0; j < board.length; j++) {
				if(board[j][i]!=0) {
					lastIndex[i] = j;
					break;
				}
			}
		}
        int x,y;
        stack.push(101);
        for (int i = 0; i < moves.length; i++) {
			x =lastIndex[moves[i]-1];
        	if(x < board.length) {
        		y = board[x][moves[i]-1];
        		board[x][moves[i]-1] = 0;
        		lastIndex[moves[i]-1]++;
        		if(stack.peek()==y) {
        			stack.pop();
        			answer+=2;
        		}else {
        			stack.push(y);
        		}
        	}
		}
        return answer;
    }
}
