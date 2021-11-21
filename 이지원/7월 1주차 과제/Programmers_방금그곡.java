package day_0704;

public class Programmers_방금그곡 {
	public String solution(String m, String[] musicinfos) {
		String answer = "(None)";
		int time = 0;

		if (m.contains("C#")) {
			m = m.replace("C#", "1");
		}
		if (m.contains("D#")) {
			m = m.replace("D#", "2");
		}
		if (m.contains("F#")) {
			m = m.replace("F#", "3");
		}
		if (m.contains("G#")) {
			m = m.replace("G#", "4");
		}
		if (m.contains("A#")) {
			m = m.replace("A#", "5");
		}

		for (int i = 0; i < musicinfos.length; i++) {
			String[] temp = musicinfos[i].split(",");

			if (temp[3].contains("C#")) {
				temp[3] = temp[3].replace("C#", "1");
			}
			if (temp[3].contains("D#")) {
				temp[3] = temp[3].replace("D#", "2");
			}
			if (temp[3].contains("F#")) {
				temp[3] = temp[3].replace("F#", "3");
			}
			if (temp[3].contains("G#")) {
				temp[3] = temp[3].replace("G#", "4");
			}
			if (temp[3].contains("A#")) {
				temp[3] = temp[3].replace("A#", "5");
			}

			String[] start = temp[0].split(":");
			String[] end = temp[1].split(":");
			int start_hour = Integer.parseInt(start[0]);
			int end_hour = Integer.parseInt(end[0]);
			int start_minute = Integer.parseInt(start[1]);
			int end_minute = Integer.parseInt(end[1]);
			int diff_hour = end_hour - start_hour;
			int diff_minute = end_minute - start_minute;
			int diff_time = diff_hour * 60 + diff_minute;
			StringBuilder sb = new StringBuilder();
			char[] arr = temp[3].toCharArray();
			for (int j = 0; j <= diff_time; j++) {
				sb.append(arr[j % arr.length]);
			}

			if (String.valueOf(sb).contains(m)) {
				if (time < sb.length()) {
					time = sb.length();
					answer = temp[2];
				}
			}
		}
		return answer;
	}
}
