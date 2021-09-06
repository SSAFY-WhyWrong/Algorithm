public class Programmers_괄호_변환 {
	public static void main(String[] args) {
		
	}
	
	 static public String solution(String p) {
	        String answer = "";
	        
	        if(p.length()==0)
	        	return "";
	        
	        if(isComplete(p)) {
	        	return p;
	        }
	        
	        int idx = findIndex(p);
	        String u = p.substring(0,idx);
	        String v = p.substring(idx, p.length());
	        
	        if(isComplete(u)) {
	        	answer += u + solution(v);
	        }else {
	        	v = "(" + solution(v) + ")";
	        	u = u.substring(1,u.length()-1);
	        	answer += v + reverse(u);
	        }
	        
	        
	        return answer;
	 }
	 
	 

	static public boolean isComplete(String p) {
		 int cnt = 0;
		 int pLength = p.length();
		 
		 for(int i=0;i<pLength;i++) {
			 if(p.charAt(i) == '(')
				 cnt++;
			 else if(p.charAt(i) == ')' && cnt >0){
				 cnt--;
			 }
			 else
				 return false;
		 } 
		 
		 
		 return true;
	 }
	 
	 static public int findIndex(String p) {
		 
		 int left = 0, right = 0;
		 int pLength = p.length();
		 for(int i=0;i<pLength;i++) {
			 if(p.charAt(i)=='(') left++;
			 else if(p.charAt(i)==')') right++;
			 
			 if(left==right) return i+1;
		 }
		 
		 return pLength;
	 }
	 
	 private static String reverse(String u) {
		
		 int uLength = u.length();
		 StringBuilder sb = new StringBuilder();
		 for(int i=0;i<uLength;i++) {
			 if(u.charAt(i)=='(')
				 sb.append(')');
			 else
				 sb.append('(');
			 
		 }
		 
		return sb.toString();
	}

}


