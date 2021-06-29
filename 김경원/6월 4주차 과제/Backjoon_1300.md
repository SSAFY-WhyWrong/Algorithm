---
## Backjoon 1300 K번째 수
### **Idea**
* 입력 값이 커서 정렬로 접근할 경우 시간 초과가 나올 가능성이 매우 농후함
* 이분탐색으로 접근
* mid 값을 기준으로 mid 값보다 같거나 작은 수가 몇개인지 세어준다.
* i행은 i의 배수 들로 이루어져 있다. 고로 mid/i로 나누면 mid이하의 값이 몇개인지 알 수 있다.
* i*N이 mid보다 작다면 mid/i 보다 N이 항상 작을 것이고, 반대로 mid보다 크다면 mid/i는 항상 N보다 작을 것이다 

### ** 핵심 부분 구현**
```java
	while(low<=high) {
			long cnt = 0;
			
			mid = (low+high)/2;
			
			for(int i=1;i<=N;i++) {
				cnt += Math.min(mid /i, N);
			}
			
			
			if(cnt >= K) {
				result = mid;
				high = mid-1;
			}else {
				low = mid+1;
			}						
		}
```

### 정리
배열을 만들지 않고 갯 수를 어떻게 세어줄 지를 생각해내는게 중요한 문제였다.

