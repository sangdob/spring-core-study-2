package hello.advanced.app.v1;

import hello.advanced.app.trace.TraceStatus;
import hello.advanced.app.trace.hellotrace.HelloTraceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV1 {
    private final OrderServiceV1 orderServiceV1;
    private final HelloTraceV1 trace;

    @GetMapping("/v1/request")
    public String request(String itemId) {

        TraceStatus traceStatus = null;

        try {
            traceStatus = trace.begin(itemId);
            orderServiceV1.orderItem(itemId);
            trace.end(traceStatus);

            return "ok";
        } catch (Exception e) {
            trace.exception(traceStatus, e);
            throw e;
        }


    }
}
