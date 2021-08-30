package day_0830;
import java.util.*;

class Programmers_메뉴리뉴얼 {
    static HashMap<String, Integer> map;
    static boolean chk;
    static int[] arr;
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        arr = new int[11];
        map = new HashMap<>();
        for(int i = 0; i < orders.length; i++){
            char[] temp = orders[i].toCharArray();
            Arrays.sort(temp);
            for(int j = temp.length; j >= 2; j--){
                chk = false;
                comb(0, 0, temp, new boolean[temp.length], j, course);
            }
        }
        int cnt = 0;
        for(String k : map.keySet()){
            arr[k.length()] = Math.max(map.get(k), arr[k.length()]);
        }
        for(String k : map.keySet()){
            if(arr[k.length()] <= map.get(k) && map.get(k) >= 2){
                cnt++;
            }
        }
        answer = new String[cnt];
        cnt = 0;
        for(String k : map.keySet()){
            if(arr[k.length()] <= map.get(k) && map.get(k) >= 2){
                answer[cnt++] = k;
            }
        }
        Arrays.sort(answer);
        return answer;
    }
    
    static void comb(int target, int cnt, char[] temp, boolean[] visited, int r, int[] course){
        if(cnt == r){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < temp.length; i++){
                if(visited[i]){
                    sb.append(temp[i]);
                }
            }
            for(int i = 0; i < course.length; i++){
                if(sb.length() == course[i]){
                    if(map.containsKey(String.valueOf(sb))){
                        map.put(String.valueOf(sb), map.get(String.valueOf(sb)) + 1);
                    } else {
                        map.put(String.valueOf(sb), 1);
                    }
                }
            }
            return;
        }
        
        if(target == temp.length){
            return;
        }
        
        visited[target] = true;
        comb(target + 1, cnt + 1, temp, visited, r, course);
        visited[target] = false;
        comb(target + 1, cnt, temp, visited, r, course);
    }
}