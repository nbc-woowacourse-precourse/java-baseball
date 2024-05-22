package baseball;

import camp.nextstep.edu.missionutils.Console;

class Screen {

    void displayStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    void displayWinMessage() {
        System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    void displayResult(String message) {
        System.out.println(message);
    }

    void displayErrorAndExit() {
        System.out.println("입력 값이 유효하지 않습니다. 게임을 종료합니다.");
    }

    void displayError(String message) {
        System.out.println(message);
    }

    boolean askForNewGame() {
        while (true) {
            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
            String response = Console.readLine();
            if ("1".equals(response)) {
                return true;
            }
            if ("2".equals(response)) {
                return false;
            }
            System.out.println("잘못된 입력입니다. 1 또는 2를 입력해주세요.");
        }
    }
}
