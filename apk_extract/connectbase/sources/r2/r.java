package r2;

import n2.k0;

/* JADX INFO: loaded from: classes2.dex */
public final class r extends o {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f14202g;

    public r(long j10) {
        super(0, j10, 1, null);
        this.f14202g = j10;
    }

    public static r j(r rVar, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = rVar.f14202g;
        }
        rVar.getClass();
        return new r(j10);
    }

    @Override // r2.o
    public long b() {
        return this.f14202g;
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof r) && this.f14202g == ((r) obj).f14202g;
    }

    @Override // r2.o
    public void f(long j10) {
        this.f14202g = j10;
    }

    public final long h() {
        return this.f14202g;
    }

    public int hashCode() {
        return Long.hashCode(this.f14202g);
    }

    @os.l
    public final r i(long j10) {
        return new r(j10);
    }

    @os.l
    public String toString() {
        return k0.a(new StringBuilder("ResumeSendMessage(taskId="), this.f14202g, ')');
    }
}
