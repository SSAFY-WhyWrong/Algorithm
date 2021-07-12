---
## Programmers 크레인 인형뽑기 게임
### **Idea**
* 뽑아서 바구니에 담은 것을 스택에 넣어줌
* 스택에 담을 때 스택이 비어있지 않다면 스택의 Peek와 비교하여 같으면 삽입하지 않고 스택에서는 pop 해줌
* 그 외는 모두 삽입


### ** 핵심 부분 구현**
```java
	if (now == 0)
				continue;

			if (!stack.isEmpty() && stack.peek() == now) {
				stack.pop();
				answer += 2;
			} else {
				stack.add(now);
			}
```

### 정리
문제에서 인형이 없는 곳에서 조작하는 경우는 없다고 그랬는데 채점 케이스 1,2번이 그런 케이스 였다.