import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Programmers_튜플 {
	public static void main(String[] args) {
		
		String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		
		solution(s);
		
	}
	
	
	
	 static public int[] solution(String s) {
	       int[] answer = {};
	        
	       StringTokenizer st = new StringTokenizer(s);
	       
	       
	       List<String>list = new ArrayList();
	       
	       while(st.hasMoreTokens()) {
	    	   s = st.nextToken("{}");
	    	   if(!s.equals(",")) {
	    		   list.add(s);
	    	   }
	       }
	       
	       Collections.sort(list,(String s1,String s2)->s2.length()-s1.length() );
	       Map<String,Integer> map = new HashMap();
	       
	       String temp[] = list.get(0).split(",");
	       int length = temp.length;
	       answer = new int[temp.length];    
	       
	       
	       for(int i=0;i<temp.length;i++)
	    	   map.put(temp[i], 1);
	       
	        int cnt[] = new int[temp.length];
	        
	        for(int i=1;i<list.size();i++) {
	        	temp = list.get(i).split(",");
	        	length = temp.length;
	        	
	        	for(int j=0;j<length;j++) {
	        		int num = map.get(temp[j]);
	        		map.put(temp[j], num+1);
	        	}
	        	
	        }
	        List<String> mapList = new ArrayList<>(map.keySet());
	        Collections.sort(mapList, (o1,o2)->(map.get(o2).compareTo(map.get(o1))));
	        
	        for(int i=0;i<mapList.size();i++) {
	        	answer[i] = Integer.parseInt(mapList.get(i));
	        }
	        
	        return answer;
	    }
}
