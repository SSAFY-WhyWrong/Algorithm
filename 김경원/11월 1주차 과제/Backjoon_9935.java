import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Backjoon_9935 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String str = br.readLine();
		String pat = br.readLine();
		
		Stack<Character> stack = new Stack();
		
		for(int i=0;i<str.length();i++) {
			stack.push(str.charAt(i));
			
			if(stack.size() >= pat.length()) {
				boolean flag = true;
				
				for(int j=0;j<pat.length();j++) {
					if(stack.get(stack.size() - pat.length() + j)!= pat.charAt(j)) {
						flag = false;
						break;
					}
				}
				if(flag) {
					for(int j=0;j<pat.length();j++) {
						stack.pop();
					}
				}
				
			}			
		}
		
		for(char c : stack) {
			sb.append(c);
		}
		
		if(stack.size() ==0)
			sb.append("FRULA");
		
		System.out.println(sb.toString());
		
		
		

	}


}
