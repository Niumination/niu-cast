package rq;

import java.io.Serializable;
import java.util.List;
import lm.z0;
import nq.q0;
import nq.r0;

/* JADX INFO: loaded from: classes3.dex */
@z0
public final class j implements Serializable {

    @os.m
    private final Long coroutineId;

    @os.m
    private final String dispatcher;

    @os.l
    private final List<StackTraceElement> lastObservedStackTrace;

    @os.m
    private final String lastObservedThreadName;

    @os.m
    private final String lastObservedThreadState;

    @os.m
    private final String name;
    private final long sequenceNumber;

    @os.l
    private final String state;

    public j(@os.l e eVar, @os.l um.g gVar) {
        Thread.State state;
        q0 q0Var = (q0) gVar.get(q0.f11900b);
        this.coroutineId = q0Var != null ? Long.valueOf(q0Var.f11901a) : null;
        um.e eVar2 = (um.e) gVar.get(um.e.G);
        this.dispatcher = eVar2 != null ? eVar2.toString() : null;
        r0 r0Var = (r0) gVar.get(r0.f11910b);
        this.name = r0Var != null ? r0Var.f11911a : null;
        this.state = eVar._state;
        Thread thread = eVar.lastObservedThread;
        this.lastObservedThreadState = (thread == null || (state = thread.getState()) == null) ? null : state.toString();
        Thread thread2 = eVar.lastObservedThread;
        this.lastObservedThreadName = thread2 != null ? thread2.getName() : null;
        this.lastObservedStackTrace = eVar.h();
        this.sequenceNumber = eVar.f14823b;
    }

    @os.m
    public final Long getCoroutineId() {
        return this.coroutineId;
    }

    @os.m
    public final String getDispatcher() {
        return this.dispatcher;
    }

    @os.l
    public final List<StackTraceElement> getLastObservedStackTrace() {
        return this.lastObservedStackTrace;
    }

    @os.m
    public final String getLastObservedThreadName() {
        return this.lastObservedThreadName;
    }

    @os.m
    public final String getLastObservedThreadState() {
        return this.lastObservedThreadState;
    }

    @os.m
    public final String getName() {
        return this.name;
    }

    public final long getSequenceNumber() {
        return this.sequenceNumber;
    }

    @os.l
    public final String getState() {
        return this.state;
    }
}
