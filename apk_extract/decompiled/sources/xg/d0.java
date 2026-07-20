package xg;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class d0 extends f0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10935b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final zf.z f10936c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d0(u route, String reason, zf.z errorStatusCode) {
        super(route);
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(errorStatusCode, "errorStatusCode");
        this.f10935b = reason;
        this.f10936c = errorStatusCode;
    }

    public final String toString() {
        return "FAILURE \"" + this.f10935b + "\" @ " + this.f10943a;
    }
}
