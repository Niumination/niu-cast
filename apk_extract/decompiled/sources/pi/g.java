package pi;

import java.util.ArrayList;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import li.h0;
import ni.d0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class g implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineContext f8897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ni.c f8899c;

    public g(CoroutineContext coroutineContext, int i8, ni.c cVar) {
        this.f8897a = coroutineContext;
        this.f8898b = i8;
        this.f8899c = cVar;
    }

    @Override // oi.h
    public Object a(oi.i iVar, Continuation continuation) {
        Object objC = h0.c(new e(iVar, this, null), continuation);
        return objC == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objC : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0015  */
    @Override // pi.s
    public final oi.h b(CoroutineContext coroutineContext, int i8, ni.c cVar) {
        CoroutineContext coroutineContext2 = this.f8897a;
        CoroutineContext coroutineContextPlus = coroutineContext.plus(coroutineContext2);
        ni.c cVar2 = ni.c.SUSPEND;
        ni.c cVar3 = this.f8899c;
        int i9 = this.f8898b;
        if (cVar == cVar2) {
            if (i9 != -3) {
                if (i8 == -3) {
                    i8 = i9;
                } else if (i9 != -2) {
                    if (i8 == -2) {
                        i8 = i9;
                    } else {
                        i8 += i9;
                        if (i8 < 0) {
                            i8 = Integer.MAX_VALUE;
                        }
                    }
                }
            }
            cVar = cVar3;
        }
        return (Intrinsics.areEqual(coroutineContextPlus, coroutineContext2) && i8 == i9 && cVar == cVar3) ? this : d(coroutineContextPlus, i8, cVar);
    }

    public abstract Object c(d0 d0Var, Continuation continuation);

    public abstract g d(CoroutineContext coroutineContext, int i8, ni.c cVar);

    public String toString() {
        ArrayList arrayList = new ArrayList(4);
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        CoroutineContext coroutineContext = this.f8897a;
        if (coroutineContext != emptyCoroutineContext) {
            arrayList.add("context=" + coroutineContext);
        }
        int i8 = this.f8898b;
        if (i8 != -3) {
            arrayList.add("capacity=" + i8);
        }
        ni.c cVar = ni.c.SUSPEND;
        ni.c cVar2 = this.f8899c;
        if (cVar2 != cVar) {
            arrayList.add("onBufferOverflow=" + cVar2);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getSimpleName());
        sb2.append('[');
        return a1.a.s(sb2, CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", null, null, 0, null, null, 62, null), ']');
    }
}
