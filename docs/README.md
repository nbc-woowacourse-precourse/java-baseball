## 🛠️️ 기능 목록
- ### **컴퓨터**
  - 게임 시작 문구 출력
    ```
    숫자 야구 게임을 시작합니다.
    ``` 
  - 1부터 9까지 서로 다른 3자리 숫자 선택 (Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.)
    #### 사용 예시
    
    ```java
    List<Integer> computer = new ArrayList<>();
    while (computer.size() < 3) {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber);
        }
    }
    ```
  - 사용자가 입력한 숫자에 대한 결과 출력
    ```
    - 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 낫싱이란 힌트를 얻는다.
    - 예) 상대방(컴퓨터)의 수가 425일 때
        - 123을 제시한 경우 : 1스트라이크
        - 456을 제시한 경우 : 1볼 1스트라이크
        - 789를 제시한 경우 : 낫싱
      ```
  - 사용자가 숫자를 맞춘 경우 게임 종료 문구 출력
    ```
    3개의 숫자를 모두 맞히셨습니다! 게임 종료
    ``` 
  - 게임이 끝난 경우, 재시작/종료 출력
    ```
    게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
    ```
  - 사용자의 입력이 잘못되었을 경우 `IllegalArgumentException` 을 발생시킨 후 애플리케이션을 종료
    ```
    잘못 입력하셨습니다. 게임을 종료합니다.
    ```

---
- ### **사용자**
  - 서로 다른 3자리 숫자 입력(사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.)
    ```
    숫자를 입력해주세요 : 123
    ```
     
  - 게임이 끝난 경우 재시작/종료 입력
     ```
    게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
    1
    ```

