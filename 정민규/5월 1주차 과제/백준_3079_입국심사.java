import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_3079_입국심사 {
	static int N;
	static long M;
	static long[] arr;
	static int time;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Long.parseLong(st.nextToken());
		arr = new long[N];
		long max = 0;
		long min = Long.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(br.readLine());
			if (max < arr[i])
				max = arr[i];
			if (min > arr[i])
				min = arr[i];
		}
		long left = min;
		long right = max * M;
		long mid, total;
		long ans = right;
		while (left <= right) {
			mid = (left + right) / 2;
			total = 0;
			for (int i = 0; i < N; i++) {
				total += mid / arr[i];
			}
			if (total < M) {
				left = mid + 1;
			} else {
				if (ans > mid) {
					ans = mid;
				}
				right = mid - 1;
			}
		}
		System.out.println(ans);
	}
}
/*
 * 이분탐색 문제 좌는 심사대중 가장 작은 시간 단 이때는 사람을 안곱한다.-> 여러 심사대가 동시에 진행되면
 * 이는 min * m 이 절때 최솟값이 아니다.
 * 우는 시간이 가장 긴 심사대 *사람 으로 계산한다. --> 이는 가장 최댓값이기 때문이다.
 * 
 * while문은 각 좌측값이 우측 값보다 커질때 멈춘다.
 * 좌측값과 우측값으로 구한 평균값을 구한다. 이 평균값은 심사를 마치는데 걸리는 시간의 값이다.
 * 이 평균값을 각각의 입국심사대 걸린 시간만큼 나눈다. 이는 똑같은 시간동안 각각의 입국심사대에서 검사한 사람의 수이다.
 * 이때 사람의 수를 다 더했을때 기존인원만큼 안되면 최솟값을 더 늘린다.
 * 이때 사람의 수를 다 더했을때 기존인원보다 넘으면 최댓값을 더 뺀다.
 * 만약 기존인원보다 사람의수를 다 더했을때 ans에 mid보다 크게 되어있으면, 최댓값을  줄일것이므로,
 * ans에 현재 mid값을 대입한다.
 * 
 * 좌측값이 우측값보다 커졌을 때, 최적값을 찾은것이므로 그때 정답을 도출한다.
 * 
 * 
 */
