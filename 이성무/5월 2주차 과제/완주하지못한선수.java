package 성공;

import java.util.ArrayList;

public class 완주하지못한선수 {
	public String solution(String[] participant, String[] completion) {
		String answer = "";
		int size = completion.length;
		int leng = 0, sum;
		String s;
		//최대 가질 수 있는 값 2440
		ArrayList<String>[] array = new ArrayList[2441];
		for (int i = 0; i < size; i++) {
			//성공한 사람들의 이름을 char형으로 나누어 sum에 더하고 그 값에 해당하는 배열 리스트에 String저장
			sum = 0;
			leng = completion[i].length();
			s = completion[i];
			for (int j = 0; j < leng; j++) {
				sum += s.charAt(j) - 'a';
			}
			if (array[sum] == null) {
				array[sum] = new ArrayList<>();
				array[sum].add(s);
			} else {
				array[sum].add(s);
			}
		}
		size += 1;
		for (int i = 0; i < size; i++) {
			//참가자의 이름을 char형으로 나누어 sum에 더하고 그 값에 해당하는 배열리스트에 같은 스트링값이 없으면 정답
			//있으면 지워준다. 중복방지
			s = participant[i];
			leng = s.length();
			sum = 0;
			for (int j = 0; j < leng; j++) {
				sum += s.charAt(j) - 'a';
			}
			if (array[sum] == null) {
				answer = s;
			} else if (!array[sum].contains(s)) {
				answer = s;
				return answer;
			}else {
				array[sum].remove(s);
			}
		}
		return answer;
	}

}
