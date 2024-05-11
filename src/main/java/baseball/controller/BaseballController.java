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
        int key = 0;
        String restartKey = "";
        boolean answerCheck;
        do {
            String answerNumber = service.makeAnswerNumber();
            output.startGame();
            do {
                String inputNumber = input.input();
                answerCheck = service.checkNumber(inputNumber, answerNumber);
            } while (answerCheck);
            output.restartGame();
            restartKey = input.input();
            key = checkRestartKey(restartKey);
        } while (key != SHUTDOWNKEY);
    }

    private void init() {
        input = new Input();
        output = new Output();
        service = new BaseballService();
        baseballException = new BaseballException();
    }

    private int checkRestartKey(
            final String restartKey
    ) {
        baseballException.checkRestartKey(restartKey);
        return Integer.parseInt(restartKey);
    }
}
