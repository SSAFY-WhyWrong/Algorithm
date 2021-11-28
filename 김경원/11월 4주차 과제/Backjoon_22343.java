import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Backjoon_22343 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String str1, str2;
		int len;
		int[] a, b;
		int sqr;
		char token;

		for (int t = 0; t < N; t++) {
			str1 = br.readLine();
			str2 = br.readLine();

			len = Math.max(str1.length(), str2.length());
			len = len / 2;

			a = new int[len];
			b = new int[len];
			sqr = 0;
			count(str1, a, len);
			count(str2, b, len);

			token = '=';
			for (int i = len - 1; i >= 0; i--) {

				if (a[i] > b[i]) {
					token = '>';
					break;
				} else if (a[i] < b[i]) {
					token = '<';
					break;
				}
			}

			System.out.println(token);

		}

	}

	static void count(String str, int[] arr, int len) {
		int sqr = 0;
		for (int i = 0; i < str.length(); i++) {

			if (str.charAt(i) == '(') {
				sqr++;
				if (str.charAt(i + 1) == ')')
					arr[sqr - 1]++;

				continue;
			}

			sqr--;

		}

		for (int i = 0; i < len - 1; i++) {
			arr[i + 1] += arr[i] / 2;
			arr[i] %= 2;
		}

	}

}
