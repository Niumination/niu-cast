package pl;

import java.nio.ByteBuffer;
import lm.d1;
import lm.l2;
import lm.z0;

/* JADX INFO: loaded from: classes2.dex */
public final class g0 {

    @xm.f(c = "io.ktor.utils.io.ReadSessionKt", f = "ReadSession.kt", i = {0, 0, 1, 1, 1, 2}, l = {24, 28, 31}, m = "read", n = {"$this$read", "block", "$this$read", "buffer", "bytesRead", "cause"}, s = {"L$0", "L$1", "L$0", "L$1", "I$0", "L$0"})
    public static final class a extends xm.d {
        int I$0;
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
            return g0.d(null, 0, null, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ReadSessionKt", f = "ReadSession.kt", i = {0}, l = {131}, m = "requestBufferFallback", n = {"chunk"}, s = {"L$0"})
    public static final class b extends xm.d {
        Object L$0;
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
            return g0.i(null, 0, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ReadSessionKt", f = "ReadSession.kt", i = {0}, l = {124}, m = "requestBufferSuspend", n = {"$this$requestBufferSuspend"}, s = {"L$0"})
    public static final class c extends xm.d {
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
            return g0.j(null, 0, this);
        }
    }

    @os.m
    @z0
    public static final Object c(@os.l k kVar, @os.m tl.e eVar, int i10, @os.l um.d<? super l2> dVar) {
        if (i10 < 0) {
            throw new IllegalStateException(kn.l0.C("bytesRead shouldn't be negative: ", new Integer(i10)).toString());
        }
        boolean z10 = kVar instanceof z;
        j0 j0VarZ = z10 ? ((z) kVar).Z() : null;
        if (j0VarZ != null) {
            j0VarZ.b0(i10);
            if (z10) {
                ((z) kVar).l0();
            }
            return l2.f10208a;
        }
        if (eVar instanceof ul.b) {
            ul.b.e eVar2 = ul.b.f16311i;
            if (eVar != eVar2.a()) {
                eVar2.getClass();
                ((ul.b) eVar).j2(ul.b.f16315w);
                Object objP = kVar.P(i10, dVar);
                return objP == wm.a.COROUTINE_SUSPENDED ? objP : l2.f10208a;
            }
        }
        return l2.f10208a;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00c2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:45:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @os.m
    @tl.f0
    public static final Object d(@os.l k kVar, int i10, @os.l jn.q<? super ql.f, ? super Long, ? super Long, Integer> qVar, @os.l um.d<? super Integer> dVar) throws Throwable {
        a aVar;
        tl.e eVarA;
        k kVar2;
        Throwable th2;
        int i11;
        if (dVar instanceof a) {
            aVar = (a) dVar;
            int i12 = aVar.label;
            if ((i12 & Integer.MIN_VALUE) != 0) {
                aVar.label = i12 - Integer.MIN_VALUE;
            } else {
                aVar = new a(dVar);
            }
        } else {
            aVar = new a(dVar);
        }
        Object objH = aVar.result;
        wm.a aVar2 = wm.a.COROUTINE_SUSPENDED;
        int i13 = aVar.label;
        try {
            if (i13 == 0) {
                d1.n(objH);
                aVar.L$0 = kVar;
                aVar.L$1 = qVar;
                aVar.label = 1;
                objH = h(kVar, i10, aVar);
                if (objH == aVar2) {
                    return aVar2;
                }
            } else {
                if (i13 != 1) {
                    if (i13 != 2) {
                        if (i13 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        Throwable th3 = (Throwable) aVar.L$0;
                        d1.n(objH);
                        throw th3;
                    }
                    i11 = aVar.I$0;
                    eVarA = (tl.e) aVar.L$1;
                    kVar2 = (k) aVar.L$0;
                    try {
                        d1.n(objH);
                        return new Integer(i11);
                    } catch (Throwable th4) {
                        th2 = th4;
                        aVar.L$0 = th2;
                        aVar.L$1 = null;
                        aVar.label = 3;
                        if (c(kVar2, eVarA, 0, aVar) == aVar2) {
                            return aVar2;
                        }
                        throw th2;
                    }
                }
                qVar = (jn.q) aVar.L$1;
                kVar = (k) aVar.L$0;
                d1.n(objH);
            }
            int iIntValue = qVar.invoke(ql.f.b(eVarA.f15820a), new Long(eVarA.f15821b.f15873b), new Long(eVarA.f15821b.f15874c)).intValue();
            aVar.L$0 = kVar;
            aVar.L$1 = eVarA;
            aVar.I$0 = iIntValue;
            aVar.label = 2;
            if (c(kVar, eVarA, iIntValue, aVar) == aVar2) {
                return aVar2;
            }
            kVar2 = kVar;
            i11 = iIntValue;
            return new Integer(i11);
        } catch (Throwable th5) {
            kVar2 = kVar;
            th2 = th5;
            aVar.L$0 = th2;
            aVar.L$1 = null;
            aVar.label = 3;
            if (c(kVar2, eVarA, 0, aVar) == aVar2) {
                return aVar2;
            }
            throw th2;
        }
        tl.e eVar = (tl.e) objH;
        eVarA = eVar == null ? tl.e.f15818d.a() : eVar;
    }

    @tl.f0
    public static final Object e(k kVar, int i10, jn.q<? super ql.f, ? super Long, ? super Long, Integer> qVar, um.d<? super Integer> dVar) {
        tl.e eVarA = (tl.e) h(kVar, i10, dVar);
        if (eVarA == null) {
            eVarA = tl.e.f15818d.a();
        }
        try {
            int iIntValue = qVar.invoke(ql.f.b(eVarA.f15820a), Long.valueOf(eVarA.f15821b.f15873b), Long.valueOf(eVarA.f15821b.f15874c)).intValue();
            c(kVar, eVarA, iIntValue, dVar);
            return Integer.valueOf(iIntValue);
        } catch (Throwable th2) {
            c(kVar, eVarA, 0, dVar);
            throw th2;
        }
    }

    public static Object f(k kVar, int i10, jn.q qVar, um.d dVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 1;
        }
        tl.e eVarA = (tl.e) h(kVar, i10, dVar);
        if (eVarA == null) {
            eVarA = tl.e.f15818d.a();
        }
        try {
            int iIntValue = ((Number) qVar.invoke(ql.f.b(eVarA.f15820a), Long.valueOf(eVarA.f15821b.f15873b), Long.valueOf(eVarA.f15821b.f15874c))).intValue();
            c(kVar, eVarA, iIntValue, dVar);
            return Integer.valueOf(iIntValue);
        } catch (Throwable th2) {
            c(kVar, eVarA, 0, dVar);
            throw th2;
        }
    }

    public static final j0 g(k kVar) {
        if (kVar instanceof z) {
            return ((z) kVar).Z();
        }
        return null;
    }

    @os.m
    @z0
    public static final Object h(@os.l k kVar, int i10, @os.l um.d<? super tl.e> dVar) {
        j0 j0VarZ;
        if (kVar instanceof j0) {
            j0VarZ = (j0) kVar;
        } else {
            j0VarZ = kVar instanceof z ? ((z) kVar).Z() : null;
        }
        if (j0VarZ == null) {
            return i(kVar, i10, dVar);
        }
        tl.o0 o0VarB = j0VarZ.b(i10 <= 8 ? i10 : 8);
        return o0VarB != null ? o0VarB : j(j0VarZ, i10, dVar);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0016  */
    public static final Object i(k kVar, int i10, um.d<? super ul.b> dVar) {
        b bVar;
        ul.b bVar2;
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
        b bVar3 = bVar;
        Object obj = bVar3.result;
        Object obj2 = wm.a.COROUTINE_SUSPENDED;
        int i12 = bVar3.label;
        if (i12 == 0) {
            d1.n(obj);
            ul.b.f16311i.getClass();
            ul.b bVar4 = (ul.b) ul.b.f16315w.W0();
            ByteBuffer byteBuffer = bVar4.f15820a;
            tl.m mVar = bVar4.f15821b;
            int i13 = mVar.f15874c;
            long j10 = mVar.f15872a - i13;
            bVar3.L$0 = bVar4;
            bVar3.label = 1;
            Object objD0 = kVar.d0(byteBuffer, i13, 0L, i10, j10, bVar3);
            if (objD0 == obj2) {
                return obj2;
            }
            bVar2 = bVar4;
            obj = objD0;
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            bVar2 = (ul.b) bVar3.L$0;
            d1.n(obj);
        }
        bVar2.b((int) ((Number) obj).longValue());
        return bVar2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object j(j0 j0Var, int i10, um.d<? super tl.e> dVar) {
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
            cVar.L$0 = j0Var;
            cVar.label = 1;
            if (j0Var.w(i10, cVar) == aVar) {
                return aVar;
            }
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j0Var = (j0) cVar.L$0;
            d1.n(obj);
        }
        return j0Var.b(1);
    }
}
