---
## Programmers 캐시
### **Idea**
* LRU를 구현하는 문제
* 캐시를 List로 구현하고 변화가 있을 때마다 List를 정렬한다.
* 캐시에 있는 도시명인 경우 hit, 아닌 경우 miss로 처리하여 시간을 계산
* cacheSize가 0인 경우도 고려하여야함


### ** 핵심 부분 구현**
```java
				for(int i=0;i<city_cnt;i++) {
			isCacheHit = false;
			
			for(int j=0;j<cache.size();j++) {
				if(cache.get(j).name.equals(cities[i].toLowerCase())) {
					answer += 1;
					cache.get(j).idx = i;
					isCacheHit = true;
					break;
				}
			}
			
			if(!isCacheHit) {
				answer +=5;
				if(!cache.isEmpty() && cache.size() >= cacheSize) {
					cache.remove(0);					
				}
				if(cache.size() < cacheSize)
					cache.add(new Node(cities[i].toLowerCase(),i));
			}
			
			if(!cache.isEmpty()) {
				Collections.sort(cache);
			}
			
		}

```

### 정리
단순, LRU 구현 문제. 어떻게 구현할 것인지와 예외 사항을 잘 처리해주면 특별히 문제가 없다.

