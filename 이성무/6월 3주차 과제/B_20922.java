package 실패;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_20922 {
	private static int N, K, max, start, end;
	private static int[] array, count;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 길이 1 ~ 200,000
		K = Integer.parseInt(st.nextToken()); // 최대 갯수 1 ~ 100
		start = 0;
		end = -1;
		array = new int[N];
		count = new int[100001];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		if (N == 1) {
			System.out.println("1");
			System.exit(0);
		}
		for (int i = 0; i < N; i++) {
			if (count[array[i]] + 1 > K) { // 추가시에 현재 배열의 값의 갯수가 최대 값을 넘을 때
				end++;
				count[array[i]]++;
				while (true) {
					count[array[start++]]--;
					if (count[array[i]] == K) {
						if (start > end)
							end = start;
						break;
					}
				}
//				System.out.println("start:"+start);
//				System.out.println("end:"+end);
			} else { // 추가 시에 아직 현재 배열의 값의 갯수가 최대 값이 되지 않았을 떄
				end++;
				count[array[i]]++;
//				System.out.println("end:"+end);
//				System.out.println("start:"+start);
			}
//			System.out.println();
			max = Math.max(max, end - start);
		}
		System.out.println(max + 1);
	}

}
