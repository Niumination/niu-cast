package r2;

import java.util.List;
import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class t extends m {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f14204h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @os.l
    public final List<j> f14205i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @os.m
    public final String f14206j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(long j10, @os.l List<j> list, @os.m String str) {
        super(j10);
        l0.p(list, "data");
        this.f14204h = j10;
        this.f14205i = list;
        this.f14206j = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ t l(t tVar, long j10, List list, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = tVar.f14204h;
        }
        if ((i10 & 2) != 0) {
            list = tVar.f14205i;
        }
        if ((i10 & 4) != 0) {
            str = tVar.f14206j;
        }
        return tVar.k(j10, list, str);
    }

    @Override // r2.m, r2.o
    public long b() {
        return this.f14204h;
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return this.f14204h == tVar.f14204h && l0.g(this.f14205i, tVar.f14205i) && l0.g(this.f14206j, tVar.f14206j);
    }

    @Override // r2.m, r2.o
    public void f(long j10) {
        this.f14204h = j10;
    }

    public final long h() {
        return this.f14204h;
    }

    public int hashCode() {
        int iHashCode = (this.f14205i.hashCode() + (Long.hashCode(this.f14204h) * 31)) * 31;
        String str = this.f14206j;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    @os.l
    public final List<j> i() {
        return this.f14205i;
    }

    @os.m
    public final String j() {
        return this.f14206j;
    }

    @os.l
    public final t k(long j10, @os.l List<j> list, @os.m String str) {
        l0.p(list, "data");
        return new t(j10, list, str);
    }

    @os.l
    public final List<j> m() {
        return this.f14205i;
    }

    @os.m
    public final String n() {
        return this.f14206j;
    }

    @os.l
    public String toString() {
        StringBuilder sb2 = new StringBuilder("SendFileInfoMessage(taskId=");
        sb2.append(this.f14204h);
        sb2.append(", data=");
        sb2.append(this.f14205i);
        sb2.append(", extend=");
        return l.a.a(sb2, this.f14206j, ')');
    }

    public /* synthetic */ t(long j10, List list, String str, int i10, kn.w wVar) {
        this(j10, list, (i10 & 4) != 0 ? null : str);
    }
}
