import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Backjoon_3663 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T;
		
		T = Integer.parseInt(br.readLine());
		
		
		for(int t=0;t<T;t++) {
			String name = br.readLine();
			int answer = 0;
			int move = name.length()-1;
			
			for(int i=0;i<name.length();i++) {
				answer += Math.min(name.charAt(i) - 'A',  ('Z' - name.charAt(i)+ 1));
			}
			
			for(int i=0;i<name.length();i++) {
				int next = i+1;
				while(next < name.length() && name.charAt(next)=='A') {
					next++;
				}
				
				if(next != name.length()) {
					int right = i*2 + name.length() - next;
					move = Math.min(move, right);					
				}				
				
				int left = i + (name.length() - next) * 2;				
				move = Math.min(move, left);
				
			}
			
			
			sb.append(answer+move).append('\n');
			
			
		}
		System.out.println(sb);
		
	}
}
