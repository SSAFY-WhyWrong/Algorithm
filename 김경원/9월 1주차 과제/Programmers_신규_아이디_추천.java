
public class Programmers_신규_아이디_추천 {
	public static void main(String[] args) {
		String new_id = "abcdefghijklmn.p";
		String answer = solution(new_id);
		System.out.println(answer);
	}
	
    static public String solution(String new_id) {
        String answer = "";
        
        answer = new_id.toLowerCase();
        answer = answer.replaceAll("[^-_.a-z0-9]", "");
        answer = answer.replaceAll("[.]+", ".");
        answer = answer.replaceAll("^[.]|[.]$","");
        if(answer.equals("")) answer = "a";
        if(answer.length()>=16) {
        	answer = answer.substring(0,15);
        	if(answer.charAt(answer.length()-1)=='.') answer = answer.substring(0,14);
        }
        while(answer.length() <=2 ) {
        	answer += answer.charAt(answer.length()-1);
        }
        
        return answer;
    }
}
