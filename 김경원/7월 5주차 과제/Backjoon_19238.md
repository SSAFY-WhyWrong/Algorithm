---
## Backjoon_16118 스타트 택시
### **Idea**
* 현재 택시의 위치를 기준으로 BFS 탐색하여 각 지점까지 얼마만에 도달할 수 있는지 계산
* 위에서 구한 거리로 승객들의 위치를 가까운 순으로 정렬
* 기름이 부족하지 않다면 승객을 태우고 그 후 목적지도 기름 한도 내에 가능한지 확인
* 더 이상 대기 중인 승객이 남지 않을 때가지 반복


### ** 핵심 부분 구현**
```java
while (list.size() > 0) {
			getWay(way, car_x, car_y, N);

			for (int i = 0; i < list.size(); i++) {
				Client client = list.get(i);
				if (way[client.pos_x][client.pos_y] == -1)
					client.way_len = Integer.MAX_VALUE;
				else
					client.way_len = way[client.pos_x][client.pos_y];
			}
			// 거리 구하기 끝

			Collections.sort(list);
			Client client = list.get(0);
			fuel -= client.way_len;

			if (fuel < 0) {
				isFail = true;
				break;
			}

			int dist = getDist(N, client);

			if (dist > fuel) {
				isFail = true;
				break;
			}

			fuel += dist;
			
			car_x = client.target_x;
			car_y = client.target_y;
			list.remove(0);
		}

		if (isFail)
			System.out.println(-1);
		else
			System.out.println(fuel);
```

### 정리
처음에 승객의 위치를 기준으로 각각 BFS 탐색을 해주니 시간 초과가 나옴

한 번의 BFS 탐색으로 모든 승객들의 거리를 알 수 있으니 전체 BFS 탐색 후 승객 별 거리를 반환해주니 해결됨
