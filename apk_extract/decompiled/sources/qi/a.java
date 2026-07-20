package qi;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a8.a f9128a = new a8.a("CLOSED", 15);

    public static final Object a(w wVar, long j8, Function2 function2) {
        while (true) {
            if (wVar.f9170c >= j8 && !wVar.d()) {
                return wVar;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b.f9131a;
            Object obj = atomicReferenceFieldUpdater.get(wVar);
            a8.a aVar = f9128a;
            if (obj == aVar) {
                return aVar;
            }
            w wVar2 = (w) ((b) obj);
            if (wVar2 == null) {
                wVar2 = (w) function2.invoke(Long.valueOf(wVar.f9170c + 1), wVar);
                if (atomicReferenceFieldUpdater.compareAndSet(wVar, null, wVar2)) {
                    if (wVar.d()) {
                        wVar.e();
                    }
                }
            }
            wVar = wVar2;
        }
    }
}
