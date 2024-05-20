package baseball.model;

import baseball.constant.Message;
import baseball.io.OutPut;
import baseball.io.Scanner;
import baseball.service.BaseballService;
import java.util.List;

public class Player {
    // Todo : Player..? 레이어 분리를 다시 생각해 볼 것
    private Referee referee;
    private Computer computer;
    private BaseballService service;
    private Scanner scanner;
    private OutPut outPut;

    public void startGame() {
        outPut.startMsg();

        List<Integer> computerNumbers = computer.generateRandomNumber();
        // Todo : While 문 안의 if 문을 분리해 볼 것
        while (true) {
            String input = scanner.getPlayerNumbers();
            List<Integer> playerNumbers = service.convertInputToNumber(input);
            int strike = referee.getBallAndStrikeCount(computerNumbers, playerNumbers);

            if (!service.validateInput(input)) {
                throw new IllegalArgumentException(String.valueOf(Message.ERROR));
            }

            if (referee.validateThreeStrike(strike, computerNumbers)) {
                break;
            }
        }
    }
}
