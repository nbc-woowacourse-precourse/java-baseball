package baseball.model;

import static baseball.constant.Number.THREE_STRIKE;

import baseball.presentation.OutPut;
import baseball.presentation.Scanner;
import baseball.service.BaseballService;
import java.util.List;

public class BaseballGame {

    Computer computer = new Computer();
    BaseballService service = new BaseballService();
    Scanner scanner = new Scanner();
    OutPut outPut = new OutPut();

    public void start() {
        outPut.startMsg();
        List<Integer> computerNumbers = computer.generateRandomNumber();

        while (true) {
            outPut.inputMsg();
            String input = scanner.getPlayerNumbers();
            service.getInput(input);
            int strike = service.getStrike(input, computerNumbers);

            if (strike == THREE_STRIKE.getNumber()) {
                computerNumbers.clear();
                computerNumbers = computer.generateRandomNumber();
                outPut.wonTheGame();

                if (scanner.restartOrTerminateGame()) {
                    break;
                }
            }
        }
    }
}
