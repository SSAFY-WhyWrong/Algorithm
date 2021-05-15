
public class 프로그래머스_카펫 {
	public static void main(String[] args) {
		int[] ans = solution(24, 24);
		System.out.println(ans[0] + " " + ans[1]);

	}

	public static int[] solution(int brown, int yellow) {
		int[] answer = {};
		int sum = brown + yellow;
		int garo = brown / 2;
		int saro = 2;
		// 채우기

		while (true) {
			garo -= 1;
			saro += 1;
			if (sum == garo * saro) {
				answer = new int[2];
				answer[0] = garo;
				answer[1] = saro;
				break;
			}
		}
		return answer;
	}
}
