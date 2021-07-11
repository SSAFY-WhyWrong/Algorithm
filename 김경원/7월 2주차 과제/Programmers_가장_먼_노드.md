---
## Programmers 가장 먼 노드
### **Idea**
* BFS로 탐색
* 방문한 노드를 큐에 담고, 기존에 큐에 담겨져 있던 것 만큼만 큐에서 poll해준다.
* answer는 매 번 한 싸이클을 돌고 나올 때마다 큐의 사이즈로 갱신

### ** 핵심 부분 구현**
```java        
        while(!q.isEmpty()) {
        	
        	q_cnt = q.size();
        	answer = q_cnt;
        	for(int i=0;i<q_cnt;i++) {
        		int now = q.poll();
        		for(int num : edge_list[now]) {
        			if(!visit[num]) {
        				visit[num] = true;
        				q.add(num);
        			}
        		}
        	}
        }
```

### 정리
단순 BFS 문제, 엣지를 list로 새로 관리해주었음