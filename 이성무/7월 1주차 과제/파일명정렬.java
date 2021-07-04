package 실패;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 파일명정렬 {
	public static void main(String[] args) {
		String[] a = { "img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG" };
		System.out.println(Arrays.toString(solution(a)));
	}

	private static class file implements Comparable<file> {
		String head, number, tail, original;

		public file(String head, String number, String tail, String original) {
			super();
			this.head = head;
			this.number = number;
			this.tail = tail;
			this.original = original;
		}

		@Override
		public int compareTo(file o) {
			// TODO Auto-generated method stub
			if (this.head.toUpperCase().equals(o.head.toUpperCase())) { //head 동일하면
				return Integer.parseInt(this.number) - Integer.parseInt(o.number); //number로
			} else {
				int size = Math.min(this.head.length(), o.head.length()); //작은 것을 기준으로
				String thi = this.head.toUpperCase(); //대문자 맞추기
				String ohi = o.head.toUpperCase();
				for (int i = 0; i < size; i++) { //문자열 비교
					if (thi.charAt(i) - ohi.charAt(i) != 0) {
						return thi.charAt(i) - ohi.charAt(i);
					}
				}
				return thi.length() - ohi.length(); //끝까지 같으면 길이도 확인
			}
		}
	}

	public static String[] solution(String[] files) {
		String original,tail;
		int start, hend, nend, tend;
		ArrayList<file> list = new ArrayList<>();
		for (int i = 0; i < files.length; i++) {
			original = files[i];
			start = 0;
			tail = "";
			while (true) { // head찾기
				if (original.charAt(start) >= '0' && original.charAt(start) <= '9') {
					hend = start;
					break;
				}
				start++;
			}
			while (true) { // number찾기
				if(start==original.length()) {
					nend = start;
					break;
				}
				if (original.charAt(start) < '0' || original.charAt(start) > '9') {
					nend = start;
					break;
				}
				start++;
			}
			if(nend!=original.length()) { // tail 있는지 확인				
				tend = original.length();
				tail = original.substring(nend, tend);
			}
			list.add(new file(original.substring(0, hend), original.substring(hend, nend),
					tail, original)); //찾은 인덱스 들로 String split
		}
		Collections.sort(list); //정렬
		String[] answer = new String[list.size()];
		int k = 0;
		for (file a : list) { //옮겨담기
			answer[k++] = a.original;
		}
		return answer;
	}
}
