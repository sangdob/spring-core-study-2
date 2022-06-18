package hello.proxy.jdkdynamic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Slf4j
public class ReflectionTest {

    @Test
    void reflection() {
        Hello target = new Hello();

        log.info("start");
        String result = target.callA();
        log.info("result = {}", result);

        log.info("start");
        String result2 = target.callB();
        log.info("result = {}", result2);

    }

//    error 발생시 리플렉션은 런타임오류
    @Test
    void reflection2() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class classHello = Class.forName("hello.proxy.jdkdynamic.ReflectionTest$Hello");
        Hello target = new Hello();

        Method callA = classHello.getMethod("callA");
        dynamicCall(callA, target);
        Method callB = classHello.getMethod("callB");
        dynamicCall(callB, target);
    }

    private void dynamicCall(Method method, Object target) throws InvocationTargetException, IllegalAccessException {
        log.info("start");
        Object result = method.invoke(target);
        log.info("result = {}", result);
    }

    @Slf4j
    static class Hello {

        public String callA() {
            log.info("callA");
            return "callA";
        }

        public String callB() {
            log.info("callB");
            return "callB";
        }
    }
}
