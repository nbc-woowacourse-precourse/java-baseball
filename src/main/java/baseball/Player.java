package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Player {
    public List<Integer> makeGuess() throws IllegalArgumentException {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        if (!input.matches("\\d{3}")) {
            throw new IllegalArgumentException("입력 값이 유효하지 않습니다. 정확히 3자리 숫자를 입력해야 합니다.");
        }

        List<Integer> guess = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();

        for (char ch : input.toCharArray()) {
            int num = Character.getNumericValue(ch);
            if (!seen.add(num)) {
                throw new IllegalArgumentException("모든 숫자는 서로 달라야 합니다.");
            }
            guess.add(num);
        }

        return guess;
    }
}
