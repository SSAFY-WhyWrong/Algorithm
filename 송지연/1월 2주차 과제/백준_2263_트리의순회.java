import java.util.*;
import java.io.*;

public class 백준_2263_트리의순회 {

	static int N;
	static int[] inorder, postorder;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		inorder = new int[N];
		postorder = new int[N];
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i=0;i<N;i++) {
			inorder[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(bf.readLine());
		for(int i=0;i<N;i++) {
			postorder[i] = Integer.parseInt(st.nextToken());
		}
		
		preorder(0, N-1, 0, N-1);
	}
	
	public static void preorder(int inorderS, int inorderE, int postorderS, int postorderE) {
		if(inorderS > inorderE || postorderS > postorderE) return;
		
		int root = postorder[postorderE], rootIdx = -1;
		for(int i=inorderS;i<=inorderE;i++) {
			if(root == inorder[i]) {
				rootIdx = i;
				break;
			}
		}
		
		System.out.print(root + " ");

		int leftSize = rootIdx - inorderS;

		preorder(inorderS, rootIdx - 1, postorderS, postorderS + leftSize - 1);
		preorder(rootIdx + 1, inorderE, postorderS + leftSize, postorderE - 1);
	}

}
