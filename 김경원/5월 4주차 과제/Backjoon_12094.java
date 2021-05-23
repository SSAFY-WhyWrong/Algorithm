// 백준 12094 2048(hard)
// 주소 : https://www.acmicpc.net/problem/12094


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon_12094 {
	
	static int ni[] = {-1,1,0,0};
	static int nj[] = {0,0,-1,1};
	
	static int N;
	static int play_arr[][];
	static int max_num[] = new int[11];
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken(" "));
		play_arr = new int[N][N];
		result = 0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				play_arr[i][j] = Integer.parseInt(st.nextToken(" "));
				result = Math.max(result,play_arr[i][j]);
			}
		}
		
		
		
		play(0);
		for(int i=0;i<=10;i++) {
			result = Math.max(result, max_num[i]);
		}
		
		
		System.out.println(result);	
		
	}
	static void print_arr() {
		System.out.println("--------------------");
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.printf("%5d",play_arr[i][j]);
			}
			System.out.println();
		}
	}
	
	static int getMax() {
		int max=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				max = Math.max(max,play_arr[i][j]);
			}
		}
		return max;
	}
	
	static void arr_copy(int arr1[][], int arr2[][]) {
		for(int i=0;i<N;i++) {
			arr2[i] = arr1[i].clone();
		}
	}
	
	static boolean isSame(int arr1[][], int arr2[][]) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(arr1[i][j] != arr2[i][j]) return false;
			}
		}
		return true;
	}
	
	
	static void play(int cnt) {
		int now_max = getMax();
		if(now_max  <= max_num[cnt]) return;
		
		if(cnt == 10 ) {
			max_num[10] = now_max;
			for(int i=10;i>0;i--) {
				max_num[i-1] = max_num[i]/2;
			}
			return;
		}else {
			
			int temp[][] = new int[N][N];
			arr_copy(play_arr,temp);	
			
			
			up(cnt+1,temp);	
			if(!isSame(temp,play_arr))
				play(cnt+1);
			
			down(cnt+1,temp);
			if(!isSame(temp,play_arr))
				play(cnt+1);
			
			left(cnt+1,temp);
			if(!isSame(temp,play_arr))
				play(cnt+1);
			
			right(cnt+1,temp);
			if(!isSame(temp,play_arr))
				play(cnt+1);
		}
		
	}
	
static void up(int cnt, int[][] temp) {		
		
		Queue<Integer>q = new LinkedList();
		
		play_arr = new int[N][N];
		
		for(int j=0;j<N;j++) {
			for(int i=0;i<N;i++) {
				if(temp[i][j]!=0) {
					q.add(temp[i][j]);
				}
			} //한줄씩 큐에 담음
			
			int now_line=0;
			while(!q.isEmpty()) {
				int now = q.poll();
			
				if(play_arr[now_line][j]==0) play_arr[now_line][j] = now;
				else if(play_arr[now_line][j] == now) {
					now *= 2;
					play_arr[now_line++][j] = now;
				}
				else play_arr[++now_line][j] =now;
			
			}
			
		}

		
	}
	static void down(int cnt, int[][] temp) {
		
		Queue<Integer>q = new LinkedList();
		
		play_arr = new int[N][N];
		for(int j=0;j<N;j++) {
			for(int i=N-1;i>=0;i--) {
				if(temp[i][j]!=0) {
					q.add(temp[i][j]);
				}
			} //한줄씩 큐에 담음
			
			int now_line=N-1;
			while(!q.isEmpty()) {
				int now = q.poll();
			
				if(play_arr[now_line][j]==0) play_arr[now_line][j] = now;
				else if(play_arr[now_line][j] == now) {
					play_arr[now_line--][j] += now;
				}
				else play_arr[--now_line][j] =now;
			
			}
			
		}
		

		
	}
	static void left(int cnt,int[][] temp) {
		
		Queue<Integer>q = new LinkedList();
		play_arr = new int[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(temp[i][j]!=0) {
					q.add(temp[i][j]);
				}
			} //한줄씩 큐에 담음
			
			int now_line=0;
			while(!q.isEmpty()) {
				int now = q.poll();
			
				if(play_arr[i][now_line]==0) play_arr[i][now_line] = now;
				else if(play_arr[i][now_line] == now) {
					play_arr[i][now_line++] = +now;
				}
				else play_arr[i][++now_line] =now;
			
			}
			
		}
		

	}
	static void right(int cnt, int[][] temp) {
		Queue<Integer>q = new LinkedList();
		play_arr = new int[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=N-1;j>=0;j--) {
				if(temp[i][j]!=0) {
					q.add(temp[i][j]);
				}
			} //한줄씩 큐에 담음
			
			int now_line=N-1;
			while(!q.isEmpty()) {
				int now = q.poll();
			
				if(play_arr[i][now_line]==0) play_arr[i][now_line] = now;
				else if(play_arr[i][now_line] == now) {
					play_arr[i][now_line--] += now;
				}
				else play_arr[i][--now_line] =now;
			
			}
			
		}

	}
}
