import java.util.LinkedList;
import java.util.Queue;

public class 프로그래머스_네트워크 {
	static Queue<Integer> q;
    static boolean[] arr;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        arr=new boolean[n];
        q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(arr[i]!=true){
                arr[i]=true;
                answer+=1;
                for(int j=0;j<n;j++){
                    if(i!=j&&arr[j]!=true&&computers[i][j]==1){
                        q.offer(j);
                        arr[j]=true;
                        bfs(n,computers);
                    }
                }
            }
        }
        return answer;
    }
    static void bfs(int n, int[][] computers){
        while(!q.isEmpty()){
            int net=q.poll();
            for(int i=0;i<n;i++){
                if(i!=net && arr[i]!=true && computers[net][i]==1){
                    q.offer(i);
                    arr[i]=true;
                }
            }
        }
    }
}
/*
 * bfs 문제로 풀었다. 
 * 자기자신 컴퓨터도 연결되어있는걸로 처리해서 자기자신제외, 방문한것들 제외, 컴퓨터 연결상태가 1인것만 찾아서  네트워크를 찾아냈다.
 * 해당 컴퓨터를 처음방문하면 그때마다 네트워크를 추가해주었다.
 * */
