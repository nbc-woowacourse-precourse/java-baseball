package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> number;

    public Computer() {
        number = new ArrayList<>();
    }

    public void createRandomNumber() {
        number.clear();
        while(number.size()<3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!number.contains(randomNumber)){
                number.add(randomNumber);
            }
        }
    }

    public List<Integer> getRandomNumber() {
        return number;
    }
}
