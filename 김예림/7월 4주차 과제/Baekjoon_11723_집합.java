package M07_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_11723_���� {
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
				// or ������ �� ��Ʈ �� 1���� 1�̸� 1�̴�.
				s |= (1 << Integer.parseInt(st.nextToken()));
				break;
			case "remove":
				//~�� ���� ��Ʈ�� �������ְ�, and (�� ��Ʈ ��ΰ� 1�̸� 1)�� ���� ���� �����ش�.
				s &= ~(1 << Integer.parseInt(st.nextToken()));
				break;
			case "check":
				if((s & (1 << Integer.parseInt(st.nextToken()))) > 0) sb.append(1+"\n");
				// �� ���� ==1�� �ϸ� Ʋ���� ������?
				else sb.append(0+"\n");
				break;
			case "toggle":
				s ^= (1 << Integer.parseInt(st.nextToken()));
				break;
			case "all":
				s = ~(1 << 21); //�̰� ��������
				break;
			case "empty":
				s = 0;
				break;
			}
		}
		System.out.println(sb.toString());
	}
}
