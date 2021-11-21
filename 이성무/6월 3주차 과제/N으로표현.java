package 실패;

import java.util.HashSet;
import java.util.Set;

public class N으로표현 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 2;
		int number = 11;
		System.out.println(solution(N, number));
	}

	public static int solution(int N, int number) {
		int answer = -1;
		// N만으로 이루어진 사칙연산으로 number값을 표현할때 사용한 갯수의 최솟값
		// 최솟값이 8보다 크면 -1을 리턴
		StringBuilder sb;
		Set<Integer>[] set = new HashSet[9];
		for (int i = 1; i < 9; i++) {
			set[i] = new HashSet<>();
		}
		int size1, size2;
		for (int i = 1; i < 9; i++) { // set를 구성
			sb = new StringBuilder();
			for (int l = 0; l < i; l++) {
				sb.append(N);
			}
//			System.out.println(sb);
			set[i].add(Integer.parseInt(sb.toString()));
			for (int j = 1; j < i; j++) { // 빼는 값을 늘려가면서 조합을 구성
				for (Integer a : set[i - j]) {
					for (Integer b : set[j]) {
						set[i].add(a + b);
						set[i].add(a - b);
						set[i].add(a * b);
						if(b==0) continue;
						set[i].add(a / b);
					}
				}
			}
//			System.out.println(set[i].toString());
		}
		for (int i = 1; i < 9; i++) {
			for (Integer c : set[i]) {
				if (c == number)
					return i;
			}
		}
		return answer;
	}
}
