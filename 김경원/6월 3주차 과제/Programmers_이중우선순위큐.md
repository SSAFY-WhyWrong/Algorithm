---
## Programmers 이중우선순위큐
### **Idea**
* 리스트로 관리
* 삽입을 할 때마다 오름차순 정렬
* 리스트의 제일 앞이 최소값, 제일 뒤가 최대값이다.
* 삭제 연산 시 앞과 제일 끝만 삭제 해주면 된다.


### ** 핵심 부분 구현**
```java        
        for (int i = 0; i < oper_length; i++) {
			// 삽입
			int num = Integer.parseInt(operations[i].substring(2));
			if (operations[i].charAt(0) == 'I') {
				list.add(num);
				cnt++;
				Collections.sort(list);
			}
			// 삭제
			else {
				if (cnt != 0) {
					if (num == 1) {
						list.remove(cnt-1);
					} else {
						list.remove(0);
					}
					cnt--;
				}
			}
		}
```

### 정리
우선순위 큐처럼 삽입 시마다 정렬을 해주면 된다.

이중이라고 해서 정렬 조건을 2개로 할 필요 없이 양 쪽 끝을 봐주면 된다.
