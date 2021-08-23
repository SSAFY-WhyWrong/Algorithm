---
## Programmers 오픈채팅방
### **Idea**
* 닉네임은 입장 시 와 입장 후에만 변경된다.
* 사용자의 uid를 기준으로 최종 닉네임을 기억해둔다.
* uid와 닉네임은 HashMap으로 관리
 


### ** 핵심 부분 구현**
```java        
	static void DFS(int ticketCnt, int cnt, int now){
		
		for (String str : record) {
			order = str.split(" ");

			if (order[0].equals("Change")) {
				nickname[map.get(order[1])] = order[2];
			}else if(order[0].equals("Enter")) {
				if (!map.containsKey(order[1])) {
					map.put(order[1], idx);
					nickname[idx] = order[2];
					list.add(new Node(idx++, order[0]));
				} else {					
					nickname[map.get(order[1])] = order[2];
					list.add(new Node(map.get(order[1]), order[0]));
				}
			}else {
				list.add(new Node(map.get(order[1]),order[0]));
			}

		}
		
	}
```

### 정리

