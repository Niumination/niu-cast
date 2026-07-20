package f2;

import android.os.Handler;
import android.os.HandlerThread;
import kn.l0;

/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.m
    public HandlerThread f5824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.m
    public Handler f5825b;

    public r(@os.m HandlerThread handlerThread, @os.m Handler handler) {
        this.f5824a = handlerThread;
        this.f5825b = handler;
    }

    public static r d(r rVar, HandlerThread handlerThread, Handler handler, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            handlerThread = rVar.f5824a;
        }
        if ((i10 & 2) != 0) {
            handler = rVar.f5825b;
        }
        rVar.getClass();
        return new r(handlerThread, handler);
    }

    @os.m
    public final HandlerThread a() {
        return this.f5824a;
    }

    @os.m
    public final Handler b() {
        return this.f5825b;
    }

    @os.l
    public final r c(@os.m HandlerThread handlerThread, @os.m Handler handler) {
        return new r(handlerThread, handler);
    }

    @os.m
    public final Handler e() {
        return this.f5825b;
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return l0.g(this.f5824a, rVar.f5824a) && l0.g(this.f5825b, rVar.f5825b);
    }

    @os.m
    public final HandlerThread f() {
        return this.f5824a;
    }

    public final void g(@os.m Handler handler) {
        this.f5825b = handler;
    }

    public final void h(@os.m HandlerThread handlerThread) {
        this.f5824a = handlerThread;
    }

    public int hashCode() {
        HandlerThread handlerThread = this.f5824a;
        int iHashCode = (handlerThread == null ? 0 : handlerThread.hashCode()) * 31;
        Handler handler = this.f5825b;
        return iHashCode + (handler != null ? handler.hashCode() : 0);
    }

    @os.l
    public String toString() {
        return "HandlerHolder(thread=" + this.f5824a + ", handler=" + this.f5825b + ')';
    }
}
