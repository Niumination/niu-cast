package rp;

import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class s<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f14768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f14769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final String f14770c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final dp.b f14771d;

    public s(T t10, T t11, @os.l String str, @os.l dp.b bVar) {
        l0.p(str, "filePath");
        l0.p(bVar, "classId");
        this.f14768a = t10;
        this.f14769b = t11;
        this.f14770c = str;
        this.f14771d = bVar;
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return l0.g(this.f14768a, sVar.f14768a) && l0.g(this.f14769b, sVar.f14769b) && l0.g(this.f14770c, sVar.f14770c) && l0.g(this.f14771d, sVar.f14771d);
    }

    public int hashCode() {
        T t10 = this.f14768a;
        int iHashCode = (t10 == null ? 0 : t10.hashCode()) * 31;
        T t11 = this.f14769b;
        return this.f14771d.hashCode() + s0.b.a(this.f14770c, (iHashCode + (t11 != null ? t11.hashCode() : 0)) * 31, 31);
    }

    @os.l
    public String toString() {
        return "IncompatibleVersionErrorData(actualVersion=" + this.f14768a + ", expectedVersion=" + this.f14769b + ", filePath=" + this.f14770c + ", classId=" + this.f14771d + ')';
    }
}
