package 성공;

import java.util.Arrays;

public class 카펫 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(solution(8, 1)));
	}

	public static int[] solution(int brown, int yellow) {
		int[] answer = new int[2];
		int garo = 1, sero = 1;
		// 노란색 갯수로 만들 수 있는 조합 가로가 같거나 더 커야하는 기준으로 만들어서 겉에 두를 수 있는 갯수 세서 같으면 리턴
		for (int i = 1; i <= yellow / 2; i++) { // 세로
			if (yellow % i == 0) {
				garo = yellow / i;
				sero = i;
				if (capet(brown, garo, sero))
					break;
			}
		}
		answer[0] = garo+2;
		answer[1] = sero+2;
		return answer;
	}

	private static boolean capet(int brown, int garo, int sero) {
		// TODO Auto-generated method stub
		int sum = 4;
		sum += garo * 2;
		sum += sero * 2;
		if (brown == sum)
			return true;
		else
			return false;
	}
}
