package baseball;

import java.util.List;
import java.util.Objects;

public class CheckBall {

    boolean checkNumber(User user, Computer computer){
        List<Integer> userNumber= user.getUserNumber();
        List<Integer> computerNumber = computer.getRandomNumber();

        int strike=0;
        int ball=0;

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(Objects.equals(userNumber.get(i),computerNumber.get(j))){
                    if(i==j) strike++;
                    else ball++;
                }
            }
        }

        if (strike == 3) {
            System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        } else {
            printResult(strike, ball);
            return false;
        }
    }

    private void printResult(int strike, int ball){
        if(strike>0&&ball>0){
            System.out.println(ball+"볼 "+strike+"스트라이크");
        }else if(strike>0){
            System.out.println(strike+"스트라이크");
        }else if(ball>0){
            System.out.println(ball+"볼");
        }else{
            System.out.println("낫싱");
        }
    }
}
