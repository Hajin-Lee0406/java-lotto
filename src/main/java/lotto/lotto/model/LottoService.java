package lotto.lotto.model;

import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class LottoService {

    public void run(){

    }

    public List<Integer> buyLotto(){
        return pickUniqueNumbersInRange(1, 45, 6);
    }

}
