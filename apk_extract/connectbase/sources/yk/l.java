package yk;

import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import gk.u0;
import ik.r0;
import ik.y0;
import ik.z0;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;
import kn.k1;
import kn.n0;
import lm.a1;
import lm.d1;
import lm.l2;
import nq.l0;
import nq.s0;
import wj.h2;

/* JADX INFO: loaded from: classes2.dex */
public abstract class l implements vk.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public static final c f21420f = new c();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public static final fl.b<l> f21421g = new fl.b<>("EngineResponse");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final dk.b f21422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.m
    public r0 f21423b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final lm.d0 f21424c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f21425d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final vk.d f21426e;

    public static final class a extends IllegalStateException implements l0<a> {
        private final long expected;

        public a(long j10) {
            super(kn.l0.C("Body.size is too long. Expected ", Long.valueOf(j10)));
            this.expected = j10;
        }

        @Override // nq.l0
        @os.m
        public a createCopy() {
            a aVar = new a(this.expected);
            aVar.initCause(this);
            return aVar;
        }
    }

    public static final class b extends IllegalStateException implements l0<b> {
        private final long actual;
        private final long expected;

        /* JADX WARN: Illegal instructions before constructor call */
        public b(long j10, long j11) {
            StringBuilder sbA = j.b.a("Body.size is too small. Body: ", j11, ", Content-Length: ");
            sbA.append(j10);
            super(sbA.toString());
            this.expected = j10;
            this.actual = j11;
        }

        @Override // nq.l0
        @os.m
        public b createCopy() {
            b bVar = new b(this.expected, this.actual);
            bVar.initCause(this);
            return bVar;
        }
    }

    public static final class c {

        @xm.f(c = "io.ktor.server.engine.BaseApplicationResponse$Companion$setupSendPipeline$1", f = "BaseApplicationResponse.kt", i = {}, l = {320}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends xm.o implements jn.q<nl.f<Object, dk.b>, Object, um.d<? super l2>, Object> {
            private /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            int label;

            public a(um.d<? super a> dVar) {
                super(3, dVar);
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i10 = this.label;
                if (i10 == 0) {
                    d1.n(obj);
                    nl.f fVar = (nl.f) this.L$0;
                    Object obj2 = this.L$1;
                    if (!(obj2 instanceof nk.s)) {
                        throw new IllegalArgumentException("Response pipeline couldn't transform '" + obj2.getClass() + "' to the OutgoingContent");
                    }
                    dk.b bVar = (dk.b) fVar.getContext();
                    vk.a aVarE = bVar.e();
                    l lVar = aVarE instanceof l ? (l) aVarE : null;
                    if (lVar == null) {
                        fl.c cVarC = bVar.c();
                        l.f21420f.getClass();
                        lVar = (l) cVarC.h(l.f21421g);
                    }
                    this.L$0 = null;
                    this.label = 1;
                    if (lVar.r((nk.s) obj2, this) == aVar) {
                        return aVar;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    d1.n(obj);
                }
                return l2.f10208a;
            }

            @Override // jn.q
            @os.m
            public final Object invoke(@os.l nl.f<Object, dk.b> fVar, @os.l Object obj, @os.m um.d<? super l2> dVar) {
                a aVar = new a(dVar);
                aVar.L$0 = fVar;
                aVar.L$1 = obj;
                return aVar.invokeSuspend(l2.f10208a);
            }
        }

        public c() {
        }

        @v
        public static /* synthetic */ void b() {
        }

        @os.l
        public final fl.b<l> a() {
            return l.f21421g;
        }

        @v
        public final void c(@os.l vk.d dVar) {
            kn.l0.p(dVar, "sendPipeline");
            vk.d.f17581n.getClass();
            dVar.x(vk.d.H, new a(null));
        }

        public c(kn.w wVar) {
        }
    }

    public static final class d extends IllegalStateException implements l0<d> {

        @os.l
        private final String content;

        @os.l
        private final String name;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@os.l String str, @os.l String str2) {
            super("Header " + str + " is not allowed for " + str2);
            kn.l0.p(str, "name");
            kn.l0.p(str2, t2.a.f15437d);
            this.name = str;
            this.content = str2;
        }

        @Override // nq.l0
        @os.m
        public d createCopy() {
            d dVar = new d(this.name, this.content);
            dVar.initCause(this);
            return dVar;
        }
    }

    public static final class e extends IllegalStateException {
        public e() {
            super("Response has already been sent");
        }
    }

    public static final class f extends n0 implements jn.p<String, List<? extends String>, l2> {
        final /* synthetic */ nk.s $content;
        final /* synthetic */ k1.a $transferEncodingSet;
        final /* synthetic */ l this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(k1.a aVar, nk.s sVar, l lVar) {
            super(2);
            this.$transferEncodingSet = aVar;
            this.$content = sVar;
            this.this$0 = lVar;
        }

        @Override // jn.p
        public /* bridge */ /* synthetic */ l2 invoke(String str, List<? extends String> list) {
            invoke2(str, (List<String>) list);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l String str, @os.l List<String> list) {
            kn.l0.p(str, "name");
            kn.l0.p(list, "values");
            ik.j0 j0Var = ik.j0.f8048a;
            j0Var.getClass();
            if (kn.l0.g(str, ik.j0.f8095x0)) {
                this.$transferEncodingSet.element = true;
            } else {
                j0Var.getClass();
                String str2 = ik.j0.f8097y0;
                if (kn.l0.g(str, str2)) {
                    if (!(this.$content instanceof nk.s.c)) {
                        j0Var.getClass();
                        throw new d(str2, "non-upgrading response");
                    }
                    Iterator<String> it = list.iterator();
                    while (it.hasNext()) {
                        this.this$0.b().b(str, it.next(), false);
                    }
                    return;
                }
            }
            Iterator<String> it2 = list.iterator();
            while (it2.hasNext()) {
                vk.g.c(this.this$0.b(), str, it2.next(), false, 4, null);
            }
        }
    }

    public static final class g extends n0 implements jn.a<vk.f> {
        public g() {
            super(0);
        }

        @Override // jn.a
        @os.l
        public final vk.f invoke() {
            l lVar = l.this;
            return new vk.f(lVar, kn.l0.g(u0.e(lVar.f21422a.d()).d(), h2.f18719h));
        }
    }

    @xm.f(c = "io.ktor.server.engine.BaseApplicationResponse", f = "BaseApplicationResponse.kt", i = {0, 1}, l = {189, 190}, m = "respondFromBytes$suspendImpl", n = {"bytes", "$this$use$iv"}, s = {"L$0", "L$0"})
    public static final class h extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public h(um.d<? super h> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return l.m(l.this, null, this);
        }
    }

    @xm.f(c = "io.ktor.server.engine.BaseApplicationResponse$respondFromBytes$3$1", f = "BaseApplicationResponse.kt", i = {}, l = {191}, m = "invokeSuspend", n = {}, s = {})
    public static final class i extends xm.o implements jn.p<s0, um.d<? super l2>, Object> {
        final /* synthetic */ byte[] $bytes;
        final /* synthetic */ pl.n $this_use;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(pl.n nVar, byte[] bArr, um.d<? super i> dVar) {
            super(2, dVar);
            this.$this_use = nVar;
            this.$bytes = bArr;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            return new i(this.$this_use, this.$bytes, dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                pl.n nVar = this.$this_use;
                byte[] bArr = this.$bytes;
                this.label = 1;
                if (pl.o.f(nVar, bArr, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
            }
            return l2.f10208a;
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l s0 s0Var, @os.m um.d<? super l2> dVar) {
            return ((i) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @xm.f(c = "io.ktor.server.engine.BaseApplicationResponse", f = "BaseApplicationResponse.kt", i = {0, 0, 1, 1, 1, 1, 2, 2, 2, 2}, l = {ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION, 202, 207}, m = "respondFromChannel$suspendImpl", n = {"this", "readChannel", "this", "readChannel", "$this$use$iv", "length", "this", "$this$use$iv", "length", "copied"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "J$0"})
    public static final class j extends xm.d {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public j(um.d<? super j> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return l.o(l.this, null, this);
        }
    }

    @xm.f(c = "io.ktor.server.engine.BaseApplicationResponse$respondFromChannel$2$copied$1", f = "BaseApplicationResponse.kt", i = {}, l = {203}, m = "invokeSuspend", n = {}, s = {})
    public static final class k extends xm.o implements jn.p<s0, um.d<? super Long>, Object> {
        final /* synthetic */ Long $length;
        final /* synthetic */ pl.k $readChannel;
        final /* synthetic */ pl.n $this_use;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(pl.k kVar, pl.n nVar, Long l10, um.d<? super k> dVar) {
            super(2, dVar);
            this.$readChannel = kVar;
            this.$this_use = nVar;
            this.$length = l10;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            return new k(this.$readChannel, this.$this_use, this.$length, dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                pl.k kVar = this.$readChannel;
                pl.n nVar = this.$this_use;
                Long l10 = this.$length;
                long jLongValue = l10 == null ? Long.MAX_VALUE : l10.longValue();
                this.label = 1;
                obj = pl.l.c(kVar, nVar, jLongValue, this);
                if (obj == aVar) {
                    return aVar;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
            }
            return obj;
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l s0 s0Var, @os.m um.d<? super Long> dVar) {
            return ((k) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    /* JADX INFO: renamed from: yk.l$l, reason: collision with other inner class name */
    @xm.f(c = "io.ktor.server.engine.BaseApplicationResponse", f = "BaseApplicationResponse.kt", i = {3}, l = {108, y5.a.f20726j0, 125, 135, 144}, m = "respondOutgoingContent$suspendImpl", n = {"readChannel"}, s = {"L$0"})
    public static final class C0546l extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C0546l(um.d<? super C0546l> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return l.s(l.this, null, this);
        }
    }

    @xm.f(c = "io.ktor.server.engine.BaseApplicationResponse", f = "BaseApplicationResponse.kt", i = {0, 1}, l = {161, 165}, m = "respondWriteChannelContent$suspendImpl", n = {t2.a.f15437d, "$this$use$iv"}, s = {"L$0", "L$0"})
    public static final class m extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public m(um.d<? super m> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return l.v(l.this, null, this);
        }
    }

    @xm.f(c = "io.ktor.server.engine.BaseApplicationResponse$respondWriteChannelContent$2$1", f = "BaseApplicationResponse.kt", i = {}, l = {166}, m = "invokeSuspend", n = {}, s = {})
    public static final class n extends xm.o implements jn.p<s0, um.d<? super l2>, Object> {
        final /* synthetic */ nk.s.e $content;
        final /* synthetic */ pl.n $this_use;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(nk.s.e eVar, pl.n nVar, um.d<? super n> dVar) {
            super(2, dVar);
            this.$content = eVar;
            this.$this_use = nVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            return new n(this.$content, this.$this_use, dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                nk.s.e eVar = this.$content;
                pl.n nVar = this.$this_use;
                this.label = 1;
                if (eVar.j(nVar, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
            }
            return l2.f10208a;
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l s0 s0Var, @os.m um.d<? super l2> dVar) {
            return ((n) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    public l(@os.l dk.b bVar) {
        kn.l0.p(bVar, NotificationCompat.CATEGORY_CALL);
        this.f21422a = bVar;
        this.f21424c = lm.f0.b(new g());
        vk.d dVar = new vk.d(bVar.a().I.h());
        dVar.C(bVar.a().f3713p);
        this.f21426e = dVar;
    }

    @lm.k(level = lm.m.ERROR, message = "Avoid specifying pools or use KtorDefaultPool instead.", replaceWith = @a1(expression = "KtorDefaultPool", imports = {"io.ktor.util.cio.KtorDefaultPool"}))
    public static /* synthetic */ void k() {
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0, types: [vk.a, yk.l] */
    /* JADX WARN: Type inference failed for: r9v1, types: [pl.n] */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.lang.Object, lm.l2] */
    public static Object m(l lVar, byte[] bArr, um.d dVar) {
        h hVar;
        pl.n nVar;
        if (dVar instanceof h) {
            hVar = (h) dVar;
            int i10 = hVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                hVar.label = i10 - Integer.MIN_VALUE;
            } else {
                hVar = new h(dVar);
            }
        } else {
            hVar = new h(dVar);
        }
        Object objW = hVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = hVar.label;
        try {
            if (i11 != 0) {
                if (i11 == 1) {
                    bArr = (byte[]) hVar.L$0;
                    d1.n(objW);
                } else {
                    if (i11 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    nVar = (pl.n) hVar.L$0;
                    d1.n(objW);
                }
                pl.o.a(nVar);
                lVar = l2.f10208a;
                return lVar;
            }
            d1.n(objW);
            vk.g gVarB = lVar.b();
            ik.j0.f8048a.getClass();
            String strF = gVarB.f(ik.j0.f8080q);
            if (strF != null) {
                lVar.i(Long.parseLong(strF), bArr.length);
            }
            hVar.L$0 = bArr;
            hVar.label = 1;
            objW = lVar.w(hVar);
            if (objW == aVar) {
                return aVar;
            }
            nVar = (pl.n) objW;
            nq.n0 n0VarG = nq.k1.g();
            i iVar = new i(nVar, bArr, null);
            hVar.L$0 = nVar;
            hVar.label = 2;
            if (nq.k.g(n0VarG, iVar, hVar) == aVar) {
                return aVar;
            }
            pl.o.a(nVar);
            lVar = l2.f10208a;
            return lVar;
        } catch (Throwable th2) {
            try {
                lVar.f(th2);
                throw th2;
            } catch (Throwable th3) {
                pl.o.a(lVar);
                throw th3;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:40:0x00c4 A[Catch: all -> 0x00f2, TRY_LEAVE, TryCatch #0 {all -> 0x00f2, blocks: (B:37:0x00bb, B:40:0x00c4), top: B:55:0x00bb }] */
    /* JADX WARN: Code duplicated, block: B:42:0x00d8 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:43:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v2, types: [pl.n] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r4v3, types: [pl.n] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v7 */
    public static Object o(l lVar, pl.k kVar, um.d dVar) {
        j jVar;
        pl.n nVar;
        Long l10;
        pl.n nVar2;
        long jLongValue;
        l lVar2;
        Long l11;
        long j10;
        ?? r10;
        if (dVar instanceof j) {
            jVar = (j) dVar;
            int i10 = jVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                jVar.label = i10 - Integer.MIN_VALUE;
            } else {
                jVar = lVar.new j(dVar);
            }
        } else {
            jVar = lVar.new j(dVar);
        }
        Object objW = jVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        ?? r11 = jVar.label;
        try {
            if (r11 != 0) {
                if (r11 == 1) {
                    kVar = (pl.k) jVar.L$1;
                    lVar = (l) jVar.L$0;
                    d1.n(objW);
                } else {
                    if (r11 == 2) {
                        Long l12 = (Long) jVar.L$3;
                        pl.n nVar3 = (pl.n) jVar.L$2;
                        kVar = (pl.k) jVar.L$1;
                        l lVar3 = (l) jVar.L$0;
                        d1.n(objW);
                        nVar = nVar3;
                        l10 = l12;
                        lVar = lVar3;
                        nVar2 = nVar;
                        try {
                            jLongValue = ((Number) objW).longValue();
                            if (l10 == null) {
                                r10 = nVar2;
                            } else {
                                jVar.L$0 = lVar;
                                jVar.L$1 = nVar2;
                                jVar.L$2 = l10;
                                jVar.L$3 = null;
                                jVar.J$0 = jLongValue;
                                jVar.label = 3;
                                objW = kVar.P(1L, jVar);
                                if (objW == aVar) {
                                    return aVar;
                                }
                                lVar2 = lVar;
                                l11 = l10;
                                r11 = nVar2;
                                j10 = jLongValue;
                            }
                            pl.o.a(r10);
                            return l2.f10208a;
                        } catch (Throwable th2) {
                            th = th2;
                            r11 = nVar2;
                            try {
                                r11.f(th);
                                throw th;
                            } catch (Throwable th3) {
                                pl.o.a(r11);
                                throw th3;
                            }
                        }
                    }
                    if (r11 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    j10 = jVar.J$0;
                    l11 = (Long) jVar.L$2;
                    pl.n nVar4 = (pl.n) jVar.L$1;
                    lVar2 = (l) jVar.L$0;
                    d1.n(objW);
                    r11 = nVar4;
                }
                lVar2.i(l11.longValue(), j10 + ((Number) objW).longValue());
                r10 = r11;
                pl.o.a(r10);
                return l2.f10208a;
            }
            d1.n(objW);
            jVar.L$0 = lVar;
            jVar.L$1 = kVar;
            jVar.label = 1;
            objW = lVar.w(jVar);
            if (objW == aVar) {
                return aVar;
            }
            pl.n nVar5 = (pl.n) objW;
            vk.g gVarB = lVar.b();
            ik.j0.f8048a.getClass();
            String strF = gVarB.f(ik.j0.f8080q);
            Long l13 = strF == null ? null : new Long(Long.parseLong(strF));
            nq.n0 n0VarG = nq.k1.g();
            k kVar2 = new k(kVar, nVar5, l13, null);
            jVar.L$0 = lVar;
            jVar.L$1 = kVar;
            jVar.L$2 = nVar5;
            jVar.L$3 = l13;
            jVar.label = 2;
            Object objG = nq.k.g(n0VarG, kVar2, jVar);
            if (objG == aVar) {
                return aVar;
            }
            nVar = nVar5;
            l10 = l13;
            objW = objG;
            nVar2 = nVar;
            jLongValue = ((Number) objW).longValue();
            if (l10 == null) {
                r10 = nVar2;
            } else {
                jVar.L$0 = lVar;
                jVar.L$1 = nVar2;
                jVar.L$2 = l10;
                jVar.L$3 = null;
                jVar.J$0 = jLongValue;
                jVar.label = 3;
                objW = kVar.P(1L, jVar);
                if (objW == aVar) {
                    return aVar;
                }
                lVar2 = lVar;
                l11 = l10;
                r11 = nVar2;
                j10 = jLongValue;
                lVar2.i(l11.longValue(), j10 + ((Number) objW).longValue());
                r10 = r11;
            }
            pl.o.a(r10);
            return l2.f10208a;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static Object s(l lVar, nk.s sVar, um.d dVar) throws Throwable {
        C0546l c0546l;
        pl.k kVar;
        if (dVar instanceof C0546l) {
            c0546l = (C0546l) dVar;
            int i10 = c0546l.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c0546l.label = i10 - Integer.MIN_VALUE;
            } else {
                c0546l = lVar.new C0546l(dVar);
            }
        } else {
            c0546l = lVar.new C0546l(dVar);
        }
        Object obj = c0546l.result;
        Object obj2 = wm.a.COROUTINE_SUSPENDED;
        int i11 = c0546l.label;
        if (i11 != 0) {
            if (i11 == 1) {
                d1.n(obj);
                return l2.f10208a;
            }
            if (i11 == 2) {
                d1.n(obj);
                return l2.f10208a;
            }
            if (i11 == 3) {
                d1.n(obj);
                return l2.f10208a;
            }
            if (i11 != 4) {
                if (i11 != 5) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
                return l2.f10208a;
            }
            kVar = (pl.k) c0546l.L$0;
            try {
                d1.n(obj);
                l2 l2Var = l2.f10208a;
                pl.m.a(kVar);
                return l2Var;
            } catch (Throwable th2) {
                th = th2;
                pl.m.a(kVar);
                throw th;
            }
        }
        d1.n(obj);
        if (sVar instanceof nk.s.c) {
            lVar.h(sVar);
            c0546l.label = 1;
            if (lVar.t((nk.s.c) sVar, c0546l) == obj2) {
                return obj2;
            }
            return l2.f10208a;
        }
        if (sVar instanceof nk.s.a) {
            byte[] bArrJ = ((nk.s.a) sVar).j();
            lVar.h(sVar);
            c0546l.label = 2;
            if (lVar.l(bArrJ, c0546l) == obj2) {
                return obj2;
            }
            return l2.f10208a;
        }
        if (sVar instanceof nk.s.e) {
            lVar.h(sVar);
            c0546l.label = 3;
            if (lVar.u((nk.s.e) sVar, c0546l) == obj2) {
                return obj2;
            }
            return l2.f10208a;
        }
        if (!(sVar instanceof nk.s.d)) {
            if (!(sVar instanceof nk.s.b)) {
                throw new lm.i0();
            }
            lVar.h(sVar);
            c0546l.label = 5;
            if (lVar.p((nk.s.b) sVar, c0546l) == obj2) {
                return obj2;
            }
            return l2.f10208a;
        }
        pl.k kVarJ = ((nk.s.d) sVar).j();
        try {
            lVar.h(sVar);
            c0546l.L$0 = kVarJ;
            c0546l.label = 4;
            if (lVar.n(kVarJ, c0546l) == obj2) {
                return obj2;
            }
            kVar = kVarJ;
            l2 l2Var2 = l2.f10208a;
            pl.m.a(kVar);
            return l2Var2;
        } catch (Throwable th3) {
            th = th3;
            kVar = kVarJ;
            pl.m.a(kVar);
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [yk.l] */
    /* JADX WARN: Type inference failed for: r6v1, types: [pl.n] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.lang.Object, lm.l2] */
    public static Object v(l lVar, nk.s.e eVar, um.d dVar) {
        m mVar;
        pl.n nVar;
        if (dVar instanceof m) {
            mVar = (m) dVar;
            int i10 = mVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                mVar.label = i10 - Integer.MIN_VALUE;
            } else {
                mVar = new m(dVar);
            }
        } else {
            mVar = new m(dVar);
        }
        Object objW = mVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = mVar.label;
        try {
            try {
                if (i11 != 0) {
                    if (i11 == 1) {
                        eVar = (nk.s.e) mVar.L$0;
                        d1.n(objW);
                    } else {
                        if (i11 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        nVar = (pl.n) mVar.L$0;
                        d1.n(objW);
                    }
                    pl.o.a(nVar);
                    lVar = l2.f10208a;
                    return lVar;
                }
                d1.n(objW);
                mVar.L$0 = eVar;
                mVar.label = 1;
                objW = lVar.w(mVar);
                if (objW == aVar) {
                    return aVar;
                }
                nVar = (pl.n) objW;
                nq.n0 n0VarC = nq.k1.c();
                n nVar2 = new n(eVar, nVar, null);
                mVar.L$0 = nVar;
                mVar.label = 2;
                if (nq.k.g(n0VarC, nVar2, mVar) == aVar) {
                    return aVar;
                }
                pl.o.a(nVar);
                lVar = l2.f10208a;
                return lVar;
            } catch (pl.s e10) {
                throw new gl.e(null, e10, 1, null);
            }
        } catch (Throwable th2) {
            try {
                lVar.f(th2);
                throw th2;
            } catch (Throwable th3) {
                pl.o.a(lVar);
                throw th3;
            }
        }
    }

    @Override // vk.a
    public void a(@os.l r0 r0Var) {
        kn.l0.p(r0Var, "value");
        this.f21423b = r0Var;
        x(r0Var);
    }

    @Override // vk.a
    @os.l
    public final vk.d c() {
        return this.f21426e;
    }

    @Override // vk.a
    @vk.j
    public void d(@os.l vk.h hVar) {
        kn.l0.p(hVar, "builder");
        z0.b(this, hVar.a().c(), y0.b.f8218c);
    }

    @Override // vk.a
    @os.l
    public vk.f e() {
        return (vk.f) this.f21424c.getValue();
    }

    @Override // vk.a
    @os.l
    public final dk.b f() {
        return this.f21422a;
    }

    public final void h(@os.l nk.s sVar) {
        l2 l2Var;
        kn.l0.p(sVar, t2.a.f15437d);
        if (this.f21425d) {
            throw new e();
        }
        this.f21425d = true;
        k1.a aVar = new k1.a();
        r0 r0VarG = sVar.g();
        if (r0VarG == null) {
            l2Var = null;
        } else {
            a(r0VarG);
            l2Var = l2.f10208a;
        }
        if (l2Var == null && status() == null) {
            r0.f8158c.getClass();
            a(r0.f8165g);
            l2 l2Var2 = l2.f10208a;
        }
        sVar.e().e(new f(aVar, sVar, this));
        Long lB = sVar.b();
        if (lB != null) {
            vk.g gVarB = b();
            ik.j0.f8048a.getClass();
            gVarB.b(ik.j0.f8080q, d0.a(lB.longValue()), false);
        } else if (!aVar.element && !(sVar instanceof nk.s.c)) {
            if (sVar instanceof nk.s.b) {
                vk.g gVarB2 = b();
                ik.j0.f8048a.getClass();
                gVarB2.b(ik.j0.f8080q, hi.b.f7118g, false);
            } else {
                vk.g gVarB3 = b();
                ik.j0.f8048a.getClass();
                gVarB3.b(ik.j0.f8095x0, "chunked", false);
            }
        }
        ik.i iVarC = sVar.c();
        if (iVarC != null) {
            vk.g gVarB4 = b();
            ik.j0.f8048a.getClass();
            gVarB4.b(ik.j0.f8086t, iVarC.toString(), false);
        }
        ik.b0 b0VarB = this.f21422a.d().b();
        ik.j0 j0Var = ik.j0.f8048a;
        j0Var.getClass();
        String str = ik.j0.f8072m;
        String str2 = b0VarB.get(str);
        if (str2 != null) {
            vk.g gVarB5 = this.f21422a.e().b();
            j0Var.getClass();
            if (gVarB5.d(str)) {
                return;
            }
            if (jq.e0.K1(str2, "close", true)) {
                vk.c.m(this, "Connection", "close");
            } else if (jq.e0.K1(str2, "keep-alive", true)) {
                vk.c.m(this, "Connection", "keep-alive");
            }
        }
    }

    public final void i(long j10, long j11) {
        if (j10 < j11) {
            throw new a(j10);
        }
        if (j10 > j11) {
            throw new b(j10, j11);
        }
    }

    @os.l
    public bm.h<ByteBuffer> j() {
        return gl.b.a();
    }

    @os.m
    public Object l(@os.l byte[] bArr, @os.l um.d<? super l2> dVar) {
        return m(this, bArr, dVar);
    }

    @os.m
    public Object n(@os.l pl.k kVar, @os.l um.d<? super l2> dVar) {
        return o(this, kVar, dVar);
    }

    @os.m
    public Object p(@os.l nk.s.b bVar, @os.l um.d<? super l2> dVar) {
        return l2.f10208a;
    }

    @os.m
    public Object r(@os.l nk.s sVar, @os.l um.d<? super l2> dVar) {
        return s(this, sVar, dVar);
    }

    @Override // vk.a
    @os.m
    public r0 status() {
        return this.f21423b;
    }

    @os.m
    public abstract Object t(@os.l nk.s.c cVar, @os.l um.d<? super l2> dVar);

    @os.m
    public Object u(@os.l nk.s.e eVar, @os.l um.d<? super l2> dVar) {
        return v(this, eVar, dVar);
    }

    @os.m
    public abstract Object w(@os.l um.d<? super pl.n> dVar);

    public abstract void x(@os.l r0 r0Var);
}
