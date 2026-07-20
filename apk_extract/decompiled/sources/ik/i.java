package ik;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements ek.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TimeUnit f5892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ck.c f5893b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f5894c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ck.h f5895d;

    public i(ck.c cVar, long j8, TimeUnit timeUnit, ck.h hVar) {
        this.f5892a = timeUnit;
        this.f5893b = cVar;
        this.f5894c = j8;
        this.f5895d = hVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        this.f5893b.getClass();
        fk.i iVar = fk.u.f5091c;
        return fk.u.b(new fk.k(Integer.MAX_VALUE, this.f5892a.toMillis(this.f5894c), this.f5895d));
    }
}
