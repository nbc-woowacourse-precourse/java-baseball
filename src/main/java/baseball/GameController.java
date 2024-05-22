package baseball;

import java.util.List;

public class GameController {
    private final Computer computer = new Computer();
    private final Player player = new Player();
    private final Referee referee = new Referee();
    private final Screen screen = new Screen();

    public void startGame() {
        screen.displayStartMessage();
        while (true) {
            List<Integer> secretNumber = computer.generateSecretNumber();
            if (!playRound(secretNumber)) break;
        }
    }

    public boolean playRound(List<Integer> secretNumber) {
        while (true) {
            List<Integer> guess = player.makeGuess(screen);
            int strikes = referee.countStrikes(secretNumber, guess);
            int balls = referee.countBalls(secretNumber, guess);

            if (strikes == 3) {
                screen.displayWinMessage();
                return screen.askForNewGame();
            }

            screen.displayResult(Referee.getResultMessage(balls, strikes));
        }
    }
}
