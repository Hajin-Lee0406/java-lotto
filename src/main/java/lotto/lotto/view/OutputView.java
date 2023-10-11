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
        System.out.println(total + "개를 구매했습니다.");
    }

    public void printresult(){
        System.out.println("당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - ");
        System.out.println("4개 일치 (50,000원) - ");
        System.out.println("5개 일치 (1,500,000원) - ");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - ");
        System.out.println("6개 일치 (2,000,000,000원) - ");
        //System.out.println("총 수익률은 " + + "%입니다.");
    }
}
