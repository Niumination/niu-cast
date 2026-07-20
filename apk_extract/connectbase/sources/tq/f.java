package tq;

import kn.r1;
import kn.u1;
import vq.a1;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nChannelFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChannelFlow.kt\nkotlinx/coroutines/flow/internal/ChannelFlowKt\n+ 2 CoroutineContext.kt\nkotlinx/coroutines/CoroutineContextKt\n*L\n1#1,245:1\n95#2,5:246\n*S KotlinDebug\n*F\n+ 1 ChannelFlow.kt\nkotlinx/coroutines/flow/internal/ChannelFlowKt\n*L\n226#1:246,5\n*E\n"})
public final class f {
    @os.l
    public static final <T> e<T> b(@os.l sq.i<? extends T> iVar) {
        e<T> eVar = iVar instanceof e ? (e) iVar : null;
        return eVar == null ? new i(iVar, null, 0, null, 14, null) : eVar;
    }

    @os.m
    public static final <T, V> Object c(@os.l um.g gVar, V v10, @os.l Object obj, @os.l jn.p<? super V, ? super um.d<? super T>, ? extends Object> pVar, @os.l um.d<? super T> dVar) {
        Object objC = a1.c(gVar, obj);
        try {
            Object objInvoke = ((jn.p) u1.q(pVar, 2)).invoke(v10, new z(dVar, gVar));
            a1.a(gVar, objC);
            if (objInvoke == wm.a.COROUTINE_SUSPENDED) {
                xm.h.c(dVar);
            }
            return objInvoke;
        } catch (Throwable th2) {
            a1.a(gVar, objC);
            throw th2;
        }
    }

    public static /* synthetic */ Object d(um.g gVar, Object obj, Object obj2, jn.p pVar, um.d dVar, int i10, Object obj3) {
        if ((i10 & 4) != 0) {
            obj2 = a1.b(gVar);
        }
        return c(gVar, obj, obj2, pVar, dVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> sq.j<T> e(sq.j<? super T> jVar, um.g gVar) {
        return jVar instanceof y ? true : jVar instanceof t ? jVar : new b0(jVar, gVar);
    }
}
