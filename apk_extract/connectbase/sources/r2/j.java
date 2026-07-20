package r2;

import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f14176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public String f14177b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f14178c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final String f14179d;

    public j(long j10, @os.l String str, long j11, @os.l String str2) {
        l0.p(str, "name");
        l0.p(str2, "md5");
        this.f14176a = j10;
        this.f14177b = str;
        this.f14178c = j11;
        this.f14179d = str2;
    }

    public static /* synthetic */ j f(j jVar, long j10, String str, long j11, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = jVar.f14176a;
        }
        long j12 = j10;
        if ((i10 & 2) != 0) {
            str = jVar.f14177b;
        }
        String str3 = str;
        if ((i10 & 4) != 0) {
            j11 = jVar.f14178c;
        }
        long j13 = j11;
        if ((i10 & 8) != 0) {
            str2 = jVar.f14179d;
        }
        return jVar.e(j12, str3, j13, str2);
    }

    public final long a() {
        return this.f14176a;
    }

    @os.l
    public final String b() {
        return this.f14177b;
    }

    public final long c() {
        return this.f14178c;
    }

    @os.l
    public final String d() {
        return this.f14179d;
    }

    @os.l
    public final j e(long j10, @os.l String str, long j11, @os.l String str2) {
        l0.p(str, "name");
        l0.p(str2, "md5");
        return new j(j10, str, j11, str2);
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return this.f14176a == jVar.f14176a && l0.g(this.f14177b, jVar.f14177b) && this.f14178c == jVar.f14178c && l0.g(this.f14179d, jVar.f14179d);
    }

    public final long g() {
        return this.f14176a;
    }

    @os.l
    public final String h() {
        return this.f14179d;
    }

    public int hashCode() {
        return this.f14179d.hashCode() + ((Long.hashCode(this.f14178c) + s0.b.a(this.f14177b, Long.hashCode(this.f14176a) * 31, 31)) * 31);
    }

    @os.l
    public final String i() {
        return this.f14177b;
    }

    public final long j() {
        return this.f14178c;
    }

    public final void k(@os.l String str) {
        l0.p(str, "<set-?>");
        this.f14177b = str;
    }

    @os.l
    public String toString() {
        StringBuilder sb2 = new StringBuilder("FileInfo(id=");
        sb2.append(this.f14176a);
        sb2.append(", name=");
        sb2.append(this.f14177b);
        sb2.append(", size=");
        sb2.append(this.f14178c);
        sb2.append(", md5=");
        return l.a.a(sb2, this.f14179d, ')');
    }
}
