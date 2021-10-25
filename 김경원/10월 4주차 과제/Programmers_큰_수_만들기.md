---
## Programmers 큰 수 만들기
### **Idea**
* numbers의 길이 length이면 만들려고 하는 결과는 length-k 의 길이를 가진 최대 숫자 이다.
* 숫자를 순서대로 입력하면서 기존에 입력된 숫자들이 현재 숫자보다 작다면 기존 숫자를 제거
* 숫자 제거 행위를 최대 k번까지 반복


### ** 핵심 부분 구현**
```java        
	   for(int i=0;i<number.length();i++) {
        	char now = number.charAt(i);
        	
        	while(len!=0 && list.get(len-1) < now && remove_cnt < k) { 
        		list.remove(len-1);
        		len--;
        		remove_cnt++;
        	}
        	
        	len++;
        	list.add(now);
        }
```
