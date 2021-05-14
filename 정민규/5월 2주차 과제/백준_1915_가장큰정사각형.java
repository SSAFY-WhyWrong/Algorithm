import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_1915_가장큰정사각형 {
	static int N, M;
	static int[][] ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ans = new int[N][M];
		int max_value = 0;
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				char tmp = s.charAt(j);
				ans[i][j] = (int) tmp - 48;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				if (i == 0 || j == 0) {
					max_value = max_value > ans[i][j] ? max_value : ans[i][j];
				} else {
					if (ans[i - 1][j - 1] == 0 || ans[i - 1][j] == 0 || ans[i][j - 1] == 0 || ans[i][j] == 0) {
						continue;
					} else if (ans[i - 1][j] == ans[i - 1][j - 1] && ans[i - 1][j] == ans[i][j - 1] && ans[i][j] == 1) {
						ans[i][j] = ans[i - 1][j - 1] + 1;
						max_value = max_value > ans[i][j] ? max_value : ans[i][j];
					} else {
						int max = (ans[i - 1][j - 1] < ans[i - 1][j]) ? ans[i - 1][j - 1] : ans[i - 1][j];
						max = max < ans[i][j - 1] ? max : ans[i][j - 1];
						ans[i][j] = max + 1;
						max_value = max_value > ans[i][j] ? max_value : ans[i][j];
					}
				}
			}
		}

		System.out.println(max_value * max_value);
	}
}
