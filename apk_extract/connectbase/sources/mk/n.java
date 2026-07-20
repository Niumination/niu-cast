package mk;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.nio.ByteBuffer;
import java.util.List;
import kn.l0;
import kn.l1;
import kn.x0;
import lm.a1;
import lm.l2;
import nm.k0;
import nq.o2;
import nq.r0;
import nq.s0;

/* JADX INFO: loaded from: classes2.dex */
public final class n implements e0 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ un.o<Object>[] f10806i = {l1.k(new x0(n.class, "maxFrameSize", "getMaxFrameSize()J", 0)), l1.f9319a.i(new x0(n.class, "masking", "getMasking()Z", 0))};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final nq.b0 f10807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final pq.l<g> f10808b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final um.g f10809c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final qn.f f10810d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final qn.f f10811e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public final g0 f10812f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public final d0 f10813g;

    @xm.f(c = "io.ktor.http.cio.websocket.RawWebSocket$1", f = "RawWebSocket.kt", i = {2}, l = {ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE, 56, 59}, m = "invokeSuspend", n = {"cause"}, s = {"L$0"})
    public static final class a extends xm.o implements jn.p<s0, um.d<? super l2>, Object> {
        Object L$0;
        int label;

        public a(um.d<? super a> dVar) {
            super(2, dVar);
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            return n.this.new a(dVar);
        }

        /* JADX WARN: Code duplicated, block: B:30:0x0052 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:31:0x0053  */
        /* JADX WARN: Code duplicated, block: B:34:0x005e A[Catch: all -> 0x002d, CancellationException -> 0x002f, a -> 0x0031, TRY_LEAVE, TryCatch #3 {all -> 0x002d, blocks: (B:15:0x0028, B:28:0x0048, B:32:0x0056, B:34:0x005e, B:24:0x0037, B:27:0x003e), top: B:54:0x0008, outer: #1 }] */
        /* JADX WARN: Code duplicated, block: B:36:0x0074 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:37:0x0075  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x0072 -> B:16:0x002b). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // xm.a
        @os.m
        public final java.lang.Object invokeSuspend(@os.l java.lang.Object r11) {
            /*
                Method dump skipped, instruction units count: 212
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: mk.n.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l s0 s0Var, @os.m um.d<? super l2> dVar) {
            return ((a) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    public static final class b extends qn.c<Long> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f10814b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ n f10815c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Object obj, n nVar) {
            super(obj);
            this.f10814b = obj;
            this.f10815c = nVar;
        }

        @Override // qn.c
        public void c(@os.l un.o<?> oVar, Long l10, Long l11) {
            l0.p(oVar, "property");
            long jLongValue = l11.longValue();
            l10.longValue();
            this.f10815c.f10813g.f10758c = jLongValue;
        }
    }

    public static final class c extends qn.c<Boolean> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f10816b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ n f10817c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Object obj, n nVar) {
            super(obj);
            this.f10816b = obj;
            this.f10817c = nVar;
        }

        @Override // qn.c
        public void c(@os.l un.o<?> oVar, Boolean bool, Boolean bool2) {
            l0.p(oVar, "property");
            boolean zBooleanValue = bool2.booleanValue();
            bool.getClass();
            this.f10817c.f10812f.f10779c = zBooleanValue;
        }
    }

    public n(@os.l pl.k kVar, @os.l pl.n nVar, long j10, boolean z10, @os.l um.g gVar, @os.l bm.h<ByteBuffer> hVar) {
        l0.p(kVar, "input");
        l0.p(nVar, "output");
        l0.p(gVar, "coroutineContext");
        l0.p(hVar, "pool");
        o2 o2Var = new o2((nq.l2) gVar.get(nq.l2.f11882k));
        this.f10807a = o2Var;
        this.f10808b = pq.o.d(0, null, null, 6, null);
        um.g gVarPlus = gVar.plus(o2Var).plus(new r0("raw-ws"));
        this.f10809c = gVarPlus;
        qn.a aVar = qn.a.f14050a;
        this.f10810d = new b(Long.valueOf(j10), this);
        this.f10811e = new c(Boolean.valueOf(z10), this);
        this.f10812f = new g0(nVar, gVarPlus, z10, hVar);
        this.f10813g = new d0(kVar, gVarPlus, j10, hVar);
        nq.k.f(this, null, null, new a(null), 3, null);
        o2Var.complete();
    }

    @f
    public static /* synthetic */ void c() {
    }

    @Override // mk.e0
    public long F0() {
        return ((Number) this.f10810d.a(this, f10806i[0])).longValue();
    }

    @Override // mk.e0
    public void T0(boolean z10) {
        this.f10811e.b(this, f10806i[1], Boolean.valueOf(z10));
    }

    @Override // mk.e0
    @os.m
    public Object U0(@os.l g gVar, @os.l um.d<? super l2> dVar) {
        return e0.a.b(this, gVar, dVar);
    }

    @Override // mk.e0
    public boolean b2() {
        return ((Boolean) this.f10811e.a(this, f10806i[1])).booleanValue();
    }

    @Override // mk.e0
    @os.l
    public pq.f0<g> d() {
        return this.f10808b;
    }

    @os.l
    public final d0 e() {
        return this.f10813g;
    }

    @os.l
    public final g0 f() {
        return this.f10812f;
    }

    @Override // mk.e0
    @os.l
    public List<w<?>> f0() {
        return k0.INSTANCE;
    }

    @Override // nq.s0
    @os.l
    public um.g getCoroutineContext() {
        return this.f10809c;
    }

    @Override // mk.e0
    @os.l
    public pq.g0<g> h() {
        return this.f10812f.f10781e;
    }

    @Override // mk.e0
    @os.m
    public Object p0(@os.l um.d<? super l2> dVar) throws Throwable {
        Object objP0 = this.f10812f.p0(dVar);
        return objP0 == wm.a.COROUTINE_SUSPENDED ? objP0 : l2.f10208a;
    }

    @Override // mk.e0
    @lm.k(message = "Use cancel() instead.", replaceWith = @a1(expression = "cancel()", imports = {"kotlinx.coroutines.cancel"}))
    public void q() {
        pq.g0.a.a(this.f10812f.f10781e, null, 1, null);
        this.f10807a.complete();
    }

    @Override // mk.e0
    public void w0(long j10) {
        this.f10810d.b(this, f10806i[0], Long.valueOf(j10));
    }

    public /* synthetic */ n(pl.k kVar, pl.n nVar, long j10, boolean z10, um.g gVar, bm.h hVar, int i10, kn.w wVar) {
        this(kVar, nVar, (i10 & 4) != 0 ? 2147483647L : j10, (i10 & 8) != 0 ? false : z10, gVar, (i10 & 32) != 0 ? gl.b.a() : hVar);
    }
}
