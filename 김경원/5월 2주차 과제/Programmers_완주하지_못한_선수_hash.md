## 5월 2주차 과제 풀이
---
## Programmers 완주하지 못한 선수 (Hash ver)
### **Idea**
* String Equals의 경우 효율이 좋은 함수가 아니므로 Hash하여 관리하기로 함
* 완주한 사람을 모두 HashMap에 담아준다 (이름은 Key가 되고, 동명이인의 수가 value 값이 된다)
* 참가자들의 이름을 key값으로 처리하여 HashMap의 value값에 접근하여 -1 해준다.
* 접근 당시 value 값이 null 혹은 0이 이라면 그 사람이 완주하지 못한 것이다. (0도 해주는 이유는 동명이인이 있으니깐)


### ** 핵심 부분 구현**
```java
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        HashMap<String, Integer> hash = new HashMap();
        
        int length = completion.length;
        for(int i=0;i<length;i++){
            if(hash.get(completion[i]) == null){
                hash.put(completion[i],1);
            }else{
                int num = hash.get(completion[i]);
               hash.put(completion[i],num+1);
            }
        }
        
        length = participant.length;
        for(int i=0;i<length;i++){
            if(hash.get(participant[i]) != null && hash.get(participant[i])!=0){
                int num = hash.get(participant[i]);
                hash.put(participant[i],num-1);
            }else{
                answer =participant[i];
                break;
            }
        }
        
        
        return answer;
    }

```

### 정리
HashMap에 담는 처음 n번과 확인하는 과정 n-1번의 연산 만에 결과를 얻어낼 수 있다

단순하게 String Equals 버전보다 빠르게 나올 줄 알았으나 이름이 20글자 이내고 input이 크리티컬하지 않았는지 오히려 시간이 더 오래걸렸다.

해싱하는 것 자체도 시간을 잡아먹기에 input의 문자열이 그렇게 길지 않다면 해싱하는 것보다 그냥 문제를 처리하는 것이 더 효율적이다.

