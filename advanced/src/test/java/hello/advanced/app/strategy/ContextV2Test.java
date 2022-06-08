package hello.advanced.app.strategy;

import hello.advanced.app.strategy.code.strategy.ContextV2;
import hello.advanced.app.strategy.code.strategy.Strategy;
import hello.advanced.app.strategy.code.strategy.StrategyLogic1;
import hello.advanced.app.strategy.code.strategy.StrategyLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV2Test {

    @Test
    void strategyV1() {
        ContextV2 contextV2 = new ContextV2();
        contextV2.execute(new StrategyLogic1());
        contextV2.execute(new StrategyLogic2());
    }

    @Test
    void strategyV2() {
        ContextV2 contextV2 = new ContextV2();
        contextV2.execute(new Strategy() {
            @Override
            public void call() {
                log.info("익명 클래스 strategy 1");
            }
        });
        contextV2.execute(new Strategy() {
            @Override
            public void call() {
                log.info("익명 클래스 strategy 2");
            }
        });
    }

    @Test
    void strategyV3() {
        ContextV2 contextV2 = new ContextV2();
        contextV2.execute(() -> log.info("람다 형식 strategy 1"));
        contextV2.execute(() -> log.info("람다 형식 strategy 2 "));
    }
}
