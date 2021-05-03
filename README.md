## 5월 1주차 과제 풀이
---
## 1. Backjoon 2583 영역 구하기
### **Idea**
* 입력으로 주어지는 모눈종이 영역 만큼 boolean 배열을 true 해준다
* 모눈종이가 아닌 모든 영역을 확인하며 BFS/DFS로 탐색하며 탐색한 영역을 true 해주며 각 영역의 개수를 확인
* 더 이상 탐색할 수 없으면 PriorityQueue에 현재 탐색한 영역의 개수를 EnQueue
* 모든 영역이 true가 될 때까지 반복한다.
* PriorityQueue에 담긴 size가 영역의 개수이고 안에 들어간 수들이 영역의 크기


### ** 핵심 부분 구현**
```java
  static PriorityQueue<Integer> result = new PriorityQueue();
  
  main(){
    //생략
  		for(int i=0;i<M;i++) {
		  	for(int j=0;j<N;j++) {
				  if(!visit[i][j]) BFS(i,j);
		  	}
		}
    //아래 생략
  }
  
  
	static void BFS(int start_i, int start_j) {
		int ni[] = {-1,1,0,0};
		int nj[] = {0,0,-1,1};
		
		Queue<Node> q = new LinkedList();
		
		int cnt = 1;
		visit[start_i][start_j] = true;
		q.add(new Node(start_i, start_j));
		
		
		int x,y;
		while(!q.isEmpty()) {
			Node node = q.poll();
			for(int d=0;d<4;d++) {
				x = node.i + ni[d];
				y = node.j + nj[d];
				
				if(x< 0 || y<0 || x>=M || y>=N || visit[x][y]) continue;
				
				visit[x][y] = true;
				cnt++;
				q.add(new Node(x,y));
				
			}
		}
		
		result.add(cnt);
		
	}

```

### 정리
M*N의 배열을 모두 확인하면서 방문하지 않았거나 모눈종이가 아닌 경우에만 BFS 해주었는데, 남은 공간의 수를 계산하여 남은 공간이 더 이상 없을 때 바로 stop 해주면 조금이지만 시간을 빠르게 끝낼 수 있을 것 같다
