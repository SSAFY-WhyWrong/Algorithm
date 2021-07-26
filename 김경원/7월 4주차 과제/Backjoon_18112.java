import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Backjoon_18112 {
	public static void main(String[] args) throws IOException {		

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		
		int start,target;
		boolean visit[] = new boolean[2050]; 
		
		start = Integer.parseInt(br.readLine(),2);		
		target = Integer.parseInt(br.readLine(),2);
		
		
		int now = 0;
		int q_size;
		int cnt=-1;
		
		Queue<Integer> q = new LinkedList();
		q.add(start);
		visit[start] = true;
		
		while(!q.isEmpty()) {
			q_size = q.size();
			cnt++;
			for(int i=0;i<q_size;i++) {
				now = q.poll();
				if(now == target) {
					q.clear();
					break;
				}
				if(now > (1024)) continue;
				for(int j=0;(1 << j ) <= Integer.highestOneBit(now);j++) {
					
					//맨 앞 숫자가 아닌 경우 보수로 바꾸기
					if(1<<j != Integer.highestOneBit(now) && !visit[now ^ 1 << j]) {
						visit[now ^ 1 << j] = true;
						q.add(now ^ 1 << j);
					}		
					
					
				}
				if(now!=0 && !visit[now-1]) {
					visit[now-1] = true;
					q.add(now-1);
				}
				if(now+1 < 2048 && !visit[now+1]) {
					visit[now+1] = true;
					q.add(now+1);
				}
			}
			
		}
		
		System.out.println(cnt);
	}
	
	
}
