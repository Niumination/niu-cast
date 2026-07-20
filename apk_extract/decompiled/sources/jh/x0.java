package jh;

import java.io.IOException;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class x0 implements o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final wi.a f6310b;
    private volatile r0 closed;

    public x0(wi.a source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.f6310b = source;
    }

    @Override // jh.o
    public final void b(Throwable th2) {
        String message;
        if (this.closed != null) {
            return;
        }
        if (th2 == null || (message = th2.getMessage()) == null) {
            message = "Channel was cancelled";
        }
        this.closed = new r0(new IOException(message, th2));
    }

    @Override // jh.o
    public final Throwable c() {
        r0 r0Var = this.closed;
        if (r0Var != null) {
            return r0Var.a();
        }
        return null;
    }

    @Override // jh.o
    public final wi.k d() throws Throwable {
        Throwable thC = c();
        if (thC == null) {
            return this.f6310b;
        }
        throw thC;
    }

    @Override // jh.o
    public final Object e(int i8, ContinuationImpl continuationImpl) throws Throwable {
        Throwable thC = c();
        if (thC == null) {
            return Boxing.boxBoolean(lh.a.e(this.f6310b) >= ((long) i8));
        }
        throw thC;
    }

    @Override // jh.o
    public final boolean f() {
        return this.f6310b.T();
    }
}
