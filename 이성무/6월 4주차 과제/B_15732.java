package 실패;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_15732 {
	private static int N, K, D,min,max,mid;

	private static class dotori {
		int start, end, term;

		public dotori(int start, int end, int term) {
			this.start = start;
			this.end = end;
			this.term = term;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		ArrayList<dotori> list = new ArrayList<>();
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine()," ");
			list.add(new dotori(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		min = 0;
		max = N;
		mid = (min+max)/2;
		int size = list.size();
		long cnt=0;
		dotori a;
		
		while(min<=max) {
			cnt=0;
			mid = (min+max)/2;			
			for (int i = 0; i < size; i++) {
				a = list.get(i);
				if(a.end<=mid) { //끝과 같거나 클때 안에 들어있는거 전부 카운트
					cnt += (a.end-a.start)/a.term+1;
				}else if(a.start>mid) { //시작도 넘어서 포함 1도 안될때
					
				}else { //끝이 벗어나지만 시작이 안에 있어서 시작부터 mid까지 텀의 수 더해줌
					cnt += (mid-a.start)/a.term+1;
				}
			}
			if(cnt>=D) { //넘어서 불가능
				max = mid-1;
			}else { //가능
				min = mid+1;
			}
		}
		System.out.println(min);
		
	}

}
