# 7월 1주차 과제 풀이

## Programmers_방금그곡

### Idea
#### - C#, D#, F#, G#, A#을 숫자 1,2,3,4,5로 치환.
#### - 시작 시간과 끝시간을 비교해서 전체 재생 시간을 구함.
#### - 음 이름을 mod를 이용해서 전체 재생 시간만큼 늘려줌. => sb.append(arr[j % arr.length]);
#### - m이 포함되어 있으면 answer에 저장.
#### - 끝까지 돌려보고 또 나오면 재생시간이 긴 것으로 바꿈, 재생 시간도 같다면 먼저 나옴 노래 이름 유지.

### 핵심 부분 구현
#### - C#, D#, F#, G#, A# 치환 부분<br>
![image](https://user-images.githubusercontent.com/48550373/124388435-e9215d00-dd1d-11eb-9327-da451aacdbd3.png)

#### 전체 노래를 구하고 answer 구하는 과정<br>
![image](https://user-images.githubusercontent.com/48550373/124388474-0f46fd00-dd1e-11eb-9b87-a05abbc9a385.png)


