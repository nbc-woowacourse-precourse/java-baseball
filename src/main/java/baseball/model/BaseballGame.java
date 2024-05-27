package baseball.model;

import static baseball.constant.Number.THREE_STRIKE;

import baseball.presentation.OutPut;
import baseball.presentation.Scanner;
import baseball.service.BaseballService;
import java.util.List;

public class BaseballGame {

    private final Computer computer = new Computer();
    private final BaseballService service = new BaseballService();
    private final Scanner scanner = new Scanner();
    private final OutPut outPut = new OutPut();

    public void start() {
        outPut.startMsg();
        List<Integer> computerNumbers = computer.generateRandomNumber();
        boolean gameEnded = false;

        while (!gameEnded) {
            outPut.inputMsg();
            String input = scanner.getPlayerNumbers();

            service.getInput(input);
            int strike = service.getStrike(input, computerNumbers);

            if (strike == THREE_STRIKE.getNumber()) {
                computerNumbers.clear();
                computerNumbers = computer.generateRandomNumber();

                outPut.wonTheGame();
                gameEnded = scanner.restartOrTerminateGame();
            }
        }
    }
}
