package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Integer> number;

    public User(){
        number = new ArrayList<>();
    }

    public void inputNumber(){
        System.out.println("숫자를 입력해주세요 : ");
        String inputString = Console.readLine();
        if(!inputString.matches("\\d{3}")){
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        int userNumber = Integer.parseInt(inputString);
        number.clear();
        number.add(userNumber/100);
        number.add((userNumber%100)/10);
        number.add(userNumber%10);
    }

    public List<Integer> getUserNumber() {
        return number;
    }
}
