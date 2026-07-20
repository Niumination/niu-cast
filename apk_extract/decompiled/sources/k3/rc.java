package k3;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class rc {
    public static qj.e a() throws InterruptedException {
        qj.e eVar = qj.e.f9192l;
        Intrinsics.checkNotNull(eVar);
        qj.e eVar2 = eVar.f;
        if (eVar2 == null) {
            long jNanoTime = System.nanoTime();
            qj.e.f9189i.await(qj.e.f9190j, TimeUnit.MILLISECONDS);
            qj.e eVar3 = qj.e.f9192l;
            Intrinsics.checkNotNull(eVar3);
            if (eVar3.f != null || System.nanoTime() - jNanoTime < qj.e.f9191k) {
                return null;
            }
            return qj.e.f9192l;
        }
        long jNanoTime2 = eVar2.f9193g - System.nanoTime();
        if (jNanoTime2 > 0) {
            qj.e.f9189i.await(jNanoTime2, TimeUnit.NANOSECONDS);
            return null;
        }
        qj.e eVar4 = qj.e.f9192l;
        Intrinsics.checkNotNull(eVar4);
        eVar4.f = eVar2.f;
        eVar2.f = null;
        return eVar2;
    }
}
