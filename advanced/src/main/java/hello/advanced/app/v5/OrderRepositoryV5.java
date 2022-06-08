package hello.advanced.app.v5;

import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.callback.TraceTemplate;
import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.templates.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryV5 {

    private final TraceTemplate template;

    public OrderRepositoryV5(LogTrace trace) {
        this.template = new TraceTemplate(trace);
    }

    public void save(String itemId) {
        template.execute(this.getClass().getName(), () -> {
            if (itemId.equals("ex")) {
                throw new IllegalArgumentException("Exception!! ");
            }
            return null;
        });
    }

   /* public void save(TraceId traceId, String itemId) {
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
    }*/

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.getMessage();

        }
    }

}
