package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Application {
    public static void main(String[] args) {
        playGame();
    }

    private static void playGame(){

        int regame;
        int userNumber;
        int randomNumber;
        String inputString;
        List<Integer> computer = new ArrayList<>();

        while(true){

            while (computer.size() < 3) {
                randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }
            randomNumber = 100*computer.get(0)+10*computer.get(1)+computer.get(2);

            System.out.println("숫자 야구 게임을 시작합니다.");

            while(true){
                System.out.print("숫자를 입력해주세요 : ");
                inputString = Console.readLine();

                if (!inputString.matches("\\d{3}")) {
                    throw new IllegalArgumentException();
                }
                userNumber=Integer.parseInt(inputString);

                if(userNumber==randomNumber){
                    System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
                        + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    break;
                }else{
                    checkNumber(userNumber, computer);
                }
            }
            computer.clear();

            while(true){
                regame= Integer.parseInt(Console.readLine());
                if(regame==2){
                    return;
                }else if(regame==1){
                    break;
                }
                System.out.print("잘못 입력했습니다. 다시 입력해주세요 : ");
            }
        }
    }

    private static void checkNumber(int n, List<Integer> c){
        List<Integer> user= new ArrayList<>();
        user.add(n/100);
        user.add((n%100)/10);
        user.add(n%10);

        int strike=0;
        int ball=0;

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(Objects.equals(user.get(i), c.get(j))){
                    if(i==j) strike++;
                    else ball++;
                }
            }
        }

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
