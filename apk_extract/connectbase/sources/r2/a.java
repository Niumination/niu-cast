package r2;

import n2.k0;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends o {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f14148g;

    public a() {
        this(0L, 1, null);
    }

    public static a j(a aVar, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = aVar.f14148g;
        }
        aVar.getClass();
        return new a(j10);
    }

    @Override // r2.o
    public long b() {
        return this.f14148g;
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && this.f14148g == ((a) obj).f14148g;
    }

    @Override // r2.o
    public void f(long j10) {
        this.f14148g = j10;
    }

    public final long h() {
        return this.f14148g;
    }

    public int hashCode() {
        return Long.hashCode(this.f14148g);
    }

    @os.l
    public final a i(long j10) {
        return new a(j10);
    }

    @os.l
    public String toString() {
        return k0.a(new StringBuilder("CancelMessage(taskId="), this.f14148g, ')');
    }

    public /* synthetic */ a(long j10, int i10, kn.w wVar) {
        this((i10 & 1) != 0 ? 0L : j10);
    }

    public a(long j10) {
        super(0, j10, 1, null);
        this.f14148g = j10;
    }
}
