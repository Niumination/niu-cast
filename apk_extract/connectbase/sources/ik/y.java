package ik;

/* JADX INFO: loaded from: classes2.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final String f8206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final String f8207b;

    public y(@os.l String str, @os.l String str2) {
        kn.l0.p(str, "name");
        kn.l0.p(str2, "value");
        this.f8206a = str;
        this.f8207b = str2;
    }

    public static /* synthetic */ y d(y yVar, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = yVar.f8206a;
        }
        if ((i10 & 2) != 0) {
            str2 = yVar.f8207b;
        }
        return yVar.c(str, str2);
    }

    @os.l
    public final String a() {
        return this.f8206a;
    }

    @os.l
    public final String b() {
        return this.f8207b;
    }

    @os.l
    public final y c(@os.l String str, @os.l String str2) {
        kn.l0.p(str, "name");
        kn.l0.p(str2, "value");
        return new y(str, str2);
    }

    @os.l
    public final String e() {
        return this.f8206a;
    }

    public boolean equals(@os.m Object obj) {
        if (obj instanceof y) {
            y yVar = (y) obj;
            if (jq.e0.K1(yVar.f8206a, this.f8206a, true) && jq.e0.K1(yVar.f8207b, this.f8207b, true)) {
                return true;
            }
        }
        return false;
    }

    @os.l
    public final String f() {
        return this.f8207b;
    }

    public int hashCode() {
        String lowerCase = this.f8206a.toLowerCase();
        kn.l0.o(lowerCase, "this as java.lang.String).toLowerCase()");
        int iHashCode = lowerCase.hashCode();
        String lowerCase2 = this.f8207b.toLowerCase();
        kn.l0.o(lowerCase2, "this as java.lang.String).toLowerCase()");
        return lowerCase2.hashCode() + (iHashCode * 31) + iHashCode;
    }

    @os.l
    public String toString() {
        StringBuilder sb2 = new StringBuilder("HeaderValueParam(name=");
        sb2.append(this.f8206a);
        sb2.append(", value=");
        return l.a.a(sb2, this.f8207b, ')');
    }
}
