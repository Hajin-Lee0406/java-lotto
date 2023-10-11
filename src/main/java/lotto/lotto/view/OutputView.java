package lotto.lotto.view;

import java.util.List;

public class OutputView {
    private static final OutputView instance = new OutputView();

    public static OutputView getInstance() {
        return instance;
    }

    private OutputView() {
    }

    public void printBuyLotto(List<Integer> buyLotto){
        System.out.println(buyLotto);
    }

    public void printBuyLottoCount(int total){
        System.out.println();
        System.out.println(total + "개를 구매했습니다.");
    }

}
