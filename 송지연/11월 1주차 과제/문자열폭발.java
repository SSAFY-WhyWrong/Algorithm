import java.io.*;
import java.util.*;

public class 문자열폭발{

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		String compare = sc.next();
		Stack<Character> stack = new Stack<>();
		
		for(int i=0;i<word.length();i++) {
			stack.add(word.charAt(i));
		
			if(stack.size() < compare.length()) continue;
			
			boolean flag = true;
			for (int j=0;j<compare.length();j++) {
				if (stack.get(stack.size() - compare.length() + j) != compare.charAt(j)) {
					flag = false;
					break;                                            
				}
			}
			
			if (flag) {
				for (int j=0;j<compare.length();j++) {
					stack.pop();
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(char c : stack) {
			sb.append(c);
		}
		
		System.out.println(sb.length() > 0 ? sb.toString() : "FRULA");
		
		
	}

}
