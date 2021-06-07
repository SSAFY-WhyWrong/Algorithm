---
## Backjoon 2170 선 긋기
### **Idea**
* 시작점을 기준으로 오름차순 정렬
* 다음 선분의 끝 점이 현재의 시작 점 보다 작으면 끝 점만 갱신
* 다음 선분의 끝 점이 현재의 시작 점 보다 크면 현재의 선분 길이를 결과에 더해주고, 선분을 변경

### ** 핵심 부분 구현**
```java
int result=0;
		start =-1000000000 ; end = -1000000000;
		for(int i=0;i<N;i++) {
			if(end < list.get(i).i) {
				result += end-start;
				start = list.get(i).i;
				end = list.get(i).j;
			}
			else
				end = Math.max(end, list.get(i).j);
		}
		result += end - start;


```

### 정리
데이터 범위를 잘못봐서 최소 데이터 좌표 값이 0인 줄 알았다.

항상 데이터 범위를 잘 확인하고 문제를 풀도록 하자

