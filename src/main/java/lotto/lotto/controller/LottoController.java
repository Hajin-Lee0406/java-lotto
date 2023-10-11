package lotto.lotto.controller;

import lotto.lotto.model.Lotto;
import lotto.lotto.model.LottoService;
import lotto.lotto.view.InputView;
import lotto.lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoController {

    private final LottoService lottoService;
    private final OutputView outputView;
    private final InputView inputView;
    private List<Lotto> lottoList = new ArrayList<>();

    public LottoController() {
        lottoService = new LottoService();
        outputView = OutputView.getInstance();
        inputView = InputView.getInstance();
    }

    public void run(){
        startLotto();
    }

    private void startLotto(){
        String purchaseAmount = inputView.getPurchaseAmount();

        if (Integer.parseInt(purchaseAmount) % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력하세요.");
        }

        int total = Integer.parseInt(purchaseAmount) / 1000;
        outputView.printBuyLottoCount(total);

        buyLottoList(total);
    }

    // 로또 구매
    private void buyLottoList(int total){
        for (int i = 0; i < total; i++) {
            List<Integer> numbers = lottoService.buyLotto();
            lottoList.add(new Lotto(numbers));
            System.out.println(numbers);
        }
    }

}
