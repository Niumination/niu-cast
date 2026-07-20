package fk;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public final class q extends ck.i {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final m[] f5083o = new m[0];
    public static final m[] p = new m[0];
    public final o e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f5084h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicReference f5085i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f5086j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f5087k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f5088l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f5089m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public volatile ck.e f5090n;

    public q(o oVar) {
        this.e = oVar;
        d dVar = d.f5057a;
        this.f5085i = new AtomicReference(f5083o);
        new AtomicBoolean();
        a(0L);
    }

    @Override // ck.i
    public final void b(ck.e eVar) {
        if (this.f5090n != null) {
            throw new IllegalStateException("Only a single producer can be set on a Subscriber.");
        }
        this.f5090n = eVar;
        c();
        d();
    }

    public final void c() {
        if (this.f1736a.f5909b) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f5086j) {
                    this.f5087k = true;
                    return;
                }
                this.f5086j = true;
                while (!this.f1736a.f5909b) {
                    m[] mVarArr = (m[]) this.f5085i.get();
                    long j8 = this.f5088l;
                    long jMax = j8;
                    for (m mVar : mVarArr) {
                        jMax = Math.max(jMax, mVar.totalRequested.get());
                    }
                    long j10 = this.f5089m;
                    ck.e eVar = this.f5090n;
                    long j11 = jMax - j8;
                    if (j11 != 0) {
                        this.f5088l = jMax;
                        if (eVar == null) {
                            long j12 = j10 + j11;
                            if (j12 < 0) {
                                j12 = Long.MAX_VALUE;
                            }
                            this.f5089m = j12;
                        } else if (j10 != 0) {
                            this.f5089m = 0L;
                            eVar.request(j10 + j11);
                        } else {
                            eVar.request(j11);
                        }
                    } else if (j10 != 0 && eVar != null) {
                        this.f5089m = 0L;
                        eVar.request(j10);
                    }
                    synchronized (this) {
                        try {
                            if (!this.f5087k) {
                                this.f5086j = false;
                                return;
                            }
                            this.f5087k = false;
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    public final void d() {
        for (m mVar : (m[]) this.f5085i.get()) {
            this.e.replay(mVar);
        }
    }

    @Override // ck.d
    public final void onCompleted() {
        if (this.f5084h) {
            return;
        }
        this.f5084h = true;
        try {
            this.e.complete();
            d();
        } finally {
            unsubscribe();
        }
    }

    @Override // ck.d
    public final void onError(Throwable th2) {
        if (this.f5084h) {
            return;
        }
        this.f5084h = true;
        try {
            this.e.error(th2);
            d();
        } finally {
            unsubscribe();
        }
    }

    @Override // ck.d
    public final void onNext(Object obj) {
        if (this.f5084h) {
            return;
        }
        this.e.next(obj);
        d();
    }
}
