package pl;

import lm.d1;
import lm.l2;
import lm.z0;

/* JADX INFO: loaded from: classes2.dex */
public final class o0 {

    @xm.f(c = "io.ktor.utils.io.WriterSessionKt", f = "WriterSession.kt", i = {0}, l = {81}, m = "completeWritingFallback", n = {"buffer"}, s = {"L$0"})
    public static final class a extends xm.d {
        Object L$0;
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
            return o0.d(null, null, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.WriterSessionKt", f = "WriterSession.kt", i = {0, 0}, l = {22, 29, 29}, m = "write", n = {"$this$write", "block"}, s = {"L$0", "L$1"})
    public static final class b extends xm.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public b(um.d<? super b> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return o0.f(null, 0, null, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.WriterSessionKt", f = "WriterSession.kt", i = {0, 0}, l = {ms.a.T}, m = "writeBufferSuspend", n = {"session", "desiredSpace"}, s = {"L$0", "I$0"})
    public static final class c extends xm.d {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public c(um.d<? super c> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return o0.j(null, 0, this);
        }
    }

    @os.m
    @z0
    public static final Object c(@os.l n nVar, @os.l tl.e eVar, int i10, @os.l um.d<? super l2> dVar) {
        if (nVar instanceof a0) {
            ((a0) nVar).W(i10);
            return l2.f10208a;
        }
        Object objD = d(nVar, eVar, dVar);
        return objD == wm.a.COROUTINE_SUSPENDED ? objD : l2.f10208a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object d(n nVar, tl.e eVar, um.d<? super l2> dVar) {
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
        Object obj2 = wm.a.COROUTINE_SUSPENDED;
        int i11 = aVar.label;
        if (i11 == 0) {
            d1.n(obj);
            if (!(eVar instanceof tl.o0)) {
                throw new UnsupportedOperationException("Only IoBuffer instance is supported.");
            }
            aVar.L$0 = eVar;
            aVar.label = 1;
            if (nVar.m0((tl.o0) eVar, aVar) == obj2) {
                return obj2;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            eVar = (tl.e) aVar.L$0;
            d1.n(obj);
        }
        tl.o0.H.getClass();
        ((tl.o0) eVar).j2(tl.o0.M);
        return l2.f10208a;
    }

    @os.m
    @z0
    public static final Object e(@os.l n nVar, int i10, @os.l um.d<? super tl.e> dVar) {
        p0 p0VarV = nVar instanceof a0 ? ((a0) nVar).V() : null;
        if (p0VarV == null) {
            return i();
        }
        tl.o0 o0VarB = p0VarV.b(i10);
        return o0VarB != null ? o0VarB : j(p0VarV, i10, dVar);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @os.m
    @tl.f0
    public static final Object f(@os.l n nVar, int i10, @os.l jn.q<? super ql.f, ? super Long, ? super Long, Integer> qVar, @os.l um.d<? super Integer> dVar) throws Throwable {
        b bVar;
        if (dVar instanceof b) {
            bVar = (b) dVar;
            int i11 = bVar.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                bVar.label = i11 - Integer.MIN_VALUE;
            } else {
                bVar = new b(dVar);
            }
        } else {
            bVar = new b(dVar);
        }
        Object objE = bVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i12 = bVar.label;
        if (i12 == 0) {
            d1.n(objE);
            bVar.L$0 = nVar;
            bVar.L$1 = qVar;
            bVar.label = 1;
            objE = e(nVar, i10, bVar);
            if (objE == aVar) {
                return aVar;
            }
        } else {
            if (i12 != 1) {
                if (i12 == 2) {
                    Integer num = (Integer) bVar.L$0;
                    d1.n(objE);
                    return num;
                }
                if (i12 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Throwable th2 = (Throwable) bVar.L$0;
                d1.n(objE);
                throw th2;
            }
            qVar = (jn.q) bVar.L$1;
            nVar = (n) bVar.L$0;
            d1.n(objE);
        }
        tl.e eVarA = (tl.e) objE;
        if (eVarA == null) {
            eVarA = tl.e.f15818d.a();
        }
        int iIntValue = 0;
        try {
            iIntValue = qVar.invoke(ql.f.b(eVarA.f15820a), new Long(eVarA.f15821b.f15874c), new Long(eVarA.f15821b.f15872a)).intValue();
            eVarA.b(iIntValue);
            Integer num2 = new Integer(iIntValue);
            bVar.L$0 = num2;
            bVar.L$1 = null;
            bVar.label = 2;
            return c(nVar, eVarA, iIntValue, bVar) == aVar ? aVar : num2;
        } catch (Throwable th3) {
            bVar.L$0 = th3;
            bVar.L$1 = null;
            bVar.label = 3;
            if (c(nVar, eVarA, iIntValue, bVar) == aVar) {
                return aVar;
            }
            throw th3;
        }
    }

    @tl.f0
    public static final Object g(n nVar, int i10, jn.q<? super ql.f, ? super Long, ? super Long, Integer> qVar, um.d<? super Integer> dVar) {
        tl.e eVarA = (tl.e) e(nVar, i10, dVar);
        if (eVarA == null) {
            eVarA = tl.e.f15818d.a();
        }
        int iIntValue = 0;
        try {
            iIntValue = qVar.invoke(ql.f.b(eVarA.f15820a), Long.valueOf(eVarA.f15821b.f15874c), Long.valueOf(eVarA.f15821b.f15872a)).intValue();
            eVarA.b(iIntValue);
            return Integer.valueOf(iIntValue);
        } finally {
            c(nVar, eVarA, iIntValue, dVar);
        }
    }

    public static Object h(n nVar, int i10, jn.q qVar, um.d dVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 1;
        }
        tl.e eVarA = (tl.e) e(nVar, i10, dVar);
        if (eVarA == null) {
            eVarA = tl.e.f15818d.a();
        }
        int iIntValue = 0;
        try {
            iIntValue = ((Number) qVar.invoke(ql.f.b(eVarA.f15820a), Long.valueOf(eVarA.f15821b.f15874c), Long.valueOf(eVarA.f15821b.f15872a))).intValue();
            eVarA.b(iIntValue);
            return Integer.valueOf(iIntValue);
        } finally {
            c(nVar, eVarA, iIntValue, dVar);
        }
    }

    public static final tl.e i() {
        ul.b.f16311i.getClass();
        Object objW0 = ul.b.f16315w.W0();
        ul.b bVar = (ul.b) objW0;
        bVar.v0();
        bVar.p0(8);
        return (tl.e) objW0;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object j(p0 p0Var, int i10, um.d<? super tl.e> dVar) {
        c cVar;
        if (dVar instanceof c) {
            cVar = (c) dVar;
            int i11 = cVar.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                cVar.label = i11 - Integer.MIN_VALUE;
            } else {
                cVar = new c(dVar);
            }
        } else {
            cVar = new c(dVar);
        }
        Object obj = cVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i12 = cVar.label;
        if (i12 == 0) {
            d1.n(obj);
            cVar.L$0 = p0Var;
            cVar.I$0 = i10;
            cVar.label = 1;
            if (p0Var.c(i10, cVar) == aVar) {
                return aVar;
            }
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i10 = cVar.I$0;
            p0Var = (p0) cVar.L$0;
            d1.n(obj);
        }
        tl.o0 o0VarB = p0Var.b(i10);
        return o0VarB == null ? p0Var.b(1) : o0VarB;
    }

    public static final p0 k(n nVar) {
        if (nVar instanceof a0) {
            return ((a0) nVar).V();
        }
        return null;
    }
}
