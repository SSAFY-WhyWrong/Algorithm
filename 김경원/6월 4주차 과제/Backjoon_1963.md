---
## Backjoon 1963 소수 경로
### **Idea**
* 소수 판별을 위해 미리 에라토스테네스의 체를 이용하여 소수 여부를 확인할 수 있는 배열을 만들어둔다. 
* 첫 번째 자리부터 네 번째 자리까지 순서대로 바꿔가면서 확인한다. (BFS - 완전탐색)
* 이미 만들어진 소수에 대해서 체크해준다 (먼저 만들어진 것이 무조건 더 빠르니깐)


### ** 핵심 부분 구현**
```java
while (!q.isEmpty()) {
				if(flag) break;
				int q_size = q.size();
				for (int _q = 0; _q < q_size; _q++) {

					num = q.poll();
					if(num == target) {
						flag= true;
						break;
					}
					
					for (int i = 0; i < 4; i++) {
						for (int j = 0; j < 10; j++) {
							int temp;
							now = num % mod[i];
							now /= div[i];
							now%=10;
							
							temp = num - now*div[i] + j * div[i];
							if(temp >= 1000 && !visit[temp] && !prime[temp]) {								
								visit[temp] = true;
								q.add(temp);
							}
							
							
						}
					}
				}
				cnt++;				
			}

```

### 정리


