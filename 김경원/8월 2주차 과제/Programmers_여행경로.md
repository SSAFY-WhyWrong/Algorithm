---
## Programmers 여행경로
### **Idea**
* 모든 티켓을 한 번씩만 모두 사용 하여야 함
* HashMap을 이용하여 각 도시마다 index 값을 주어서 관리
* 티켓으로 그래프의 형태를 만들어 DFS 탐색
* 탐색 시 공항의 이름 기준 사전순으로 먼저 나오는 도시를 먼저 방문하도록 간선의 순서를 정렬
 


### ** 핵심 부분 구현**
```java        
	static void DFS(int ticketCnt, int cnt, int now){
		
		if(cnt > ticketCnt) {
			isFinish = true;
			return;
		}
		
		
		for(Node node : list[now]) {
			if(used[node.num]) continue;
			
			used[node.num] = true;
			route[cnt] = node.name;			
			DFS(ticketCnt, cnt+1, node.idx);
			if(isFinish) return;
			
			used[node.num] = false;
		}
		
	}
```

### 정리

