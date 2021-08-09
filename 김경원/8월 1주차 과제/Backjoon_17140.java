import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Backjoon_17140 {
	static class Node implements Comparable<Node>{
		int num, cnt;
		Node(int num, int cnt){
			this.num = num;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Node o) {
			if(this.cnt == o.cnt) {
				return this.num - o.num;
			}
			return this.cnt - o.cnt;
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int r,c,k;
		int arr[][] = new int[101][101];
		int cnt[];
		
		int row = 3,col = 3;
		
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken(" "));
		c = Integer.parseInt(st.nextToken(" "));
		k = Integer.parseInt(st.nextToken(" "));
		
		for(int i=0;i<row;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<col;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken(" "));
			}
		}
		
		int t=0;
		List<Node> list = new ArrayList();
		int index = 0;
		boolean isFind = false;
		int temp_col;
		int temp_row;
		while(t<=100) {
			index = 0;
//			for(int i=0;i<row;i++) {
//				for(int j=0;j<col;j++) {
//					System.out.print(arr[i][j]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println("--------------------");
			if(arr[r-1][c-1]== k) {
				isFind = true;
				break;
			}
			if(row >= col) {
				temp_col = 0;
				for(int i=0;i<row;i++) {
					cnt = new int[101];
					for(int j=0;j<col;j++) {
						cnt[arr[i][j]]++;
						arr[i][j] = 0;
					}
					
					for(int n=1;n<=100;n++) {
						if(cnt[n]!=0) list.add(new Node(n,cnt[n]));
					}
					
					Collections.sort(list);	
					for(int j=0;j<list.size();j++) {
						arr[i][j*2] = list.get(j).num;
						arr[i][j*2 + 1] = list.get(j).cnt;
					}
					
					index = Math.max(index, list.size()*2);
					if(index > 100) index = 100;
					for(int j=list.size()*2; j<index;j++) {
						arr[i][j] = 0;
					}
					list.clear();
					temp_col = Math.max(index, temp_col);
				}
				col = temp_col;
				
				
				
			} else {
				temp_row = 0;
				for(int j=0;j<col;j++) {
					cnt = new int[101];
					for(int i=0;i<row;i++) {
						cnt[arr[i][j]]++;
						arr[i][j] = 0;
					}
					for(int n=1;n<=100;n++) {
						if(cnt[n]!=0) list.add(new Node(n,cnt[n]));
					}
					
					Collections.sort(list);
					
					
					for(int i=0;i<list.size();i++) {
						arr[i*2][j] = list.get(i).num;
						arr[i*2 + 1][j] = list.get(i).cnt;
					}
					
					index = Math.max(index, list.size()*2);
					
					if(index > 100) index = 100;
					
					for(int i=list.size()*2; i<index; i++) {
						arr[i][j] = 0;
					}
					list.clear();
					temp_row = Math.max(index, temp_row);
				}
				row = temp_row;
				
			}
			t++;
		}
		// while-end
		
		if(isFind) System.out.println(t);
		else System.out.println(-1);
		
		
		
		
	}
}
