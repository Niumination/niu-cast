package z4;

import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final String f21826a;

    public j(@os.l String str) {
        l0.p(str, "phoneBrand");
        this.f21826a = str;
    }

    public static /* synthetic */ j c(j jVar, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = jVar.f21826a;
        }
        return jVar.b(str);
    }

    @os.l
    public final String a() {
        return this.f21826a;
    }

    @os.l
    public final j b(@os.l String str) {
        l0.p(str, "phoneBrand");
        return new j(str);
    }

    @os.l
    public final String d() {
        return this.f21826a;
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof j) && l0.g(this.f21826a, ((j) obj).f21826a);
    }

    public int hashCode() {
        return this.f21826a.hashCode();
    }

    @os.l
    public String toString() {
        return n.a.a("PhoneInfo(phoneBrand=", this.f21826a, ")");
    }
}
