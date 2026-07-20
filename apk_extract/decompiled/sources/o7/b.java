package o7;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import x7.f;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8411a;

    public /* synthetic */ b(int i8) {
        this.f8411a = i8;
    }

    private final void c() {
    }

    private final void d() {
    }

    private final void e() {
    }

    private final void f() {
    }

    private final void g() {
    }

    @Override // o7.c
    public final void a() {
        int i8 = this.f8411a;
    }

    @Override // o7.c
    public final void b(q7.a capabilityBean, Map map) {
        switch (this.f8411a) {
            case 0:
                Intrinsics.checkNotNullParameter(capabilityBean, "capabilityBean");
                break;
            case 1:
                Intrinsics.checkNotNullParameter(capabilityBean, "capabilityBean");
                break;
            case 2:
                Intrinsics.checkNotNullParameter(capabilityBean, "capabilityBean");
                break;
            default:
                Intrinsics.checkNotNullParameter(capabilityBean, "capabilityBean");
                break;
        }
    }

    @Override // o7.c
    public final void start() {
        switch (this.f8411a) {
            case 0:
                break;
            case 1:
                f.a();
                break;
            case 2:
                f.i();
                break;
            default:
                f.c();
                break;
        }
    }
}
