package r2;

import n2.k0;

/* JADX INFO: loaded from: classes2.dex */
public final class q extends m {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f14201h;

    public q(long j10) {
        super(j10);
        this.f14201h = j10;
    }

    public static q j(q qVar, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = qVar.f14201h;
        }
        qVar.getClass();
        return new q(j10);
    }

    @Override // r2.m, r2.o
    public long b() {
        return this.f14201h;
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof q) && this.f14201h == ((q) obj).f14201h;
    }

    @Override // r2.m, r2.o
    public void f(long j10) {
        this.f14201h = j10;
    }

    public final long h() {
        return this.f14201h;
    }

    public int hashCode() {
        return Long.hashCode(this.f14201h);
    }

    @os.l
    public final q i(long j10) {
        return new q(j10);
    }

    @os.l
    public String toString() {
        return k0.a(new StringBuilder("ReceiveFinishMessage(taskId="), this.f14201h, ')');
    }
}
