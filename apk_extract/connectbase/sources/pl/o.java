package pl;

import lm.d1;
import lm.l2;
import tl.w0;

/* JADX INFO: loaded from: classes2.dex */
public final class o {

    @xm.f(c = "io.ktor.utils.io.ByteWriteChannelKt", f = "ByteWriteChannel.kt", i = {0}, l = {221, 221}, m = "writePacketSuspend", n = {"builder$iv"}, s = {"L$0"})
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
            return o.l(null, null, this);
        }
    }

    public static final boolean a(@os.l n nVar) {
        kn.l0.p(nVar, "<this>");
        return nVar.f(null);
    }

    @os.m
    public static final Object b(@os.l n nVar, @os.l byte[] bArr, @os.l um.d<? super Integer> dVar) {
        return nVar.s(bArr, 0, bArr.length, dVar);
    }

    @os.m
    public static final Object c(@os.l n nVar, boolean z10, @os.l um.d<? super l2> dVar) {
        Object objH = nVar.H(z10 ? (byte) 1 : (byte) 0, dVar);
        return objH == wm.a.COROUTINE_SUSPENDED ? objH : l2.f10208a;
    }

    @os.m
    public static final Object d(@os.l n nVar, int i10, @os.l um.d<? super l2> dVar) {
        Object objH = nVar.H((byte) (i10 & 255), dVar);
        return objH == wm.a.COROUTINE_SUSPENDED ? objH : l2.f10208a;
    }

    @os.m
    public static final Object e(@os.l n nVar, char c10, @os.l um.d<? super l2> dVar) {
        Object objN = n(nVar, c10, dVar);
        return objN == wm.a.COROUTINE_SUSPENDED ? objN : l2.f10208a;
    }

    @os.m
    public static final Object f(@os.l n nVar, @os.l byte[] bArr, @os.l um.d<? super l2> dVar) {
        Object objI = nVar.i(bArr, 0, bArr.length, dVar);
        return objI == wm.a.COROUTINE_SUSPENDED ? objI : l2.f10208a;
    }

    @os.m
    public static final Object g(@os.l n nVar, long j10, @os.l tl.q qVar, @os.l um.d<? super l2> dVar) {
        Object objB = q.B(nVar, (int) j10, qVar, dVar);
        return objB == wm.a.COROUTINE_SUSPENDED ? objB : l2.f10208a;
    }

    @os.m
    public static final Object h(@os.l n nVar, long j10, @os.l um.d<? super l2> dVar) {
        Object objH0 = nVar.h0((int) j10, dVar);
        return objH0 == wm.a.COROUTINE_SUSPENDED ? objH0 : l2.f10208a;
    }

    @os.m
    public static final Object i(@os.l n nVar, int i10, @os.l jn.l<? super tl.s, l2> lVar, @os.l um.d<? super l2> dVar) {
        tl.s sVarA = w0.a(i10);
        try {
            lVar.invoke(sVarA);
            Object objP = nVar.p(sVarA.z2(), dVar);
            return objP == wm.a.COROUTINE_SUSPENDED ? objP : l2.f10208a;
        } catch (Throwable th2) {
            sVarA.close();
            throw th2;
        }
    }

    public static final Object j(n nVar, int i10, jn.l<? super tl.s, l2> lVar, um.d<? super l2> dVar) {
        tl.s sVarA = w0.a(i10);
        try {
            lVar.invoke(sVarA);
            nVar.p(sVarA.z2(), dVar);
            return l2.f10208a;
        } catch (Throwable th2) {
            sVarA.close();
            throw th2;
        }
    }

    public static Object k(n nVar, int i10, jn.l lVar, um.d dVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        tl.s sVarA = w0.a(i10);
        try {
            lVar.invoke(sVarA);
            nVar.p(sVarA.z2(), dVar);
            return l2.f10208a;
        } catch (Throwable th2) {
            sVarA.close();
            throw th2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @os.m
    public static final Object l(@os.l n nVar, @os.l jn.p<? super tl.s, ? super um.d<? super l2>, ? extends Object> pVar, @os.l um.d<? super l2> dVar) throws Throwable {
        a aVar;
        tl.s sVar;
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
        if (i11 != 0) {
            if (i11 == 1) {
                nVar = (n) aVar.L$1;
                sVar = (tl.s) aVar.L$0;
                try {
                    d1.n(obj);
                } catch (Throwable th2) {
                    th = th2;
                    sVar.close();
                    throw th;
                }
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
            }
            return l2.f10208a;
        }
        d1.n(obj);
        tl.s sVarA = w0.a(0);
        try {
            aVar.L$0 = sVarA;
            aVar.L$1 = nVar;
            aVar.label = 1;
            if (pVar.invoke(sVarA, aVar) == aVar2) {
                return aVar2;
            }
            sVar = sVarA;
        } catch (Throwable th3) {
            th = th3;
            sVar = sVarA;
            sVar.close();
            throw th;
        }
        tl.v vVarZ2 = sVar.z2();
        aVar.L$0 = null;
        aVar.L$1 = null;
        aVar.label = 2;
        if (nVar.p(vVarZ2, aVar) == aVar2) {
            return aVar2;
        }
        return l2.f10208a;
    }

    @os.m
    public static final Object m(@os.l n nVar, int i10, @os.l tl.q qVar, @os.l um.d<? super l2> dVar) {
        Object objF = q.F(nVar, (short) (i10 & 65535), qVar, dVar);
        return objF == wm.a.COROUTINE_SUSPENDED ? objF : l2.f10208a;
    }

    @os.m
    public static final Object n(@os.l n nVar, int i10, @os.l um.d<? super l2> dVar) {
        Object objE0 = nVar.e0((short) (i10 & 65535), dVar);
        return objE0 == wm.a.COROUTINE_SUSPENDED ? objE0 : l2.f10208a;
    }

    @os.m
    public static final Object o(@os.l n nVar, @os.l CharSequence charSequence, @os.l um.d<? super l2> dVar) {
        tl.s sVarA = w0.a(0);
        try {
            sVarA.q2(charSequence);
            Object objP = nVar.p(sVarA.z2(), dVar);
            return objP == wm.a.COROUTINE_SUSPENDED ? objP : l2.f10208a;
        } catch (Throwable th2) {
            sVarA.close();
            throw th2;
        }
    }

    @os.m
    public static final Object p(@os.l n nVar, @os.l String str, @os.l um.d<? super l2> dVar) {
        tl.s sVarA = w0.a(0);
        try {
            tl.d1.Y(sVarA, str, 0, 0, null, 14, null);
            Object objP = nVar.p(sVarA.z2(), dVar);
            return objP == wm.a.COROUTINE_SUSPENDED ? objP : l2.f10208a;
        } catch (Throwable th2) {
            sVarA.close();
            throw th2;
        }
    }
}
