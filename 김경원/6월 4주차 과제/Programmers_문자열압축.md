---
## Programmers 문자열 압축
### **Idea**
* 문자 단위를 1부터 s의 길이/2 까지 늘려가면서 확인해준다.
* 현재 확인 중인 문자열의 길이 만큼 idx 값을 증가시키면서 같은지 확인
* 같으면 cnt 값을 증가, 다르면 cnt가 2이상인 경우 문자열에 추가하고 현재까지 비교한 문자열을 추가해준다.
* 마지막까지 확인 후 남은 문자를 덧붙인 후 길이의 최소값을 갱신해준다.


### ** 핵심 부분 구현**
```java        
  for(int i=1;i<=length/2;i++) {
        	idx = i;
        	cnt = 1;
        	String compStr = "";
        	String now = s.substring(0,i);
        	while(idx+i <= length) {
        		String next = s.substring(idx,idx+i);        		
        		if(now.equals(next)) {
        			cnt++;
        		}else {
        			if(cnt >=2)
        				compStr += cnt;
        			compStr += now;
        			now = next;
        			cnt = 1;
        		}
        		
        		idx += i;
        	}
        	
        	if(cnt >=2)
        		compStr += cnt;
        	compStr += now;
        	if(idx < length)
        		compStr += s.substring(idx);
        	answer = Math.min(answer, compStr.length());
        }
```

### 정리
s의 길이가 1인 경우를 고려하지 않아 처음에 케이스 하나가 fail이 나왔다.

항상 최솟값과 최댓값은 확인하도록 노력하자
