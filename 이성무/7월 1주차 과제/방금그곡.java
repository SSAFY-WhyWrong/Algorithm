package 실패;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 방금그곡 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] array = { "12:00,12:14,HELLO,C#DEFGAB", "13:00,13:12,WORLD,ABCDEFAAC" ,"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B","12:00,12:12,HELLO,CDEFGAB", "13:00,13:01,WORLD,ABCDEF"};
		System.out.println(solution("ABC", array));
	}

	// C, C#, D, D#, E, F, F#, G, G#, A, A#, B
	private static class music implements Comparable<music>{
		String title;
		int[] code;
		int term,start;

		public music(String title, int[] code,int term,int start) {
			super();
			this.title = title;
			this.code = code;
			this.term= term;
			this.start= start;
		}

		@Override
		public int compareTo(music o) {
			// TODO Auto-generated method stub
			return this.term-o.term;
		}
		
	}

	private static int maxLength = -200;
	private static String answer;
	private static ArrayList<Integer> convert;

	public static String solution(String m, String[] musicinfos) {
		maxLength = -200;
		answer = null;
		ArrayList<music> list = new ArrayList<>();
		convert = new ArrayList<>();
		for (int i = 0; i < m.length(); i++) {
			if (i != m.length() - 1 && m.charAt(i + 1) == '#') {
				convert.add(m.charAt(i) - 'A' + 7);
				i++;
			} else {
				convert.add(m.charAt(i) - 'A');
			}
		}
		music k;
		for (int i = 0; i < musicinfos.length; i++) {
			k = make(musicinfos[i]);
			if (k != null)
				list.add(k);
		}
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			confirm(list.get(i));
		}
		if(maxLength==-200)return "(None)";
		return answer;
	}

	private static void confirm(music music) { //내가들은 코드와 맞는지 확인
		int index = 0, start;
		int[] a = music.code;
		for (int i = 0; i < a.length; i++) {
			if (convert.get(0) == a[i]) {
				start = 1;
				index = i + 1;
				if(index==a.length)index=0;
				if(start>=convert.size()) { //들은코드가 코드 한개 일수도 있어서 처리
					if (maxLength < music.term) {
						maxLength = music.term;
						answer = music.title;
					}
					return;
				}
				while (true) {
					if (a[index] == convert.get(start)) {
						index++;
						start++;
						if (index == a.length)
							index = 0;
						if (start >= convert.size()) { //길이가 더 긴거 갱신
							if (maxLength < music.term) {
								maxLength = music.term;
								answer = music.title;
							}
							return;
						}
					} else {
						break;
					}
				}
			}
		}
	}

	private static music make(String str) { //코드를 만드는 메소드
		// TODO Auto-generated method stub
		String start, end, title, code;
		int term, down, up, index = 0;
		StringTokenizer st = new StringTokenizer(str, ",");
		start = st.nextToken();
		end = st.nextToken();
		title = st.nextToken();
		code = st.nextToken();
		down = Integer.parseInt(start.substring(0, 2)) * 60;
		down += Integer.parseInt(start.substring(3, 5));

		up = Integer.parseInt(end.substring(0, 2)) * 60;
		up += Integer.parseInt(end.substring(3, 5));
		term = up - down;
		if (term < convert.size())
			return null;
		int[] codeArray = new int[term];
		for (int i = 0; i < term; i++) { //코드 숫자로 변환해서 배열 작성
			codeArray[i] += code.charAt(index) - 'A';
			if (index != code.length() - 1 && code.charAt(index + 1) == '#') {
				codeArray[i] += 7;
				index++;
			}
			index++;
			if (index >= code.length())
				index = 0;
		}
//		System.out.println(Arrays.toString(codeArray));
		music m = new music(title, codeArray,term,down);
		return m;
	}

}
