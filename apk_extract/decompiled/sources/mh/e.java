package mh;

import java.io.IOException;
import jh.o;
import jh.r0;
import kotlin.ResultKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import li.f0;
import li.l0;
import li.o1;
import li.p1;
import li.r1;
import wi.k;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final wi.c f8087b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CoroutineContext f8088c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public r0 f8089d;
    public final wi.a e;
    public final r1 f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CoroutineContext f8090g;

    public e(wi.c source, CoroutineContext parent) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(parent, "parent");
        this.f8087b = source;
        this.f8088c = parent;
        this.e = new wi.a();
        r1 r1Var = new r1((p1) parent.get(o1.f7483a));
        this.f = r1Var;
        this.f8090g = parent.plus(r1Var).plus(new f0("RawSourceChannel"));
    }

    @Override // jh.o
    public final void b(Throwable th2) {
        String message;
        String message2;
        if (this.f8089d != null) {
            return;
        }
        r1 r1Var = this.f;
        String str = "Channel was cancelled";
        if (th2 == null || (message = th2.getMessage()) == null) {
            message = "Channel was cancelled";
        }
        l0.g(message, th2, r1Var);
        this.f8087b.close();
        if (th2 != null && (message2 = th2.getMessage()) != null) {
            str = message2;
        }
        this.f8089d = new r0(new IOException(str, th2));
    }

    @Override // jh.o
    public final Throwable c() {
        r0 r0Var = this.f8089d;
        if (r0Var != null) {
            return r0Var.a();
        }
        return null;
    }

    @Override // jh.o
    public final k d() {
        return this.e;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // jh.o
    public final Object e(int i8, ContinuationImpl continuationImpl) {
        c cVar;
        if (continuationImpl instanceof c) {
            cVar = (c) continuationImpl;
            int i9 = cVar.label;
            if ((i9 & Integer.MIN_VALUE) != 0) {
                cVar.label = i9 - Integer.MIN_VALUE;
            } else {
                cVar = new c(this, continuationImpl);
            }
        } else {
            cVar = new c(this, continuationImpl);
        }
        Object obj = cVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = cVar.label;
        if (i10 == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.f8089d != null) {
                return Boxing.boxBoolean(true);
            }
            d dVar = new d(this, i8, null);
            cVar.L$0 = this;
            cVar.I$0 = i8;
            cVar.label = 1;
            if (l0.u(this.f8090g, dVar, cVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i8 = cVar.I$0;
            this = (e) cVar.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return Boxing.boxBoolean(lh.a.e(this.e) >= ((long) i8));
    }

    @Override // jh.o
    public final boolean f() {
        return this.f8089d != null && this.e.T();
    }
}
