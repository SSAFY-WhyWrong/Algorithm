package 성공;

import java.util.ArrayList;

public class 카카오_단체사진찍기_2017 {
	private static class kakao {
		char p1, p2, ch;
		int val;

		public kakao(char p1, char p2, char ch, int val) {
			this.p1 = p1;
			this.p2 = p2;
			this.ch = ch;
			this.val = val;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 2;
		String[] data = { "N~F=0", "R~T>2" };
		System.out.println(solution(n, data));
	}

	private static ArrayList<kakao> list;
	private static boolean[] bool;
	private static char[] perm = new char[8];
	private static char[] corn1 = { 'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T' };
	private static int listSize, sum;

	public static int solution(int n, String[] data) {
		int answer = 0;
		int size = data.length;
		String a;
		list = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			a = data[i];
			list.add(new kakao(a.charAt(0), a.charAt(2), a.charAt(3), a.charAt(4) - '0'));
		}
		bool = new boolean[8];
		listSize = list.size();
		sum=0;
		permu(0);
		answer = sum;
		return answer;
	}

	private static void permu(int i) {
		if (i == 8) {
			kakao k;
			int cnt, val;
			char p1, p2;
			boolean isSafe = false, start = false;
			for (int j = 0; j < listSize; j++) {
				k = list.get(j);
				p1 = k.p1;
				p2 = k.p2;
				val = k.val;
				cnt = 0;
				isSafe = false;
				start = false;
				for (int j2 = 0; j2 < 8; j2++) {
					if (start && (perm[j2] == p1 || perm[j2] == p2)) {
						isSafe = true;
						break;
					}
					if (start)
						cnt++;
					if (!start && (perm[j2] == p1 || perm[j2] == p2)) {
						start = true;
					}
				}
				if (k.ch == '=') {
					if (cnt != val)
						return;
				} else if (k.ch == '>') {
					if (cnt <= val)
						return;
				} else {
					if (cnt >= val)
						return;
				}
			}
			sum++;
			return;
		}

		for (int j = 0; j < 8; j++) {
			if (!bool[j]) {
				perm[i] = corn1[j];
				bool[j] = true;
				permu(i + 1);
				bool[j] = false;
			}
		}

	}

}
