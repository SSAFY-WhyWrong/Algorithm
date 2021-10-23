import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Backjoon_2174 {
	static int ni[] = {1,0,-1,0}; // N E S W 
	static int nj[] = {0,1,0,-1};
	static class Node{
		int i,j,dir;
		
		Node(int i,int j, int dir){
			this.i=i;
			this.j=j;
			this.dir = dir;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;	
		
		
		int A,B,N,M;
		boolean isCrash = false;
		
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken(" "));
		B = Integer.parseInt(st.nextToken(" "));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken(" "));
		M = Integer.parseInt(st.nextToken(" "));
		
		Node robot[] = new Node[N];
		
		int arr[][] = new int[B+1][A+1];
		
		Map<String,Integer> dirMap = new HashMap();
		dirMap.put("N", 0);
		dirMap.put("E", 1);
		dirMap.put("S", 2);
		dirMap.put("W", 3);
		
		
		
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int x,y;
			x = Integer.parseInt(st.nextToken(" "));
			y = Integer.parseInt(st.nextToken(" "));			
			int dir = dirMap.get(st.nextToken(" "));
			
			robot[i] = new Node(y,x,dir);
			arr[y][x] = i+1;
		}
		
		for(int t=0;t<M;t++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken(" ")) - 1;
			String order = st.nextToken(" ");
			int round = Integer.parseInt(st.nextToken(" "));
			
			for(int r=0;r<round;r++) {
								
				if(isCrash) break;
				
				
				if(order.equals("F")) {
					
//					System.out.println(num +" : "+robot[num].i+" "+robot[num].j+" "+robot[num].dir);
					
					arr[robot[num].i][robot[num].j] = 0;
					
					robot[num].i += ni[robot[num].dir];
					robot[num].j += nj[robot[num].dir];					
					
					if(robot[num].i <= 0 || robot[num].j <= 0 || robot[num].i > B || robot[num].j > A) {
						isCrash = true;
						System.out.println("Robot "+(num+1)+" crashes into the wall");
						break;
					}else if(arr[robot[num].i][robot[num].j]!=0) {
						isCrash = true;
						System.out.println("Robot "+(num+1)+" crashes into robot "+arr[robot[num].i][robot[num].j]);
						break;
					}
					
					arr[robot[num].i][robot[num].j] = num+1;
					
					
				}else if(order.equals("L")) {
					
					robot[num].dir = (4 + (robot[num].dir-1)) % 4;
					
					
				}else if(order.equals("R")) {
					
					robot[num].dir = (robot[num].dir + 1)%4;	
					
					
				}
				
				
			}
			
			
			
		}
		
		if(!isCrash)
			System.out.println("OK");
		
	}
}
