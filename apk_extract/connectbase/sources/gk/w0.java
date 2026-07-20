package gk;

import fl.r1;
import ik.i1;
import ik.k1;
import io.netty.handler.codec.http.HttpHeaders;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kn.l1;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class w0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final b f6720b = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final nl.j f6721c = new nl.j("PartialContent");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final fl.b<w0> f6722d = new fl.b<>("Partial Content");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6723a;

    public static final class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ un.o<Object>[] f6724b = {l1.k(new kn.x0(a.class, "maxRangeCount", "getMaxRangeCount()I", 0))};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final qn.f f6725a;

        /* JADX INFO: renamed from: gk.w0$a$a, reason: collision with other inner class name */
        public static final class C0175a extends qn.c<Integer> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Object f6726b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0175a(Object obj) {
                super(obj);
                this.f6726b = obj;
            }

            @Override // qn.c
            public boolean d(@os.l un.o<?> oVar, Integer num, Integer num2) {
                kn.l0.p(oVar, "property");
                int iIntValue = num2.intValue();
                num.intValue();
                if (iIntValue > 0) {
                    return true;
                }
                throw new IllegalArgumentException(kn.l0.C("Bad maxRangeCount value ", Integer.valueOf(iIntValue)));
            }
        }

        public a() {
            qn.a aVar = qn.a.f14050a;
            this.f6725a = new C0175a(10);
        }

        public final int a() {
            return ((Number) this.f6725a.a(this, f6724b[0])).intValue();
        }

        public final void b(int i10) {
            this.f6725a.b(this, f6724b[0], Integer.valueOf(i10));
        }
    }

    public static final class b implements dk.h<dk.c, a, w0> {

        @xm.f(c = "io.ktor.features.PartialContent$Feature$install$1", f = "PartialContent.kt", i = {}, l = {52}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends xm.o implements jn.q<nl.f<l2, dk.b>, l2, um.d<? super l2>, Object> {
            final /* synthetic */ w0 $feature;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(w0 w0Var, um.d<? super a> dVar) {
                super(3, dVar);
                this.$feature = w0Var;
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i10 = this.label;
                if (i10 == 0) {
                    lm.d1.n(obj);
                    nl.f fVar = (nl.f) this.L$0;
                    w0 w0Var = this.$feature;
                    this.label = 1;
                    if (w0Var.k(fVar, this) == aVar) {
                        return aVar;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    lm.d1.n(obj);
                }
                return l2.f10208a;
            }

            @Override // jn.q
            @os.m
            public final Object invoke(@os.l nl.f<l2, dk.b> fVar, @os.l l2 l2Var, @os.m um.d<? super l2> dVar) {
                a aVar = new a(this.$feature, dVar);
                aVar.L$0 = fVar;
                return aVar.invokeSuspend(l2.f10208a);
            }
        }

        public b() {
        }

        @Override // dk.h
        @os.l
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public w0 a(@os.l dk.c cVar, @os.l jn.l<? super a, l2> lVar) throws nl.c {
            kn.l0.p(cVar, "pipeline");
            kn.l0.p(lVar, "configure");
            a aVar = new a();
            lVar.invoke(aVar);
            w0 w0Var = new w0(aVar.a());
            dk.c.f3706v.getClass();
            cVar.x(dk.c.f3709y, new a(w0Var, null));
            return w0Var;
        }

        @Override // dk.h
        @os.l
        public fl.b<w0> getKey() {
            return w0.f6722d;
        }

        public b(kn.w wVar) {
        }
    }

    public static abstract class c extends nk.s.d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public final nk.s.d f6727b;

        public static final class a extends c {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            @os.l
            public final lm.d0 f6728c;

            /* JADX INFO: renamed from: gk.w0$c$a$a, reason: collision with other inner class name */
            public static final class C0176a extends kn.n0 implements jn.a<ik.b0> {
                final /* synthetic */ nk.s.d $original;
                final /* synthetic */ a this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0176a(nk.s.d dVar, a aVar) {
                    super(0);
                    this.$original = dVar;
                    this.this$0 = aVar;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // jn.a
                @os.l
                public final ik.b0 invoke() {
                    ik.b0.a aVar = ik.b0.f7939b;
                    nk.s.d dVar = this.$original;
                    a aVar2 = this.this$0;
                    ik.c0 c0Var = new ik.c0(0, 1, null);
                    c0Var.b(dVar.e());
                    aVar2.l(c0Var);
                    return c0Var.f();
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(@os.l nk.s.d dVar) {
                super(dVar);
                kn.l0.p(dVar, "original");
                this.f6728c = lm.f0.c(lm.h0.NONE, new C0176a(dVar, this));
            }

            @Override // nk.s
            @os.m
            public Long b() {
                return this.f6727b.b();
            }

            @Override // nk.s
            @os.l
            public ik.b0 e() {
                return (ik.b0) this.f6728c.getValue();
            }

            @Override // nk.s.d
            @os.l
            public pl.k j() {
                return this.f6727b.j();
            }
        }

        public static final class b extends c implements nq.s0 {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            @os.l
            public final um.g f6729c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final boolean f6730d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            @os.l
            public final List<tn.o> f6731e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final long f6732f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            @os.l
            public final String f6733g;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            @os.m
            public final Long f6734i;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            @os.l
            public final lm.d0 f6735n;

            public static final class a extends kn.n0 implements jn.a<ik.b0> {
                final /* synthetic */ nk.s.d $original;
                final /* synthetic */ b this$0;

                /* JADX INFO: renamed from: gk.w0$c$b$a$a, reason: collision with other inner class name */
                public static final class C0177a extends kn.n0 implements jn.p<String, String, Boolean> {
                    public static final C0177a INSTANCE = new C0177a();

                    public C0177a() {
                        super(2);
                    }

                    /* JADX WARN: Code duplicated, block: B:7:0x0024  */
                    @Override // jn.p
                    @os.l
                    public final Boolean invoke(@os.l String str, @os.l String str2) {
                        boolean z10;
                        kn.l0.p(str, "name");
                        kn.l0.p(str2, "$noName_1");
                        ik.j0 j0Var = ik.j0.f8048a;
                        j0Var.getClass();
                        if (!jq.e0.K1(str, ik.j0.f8086t, true)) {
                            j0Var.getClass();
                            z10 = jq.e0.K1(str, ik.j0.f8080q, true) ? false : true;
                        }
                        return Boolean.valueOf(z10);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public a(nk.s.d dVar, b bVar) {
                    super(0);
                    this.$original = dVar;
                    this.this$0 = bVar;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // jn.a
                @os.l
                public final ik.b0 invoke() {
                    ik.b0.a aVar = ik.b0.f7939b;
                    nk.s.d dVar = this.$original;
                    b bVar = this.this$0;
                    ik.c0 c0Var = new ik.c0(0, 1, null);
                    r1.e(c0Var, dVar.e(), false, C0177a.INSTANCE, 2, null);
                    bVar.l(c0Var);
                    return c0Var.f();
                }
            }

            /* JADX INFO: renamed from: gk.w0$c$b$b, reason: collision with other inner class name */
            public static final class C0178b extends kn.n0 implements jn.l<tn.o, pl.k> {
                public C0178b() {
                    super(1);
                }

                @Override // jn.l
                @os.l
                public final pl.k invoke(@os.l tn.o oVar) {
                    kn.l0.p(oVar, "range");
                    return b.this.f6727b.k(oVar);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(@os.l um.g gVar, boolean z10, @os.l nk.s.d dVar, @os.l List<tn.o> list, long j10, @os.l String str) {
                super(dVar);
                kn.l0.p(gVar, "coroutineContext");
                kn.l0.p(dVar, "original");
                kn.l0.p(list, "ranges");
                kn.l0.p(str, HttpHeaders.Values.BOUNDARY);
                this.f6729c = gVar;
                this.f6730d = z10;
                this.f6731e = list;
                this.f6732f = j10;
                this.f6733g = str;
                this.f6734i = Long.valueOf(p0.d(list, Long.valueOf(j10), str, String.valueOf(dVar.c())));
                this.f6735n = lm.f0.c(lm.h0.NONE, new a(dVar, this));
            }

            @Override // nk.s
            @os.m
            public Long b() {
                return this.f6734i;
            }

            @Override // gk.w0.c, nk.s
            @os.m
            public ik.i c() {
                ik.i.f.f8020a.getClass();
                return ik.i.f.f8028i.j(HttpHeaders.Values.BOUNDARY, this.f6733g);
            }

            @Override // nk.s
            @os.l
            public ik.b0 e() {
                return (ik.b0) this.f6735n.getValue();
            }

            @Override // gk.w0.c, nk.s
            @os.m
            public ik.r0 g() {
                if (!this.f6730d) {
                    return this.f6727b.g();
                }
                ik.r0.f8158c.getClass();
                return ik.r0.f8171m;
            }

            @Override // nq.s0
            @os.l
            public um.g getCoroutineContext() {
                return this.f6729c;
            }

            @Override // nk.s.d
            @os.l
            public pl.k j() {
                return p0.g(this, new C0178b(), this.f6731e, Long.valueOf(this.f6732f), this.f6733g, String.valueOf(this.f6727b.c()));
            }

            @os.l
            public final String n() {
                return this.f6733g;
            }

            public final boolean o() {
                return this.f6730d;
            }

            public final long p() {
                return this.f6732f;
            }

            @os.l
            public final List<tn.o> r() {
                return this.f6731e;
            }
        }

        /* JADX INFO: renamed from: gk.w0$c$c, reason: collision with other inner class name */
        public static final class C0179c extends c {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final boolean f6736c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            @os.l
            public final tn.o f6737d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final long f6738e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            @os.l
            public final lm.d0 f6739f;

            /* JADX INFO: renamed from: gk.w0$c$c$a */
            public static final class a extends kn.n0 implements jn.a<ik.b0> {
                final /* synthetic */ nk.s.d $original;
                final /* synthetic */ C0179c this$0;

                /* JADX INFO: renamed from: gk.w0$c$c$a$a, reason: collision with other inner class name */
                public static final class C0180a extends kn.n0 implements jn.p<String, String, Boolean> {
                    public static final C0180a INSTANCE = new C0180a();

                    public C0180a() {
                        super(2);
                    }

                    @Override // jn.p
                    @os.l
                    public final Boolean invoke(@os.l String str, @os.l String str2) {
                        kn.l0.p(str, "name");
                        kn.l0.p(str2, "$noName_1");
                        ik.j0.f8048a.getClass();
                        return Boolean.valueOf(!jq.e0.K1(str, ik.j0.f8080q, true));
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public a(nk.s.d dVar, C0179c c0179c) {
                    super(0);
                    this.$original = dVar;
                    this.this$0 = c0179c;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // jn.a
                @os.l
                public final ik.b0 invoke() {
                    ik.b0.a aVar = ik.b0.f7939b;
                    nk.s.d dVar = this.$original;
                    C0179c c0179c = this.this$0;
                    ik.c0 c0Var = new ik.c0(0, 1, null);
                    r1.e(c0Var, dVar.e(), false, C0180a.INSTANCE, 2, null);
                    c0179c.l(c0Var);
                    vk.c.f(c0Var, c0179c.f6737d, Long.valueOf(c0179c.f6738e), null, 4, null);
                    return c0Var.f();
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0179c(boolean z10, @os.l nk.s.d dVar, @os.l tn.o oVar, long j10) {
                super(dVar);
                kn.l0.p(dVar, "original");
                kn.l0.p(oVar, "range");
                this.f6736c = z10;
                this.f6737d = oVar;
                this.f6738e = j10;
                this.f6739f = lm.f0.c(lm.h0.NONE, new a(dVar, this));
            }

            @Override // nk.s
            @os.m
            public Long b() {
                return Long.valueOf((this.f6737d.f15922b - this.f6737d.f15921a) + 1);
            }

            @Override // nk.s
            @os.l
            public ik.b0 e() {
                return (ik.b0) this.f6739f.getValue();
            }

            @Override // gk.w0.c, nk.s
            @os.m
            public ik.r0 g() {
                if (!this.f6736c) {
                    return this.f6727b.g();
                }
                ik.r0.f8158c.getClass();
                return ik.r0.f8171m;
            }

            @Override // nk.s.d
            @os.l
            public pl.k j() {
                return this.f6727b.k(this.f6737d);
            }

            public final long n() {
                return this.f6738e;
            }

            public final boolean o() {
                return this.f6736c;
            }

            @os.l
            public final tn.o p() {
                return this.f6737d;
            }
        }

        public /* synthetic */ c(nk.s.d dVar, kn.w wVar) {
            this(dVar);
        }

        @Override // nk.s
        @os.m
        public ik.i c() {
            return this.f6727b.c();
        }

        @Override // nk.s
        @os.m
        public <T> T f(@os.l fl.b<T> bVar) {
            kn.l0.p(bVar, cb.b.c.f1408o);
            return (T) this.f6727b.f(bVar);
        }

        @Override // nk.s
        @os.m
        public ik.r0 g() {
            return this.f6727b.g();
        }

        @Override // nk.s
        public <T> void i(@os.l fl.b<T> bVar, @os.m T t10) {
            kn.l0.p(bVar, cb.b.c.f1408o);
            this.f6727b.i(bVar, t10);
        }

        public final void l(@os.l ik.c0 c0Var) {
            kn.l0.p(c0Var, "<this>");
            ik.j0 j0Var = ik.j0.f8048a;
            j0Var.getClass();
            String str = ik.j0.f8058f;
            i1 i1Var = i1.Bytes;
            if (c0Var.i(str, i1Var.getUnitToken())) {
                return;
            }
            j0Var.getClass();
            c0Var.a(str, i1Var.getUnitToken());
        }

        @os.l
        public final nk.s.d m() {
            return this.f6727b;
        }

        public c(nk.s.d dVar) {
            this.f6727b = dVar;
        }
    }

    @xm.f(c = "io.ktor.features.PartialContent", f = "PartialContent.kt", i = {0, 0, 0}, l = {y5.a.f20736o0}, m = "checkIfRangeHeader", n = {"this", t2.a.f15437d, "ifRange"}, s = {"L$0", "L$1", "L$2"})
    public static final class d extends xm.d {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public d(um.d<? super d> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return w0.this.i(null, null, this);
        }
    }

    @xm.f(c = "io.ktor.features.PartialContent", f = "PartialContent.kt", i = {0}, l = {337}, m = "intercept", n = {"context"}, s = {"L$0"})
    public static final class e extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public e(um.d<? super e> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return w0.this.k(null, this);
        }
    }

    @xm.f(c = "io.ktor.features.PartialContent$intercept$2", f = "PartialContent.kt", i = {}, l = {64}, m = "invokeSuspend", n = {}, s = {})
    public static final class f extends xm.o implements jn.q<nl.f<Object, dk.b>, Object, um.d<? super l2>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        public f(um.d<? super f> dVar) {
            super(3, dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                lm.d1.n(obj);
                nl.f fVar = (nl.f) this.L$0;
                Object obj2 = this.L$1;
                if ((obj2 instanceof nk.s.d) && !(obj2 instanceof c)) {
                    c.a aVar2 = new c.a((nk.s.d) obj2);
                    this.L$0 = null;
                    this.label = 1;
                    if (fVar.v0(aVar2, this) == aVar) {
                        return aVar;
                    }
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                lm.d1.n(obj);
            }
            return l2.f10208a;
        }

        @Override // jn.q
        @os.m
        public final Object invoke(@os.l nl.f<Object, dk.b> fVar, @os.l Object obj, @os.m um.d<? super l2> dVar) {
            f fVar2 = new f(dVar);
            fVar2.L$0 = fVar;
            fVar2.L$1 = obj;
            return fVar2.invokeSuspend(l2.f10208a);
        }
    }

    @xm.f(c = "io.ktor.features.PartialContent$intercept$3", f = "PartialContent.kt", i = {}, l = {83}, m = "invokeSuspend", n = {}, s = {})
    public static final class g extends xm.o implements jn.q<nl.f<Object, dk.b>, Object, um.d<? super l2>, Object> {
        final /* synthetic */ dk.b $call;
        final /* synthetic */ k1 $rangeSpecifier;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(dk.b bVar, k1 k1Var, um.d<? super g> dVar) {
            super(3, dVar);
            this.$call = bVar;
            this.$rangeSpecifier = k1Var;
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                lm.d1.n(obj);
                nl.f fVar = (nl.f) this.L$0;
                Object obj2 = this.L$1;
                if ((obj2 instanceof nk.s.d) && !(obj2 instanceof c)) {
                    nk.s.d dVar = (nk.s.d) obj2;
                    Long lB = dVar.b();
                    if (lB == null) {
                        return l2.f10208a;
                    }
                    long jLongValue = lB.longValue();
                    w0 w0Var = w0.this;
                    dk.b bVar = this.$call;
                    k1 k1Var = this.$rangeSpecifier;
                    this.L$0 = null;
                    this.label = 1;
                    if (w0Var.r(fVar, dVar, bVar, k1Var, jLongValue, this) == aVar) {
                        return aVar;
                    }
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                lm.d1.n(obj);
            }
            return l2.f10208a;
        }

        @Override // jn.q
        @os.m
        public final Object invoke(@os.l nl.f<Object, dk.b> fVar, @os.l Object obj, @os.m um.d<? super l2> dVar) {
            g gVar = w0.this.new g(this.$call, this.$rangeSpecifier, dVar);
            gVar.L$0 = fVar;
            gVar.L$1 = obj;
            return gVar.invokeSuspend(l2.f10208a);
        }
    }

    @xm.f(c = "io.ktor.features.PartialContent", f = "PartialContent.kt", i = {0, 0, 0, 0, 0}, l = {98, 99, 101}, m = "tryProcessRange", n = {"this", "$this$tryProcessRange", t2.a.f15437d, "rangesSpecifier", "length"}, s = {"L$0", "L$1", "L$2", "L$3", "J$0"})
    public static final class h extends xm.d {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
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
            return w0.this.r(null, null, null, null, 0L, this);
        }
    }

    public w0(int i10) {
        this.f6723a = i10;
    }

    public final boolean h(nk.i iVar, List<? extends nk.a0> list) {
        List<? extends nk.a0> list2 = list;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            return true;
        }
        for (nk.a0 a0Var : list2) {
            if (!(a0Var instanceof nk.i ? kn.l0.g(iVar.f11524a, ((nk.i) a0Var).f11524a) : true)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:48:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:54:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:57:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:59:0x0108  */
    /* JADX WARN: Code duplicated, block: B:60:0x010f  */
    /* JADX WARN: Code duplicated, block: B:62:0x0113  */
    /* JADX WARN: Code duplicated, block: B:63:0x011a  */
    /* JADX WARN: Code duplicated, block: B:73:0x011d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:78:? A[LOOP:0: B:55:0x00f8->B:78:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object i(nk.s.d dVar, dk.b bVar, um.d<? super Boolean> dVar2) {
        d dVar3;
        List<nk.a0> listA;
        List<nk.a0> listG;
        List<nk.a0> list;
        boolean zH;
        if (dVar2 instanceof d) {
            dVar3 = (d) dVar2;
            int i10 = dVar3.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                dVar3.label = i10 - Integer.MIN_VALUE;
            } else {
                dVar3 = new d(dVar2);
            }
        } else {
            dVar3 = new d(dVar2);
        }
        Object objD = dVar3.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = dVar3.label;
        boolean z10 = true;
        if (i11 == 0) {
            lm.d1.n(objD);
            r rVar = (r) dk.i.b(bVar.a(), r.f6699b);
            try {
                ik.b0 b0VarB = bVar.d().b();
                ik.j0.f8048a.getClass();
                List<String> listB = b0VarB.b(ik.j0.L);
                listA = null;
                if (listB == null) {
                    listG = null;
                } else {
                    List<String> list2 = listB;
                    ArrayList arrayList = new ArrayList(nm.z.b0(list2, 10));
                    Iterator<T> it = list2.iterator();
                    while (it.hasNext()) {
                        arrayList.add(x0.e((String) it.next()));
                    }
                    if (arrayList.isEmpty()) {
                        arrayList = null;
                    }
                    if (arrayList != null) {
                        Iterator it2 = arrayList.iterator();
                        if (!it2.hasNext()) {
                            throw new UnsupportedOperationException("Empty collection can't be reduced.");
                        }
                        Object next = it2.next();
                        while (it2.hasNext()) {
                            next = nm.h0.E4((List) next, (List) it2.next());
                        }
                        List list3 = (List) next;
                        if (list3 != null) {
                            listG = x0.g(list3);
                        }
                    }
                    listG = null;
                }
                if (listG == null) {
                    return Boolean.TRUE;
                }
                if (rVar != null) {
                    dVar3.L$0 = this;
                    dVar3.L$1 = dVar;
                    dVar3.L$2 = listG;
                    dVar3.label = 1;
                    objD = rVar.d(dVar, dVar3);
                    if (objD == aVar) {
                        return aVar;
                    }
                }
                if (listA == null) {
                    listA = s.a(dVar);
                }
                list = listA;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    for (nk.a0 a0Var : list) {
                        if (a0Var instanceof nk.m) {
                            zH = this.j((nk.m) a0Var, listG);
                        } else if (a0Var instanceof nk.i) {
                            zH = this.h((nk.i) a0Var, listG);
                        } else {
                            zH = true;
                        }
                        if (!zH) {
                            z10 = false;
                            break;
                        }
                    }
                }
                return Boolean.valueOf(z10);
            } catch (Throwable unused) {
                return Boolean.FALSE;
            }
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        List<nk.a0> list4 = (List) dVar3.L$2;
        dVar = (nk.s.d) dVar3.L$1;
        w0 w0Var = (w0) dVar3.L$0;
        lm.d1.n(objD);
        listG = list4;
        this = w0Var;
        listA = (List) objD;
        if (listA == null) {
            listA = s.a(dVar);
        }
        list = listA;
        if (!(list instanceof Collection)) {
            while (r8.hasNext()) {
                if (a0Var instanceof nk.m) {
                    zH = this.j((nk.m) a0Var, listG);
                } else if (a0Var instanceof nk.i) {
                    zH = this.h((nk.i) a0Var, listG);
                } else {
                    zH = true;
                }
                if (!zH) {
                    z10 = false;
                    break;
                }
            }
        } else {
            while (r8.hasNext()) {
                if (a0Var instanceof nk.m) {
                    zH = this.j((nk.m) a0Var, listG);
                } else if (a0Var instanceof nk.i) {
                    zH = this.h((nk.i) a0Var, listG);
                } else {
                    zH = true;
                }
                if (!zH) {
                    z10 = false;
                    break;
                }
            }
        }
        return Boolean.valueOf(z10);
    }

    public final boolean j(nk.m mVar, List<? extends nk.a0> list) {
        kl.d dVarE = kl.b.e(mVar.f11535a);
        List<? extends nk.a0> list2 = list;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            return true;
        }
        for (nk.a0 a0Var : list2) {
            if ((a0Var instanceof nk.m) && dVarE.compareTo(((nk.m) a0Var).f11535a) > 0) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object k(nl.f<l2, dk.b> fVar, um.d<? super l2> dVar) throws nl.c {
        e eVar;
        if (dVar instanceof e) {
            eVar = (e) dVar;
            int i10 = eVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                eVar.label = i10 - Integer.MIN_VALUE;
            } else {
                eVar = new e(dVar);
            }
        } else {
            eVar = new e(dVar);
        }
        Object obj = eVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = eVar.label;
        if (i11 == 0) {
            lm.d1.n(obj);
            dk.b context = fVar.getContext();
            k1 k1VarY = uk.e.y(context.d());
            if (k1VarY == null) {
                q(context.e().c());
                context.e().c().x(f6721c, new f(null));
                return l2.f10208a;
            }
            if (m(context)) {
                q(context.e().c());
                fl.c cVarC = context.c();
                l.f6660c.getClass();
                cVarC.g(l.f6661d, Boolean.TRUE);
                context.e().c().x(f6721c, new g(context, k1VarY, null));
                return l2.f10208a;
            }
            ik.r0.f8158c.getClass();
            ik.r0 r0VarG0 = ik.r0.C.g0("Method " + context.d().g().getMethod().f8144a + " is not allowed with range request");
            if (!(r0VarG0 instanceof byte[])) {
                try {
                    vk.i.b(context.e(), l1.A(ik.r0.class));
                } catch (Throwable unused) {
                }
            }
            vk.d dVarC = context.e().c();
            eVar.L$0 = fVar;
            eVar.label = 1;
            if (dVarC.g(context, r0VarG0, eVar) == aVar) {
                return aVar;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            fVar = (nl.f) eVar.L$0;
            lm.d1.n(obj);
        }
        fVar.finish();
        return l2.f10208a;
    }

    public final boolean l(dk.b bVar) {
        ik.p0 method = bVar.d().g().getMethod();
        ik.p0.f8135b.getClass();
        return kn.l0.g(method, ik.p0.f8136c);
    }

    public final boolean m(dk.b bVar) {
        if (!l(bVar)) {
            ik.p0 method = bVar.d().g().getMethod();
            ik.p0.f8135b.getClass();
            if (!kn.l0.g(method, ik.p0.f8141h)) {
                return false;
            }
        }
        return true;
    }

    public final Object n(nl.f<Object, dk.b> fVar, nk.s.d dVar, List<tn.o> list, long j10, um.d<? super l2> dVar2) {
        String strC = kn.l0.C("ktor-boundary-", fl.a0.c());
        fl.c cVarC = fVar.getContext().c();
        l.f6660c.getClass();
        cVarC.g(l.f6661d, Boolean.TRUE);
        Object objV0 = fVar.v0(new c.b(fVar.getCoroutineContext(), l(fVar.getContext()), dVar, list, j10, strC), dVar2);
        return objV0 == wm.a.COROUTINE_SUSPENDED ? objV0 : l2.f10208a;
    }

    public final Object o(nl.f<Object, dk.b> fVar, nk.s.d dVar, k1 k1Var, long j10, um.d<? super l2> dVar2) {
        if (j10 < 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        List<tn.o> listJ = k1Var.j(j10, this.f6723a);
        if (listJ.isEmpty()) {
            vk.c.h(fVar.getContext().e(), null, new Long(j10), null, 4, null);
            ik.r0.f8158c.getClass();
            Object objV0 = fVar.v0(new nk.j(ik.r0.N.g0("Couldn't satisfy range request " + k1Var + ": it should comply with the restriction [0; " + j10 + ')')), dVar2);
            return objV0 == wm.a.COROUTINE_SUSPENDED ? objV0 : l2.f10208a;
        }
        if (listJ.size() != 1 && !x0.d(listJ)) {
            tn.o oVarL = k1Var.l(j10);
            kn.l0.m(oVarL);
            Object objP = p(fVar, dVar, oVarL, j10, dVar2);
            return objP == wm.a.COROUTINE_SUSPENDED ? objP : l2.f10208a;
        }
        if (listJ.size() == 1) {
            Object objP2 = p(fVar, dVar, (tn.o) nm.h0.h5(listJ), j10, dVar2);
            return objP2 == wm.a.COROUTINE_SUSPENDED ? objP2 : l2.f10208a;
        }
        Object objN = n(fVar, dVar, listJ, j10, dVar2);
        return objN == wm.a.COROUTINE_SUSPENDED ? objN : l2.f10208a;
    }

    public final Object p(nl.f<Object, dk.b> fVar, nk.s.d dVar, tn.o oVar, long j10, um.d<? super l2> dVar2) {
        Object objV0 = fVar.v0(new c.C0179c(l(fVar.getContext()), dVar, oVar, j10), dVar2);
        return objV0 == wm.a.COROUTINE_SUSPENDED ? objV0 : l2.f10208a;
    }

    public final void q(vk.d dVar) throws nl.c {
        vk.d.f17581n.getClass();
        dVar.u(vk.d.f17585x, f6721c);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object r(nl.f<Object, dk.b> fVar, nk.s.d dVar, dk.b bVar, k1 k1Var, long j10, um.d<? super l2> dVar2) {
        h hVar;
        if (dVar2 instanceof h) {
            hVar = (h) dVar2;
            int i10 = hVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                hVar.label = i10 - Integer.MIN_VALUE;
            } else {
                hVar = new h(dVar2);
            }
        } else {
            hVar = new h(dVar2);
        }
        Object objI = hVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = hVar.label;
        if (i11 == 0) {
            lm.d1.n(objI);
            hVar.L$0 = this;
            hVar.L$1 = fVar;
            hVar.L$2 = dVar;
            hVar.L$3 = k1Var;
            hVar.J$0 = j10;
            hVar.label = 1;
            objI = i(dVar, bVar, hVar);
            if (objI == aVar) {
                return aVar;
            }
        } else {
            if (i11 != 1) {
                if (i11 == 2) {
                    lm.d1.n(objI);
                    return l2.f10208a;
                }
                if (i11 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                lm.d1.n(objI);
                return l2.f10208a;
            }
            j10 = hVar.J$0;
            k1Var = (k1) hVar.L$3;
            dVar = (nk.s.d) hVar.L$2;
            fVar = (nl.f) hVar.L$1;
            this = (w0) hVar.L$0;
            lm.d1.n(objI);
        }
        k1 k1Var2 = k1Var;
        long j11 = j10;
        if (((Boolean) objI).booleanValue()) {
            hVar.L$0 = null;
            hVar.L$1 = null;
            hVar.L$2 = null;
            hVar.L$3 = null;
            hVar.label = 2;
            if (this.o(fVar, dVar, k1Var2, j11, hVar) == aVar) {
                return aVar;
            }
            return l2.f10208a;
        }
        c.a aVar2 = new c.a(dVar);
        hVar.L$0 = null;
        hVar.L$1 = null;
        hVar.L$2 = null;
        hVar.L$3 = null;
        hVar.label = 3;
        if (fVar.v0(aVar2, hVar) == aVar) {
            return aVar;
        }
        return l2.f10208a;
    }
}
