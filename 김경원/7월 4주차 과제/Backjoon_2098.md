---
## Backjoon_2098 외판원 순회
### **Idea**
* 외판원 문제 (한 번 방문한 도시를 재방문하지 않으면서 모든 도시를 방문 후 처음 도시로 돌아오는 최단 경로)
* 경로가 없는 경우는 MAX값을 지정해주었음. (오버플로우를 방지하기 위해 Integer의 max value 대신에 입력 데이터 상 나올 수 있는 최대값보다 큰 값으로 대체)
* 완전 탐색으로 접근하는 경우 O(N!)의 시간이 걸리므로 DP로 접근
* 도시의 방문 여부를 비트마스킹하여 관리 (방문 여부만 기억, 순서는 중요치 않음)
* TSP로 만들어진 경로는 사이클을 이루는 상태 (즉, 어디서부터 시작하든 결과는 똑같다)
* 도시 방문 여부 상태와 출발 노드에 따른 결과를 memorization 해준다.
* bit가 방문한 도시를 나타내는 비트마스크 값이고, node가 현재 위치라고 하면 dist[node][bit]는 도시 방문 상태가 bit일 때 node에서 출발할 때 나오는 최소 경로값이 저장되어야 한다. 

### ** 핵심 부분 구현**
```java
	static int TSP(int now,int bit) {
		
		
		if(bit == (1 << N) - 1) {			
			return edge[now][0];
		}
		
		
		if(dist[now][bit]!=MAX_WEIGHT)
			return dist[now][bit];
		
		for(int i=0;i<N;i++) {			
			if(edge[now][i]!=MAX_WEIGHT && (bit & (1 << i)) == 0 ) {
				dist[now][bit] = Math.min(dist[now][bit], TSP(i, bit | 1 << i) + edge[now][i]);
			}
		}
		
		
		
		return dist[now][bit];
	}
```

### 정리
시간 복잡도는 각각의 도시 N개를 방문 하냐 안 하냐므로, O (N * 2^N)이 된다.
