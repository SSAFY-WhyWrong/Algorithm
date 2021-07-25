---
## Programmers 배달
### **Idea**
* 다익스트라로 각 마을의 최단 경로를 계산한다
* 각 마을의 최단 경로가 K보다 작은 것의 수를 세어준다.


### ** 핵심 부분 구현**
```java        
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(now.weight  > dist[now.idx]) continue;
			
			
			
			for(Node node : edge[now.idx]) {
				if(node.weight + dist[now.idx]<dist[node.idx]) {
					dist[node.idx]= node.weight + dist[now.idx];
					pq.add(new Node(node.idx,dist[node.idx]));
				}
			}
		}
        
```

### 정리
단순 다익스트라 문제이다.
