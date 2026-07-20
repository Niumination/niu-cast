package xg;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends m3.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10941b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f10942c;

    public f(String name, String str, String str2) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.f10940a = name;
        this.f10941b = str;
        this.f10942c = str2;
    }

    @Override // m3.w
    public final n a(c0 c0Var, int i8) {
        return m3.x.a(c0Var.f10930d, i8, this.f10940a, this.f10941b, this.f10942c, true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return Intrinsics.areEqual(this.f10940a, fVar.f10940a) && Intrinsics.areEqual(this.f10941b, fVar.f10941b) && Intrinsics.areEqual(this.f10942c, fVar.f10942c);
    }

    public final int hashCode() {
        int iHashCode = this.f10940a.hashCode() * 31;
        String str = this.f10941b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f10942c;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        String str = this.f10941b;
        if (str == null) {
            str = "";
        }
        sb2.append(str);
        sb2.append('{');
        sb2.append(this.f10940a);
        sb2.append("?}");
        String str2 = this.f10942c;
        sb2.append(str2 != null ? str2 : "");
        return sb2.toString();
    }
}
