package xg;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends m3.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10945b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f10946c;

    public g(String name, String str, String str2) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.f10944a = name;
        this.f10945b = str;
        this.f10946c = str2;
    }

    @Override // m3.w
    public final n a(c0 c0Var, int i8) {
        return m3.x.a(c0Var.f10930d, i8, this.f10944a, this.f10945b, this.f10946c, false);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return Intrinsics.areEqual(this.f10944a, gVar.f10944a) && Intrinsics.areEqual(this.f10945b, gVar.f10945b) && Intrinsics.areEqual(this.f10946c, gVar.f10946c);
    }

    public final int hashCode() {
        int iHashCode = this.f10944a.hashCode() * 31;
        String str = this.f10945b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f10946c;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        String str = this.f10945b;
        if (str == null) {
            str = "";
        }
        sb2.append(str);
        sb2.append('{');
        sb2.append(this.f10944a);
        sb2.append('}');
        String str2 = this.f10946c;
        sb2.append(str2 != null ? str2 : "");
        return sb2.toString();
    }
}
