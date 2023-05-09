package step2.domain;

import java.util.List;

@FunctionalInterface
public interface LottoGenerateStrategy {
    List<List<Integer>> generate();
}