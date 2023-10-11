package lotto.lotto.model;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Result {
    FIRST(6, 2000000000, "6개 일치 (2,000,000,000원) - "),
    SECOND(5,30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(5, 1500000, "5개 일치 (1,500,000원) - "),
    FOURTH(4, 50000, "4개 일치 (50,000원) - "),
    FIFTH(3, 5000, "3개 일치 (5,000원) - ");

    private final int hit;
    private final int account;

    private final String comment;

    Result(int hit, int account, String comment) {
        this.hit = hit;
        this.account = account;
        this.comment = comment;
    }

    public int getHit() {
        return hit;
    }

    public int getAccount() {
        return account;
    }

    public String getComment() {
        return comment;
    }

    private static final Map<Integer, Result> BY_HIT =
            Stream.of(values()).collect(Collectors.toMap(Result::getHit, e -> e, (SECOND, THIRD) -> THIRD));

    public static Result valueOfHit(int hit, boolean isBonus) {
        if(isBonus) return SECOND;
        return BY_HIT.get(hit);
    }
}
