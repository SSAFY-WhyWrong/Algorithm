import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon_1963 {
	static boolean prime[] = new boolean[10000];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;


		for (int i = 2; i < 10000; i++) {
			if (prime[i])
				continue;
			for (int j = 2 * i; j < 10000; j += i) {
				prime[j] = true;
			}
		}

		int test_case = Integer.parseInt(br.readLine());
		int num, target;
		int div[] = {1000,100,10,1};
		int mod[] = {10000,1000,100,10};
		boolean flag;
		for (int t = 0; t < test_case; t++) {
			st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken(" "));
			target = Integer.parseInt(st.nextToken(" "));
			
			flag = false;
			boolean visit[] = new boolean[10000];

			Queue<Integer> q = new LinkedList();

			int cnt = 0, now;
			visit[num] = true;
			
			q.add(num);

			while (!q.isEmpty()) {
				if(flag) break;
				int q_size = q.size();
				for (int _q = 0; _q < q_size; _q++) {

					num = q.poll();
					if(num == target) {
						flag= true;
						break;
					}
					
					for (int i = 0; i < 4; i++) {
						for (int j = 0; j < 10; j++) {
							int temp;
							now = num % mod[i];
							now /= div[i];
							now%=10;
							
							temp = num - now*div[i] + j * div[i];
							if(temp >= 1000 && !visit[temp] && !prime[temp]) {								
								visit[temp] = true;
								q.add(temp);
							}
							
							
						}
					}
				}
				cnt++;				
			}
			
			if(num == target)
				System.out.println(cnt-1);
			else
				System.out.println("Impossible");

		}

	}
}
