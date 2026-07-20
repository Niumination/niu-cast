package pq;

import kn.n0;
import kn.r1;
import lm.c1;
import lm.d1;
import lm.l2;
import nq.a2;
import nq.g2;
import nq.m0;
import nq.s0;
import nq.u0;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nProduce.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Produce.kt\nkotlinx/coroutines/channels/ProduceKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,151:1\n1#2:152\n314#3,11:153\n*S KotlinDebug\n*F\n+ 1 Produce.kt\nkotlinx/coroutines/channels/ProduceKt\n*L\n48#1:153,11\n*E\n"})
public final class b0 {

    @xm.f(c = "kotlinx.coroutines.channels.ProduceKt", f = "Produce.kt", i = {0, 0}, l = {153}, m = "awaitClose", n = {"$this$awaitClose", "block"}, s = {"L$0", "L$1"})
    public static final class a extends xm.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public a(um.d<? super a> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return b0.a(null, null, this);
        }
    }

    public static final class b extends n0 implements jn.a<l2> {
        public static final b INSTANCE = new b();

        public b() {
            super(0);
        }

        @Override // jn.a
        public /* bridge */ /* synthetic */ l2 invoke() {
            invoke2();
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }
    }

    public static final class c extends n0 implements jn.l<Throwable, l2> {
        final /* synthetic */ nq.p<l2> $cont;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public c(nq.p<? super l2> pVar) {
            super(1);
            this.$cont = pVar;
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(Throwable th2) {
            invoke2(th2);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.m Throwable th2) {
            nq.p<l2> pVar = this.$cont;
            c1.a aVar = c1.Companion;
            pVar.resumeWith(c1.m59constructorimpl(l2.f10208a));
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @os.m
    public static final Object a(@os.l d0<?> d0Var, @os.l jn.a<l2> aVar, @os.l um.d<? super l2> dVar) {
        a aVar2;
        if (dVar instanceof a) {
            aVar2 = (a) dVar;
            int i10 = aVar2.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                aVar2.label = i10 - Integer.MIN_VALUE;
            } else {
                aVar2 = new a(dVar);
            }
        } else {
            aVar2 = new a(dVar);
        }
        Object obj = aVar2.result;
        wm.a aVar3 = wm.a.COROUTINE_SUSPENDED;
        int i11 = aVar2.label;
        try {
            if (i11 == 0) {
                d1.n(obj);
                if (aVar2.getContext().get(nq.l2.f11882k) != d0Var) {
                    throw new IllegalStateException("awaitClose() can only be invoked from the producer context");
                }
                aVar2.L$0 = d0Var;
                aVar2.L$1 = aVar;
                aVar2.label = 1;
                nq.q qVar = new nq.q(wm.c.e(aVar2), 1);
                qVar.F();
                d0Var.i(new c(qVar));
                Object objZ = qVar.z();
                if (objZ == aVar3) {
                    xm.h.c(aVar2);
                }
                if (objZ == aVar3) {
                    return aVar3;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                aVar = (jn.a) aVar2.L$1;
                d1.n(obj);
            }
            aVar.invoke();
            return l2.f10208a;
        } catch (Throwable th2) {
            aVar.invoke();
            throw th2;
        }
    }

    public static /* synthetic */ Object b(d0 d0Var, jn.a aVar, um.d dVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            aVar = b.INSTANCE;
        }
        return a(d0Var, aVar, dVar);
    }

    @a2
    @os.l
    public static final <E> f0<E> c(@os.l s0 s0Var, @os.l um.g gVar, int i10, @lm.b @os.l jn.p<? super d0<? super E>, ? super um.d<? super l2>, ? extends Object> pVar) {
        return e(s0Var, gVar, i10, i.SUSPEND, u0.DEFAULT, null, pVar);
    }

    @g2
    @os.l
    public static final <E> f0<E> d(@os.l s0 s0Var, @os.l um.g gVar, int i10, @os.l u0 u0Var, @os.m jn.l<? super Throwable, l2> lVar, @lm.b @os.l jn.p<? super d0<? super E>, ? super um.d<? super l2>, ? extends Object> pVar) {
        return e(s0Var, gVar, i10, i.SUSPEND, u0Var, lVar, pVar);
    }

    @os.l
    public static final <E> f0<E> e(@os.l s0 s0Var, @os.l um.g gVar, int i10, @os.l i iVar, @os.l u0 u0Var, @os.m jn.l<? super Throwable, l2> lVar, @lm.b @os.l jn.p<? super d0<? super E>, ? super um.d<? super l2>, ? extends Object> pVar) {
        c0 c0Var = new c0(m0.d(s0Var, gVar), o.d(i10, iVar, null, 4, null), true, true);
        if (lVar != null) {
            c0Var.k0(lVar);
        }
        u0Var.invoke(pVar, c0Var, c0Var);
        return c0Var;
    }

    public static /* synthetic */ f0 f(s0 s0Var, um.g gVar, int i10, jn.p pVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            gVar = um.i.INSTANCE;
        }
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        return c(s0Var, gVar, i10, pVar);
    }

    public static f0 g(s0 s0Var, um.g gVar, int i10, u0 u0Var, jn.l lVar, jn.p pVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            gVar = um.i.INSTANCE;
        }
        um.g gVar2 = gVar;
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        int i12 = i10;
        if ((i11 & 4) != 0) {
            u0Var = u0.DEFAULT;
        }
        u0 u0Var2 = u0Var;
        if ((i11 & 8) != 0) {
            lVar = null;
        }
        return e(s0Var, gVar2, i12, i.SUSPEND, u0Var2, lVar, pVar);
    }

    public static /* synthetic */ f0 h(s0 s0Var, um.g gVar, int i10, i iVar, u0 u0Var, jn.l lVar, jn.p pVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            gVar = um.i.INSTANCE;
        }
        um.g gVar2 = gVar;
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        int i12 = i10;
        if ((i11 & 4) != 0) {
            iVar = i.SUSPEND;
        }
        i iVar2 = iVar;
        if ((i11 & 8) != 0) {
            u0Var = u0.DEFAULT;
        }
        u0 u0Var2 = u0Var;
        if ((i11 & 16) != 0) {
            lVar = null;
        }
        return e(s0Var, gVar2, i12, iVar2, u0Var2, lVar, pVar);
    }
}
