package vq;

import kn.r1;
import nq.g2;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nSynchronized.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 2 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n*L\n1#1,33:1\n20#2:34\n*S KotlinDebug\n*F\n+ 1 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n*L\n31#1:34\n*E\n"})
public final class w0 {
    @g2
    public static final <T> T a(@os.l Object obj, @os.l jn.a<? extends T> aVar) {
        T tInvoke;
        synchronized (obj) {
            tInvoke = aVar.invoke();
        }
        return tInvoke;
    }
}
