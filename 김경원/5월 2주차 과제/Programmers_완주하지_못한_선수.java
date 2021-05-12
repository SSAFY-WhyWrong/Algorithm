import java.util.Arrays;

class Programmers_완주하지_못한_선수 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        int arrayLength = completion.length;
        
        for(int i=0;i<arrayLength;i++){
            if(participant[i].equals(completion[i])) continue;
            answer = participant[i];
            break;
        }
        
        if(answer.length()==0) answer = participant[arrayLength];
        
        return answer;
    }
}