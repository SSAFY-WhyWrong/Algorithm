package day_0505;

import java.util.*;

public class Programmers_완주하지못한선수 {
	public String solution(String[] participant, String[] completion) {
		String answer = "";
		HashMap<String, Integer> map = new HashMap<>();

		for (int i = 0; i < participant.length; i++) {
			if (map.containsKey(participant[i])) {
				map.put(participant[i], map.get(participant[i]) + 1);
			} else {
				map.put(participant[i], 1);
			}
		}
		for (int i = 0; i < completion.length; i++) {
			if (map.containsKey(completion[i])) {
				map.put(completion[i], map.get(completion[i]) - 1);
			}
		}
		for (String k : map.keySet()) {
			if (map.get(k) >= 1) {
				answer = k;
			}
		}

		return answer;
	}
}
