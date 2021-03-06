import java.util.Arrays;

public class 프로그래머스_완주하지못한선수 {

	   public String solution(String[] participant, String[] completion) {
	        Arrays.sort(participant);
	        Arrays.sort(completion);
	        
	        int index=0;
	        for(String name:completion){
	            if(!name.equals(participant[index]))
	                return participant[index];
	            index+=1;
	        }
	        return participant[participant.length-1];
	    }
}
//import java.util.HashMap;
/*class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String,Integer> hash_map=new HashMap<>();
        for(String name : participant){
            hash_map.put(name,hash_map.getOrDefault(name,0)+1);
        }
        for(String name : completion){
            hash_map.put(name,hash_map.get(name)-1);
        }
        for(String name: hash_map.keySet()){
            if(hash_map.get(name)!=0){
                answer=name;
                break;
            }            
        }
        return answer;
    }
}*/
/*
- 해쉬map을 처음 이용해보았다.
- 처음문제를 풀때는 각각 참가자와 완료자들의 집합을 정렬한뒤, 비교하여 이름이 틀릴경우 그 이름을 추출하였다.
- getOrDefault는 key가 없을시에 , default 값 넣기 아니면 해당 값넣기 함수이다.
*/
