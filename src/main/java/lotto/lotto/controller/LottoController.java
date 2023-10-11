package lotto.lotto.controller;

import lotto.lotto.model.Lotto;
import lotto.lotto.model.LottoService;
import lotto.lotto.model.Grade;
import lotto.lotto.view.InputView;
import lotto.lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public void run() {
        startLotto();
    }

    private void startLotto() {
        Integer inputMoney = inputView.getPurchaseAmount();

        if (inputMoney % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력하세요.");
        }

        int total = inputMoney / 1000;
        buyLottoList(total);

        List<Integer> inputNumbers = inputView.getInputNumbers();
        int bonusNumber = inputView.getInputBonusNumber();

        String rateOfReturn = lottoService.getRateOfReturn(inputMoney, checkResult(lottoList, inputNumbers, bonusNumber));
        outputView.printRateOfReturn(rateOfReturn);
    }

    // 로또 구매
    private void buyLottoList(int total) {
        for (int i = 0; i < total; i++) {
            List<Integer> numbers = lottoService.buyLotto();
            lottoList.add(new Lotto(numbers));
        }

        outputView.printBuyLottoCount(total, lottoList);
    }

    // 당첨 확인
    private int checkResult(List<Lotto> lottoList, List<Integer> inputNumbers, int bonusNumber) {
        List<Grade> test = lottoService.totalResult(lottoList, inputNumbers, bonusNumber);
        int outputMoney = 0;

        for (Grade value : Grade.values()) {
            int count = Collections.frequency(test, value);
            outputMoney += count * value.getAccount();
            outputView.printGradeResult(value.getComment(), count);
        }

        return outputMoney;
    }

}
