package r2;

import n2.k0;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends m {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f14150h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f14151i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f14152j;

    public c(long j10, long j11, long j12) {
        super(j10);
        this.f14150h = j10;
        this.f14151i = j11;
        this.f14152j = j12;
    }

    public static c l(c cVar, long j10, long j11, long j12, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = cVar.f14150h;
        }
        long j13 = j10;
        if ((i10 & 2) != 0) {
            j11 = cVar.f14151i;
        }
        long j14 = j11;
        if ((i10 & 4) != 0) {
            j12 = cVar.f14152j;
        }
        cVar.getClass();
        return new c(j13, j14, j12);
    }

    @Override // r2.m, r2.o
    public long b() {
        return this.f14150h;
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f14150h == cVar.f14150h && this.f14151i == cVar.f14151i && this.f14152j == cVar.f14152j;
    }

    @Override // r2.m, r2.o
    public void f(long j10) {
        this.f14150h = j10;
    }

    public final long h() {
        return this.f14150h;
    }

    public int hashCode() {
        return Long.hashCode(this.f14152j) + ((Long.hashCode(this.f14151i) + (Long.hashCode(this.f14150h) * 31)) * 31);
    }

    public final long i() {
        return this.f14151i;
    }

    public final long j() {
        return this.f14152j;
    }

    @os.l
    public final c k(long j10, long j11, long j12) {
        return new c(j10, j11, j12);
    }

    public final long m() {
        return this.f14151i;
    }

    public final long n() {
        return this.f14152j;
    }

    @os.l
    public String toString() {
        StringBuilder sb2 = new StringBuilder("CancelReceiveReplyMessage(taskId=");
        sb2.append(this.f14150h);
        sb2.append(", fileId=");
        sb2.append(this.f14151i);
        sb2.append(", sentLength=");
        return k0.a(sb2, this.f14152j, ')');
    }
}
