package hello.advanced.app.trace.hellotrace;

import hello.advanced.app.trace.TraceStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloTraceV2Test {

    @Test
    void begin_end() {
        HelloTraceV2 trace = new HelloTraceV2();
        TraceStatus status = trace.begin("hello");
        TraceStatus status1 = trace.beginSync(status.getTraceId(), "next Trace");

        trace.end(status1);
        trace.end(status);
    }

    @Test
    void begin_exception() {
        HelloTraceV2 trace = new HelloTraceV2();
        TraceStatus status = trace.begin("hello");
        TraceStatus status1 = trace.beginSync(status.getTraceId(), "next Trace");
        trace.exception(status1, new IllegalStateException());
        trace.exception(status, new IllegalStateException());
    }
}