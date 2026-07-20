package wj;

import java.util.ArrayList;
import java.util.Queue;
import vj.e;
import xj.j;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends xj.c {
    static final boolean RECORD_ALL_EVENTS = true;
    private static final long serialVersionUID = -176083308134819629L;
    Queue<c> eventQueue;
    j logger;
    String name;

    public a(j jVar, Queue<c> queue) {
        this.logger = jVar;
        this.name = jVar.f11014a;
        this.eventQueue = queue;
    }

    @Override // xj.c, xj.a, vj.b
    public /* bridge */ /* synthetic */ yj.a atDebug() {
        return super.atDebug();
    }

    @Override // xj.c, xj.a, vj.b
    public /* bridge */ /* synthetic */ yj.a atError() {
        return super.atError();
    }

    @Override // xj.c, xj.a, vj.b
    public /* bridge */ /* synthetic */ yj.a atInfo() {
        return super.atInfo();
    }

    @Override // xj.c, xj.a, vj.b
    public /* bridge */ /* synthetic */ yj.a atLevel(b bVar) {
        return super.atLevel(bVar);
    }

    @Override // xj.c, xj.a, vj.b
    public /* bridge */ /* synthetic */ yj.a atTrace() {
        return super.atTrace();
    }

    @Override // xj.c, xj.a, vj.b
    public /* bridge */ /* synthetic */ yj.a atWarn() {
        return super.atWarn();
    }

    @Override // xj.a
    public String getFullyQualifiedCallerName() {
        return null;
    }

    @Override // xj.a
    public String getName() {
        return this.name;
    }

    @Override // xj.a
    public void handleNormalizedLoggingCall(b bVar, e eVar, String str, Object[] objArr, Throwable th2) {
        c cVar = new c();
        System.currentTimeMillis();
        cVar.f10789a = bVar;
        cVar.f10791c = this.logger;
        if (eVar != null) {
            if (cVar.f10790b == null) {
                cVar.f10790b = new ArrayList(2);
            }
            cVar.f10790b.add(eVar);
        }
        Thread.currentThread().getName();
        cVar.f10792d = objArr;
        this.eventQueue.add(cVar);
    }

    @Override // xj.c, xj.a, vj.b
    public boolean isDebugEnabled() {
        return true;
    }

    @Override // xj.c, xj.a, vj.b
    public /* bridge */ /* synthetic */ boolean isEnabledForLevel(b bVar) {
        return super.isEnabledForLevel(bVar);
    }

    @Override // xj.c, xj.a, vj.b
    public boolean isErrorEnabled() {
        return true;
    }

    @Override // xj.c, xj.a, vj.b
    public boolean isInfoEnabled() {
        return true;
    }

    @Override // xj.c, xj.a, vj.b
    public boolean isTraceEnabled() {
        return true;
    }

    @Override // xj.c, xj.a, vj.b
    public boolean isWarnEnabled() {
        return true;
    }

    @Override // xj.c, xj.a, vj.b
    public yj.a makeLoggingEventBuilder(b bVar) {
        return new yj.b();
    }
}
