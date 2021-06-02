package study_sovle;

import java.util.*;

public class Programmers_튜플 {
	public int[] solution(String s) {
		int[] answer = {};
		StringBuilder sb = new StringBuilder();
		StringBuilder no = new StringBuilder();
		ArrayList<String> al = new ArrayList<>();
		for (int i = 2; i < s.length() - 1; i++) {
			char tmp = s.charAt(i);
			if (tmp >= '0' && tmp <= '9' || tmp == ',') {
				sb.append(tmp);
			} else if (tmp == '}') {
				i++;
				no.append(tmp);
				tmp = s.charAt(i);
				if (tmp == ',') {
					no.append(tmp);
					i++;
					tmp = s.charAt(i);
					if (tmp == '{') {
						no.append(tmp);
						al.add(String.valueOf(sb));
						sb.setLength(0);
						no.setLength(0);
					}
				} else if (tmp == '}') {
					al.add(String.valueOf(sb));
				}
			}
		}
		String[] arr = new String[al.size()];
		for (int i = 0; i < al.size(); i++) {
			arr[i] = al.get(i);
		}

		for (int i = 0; i < al.size(); i++) {
			for (int j = i; j < al.size(); j++) {
				if (arr[i].length() > arr[j].length()) {
					String tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}

		answer = new int[al.size()];
		int a = 0;
		HashMap<String, Integer> ha = new HashMap<>();
		for (int i = 0; i < al.size(); i++) {
			String[] tmp = arr[i].split(",");
			for (int j = 0; j < tmp.length; j++) {
				if (!ha.containsKey(tmp[j])) {
					ha.put(tmp[j], 1);
					answer[a] = Integer.parseInt(tmp[j]);
					a++;
				}
			}
		}

		return answer;
	}
}
