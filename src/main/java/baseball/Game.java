package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game{
    private Computer computer;
    private User user;
    private CheckBall checkBall;

    public Game() {
        computer = new Computer();
        user = new User();
        checkBall = new CheckBall();
    }

    public void start() {

        System.out.println("숫자 야구 게임을 시작합니다.");

        while(true){
            computer.createRandomNumber();
            while(true){
                user.inputNumber();
                if(checkBall.checkNumber(user, computer)) break;
            }
            if(!isRegame()) break;
        }
    }

    private boolean isRegame(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        while(true) {
            int regame = Integer.parseInt(Console.readLine());
            if (regame == 2) {
                return false;
            }else if(regame == 1) {
                return true;
            }
            System.out.println("잘못 입력했습니다. 다시 입력해주세요 : ");
        }
    }
}
