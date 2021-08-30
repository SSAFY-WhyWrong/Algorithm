---
## Programmers 광고 삽입
### **Idea**
* 각 구간 별로 몇 명이 있는지 기록
* 각 구간을 구간합을 만들어 관리
* 현재 시간 ~ 광고 시간 까지의 누적합을 이용하여 가장 많이 보는 순간을 구해준다


### ** 핵심 부분 구현**
```java        
        for(int i=1;i<cnt.length;i++) {
        	cnt[i]+=cnt[i-1];
        }
        
        
        int start = 0;
        int end = advtime;
        long maxtime = cnt[advtime-1];
        int answertime=0;
        for(int i=0; i <= playtime - advtime; i++) {
        	long time = cnt[i+advtime] - cnt[i];
        	if(maxtime < time) {
        		answertime = i+1;
        		maxtime = time;
        	}
        }
```

### 정리
단순하게 합을 구하니 시간이 초과 되어 합계를 구할 때 구간합을 이용하여 빠르게 구해주었다.
