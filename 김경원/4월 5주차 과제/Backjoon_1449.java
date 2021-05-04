import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Backjoon_1449 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		List<Integer> pipe = new ArrayList();
		
		int N, L;
		int result;
		
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken(" "));
		L = Integer.parseInt(st.nextToken(" "));
		
		result = N;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			pipe.add(Integer.parseInt(st.nextToken(" ")));
		}
		
		Collections.sort(pipe);
		
		for(int i=0;i<N;i++) {
			int skip=0;
			for(int j=i+1;j<N;j++) {
				if(pipe.get(i) + L > pipe.get(j)) {
					skip++;
					result--;
				}else {
					break;
				}
			}
			i += skip;
		}
		
		System.out.println(result);
		
		
		
	}
}
