---
## Backjoon 1486 등산
### **Idea**
* 각각의 산에서 다른 산 까지 가는 경로를 만들어준다 (이 때 T가 넘지 않는 것들만 구해준다)
* 호텔에서 각 산까지 가는 최소 시간을 구한다.
* 산에서 호텔까지 가는 최소 시간을 구한다.
* 위 두 시간을 더해서 D를 넘지 않는 경우에서 최대값을 찾는다


### ** 핵심 부분 구현**
```java
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int now = arr[i][j];
				for (int d = 0; d < 4; d++) {
					int next_i = i + ni[d];
					int next_j = j + nj[d];

					if (next_i < 0 || next_j < 0 || next_i >= N || next_j >= M || Math.abs(now - arr[next_i][next_j]) > T) {
						continue;
					}


					int weight = arr[i][j] >= arr[next_i][next_j] ? 1 : Math.abs(arr[i][j] - arr[next_i][next_j]);
					weight *= weight;

					//호텔에서 산으로 가는 최소 시간를 위한 edge
					edge[i][j].add(new Node(next_i, next_j, weight, 0));
					
					//호텔에서 산으로 가는 최소 시간을 구하기 위한 edge
					rEdge[next_iㅊ][next_j].add(new Node(i, j, weight, 0));

				}
			}
		}

```


