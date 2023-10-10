package lotto.lotto.controller;

import lotto.lotto.model.LottoService;
import lotto.lotto.view.InputView;
import lotto.lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {

    private final LottoService lottoService;
    private final OutputView outputView;
    private final InputView inputView;

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

        for(int i =0; i<total; i++){
            outputView.printBuyLotto(lottoService.buyLotto());
        }
    }
}
