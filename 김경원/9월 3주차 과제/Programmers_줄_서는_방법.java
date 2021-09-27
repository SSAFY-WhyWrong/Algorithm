import java.util.ArrayList;
import java.util.List;

public class Programmers_줄_서는_방법 {
	public static void main(String[] args) {
		int n = 3;
		int k = 5;
		solution(n,k);
	}
	
	
	static public int[] solution(int n, long k) {
        int[] answer = new int[n];
        
        long x = 1;
        List<Integer> numbers = new ArrayList();
        for(int num=1; num<=n;num++) {
        	numbers.add(num);
        	x *= num;
        }      
        
        k-=1;
        
        for(int i=0;i<n;i++) {
        	x =  x / (n-i); 
        	int idx =  (int)(k / x);
        	answer[i] = numbers.get(idx);
        	numbers.remove(idx);  
        	k %= x;
        }
        
        
        for(int i=0;i<n;i++)
        	System.out.println(answer[i]);
        
        return answer;
    }
	
}
