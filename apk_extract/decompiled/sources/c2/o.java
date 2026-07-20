package c2;

/* JADX INFO: loaded from: classes.dex */
public final class o extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f1423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u f1424b;

    public o(v vVar, u uVar) {
        this.f1423a = vVar;
        this.f1424b = uVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        v vVar = this.f1423a;
        if (vVar != null ? vVar.equals(((o) wVar).f1423a) : ((o) wVar).f1423a == null) {
            u uVar = this.f1424b;
            if (uVar == null) {
                if (((o) wVar).f1424b == null) {
                    return true;
                }
            } else if (uVar.equals(((o) wVar).f1424b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        v vVar = this.f1423a;
        int iHashCode = ((vVar == null ? 0 : vVar.hashCode()) ^ 1000003) * 1000003;
        u uVar = this.f1424b;
        return iHashCode ^ (uVar != null ? uVar.hashCode() : 0);
    }

    public final String toString() {
        return "NetworkConnectionInfo{networkType=" + this.f1423a + ", mobileSubtype=" + this.f1424b + "}";
    }
}
