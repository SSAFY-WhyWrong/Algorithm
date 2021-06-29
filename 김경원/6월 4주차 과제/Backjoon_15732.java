import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_15732 {
	static class Node{
		int start, end, c;
		Node(int start,int end, int c){
			this.start = start;
			this.end = end;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N,K,D;
		int low,high,mid;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken(" ")); //상자 수
		K = Integer.parseInt(st.nextToken(" ")); //규칙 수
		D = Integer.parseInt(st.nextToken(" ")); //도토리 수
		
		Node rule[] = new Node[K];
		
		low = N;
		high = 0;
		
		int start,end,c;
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			low = Math.min(low, start);
			high = Math.max(high, end);
			
			rule[i] = new Node(start,end,c);			
		}
		
		
		long now;
		int result=0;
		while(low<=high) {
			mid = (low+high)/2;
			now = getAmount(rule,K,mid);			
			
			if(now >= D) {
				high = mid-1;
				result = mid;
			}else
				low = mid+1;		
		}
		
		System.out.println(result);
		
	}
	static long getAmount(Node[] rule, int K,int mid) {
		
		int temp;
		long sum=0;
		
		for(int i=0;i<K;i++) {
			temp =  Math.min(rule[i].end, mid) - rule[i].start;
			if(temp < 0) continue;
			
			temp = temp/rule[i].c + 1;
			
			sum+=temp;
			
			
		}
		
		
		
		return sum;
	}

	
}
