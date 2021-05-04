5월 2주차 문제 풀이

1. 프로그래머스 [1차] 비밀 지도

Idea
- 입력으로 주어지는 int 배열의 각각의 값을 2진수로 바꾸는 함수를 통해 각각의 배열의 map1, 2라는 이차원 배열에 저장
- 2진수로 바꿔주는 함수는 StringBuilder를 return 해주고 이를 각각의 배열에 저장
- map1, map2 이차원 배열에 저장된 값이 둘 중 하나라도 1이면 벽이니까 #을 StringBuilder에 저장하고 둘 다 0이면 " "공백을 저장
- i 행을 다 탐색하면 만들어진 문자열을 answer[i]에 저장


main 메소드<br>
 ![image](https://user-images.githubusercontent.com/48550373/117010534-db545900-ad27-11eb-9298-8ae43e079a84.png)
 
jinsu 메소드<br>
 ![image](https://user-images.githubusercontent.com/48550373/117010583-e60eee00-ad27-11eb-80a5-45429cacb035.png)
