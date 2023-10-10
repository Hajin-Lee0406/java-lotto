package lotto;

import lotto.lotto.controller.LottoController;
import lotto.lotto.model.LottoService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController lottoController = new LottoController();
        lottoController.run();
    }
}
