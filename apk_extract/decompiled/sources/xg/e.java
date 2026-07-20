package xg;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends m3.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10937a;

    public e(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.f10937a = value;
    }

    @Override // m3.w
    public final n a(c0 c0Var, int i8) {
        return (i8 >= c0Var.f10930d.size() || !Intrinsics.areEqual(c0Var.f10930d.get(i8), this.f10937a)) ? n.f10968a : n.f10972g;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof e) && Intrinsics.areEqual(this.f10937a, ((e) obj).f10937a);
    }

    public final int hashCode() {
        return this.f10937a.hashCode();
    }

    public final String toString() {
        return this.f10937a;
    }
}
