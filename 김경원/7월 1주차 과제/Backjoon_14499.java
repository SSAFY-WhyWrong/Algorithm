import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_14499 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N,M,K;
		int dice_x, dice_y;
		
		int dice[] = {0,0,0,0};
		int dice_left= 0 ,dice_right = 0;
		
		int arr[][];
		int order[];
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken(" "));
		M = Integer.parseInt(st.nextToken(" "));
		dice_x = Integer.parseInt(st.nextToken(" "));
		dice_y = Integer.parseInt(st.nextToken(" "));
		K = Integer.parseInt(st.nextToken(" "));
		
		
		arr = new int[N][M];
		order = new int[K];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken(" "));				
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<K;i++)
			order[i] = Integer.parseInt(st.nextToken(" ")) - 1;
		
		StringBuilder sb = new StringBuilder();
		
		int ni[] = {0,0,-1,1};
		int nj[] = {1,-1,0,0};
		
		int x,y;
		for(int i=0;i<K;i++) {
			x = dice_x + ni[order[i]];
			y = dice_y + nj[order[i]];
			if(x < 0 || y < 0 || x >= N || y>= M) continue;
			
			if(order[i]==0) {
				int temp = dice_left;
				dice_left = dice[2];
				dice[2] = dice_right;
				dice_right = dice[0];
				dice[0] = temp;
			}else if(order[i]==1) {
				int temp = dice_right;
				dice_right = dice[2];
				dice[2] = dice_left;
				dice_left = dice[0];
				dice[0] = temp;
			}else if(order[i]==2) {
				int temp = dice[0];
				dice[0] = dice[1];
				dice[1] = dice[2];
				dice[2] = dice[3];
				dice[3] = temp;
			}else if(order[i]==3) {
				int temp = dice[0];
				dice[0] = dice[3];
				dice[3] = dice[2];
				dice[2] = dice[1];
				dice[1] = temp;
			}
						
			if(arr[x][y] == 0) {
				arr[x][y] = dice[2];
			}else {
				dice[2] = arr[x][y];
				arr[x][y] = 0;
			}
			
			
//			for(int t=0;t<4;t++)
//				System.out.print(dice[t]+" ");
//			System.out.print(dice_left+" "+dice_right+"\n");
			
			dice_x = x;
			dice_y = y;
			
			sb.append(dice[0]).append('\n');
			
			
		}
		
		
		
		System.out.println(sb);
		
	}
}
