public class Programmers_다트게임 {
	public static void main(String[] args) {

		String dartResult = "1D2S#10S";

		solution(dartResult);

	}

	static public int solution(String dartResult) {
		int answer = 0;

		dartResult = dartResult.replaceAll("10", ":");

		int score[] = new int[4];
		char token;

		int turn = 0;
		
		for (int t = 0; t < dartResult.length(); t++) {
			token = dartResult.charAt(t);
			if (token >= '0' && token <= ':') {
				turn++;
				score[turn] = token - '0';
			} else if (token == 'S') {

			} else if (token == 'D') {
				score[turn] *= score[turn];
			} else if (token == 'T') {
				score[turn] *= score[turn] * score[turn];
			} else if (token == '*') {
				score[turn - 1] *= 2;
				score[turn] *= 2;
			} else if (token == '#') {
				score[turn] *= -1;
			}
		}

		for (int i = 1; i <= 3; i++) {
			answer += score[i];
		}

		System.out.println(answer);
		return answer;
		
		
	}

}
