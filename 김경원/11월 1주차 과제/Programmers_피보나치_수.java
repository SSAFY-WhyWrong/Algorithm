
public class Programmers_피보나치_수 {
	public static void main(String[] args) {
		int n = 5;
		System.out.println(solution(n));
	}
	
	
    static public int solution(int n) {
    	if(n == 2) return 1; 
    	
    	int n1 = 1, n2 = 1, sum = 0; 
    	for(int i=3; i<=n; i++) {
    		sum = n1 + n2; 
    		sum %= 1234567; 
    		n1 = n2; 
    		n2 = sum;
    	}
    	
    	return sum;
    }
}
