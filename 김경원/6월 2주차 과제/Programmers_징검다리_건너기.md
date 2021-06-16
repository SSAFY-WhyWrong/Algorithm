---
## Programmers 징검다리 건너기
### **Idea**
* 이분탐색으로 값을 뽑아, 그 값보다 작은 경우가 K번 이상 연속으로 나오는지 확인


### ** 핵심 부분 구현**
```java        
        while(low<=high) {
        	mid = (low+high)/2;
        	cnt = 0;
        	for(int i=0;i<length;i++) {
        		if(stones[i] < mid) {
        			cnt++;
        		}else {
        			cnt = 0;
        		}
        		
        		if(cnt >= k) {
        			high = mid-1;
        			break;
        		}
        	}
        	if(cnt < k) {
        		low = mid+1;
        		answer = Math.max(answer, mid);
        	}
        }
        
        
        return answer;
```

### 정리
처음엔 이분 탐색이 아닌 완전 탐색으로 K개씩 묶어서 확인하였는데, 일부 케이스에서 시간이 초과됨

그래서 시간을 줄이기 위해 이분탐색으로 대체
