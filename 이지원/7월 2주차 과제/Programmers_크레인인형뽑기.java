package day_0711;
import java.util.*;

public class Programmers_크레인인형뽑기 {
	class Solution {
	    public int solution(int[][] board, int[] moves) {
	        int answer = 0;
	        Stack<Integer> check = new Stack<>();
	        for(int i = 0; i < moves.length; i++){
	            for(int j = 0; j < board.length; j++){
	                if(board[j][moves[i] - 1] != 0){
	                    if(check.isEmpty()){
	                        check.add(board[j][moves[i] - 1]);
	                    } else {
	                        if(check.peek() == board[j][moves[i] - 1]){
	                            check.pop();
	                            answer += 2;
	                        } else{
	                            check.add(board[j][moves[i] - 1]);
	                        }
	                    }
	                    board[j][moves[i] - 1] = 0;
	                    break;
	                }
	            }
	        }
	        return answer;
	    }
	}
}
