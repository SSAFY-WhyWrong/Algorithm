---
## Programmers 방금그곡
### **Idea**
* 음악 시작 시간과 끝나는 시간을 모두 분 단위로 바꾸어 음악 재생 시간(분)으로 바꿈
* 음악 재생 시간이 가장 긴 것부터 확인하게 정렬
* C#과 같은 반음의 경우 소문자로 변환하여 처리
* 재상 시간 기준으로 내림차순으로 정렬 되있으므로, 멜로디가 포함된 경우가 있으면 그것이 정답이므로, 뒤에는 더 이상 볼 필요가 없다.


### ** 핵심 부분 구현**
```java        
	static public String solution(String m, String[] musicinfos) {
		String answer = "";
		int result = -1;
		m = parseMelody(m);
		List<Node> list = new ArrayList();

		for (int i = 0; i < musicinfos.length; i++) {
			list.add(new Node(musicinfos[i]));
		}
		Collections.sort(list);

		String melody;
		for (int i = 0; i < musicinfos.length; i++) {
			melody = parseMelody(list.get(i).melody);
			System.out.println(melody);			

			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < list.get(i).len; j++) {
				sb.append(melody.charAt(j % melody.length()));
			}
			if (sb.toString().contains(m)) {
				result = i;
				break;
			}
		}
		if (result == -1)
			answer = "(None)";
		else
			answer = list.get(result).name;

		System.out.println(answer);

		return answer;
	}
```




### 정리
채점 데이터가 하나 계속해서 틀렸다고 나와서 많이 헤맸다.

코드의 문제가 있던 것이 아니었고 문제의 조건에서 사용되는 음은 총 12개로 (C, C#, D, D#, E, F, F#, G, G#, A, A#, B)로 이루어져 있다는 조건이 잘못되었다.

채점 데이터에서는 E#이 필요하다.
