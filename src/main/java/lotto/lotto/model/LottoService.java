package lotto.lotto.model;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class LottoService {

    public void run(){

    }

    public List<Integer> buyLotto(){
        return pickUniqueNumbersInRange(1, 45, 6);
    }

    public Result checkResult(Lotto lotto, List<Integer> inputNumbers, int bonusNumber){
        int count = 0;
        boolean isBonus = false;

        for (Integer inputNumber : inputNumbers) {
            if(lotto.getNumbers().contains(inputNumber)){
                count ++;
            }
        }

        if (count == 5){
            if(lotto.getNumbers().contains(bonusNumber)){
                isBonus = true;
            }
        }
        Result result = Result.valueOfHit(count, isBonus);
        return result;
    }

    public List<Result> totalResult(List<Lotto> lottoList, List<Integer> inputNumbers, int bonusNumber){
        List<Result> results = new ArrayList<>();

        for (Lotto lotto : lottoList) {
            Result result = checkResult(lotto, inputNumbers, bonusNumber);
            results.add(result);
        }

        return results;
    }

    public String getRateOfReturn(int inputMoney, int outputMoney){
        return String.format("%.2f", ((double) outputMoney /inputMoney) * 100);
    }

}
