package 실패;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B_18112 {
	private static int orig,aim;
	private static Queue<Integer> queue;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] array = new boolean[2048];
		orig = Integer.parseInt(br.readLine(),2);
		aim = Integer.parseInt(br.readLine(),2);
		queue = new LinkedList<>();
		queue.add(orig);
		int k,size,cnt=0,m;
		String str;
		array[orig] = true;
		while(!queue.isEmpty()) {
			size = queue.size();
			for (int i = 0; i < size; i++) {
				k = queue.poll();
				str = Integer.toBinaryString(k);
				for (int j = 0; j < str.length()-1; j++) {
					if((k & (1<<j)) != 0) {
						m = k - (1<<j);
					}else {
						m = k | (1<<j);
					}
					if(m==aim) {
						System.out.println(cnt+1);
						System.exit(0);
					}
					if(m<2048 && !array[m]) {
						queue.add(m);							
						array[m] = true;
					}
				}
				if(k<2048&&!array[k+1]) {
					queue.add(k+1);
					array[k+1] = true;
				}
				if(k>0&&!array[k-1]) {
					queue.add(k-1);
					array[k-1] = true;
				}
				if(k+1==aim||k-1==aim) {
					System.out.println(cnt+1);
					System.exit(0);
				}
			}
			cnt++;
		}
	}

}
