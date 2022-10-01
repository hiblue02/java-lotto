package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.LottoResult;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String FORMAT_RESULT = "%d개 일치 (%d원) - %d개%n";
    private static final String FORMAT_RESULT_EARNING_RATE = "총 수익률은 %.2f입니다.";
    private static final String FORMAT_COUNT = "%d개를 구매했습니다.%n";
    private static final String HORIZON = "-".repeat(20);


    private OutputView(){

    }

    public static void printCount(int lottoCount) {
        System.out.printf(FORMAT_COUNT,lottoCount);
    }

    public static void printLottoGame(LottoGame lottoGame) {

        List<Lotto> lottos = lottoGame.getValue();

        for (Lotto lotto : lottos) {
            String collect = lotto.getValue().stream().map(String::valueOf).collect(Collectors.joining(","));
            System.out.println("["+collect+"]");
        }
    }

    public static void printResult(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println(HORIZON);
        System.out.printf(FORMAT_RESULT, LottoResult.FOURTH, LottoResult.FOURTH_PRIZE, lottoResult.getFourthCount());
        System.out.printf(FORMAT_RESULT, LottoResult.THIRD, LottoResult.THIRD_PRIZE, lottoResult.getThirdCount());
        System.out.printf(FORMAT_RESULT, LottoResult.SECOND, LottoResult.SECOND_PRIZE, lottoResult.getSecondCount());
        System.out.printf(FORMAT_RESULT, LottoResult.FIRST, LottoResult.FIRST_PRIZE, lottoResult.getFirstCount());
        System.out.printf(FORMAT_RESULT_EARNING_RATE, lottoResult.getEarningRate());
    }
}