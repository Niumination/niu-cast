package xg;

import af.r5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends m3.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zf.x f10926a;

    public b(zf.x method) {
        Intrinsics.checkNotNullParameter(method, "method");
        this.f10926a = method;
    }

    @Override // m3.w
    public final n a(c0 c0Var, int i8) {
        vg.e eVarG = c0Var.f10928b.g();
        Intrinsics.checkNotNullParameter(eVarG, "<this>");
        return Intrinsics.areEqual((zf.x) ((r5) ug.f.a(eVarG)).f560h, this.f10926a) ? n.e : n.f10969b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof b) && Intrinsics.areEqual(this.f10926a, ((b) obj).f10926a);
    }

    public final int hashCode() {
        return this.f10926a.f11559a.hashCode();
    }

    public final String toString() {
        return a1.a.s(new StringBuilder("(method:"), this.f10926a.f11559a, ')');
    }
}
