
public class Programmers_문자열압축 {
	public static void main(String[] args) {
		String s ="xababcdcdababcdcd";
		System.out.println(solution(s));
		
	}
	
    static public int solution(String s) {
        int answer = 1000;
       
        int length = s.length();
        int idx;
        int cnt;
        for(int i=1;i<=length/2;i++) {
        	idx = i;
        	cnt = 1;
        	String compStr = "";
        	String now = s.substring(0,i);
        	while(idx+i <= length) {
        		String next = s.substring(idx,idx+i);        		
        		if(now.equals(next)) {
        			cnt++;
        		}else {
        			if(cnt >=2)
        				compStr += cnt;
        			compStr += now;
        			now = next;
        			cnt = 1;
        		}
        		
        		idx += i;
        	}
        	
        	if(cnt >=2)
        		compStr += cnt;
        	compStr += now;
        	if(idx < length)
        		compStr += s.substring(idx);
        	
        	answer = Math.min(answer, compStr.length());
        }
        
        
        return answer;
    }
}
