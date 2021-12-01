package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumbersTest {
    @Test
    @DisplayName("LottoNumbers 생성자 테스트")
    void constructor() {
        assertThat(new LottoNumbers(IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList())))
                .isEqualTo(new LottoNumbers(IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList())));
    }

    @Test
    @DisplayName("지난 주 당첨 번호는 6개만 입력 받는다.")
    void validateLottoNumbersLength() {
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        assertThatThrownBy(() -> {
            lottoNumbers.validateLottoNumbersLength();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("지난 주 당첨 번호는 6개만 입력할 수 있습니다.");
    }

    @Test
    @DisplayName("지난 주 당첨 번호는 1~45의 값을 가진다.")
    void validateLottoNumbersOneToFortyfive() {
        assertThatThrownBy(() -> {
            new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 46));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("동일한 번호를 입력할 수 없다.")
    void validateSameLottoNumbers() {
        assertThatThrownBy(() -> {
            new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 5));
        }).isInstanceOf(IllegalArgumentException.class);
    }
}