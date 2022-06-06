package hello.advanced.app.v3;

import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTraceV2;
import hello.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV3 {

    private final LogTrace trace;

    public void save(String itemId) {
        TraceStatus status = null;
        try {
            status = trace.begin(itemId);

            if (itemId.equals("ex")) {
                throw new IllegalArgumentException("Exception!! ");
            }
            sleep(100);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }

    }

    public void save(TraceId traceId, String itemId) {
        TraceStatus status = null;
        try {
            status = trace.begin(this.getClass().getName().toString());
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
