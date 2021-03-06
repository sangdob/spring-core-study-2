package hello.advanced.app.strategy;

import hello.advanced.app.strategy.code.strategy.ContextV1;
import hello.advanced.app.strategy.code.strategy.Strategy;
import hello.advanced.app.strategy.code.strategy.StrategyLogic1;
import hello.advanced.app.strategy.code.strategy.StrategyLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV1Test {

    /**
    * 전략패턴 시작
    * */
    @Test
    void strategyV0() {
        logic1();
        logic2();
    }

    private void logic1() {
        long startTime = System.currentTimeMillis();

        //변하는 부분
        log.info("비즈니스 로직 1 실행 ");

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime = {}", resultTime);
    }

    private void logic2() {
        long startTime = System.currentTimeMillis();

        //변하는 부분
        log.info("비즈니스 로직 2 실행 ");

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime = {}", resultTime);
    }

    /**
     * 전략 패턴 사용
     */
    @Test
    void strategyV1() {
        StrategyLogic1 strategyLogic1 =new StrategyLogic1();
        ContextV1 contextV1 = new ContextV1(strategyLogic1);
        contextV1.execute();

        StrategyLogic2 strategyLogic2 =new StrategyLogic2();
        ContextV1 contextV2 = new ContextV1(strategyLogic2);
        contextV2.execute();
    }

    @Test
    void strategyV2() {
        Strategy strategy = new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스로직 인라인 호출 ");
            }
        };
        ContextV1 contextV1 = new ContextV1(strategy);
        contextV1.execute();
    }

    @Test
    void strategyV3() {
        ContextV1 contextV1 = new ContextV1(new Strategy() {
            @Override
            public void call() {
                log.info("익명클래스 호출 ");
            }
        });
        contextV1.execute();

        ContextV1 contextV2 = new ContextV1(new Strategy() {
            @Override
            public void call() {
                log.info("익명클래스 호출 ");
            }
        });
        contextV2.execute();
    }

    @Test
    void strategyV4() {
        ContextV1 contextV1 = new ContextV1(() -> log.info("익명클래스1 호출 "));
        contextV1.execute();

        ContextV1 contextV2 = new ContextV1(() -> log.info("익명클래스2 호출 "));
        contextV2.execute();
    }
}
