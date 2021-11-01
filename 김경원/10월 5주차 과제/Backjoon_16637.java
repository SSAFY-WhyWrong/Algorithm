import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Backjoon_16637 {
	
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		result = Integer.MIN_VALUE;		
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		DFS(0,0,N,str);
		
		System.out.println(result);
		
	}
	
	static void DFS(int idx, int value, int N, String str) {
		if(idx >= N) {
			result = Math.max(result, value);
			return;
		}
		char token;
		int num = str.charAt(idx) -'0';
		token = '+';
		if(idx > 0) token = str.charAt(idx-1);
		
		DFS(idx+2, calc(value,num,token), N, str);
		
		if(idx +2 < N) {
			int temp = calc(value,calc(num,str.charAt(idx+2)-'0',str.charAt(idx+1)),token);
			DFS(idx+4, temp, N, str);
		}
		
		
		
	}
	
	static int calc(int a, int b, char token) {
		

		
		if(token=='+')
			return (a+b);
		
		if(token =='-')
			return (a-b);
		
		
		
		return (a*b);		
		
	}
}
