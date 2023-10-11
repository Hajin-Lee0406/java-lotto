package lotto.lotto.controller;

import lotto.lotto.model.Lotto;
import lotto.lotto.model.LottoService;
import lotto.lotto.model.Result;
import lotto.lotto.view.InputView;
import lotto.lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
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
        Integer purchaseAmount = inputView.getPurchaseAmount();

        if (purchaseAmount % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력하세요.");
        }

        int total = purchaseAmount / 1000;
        outputView.printBuyLottoCount(total);

        buyLottoList(total);
        List<Integer> inputNumbers = inputView.getInputGoalNumber();
        int bonusNumber = inputView.getInputBonusNumber();
        //checkResult(lottoList, inputNumbers, bonusNumber);
        //outputView.printresult();

        String rateOfReturn = lottoService.getRateOfReturn(purchaseAmount, checkResult(lottoList, inputNumbers, bonusNumber));
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }

    // 로또 구매
    private void buyLottoList(int total){
        for (int i = 0; i < total; i++) {
            List<Integer> numbers = lottoService.buyLotto();
            lottoList.add(new Lotto(numbers));
            System.out.println(numbers);
        }
    }

    // 당첨 확인
    private int checkResult(List<Lotto> lottoList, List<Integer> inputNumbers, int bonusNumber){
        List<Result> test = lottoService.totalResult(lottoList, inputNumbers, bonusNumber);
        int outputMoney = 0;

        for (Result value : Result.values()) {
            int count = Collections.frequency(test, value);
            outputMoney = outputMoney + count*value.getAccount();
            System.out.println(value.getComment() + count + "개");
        }

        return outputMoney;
    }

}
