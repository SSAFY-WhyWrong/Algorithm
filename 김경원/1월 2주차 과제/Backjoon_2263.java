import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_2263 {
	static int[] inorder;
	static int[] postorder;
	static int[] preorder;
	static int treeIdx;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		inorder = new int[N];
		postorder = new int[N];
		preorder = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			inorder[i] = Integer.parseInt(st.nextToken(" "));
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			postorder[i] = Integer.parseInt(st.nextToken(" "));
		}
		preorder[0] = postorder[N-1];
		treeIdx = 0;
		
		solve(0,N-1,0,N-1,N);
		
		for(int i=0;i<N;i++) {
			System.out.print(preorder[i]+" ");
		}
		
	}
	
	static public void solve(int left_s, int left_e, int right_s, int right_e, int N) {
		if(left_s > left_e || right_s > right_e) {
			return;
		}
		int root = postorder[right_e];
		preorder[treeIdx++] = root;
		int idx=0;
		for(int i=0;i<N;i++) {
			if(inorder[i] == root) {
				idx = i;
				break;
			}
			
		}
		
		solve(left_s, idx-1, right_s, right_s + (idx-left_s)-1, N);
		solve(idx+1, left_e, right_s + (idx-left_s), right_e-1, N);
		
		
		
		
		
	}
	
	
}
