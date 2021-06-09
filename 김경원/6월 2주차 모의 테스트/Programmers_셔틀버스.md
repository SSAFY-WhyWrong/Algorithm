## 4월 5주차 과제 풀이
---
## Programmers 네트워크
### **Idea**
* 입력 데이터를 String에서 int로 파싱한 뒤 분 단위로 변경해준다
* 분 단위로 변경된 도착 시간을 먼저 오는 순으로 정렬한다.  
* 버스 첫 도착 시간부터 마지막 도착 시간까지 셔틀버스가 오는 시간까지 도착 가능한 인원(cnt)을 최대 m명까지 세어준다.  
* 마지막 셔틀버스 도착시간 까지 확인 후 대기 인원이 m보다 작으면 마지막 버스 도착 시간을 출력
* 그 외에는 m번째 대기인원의 시간보다 1분 빠른 시간을 출력한다.


### ** 핵심 부분 구현**
```java
		while(true) {			
			while(idx < size) {
				if(times.get(idx) <= now_time && cnt < m) {
					cnt++;
					idx++;
				}
				else
					break;
			}
			if(now_time == final_time) break;
			cnt -= m;
			if(cnt < 0 ) cnt = 0;
			now_time += t;
					
		}

		if(cnt < m) result = final_time;
		else result = times.get(idx-1)-1;
```

### 정리
버스 도착 시간마다 m명까지 세어주는 것을 고려하지 않아 일부 테스트 케이스가 fail이 나왔었다.

나의 코드에서는 cnt < m을 넣어주지 않으면 도착 시간만 기준으로 세어주었기에

cnt가 이미 m을 넘은 상황에서 계속해서 인원을 세었기에

마지막 인원을 정확하게 판별해내지 못하였음 