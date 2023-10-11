package lotto.lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final InputView instance = new InputView();

    public static InputView getInstance() {
        return instance;
    }

    private InputView() {
    }

    public Integer getPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    public List<Integer> getInputGoalNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");

        List<Integer> inputList = new ArrayList<>();

        String[] result = Console.readLine().split(",");

        for (int i = 0; i < result.length; i++) {
            inputList.add(Integer.parseInt(result[i]));
        }

        return inputList;

    }

    public Integer getInputBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }
}
