package 성공;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B16196 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] a = br.readLine().toCharArray();
		int[] array = new int[18];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < a.length - 1; i++) {
			array[i] = a[i] - '0';
			if (i < 6)
				sb.append(a[i]);
		}
		if (a[17] != 'X') { // x가 10이 아닐때
			array[17] = a[17] - '0';
		} else { // x가 10일때
			array[17] = 10;
		}
		int year = 0, month = 0, day = 0, seq = 0;
		boolean rightRegion = false;
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			if (br.readLine().equals(sb.toString())) {
				rightRegion = true;
			}
		}
		if (!rightRegion) {
			System.out.println("I");
		} else {
			year += 1000 * array[6];
			year += 100 * array[7];
			year += 10 * array[8];
			year += 1 * array[9];
			month += 10 * array[10];
			month += 1 * array[11];
			day += 10 * array[12];
			day += 1 * array[13];
			if (year < 1900 || year > 2011) {
				System.out.println("I");
				System.exit(0);
			}
			if (month < 1 || month > 12) {
				System.out.println("I");
				System.exit(0);
			}
			if (day < 1 || day > 31) {
				System.out.println("I");
				System.exit(0);
			}
			if (!check(year, month, day)) {
				System.out.println("I");
				System.exit(0);
			}
			seq += 100 * array[14];
			seq += 10 * array[15];
			seq += 1 * array[16];
			if (seq == 0) {
				System.out.println("I");
				System.exit(0);
			}
			String answer;
			if (seq % 2 == 0) {
				answer = "F";
			} else {
				answer = "M";
			}
			if (checkSum(array, array[17])) {
				System.out.println(answer);
			} else {
				System.out.println("I");
			}
		}
	}

	private static boolean checkSum(int[] array, int point) {
		// TODO Auto-generated method stub
		int po = 17;
		int sum = 0;
		for (int i = 0; i < array.length - 1; i++) {
			sum += (((Math.pow(2, po--) % 11) * array[i]) % 11);
		}
		sum += point;
		if (sum >= 11) {
			sum %= 11;
		}
		if (sum == 1) {
			return true;
		}
		return false;
	}

	private static boolean check(int year, int month, int day) {
		// TODO Auto-generated method stub
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {

		} else if (month == 2) {
			if (day > 29)
				return false;

			if (year % 4 != 0) { // 윤년이 아니고
				if (day > 28) {
					return false;
				}
			} else if (year % 100 == 0) {// 윤년에
				if (year % 400 == 0) {
					if (day > 29) // 윤년
						return false;
				} else {
					if (day > 28) // 평년
						return false;
				}
			} else { // 윤년
				if (day > 29)
					return false;
			}
		} else {
			if (day > 30)
				return false;
		}
		return true;
	}

}
