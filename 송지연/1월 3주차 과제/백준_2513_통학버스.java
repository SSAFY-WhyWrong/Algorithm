import java.util.*;
import java.io.*;

public class 백준_2513_통학버스 {
	
	static class Info {
		int location;
		int students;
		
		public Info(int location, int students) {
			this.location = location;
			this.students = students;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Info> leftQ = new PriorityQueue<>(new Comparator<Info>() {

			@Override
			public int compare(Info o1, Info o2) {
				if(o1.location == o2.location) {
					return o2.students - o1.students;
				}
				return o1.location - o2.location;
			}
		});
		
		PriorityQueue<Info> rightQ = new PriorityQueue<>(new Comparator<Info>() {

			@Override
			public int compare(Info o1, Info o2) {
				if(o1.location == o2.location) {
					return o2.students - o1.students;
				}
				return o2.location - o1.location;
			}
		});
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(bf.readLine());
			int l = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			if(l < S) {
				leftQ.add(new Info(l, s));
			} else if(l > S) {
				rightQ.add(new Info(l, s));
			}
		}
		
		int move = 0, busStudent = 0;
		while(!leftQ.isEmpty()) {
			Info now = leftQ.poll();
			
			int go = now.students / K + (now.students%K!=0 ? 1:0);
			busStudent = now.students % K;
			
			move += 2 * go * (S - now.location);
			
			if(busStudent == 0) continue;
			
			while(!leftQ.isEmpty()) {
				Info next = leftQ.poll();
				
				if(busStudent + next.students > K) {
					next.students -= (K - busStudent);
					leftQ.add(next);
					break;
				}
				
				busStudent += next.students;
			}
		}

		while(!rightQ.isEmpty()) {
			Info now = rightQ.poll();
			
			int go = now.students / K + (now.students%K!=0 ? 1:0);
			busStudent = now.students % K;
			
			move += 2 * go * (now.location - S);
			
			if(busStudent == 0) continue;
			
			while(!rightQ.isEmpty()) {
				Info next = rightQ.poll();
				
				if(busStudent + next.students > K) {
					next.students -= (K - busStudent);
					rightQ.add(next);
					break;
				}
				
				busStudent += next.students;
			}
		}
		
		System.out.println(move);
	}

}
