package ik;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements ek.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f5897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TimeUnit f5898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ck.h f5899c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f5900d;
    public final ck.c e;

    public k(ck.c cVar, int i8, long j8, TimeUnit timeUnit, ck.h hVar) {
        this.f5897a = j8;
        this.f5898b = timeUnit;
        this.f5899c = hVar;
        this.f5900d = i8;
        this.e = cVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        this.e.getClass();
        int i8 = this.f5900d;
        if (i8 < 0) {
            throw new IllegalArgumentException("bufferSize < 0");
        }
        fk.i iVar = fk.u.f5091c;
        return fk.u.b(new fk.k(i8, this.f5898b.toMillis(this.f5897a), this.f5899c));
    }
}
