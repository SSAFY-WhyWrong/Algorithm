package day_0718;

import java.util.*;

public class Programmers_파일명정렬 {
	static String head;
	static char[] temp;

	public String[] solution(String[] files) {
		String[] answer = {};
		List<Name> file = new ArrayList<>();

		for (int i = 0; i < files.length; i++) {
			head = "";
			temp = files[i].toCharArray();
			int idx = head(files[i]);
			head = head.toLowerCase();

			file.add(new Name(head, number(idx, files[i]), files[i]));
		}

		Collections.sort(file);
		answer = new String[files.length];
		for (int i = 0; i < file.size(); i++) {
			answer[i] = file.get(i).name;
		}
		return answer;
	}

	static int head(String name) {
		int idx = 0;
		for (int i = 0; i < name.length(); i++) {
			if (temp[i] >= '0' && temp[i] <= '9') {
				idx = i;
				break;
			} else {
				head += String.valueOf(temp[i]);
			}
		}
		return idx;
	}

	static String number(int idx, String name) {
		String number = "";
		int cnt = 0;
		for (int i = idx; i < temp.length; i++) {
			cnt++;
			if (temp[i] >= '0' && temp[i] <= '9') {
				number += temp[i];
			} else {
				break;
			}
			if (cnt == 5) {
				break;
			}
		}
		return number;
	}

	static class Name implements Comparable<Name> {
		String head;
		String number;
		String name;

		public Name(String head, String number, String name) {
			this.head = head;
			this.number = number;
			this.name = name;
		}

		@Override
		public int compareTo(Name o) {
			int diff = this.head.compareTo(o.head);
			int diff2 = Integer.compare(Integer.parseInt(this.number), Integer.parseInt(o.number));
			return diff == 0 ? diff2 : diff;
		}
	}
}
