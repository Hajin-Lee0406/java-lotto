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
        System.out.println();
        System.out.println("구입금액을 입력해 주세요.");

        return Integer.parseInt(Console.readLine());
    }

    public List<Integer> getInputNumbers(){
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");

        return stringToIntegerList(Console.readLine());
    }

    public Integer getInputBonusNumber(){
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");

        return Integer.parseInt(Console.readLine());
    }

    private List<Integer> stringToIntegerList(String string){
        List<Integer> inputList = new ArrayList<>();

        String[] result = string.split(",");

        for (String s : result) {
            inputList.add(Integer.parseInt(s));
        }

        return inputList;
    }
}
