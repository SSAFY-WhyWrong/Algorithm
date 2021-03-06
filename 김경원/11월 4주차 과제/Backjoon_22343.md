---
## Backjoon 22343 괄호의 값 비교
### **Idea**
* 문자열의 길이는 최대 300만이다. (즉, 괄호 안의 숫자는 최대 2^(150-1) 이므로 일반적으로 계산해서 구할 수 없다)
* 각 단순 괄호열은 2^(n-1) 으로 구할 수 있다. (n은 괄호의 갯 수)
* 길이가 서로 다른 단순 괄호열은 2^(n-1)들의 덧셈으로 볼 수 있다
* 2^n에 해당하는 단순 괄호열이 몇 개인지 구한다.
* `x * 2^(n-1)` 은 ` x/2 * 2^n`과 같다. 이를 이용하여 올려줄 수 있는 값을 모두 올려준다.  

### ** 핵심 부분 구현**
```java
	static void count(String str, int[] arr, int len) {
		int sqr = 0;
		for (int i = 0; i < str.length(); i++) {

			if (str.charAt(i) == '(') {
				sqr++;
				if (str.charAt(i + 1) == ')')
					arr[sqr - 1]++;

				continue;
			}

			sqr--;

		}

		for (int i = 0; i < len - 1; i++) {
			arr[i + 1] += arr[i] / 2;
			arr[i] %= 2;
		}

	}

```

### 정리
처음에 수치를 보지 않고 단순 문자열 문제라고 생각했더니 답이 나오지 않았다. 입력 범위를 확인하니 값이 굉장히 크다는 것을 알았다.

이게 올해 초등부 문제라는 것이 제일 놀랍다.

