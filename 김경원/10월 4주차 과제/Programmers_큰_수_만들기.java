import java.util.ArrayList;
import java.util.List;

public class Programmers_큰_수_만들기 {
	public static void main(String[] args) {
		
		String number = "99991";
		int k = 3;
		
		System.out.println(solution(number,k));
		
	}
	

	
   static public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        List<Character> list = new ArrayList();
        int len=0;
        int remove_cnt=0;
        
        for(int i=0;i<number.length();i++) {
        	char now = number.charAt(i);
        	
        	while(len!=0 && list.get(len-1) < now && remove_cnt < k) { 
        		list.remove(len-1);
        		len--;
        		remove_cnt++;
        	}
        	
        	len++;
        	list.add(now);
        }
        
        for(int i=0;i<number.length()-k;i++) {
        	sb.append(list.get(i));
        }
        
        
        
        return sb.toString();
    }
}
