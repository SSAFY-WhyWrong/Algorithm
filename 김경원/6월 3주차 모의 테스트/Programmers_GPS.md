---
## Programmers GPS
### **Idea**
* k번까지 최소 수정 횟수를 각각의 구간으로 나누어 계산한다.
* 시작 거점과 도착 거점을 제외하고 각 경로를 임의의 거점일 때 몇 번 수정해야 가능한지를 기록한다.
* dp[i][j]는 i번째 거점이 j거점일 경우에 최소 수정 횟수를 저장한다.
* dp[i][j] = Math.min(dp[i][j],dp[i-1][k]) 이다. (k는 j까지 올 수 있는 경로를 가지는 임의의 거점)
* j가 gps_log와 값이 다르다면 dp에 1을 더 해준다 ( 현재 수정을 한 것이니깐 )

### ** 핵심 부분 구현**
```java        
	dp[0][start] = 0;
        
        for(int i=1;i<k-1;i++) {
        	for(int j=1;j<=n;j++) {
        		
        		for(int before : edge[j]) { //j까지 올 수 있는 경로 확인
        			dp[i][j] = Math.min(dp[i-1][before], dp[i][j]);
        			//i-1번째에서 출발하여 j까지 올 수 있는 경로 중에서 최소값 구함
        		}
        		
        		if(gps_log[i] != j) dp[i][j]+=1; //현재가 로그와 같지 않은 경우 바꿔야함
        		
        	}
        }
        
        for(int before : edge[end]) {
        	dp[k-1][end] = Math.min(dp[k-2][before], dp[k-1][end]);
        }
```

### 정리
DFS로 완전 탐색을 하니 시간 초과가 나와서

구간을 나누어 계산하는 방식으로 바꾸었다.

시간복잡도가 O(k * (n + m ) ) 이다. (최악의 경우 한 노드당 m번씩 확인하니깐) 

