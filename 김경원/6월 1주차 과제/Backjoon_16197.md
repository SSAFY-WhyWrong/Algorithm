---
## Baekjoon 16197 두 동전
### **Idea**
* 백트래킹으로 구현
* 동전이 하나도 떨어지지 않은 경우에만 DFS로 다음 탐색
* 동전이 1개만 떨어진 경우에 result 값 갱신
* 현재 버튼을 누른 횟수가 result 보다 크면 return (최선의 수가 아님)
* 상하좌우로 움직였을 때 동전의 위치가 변하지 않았다면 탐색하지 않음

### ** 핵심 부분 구현**
```java
private static void simulate(int time, Queue<Node> q) {
				
		if(time >= result)
			return;
		
		
		for(int d=0;d<4;d++) {
			Node coin[] = new Node[2];
			int x,y;
			int drop=0;
			for(int i=0;i<2;i++) {
				coin[i] = q.poll();
				x = coin[i].i + ni[d];
				y = coin[i].j + nj[d];
				
				if(x<0 || x>= N || y<0 || y>=M) {
					drop++;
					continue;
				}
				
				
				if(map[x][y] == '#') {
					x -= ni[d];
					y -= nj[d];
				}
				q.add(new Node(x,y));
			}
			
			if(drop==0) {
				boolean isSame = true;
				for(int i=0;i<2;i++) {
					Node node = q.poll();
					if(node.i != coin[i].i || node.j != coin[i].j)
						isSame = false;
					q.add(node);
				}
				if(!isSame)
					simulate(time+1, q);
			}
			else if(drop==1) {
				result = Math.min(result, time);
				return;
			}		
			q.clear();
			for(int i=0;i<2;i++) {
				q.add(coin[i]);
			}
			
			
		}
		
		
	}

```

### 정리
문제에선 입력 케이스 대비 시간 제한이 길어 최적화가 많이 필요하지 않아 보임

동전의 방문 위치 여부를 쌍으로 파악해서 중복된 쌍을 반복하지 않도록 하면 시간을 좀 더 줄일 수 있을 것으로 보이나 구현하진 않았음.

(구현 하지 않아도 충분히 시간 내에 들어올 것이라고 판단)  

