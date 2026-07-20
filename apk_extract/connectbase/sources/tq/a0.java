package tq;

import kn.r1;
import sq.k0;
import sq.u0;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nAbstractSharedFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractSharedFlow.kt\nkotlinx/coroutines/flow/internal/SubscriptionCountStateFlow\n+ 2 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 3 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n*L\n1#1,132:1\n28#2,4:133\n28#2,4:138\n20#3:137\n20#3:142\n*S KotlinDebug\n*F\n+ 1 AbstractSharedFlow.kt\nkotlinx/coroutines/flow/internal/SubscriptionCountStateFlow\n*L\n126#1:133,4\n128#1:138,4\n126#1:137\n128#1:142\n*E\n"})
public final class a0 extends k0<Integer> implements u0<Integer> {
    public a0(int i10) {
        super(1, Integer.MAX_VALUE, pq.i.DROP_OLDEST);
        b(Integer.valueOf(i10));
    }

    @Override // sq.u0
    @os.l
    /* JADX INFO: renamed from: d0, reason: merged with bridge method [inline-methods] */
    public Integer getValue() {
        Integer numValueOf;
        synchronized (this) {
            numValueOf = Integer.valueOf(P().intValue());
        }
        return numValueOf;
    }

    public final boolean e0(int i10) {
        boolean zB;
        synchronized (this) {
            zB = b(Integer.valueOf(P().intValue() + i10));
        }
        return zB;
    }
}
