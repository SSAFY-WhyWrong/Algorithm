## 5월 2주차 과제 풀이
---
## Programmers 완주하지 못한 선수
### **Idea**
* 입력의 수는 100000 이하이며 참가자는 동명이인이 있을 수 있다. 이름의 길이는 최대 20자
* 완주한 사람의 수는 항상 참여자보다 1 작다.
* 그렇기에 배열을 정렬한 후 하나씩 비교하며 같지 않은 것이 나올 때까지 확인한다.(같지 않다는 것은 현재의 참가자가 완주하지 못했다는 것이다)
* 완주한 사람과 전부 비교했는데 같지 않은 경우가 없었다면 마지막 참가자가 완주하지 못한 것이다.


### ** 핵심 부분 구현**
```java
   public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        int arrayLength = completion.length;
        
        for(int i=0;i<arrayLength;i++){
            if(participant[i].equals(completion[i])) continue;
            answer = participant[i];
            break;
        }
        
        if(answer.length()==0) answer = participant[arrayLength];
        
        return answer;
    }

```

### 정리
최악의 경우 99999번동안 String Equals를 진행하게 된다.

String Equals의 경우 최악의 경우 20글자를 비교한다.

99999 * 20 = 19999880 이므로 1초를 넘기지 않을 것이라고 판단하였다.
