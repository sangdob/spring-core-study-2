package hello.advanced.app.strategy.code.strategy;

import lombok.extern.slf4j.Slf4j;

/**
 * 전략 패턴 - 파라미터 전달 방식 테스트
 */
@Slf4j
public class ContextV2 {

    public void execute(Strategy strategy) {
        long startTime = System.currentTimeMillis();

        //bussiness logic call
        strategy.call();

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime = {}", resultTime);
    }
}
