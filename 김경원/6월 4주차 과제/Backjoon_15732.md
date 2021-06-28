---
## Backjoon 15732 도토리 숨기기
### **Idea**
* 규칙을 모두 동시에 적용 시켜야 한다.
* 이분탐색으로 접근, low에 최소 상자 번호를 high에는 가장 큰 상자 번호를 넣고 탐색 한다.
* 이분탐색으로 뽑아낸 번호로 마지막 상자가 될 수 있는 최소값을 찾는다.

### ** 핵심 부분 구현**
```java
	static long getAmount(Node[] rule, int K,int mid) {
		
		int temp;
		long sum=0;
		
		for(int i=0;i<K;i++) {
			temp =  Math.min(rule[i].end, mid) - rule[i].start;
			if(temp < 0) continue;
			
			temp = temp/rule[i].c + 1;
			
			sum+=temp;
			
			
		}
		
		
		
		return sum;
	}
```

### 정리
이분 탐색 이외에는 단순한 수학 계산만 하면 된다.

