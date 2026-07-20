package v7;

import android.app.Application;
import android.util.Log;
import java.util.Map;
import k3.gc;
import k3.pb;
import kotlin.jvm.internal.Intrinsics;
import o7.c;
import w7.d;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements c {
    @Override // o7.c
    public final void a() {
        Intrinsics.checkNotNullParameter("ScreenControlCapability", "tag");
        Intrinsics.checkNotNullParameter("unInit", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("ScreenControlCapability"), "unInit");
        }
        d.f10682d = null;
        pa.a aVar = pa.a.f8703a;
        if (pa.a.j("ro.tr_project.flip_screen.support") || pa.a.j("ro.tr_project.foldable_screen.support")) {
            o6.a aVar2 = d.f10680b;
            aVar2.f8407b = null;
            lc.a aVar3 = (lc.a) aVar2.e;
            if (aVar3 != null) {
                try {
                    aVar.b(aVar3);
                } catch (Throwable e) {
                    Intrinsics.checkNotNullParameter("FoldChangeHelper", "tag");
                    Intrinsics.checkNotNullParameter(e, "e");
                    Log.e(gc.f6463b.concat("FoldChangeHelper"), e.getMessage(), e);
                }
                aVar2.e = null;
            }
        }
        Application context = pb.a();
        w7.a aVar4 = d.f10681c;
        aVar4.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        if (aVar4.f10676d.compareAndSet(true, false)) {
            aVar4.f10675c = null;
            try {
                context.unregisterReceiver(aVar4.e);
            } catch (Exception e4) {
                Intrinsics.checkNotNullParameter("KeyguardManagerUtil", "tag");
                Intrinsics.checkNotNullParameter(e4, "e");
                Log.e(gc.f6463b.concat("KeyguardManagerUtil"), e4.getMessage(), e4);
            }
        }
    }

    @Override // o7.c
    public final void b(q7.a capabilityBean, Map map) {
        Intrinsics.checkNotNullParameter(capabilityBean, "capabilityBean");
        Intrinsics.checkNotNullParameter(capabilityBean, "capabilityBean");
    }

    @Override // o7.c
    public final void start() {
    }
}
