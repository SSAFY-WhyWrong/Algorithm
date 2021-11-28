import java.util.Arrays;

public class Programmers_전화번호_목록 {
	public static void main(String[] args) {
		
		String[] phone_book = {"119", "97674223", "1195524421"};
		
		System.out.println(solution(phone_book));
	}
	
    static public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);
        
        for(int i=1;i<phone_book.length;i++) {
        	String str1 = phone_book[i-1];
        	String str2 = phone_book[i];
        	
        	if(str1.length() >= str2.length()) {
        		continue;
        	}
        	
        	
        	if(str1.equals(str2.substring(0,str1.length()))) {
        		return false;
        	}
        	
        	
      
        }
        
        
        
        
        
        return answer;
    }
}
