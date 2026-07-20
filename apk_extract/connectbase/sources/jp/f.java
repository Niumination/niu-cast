package jp;

import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final dp.b f8772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8773b;

    public f(@os.l dp.b bVar, int i10) {
        l0.p(bVar, "classId");
        this.f8772a = bVar;
        this.f8773b = i10;
    }

    @os.l
    public final dp.b a() {
        return this.f8772a;
    }

    public final int b() {
        return this.f8773b;
    }

    public final int c() {
        return this.f8773b;
    }

    @os.l
    public final dp.b d() {
        return this.f8772a;
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return l0.g(this.f8772a, fVar.f8772a) && this.f8773b == fVar.f8773b;
    }

    public int hashCode() {
        return (this.f8772a.hashCode() * 31) + this.f8773b;
    }

    @os.l
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        int i10 = this.f8773b;
        int i11 = 0;
        int i12 = 0;
        while (i12 < i10) {
            i12++;
            sb2.append("kotlin/Array<");
        }
        sb2.append(this.f8772a);
        int i13 = this.f8773b;
        while (i11 < i13) {
            i11++;
            sb2.append(">");
        }
        String string = sb2.toString();
        l0.o(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
