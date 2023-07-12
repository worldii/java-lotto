package lotto.model;

public class LottoMoney {
    public static final int LOTTO_UNIT = 1000;
    public static final int ZERO = 0;
    private final int money;

    public LottoMoney(final int money) {
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(final int money) {
        if (money < ZERO) {
            throw new IllegalStateException("로또 머니가 양수여야 합니다.");
        }
        if (money % LOTTO_UNIT != 0) {
            throw new IllegalStateException("로또는 천원 단위입니다.");
        }
    }

    public int getLottoCount() {
        return money / LOTTO_UNIT;
    }

    public int getLottoMoney() {
        return money;
    }
}
