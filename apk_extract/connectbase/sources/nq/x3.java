package nq;

/* JADX INFO: loaded from: classes3.dex */
public final class x3 {

    @xm.f(c = "kotlinx.coroutines.TimeoutKt", f = "Timeout.kt", i = {0, 0, 0}, l = {104}, m = "withTimeoutOrNull", n = {"block", "coroutine", "timeMillis"}, s = {"L$0", "L$1", "J$0"})
    public static final class a<T> extends xm.d {
        long J$0;
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
            return x3.e(0L, null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0018  */
    @os.l
    public static final v3 a(long j10, @os.l c1 c1Var, @os.l l2 l2Var) {
        String strA;
        e1 e1Var = c1Var instanceof e1 ? (e1) c1Var : null;
        if (e1Var != null) {
            lq.e.a aVar = lq.e.f10247b;
            strA = e1Var.d(lq.g.n0(j10, lq.h.MILLISECONDS));
            if (strA == null) {
                strA = j1.g.a("Timed out waiting for ", j10, " ms");
            }
        } else {
            strA = j1.g.a("Timed out waiting for ", j10, " ms");
        }
        return new v3(strA, l2Var);
    }

    public static final <U, T extends U> Object b(w3<U, ? super T> w3Var, jn.p<? super s0, ? super um.d<? super T>, ? extends Object> pVar) {
        r2.w(w3Var, d1.d(w3Var.f17874d.getContext()).E(w3Var.f11983e, w3Var, w3Var.f11822c));
        return wq.b.f(w3Var, w3Var, pVar);
    }

    @os.m
    public static final <T> Object c(long j10, @os.l jn.p<? super s0, ? super um.d<? super T>, ? extends Object> pVar, @os.l um.d<? super T> dVar) {
        if (j10 <= 0) {
            throw new v3("Timed out immediately");
        }
        Object objB = b(new w3(j10, dVar), pVar);
        if (objB == wm.a.COROUTINE_SUSPENDED) {
            xm.h.c(dVar);
        }
        return objB;
    }

    @os.m
    public static final <T> Object d(long j10, @os.l jn.p<? super s0, ? super um.d<? super T>, ? extends Object> pVar, @os.l um.d<? super T> dVar) {
        return c(d1.e(j10), pVar, dVar);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, nq.w3] */
    @os.m
    public static final <T> Object e(long j10, @os.l jn.p<? super s0, ? super um.d<? super T>, ? extends Object> pVar, @os.l um.d<? super T> dVar) {
        a aVar;
        kn.k1.h hVar;
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
            if (j10 <= 0) {
                return null;
            }
            kn.k1.h hVar2 = new kn.k1.h();
            try {
                aVar.L$0 = pVar;
                aVar.L$1 = hVar2;
                aVar.J$0 = j10;
                aVar.label = 1;
                ?? r10 = (T) new w3(j10, aVar);
                hVar2.element = r10;
                Object objB = b(r10, pVar);
                if (objB == aVar2) {
                    xm.h.c(aVar);
                }
                return objB == aVar2 ? aVar2 : objB;
            } catch (v3 e10) {
                e = e10;
                hVar = hVar2;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            hVar = (kn.k1.h) aVar.L$1;
            try {
                lm.d1.n(obj);
                return obj;
            } catch (v3 e11) {
                e = e11;
            }
        }
        if (e.coroutine == hVar.element) {
            return null;
        }
        throw e;
    }

    @os.m
    public static final <T> Object f(long j10, @os.l jn.p<? super s0, ? super um.d<? super T>, ? extends Object> pVar, @os.l um.d<? super T> dVar) {
        return e(d1.e(j10), pVar, dVar);
    }
}
