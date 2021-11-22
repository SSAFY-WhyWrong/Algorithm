import java.util.*;

class Solution {
    
    int[] nQueen;
    int answer;
    
    public int solution(int n) {
        answer = 0;
        nQueen = new int[n];
        
        location(0, n);
        
        return answer;
    }
    
    public void location(int row, int n) {
        if(row == n) {
            answer++;
            return;
        }
        
        for(int i=0;i<n;i++) {
            nQueen[row] = i;
            
            if(isPossible(row)) {
                location(row+1, n);
            }
        }
        
    }
    
    public boolean isPossible(int row) {
        for(int i=0;i<row;i++) {
            if(nQueen[i] == nQueen[row]) {
                return false;
            }
            
            if(Math.abs(row - i) == Math.abs(nQueen[row] - nQueen[i])) {
                return false;
            }
        }
        
        return true;
    }
}