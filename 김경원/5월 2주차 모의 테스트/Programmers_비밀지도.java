import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Programmers_비밀지도 {
	
	public static void main(String[] args) throws IOException {
		int n =5;
		int arr1[] = {9,20,28,18,11};
		int arr2[] = {30,1,21,17,28};
		
		String answer[] = solution(n,arr1,arr2);
		
		System.out.println(answer);
	
		
		
	}
	
	static public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = {};
        StringBuilder sb = new StringBuilder();
        
        answer = new String[n];
        
        int bit;
        
        boolean visit[][] = new boolean[n][n];
        
        
        for(int i=0;i<n;i++) {
			bit = 1 << n-1;
			for(int j=0;j<n;j++) {
				if((arr1[i] & bit) !=0)
					visit[i][j] = true;

				bit = bit >> 1;
			}				
		}
        
           for(int i=0;i<n;i++) {
			bit = 1 << n-1;
			for(int j=0;j<n;j++) {
				if((arr2[i] & bit) !=0)
					visit[i][j] = true;

				bit = bit >> 1;
			}				
		}
        
        
        for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(visit[i][j])
					sb.append('#');
				else sb.append(' ');
			}
			answer[i] = sb.toString();
            sb = new StringBuilder();
		}
        
       
        
        return answer;
    }
	
	
}
