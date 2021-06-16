package 실패;

import java.util.Arrays;

public class 징검다리건너기v2 {
	private static int half, size;
	private static int minimum, maximum;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] stones = { 2, 4, 5, 3, 2, 1, 4, 2, 5, 1 };
		int k = 3;
		System.out.println(solution(stones, k));
	}

	// 이진탐색
	public static int solution(int[] stones, int k) {
		int answer = 0;
		size = stones.length; // 1이상 200,000이하
		// 최대 ? >>> 2억 ,최소 ? >>> 0명
		minimum = 0;
		maximum = 200000000;
		while (true) {
			half = (minimum + maximum) / 2;
			if (binarySearch(half, stones, k)) { // 수용가능
				answer = Math.max(answer, half);
				minimum = half + 1;
			} else { // 수용불가능
				maximum = half - 1;
			}
			if (minimum > maximum) {
				break;
			}
		}
		return answer;
	}

	private static boolean binarySearch(int val, int[] stones, int k) {
		int cnt = 0;
		for (int i = 0; i < size; i++) {
			if (stones[i] - val < 0) {
				cnt++;
			} else {
				cnt = 0;
			}
			if (cnt == k) {
				return false;
			}
		}
		return true;
	}
}
