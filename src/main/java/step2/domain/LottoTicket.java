package step2.domain;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;

public class LottoTicket {
    private final Set<LottoNumber> lottoTicket;

    public LottoTicket(Set<LottoNumber> lottoTicket) {
        this.lottoTicket = lottoTicket;
    }

    public long matchedWinningNumber(MatchedNumber matchedNumber) {
        return this.lottoTicket.stream()
                .filter(number -> number.matchedWinningNumber(matchedNumber))
                .count();
    }

    public boolean matchedBonusBallNumber(LottoNumber bonusBallNumber) {
        return lottoTicket.contains(bonusBallNumber);
    }

    public Set<LottoNumber> lottoTicket() {
        return Collections.unmodifiableSet(lottoTicket);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(lottoTicket, that.lottoTicket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoTicket);
    }

}