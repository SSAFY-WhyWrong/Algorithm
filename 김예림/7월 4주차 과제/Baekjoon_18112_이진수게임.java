package M07_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon_18112_���������� {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int start = Integer.parseInt(br.readLine(), 2);
		int end = Integer.parseInt(br.readLine(), 2);
		
		Queue<Number> q = new LinkedList<>();
		q.offer(new Number(start, 0));
		int size = 0;
		//�̰� 1<=l,k<=10 �� �� ������ �������� �޴´ٴ� ���� �ƴѰ���...
		//�� �̻��� ���ڰ� ���������� �ؾ���
		//visited��� ���ڸ� ���� ��Ʈ����ŷ���� �湮üũ�ϱ�!
		boolean[] visited = new boolean[11];
		
		while(true) {			
			Number cur = q.poll();
			visited[cur.num] = true;
			if(cur.num == end) {
				System.out.println(cur.size);
				break;
			}
			size++;
			for(int i=1; i<5; i++) {
				int tmp = cur.num ^ (1 << i);
				if(tmp<11 && tmp>0 && !visited[tmp]) {
					q.offer(new Number(tmp, size));
				}
			}
			if(cur.num+1 < 11 && !visited[cur.num+1]) q.offer(new Number(cur.num+1, size));
			if(cur.num-1 > 0 && !visited[cur.num-1]) q.offer(new Number(cur.num-1, size));
		}
	}
	
	static class Number{
		int num;
		int size;
		public Number(int num, int size) {
			this.num = num;
			this.size = size;
		}
	}
}
