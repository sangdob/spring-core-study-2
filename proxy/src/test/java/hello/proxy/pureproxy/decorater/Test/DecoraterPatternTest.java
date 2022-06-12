package hello.proxy.pureproxy.decorater.Test;

import hello.proxy.pureproxy.decorater.code.Component;
import hello.proxy.pureproxy.decorater.code.DecoratorComponent;
import hello.proxy.pureproxy.decorater.code.RealComponent;
import org.junit.jupiter.api.Test;

public class DecoraterPatternTest {

    @Test
    void noDecorator() {
        Component realComponent = new RealComponent();
        DecoratorComponent client = new DecoratorComponent(realComponent);

        client.execute();

    }
}
