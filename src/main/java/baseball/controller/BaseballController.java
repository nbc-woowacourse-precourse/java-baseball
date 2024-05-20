package baseball.controller;

import baseball.exception.BaseballException;
import baseball.io.Input;
import baseball.io.Output;
import baseball.service.BaseballService;

public class BaseballController {
    private final int SHUTDOWNKEY = 2;
    private Input input;
    private Output output;
    private BaseballService service;
    private BaseballException baseballException;

    public void start() {
        init();
        playGame();
    }

    private void init() {
        input = new Input();
        output = new Output();
        service = new BaseballService();
        baseballException = new BaseballException();
    }

    private void playGame() {
        int key;
        String restartKey;
        do {
            String answerNumber = service.makeAnswerNumber();
            output.startGame();
            execBaseballLogic(answerNumber);
            output.restartGame();
            restartKey = input.inputNumber();
            key = checkRestartKey(restartKey);
        } while (key != SHUTDOWNKEY);
    }

    private void execBaseballLogic(
            final String answerNumber
    ) {
        boolean answerCheck;
        do {
            String inputNumber = input.inputNumber();
            answerCheck = service.checkNumber(inputNumber, answerNumber);
        } while (answerCheck);
    }

    private int checkRestartKey(
            final String restartKey
    ) {
        baseballException.checkRestartKey(restartKey);
        return Integer.parseInt(restartKey);
    }
}
