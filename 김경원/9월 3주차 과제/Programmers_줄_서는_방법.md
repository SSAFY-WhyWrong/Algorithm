---
## Programmers 줄 서는 방법
### **Idea**
* 첫 번째 숫자부터 하나 씩 구하면서 리스트에서 빼주어 규모를 줄인다.
* 사람의 수가 n명일 때, 경우의 수는 총 n!
* n! / n 을 하면 제일 앞 사람이 올 수 있는 단위 x를 알 수 있다.
* k번째 방법인, k / x 를 하면 첫 번째 사람의 숫자를 알 수 있다.
* 이러한 방법으로 첫 번째 자리의 숫자를 파악하면서 사용한 숫자를 제거해준다.
* 숫자가 줄어들어 경우의 수도 줄어드니깐 k를  mod x 해서 갱신해준다. 


### ** 핵심 부분 구현**
```java        
        long x = 1;
        List<Integer> numbers = new ArrayList();
        for(int num=1; num<=n;num++) {
        	numbers.add(num);
        	x *= num;
        }      
        
        k-=1;
        
        for(int i=0;i<n;i++) {
        	x =  x / (n-i); 
        	int idx =  (int)(k / x);
        	answer[i] = numbers.get(idx);
        	numbers.remove(idx);  
        	k %= x;
        }
```

### 정리

