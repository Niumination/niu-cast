package vk;

import androidx.core.app.NotificationCompat;
import fl.v1;
import ik.j0;
import ik.k;
import ik.n1;
import ik.r0;
import java.io.File;
import java.io.OutputStream;
import java.io.Writer;
import jn.p;
import kn.l0;
import kn.l1;
import kn.n0;
import lm.d1;
import lm.l2;
import nk.d0;
import nk.o;
import nk.s;
import nk.t;
import nk.y;
import os.l;
import os.m;
import pl.n;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    @xm.f(c = "io.ktor.response.ApplicationResponseFunctionsKt", f = "ApplicationResponseFunctions.kt", i = {0, 0}, l = {121, 239}, m = "respondBytes", n = {"contentType", NotificationCompat.CATEGORY_STATUS}, s = {"L$0", "L$1"})
    public static final class a extends xm.d {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public a(um.d<? super a> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return b.f(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: vk.b$b, reason: collision with other inner class name */
    public static final class C0457b extends n0 implements jn.l<s, l2> {
        public static final C0457b INSTANCE = new C0457b();

        public C0457b() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@l s sVar) {
            l0.p(sVar, "$this$null");
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(s sVar) {
            invoke2(sVar);
            return l2.f10208a;
        }
    }

    public static final class c extends n0 implements jn.l<s, l2> {
        public static final c INSTANCE = new c();

        public c() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@l s sVar) {
            l0.p(sVar, "$this$null");
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(s sVar) {
            invoke2(sVar);
            return l2.f10208a;
        }
    }

    public static final class d extends n0 implements jn.l<s, l2> {
        public static final d INSTANCE = new d();

        public d() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@l s sVar) {
            l0.p(sVar, "$this$null");
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(s sVar) {
            invoke2(sVar);
            return l2.f10208a;
        }
    }

    public static final class e extends n0 implements jn.l<s, l2> {
        public static final e INSTANCE = new e();

        public e() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@l s sVar) {
            l0.p(sVar, "$this$null");
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(s sVar) {
            invoke2(sVar);
            return l2.f10208a;
        }
    }

    @xm.f(c = "io.ktor.response.ApplicationResponseFunctionsKt", f = "ApplicationResponseFunctions.kt", i = {0, 0, 0}, l = {y5.a.Z, 239}, m = "respondText", n = {"$this$respondText", "contentType", NotificationCompat.CATEGORY_STATUS}, s = {"L$0", "L$1", "L$2"})
    public static final class f extends xm.d {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public f(um.d<? super f> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return b.w(null, null, null, null, this);
        }
    }

    @m
    public static final Object A(@l dk.b bVar, @m ik.i iVar, @m r0 r0Var, @l p<? super Writer, ? super um.d<? super l2>, ? extends Object> pVar, @l um.d<? super l2> dVar) {
        Object objG = bVar.e().c().g(bVar, new d0(pVar, a(bVar, iVar), r0Var), dVar);
        return objG == wm.a.COROUTINE_SUSPENDED ? objG : l2.f10208a;
    }

    public static /* synthetic */ Object B(dk.b bVar, ik.i iVar, r0 r0Var, p pVar, um.d dVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            iVar = null;
        }
        if ((i10 & 2) != 0) {
            r0Var = null;
        }
        return A(bVar, iVar, r0Var, pVar, dVar);
    }

    @in.i(name = "respondWithType")
    public static final <T> Object C(dk.b bVar, r0 r0Var, T t10, um.d<? super l2> dVar) {
        bVar.e().a(r0Var);
        if (!(t10 instanceof s) && !(t10 instanceof String) && !(t10 instanceof byte[])) {
            try {
                vk.a aVarE = bVar.e();
                l0.P();
                i.b(aVarE, null);
            } catch (Throwable unused) {
            }
        }
        bVar.e().c().g(bVar, t10, dVar);
        return l2.f10208a;
    }

    @in.i(name = "respondWithType")
    public static final <T> Object D(dk.b bVar, T t10, um.d<? super l2> dVar) {
        if (!(t10 instanceof s) && !(t10 instanceof String) && !(t10 instanceof byte[])) {
            try {
                vk.a aVarE = bVar.e();
                l0.P();
                i.b(aVarE, null);
            } catch (Throwable unused) {
            }
        }
        bVar.e().c().g(bVar, t10, dVar);
        return l2.f10208a;
    }

    @l
    public static final ik.i a(@l dk.b bVar, @m ik.i iVar) {
        l0.p(bVar, "<this>");
        if (iVar == null) {
            g gVarB = bVar.e().b();
            j0.f8048a.getClass();
            String strF = gVarB.f(j0.f8086t);
            iVar = null;
            if (strF != null) {
                try {
                    iVar = ik.i.f7981f.b(strF);
                } catch (ik.c unused) {
                }
            }
            if (iVar == null) {
                ik.i.g.f8029a.getClass();
                iVar = ik.i.g.f8031c;
            }
        }
        return k.a(iVar) == null ? k.b(iVar, jq.f.f8800b) : iVar;
    }

    @lm.k(level = lm.m.HIDDEN, message = "This method doesn't save type of the response. This can lead to error in serialization")
    public static final Object b(dk.b bVar, r0 r0Var, Object obj, um.d<? super l2> dVar) {
        bVar.e().a(r0Var);
        if (!(obj instanceof s) && !(obj instanceof String) && !(obj instanceof byte[])) {
            try {
                i.b(bVar.e(), l1.A(Object.class));
            } catch (Throwable unused) {
            }
        }
        Object objG = bVar.e().c().g(bVar, obj, dVar);
        return objG == wm.a.COROUTINE_SUSPENDED ? objG : l2.f10208a;
    }

    @lm.k(level = lm.m.HIDDEN, message = "This method doesn't save type of the response. This can lead to error in serialization")
    public static final Object c(dk.b bVar, Object obj, um.d<? super l2> dVar) {
        Object objG = bVar.e().c().g(bVar, obj, dVar);
        return objG == wm.a.COROUTINE_SUSPENDED ? objG : l2.f10208a;
    }

    @lm.k(level = lm.m.HIDDEN, message = "This method doesn't save type of the response. This can lead to error in serialization")
    public static final Object d(dk.b bVar, r0 r0Var, Object obj, um.d<? super l2> dVar) {
        bVar.e().a(r0Var);
        if (!(obj instanceof s) && !(obj instanceof String) && !(obj instanceof byte[])) {
            try {
                i.b(bVar.e(), l1.A(Object.class));
            } catch (Throwable unused) {
            }
        }
        bVar.e().c().g(bVar, obj, dVar);
        return l2.f10208a;
    }

    @lm.k(level = lm.m.HIDDEN, message = "This method doesn't save type of the response. This can lead to error in serialization")
    public static final Object e(dk.b bVar, Object obj, um.d<? super l2> dVar) {
        bVar.e().c().g(bVar, obj, dVar);
        return l2.f10208a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @m
    public static final Object f(@l dk.b bVar, @m ik.i iVar, @m r0 r0Var, @l jn.l<? super um.d<? super byte[]>, ? extends Object> lVar, @l um.d<? super l2> dVar) {
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
        Object objInvoke = aVar.result;
        wm.a aVar2 = wm.a.COROUTINE_SUSPENDED;
        int i11 = aVar.label;
        if (i11 != 0) {
            if (i11 == 1) {
                bVar = (dk.b) aVar.L$2;
                r0Var = (r0) aVar.L$1;
                iVar = (ik.i) aVar.L$0;
                d1.n(objInvoke);
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(objInvoke);
            }
            return l2.f10208a;
        }
        d1.n(objInvoke);
        aVar.L$0 = iVar;
        aVar.L$1 = r0Var;
        aVar.L$2 = bVar;
        aVar.label = 1;
        objInvoke = lVar.invoke(aVar);
        if (objInvoke == aVar2) {
            return aVar2;
        }
        nk.b bVar2 = new nk.b((byte[]) objInvoke, iVar, r0Var);
        vk.d dVarC = bVar.e().c();
        aVar.L$0 = null;
        aVar.L$1 = null;
        aVar.L$2 = null;
        aVar.label = 2;
        if (dVarC.g(bVar, bVar2, aVar) == aVar2) {
            return aVar2;
        }
        return l2.f10208a;
    }

    @m
    public static final Object g(@l dk.b bVar, @l byte[] bArr, @m ik.i iVar, @m r0 r0Var, @l jn.l<? super s, l2> lVar, @l um.d<? super l2> dVar) {
        nk.b bVar2 = new nk.b(bArr, iVar, r0Var);
        lVar.invoke(bVar2);
        Object objG = bVar.e().c().g(bVar, bVar2, dVar);
        return objG == wm.a.COROUTINE_SUSPENDED ? objG : l2.f10208a;
    }

    public static /* synthetic */ Object h(dk.b bVar, ik.i iVar, r0 r0Var, jn.l lVar, um.d dVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            iVar = null;
        }
        if ((i10 & 2) != 0) {
            r0Var = null;
        }
        return f(bVar, iVar, r0Var, lVar, dVar);
    }

    public static /* synthetic */ Object i(dk.b bVar, byte[] bArr, ik.i iVar, r0 r0Var, jn.l lVar, um.d dVar, int i10, Object obj) {
        ik.i iVar2 = (i10 & 2) != 0 ? null : iVar;
        r0 r0Var2 = (i10 & 4) != 0 ? null : r0Var;
        if ((i10 & 8) != 0) {
            lVar = C0457b.INSTANCE;
        }
        return g(bVar, bArr, iVar2, r0Var2, lVar, dVar);
    }

    @m
    public static final Object j(@l dk.b bVar, @m ik.i iVar, @m r0 r0Var, @l p<? super n, ? super um.d<? super l2>, ? extends Object> pVar, @l um.d<? super l2> dVar) {
        if (iVar == null) {
            ik.i.a.f7985a.getClass();
            iVar = ik.i.a.f7992h;
        }
        Object objG = bVar.e().c().g(bVar, new nk.f(pVar, iVar, r0Var), dVar);
        return objG == wm.a.COROUTINE_SUSPENDED ? objG : l2.f10208a;
    }

    public static /* synthetic */ Object k(dk.b bVar, ik.i iVar, r0 r0Var, p pVar, um.d dVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            iVar = null;
        }
        if ((i10 & 2) != 0) {
            r0Var = null;
        }
        return j(bVar, iVar, r0Var, pVar, dVar);
    }

    @m
    public static final Object l(@l dk.b bVar, @l File file, @l String str, @l jn.l<? super s, l2> lVar, @l um.d<? super l2> dVar) {
        nk.n nVarC = o.c(file, str, null, 4, null);
        lVar.invoke(nVarC);
        if (nVarC == null && !(nVarC instanceof byte[])) {
            try {
                i.b(bVar.e(), l1.A(nk.n.class));
            } catch (Throwable unused) {
            }
        }
        Object objG = bVar.e().c().g(bVar, nVarC, dVar);
        return objG == wm.a.COROUTINE_SUSPENDED ? objG : l2.f10208a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @m
    public static final Object m(@l dk.b bVar, @l File file, @l jn.l<? super s, l2> lVar, @l um.d<? super l2> dVar) {
        nk.n nVar = new nk.n(file, null, 2, 0 == true ? 1 : 0);
        lVar.invoke(nVar);
        Object objG = bVar.e().c().g(bVar, nVar, dVar);
        return objG == wm.a.COROUTINE_SUSPENDED ? objG : l2.f10208a;
    }

    public static /* synthetic */ Object n(dk.b bVar, File file, String str, jn.l lVar, um.d dVar, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            lVar = c.INSTANCE;
        }
        return l(bVar, file, str, lVar, dVar);
    }

    public static /* synthetic */ Object o(dk.b bVar, File file, jn.l lVar, um.d dVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            lVar = d.INSTANCE;
        }
        return m(bVar, file, lVar, dVar);
    }

    @m
    public static final Object p(@l dk.b bVar, @m ik.i iVar, @m r0 r0Var, @l p<? super OutputStream, ? super um.d<? super l2>, ? extends Object> pVar, @l um.d<? super l2> dVar) {
        if (iVar == null) {
            ik.i.a.f7985a.getClass();
            iVar = ik.i.a.f7992h;
        }
        Object objG = bVar.e().c().g(bVar, new t(pVar, iVar, r0Var), dVar);
        return objG == wm.a.COROUTINE_SUSPENDED ? objG : l2.f10208a;
    }

    public static /* synthetic */ Object q(dk.b bVar, ik.i iVar, r0 r0Var, p pVar, um.d dVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            iVar = null;
        }
        if ((i10 & 2) != 0) {
            r0Var = null;
        }
        return p(bVar, iVar, r0Var, pVar, dVar);
    }

    @m
    public static final Object r(@l dk.b bVar, @l String str, boolean z10, @l um.d<? super l2> dVar) {
        g gVarB = bVar.e().b();
        j0.f8048a.getClass();
        g.c(gVarB, j0.P, str, false, 4, null);
        r0.f8158c.getClass();
        r0 r0Var = z10 ? r0.f8174p : r0.f8175q;
        if (!(r0Var instanceof byte[])) {
            try {
                i.b(bVar.e(), l1.A(r0.class));
            } catch (Throwable unused) {
            }
        }
        Object objG = bVar.e().c().g(bVar, r0Var, dVar);
        return objG == wm.a.COROUTINE_SUSPENDED ? objG : l2.f10208a;
    }

    @m
    public static final Object s(@l dk.b bVar, boolean z10, @l jn.l<? super n1, l2> lVar, @l um.d<? super l2> dVar) {
        n1 n1VarA = v1.a(n1.f8120j, bVar);
        lVar.invoke(n1VarA);
        Object objR = r(bVar, n1VarA.c(), z10, dVar);
        return objR == wm.a.COROUTINE_SUSPENDED ? objR : l2.f10208a;
    }

    public static final Object t(dk.b bVar, boolean z10, jn.l<? super n1, l2> lVar, um.d<? super l2> dVar) {
        n1 n1VarA = v1.a(n1.f8120j, bVar);
        lVar.invoke(n1VarA);
        r(bVar, n1VarA.c(), z10, dVar);
        return l2.f10208a;
    }

    public static /* synthetic */ Object u(dk.b bVar, String str, boolean z10, um.d dVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return r(bVar, str, z10, dVar);
    }

    public static Object v(dk.b bVar, boolean z10, jn.l lVar, um.d dVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        n1 n1VarA = v1.a(n1.f8120j, bVar);
        lVar.invoke(n1VarA);
        r(bVar, n1VarA.c(), z10, dVar);
        return l2.f10208a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @m
    public static final Object w(@l dk.b bVar, @m ik.i iVar, @m r0 r0Var, @l jn.l<? super um.d<? super String>, ? extends Object> lVar, @l um.d<? super l2> dVar) {
        f fVar;
        if (dVar instanceof f) {
            fVar = (f) dVar;
            int i10 = fVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                fVar.label = i10 - Integer.MIN_VALUE;
            } else {
                fVar = new f(dVar);
            }
        } else {
            fVar = new f(dVar);
        }
        Object objInvoke = fVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = fVar.label;
        if (i11 != 0) {
            if (i11 == 1) {
                r0Var = (r0) fVar.L$2;
                iVar = (ik.i) fVar.L$1;
                bVar = (dk.b) fVar.L$0;
                d1.n(objInvoke);
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(objInvoke);
            }
            return l2.f10208a;
        }
        d1.n(objInvoke);
        fVar.L$0 = bVar;
        fVar.L$1 = iVar;
        fVar.L$2 = r0Var;
        fVar.label = 1;
        objInvoke = lVar.invoke(fVar);
        if (objInvoke == aVar) {
            return aVar;
        }
        y yVar = new y((String) objInvoke, a(bVar, iVar), r0Var);
        vk.d dVarC = bVar.e().c();
        fVar.L$0 = null;
        fVar.L$1 = null;
        fVar.L$2 = null;
        fVar.label = 2;
        if (dVarC.g(bVar, yVar, fVar) == aVar) {
            return aVar;
        }
        return l2.f10208a;
    }

    @m
    public static final Object x(@l dk.b bVar, @l String str, @m ik.i iVar, @m r0 r0Var, @l jn.l<? super s, l2> lVar, @l um.d<? super l2> dVar) {
        y yVar = new y(str, a(bVar, iVar), r0Var);
        lVar.invoke(yVar);
        Object objG = bVar.e().c().g(bVar, yVar, dVar);
        return objG == wm.a.COROUTINE_SUSPENDED ? objG : l2.f10208a;
    }

    public static /* synthetic */ Object y(dk.b bVar, ik.i iVar, r0 r0Var, jn.l lVar, um.d dVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            iVar = null;
        }
        if ((i10 & 2) != 0) {
            r0Var = null;
        }
        return w(bVar, iVar, r0Var, lVar, dVar);
    }

    public static /* synthetic */ Object z(dk.b bVar, String str, ik.i iVar, r0 r0Var, jn.l lVar, um.d dVar, int i10, Object obj) {
        ik.i iVar2 = (i10 & 2) != 0 ? null : iVar;
        r0 r0Var2 = (i10 & 4) != 0 ? null : r0Var;
        if ((i10 & 8) != 0) {
            lVar = e.INSTANCE;
        }
        return x(bVar, str, iVar2, r0Var2, lVar, dVar);
    }
}
