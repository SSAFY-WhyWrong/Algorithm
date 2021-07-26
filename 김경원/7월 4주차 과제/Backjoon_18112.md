---
## Backjoon_18112 이진수 게임
### **Idea**
* 각 차례마다 큐에 담겼었던 숫자만 확인하면서 차례를 세어준다.
* 가능한 동작들을 행한 뒤 만들어지는 숫자를 큐에 담는다.
* 맨 앞 비트만 제외한 나머지 비트를 각각 XOR 연산하여 보수로 바꿔준다.
* 중복되는 경우를 스킵해준다.
* 각각의 숫자를 비트로 변환하여 관리

### ** 핵심 부분 구현**
```java
		while(!q.isEmpty()) {
			q_size = q.size();
			cnt++;
			for(int i=0;i<q_size;i++) {
				now = q.poll();
				if(now == target) {
					q.clear();
					break;
				}
				if(now > (1024)) continue;
				for(int j=0;(1 << j ) <= Integer.highestOneBit(now);j++) {
					
					//맨 앞 숫자가 아닌 경우 보수로 바꾸기
					if(1<<j != Integer.highestOneBit(now) && !visit[now ^ 1 << j]) {
						visit[now ^ 1 << j] = true;
						q.add(now ^ 1 << j);
					}		
					
					
				}
				if(now!=0 && !visit[now-1]) {
					visit[now-1] = true;
					q.add(now-1);
				}
				if(now+1 < 2048 && !visit[now+1]) {
					visit[now+1] = true;
					q.add(now+1);
				}
			}
			
		}
```

### 정리
입력 값의 이진수 길이가 최대 10이다.

즉 만들어질 수 있는 최대 숫자는 1111111111(2047)이 된다.

