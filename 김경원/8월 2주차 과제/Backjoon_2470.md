---
## Baekjoon 16197 두 용액
### **Idea**
* 입력 값을 오름차순으로 정렬
* 양 쪽 끝 점을 잡고 두 수의 합을 구함
* 현재 값이 0보다 크다면 왼쪽 포인터를, 0보다 작다면 오른쪽 포인터를 옮긴다
* 최소 차이가 만들어지는 경우를 기록하며 반복한다.
* 합계가 0인 경우나 두 포인터가 만나면 종료 

### ** 핵심 부분 구현**
```java
		int start = 0;
		int end = N-1;
		long result = Long.MAX_VALUE;
		long num1=0, num2=0;
		while(start < end) {
			long sum = arr[start] + arr[end];
			
			if(Math.abs(sum) < result) {
				num1 = arr[start];
				num2 = arr[end];
				result = Math.abs(sum);
			}
			
			if(sum > 0)
				end--;
			
			else
				start++;
			
			
		}	

```

### 정리
 

