package day_0823;
import java.util.*;

public class Programmers_오픈채팅방 {
	class Solution {
	    public String[] solution(String[] record) {
	        String[] answer = {};
	        int cnt = 0;
	        HashMap<String, String> map = new HashMap<>();
	        
	        for(int i = 0; i < record.length; i++) {
	            String[] temp = record[i].split(" ");
	            if(temp[0].equals("Enter")) {
	                map.put(temp[1], temp[2]);
	                cnt++;
	            } else if (temp[0].equals("Change")){
	                map.put(temp[1], temp[2]);
	            } else {
	                cnt++;
	            }
	        }
	        
	        answer = new String[cnt];
	        cnt = 0;
	        for(int i = 0; i < record.length; i++){
	            String[] temp = record[i].split(" ");
	            if(temp[0].equals("Enter")) {
	                answer[cnt] = map.get(temp[1]) + "님이 들어왔습니다.";
	                cnt++;
	            } else if (temp[0].equals("Leave")){
	                answer[cnt] = map.get(temp[1]) + "님이 나갔습니다.";
	                cnt++;
	            }
	        }
	        
	        return answer;
	    }
	}
}
