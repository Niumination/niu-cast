package pl;

import java.io.EOFException;
import lm.d1;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class m {

    @xm.f(c = "io.ktor.utils.io.ByteReadChannelKt", f = "ByteReadChannel.kt", i = {0}, l = {271}, m = "copyAndClose", n = {"dst"}, s = {"L$0"})
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
            return m.b(null, null, 0L, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteReadChannelKt", f = "ByteReadChannel.kt", i = {0}, l = {242}, m = "discardExact", n = {p6.n.f13005a}, s = {"J$0"})
    public static final class b extends xm.d {
        long J$0;
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
            return m.f(null, 0L, this);
        }
    }

    public static final boolean a(@os.l k kVar) {
        kn.l0.p(kVar, "<this>");
        return kVar.c(null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @os.m
    public static final Object b(@os.l k kVar, @os.l n nVar, long j10, @os.l um.d<? super Long> dVar) {
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
        Object objC = aVar.result;
        wm.a aVar2 = wm.a.COROUTINE_SUSPENDED;
        int i11 = aVar.label;
        if (i11 == 0) {
            d1.n(objC);
            aVar.L$0 = nVar;
            aVar.label = 1;
            objC = l.c(kVar, nVar, j10, aVar);
            if (objC == aVar2) {
                return aVar2;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            nVar = (n) aVar.L$0;
            d1.n(objC);
        }
        long jLongValue = ((Number) objC).longValue();
        o.a(nVar);
        return new Long(jLongValue);
    }

    public static /* synthetic */ Object c(k kVar, n nVar, long j10, um.d dVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = Long.MAX_VALUE;
        }
        return b(kVar, nVar, j10, dVar);
    }

    @os.m
    public static final Object d(@os.l k kVar, @os.l n nVar, @os.l um.d<? super Long> dVar) {
        return l.c(kVar, nVar, Long.MAX_VALUE, dVar);
    }

    @os.m
    public static final Object e(@os.l k kVar, @os.l um.d<? super Long> dVar) {
        return kVar.P(Long.MAX_VALUE, dVar);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @os.m
    public static final Object f(@os.l k kVar, long j10, @os.l um.d<? super l2> dVar) throws EOFException {
        b bVar;
        if (dVar instanceof b) {
            bVar = (b) dVar;
            int i10 = bVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                bVar.label = i10 - Integer.MIN_VALUE;
            } else {
                bVar = new b(dVar);
            }
        } else {
            bVar = new b(dVar);
        }
        Object objP = bVar.result;
        Object obj = wm.a.COROUTINE_SUSPENDED;
        int i11 = bVar.label;
        if (i11 == 0) {
            d1.n(objP);
            bVar.J$0 = j10;
            bVar.label = 1;
            objP = kVar.P(j10, bVar);
            if (objP == obj) {
                return obj;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j10 = bVar.J$0;
            d1.n(objP);
        }
        if (((Number) objP).longValue() == j10) {
            return l2.f10208a;
        }
        throw new EOFException(j1.g.a("Unable to discard ", j10, " bytes"));
    }

    public static final Object g(k kVar, long j10, um.d<? super l2> dVar) throws EOFException {
        if (((Number) kVar.P(j10, dVar)).longValue() == j10) {
            return l2.f10208a;
        }
        throw new EOFException(j1.g.a("Unable to discard ", j10, " bytes"));
    }

    @os.m
    public static final Object h(@os.l k kVar, @os.l byte[] bArr, @os.l um.d<? super Integer> dVar) {
        return kVar.v(bArr, 0, bArr.length, dVar);
    }

    @os.m
    public static final Object i(@os.l k kVar, @os.l tl.o0 o0Var, @os.l um.d<? super l2> dVar) {
        tl.m mVar = o0Var.f15821b;
        Object objY = kVar.y(o0Var, mVar.f15872a - mVar.f15874c, dVar);
        return objY == wm.a.COROUTINE_SUSPENDED ? objY : l2.f10208a;
    }

    @os.m
    public static final Object j(@os.l k kVar, @os.l byte[] bArr, @os.l um.d<? super l2> dVar) {
        Object objL = kVar.l(bArr, 0, bArr.length, dVar);
        return objL == wm.a.COROUTINE_SUSPENDED ? objL : l2.f10208a;
    }

    @os.m
    public static final Object k(@os.l k kVar, int i10, @os.l um.d<? super tl.v> dVar) {
        return kVar.u(i10, 0, dVar);
    }

    @os.m
    public static final Object l(@os.l k kVar, long j10, @os.l um.d<? super tl.v> dVar) {
        return kVar.E(j10, 0, dVar);
    }

    @os.m
    public static final Object m(@os.l k kVar, @os.l um.d<? super tl.v> dVar) {
        return kVar.E(Long.MAX_VALUE, 0, dVar);
    }

    @os.m
    public static final Object n(@os.l k kVar, @os.l um.d<? super String> dVar) {
        return kVar.c0(Integer.MAX_VALUE, dVar);
    }

    @os.m
    public static final Object o(@os.l k kVar, @os.l Appendable appendable, @os.l um.d<? super Boolean> dVar) {
        return kVar.O(appendable, Integer.MAX_VALUE, dVar);
    }
}
