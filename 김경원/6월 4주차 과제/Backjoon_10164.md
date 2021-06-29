## 5월 3주차 과제 풀이
---
## Backjoon 10164 격자상의 경로
### **Idea**
* K의 좌표를 구해준다. (K가 0인 경우는 1,1로 처리)
* K의 좌표를 기준으로 K에 도달하기 전과 후 로 나누어 DP 계산을 해준다. (Bottom-up) 


### ** 핵심 부분 구현**
```java
for(int i=1;i<=x;i++) {
			for(int j=1;j<=y;j++) {
				arr[i][j] = arr[i-1][j] + arr[i][j-1];
			}
		}
		
		for(int i=x;i<=N;i++) {
			for(int j=y;j<=M;j++) {
				arr[i][j] = arr[i-1][j] + arr[i][j-1];
			}
			
		}


```

### 정리
K의 좌표를 구한 후, 좌표까지와 좌표부터로 경우의 수를 구해주면 된다.

