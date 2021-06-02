---
## Baekjoon 13334 철로
### **Idea**
* 집과 사무실 중 값이 더 작은 것을 start, 큰 것을 end로 한 뒤 end 값을 기준으로 오름차순으로 정렬
* start와 end의 거리 차가 d를 넘지 않으면서 우선순위큐에 start를 add 한다
* end 값과 우선순위 큐의 peek 값의 간격이 d를 넘으면 넘지 않는 start 값이 나올 때까지 pop 해준다
* 우선순위 큐의 사이즈가 가장 클 때가 최대 값이다.

### ** 핵심 부분 구현**
```java

		for (int i = 0; i < N; i++) {
			if (list.get(i).end - list.get(i).start > d)
				continue;

			if (!pq.isEmpty() && list.get(i).end > pq.peek() + d) { // 포함할 수 없는 경우
				// 다음 목표의 end가 start + d 보다 크면 start를 새로 갱신 해 주어야함
				while (!pq.isEmpty() && list.get(i).end > pq.peek()+d) {
					pq.poll();
				}

			}

			pq.add(list.get(i).start);
			max_cnt = Math.max(max_cnt, pq.size());

		}
```

### 정리
무엇을 기준으로 정렬할지 무엇을 기준으로 탐색할지가 중요한 라인 스위핑 문제

우선순위 큐에서 pop 하기 전에 peek 값을 확인하고 했어야 했는데 우선 pop하고 확인하였더니 정답과 1의 오차가 생기는 경우가 있었음

