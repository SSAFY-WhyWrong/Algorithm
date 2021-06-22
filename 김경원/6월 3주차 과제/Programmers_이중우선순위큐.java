import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Programmers_이중우선순위큐 {
	public static void main(String[] args) {
		String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
		int answer[] = solution(operations);
		System.out.println(answer[0] + " " + answer[1]);
	}

	static public int[] solution(String[] operations) {
		int[] answer = new int[2];
		List<Integer> list = new ArrayList();
		int oper_length = operations.length;
		int cnt = 0;
		for (int i = 0; i < oper_length; i++) {
			// 삽입
			int num = Integer.parseInt(operations[i].substring(2));
			if (operations[i].charAt(0) == 'I') {
				list.add(num);
				cnt++;
				Collections.sort(list);
			}
			// 삭제
			else {
				if (cnt != 0) {
					if (num == 1) {
						list.remove(cnt-1);
					} else {
						list.remove(0);
					}
					cnt--;
				}
			}
		}
		

		
		
		if (cnt == 0) {
			answer[0] = 0;
			answer[1] = 0;
		} else {
			answer[0] = list.get(cnt - 1);
			answer[1] = list.get(0);
		}
		return answer;
	}
}
