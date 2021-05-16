import java.util.HashMap;
import java.util.Map;

public class programmers_단체사진_찍기 {
	public static void main(String[] args) {
		String data[] = {"N~F=0", "R~T>2"};
		solution(2,data);
		System.out.println(answer);
	}
	
	static int answer;
	static Map<Character,Integer> map = new HashMap<>();
	static int pos[];
	static public int solution(int n, String[] data) {
        answer = 0;
        
        pos = new int[8];
        for(int i=0;i<8;i++) {
        	pos[i] = 0;
        }
        //A,C,F,J,M,N,R,T
        map.put('A', 0);
        map.put('C', 1);
        map.put('F', 2);
        map.put('J', 3);
        map.put('M', 4);
        map.put('N', 5);
        map.put('R', 6);
        map.put('T', 7);
        
        DFS(n,data,0);
        return answer;
    }
 
 static void DFS(int n, String[] data,int cnt) {
	 if(cnt==8) {
		 answer++;
		 return;
	 }
	 
	 
	 for(int i=0;i<8;i++) {
		 if(pos[i]!=0)
			 continue;
		 
		 pos[i] = cnt+1;
         if(pos_check(n,data)) 
		     DFS(n,data,cnt+1);	 
		 pos[i] = 0;
		 
	 }
	 
	 
 }

private static boolean pos_check(int n, String[] data) {
	int a,b;
	char token;
	int value;
	
	for(int i=0;i<n;i++) {
		a = map.get(data[i].charAt(0));
		b = map.get(data[i].charAt(2));
		token = data[i].charAt(3);
		value = data[i].charAt(4) - '0' +1 ;
				
		if(pos[a] == 0 || pos[b] ==0 ) continue;
        
		if(token == '=') {
			if(Math.abs(pos[a] - pos[b]) != value)
				return false;
			
		}else if(token == '<') {
			if(Math.abs(pos[a] - pos[b]) >= value)
				return false;
		}else if(token =='>'){
			if(Math.abs(pos[a] - pos[b]) <= value)
				return false;
		}
		
	}
	
	
	return true;
}
}
