package vq;

import java.util.List;
import kn.r1;
import nq.g2;
import nq.x2;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nMainDispatchers.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MainDispatchers.kt\nkotlinx/coroutines/internal/MainDispatchersKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,134:1\n1#2:135\n*E\n"})
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final String f17842a = "kotlinx.coroutines.fast.service.loader";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f17843b = false;

    public static final h0 a(Throwable th2, String str) throws Throwable {
        if (th2 != null) {
            throw th2;
        }
        e();
        throw new lm.y();
    }

    public static /* synthetic */ h0 b(Throwable th2, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            th2 = null;
        }
        if ((i10 & 2) != 0) {
            str = null;
        }
        return a(th2, str);
    }

    public static /* synthetic */ void c() {
    }

    @g2
    public static final boolean d(@os.l x2 x2Var) {
        return x2Var.f0() instanceof h0;
    }

    @os.l
    public static final Void e() {
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    }

    @g2
    @os.l
    public static final x2 f(@os.l e0 e0Var, @os.l List<? extends e0> list) {
        try {
            return e0Var.b(list);
        } catch (Throwable th2) {
            return a(th2, e0Var.a());
        }
    }
}
