import java.util.ArrayList;
import java.util.List;

public class Programmers_N으로_표현 {
	public static void main(String[] args) {
		int N = 5;
		int number = 12;
		System.out.println(solution(N,number));
		
	}
	
    static public int solution(int N, int number) {
        int answer = 0;
        int num=0;
        
        List<Integer> list[] = new ArrayList[10];
        for(int i=1;i<=9;i++) {
        	list[i] = new ArrayList();
        }
        
        for(int i=1;i<=8;i++) {
        	num = num*10 +N;
        	list[i].add(num);
        
        	for(int j=1;j<i;j++) {
        		for(int x : list[j]) {
        			for(int y : list[i-j]) {
        				list[i].add(x+y);         				
        				list[i].add(x-y);
        				list[i].add(x*y);
        				if(y!=0)
        					list[i].add(x/y);
        			}
        		}
        	}
        	if(list[i].contains(number)) {
        		return (i);
        	}
        	
        }

        
        return -1;
    }
}
