package jh;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final li.l f6286b;

    public f(li.l continuation) {
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        this.f6286b = continuation;
    }

    @Override // jh.e
    public final void a(Throwable th2) {
        Object objM159constructorimpl;
        Continuation continuationB = b();
        if (th2 != null) {
            Result.Companion companion = Result.INSTANCE;
            objM159constructorimpl = Result.m159constructorimpl(ResultKt.createFailure(th2));
        } else {
            g.f6287a.getClass();
            objM159constructorimpl = b.f6283c;
        }
        ((li.l) continuationB).resumeWith(objM159constructorimpl);
    }

    public final Continuation b() {
        return this.f6286b;
    }

    @Override // jh.e
    public final void resume() {
        Continuation continuationB = b();
        g.f6287a.getClass();
        ((li.l) continuationB).resumeWith(b.f6283c);
    }
}
