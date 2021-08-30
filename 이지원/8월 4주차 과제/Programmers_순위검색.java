package day_0830;
import java.util.*;

class Programmers_순위검색 {
    public int[] solution(String[] info, String[] query) {
        int[] answer = {};
        answer = new int[query.length];
        Info[] in = new Info[info.length];
        for(int i = 0; i < info.length; i++){
            String[] temp = info[i].split(" ");
            in[i] = new Info(temp[0], temp[1], temp[2], temp[3], Integer.parseInt(temp[4]));
        }
        Arrays.sort(in);
        for(int i = 0; i < query.length; i++){
            String[] temp = query[i].split(" and ");
            String[] tmp = temp[3].split(" ");
            for(int s = 0; s < in.length; s++) {
                
                if((in[s].lang.equals(temp[0]) || temp[0].equals("-")) && (in[s].position.equals(temp[1]) || temp[1].equals("-")) && (in[s].job.equals(temp[2]) || temp[2].equals("-")) && (in[s].food.equals(tmp[0]) || tmp[0].equals("-")) && (in[s].score >= Integer.parseInt(tmp[1]) || tmp[1].equals("-"))) {
                    answer[i]++;
                }
            }
        }
        return answer;
    }

    static class Info implements Comparable<Info>{
        String lang, position, job, food;
        int score;
        public Info(String lang, String position, String job, String food, int score){
            this.lang = lang;
            this.position = position;
            this.job = job;
            this.food = food;
            this.score = score;
        }
        @Override
        public int compareTo(Info o){
            return this.score - o.score;
        }
    }
    public int binarySearch(Info[] arr, int target) {
        int first = 0;
        int last = arr.length - 1;
        int mid;
        while (first <= last) {
            mid = (first + last) / 2;
            if (target == arr[mid].score) {
                return mid;
            } else {
                if (target < arr[mid].score) {
                    last = mid - 1; 
                } else {
                    first = mid + 1; 
                } 
            } 
        } 
        return -1; 
    }
}