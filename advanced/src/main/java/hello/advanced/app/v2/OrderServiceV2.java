package hello.advanced.app.v2;

import hello.advanced.app.trace.TraceId;
import hello.advanced.app.trace.TraceStatus;
import hello.advanced.app.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV2 {

    private final OrderRepositoryV2 orderRepositoryV2;
    private final HelloTraceV2 trace;

    public void orderItem(String itemId) {
        TraceStatus status = null;
        try {
            status = trace.begin(itemId);
            orderRepositoryV2.save(itemId);
            trace.end(status);
            sleep(100);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }

    public void orderItem(TraceId traceId, String itemId) {
        TraceStatus status = null;
        try {
            status = trace.beginSync(traceId, this.getClass().getName().toString());
            orderRepositoryV2.save(traceId, itemId);
            trace.end(status);
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

