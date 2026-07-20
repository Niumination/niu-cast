package c2;

/* JADX INFO: loaded from: classes.dex */
public final class j extends r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f1405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f1406b;

    public j(q qVar, h hVar) {
        this.f1405a = qVar;
        this.f1406b = hVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        q qVar = this.f1405a;
        if (qVar != null ? qVar.equals(((j) rVar).f1405a) : ((j) rVar).f1405a == null) {
            if (this.f1406b.equals(((j) rVar).f1406b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        q qVar = this.f1405a;
        return this.f1406b.hashCode() ^ (((qVar == null ? 0 : qVar.hashCode()) ^ 1000003) * 1000003);
    }

    public final String toString() {
        return "ClientInfo{clientType=" + this.f1405a + ", androidClientInfo=" + this.f1406b + "}";
    }
}
