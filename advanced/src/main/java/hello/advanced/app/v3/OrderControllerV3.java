package hello.advanced.app.v3;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTraceV2;
import hello.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV3 {
    private final OrderServiceV3 orderServiceV3;

    @Autowired
    private final LogTrace trace;

    @GetMapping("/v2/request")
    public String request(String itemId) {

        TraceStatus traceStatus = null;

        try {
            traceStatus = trace.begin(this.getClass().getName().toString());
            orderServiceV3.orderItem(traceStatus.getTraceId(), itemId);
            trace.end(traceStatus);

            return "ok";
        } catch (Exception e) {
            trace.exception(traceStatus, e);
            throw e;
        }
    }
}
