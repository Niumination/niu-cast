package nq;

/* JADX INFO: loaded from: classes3.dex */
@kn.r1({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/DelayKt\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,162:1\n314#2,11:163\n314#2,11:174\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/DelayKt\n*L\n106#1:163,11\n127#1:174,11\n*E\n"})
public final class d1 {

    @xm.f(c = "kotlinx.coroutines.DelayKt", f = "Delay.kt", i = {}, l = {163}, m = "awaitCancellation", n = {}, s = {})
    public static final class a extends xm.d {
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
            return d1.a(this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @os.m
    public static final Object a(@os.l um.d<?> dVar) {
        a aVar;
        if (dVar instanceof a) {
            aVar = (a) dVar;
            int i10 = aVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                aVar.label = i10 - Integer.MIN_VALUE;
            } else {
                aVar = new a(dVar);
            }
        } else {
            aVar = new a(dVar);
        }
        Object obj = aVar.result;
        wm.a aVar2 = wm.a.COROUTINE_SUSPENDED;
        int i11 = aVar.label;
        if (i11 == 0) {
            lm.d1.n(obj);
            aVar.label = 1;
            q qVar = new q(wm.c.e(aVar), 1);
            qVar.F();
            Object objZ = qVar.z();
            if (objZ == aVar2) {
                xm.h.c(aVar);
            }
            if (objZ == aVar2) {
                return aVar2;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            lm.d1.n(obj);
        }
        throw new lm.y();
    }

    @os.m
    public static final Object b(long j10, @os.l um.d<? super lm.l2> dVar) {
        if (j10 <= 0) {
            return lm.l2.f10208a;
        }
        q qVar = new q(wm.c.e(dVar), 1);
        qVar.F();
        if (j10 < Long.MAX_VALUE) {
            d(qVar.getContext()).b0(j10, qVar);
        }
        Object objZ = qVar.z();
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        if (objZ == aVar) {
            xm.h.c(dVar);
        }
        return objZ == aVar ? objZ : lm.l2.f10208a;
    }

    @os.m
    public static final Object c(long j10, @os.l um.d<? super lm.l2> dVar) {
        Object objB = b(e(j10), dVar);
        return objB == wm.a.COROUTINE_SUSPENDED ? objB : lm.l2.f10208a;
    }

    @os.l
    public static final c1 d(@os.l um.g gVar) {
        um.g.b bVar = gVar.get(um.e.G);
        c1 c1Var = bVar instanceof c1 ? (c1) bVar : null;
        return c1Var == null ? z0.a() : c1Var;
    }

    public static final long e(long j10) {
        lq.e.f10247b.getClass();
        if (lq.e.m(j10, lq.e.f10248c) > 0) {
            return tn.u.v(lq.e.N(j10), 1L);
        }
        return 0L;
    }
}
