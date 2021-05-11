package B307입국심사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { // long 범위 때문에 고생한 문제 M * T 가 10^18이라는 최대 시간을 가지기 때문입니다.
	static int n,m;
	static long res = 0,max = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력칸
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int []arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] =  Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]); // 게이트중 가장 높을 고름
		}
		
		go(arr, m); // 이진 

		System.out.println(res);
	}
	private static void go(int[] arr, int m) { // 통과할 수 있는 최소 시간을 이진 탐색으로 구한다.
		long start = 1;
		long end = m * max; // 최대 걸리는 시간 = 게이트 최대 값 * 사람수 그렇기 때문에 int값을 벗어남 10^18

		long mid = 0;

		while(start <= end) {
			mid = (start + end) / 2;
			
			if(ok(arr, mid, m)) { 
				start = mid + 1; // 시간 늘리기

			}else {
				res = mid; // 통과했다면 결과값에 저장
				end = mid - 1; /// 시간 줄이기

			}
		}
		


	}
	private static boolean ok(int[] arr, long mid, int m) {
		long sum = 0; // 
		for(int i = 0; i < n; i++) {
			sum += mid / arr[i];
		}
		
		if(sum < m)return true; // 출국할 시간이 부족해
		else return false; // 시간이 넘쳐
	}
	
}
