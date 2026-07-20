package mg;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public class c extends hh.e {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final hh.h f8050l = new hh.h("Setup");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final hh.h f8051m = new hh.h("Monitoring");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final hh.h f8052n = new hh.h("Plugins");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final hh.h f8053o = new hh.h("Call");
    public static final hh.h p = new hh.h("Fallback");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f8054h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final qg.b f8055i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final vg.b f8056j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final wg.b f8057k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(boolean z2, qg.b environment) {
        super(f8050l, f8051m, f8052n, f8053o, p);
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.f8054h = z2;
        this.f8055i = environment;
        this.f8056j = new vg.b(z2);
        this.f8057k = new wg.b(z2);
    }

    @Override // hh.e
    public final boolean h() {
        return this.f8054h;
    }
}
