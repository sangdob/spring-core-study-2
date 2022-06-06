package hello.advanced.app.threadlocal.code;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class FieldService {

    private String nameStore;

    private FieldService fieldService = new FieldService();

    public String logic(String name) {
        log.info("save name => {} nameStore =>", name, nameStore);

        nameStore = name;
        sleep(100);
        log.info("search nameStore => {}",nameStore);
        return nameStore;
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
