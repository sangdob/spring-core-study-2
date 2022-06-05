package hello.advanced.app.trace;

import java.util.UUID;

public class TraceId {

    private String id;
    private int level;

    public TraceId() {
        this.id = createId();
        this.level = 0;
    }

    public TraceId(String id, int level) {
        this.id = id;
        this.level = level;
    }

    public TraceId craeteNextId() {
        return new TraceId(id, level + 1);
    }

    public TraceId createPrevId() {
        return new TraceId(id, level -1);
    }

    public String getId() {
        return id;
    }

    public int getLevel() {
        return level;
    }

    // uuid의 8자리를 사용하는
    private String createId() {
        return UUID.randomUUID().toString().substring(0, 8);
    }



    public boolean isFirstLevel() {
        return this.level == 0;
    }


}
