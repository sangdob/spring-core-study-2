package hello.proxy.common.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConctreteService {
    public void call() {
        log.info("ConcreteService call");
    }
}
