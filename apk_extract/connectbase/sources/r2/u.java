package r2;

import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class u extends m {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f14207h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f14208i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @os.m
    public final String f14209j;

    public u(long j10, boolean z10, @os.m String str) {
        super(j10);
        this.f14207h = j10;
        this.f14208i = z10;
        this.f14209j = str;
    }

    public static u l(u uVar, long j10, boolean z10, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = uVar.f14207h;
        }
        if ((i10 & 2) != 0) {
            z10 = uVar.f14208i;
        }
        if ((i10 & 4) != 0) {
            str = uVar.f14209j;
        }
        uVar.getClass();
        return new u(j10, z10, str);
    }

    @Override // r2.m, r2.o
    public long b() {
        return this.f14207h;
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return this.f14207h == uVar.f14207h && this.f14208i == uVar.f14208i && l0.g(this.f14209j, uVar.f14209j);
    }

    @Override // r2.m, r2.o
    public void f(long j10) {
        this.f14207h = j10;
    }

    public final long h() {
        return this.f14207h;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        int iHashCode = Long.hashCode(this.f14207h) * 31;
        boolean z10 = this.f14208i;
        ?? r10 = z10;
        if (z10) {
            r10 = 1;
        }
        int i10 = (iHashCode + r10) * 31;
        String str = this.f14209j;
        return i10 + (str == null ? 0 : str.hashCode());
    }

    public final boolean i() {
        return this.f14208i;
    }

    @os.m
    public final String j() {
        return this.f14209j;
    }

    @os.l
    public final u k(long j10, boolean z10, @os.m String str) {
        return new u(j10, z10, str);
    }

    @os.m
    public final String m() {
        return this.f14209j;
    }

    public final boolean n() {
        return this.f14208i;
    }

    @os.l
    public String toString() {
        StringBuilder sb2 = new StringBuilder("SendFileInfoReplyMessage(taskId=");
        sb2.append(this.f14207h);
        sb2.append(", isAccept=");
        sb2.append(this.f14208i);
        sb2.append(", extend=");
        return l.a.a(sb2, this.f14209j, ')');
    }

    public /* synthetic */ u(long j10, boolean z10, String str, int i10, kn.w wVar) {
        this(j10, z10, (i10 & 4) != 0 ? null : str);
    }
}
