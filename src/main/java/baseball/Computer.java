package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Computer {
    public List<Integer> generateSecretNumber() {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < 3) {
            int newNumber = Randoms.pickNumberInRange(1, 9);
            numbers.add(newNumber);
        }
        return new ArrayList<>(numbers);
    }
}
