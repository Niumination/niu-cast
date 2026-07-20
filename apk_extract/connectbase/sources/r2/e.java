package r2;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends m {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f14156h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f14157i;

    public e(long j10, boolean z10) {
        super(j10);
        this.f14156h = j10;
        this.f14157i = z10;
    }

    public static e k(e eVar, long j10, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = eVar.f14156h;
        }
        if ((i10 & 2) != 0) {
            z10 = eVar.f14157i;
        }
        eVar.getClass();
        return new e(j10, z10);
    }

    @Override // r2.m, r2.o
    public long b() {
        return this.f14156h;
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f14156h == eVar.f14156h && this.f14157i == eVar.f14157i;
    }

    @Override // r2.m, r2.o
    public void f(long j10) {
        this.f14156h = j10;
    }

    public final long h() {
        return this.f14156h;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        int iHashCode = Long.hashCode(this.f14156h) * 31;
        boolean z10 = this.f14157i;
        ?? r10 = z10;
        if (z10) {
            r10 = 1;
        }
        return iHashCode + r10;
    }

    public final boolean i() {
        return this.f14157i;
    }

    @os.l
    public final e j(long j10, boolean z10) {
        return new e(j10, z10);
    }

    public final boolean l() {
        return this.f14157i;
    }

    @os.l
    public String toString() {
        return "CancelSendReplyMessage(taskId=" + this.f14156h + ", isSuccess=" + this.f14157i + ')';
    }
}
