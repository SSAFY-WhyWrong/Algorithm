---
## Programmers 미로 탈출
### **Idea**
* 비트마스킹 + 다익스트라로 접근하여 풀이
* trap인 노드의 방문 여부를 기록 하여야 한다.
* trap 방문 여부를 비트마스킹 하여 관리
* 노드는 1000개까지 있을 수 있지만 트랩은 최대 10개까지만 있으므로 트랩의 인덱스를 따로 관리하여 길이 10의 비트마스크로 관리
* 정방향으로 갈 수 있는 경우는 현재 노드와 목적지 노드가 모두 정상 상태이거나 모두 함정이 발동된 경우
* 역방향으로 갈 수 있는 경우는 현재 노드만 함정이 발동 되었거나, 목적지 노드만 함정이 발동된 경우
* 위의 조건들을 지키며 다익스트라 알고리즘을 적용시켜 목적지 도착할 때까지 최단 거리를 갱신 시킴


### ** 핵심 부분 구현**
- trap 관리

```java        
		for (int i = 0; i < traps.length; i++) {
			isTrap[traps[i]] = true;
			trap_idx[traps[i]] = i+1;
		}
```

- 경로 초기화

```java
		int dist[][] = new int[n+1][1 << (traps.length+1)];
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < 1 << (traps.length+1); j++) {
				dist[i][j] = 100000000;
			}
		}
```

- 다익스트라

```java
		while (!pq.isEmpty()) {
			Node now = pq.poll();
			if(now.idx == end) {
				System.out.println(now.weight);
				return now.weight;
			}
			
			if (dist[now.idx][now.bit] < now.weight)
				continue;
			
			
			//정방향 있는 경우
			for (Node node : edge[now.idx]) {
				boolean temp = false;
				//현재 위치만 역방향인 경우 혹은 가려는 곳만 역방향이 된 경우
				if((now.bit & 1 << trap_idx[now.idx])!=0 && (now.bit & 1 << trap_idx[node.idx])==0) continue;
				if((now.bit & 1 << trap_idx[now.idx])==0 && (now.bit & 1 << trap_idx[node.idx])!=0) continue;
				
				
				int bit = now.bit;
				//목적지 노드가 함정인 경우  상태 변경을 해줌
				if(isTrap[node.idx]) bit = bit ^ (1 << trap_idx[node.idx]);
				
				if(dist[node.idx][bit] > now.weight + node.weight) {
					dist[node.idx][bit] = now.weight + node.weight;
					pq.add(new Node(node.idx, dist[node.idx][bit], bit));
				}
				
				
			}
			
			//역방향이 있는 경우
			for (Node node : r_edge[now.idx]) {
				boolean temp = false;
				//양 쪽 모두 역방향인 경우, 양쪽 모두 정방향인 경우
				if((now.bit & 1 << trap_idx[now.idx])!=0 && (now.bit & 1 << trap_idx[node.idx])!=0) continue;
				if((now.bit & 1 << trap_idx[now.idx])==0 && (now.bit & 1 << trap_idx[node.idx])==0) continue;
				
				int bit = now.bit;
				//목적지 노드가 함정인 경우  상태 변경을 해줌
				if(isTrap[node.idx]) bit = bit ^ (1 << trap_idx[node.idx]);
				
				if(dist[node.idx][bit] > now.weight + node.weight) {
					dist[node.idx][bit] = now.weight + node.weight;
					pq.add(new Node(node.idx, dist[node.idx][bit], bit));
				}
			}
			

		}
```

### 정리
|방향 | 현재 노드 | 목적지 노드|
|:---:|:---: |: ---:|
|정방향 | 0 | 0 |
|정방향 | 1 | 1|
|역방향 | 1 | 0|
|역방향 | 0 | 1|


