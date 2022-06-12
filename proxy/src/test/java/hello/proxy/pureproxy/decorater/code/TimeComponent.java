package hello.proxy.pureproxy.decorater.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeComponent implements Component {

    private Component component;

    public TimeComponent(Component component) {
        this.component = component;
    }

    @Override
    public String operation() {
        log.info("timeDecorator Start ");
        long startTime = System.currentTimeMillis();
        String operation = component.operation();
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;

        log.info("timeDecorator end | resultTime = {}",resultTime);
        return operation;
    }
}
