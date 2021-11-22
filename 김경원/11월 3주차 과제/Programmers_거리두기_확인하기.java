
public class Programmers_거리두기_확인하기 {
	public static void main(String[] args) {
		
		String[][] places = {{"OOPOO", "OPOOO", "OOOOO", "OOOOO", "OOOOO"},
				{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
				{"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
				{"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
				{"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
		
		int[] answer = new int[5];
		
		answer = solution(places);
		
		for(int ans : answer) {
			System.out.println(ans);
		}
	}
	
    static public int[] solution(String[][] places) {        
        int placesCnt = places.length;
        
        int[] answer = new int[placesCnt];
        
        for(int t=0; t<placesCnt;t++) {
        	answer[t] = 0;
        	if(isSafe(places[t])) {
        		answer[t] = 1;
        	}
        }

        return answer;
    }
    
    
    static public boolean isSafe(String[] places) {
    	
        int[] ni = {0,2,1,0};
        int[] nj = {2,0,0,1};
        
    	
      	for(int i=0;i<5;i++) {
    		for(int j=0;j<5;j++) {
    			
    			if(places[i].charAt(j) != 'P') continue;
    			
    			for(int d=0;d<4;d++) {
    				int y = i + ni[d];
    				int x = j + nj[d];
    				int sub_y = i+ni[d]/2;
    				int sub_x = j+nj[d]/2;
    				
    				if(x>= 5 || y>=5 ) continue;
    				
    				if(places[y].charAt(x) == 'P' && places[sub_y].charAt(sub_x) != 'X')
    					return false; 				
    				
    			}
    			
    			if(i==4 || j ==4) continue;
    			
    			
    			
    			if(i!=0 && places[i-1].charAt(j+1) == 'P' &&   (places[i-1].charAt(j) != 'X' || places[i].charAt(j+1) != 'X'))
    				return false;
    			
    			
    			if(places[i+1].charAt(j+1) == 'P' &&   (places[i+1].charAt(j) != 'X' || places[i].charAt(j+1) != 'X'))
    				return false;
    			
    			
    		}
    	}
    	
    	
    	return true;
    }
    
}
