package baseball.controller;
import baseball.exception.BaseballException;
import baseball.service.BaseballService;
import baseball.io.Input;
import baseball.io.Output;

public class BaseballController {

    private Input input;
    private Output output;
    private BaseballService service;
    private BaseballException baseballException;
    private final int SHUTDOWNKEY = 2;

    public void start(){
        init();
        String answerNumber = service.makeAnswerNumber();
        int endKey = 0;
        String restartKey = "";
        output.startGame();
        do{
            String inputNumber = input.input();
            if(service.checkNumber(inputNumber, answerNumber)){
                output.restartGame();
                restartKey = input.input();
                endKey = checkRestartKey(restartKey);
            };

        }while(endKey != SHUTDOWNKEY);
    }

    private void init(){
        input = new Input();
        output = new Output();
        service = new BaseballService();
        baseballException = new BaseballException();
    }

    private int checkRestartKey(
            final String restartKey
    ){
        baseballException.checkRestartKey(restartKey);
        return Integer.parseInt(restartKey);
    }
}
