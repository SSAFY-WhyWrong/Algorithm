import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Programmers_파일명정렬 {

	static class Node implements Comparable<Node> {
		String name; //원래 파일명
		String head; // 헤드
		int number; // 넘버

		Node(String name) {
			int idx = 0;
			this.name = name;
			idx = getHeadIdx(name);
			this.head = name.substring(0, idx).toLowerCase();
			this.number = getNumber(name,idx);
			
		}
		int getHeadIdx(String name) {
			for (int i = 0; i < name.length(); i++) {
				if (name.charAt(i) >= '0' && name.charAt(i) <= '9') {
					return i;
				}
			}
			return 0;
		}
		
		int getNumber(String name, int idx) {
			int num=0;
			for(int i=idx;i<name.length();i++) {
				if (name.charAt(i) >= '0' && name.charAt(i) <= '9') {
					num *= 10;
					num += name.charAt(i) -'0';
				}else
					break;
			}
			
			return num;
		}
		@Override
		public int compareTo(Node o) {
			
			if(this.head.equals(o.head)) {
				return this.number - o.number;
			}
			
			return this.head.compareTo(o.head);
		}

	}

	public static void main(String[] args) {
		String files[] = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
		
		solution(files);
		
	}

	static public String[] solution(String[] files) {
		String[] answer = {};
		
		List<Node> list = new ArrayList();
		
		for(int i=0;i<files.length;i++) {
			list.add(new Node(files[i]));
		}
		
		Collections.sort(list);
		answer = new String[files.length];
		for(int i=0;i<files.length;i++) {
			answer[i] = list.get(i).name;
			//System.out.println(answer[i]);
		}
		
		return answer;
	}
}
