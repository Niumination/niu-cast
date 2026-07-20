package al;

import androidx.core.app.NotificationCompat;
import fl.t0;
import ik.j0;
import ik.r0;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.LastHttpContent;
import java.util.LinkedHashMap;
import java.util.List;
import kn.l0;
import lm.d1;
import lm.l2;
import nm.c1;
import nm.z;
import nq.a0;
import nq.y;

/* JADX INFO: loaded from: classes2.dex */
@t0
public abstract class q extends yk.l {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @os.l
    public static final a f379m = new a();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @os.l
    public static final byte[] f380n = new byte[0];

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @os.l
    public static final HttpResponseStatus[] f381o;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @os.l
    public final ChannelHandlerContext f382h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @os.l
    public final um.g f383i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @os.l
    public final um.g f384j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @os.l
    public final y<Object> f385k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @os.l
    public pl.k f386l;
    private volatile boolean responseMessageSent;

    public static final class a {
        public a() {
        }

        @os.l
        public final HttpResponseStatus[] a() {
            return q.f381o;
        }

        public a(kn.w wVar) {
        }
    }

    @xm.f(c = "io.ktor.server.netty.NettyApplicationResponse", f = "NettyApplicationResponse.kt", i = {0}, l = {36}, m = "respondOutgoingContent$suspendImpl", n = {"this"}, s = {"L$0"})
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
            return q.K(q.this, null, this);
        }
    }

    static {
        HttpResponseStatus httpResponseStatus;
        r0.f8158c.getClass();
        List list = r0.f8161d0;
        int iJ = c1.j(z.b0(list, 10));
        if (iJ < 16) {
            iJ = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iJ);
        for (Object obj : list) {
            linkedHashMap.put(Integer.valueOf(((r0) obj).f8185a), obj);
        }
        HttpResponseStatus[] httpResponseStatusArr = new HttpResponseStatus[1000];
        for (int i10 = 0; i10 < 1000; i10++) {
            if (linkedHashMap.keySet().contains(Integer.valueOf(i10))) {
                Object obj2 = linkedHashMap.get(Integer.valueOf(i10));
                l0.m(obj2);
                httpResponseStatus = new HttpResponseStatus(i10, ((r0) obj2).f8186b);
            } else {
                httpResponseStatus = null;
            }
            httpResponseStatusArr[i10] = httpResponseStatus;
        }
        f381o = httpResponseStatusArr;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(@os.l i iVar, @os.l ChannelHandlerContext channelHandlerContext, @os.l um.g gVar, @os.l um.g gVar2) {
        super(iVar);
        l0.p(iVar, NotificationCompat.CATEGORY_CALL);
        l0.p(channelHandlerContext, "context");
        l0.p(gVar, "engineContext");
        l0.p(gVar2, "userContext");
        this.f382h = channelHandlerContext;
        this.f383i = gVar;
        this.f384j = gVar2;
        this.f385k = a0.c(null, 1, null);
        this.f386l = pl.k.f13204a.a();
    }

    public static Object I(q qVar, byte[] bArr, um.d dVar) {
        vk.g gVarB = qVar.b();
        j0.f8048a.getClass();
        boolean zG = l0.g(gVarB.f(j0.f8095x0), "chunked");
        if (!qVar.responseMessageSent) {
            Object objN = qVar.N(zG, bArr);
            qVar.Q(objN instanceof LastHttpContent ? pl.k.f13204a.a() : pl.d.b(bArr));
            qVar.f385k.l0(objN);
            qVar.responseMessageSent = true;
        }
        return l2.f10208a;
    }

    public static Object J(q qVar, nk.s.b bVar, um.d dVar) {
        Object objL = qVar.l(f380n, dVar);
        return objL == wm.a.COROUTINE_SUSPENDED ? objL : l2.f10208a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [al.q, java.lang.Object, yk.l] */
    /* JADX WARN: Type inference failed for: r5v1, types: [al.q] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v3, types: [al.q] */
    /* JADX WARN: Type inference failed for: r5v4, types: [pl.k] */
    /* JADX WARN: Type inference failed for: r5v9 */
    public static Object K(q qVar, nk.s sVar, um.d dVar) {
        b bVar;
        pl.n nVar;
        ?? r10;
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
        Object obj = bVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = bVar.label;
        try {
            if (i11 == 0) {
                d1.n(obj);
                bVar.L$0 = qVar;
                bVar.label = 1;
                qVar.getClass();
                Object objS = yk.l.s(qVar, sVar, bVar);
                r10 = qVar;
                if (objS == aVar) {
                    return aVar;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                q qVar2 = (q) bVar.L$0;
                d1.n(obj);
                r10 = qVar2;
            }
            qVar = r10.f386l;
            nVar = qVar instanceof pl.n ? (pl.n) qVar : null;
            if (nVar != null) {
                pl.o.a(nVar);
            }
            return l2.f10208a;
        } catch (Throwable th2) {
            try {
                pl.k kVar = qVar.f386l;
                pl.n nVar2 = kVar instanceof pl.n ? (pl.n) kVar : null;
                if (nVar2 != null) {
                    nVar2.f(th2);
                }
                throw th2;
            } catch (Throwable th3) {
                pl.k kVar2 = qVar.f386l;
                nVar = kVar2 instanceof pl.n ? (pl.n) kVar2 : null;
                if (nVar != null) {
                    pl.o.a(nVar);
                }
                throw th3;
            }
        }
    }

    public static Object L(q qVar, um.d dVar) {
        pl.c cVarC = pl.e.c(false, 1, null);
        vk.g gVarB = qVar.b();
        j0.f8048a.getClass();
        qVar.O(l0.g(gVarB.f(j0.f8095x0), "chunked"), cVarC);
        return cVarC;
    }

    public static /* synthetic */ void P(q qVar, boolean z10, pl.k kVar, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendResponse");
        }
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        qVar.O(z10, kVar);
    }

    public final void A() {
        pl.k kVar = this.f386l;
        if (kVar instanceof pl.n) {
            ((pl.n) kVar).f(new pl.s("Application response has been closed"));
            this.f386l = pl.k.f13204a.a();
        }
        B();
    }

    public final void B() {
        P(this, false, pl.k.f13204a.a(), 1, null);
    }

    @os.l
    public final ChannelHandlerContext C() {
        return this.f382h;
    }

    @os.l
    public final um.g D() {
        return this.f383i;
    }

    @os.l
    public final pl.k E() {
        return this.f386l;
    }

    @os.l
    public final y<Object> F() {
        return this.f385k;
    }

    public final boolean G() {
        return this.responseMessageSent;
    }

    @os.l
    public final um.g H() {
        return this.f384j;
    }

    @os.l
    public abstract Object M(boolean z10, boolean z11);

    @os.l
    public Object N(boolean z10, @os.l byte[] bArr) {
        l0.p(bArr, "data");
        return M(z10, true);
    }

    public final void O(boolean z10, @os.l pl.k kVar) {
        l0.p(kVar, t2.a.f15437d);
        if (this.responseMessageSent) {
            return;
        }
        this.f386l = kVar;
        this.f385k.l0(kVar.p0() ? N(false, f380n) : M(z10, false));
        this.responseMessageSent = true;
    }

    public final void Q(@os.l pl.k kVar) {
        l0.p(kVar, "<set-?>");
        this.f386l = kVar;
    }

    public final void R(boolean z10) {
        this.responseMessageSent = z10;
    }

    @Override // yk.l
    @os.m
    public Object l(@os.l byte[] bArr, @os.l um.d<? super l2> dVar) {
        return I(this, bArr, dVar);
    }

    @Override // yk.l
    @os.m
    public Object p(@os.l nk.s.b bVar, @os.l um.d<? super l2> dVar) {
        return J(this, bVar, dVar);
    }

    @Override // yk.l
    @os.m
    public Object r(@os.l nk.s sVar, @os.l um.d<? super l2> dVar) {
        return K(this, sVar, dVar);
    }

    @Override // yk.l
    @os.m
    public Object w(@os.l um.d<? super pl.n> dVar) {
        return L(this, dVar);
    }

    public final void z() {
        if (this.responseMessageSent) {
            return;
        }
        this.f386l = pl.k.f13204a.a();
        nq.l2.a.b(this.f385k, null, 1, null);
        this.responseMessageSent = true;
    }
}
