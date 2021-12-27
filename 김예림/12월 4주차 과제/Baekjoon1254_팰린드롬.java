package AlgorithmStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1254_팰린드롬 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		
		int size = s.length();
		int len = 0;
		
		String add = "";
		StringBuffer sb = new StringBuffer(s);
		String rev = sb.reverse().toString();
		if(rev.equals(s)) {
			len = s.length();
		}else {
			for(int i=0; i<size; i++) {
				add += s.charAt(i);
				
				StringBuffer revsb = new StringBuffer(add);
				String addrev = revsb.reverse().toString();
				
				String tot1 = s + addrev;
				String tot2 = add + rev;
				
				if(tot1.equals(tot2)) {
					len = tot1.length();
					break;
				}
			}
		}
		
		System.out.println(len);
	}
}
