import java.util.Arrays;

class 프로그래머스_튜플 {
    public int[] solution(String s) {
        Node[] arr = new Node[100001];
        
		for (int i = 0; i <= 100000; i++) {
			arr[i] = new Node(i, 0);
		}
		int len = s.length();

		int[] answer=new int[100001];

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < len; i++) {
			char char_tmp=s.charAt(i);
			if (char_tmp == '{') {
				sb = new StringBuilder();
			} else if (char_tmp >= '0' && char_tmp <= '9') {
				sb.append(s.charAt(i));
			} else if (char_tmp == ',') {
				int tmp = Integer.parseInt(sb.toString());
				arr[tmp].Num += 1;
				sb = new StringBuilder();
			} else if (char_tmp == '}') {
				int tmp = Integer.parseInt(sb.toString());
				arr[tmp].Num += 1;
				i += 1;//뒤에서 또 i++하니 여기선 i+=2가아닌 i+=1;
			}
		}
        Arrays.sort(arr);
        int idx=0;
        for(Node tmp : arr) {
			if(tmp.Num!=0) {
				answer[idx]=tmp.Index;
				idx+=1;
			}else {
				break;
			}
		}
        int[] ans=new int[idx];
        for(int i=0;i<idx;i++){
            ans[i]=answer[i];
        }
        return ans;
    }
	static class Node implements Comparable<Node> {
		int Index;
		int Num;

		public Node(int Index, int Num) {
			this.Index = Index;
			this.Num = Num;
		}

		@Override
		public int compareTo(Node tmp) {
			return tmp.Num - this.Num;
		}
	}
}
/*
 * 
 * - }가 나오면 i+=2가아닌 i+=1 왜냐하면 for문뒤에 i++있기때문에
 * - 문제점 : 정답은 int[] answer={}; 
 * - 이런식으로 기본적으로 주어져있었는데 이걸 정답을 ArrayList로 return하려다가 결국두번계산하게 됐다.
 */
