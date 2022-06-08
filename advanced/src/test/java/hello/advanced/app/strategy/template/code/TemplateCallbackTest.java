package hello.advanced.app.strategy.template.code;

import hello.advanced.app.strategy.template.Callback;
import hello.advanced.app.strategy.template.TimeLogTemplate;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateCallbackTest {

    /**
     * template callback 형식 익명 클래스 전달
     */
    @Test
    void callbackV1() {
        TimeLogTemplate template = new TimeLogTemplate();
        template.execute(new Callback() {
            @Override
            public void call() {
                log.info("비즈니스로직 callback 1");
            }
        });

        TimeLogTemplate template2 = new TimeLogTemplate();
        template2.execute(new Callback() {
            @Override
            public void call() {
                log.info("비즈니스로직 callback 2");
            }
        });
    }

    @Test
    void callbackV2() {
        TimeLogTemplate template = new TimeLogTemplate();
        template.execute(() -> log.info("비즈니스로직 callback 람다 형식 1"));
        template.execute(() -> log.info("비즈니스로직 callback 람다 형식 2"));
    }
}
