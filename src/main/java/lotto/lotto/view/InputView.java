package lotto.lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final InputView instance = new InputView();

    public static InputView getInstance() {
        return instance;
    }

    private InputView() {
    }

    public String getPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }
}