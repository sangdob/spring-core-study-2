package hello.proxy.pureproxy.decorater.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DecoratorComponentClient {

    private Component component;

    public DecoratorComponentClient(Component component) {
        this.component = component;
    }

    public void execute() {
        String result = component.operation();

        log.info("result = {} ", result);
    }
}
