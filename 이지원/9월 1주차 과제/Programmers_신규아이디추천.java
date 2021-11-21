package day_0906;
import java.util.*;
class Programmers_신규아이디추천 {
    public String solution(String new_id) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        sb.append(new_id);
        String ban = "~!@#$%^&*()=+[{]}:?,<>/";
        //case 1
        for(int i = 0; i < new_id.length(); i++) {
            if(sb.charAt(i) >= 'A' && sb.charAt(i) <= 'Z'){
                sb.setCharAt(i, (char)(sb.charAt(i) + 32));
            }
        }
        //case 2
        for(int i = 0; i < sb.length(); i++) {
            if(ban.contains(String.valueOf(sb.charAt(i)))){
                sb.deleteCharAt(i);
                i--;
            }
        }
        int cnt = 0;
        //case 3
        for(int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i) == '.'){
                cnt++;
            } else if(sb.charAt(i) != '.') {
                if(cnt > 1){
                    sb.delete(i - cnt, i - 1);
                    i -= cnt;
                }
                cnt = 0;
            }
            if(i == sb.length() - 1 && cnt > 1){
                sb.delete(i - cnt + 1, i);
            }
        }

        //case 4
        if(sb.length() != 0 && sb.charAt(0) == '.'){
            sb.deleteCharAt(0);
        }
        if(sb.length() != 0 && sb.charAt(sb.length() - 1) == '.'){
            sb.deleteCharAt(sb.length() - 1);
        }
        //case 5
        if(sb.length() == 0){
            sb.append("a");
        }
        //case 6
        if(sb.length() >= 16) {
            sb.setLength(15);
            if(String.valueOf(sb).charAt(14) == '.') {
                sb.setLength(14);
            }
        }
        //case 7
        if(sb.length() < 3) {
            char tmp = String.valueOf(sb).charAt((sb.length() - 1));
            while(true){
                sb.append(tmp);
                if(sb.length() == 3){
                    break;
                }
            }
        }
        answer = String.valueOf(sb);
        return answer;
    }
}