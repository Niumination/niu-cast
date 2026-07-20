package xg;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class e0 extends f0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zf.d0 f10938b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f10939c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e0(u route, zf.d0 parameters, double d7) {
        super(route);
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        this.f10938b = parameters;
        this.f10939c = d7;
    }

    public final String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder("SUCCESS");
        zf.d0 d0Var = this.f10938b;
        if (d0Var.isEmpty()) {
            str = "";
        } else {
            str = "; " + d0Var;
        }
        sb2.append(str);
        sb2.append(" @ ");
        sb2.append(this.f10943a);
        return sb2.toString();
    }
}
