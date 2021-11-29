import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        HashMap<String, Integer> phone_books = new HashMap<>();
        
        // 정렬을 먼저해야 효율적으로 접두어 비교를 할 수 있음
        Arrays.sort(phone_book);
        for(String phone : phone_book) {
            String key = "";
            for(int i=0;i<phone.length();i++) {
                key += Character.toString(phone.charAt(i));
                if(phone_books.containsKey(key)) {
                    return false;
                }
            }
            
            phone_books.put(phone, 1);
        }
        
        
        return true;
    }
}