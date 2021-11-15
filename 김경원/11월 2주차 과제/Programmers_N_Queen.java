
public class Programmers_N_Queen {
	public static void main(String[] args) {
		System.out.println(solution(4));
	}
    static int answer;
    static public int solution(int n) {
		answer = 0;

		int col[] = new int[n];

		simulate(0, col, n);

		return answer;
	}
    
   static public void simulate(int idx, int col[], int n){
        if(idx >= n){
            answer++;
            return;
        }
        
        
        for(int i=0;i<n;i++){
            col[idx] = i;
            if(isPossible(idx, col)){
                simulate(idx+1, col,n);
            }
            col[idx] = 0;
        }
        
        
        
        
    }
    
    static public boolean isPossible(int idx, int col[]){
        for(int i=0;i<idx;i++){
            if(col[i] == col[idx]) return false;
            if(Math.abs(idx - i) == Math.abs(col[idx] - col[i])) return false;
        }
        
        return true;
    }

}
