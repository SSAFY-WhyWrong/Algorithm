package M07_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import org.w3c.dom.css.ElementCSSInlineStyle;

public class Baekjoon_17822_���ǵ����� {

	static int[][] circle;
	static boolean[][] checked;
	static int N, M, T;
	static int[] di = {-1,1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		N = Integer.parseInt(st.nextToken()); //������ = ������ ����
		M = Integer.parseInt(st.nextToken()); //�� ���ǿ� ���� ������ ����
		T = Integer.parseInt(st.nextToken()); //ȸ���ϴ� Ƚ��

		circle = new int[N+1][M+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=1; j<=M; j++) {
				int num = Integer.parseInt(st.nextToken());
				circle[i][j] = num;
			}
		}
		for(int i=0; i<T; i++) {
			//���� ȸ����Ű��
			st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken());//big�� x�� ���
			int d = Integer.parseInt(st.nextToken());//d�������� ȸ��
			int k = Integer.parseInt(st.nextToken());//kĭ ȸ��

			//ȸ����Ű�� ����
			if(d==0) turnRight(x, k);
			else turnLeft(x, k);
			
			//������ ���ڵ��� ���ְų�, ���� �����ϱ�
			removeNum();
		}

		int ans = 0;
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				ans += circle[i][j];
			}
		}
		
		System.out.println(ans);
	}

	private static void removeNum() {

		checked = new boolean[N+1][M+1];
		boolean exist = false;
		int total = 0;
		int cnt = 0;

		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				if(circle[i][j]!=0) {
					cnt++;
					total+=circle[i][j];
					if(Check(i, j)) {
						//������ ���ڵ��� �ִ� ���
						//�ٷ� 0���� ������ ���� ���� boolean�Լ��� üũ�� ���� -> �����ϴٰ� üũ�� �ֵ� ���� �����
						checked[i][j] = true;
						exist = true;
					}
				}
			}
		}

		if(!exist) {
			//������ ���ڵ��� ���� ���
			double avg = (float)total/(float)cnt;
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=M; j++) {
					if(circle[i][j]>0 && circle[i][j]>avg) circle[i][j]--;
					else if (circle[i][j]>0 && circle[i][j]<avg) circle[i][j]++;
				}
			}
		} else {
			//������ ���ڵ� üũ�� �� boolean 2���� �迭�� ���Ǹ鼭 ���ڵ� �����
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=M; j++) {
					if(checked[i][j]) circle[i][j] = 0;
				}
			}
		}
	}

	private static void turnRight(int x, int k) {
		int[][] temp = new int[N+1][M+1];

		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				temp[i][j] = circle[i][j];
			}
		}

		for(int i=x; i<=N; i+=x) {
			for(int j=1; j<=M; j++) {
				int tmp = (j+k)%M;
				if(tmp==0) tmp = M;
				circle[i][tmp] = temp[i][j];
			}
		}
	}
	private static void turnLeft(int x, int k) {
		int[][] temp = new int[N+1][M+1];

		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				temp[i][j] = circle[i][j];
			}
		}

		for(int i=x; i<=N; i+=x) {
			for(int j=1; j<=M; j++) {
				int tmp = (j-k+M)%M;
				if(tmp==0) tmp = M;
				circle[i][tmp] = temp[i][j];
			}
		}
	}
	private static boolean Check(int i, int j) {

		boolean isChecked = false;

		for(int d=0; d<2; d++) {
			int ni = i + di[d];
			if(ni>=1 && ni<=N && circle[i][j]==circle[ni][j]) {
				isChecked = true;
				checked[ni][j] = true;
			}
		}
		for(int d=0; d<2; d++) {
			int nj = (j + di[d])%M;
			if(circle[i][j]==circle[i][nj]) {
				isChecked = true;
				checked[i][nj] = true;
			}
		}

		return isChecked;
	}
}
