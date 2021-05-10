import java.util.Arrays;

class Programmers_완주하지_못한_선수_hash {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        HashMap<String, Integer> hash = new HashMap();
        
        int length = completion.length;
        for(int i=0;i<length;i++){
            if(hash.get(completion[i]) == null){
                hash.put(completion[i],1);
            }else{
                int num = hash.get(completion[i]);
               hash.put(completion[i],num+1);
            }
        }
        
        length = participant.length;
        for(int i=0;i<length;i++){
            if(hash.get(participant[i]) != null && hash.get(participant[i])!=0){
                int num = hash.get(participant[i]);
                hash.put(participant[i],num-1);
            }else{
                answer =participant[i];
                break;
            }
        }
        
        
        return answer;
    }
}