package 성공;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_3079 {
	//지나간 시간의 최저 최고 에서 절반값을 대입해서 사람이 얼마나 그 시간에 지나가는지 계산 
	//답이 인원보다 작은지 확인하고 작으면 하한으로 잡고 다시 반절 계산해서 반복
	//답이 인원보다 크면 상한으로 잡고 다시 반절 계산해서 반복
	static int N,M; //하한 상한
	static int[] array;
	static long up,down, mid,max,answer=Long.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken()); //입국심사대수
		M = Integer.parseInt(st.nextToken()); //사람수
		array = new int[N];
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(br.readLine());
			if(array[i]>max)max=array[i];
		}
		up = max * M; //상한 시간 최대시간 x 사람수
		down = 1;
		mid = (up+down)/2;
		while(!binarySearch()) {
		}
		System.out.println(answer);
	}
	private static boolean binarySearch() {
		long sum=0; 
		for (int i = 0; i < N; i++) {
			sum+=(mid/array[i]);
		}
		if(sum>=M) {
			if(answer>mid)answer=mid;
			up = mid-1;
		}else {
			down = mid+1;
		}
		mid = (up+down)/2;
		
		if(up<down)return true;
		return false;
	}

}
