package r2;

import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class v extends o {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public final k f14210g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(@os.l k kVar) {
        super(0, 0L, 3, null);
        l0.p(kVar, "data");
        this.f14210g = kVar;
    }

    public static /* synthetic */ v j(v vVar, k kVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            kVar = vVar.f14210g;
        }
        return vVar.i(kVar);
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof v) && l0.g(this.f14210g, ((v) obj).f14210g);
    }

    @os.l
    public final k h() {
        return this.f14210g;
    }

    public int hashCode() {
        return this.f14210g.hashCode();
    }

    @os.l
    public final v i(@os.l k kVar) {
        l0.p(kVar, "data");
        return new v(kVar);
    }

    @os.l
    public final k k() {
        return this.f14210g;
    }

    @os.l
    public String toString() {
        return "SendFileMessage(data=" + this.f14210g + ')';
    }
}
