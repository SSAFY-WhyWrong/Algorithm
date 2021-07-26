package M07_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_11723_집합 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		
		int s = 0;
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");

			String word = st.nextToken();

			switch (word) {
			case "add":
				// or 연산은 두 비트 중 1개만 1이면 1이다.
				s |= (1 << Integer.parseInt(st.nextToken()));
				break;
			case "remove":
				//~를 통해 비트를 반전해주고, and (두 비트 모두가 1이면 1)을 통해 삭제 시켜준다.
				s &= ~(1 << Integer.parseInt(st.nextToken()));
				break;
			case "check":
				if((s & (1 << Integer.parseInt(st.nextToken()))) > 0) sb.append(1+"\n");
				// 이 줄을 ==1로 하면 틀리네 ㄷ왜지?
				else sb.append(0+"\n");
				break;
			case "toggle":
				s ^= (1 << Integer.parseInt(st.nextToken()));
				break;
			case "all":
				s = ~(1 << 21); //이게 맞으려나
				break;
			case "empty":
				s = 0;
				break;
			}
		}
		System.out.println(sb.toString());
	}
}
