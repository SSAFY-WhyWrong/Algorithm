import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_5549 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int M, N, K;

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken(" "));
		N = Integer.parseInt(st.nextToken(" "));
		K = Integer.parseInt(br.readLine());

		int ice[][] = new int[M + 1][N + 1];
		int jungle[][] = new int[M + 1][N + 1];
		int ocean[][] = new int[M + 1][N + 1];

		for (int i = 1; i <= M; i++) {
			String s = br.readLine();
			for (int j = 1; j <= N; j++) {
				char token = s.charAt(j - 1);
				if (token == 'I')
					ice[i][j]++;
				else if (token == 'J')
					jungle[i][j]++;
				else if (token == 'O')
					ocean[i][j]++;
			}
		}

		
		for (int i = 1; i <= M; i++) {
			for (int j = 1; j <= N; j++) {
				ice[i][j] += ice[i][j-1];
				jungle[i][j] += jungle[i][j-1];
				ocean[i][j] += ocean[i][j-1];
			}
		}
		
		
		for (int i = 1; i <= M; i++) {
			for (int j = 1; j <= N; j++) {
				ice[i][j] += ice[i - 1][j];
				jungle[i][j] += jungle[i - 1][j];
				ocean[i][j] += ocean[i - 1][j];
			}
		}
		
		
		StringBuilder sb = new StringBuilder();
		
		for(int t=0;t<K;t++) {			
			int x1,y1, x2,y2;
			st = new StringTokenizer(br.readLine());
			y1 = Integer.parseInt(st.nextToken(" "));
			x1 = Integer.parseInt(st.nextToken(" "));
			y2 = Integer.parseInt(st.nextToken(" "));
			x2 = Integer.parseInt(st.nextToken(" "));
			
			
			sb.append(jungle[y2][x2] - jungle[y1-1][x2] - jungle[y2][x1-1] + jungle[y1-1][x1-1]).append(" ");
			sb.append(ocean[y2][x2] - ocean[y1-1][x2] - ocean[y2][x1-1] + ocean[y1-1][x1-1]).append(" ");
			sb.append(ice[y2][x2] - ice[y1-1][x2] - ice[y2][x1-1] + ice[y1-1][x1-1]).append('\n');
			
			
		}
		
		System.out.println(sb);
	}
}
