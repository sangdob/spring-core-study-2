package hello.advanced.app.hellotrace;

import hello.advanced.app.trace.TraceId;
import hello.advanced.app.trace.TraceStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class HelloTraceV1 {

    public TraceStatus begin(String message) {
        TraceId traceId = new TraceId();
        Long startTimeMs = System.currentTimeMillis();

        return new TraceStatus(traceId, startTimeMs, message);
    }

    public void end(TraceStatus traceStatus) {

    }

    public void exception(TraceStatus traceStatus, Exception e) {

    }
}
