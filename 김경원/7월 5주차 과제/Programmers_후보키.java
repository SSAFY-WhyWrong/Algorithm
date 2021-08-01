import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Programmers_후보키 {	
	public static void main(String[] args) {
		String[][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"}
		,{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}
		};
		
		solution(relation);
	}
	
	static public int solution(String[][] relation) {
	        int answer = 0;
	        
	        int y = relation.length;
	        int x = relation[0].length;
	        
	        List<Integer> candidateKey = new ArrayList();
	        
	        
	        boolean isUnique;
	        
	        for(int bit=1;bit < (1 << x);bit++) {
	        	if(!isMinimal(candidateKey,bit))
	        		continue;
	        	

	        	
	        	if(isUnique(relation,bit,x,y)) {
	        		candidateKey.add(bit);
	        		answer++;
	        	}
	        	
	        }
	        
	        System.out.println("정답 : " + answer);
	        
	        return answer;
	    }
	
	static public boolean isMinimal(List<Integer> candidateKey , int bit) {
		for(int key : candidateKey ) {
			if((key & bit) == key)
				return false;
		}
				
		return true;
	}
	
	
	static public boolean isUnique(String[][] relation, int bit, int x, int y) {
    	HashSet<String> set = new HashSet();
  
    	for(int i=0;i<y;i++) {
    		StringBuilder sb = new StringBuilder();
    		for(int j=0;j<x;j++) {
    			if((1<<j & bit)!=0) sb.append(relation[i][j]);
    		}
    		
    		if(set.contains(sb.toString()))
    			return false;
    		
    		set.add(sb.toString());
    		
    		
    	}
    	
		return true;
	}
	
}


