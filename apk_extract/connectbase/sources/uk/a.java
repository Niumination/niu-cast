package uk;

import dk.j;
import gk.k;
import gk.x;
import ik.b1;
import ik.y0;
import java.io.InputStream;
import kn.l0;
import kn.l1;
import lm.d1;
import nk.p;
import os.l;
import os.m;
import un.s;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public static final fl.b<f> f16288a = new fl.b<>("DoubleReceivePreventionToken");

    /* JADX INFO: renamed from: uk.a$a, reason: collision with other inner class name */
    @xm.f(c = "io.ktor.request.ApplicationReceiveFunctionsKt", f = "ApplicationReceiveFunctions.kt", i = {0}, l = {y5.a.f20724i0}, m = "receive", n = {y0.a.f8215h}, s = {"L$0"})
    public static final class C0433a<T> extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C0433a(um.d<? super C0433a> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return a.c(null, null, this);
        }
    }

    @xm.f(c = "io.ktor.request.ApplicationReceiveFunctionsKt", f = "ApplicationReceiveFunctions.kt", i = {0}, l = {135}, m = "receiveOrNull", n = {"$this$receiveOrNull"}, s = {"L$0"})
    public static final class b<T> extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public b(um.d<? super b> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return a.j(null, null, this);
        }
    }

    @xm.f(c = "io.ktor.request.ApplicationReceiveFunctionsKt", f = "ApplicationReceiveFunctions.kt", i = {0}, l = {149}, m = "receiveOrNull", n = {"$this$receiveOrNull"}, s = {"L$0"})
    public static final class c<T> extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public c(um.d<? super c> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return a.i(null, null, this);
        }
    }

    public static final <T> Object a(dk.b bVar, um.d<? super T> dVar) {
        l0.P();
        return c(bVar, null, dVar);
    }

    @m
    public static final <T> Object b(@l dk.b bVar, @l un.d<T> dVar, @l um.d<? super T> dVar2) {
        return c(bVar, vn.g.d(dVar), dVar2);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @m
    public static final <T> Object c(@l dk.b bVar, @l s sVar, @l um.d<? super T> dVar) throws k {
        C0433a c0433a;
        if (dVar instanceof C0433a) {
            c0433a = (C0433a) dVar;
            int i10 = c0433a.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c0433a.label = i10 - Integer.MIN_VALUE;
            } else {
                c0433a = new C0433a(dVar);
            }
        } else {
            c0433a = new C0433a(dVar);
        }
        Object objG = c0433a.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = c0433a.label;
        if (i11 == 0) {
            d1.n(objG);
            if (l0.g(sVar, l1.d(uk.c.class))) {
                throw new IllegalArgumentException("ApplicationReceiveRequest can't be received");
            }
            fl.c cVarC = bVar.c();
            fl.b<f> bVar2 = f16288a;
            Object objI = (f) cVarC.b(bVar2);
            if (objI == null) {
                bVar.c().g(bVar2, f.f16297a);
            }
            if (objI == null) {
                objI = bVar.d().i();
            }
            uk.c cVar = new uk.c(sVar, objI, false, 4, null);
            uk.b bVarC = bVar.d().c();
            c0433a.L$0 = sVar;
            c0433a.label = 1;
            objG = bVarC.g(bVar, cVar, c0433a);
            if (objG == aVar) {
                return aVar;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            sVar = (s) c0433a.L$0;
            d1.n(objG);
        }
        Object obj = ((uk.c) objG).f16295b;
        if (obj == f.f16297a) {
            throw new g();
        }
        if (wn.d.b(sVar).r(obj)) {
            return obj;
        }
        throw new k(sVar);
    }

    @m
    public static final Object d(@l dk.b bVar, @l um.d<? super pl.k> dVar) {
        return c(bVar, l1.A(pl.k.class), dVar);
    }

    public static final Object e(dk.b bVar, um.d<? super pl.k> dVar) {
        return c(bVar, l1.A(pl.k.class), dVar);
    }

    @m
    public static final Object f(@l dk.b bVar, @l um.d<? super p> dVar) {
        return c(bVar, l1.A(p.class), dVar);
    }

    public static final Object g(dk.b bVar, um.d<? super p> dVar) {
        return c(bVar, l1.A(p.class), dVar);
    }

    public static final <T> Object h(dk.b bVar, um.d<? super T> dVar) {
        l0.P();
        return j(bVar, null, dVar);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @m
    public static final <T> Object i(@l dk.b bVar, @l un.d<T> dVar, @l um.d<? super T> dVar2) {
        c cVar;
        if (dVar2 instanceof c) {
            cVar = (c) dVar2;
            int i10 = cVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                cVar.label = i10 - Integer.MIN_VALUE;
            } else {
                cVar = new c(dVar2);
            }
        } else {
            cVar = new c(dVar2);
        }
        Object objB = cVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = cVar.label;
        try {
            if (i11 == 0) {
                d1.n(objB);
                cVar.L$0 = bVar;
                cVar.label = 1;
                objB = b(bVar, dVar, cVar);
                if (objB == aVar) {
                    return aVar;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                bVar = (dk.b) cVar.L$0;
                d1.n(objB);
            }
            return objB;
        } catch (x e10) {
            j.a(bVar.a()).debug("Conversion failed, null returned", (Throwable) e10);
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @m
    public static final <T> Object j(@l dk.b bVar, @l s sVar, @l um.d<? super T> dVar) {
        b bVar2;
        if (dVar instanceof b) {
            bVar2 = (b) dVar;
            int i10 = bVar2.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                bVar2.label = i10 - Integer.MIN_VALUE;
            } else {
                bVar2 = new b(dVar);
            }
        } else {
            bVar2 = new b(dVar);
        }
        Object objC = bVar2.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = bVar2.label;
        try {
            if (i11 == 0) {
                d1.n(objC);
                bVar2.L$0 = bVar;
                bVar2.label = 1;
                objC = c(bVar, sVar, bVar2);
                if (objC == aVar) {
                    return aVar;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                bVar = (dk.b) bVar2.L$0;
                d1.n(objC);
            }
            return objC;
        } catch (x e10) {
            j.a(bVar.a()).debug("Conversion failed, null returned", (Throwable) e10);
            return null;
        }
    }

    @m
    public static final Object k(@l dk.b bVar, @l um.d<? super b1> dVar) {
        return c(bVar, l1.A(b1.class), dVar);
    }

    public static final Object l(dk.b bVar, um.d<? super b1> dVar) {
        return c(bVar, l1.A(b1.class), dVar);
    }

    @m
    public static final Object m(@l dk.b bVar, @l um.d<? super InputStream> dVar) {
        return c(bVar, l1.A(InputStream.class), dVar);
    }

    public static final Object n(dk.b bVar, um.d<? super InputStream> dVar) {
        return c(bVar, l1.A(InputStream.class), dVar);
    }

    @m
    public static final Object o(@l dk.b bVar, @l um.d<? super String> dVar) {
        return c(bVar, l1.A(String.class), dVar);
    }

    public static final Object p(dk.b bVar, um.d<? super String> dVar) {
        return c(bVar, l1.A(String.class), dVar);
    }
}
