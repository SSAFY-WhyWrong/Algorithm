import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Programmers_방금그곡 {
	public static void main(String[] args) {
		String m = "ABCFF";
		String musicinfos[] = { "12:00,12:14,HELLO,CDEFGAB", "13:00,13:14,WORLD,ABCDEF" };

		solution(m, musicinfos);

	}

	static class Node implements Comparable<Node> {
		String m;
		int len;
		String name;
		String melody;

		Node(String m) {
			int idx;
			this.len = getLength(m);
			idx = getNameIdx(m);
			this.name = m.substring(12, idx);
			this.melody = m.substring(idx + 1, m.length());
			this.melody = parseMelody(this.melody);
		}

		int getLength(String m) {
			int min, hour, start, end;
			hour = Integer.parseInt(m.substring(0,2));
			min = Integer.parseInt(m.substring(3,5));			
			start = hour * 60 + min;


			hour = Integer.parseInt(m.substring(6,8));
			min = Integer.parseInt(m.substring(9,11));	
			end = hour * 60 + min;

			return end - start;
		}

		public int getNameIdx(String m) {
			for (int i = 12; i < m.length(); i++) {
				if (m.charAt(i) == ',') {
					return i;
				}
			}

			return 0;
		}

		@Override
		public int compareTo(Node o) {
			return o.len - this.len;
		}
	}

	static public String parseMelody(String melody) {
		String target[] = { "C#", "D#", "E#", "F#", "G#", "A#" };
		String replacement[] = { "c", "d", "e", "f", "g", "a" };

		String parse_str = melody;
		for (int i = 0; i < 6; i++) {
			parse_str = parse_str.replaceAll(target[i], replacement[i]);
		}

		return parse_str;
	}

	static public String solution(String m, String[] musicinfos) {
		String answer = "";
		int result = -1;
		m = parseMelody(m);
		List<Node> list = new ArrayList();

		for (int i = 0; i < musicinfos.length; i++) {
			list.add(new Node(musicinfos[i]));
		}
		Collections.sort(list);

		String melody;
		for (int i = 0; i < musicinfos.length; i++) {
			melody = parseMelody(list.get(i).melody);
			System.out.println(melody);			

			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < list.get(i).len; j++) {
				sb.append(melody.charAt(j % melody.length()));
			}
			if (sb.toString().contains(m)) {
				result = i;
				break;
			}
		}
		if (result == -1)
			answer = "(None)";
		else
			answer = list.get(result).name;

		System.out.println(answer);

		return answer;
	}
}
