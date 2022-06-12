package hello.proxy.pureproxy.decorater.Test;

import hello.proxy.pureproxy.decorater.code.*;
import org.junit.jupiter.api.Test;

public class DecoraterPatternTest {

    @Test
    void noDecorator() {
        Component realComponent = new RealComponent();
        DecoratorComponentClient client = new DecoratorComponentClient(realComponent);

        client.execute();

    }

    @Test
    void decorator1() {
        Component component = new RealComponent();
        Component messageDecorator = new MessageDecorator(component);
        DecoratorComponentClient client = new DecoratorComponentClient(messageDecorator);

        client.execute();
    }

    @Test
    void decorator2() {
        Component component = new RealComponent();
        Component messageDecorator = new MessageDecorator(component);
        Component timeDecorator = new TimeComponent(messageDecorator);
        DecoratorComponentClient client = new DecoratorComponentClient(timeDecorator);

        client.execute();
    }
}
