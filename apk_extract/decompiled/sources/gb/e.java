package gb;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5131a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5132b;

    public e(String icon, String action) {
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(action, "action");
        this.f5131a = icon;
        this.f5132b = action;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return Intrinsics.areEqual(this.f5131a, eVar.f5131a) && Intrinsics.areEqual(this.f5132b, eVar.f5132b);
    }

    public final int hashCode() {
        return this.f5132b.hashCode() + (this.f5131a.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("ButtonEntity(icon=");
        sb2.append(this.f5131a);
        sb2.append(", action=");
        return h0.a.n(sb2, this.f5132b, ")");
    }
}
