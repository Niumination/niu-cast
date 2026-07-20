package ck;

import ik.v;

/* JADX INFO: loaded from: classes3.dex */
public abstract class i implements d, j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f1736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ik.a f1737b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f1738c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f1739d;

    public i() {
        this(null, false);
    }

    public final void a(long j8) {
        if (j8 < 0) {
            throw new IllegalArgumentException(o.d.j("number requested cannot be negative: ", j8));
        }
        synchronized (this) {
            e eVar = this.f1738c;
            if (eVar != null) {
                eVar.request(j8);
                return;
            }
            long j10 = this.f1739d;
            if (j10 == Long.MIN_VALUE) {
                this.f1739d = j8;
            } else {
                long j11 = j10 + j8;
                if (j11 < 0) {
                    this.f1739d = Long.MAX_VALUE;
                } else {
                    this.f1739d = j11;
                }
            }
        }
    }

    public void b(e eVar) {
        long j8;
        ik.a aVar;
        boolean z2;
        synchronized (this) {
            j8 = this.f1739d;
            this.f1738c = eVar;
            aVar = this.f1737b;
            z2 = aVar != null && j8 == Long.MIN_VALUE;
        }
        if (z2) {
            aVar.b(eVar);
        } else if (j8 == Long.MIN_VALUE) {
            eVar.request(Long.MAX_VALUE);
        } else {
            eVar.request(j8);
        }
    }

    @Override // ck.j
    public final boolean isUnsubscribed() {
        return this.f1736a.f5909b;
    }

    @Override // ck.j
    public final void unsubscribe() {
        this.f1736a.unsubscribe();
    }

    public i(ik.a aVar, boolean z2) {
        this.f1739d = Long.MIN_VALUE;
        this.f1737b = aVar;
        this.f1736a = (!z2 || aVar == null) ? new v() : aVar.f1736a;
    }
}
