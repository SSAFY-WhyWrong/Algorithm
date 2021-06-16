---
## Baekjoon 20922 겹치는 건 싫어
### **Idea**
* head와 tail 두 개의 포인터를 활용
* head와 tail 사이의 중복된 숫자의 갯수를 셈
* 중복된 숫자가 K개 미만이면 tail을 증가
* 중복된 숫자가 K개 이상이 되면 K보다 작아질 때까지 head를 증가

### ** 핵심 부분 구현**
```java
while(head<N && tail < N) {
			cnt[num[tail]]++;
			if(cnt[num[tail]] > K) {				
				while(cnt[num[tail]]>K) {
					cnt[num[head]]--;
					head++;
				}
			}
			result = Math.max(result, tail-head+1);
			tail++;
		}
```

### 정리
숫자 범위가 20만 이하라서 20만개의 int 배열을 만들어서 숫자를 세주었음


