import java.util.*;
import java.io.*;

public class 백준_1756_피자굽기 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int D = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] oven = new int[D+1];
		int[] pizza = new int[N];
		
		st = new StringTokenizer(bf.readLine());
		for(int i=1;i<D+1;i++) {
			oven[i] = Integer.parseInt(st.nextToken());
			if(i > 1 && oven[i-1] < oven[i]) {
				oven[i] = oven[i-1];
			}
		}
		
		st = new StringTokenizer(bf.readLine());
		for(int i=0;i<N;i++) {
			pizza[i] = Integer.parseInt(st.nextToken());
		}
		
		int startOvenIdx = 1, endOvenIdx = D, lastPizzaIdx = 0;
		for(int i=0;i<N;i++) {
			if(pizza[i] > oven[1]) {
				lastPizzaIdx = 0;
				break;
			}

			while(startOvenIdx <= endOvenIdx) {
				int midOvenIdx = (startOvenIdx + endOvenIdx) / 2;

				if(pizza[i] > oven[midOvenIdx]) {
					endOvenIdx = midOvenIdx - 1;
				} else {
					startOvenIdx = midOvenIdx + 1;
					lastPizzaIdx = midOvenIdx;
				}
			}
			
			endOvenIdx = lastPizzaIdx - 1;
			startOvenIdx = 1;
		}
		
		System.out.println(lastPizzaIdx);
	}

}
