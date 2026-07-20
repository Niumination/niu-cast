package o4;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f8386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f8387b;

    public i(Class cls, boolean z2) {
        this.f8386a = cls;
        this.f8387b = z2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return iVar.f8386a.equals(this.f8386a) && iVar.f8387b == this.f8387b;
    }

    public final int hashCode() {
        return Boolean.valueOf(this.f8387b).hashCode() ^ ((this.f8386a.hashCode() ^ 1000003) * 1000003);
    }
}
