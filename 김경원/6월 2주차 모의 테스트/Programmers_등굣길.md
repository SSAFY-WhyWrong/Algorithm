## 4월 5주차 과제 풀이
---
## Programmers 네트워크
### **Idea**
* 이동은 반드시 오른쪽, 아래로만 가능하니 어느 위치로 오는 방법은 왼쪽과 위에서 오는 것 밖에 없다.
* 왼쪽과 위에서 오는 경우의 수를 합치면 그 지점까지 오는 최단거리 경우의 수가 된다.
* DP로 접근하면 O(n*m) 만에 결과를 얻어낼 수 있다.
* puddle이 있는 위치만 계산을 해주지 않는다.


### ** 핵심 부분 구현**
```java
		for (int i = 0; i < puddles.length; i++) {
			y = puddles[i][0];
			x = puddles[i][1];
			isPuddle[x][y] = true;
		}

		for (int i = 0; i <= n; i++)
			dp[i][0] = 0;

		for (int j = 0; j <= m; j++)
			dp[0][j] = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (!isPuddle[i][j]) {
					dp[i][j] += dp[i - 1][j] % 1000000007 + dp[i][j - 1] % 1000000007;
					dp[i][j] %= 1000000007;

				}
			}
		}
```

### 정리
단순 DP 문제이다.

puddle 관리를 boolean으로 해주었는데,

n과 m이 컸다면 x,y 좌표를 리스트에 담고 정렬하여 순서대로 피해주는 방법을 사용해도 될 거 같지만 n,m이 100*100이 최대라 그러지 않았다.