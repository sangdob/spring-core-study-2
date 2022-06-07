package hello.advanced.app.v4.v3;

import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.templates.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV4 {

    private final LogTrace trace;

    public void save(String itemId) {
        AbstractTemplate<Void> template = new AbstractTemplate<>(trace) {
            @Override
            protected Void call() {
                if (itemId.equals("ex")) {
                    throw new IllegalArgumentException("Exception!! ");
                }
                sleep(100);
                return null;
            }
        };
        template.execute(this.getClass().getName());
    }

    public void save(TraceId traceId, String itemId) {
        TraceStatus status = null;
        try {
            status = trace.begin(this.getClass().getName());
            if (itemId.equals("ex")) {
                throw new IllegalArgumentException("Exception!! ");
            }
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.getMessage();

        }
    }

}
