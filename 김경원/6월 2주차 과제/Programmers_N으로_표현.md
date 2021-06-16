---
## Programmers N으로 표현
### **Idea**
* 숫자를 사용하여 만들 수 있는 경우의 수를 각각 list에 담아서 관리
* i번째 경우의 수를 만들기 위해선 list[i]를 만들기 위해서 list[j]와 list[i-j]의 연산 결과를 넣어준다.  


### ** 핵심 부분 구현**
```java        
for(int i=1;i<=8;i++) {
        	num = num*10 +N;
        	list[i].add(num);
        
        	for(int j=1;j<i;j++) {
        		for(int x : list[j]) {
        			for(int y : list[i-j]) {
        				list[i].add(x+y);         				
        				list[i].add(x-y);
        				list[i].add(x*y);
        				if(y!=0)
        					list[i].add(x/y);
        			}
        		}
        	}
        	if(list[i].contains(number)) {
        		return (i);
        	}
        	
        }
```

### 정리
나누기 연산을 할 때, 0으로 나누어지는 경우가 있을 수 있으니 0으로 나누는 경우를 걸러주어야 한다.
