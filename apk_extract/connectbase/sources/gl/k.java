package gl;

import kn.l0;
import lm.d1;
import lm.l2;
import os.m;
import pl.n;
import pl.o;
import tl.v;

/* JADX INFO: loaded from: classes2.dex */
public final class k {

    @xm.f(c = "io.ktor.util.cio.ReadersKt", f = "Readers.kt", i = {}, l = {15}, m = "toByteArray", n = {}, s = {})
    public static final class a extends xm.d {
        int label;
        /* synthetic */ Object result;

        public a(um.d<? super a> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return k.a(null, 0, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @m
    public static final Object a(@os.l pl.k kVar, int i10, @os.l um.d<? super byte[]> dVar) {
        a aVar;
        if (dVar instanceof a) {
            aVar = (a) dVar;
            int i11 = aVar.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                aVar.label = i11 - Integer.MIN_VALUE;
            } else {
                aVar = new a(dVar);
            }
        } else {
            aVar = new a(dVar);
        }
        Object objE = aVar.result;
        Object obj = wm.a.COROUTINE_SUSPENDED;
        int i12 = aVar.label;
        if (i12 == 0) {
            d1.n(objE);
            aVar.label = 1;
            objE = kVar.E(i10, 0, aVar);
            if (objE == obj) {
                return obj;
            }
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d1.n(objE);
        }
        return tl.d1.i((v) objE, 0, 1, null);
    }

    public static /* synthetic */ Object b(pl.k kVar, int i10, um.d dVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = Integer.MAX_VALUE;
        }
        return a(kVar, i10, dVar);
    }

    public static final void c(@os.l n nVar, @os.l jn.l<? super n, l2> lVar) {
        l0.p(nVar, "<this>");
        l0.p(lVar, "block");
        try {
            lVar.invoke(nVar);
            o.a(nVar);
        } catch (Throwable th2) {
            try {
                nVar.f(th2);
                throw th2;
            } catch (Throwable th3) {
                o.a(nVar);
                throw th3;
            }
        }
    }
}
