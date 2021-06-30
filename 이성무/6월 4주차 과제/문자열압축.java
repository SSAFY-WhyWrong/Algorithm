package 실패;

import java.io.IOException;

public class 문자열압축 {

	 public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println(solution(
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
	}

	private static int size;

	public static int solution(String s) {
		int answer = 0;
		size = s.length();
		int min = size;
		for (int i = 1; i < size; i++) {
			min = Math.min(min, compress(i, s));
		}
		answer = min;
		return answer;
	}

	private static int compress(int term, String s) {
		StringBuilder sb = new StringBuilder();
		sb.append(s.substring(0, term));
		StringBuilder copy;
		int cnt = 0, answer = 0, repeat = 1;
		for (int i = term; i < size; i++) {
			copy = new StringBuilder();
			cnt = 0;
			while (i < size) {
				cnt++;
				copy.append(s.charAt(i));
				if (cnt == term)
					break;
				i++;
			}
			if (copy.toString().equals(sb.toString())) {
				repeat++;
			} else {
				if (repeat != 1) {
					answer += (term + String.valueOf(repeat).length());
					repeat = 1;
				} else {
					answer += term;
				}
				sb = copy;
			}
		}
		if (repeat != 1) {
			answer += (term + String.valueOf(repeat).length());
		} else {
			answer += (sb.length());
		}
		 return answer;
	}
}
