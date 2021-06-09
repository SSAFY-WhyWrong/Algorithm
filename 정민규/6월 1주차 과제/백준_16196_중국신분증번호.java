import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_16196_중국신분증번호 {
	static String[] country;

	static boolean country_code = false;
	static boolean year_code = false;
	static boolean month_code = false;
	static int month_num;
	static boolean day_code = false;
	static boolean gender_code = false;
	static boolean check_code = false;

	static boolean ans_code = false;
	static String[] month = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" };

	static String[] day = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15",
			"16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String citizen = br.readLine();
		int N = Integer.parseInt(br.readLine());
		country = new String[N];
		String substring = citizen.substring(0, 6);
		for (int i = 0; i < N; i++) {
			country[i] = br.readLine();
			if (substring.equals(country[i])) {
				country_code = true;
			}
		}
		int tmpyearcode = Integer.parseInt(citizen.substring(6, 10));
		if (tmpyearcode <= 2011 && tmpyearcode >= 1900) {
			year_code = true;
		}
		substring = citizen.substring(10, 12);
		for (int i = 0; i < 12; i++) {
			if (substring.equals(month[i])) {
				month_num = i;
				month_code = true;
			}
		}
		substring = citizen.substring(12, 14);
		if (month_num + 1 == 2) {
			int maxtmpday = find_29(tmpyearcode);
			for (int i = 0; i < maxtmpday; i++) {
				// 윤년 체크해야함.
				if (substring.equals(day[i]))
					day_code = true;
			}
		} else if (month_num + 1 == 1 || month_num + 1 == 3 || month_num + 1 == 5 || month_num + 1 == 7
				|| month_num + 1 == 8 || month_num + 1 == 10 || month_num + 1 == 12) {
			for (int i = 0; i < 31; i++) {
				if (substring.equals(day[i]))
					day_code = true;
			}
		} else if (month_num + 1 == 4 || month_num + 1 == 6 || month_num + 1 == 9 || month_num + 1 == 11) {
			for (int i = 0; i < 30; i++) {
				if (substring.equals(day[i]))
					day_code = true;
			}
		}
		String gender_substring = citizen.substring(14, 17);
		int tmpgender_code = Integer.parseInt(gender_substring);
		if (tmpgender_code % 2 == 0) {
			if (tmpgender_code != 0) {
				gender_code = true;
			}
		} else if (tmpgender_code % 2 == 1) {
			gender_code = true;
		}
		char tmpchecksum = citizen.charAt(17);
		int tmpsum = 0;
		if (tmpchecksum == 'X') {
			tmpsum = 10;
			check_code = true;
		} else if ('0' <= tmpchecksum && tmpchecksum <= '9') {
			tmpsum = (int) (tmpchecksum - '0');
			check_code = true;
		}
		int twomul = 1;
		int ans = 0;
		if (country_code && year_code && month_code && day_code && gender_code && check_code) {
			for (int i = 16; i >= 0; i--) {
				twomul *= 2;
				int tmpmul = (int) (citizen.charAt(i) - '0') * twomul; // -'0'을 안해줘서 계속 디버깅
				ans += tmpmul;
//				System.out.println(tmpmul + " = " + citizen.charAt(i) + " * " + twomul);
			}
			ans += tmpsum;
			int tmpans = ans % 11;
			if (tmpans == 1) {
				ans_code = true;
			}
		}
		if (ans_code) {
			if (tmpgender_code % 2 == 0) {
				System.out.println("F");
			} else {
				System.out.println("M");
			}
		} else {
			System.out.println("I");
		}

	}

	static int find_29(int year) { // 윤년 체크코드
		return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 29 : 28;
	}
}
