package hello.proxy.cglib;

import hello.proxy.cglib.code.TimeMethodInterceptor;
import hello.proxy.common.service.ConctreteService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;
@Slf4j
public class CgLIgTest {

    @Test
    void cglib() {
        ConctreteService target = new ConctreteService();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ConctreteService.class);
        enhancer.setCallback(new TimeMethodInterceptor(target));
        ConctreteService proxy = (ConctreteService) enhancer.create();

        log.info("targetClass = {}", target.getClass());
        log.info("proxyClass ={}", proxy.getClass());

        proxy.call();
    }
}
