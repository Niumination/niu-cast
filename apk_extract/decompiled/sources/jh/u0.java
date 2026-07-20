package jh;

import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class u0 implements o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f6303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final wi.a f6304c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f6305d;
    public long e;

    public u0(o delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.f6303b = delegate;
        this.f6304c = new wi.a();
    }

    @Override // jh.o
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final wi.a d() {
        g();
        wi.k kVarD = this.f6303b.d();
        wi.a aVar = this.f6304c;
        this.f6305d += aVar.k(kVarD);
        return aVar;
    }

    @Override // jh.o
    public final void b(Throwable th2) {
        this.f6303b.b(th2);
        this.f6304c.getClass();
    }

    @Override // jh.o
    public final Throwable c() {
        return this.f6303b.c();
    }

    @Override // jh.o
    public final Object e(int i8, ContinuationImpl continuationImpl) {
        return d().f10764c < ((long) i8) ? this.f6303b.e(i8, continuationImpl) : Boxing.boxBoolean(true);
    }

    @Override // jh.o
    public final boolean f() {
        return this.f6304c.T() && this.f6303b.f();
    }

    public final void g() {
        long j8 = this.e;
        long j10 = this.f6305d;
        long j11 = this.f6304c.f10764c;
        this.e = (j10 - j11) + j8;
        this.f6305d = j11;
    }
}
