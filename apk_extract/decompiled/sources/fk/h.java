package fk;

import java.util.AbstractQueue;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends ck.i implements ek.a {
    public final ck.i e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ck.g f5070h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AbstractQueue f5072j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f5073k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile boolean f5074l;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Throwable f5077o;
    public long p;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final AtomicLong f5075m = new AtomicLong();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final AtomicLong f5076n = new AtomicLong();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final d f5071i = d.f5057a;

    public h(ck.h hVar, ck.i iVar, int i8) {
        this.e = iVar;
        this.f5070h = hVar.a();
        i8 = i8 <= 0 ? ik.s.f5906b : i8;
        this.f5073k = i8 - (i8 >> 2);
        if (kk.s.f6994a == null || kk.s.f6995b) {
            this.f5072j = new jk.b(i8);
        } else {
            this.f5072j = new kk.o(i8);
        }
        a(i8);
    }

    public final boolean c(boolean z2, boolean z3, ck.i iVar, AbstractQueue abstractQueue) {
        if (iVar.f1736a.f5909b) {
            abstractQueue.clear();
            return true;
        }
        if (!z2) {
            return false;
        }
        Throwable th2 = this.f5077o;
        if (th2 != null) {
            abstractQueue.clear();
            try {
                iVar.onError(th2);
                return true;
            } finally {
                this.f5070h.unsubscribe();
            }
        }
        if (!z3) {
            return false;
        }
        try {
            iVar.onCompleted();
            return true;
        } finally {
            this.f5070h.unsubscribe();
        }
    }

    @Override // ek.a
    public final void call() {
        long j8;
        long j10;
        long j11 = this.p;
        AbstractQueue abstractQueue = this.f5072j;
        ck.i iVar = this.e;
        d dVar = this.f5071i;
        long jAddAndGet = 1;
        do {
            long j12 = this.f5075m.get();
            while (j12 != j11) {
                boolean z2 = this.f5074l;
                Object objPoll = abstractQueue.poll();
                boolean z3 = objPoll == null;
                if (c(z2, z3, iVar, abstractQueue)) {
                    return;
                }
                if (z3) {
                    break;
                }
                dVar.getClass();
                if (objPoll == d.f5059c) {
                    objPoll = null;
                }
                iVar.onNext(objPoll);
                j11++;
                if (j11 == this.f5073k) {
                    AtomicLong atomicLong = this.f5075m;
                    do {
                        j8 = atomicLong.get();
                        j10 = Long.MAX_VALUE;
                        if (j8 == Long.MAX_VALUE) {
                            break;
                        }
                        j10 = j8 - j11;
                        if (j10 < 0) {
                            throw new IllegalStateException(o.d.j("More produced than requested: ", j10));
                        }
                    } while (!atomicLong.compareAndSet(j8, j10));
                    a(j11);
                    j12 = j10;
                    j11 = 0;
                }
            }
            if (j12 == j11 && c(this.f5074l, abstractQueue.isEmpty(), iVar, abstractQueue)) {
                return;
            }
            this.p = j11;
            jAddAndGet = this.f5076n.addAndGet(-jAddAndGet);
        } while (jAddAndGet != 0);
    }

    public final void d() {
        if (this.f5076n.getAndIncrement() == 0) {
            this.f5070h.b(this);
        }
    }

    @Override // ck.d
    public final void onCompleted() {
        if (this.f1736a.f5909b || this.f5074l) {
            return;
        }
        this.f5074l = true;
        d();
    }

    @Override // ck.d
    public final void onError(Throwable th2) {
        if (this.f1736a.f5909b || this.f5074l) {
            nk.c.f8331d.a().getClass();
            return;
        }
        this.f5077o = th2;
        this.f5074l = true;
        d();
    }

    @Override // ck.d
    public final void onNext(Object obj) {
        if (this.f1736a.f5909b || this.f5074l) {
            return;
        }
        AbstractQueue abstractQueue = this.f5072j;
        this.f5071i.getClass();
        if (obj == null) {
            obj = d.f5059c;
        }
        if (abstractQueue.offer(obj)) {
            d();
        } else {
            onError(new dk.d());
        }
    }
}
