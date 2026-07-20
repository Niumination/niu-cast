package r2;

import n2.k0;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends m {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f14153h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f14154i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f14155j;

    public d(long j10, long j11, long j12) {
        super(j10);
        this.f14153h = j10;
        this.f14154i = j11;
        this.f14155j = j12;
    }

    public static d l(d dVar, long j10, long j11, long j12, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = dVar.f14153h;
        }
        long j13 = j10;
        if ((i10 & 2) != 0) {
            j11 = dVar.f14154i;
        }
        long j14 = j11;
        if ((i10 & 4) != 0) {
            j12 = dVar.f14155j;
        }
        dVar.getClass();
        return new d(j13, j14, j12);
    }

    @Override // r2.m, r2.o
    public long b() {
        return this.f14153h;
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f14153h == dVar.f14153h && this.f14154i == dVar.f14154i && this.f14155j == dVar.f14155j;
    }

    @Override // r2.m, r2.o
    public void f(long j10) {
        this.f14153h = j10;
    }

    public final long h() {
        return this.f14153h;
    }

    public int hashCode() {
        return Long.hashCode(this.f14155j) + ((Long.hashCode(this.f14154i) + (Long.hashCode(this.f14153h) * 31)) * 31);
    }

    public final long i() {
        return this.f14154i;
    }

    public final long j() {
        return this.f14155j;
    }

    @os.l
    public final d k(long j10, long j11, long j12) {
        return new d(j10, j11, j12);
    }

    public final long m() {
        return this.f14154i;
    }

    public final long n() {
        return this.f14155j;
    }

    @os.l
    public String toString() {
        StringBuilder sb2 = new StringBuilder("CancelSendMessage(taskId=");
        sb2.append(this.f14153h);
        sb2.append(", fileId=");
        sb2.append(this.f14154i);
        sb2.append(", sentLength=");
        return k0.a(sb2, this.f14155j, ')');
    }
}
