package day_0625;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_15732 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		Store[] store = new Store[K];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			store[i] = new Store(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}
		int start = 1;
		int end = N;
		while (true) {
			int mid = (start + end) / 2;
			long cnt = 0;
			for (int i = 0; i < store.length; i++) {
				if (mid >= store[i].end) {
					cnt += (store[i].end - store[i].start) / store[i].range + 1;
				} else if (store[i].start > mid)
					continue;
				else {
					if(mid == store[i].start) {
						cnt++;
					} else {
						cnt += (mid - store[i].start)/store[i].range + 1;
					}
				}
			}
			if(cnt >= D) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
			if(start > end) {
				System.out.println(start);
				break;
			}
		}
	}

	static class Store {
		int start, end, range;

		public Store(int start, int end, int range) {
			this.start = start;
			this.end = end;
			this.range = range;
		}
	}
}
