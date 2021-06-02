import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        for(int i=0; i<str1.length()-1; i++) {
            String s = str1.substring(i,i+2);
            if(('A' <= s.charAt(0) && s.charAt(0) <= 'Z') && ('A' <= s.charAt(1) && s.charAt(1) <= 'Z'))
                list1.add(s);
        }

        for(int i=0; i<str2.length()-1; i++) {
            String s = str2.substring(i,i+2);
            if(('A' <= s.charAt(0) && s.charAt(0) <= 'Z') && ('A' <= s.charAt(1) && s.charAt(1) <= 'Z'))
                list2.add(s);
        }
        
        double sum = list1.size() + list2.size(); //합집합 
        double inter = 0; //교집합 

        if(list1.size() > list2.size()) {
            for(int i=0; i<list2.size(); i++) {
                int idx = list1.indexOf(list2.get(i));
                if(idx!=-1) {
                    list1.remove(idx);
                    inter++;
                }
            }
        } else {
            for(int i=0; i<list1.size(); i++) {
                int idx = list2.indexOf(list1.get(i));
                if(idx!=-1) {
                    list2.remove(idx);
                    inter++;
                }
            }
        }
        sum -= inter;
        
        if(inter == 0 && sum == 0) return 65536;

        answer= (int)((inter/sum) * 65536);
        return answer;
    }
}