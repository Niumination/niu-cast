package r2;

import n2.k0;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends m {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f14149h;

    public b(long j10) {
        super(j10);
        this.f14149h = j10;
    }

    public static b j(b bVar, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = bVar.f14149h;
        }
        bVar.getClass();
        return new b(j10);
    }

    @Override // r2.m, r2.o
    public long b() {
        return this.f14149h;
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof b) && this.f14149h == ((b) obj).f14149h;
    }

    @Override // r2.m, r2.o
    public void f(long j10) {
        this.f14149h = j10;
    }

    public final long h() {
        return this.f14149h;
    }

    public int hashCode() {
        return Long.hashCode(this.f14149h);
    }

    @os.l
    public final b i(long j10) {
        return new b(j10);
    }

    @os.l
    public String toString() {
        return k0.a(new StringBuilder("CancelReceiveMessage(taskId="), this.f14149h, ')');
    }
}
