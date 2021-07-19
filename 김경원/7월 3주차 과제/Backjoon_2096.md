---
## Backjoon_2096 내려가기
### **Idea**
* DP로 해결
* 현재 위치까지 올 수 있는 max와 min 값을 갱신
* 자신의 위치 기준으로 세 방향(↖↑↗)을 보는데 범위를 벗어나는 곳은 무시하며 각각의 값을 갱신한다.

### ** 핵심 부분 구현**
```java
for(int i=1;i<N;i++) {
			
			for(int j=0;j<3;j++) {
				max[i][j] = -1;
				min[i][j] = 100000*9;
				for(int d=0;d<3;d++) {
					int x = j + delta[d];
					if(x < 0 || x>=3) continue;
					
					max[i][j] = Math.max(max[i][j], max[i-1][x]);
					min[i][j] = Math.min(min[i][j], min[i-1][x]);
				}
				max[i][j] += arr[i][j];
				min[i][j] += arr[i][j];
				
			}
		}
```

### 정리

