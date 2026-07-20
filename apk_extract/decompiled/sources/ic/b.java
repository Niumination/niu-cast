package ic;

import android.util.Log;
import k3.gc;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f5723a;

    public b(Ref.ObjectRef objectRef) {
        this.f5723a = objectRef;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Ref.ObjectRef objectRef = this.f5723a;
        hc.b bVar = (hc.b) objectRef.element;
        String log = "connectBle:task done,result:" + (bVar != null ? Boolean.valueOf(bVar.f5279a) : null);
        Intrinsics.checkNotNullParameter("BLEConnectHelper", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("BLEConnectHelper"), log);
        }
        T t3 = objectRef.element;
        if (t3 == 0) {
            Lazy lazy = mc.b.f7958a;
            if (mc.b.f7967l.get()) {
                mc.b.g();
            } else {
                Intrinsics.checkNotNullParameter("TranConnectManager", "tag");
                Intrinsics.checkNotNullParameter("disconnectAbnormal", "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("TranConnectManager"), "disconnectAbnormal");
                }
                mc.b.c();
            }
        } else {
            hc.b bVar2 = (hc.b) t3;
            if (!bVar2.f5279a && !Intrinsics.areEqual(bVar2.f5280b, "reject")) {
                Lazy lazy2 = mc.b.f7958a;
                mc.b.c();
            }
        }
        return Unit.INSTANCE;
    }
}
