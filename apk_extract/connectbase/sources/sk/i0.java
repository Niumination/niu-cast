package sk;

import lm.d1;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class i0 {

    @xm.f(c = "io.ktor.network.sockets.SocketsKt", f = "Sockets.kt", i = {0}, l = {39}, m = "awaitClosed", n = {"$this$awaitClosed"}, s = {"L$0"})
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
            return i0.a(null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @os.m
    public static final Object a(@os.l d dVar, @os.l um.d<? super l2> dVar2) {
        a aVar;
        if (dVar2 instanceof a) {
            aVar = (a) dVar2;
            int i10 = aVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                aVar.label = i10 - Integer.MIN_VALUE;
            } else {
                aVar = new a(dVar2);
            }
        } else {
            aVar = new a(dVar2);
        }
        Object obj = aVar.result;
        wm.a aVar2 = wm.a.COROUTINE_SUSPENDED;
        int i11 = aVar.label;
        if (i11 == 0) {
            d1.n(obj);
            nq.l2 l2VarO1 = dVar.O1();
            aVar.L$0 = dVar;
            aVar.label = 1;
            if (l2VarO1.t(aVar) == aVar2) {
                return aVar2;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            dVar = (d) aVar.L$0;
            d1.n(obj);
        }
        if (dVar.O1().isCancelled()) {
            throw dVar.O1().O();
        }
        return l2.f10208a;
    }

    @os.l
    public static final n b(@os.l b0 b0Var) {
        kn.l0.p(b0Var, "<this>");
        return new n(b0Var, d(b0Var), f(b0Var, false, 1, null));
    }

    public static final boolean c(@os.l d dVar) {
        kn.l0.p(dVar, "<this>");
        return dVar.O1().isCompleted();
    }

    @os.l
    public static final pl.k d(@os.l c cVar) {
        kn.l0.p(cVar, "<this>");
        pl.c cVarA = pl.e.a(false);
        cVar.b(cVarA);
        return cVarA;
    }

    @os.l
    public static final pl.n e(@os.l e eVar, boolean z10) {
        kn.l0.p(eVar, "<this>");
        pl.c cVarA = pl.e.a(z10);
        eVar.p(cVarA);
        return cVarA;
    }

    public static /* synthetic */ pl.n f(e eVar, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return e(eVar, z10);
    }
}
