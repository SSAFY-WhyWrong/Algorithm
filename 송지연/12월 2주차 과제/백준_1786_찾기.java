import java.util.*;
import java.io.*;

public class 백준_1786_찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String T = bf.readLine();
		String P = bf.readLine();
		int[] idx = new int[P.length()];
		
		int j = 0;
		for(int i=1;i<P.length();i++) {
			while(j > 0 && P.charAt(i) != P.charAt(j)) {
				j = idx[j-1];
			}
			
			if(P.charAt(i) == P.charAt(j)) {
				idx[i] = ++j;
			}
		}
		
		j = 0;
		int answer = 0;
		ArrayList<Integer> lst = new ArrayList<>();
		
		for(int i=0;i<T.length();i++) {
			while(j > 0 && T.charAt(i) != P.charAt(j)) {
				j = idx[j-1];
			}
			
			if(T.charAt(i) == P.charAt(j)) {
				if(j == P.length() - 1) {
					answer++;
					lst.add(i - P.length() + 2);
					j = idx[j];
				} else {
					j++;
				}
			}
		}
		
		System.out.println(answer);
		for(int i=0;i<lst.size();i++) {
			System.out.print(lst.get(i) + " ");
		}
	}
}
