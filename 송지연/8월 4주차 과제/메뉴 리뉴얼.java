import java.util.*;

class Solution {
    
    HashSet<String> combMenus;
    char[] combMenu;
    
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        
        combMenus = new HashSet<>(); // 전체 메뉴 구성이 담김
        for(int courseCnt : course) {
            combMenu = new char[courseCnt];
            for(String order : orders) {
                char[] tmp = order.toCharArray(); // 중복 방지하기 위해 정렬
                Arrays.sort(tmp);
                order = new String(tmp);
                comb(order, 0, 0, courseCnt);
            }
        }
        
        List cm = new ArrayList(combMenus);
        Collections.sort(cm, new Comparator<String>() { // 길이별 정렬
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        
//         해당 구성이 orders에 있는거랑 어떻게 비교해야할지 모르겠음
//         for(int i=0;i<cm.size();i++) {
//             String compare = cm.get(i);
            
//             for(String order : orders) {
                
//             }
//         }
        
        
        return answer;
    }
    
    public void comb(String order, int start, int cnt, int courseCnt) { // 조합 만들기
        if(cnt == courseCnt) {
            String res = "";
            for(char tmp : combMenu) {
                res += tmp;
            }
           
            combMenus.add(res);
            return;
        }
        if(start >= order.length()) return;
        
        for(int i=start;i<order.length();i++) {
            combMenu[cnt] = order.charAt(i);
            comb(order, i+1, cnt+1, courseCnt);
        }
    }
    
}