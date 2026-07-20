package gk;

import fl.r1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lm.l2;
import nm.f1;

/* JADX INFO: loaded from: classes2.dex */
public final class l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final d f6660c = new d();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final fl.b<Boolean> f6661d = new fl.b<>("preventCompression");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public static final fl.b<l> f6662e = new fl.b<>("Compression");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final q f6663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Comparator<lm.t0<o, ik.x>> f6664b;

    public static final class a extends nk.s.d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public final nk.s f6665b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @os.l
        public final jn.a<pl.k> f6666c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @os.l
        public final String f6667d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @os.l
        public final m f6668e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @os.l
        public final lm.d0 f6669f;

        /* JADX INFO: renamed from: gk.l$a$a, reason: collision with other inner class name */
        public static final class C0168a extends kn.n0 implements jn.a<ik.b0> {

            /* JADX INFO: renamed from: gk.l$a$a$a, reason: collision with other inner class name */
            public static final class C0169a extends kn.n0 implements jn.p<String, String, Boolean> {
                public static final C0169a INSTANCE = new C0169a();

                public C0169a() {
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

            public C0168a() {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // jn.a
            @os.l
            public final ik.b0 invoke() {
                ik.b0.a aVar = ik.b0.f7939b;
                a aVar2 = a.this;
                ik.c0 c0Var = new ik.c0(0, 1, null);
                r1.e(c0Var, aVar2.f6665b.e(), false, C0169a.INSTANCE, 2, null);
                ik.j0.f8048a.getClass();
                c0Var.a(ik.j0.f8076o, aVar2.f6667d);
                return c0Var.f();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(@os.l nk.s sVar, @os.l jn.a<? extends pl.k> aVar, @os.l String str, @os.l m mVar) {
            kn.l0.p(sVar, "original");
            kn.l0.p(aVar, "delegateChannel");
            kn.l0.p(str, "encoding");
            kn.l0.p(mVar, "encoder");
            this.f6665b = sVar;
            this.f6666c = aVar;
            this.f6667d = str;
            this.f6668e = mVar;
            this.f6669f = lm.f0.c(lm.h0.NONE, new C0168a());
        }

        @Override // nk.s
        @os.m
        public Long b() {
            Long lB = this.f6665b.b();
            if (lB == null) {
                return null;
            }
            Long lC = this.f6668e.c(lB.longValue());
            if (lC != null && lC.longValue() >= 0) {
                return lC;
            }
            return null;
        }

        @Override // nk.s
        @os.m
        public ik.i c() {
            return this.f6665b.c();
        }

        @Override // nk.s
        @os.l
        public ik.b0 e() {
            return (ik.b0) this.f6669f.getValue();
        }

        @Override // nk.s
        @os.m
        public <T> T f(@os.l fl.b<T> bVar) {
            kn.l0.p(bVar, cb.b.c.f1408o);
            return (T) this.f6665b.f(bVar);
        }

        @Override // nk.s
        @os.m
        public ik.r0 g() {
            return this.f6665b.g();
        }

        @Override // nk.s
        public <T> void i(@os.l fl.b<T> bVar, @os.m T t10) {
            kn.l0.p(bVar, cb.b.c.f1408o);
            this.f6665b.i(bVar, t10);
        }

        @Override // nk.s.d
        @os.l
        public pl.k j() {
            return m.a.a(this.f6668e, this.f6666c.invoke(), null, 2, null);
        }

        @os.l
        public final jn.a<pl.k> l() {
            return this.f6666c;
        }

        @os.l
        public final m m() {
            return this.f6668e;
        }

        @os.l
        public final String n() {
            return this.f6667d;
        }

        @os.l
        public final nk.s o() {
            return this.f6665b;
        }
    }

    public static final class b extends nk.s.e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public final nk.s.e f6670b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @os.l
        public final String f6671c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @os.l
        public final m f6672d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @os.l
        public final lm.d0 f6673e;

        public static final class a extends kn.n0 implements jn.a<ik.b0> {

            /* JADX INFO: renamed from: gk.l$b$a$a, reason: collision with other inner class name */
            public static final class C0170a extends kn.n0 implements jn.p<String, String, Boolean> {
                public static final C0170a INSTANCE = new C0170a();

                public C0170a() {
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

            public a() {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // jn.a
            @os.l
            public final ik.b0 invoke() {
                ik.b0.a aVar = ik.b0.f7939b;
                b bVar = b.this;
                ik.c0 c0Var = new ik.c0(0, 1, null);
                r1.e(c0Var, bVar.f6670b.e(), false, C0170a.INSTANCE, 2, null);
                ik.j0.f8048a.getClass();
                c0Var.a(ik.j0.f8076o, bVar.f6671c);
                return c0Var.f();
            }
        }

        /* JADX INFO: renamed from: gk.l$b$b, reason: collision with other inner class name */
        @xm.f(c = "io.ktor.features.Compression$CompressedWriteResponse$writeTo$2", f = "Compression.kt", i = {0}, l = {169}, m = "invokeSuspend", n = {"$this$use$iv"}, s = {"L$0"})
        public static final class C0171b extends xm.o implements jn.p<nq.s0, um.d<? super l2>, Object> {
            final /* synthetic */ pl.n $channel;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0171b(pl.n nVar, um.d<? super C0171b> dVar) {
                super(2, dVar);
                this.$channel = nVar;
            }

            @Override // xm.a
            @os.l
            public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
                C0171b c0171b = b.this.new C0171b(this.$channel, dVar);
                c0171b.L$0 = obj;
                return c0171b;
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                Throwable th2;
                pl.n nVar;
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i10 = this.label;
                if (i10 != 0) {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    nVar = (pl.n) this.L$0;
                    try {
                        lm.d1.n(obj);
                        pl.o.a(nVar);
                        return l2.f10208a;
                    } catch (Throwable th3) {
                        th2 = th3;
                        try {
                            nVar.f(th2);
                            throw th2;
                        } catch (Throwable th4) {
                            pl.o.a(nVar);
                            throw th4;
                        }
                    }
                }
                lm.d1.n(obj);
                pl.n nVarA = b.this.f6672d.a(this.$channel, ((nq.s0) this.L$0).getCoroutineContext());
                try {
                    nk.s.e eVar = b.this.f6670b;
                    this.L$0 = nVarA;
                    this.label = 1;
                    if (eVar.j(nVarA, this) == aVar) {
                        return aVar;
                    }
                    nVar = nVarA;
                    pl.o.a(nVar);
                    return l2.f10208a;
                } catch (Throwable th5) {
                    th2 = th5;
                    nVar = nVarA;
                    nVar.f(th2);
                    throw th2;
                }
            }

            @Override // jn.p
            @os.m
            public final Object invoke(@os.l nq.s0 s0Var, @os.m um.d<? super l2> dVar) {
                return ((C0171b) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
            }
        }

        public b(@os.l nk.s.e eVar, @os.l String str, @os.l m mVar) {
            kn.l0.p(eVar, "original");
            kn.l0.p(str, "encoding");
            kn.l0.p(mVar, "encoder");
            this.f6670b = eVar;
            this.f6671c = str;
            this.f6672d = mVar;
            this.f6673e = lm.f0.c(lm.h0.NONE, new a());
        }

        @Override // nk.s
        @os.m
        public Long b() {
            Long lB = this.f6670b.b();
            if (lB == null) {
                return null;
            }
            Long lC = this.f6672d.c(lB.longValue());
            if (lC != null && lC.longValue() >= 0) {
                return lC;
            }
            return null;
        }

        @Override // nk.s
        @os.m
        public ik.i c() {
            return this.f6670b.c();
        }

        @Override // nk.s
        @os.l
        public ik.b0 e() {
            return (ik.b0) this.f6673e.getValue();
        }

        @Override // nk.s
        @os.m
        public <T> T f(@os.l fl.b<T> bVar) {
            kn.l0.p(bVar, cb.b.c.f1408o);
            return (T) this.f6670b.f(bVar);
        }

        @Override // nk.s
        @os.m
        public ik.r0 g() {
            return this.f6670b.g();
        }

        @Override // nk.s
        public <T> void i(@os.l fl.b<T> bVar, @os.m T t10) {
            kn.l0.p(bVar, cb.b.c.f1408o);
            this.f6670b.i(bVar, t10);
        }

        @Override // nk.s.e
        @os.m
        public Object j(@os.l pl.n nVar, @os.l um.d<? super l2> dVar) {
            Object objG = nq.t0.g(new C0171b(nVar, null), dVar);
            return objG == wm.a.COROUTINE_SUSPENDED ? objG : l2.f10208a;
        }

        @os.l
        public final m k() {
            return this.f6672d;
        }

        @os.l
        public final String l() {
            return this.f6671c;
        }

        @os.l
        public final nk.s.e m() {
            return this.f6670b;
        }
    }

    public static final class c implements t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final Map<String, n> f6674a = new HashMap();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public final List<jn.p<dk.b, nk.s, Boolean>> f6675b = new ArrayList();

        public static final class a extends kn.n0 implements jn.l<n, l2> {
            public static final a INSTANCE = new a();

            public a() {
                super(1);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@os.l n nVar) {
                kn.l0.p(nVar, "$this$null");
            }

            @Override // jn.l
            public /* bridge */ /* synthetic */ l2 invoke(n nVar) {
                invoke2(nVar);
                return l2.f10208a;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void f(c cVar, String str, m mVar, jn.l lVar, int i10, Object obj) {
            if ((i10 & 4) != 0) {
                lVar = a.INSTANCE;
            }
            cVar.e(str, mVar, lVar);
        }

        @Override // gk.t
        @os.l
        public List<jn.p<dk.b, nk.s, Boolean>> a() {
            return this.f6675b;
        }

        @lm.k(message = "This is going to become internal. Please stop building it manually or file a ticket with explanation why do you need it.")
        @os.l
        public final q b() {
            return c();
        }

        @os.l
        public final q c() {
            Map<String, n> map = this.f6674a;
            LinkedHashMap linkedHashMap = new LinkedHashMap(nm.c1.j(map.size()));
            Iterator<T> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                Object key = entry.getKey();
                n nVar = (n) entry.getValue();
                if (nm.h0.u4(this.f6675b) && nm.h0.u4(nVar.f6678c)) {
                    p.d(nVar);
                }
                linkedHashMap.put(key, nVar.c());
            }
            return new q(linkedHashMap, nm.h0.V5(this.f6675b));
        }

        public final void d() {
            p.i(this, null, 1, null);
            p.f(this, null, 1, null);
            p.k(this, null, 1, null);
        }

        public final void e(@os.l String str, @os.l m mVar, @os.l jn.l<? super n, l2> lVar) {
            kn.l0.p(str, "name");
            kn.l0.p(mVar, "encoder");
            kn.l0.p(lVar, "block");
            if (jq.e0.S1(str)) {
                throw new IllegalArgumentException("encoder name couldn't be blank");
            }
            if (this.f6674a.containsKey(str)) {
                throw new IllegalArgumentException(n.a.a("Encoder ", str, " is already registered"));
            }
            Map<String, n> map = this.f6674a;
            n nVar = new n(str, mVar);
            lVar.invoke(nVar);
            map.put(str, nVar);
        }

        @os.l
        public final Map<String, n> g() {
            return this.f6674a;
        }
    }

    public static final class d implements dk.h<dk.c, c, l> {

        @xm.f(c = "io.ktor.features.Compression$Feature$install$1", f = "Compression.kt", i = {}, l = {193}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends xm.o implements jn.q<nl.f<Object, dk.b>, Object, um.d<? super l2>, Object> {
            final /* synthetic */ l $feature;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(l lVar, um.d<? super a> dVar) {
                super(3, dVar);
                this.$feature = lVar;
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i10 = this.label;
                if (i10 == 0) {
                    lm.d1.n(obj);
                    nl.f fVar = (nl.f) this.L$0;
                    l lVar = this.$feature;
                    this.label = 1;
                    if (lVar.d(fVar, this) == aVar) {
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
            public final Object invoke(@os.l nl.f<Object, dk.b> fVar, @os.l Object obj, @os.m um.d<? super l2> dVar) {
                a aVar = new a(this.$feature, dVar);
                aVar.L$0 = fVar;
                return aVar.invokeSuspend(l2.f10208a);
            }
        }

        public d() {
        }

        @os.l
        public final fl.b<Boolean> b() {
            return l.f6661d;
        }

        @Override // dk.h
        @os.l
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public l a(@os.l dk.c cVar, @os.l jn.l<? super c, l2> lVar) throws nl.c {
            kn.l0.p(cVar, "pipeline");
            kn.l0.p(lVar, "configure");
            c cVar2 = new c();
            lVar.invoke(cVar2);
            if (f1.F1(cVar2.f6674a)) {
                cVar2.d();
            }
            l lVar2 = new l(cVar2);
            vk.d dVar = cVar.f3713p;
            vk.d.f17581n.getClass();
            dVar.x(vk.d.f17585x, new a(lVar2, null));
            return lVar2;
        }

        @Override // dk.h
        @os.l
        public fl.b<l> getKey() {
            return l.f6662e;
        }

        public d(kn.w wVar) {
        }
    }

    public static final class e extends kn.n0 implements jn.l<lm.t0<? extends o, ? extends ik.x>, Comparable<?>> {
        public static final e INSTANCE = new e();

        public e() {
            super(1);
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ Comparable<?> invoke(lm.t0<? extends o, ? extends ik.x> t0Var) {
            return invoke2((lm.t0<o, ik.x>) t0Var);
        }

        @os.m
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Comparable<?> invoke2(@os.l lm.t0<o, ik.x> t0Var) {
            kn.l0.p(t0Var, "it");
            return Double.valueOf(t0Var.getSecond().f8202c);
        }
    }

    public static final class f extends kn.n0 implements jn.l<lm.t0<? extends o, ? extends ik.x>, Comparable<?>> {
        public static final f INSTANCE = new f();

        public f() {
            super(1);
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ Comparable<?> invoke(lm.t0<? extends o, ? extends ik.x> t0Var) {
            return invoke2((lm.t0<o, ik.x>) t0Var);
        }

        @os.m
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Comparable<?> invoke2(@os.l lm.t0<o, ik.x> t0Var) {
            kn.l0.p(t0Var, "it");
            return Double.valueOf(t0Var.getFirst().f6685d);
        }
    }

    public static final class g extends kn.n0 implements jn.a<pl.k> {
        final /* synthetic */ Object $message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(Object obj) {
            super(0);
            this.$message = obj;
        }

        @Override // jn.a
        @os.l
        public final pl.k invoke() {
            return ((nk.s.d) this.$message).j();
        }
    }

    public static final class h extends kn.n0 implements jn.a<pl.k> {
        final /* synthetic */ Object $message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(Object obj) {
            super(0);
            this.$message = obj;
        }

        @Override // jn.a
        @os.l
        public final pl.k invoke() {
            return pl.d.b(((nk.s.a) this.$message).j());
        }
    }

    public l(@os.l c cVar) {
        kn.l0.p(cVar, "compression");
        this.f6663a = cVar.c();
        this.f6664b = rm.g.h(e.INSTANCE, f.INSTANCE).reversed();
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:102:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:104:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:122:0x0198 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:124:? A[LOOP:4: B:62:0x015c->B:124:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:125:? A[LOOP:5: B:70:0x017f->B:125:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:57:0x013c  */
    /* JADX WARN: Code duplicated, block: B:61:0x0158  */
    /* JADX WARN: Code duplicated, block: B:64:0x0162  */
    /* JADX WARN: Code duplicated, block: B:66:0x0171  */
    /* JADX WARN: Code duplicated, block: B:69:0x017b  */
    /* JADX WARN: Code duplicated, block: B:72:0x0185  */
    /* JADX WARN: Code duplicated, block: B:78:0x019f  */
    /* JADX WARN: Code duplicated, block: B:79:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:81:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:82:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:87:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:89:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:91:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:93:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:95:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:97:0x01e5 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:98:0x01e6  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4, types: [nm.k0] */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v7, types: [java.util.ArrayList, java.util.Collection] */
    public final Object d(nl.f<Object, dk.b> fVar, um.d<? super l2> dVar) {
        Object objK;
        nk.s sVar;
        String str;
        o oVar;
        jn.a hVar;
        Object objV0;
        Object objV1;
        List<jn.p<dk.b, nk.s, Boolean>> list;
        Iterator it;
        ?? arrayList;
        dk.b context = fVar.getContext();
        Object objE = fVar.E();
        String strD = uk.e.d(context.d());
        if (strD == null || p.l(context)) {
            return l2.f10208a;
        }
        List<ik.x> listE = ik.i0.e(strD, false);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : listE) {
            ik.x xVar = (ik.x) obj;
            if (kn.l0.g(xVar.f8200a, "*") || this.f6663a.f6689a.containsKey(xVar.f8200a)) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it2 = arrayList2.iterator();
        while (true) {
            objK = null;
            if (!it2.hasNext()) {
                break;
            }
            ik.x xVar2 = (ik.x) it2.next();
            if (kn.l0.g(xVar2.f8200a, "*")) {
                Collection<o> collectionValues = this.f6663a.f6689a.values();
                arrayList = new ArrayList(nm.z.b0(collectionValues, 10));
                Iterator it3 = collectionValues.iterator();
                while (it3.hasNext()) {
                    arrayList.add(new lm.t0((o) it3.next(), xVar2));
                }
            } else {
                o oVar2 = this.f6663a.f6689a.get(xVar2.f8200a);
                objK = oVar2 != null ? nm.x.k(new lm.t0(oVar2, xVar2)) : null;
                arrayList = objK == null ? nm.k0.INSTANCE : objK;
            }
            nm.d0.r0(arrayList3, (Iterable) arrayList);
        }
        Comparator<lm.t0<o, ik.x>> comparator = this.f6664b;
        kn.l0.o(comparator, "comparator");
        List listU5 = nm.h0.u5(arrayList3, comparator);
        ArrayList arrayList4 = new ArrayList(nm.z.b0(listU5, 10));
        Iterator it4 = listU5.iterator();
        while (it4.hasNext()) {
            arrayList4.add((o) ((lm.t0) it4.next()).getFirst());
        }
        if (arrayList4.isEmpty()) {
            return l2.f10208a;
        }
        if ((objE instanceof nk.s) && !(objE instanceof a)) {
            List<jn.p<dk.b, nk.s, Boolean>> list2 = this.f6663a.f6690b;
            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                Iterator it5 = list2.iterator();
                while (it5.hasNext()) {
                    if (!((Boolean) ((jn.p) it5.next()).invoke(context, objE)).booleanValue()) {
                    }
                }
                if (!p.l(context)) {
                    sVar = (nk.s) objE;
                    ik.b0 b0VarE = sVar.e();
                    ik.j0.f8048a.getClass();
                    str = b0VarE.get(ik.j0.f8076o);
                    if (str != null || !kn.l0.g(str, "identity")) {
                        loop4: for (Object obj2 : arrayList4) {
                            list = ((o) obj2).f6684c;
                            if ((list instanceof Collection) || !list.isEmpty()) {
                                it = list.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        if (!((Boolean) ((jn.p) it.next()).invoke(context, objE)).booleanValue()) {
                                        }
                                    }
                                }
                            }
                            objK = obj2;
                        }
                        oVar = (o) objK;
                        if (sVar instanceof nk.s.d) {
                            hVar = new g(objE);
                        } else {
                            if (sVar instanceof nk.s.e) {
                                return (oVar == null && (objV0 = fVar.v0(new b((nk.s.e) objE, oVar.f6682a, oVar.f6683b), dVar)) == wm.a.COROUTINE_SUSPENDED) ? objV0 : l2.f10208a;
                            }
                            if (sVar instanceof nk.s.b) {
                                return l2.f10208a;
                            }
                            if (!(sVar instanceof nk.s.a)) {
                                if (sVar instanceof nk.s.c) {
                                    return l2.f10208a;
                                }
                                throw new lm.i0();
                            }
                            hVar = new h(objE);
                        }
                        if (oVar != null) {
                            objV1 = fVar.v0(new a(sVar, hVar, oVar.f6682a, oVar.f6683b), dVar);
                            if (objV1 == wm.a.COROUTINE_SUSPENDED) {
                                return objV1;
                            }
                            return l2.f10208a;
                        }
                    }
                }
            } else if (!p.l(context)) {
                sVar = (nk.s) objE;
                ik.b0 b0VarE2 = sVar.e();
                ik.j0.f8048a.getClass();
                str = b0VarE2.get(ik.j0.f8076o);
                if (str != null) {
                    loop4: while (r2.hasNext()) {
                        list = ((o) obj2).f6684c;
                        if (list instanceof Collection) {
                            it = list.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    if (!((Boolean) ((jn.p) it.next()).invoke(context, objE)).booleanValue()) {
                                    }
                                }
                            }
                        } else {
                            it = list.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    if (!((Boolean) ((jn.p) it.next()).invoke(context, objE)).booleanValue()) {
                                    }
                                }
                            }
                        }
                        objK = obj2;
                    }
                    oVar = (o) objK;
                    if (sVar instanceof nk.s.d) {
                        hVar = new g(objE);
                    } else {
                        if (sVar instanceof nk.s.e) {
                            if (oVar == null) {
                            }
                        }
                        if (sVar instanceof nk.s.b) {
                            return l2.f10208a;
                        }
                        if (!(sVar instanceof nk.s.a)) {
                            if (sVar instanceof nk.s.c) {
                                return l2.f10208a;
                            }
                            throw new lm.i0();
                        }
                        hVar = new h(objE);
                    }
                    if (oVar != null) {
                        objV1 = fVar.v0(new a(sVar, hVar, oVar.f6682a, oVar.f6683b), dVar);
                        if (objV1 == wm.a.COROUTINE_SUSPENDED) {
                            return objV1;
                        }
                        return l2.f10208a;
                    }
                } else {
                    loop4: while (r2.hasNext()) {
                        list = ((o) obj2).f6684c;
                        if (list instanceof Collection) {
                            it = list.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    if (!((Boolean) ((jn.p) it.next()).invoke(context, objE)).booleanValue()) {
                                    }
                                }
                            }
                        } else {
                            it = list.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    if (!((Boolean) ((jn.p) it.next()).invoke(context, objE)).booleanValue()) {
                                    }
                                }
                            }
                        }
                        objK = obj2;
                    }
                    oVar = (o) objK;
                    if (sVar instanceof nk.s.d) {
                        hVar = new g(objE);
                    } else {
                        if (sVar instanceof nk.s.e) {
                            if (oVar == null) {
                            }
                        }
                        if (sVar instanceof nk.s.b) {
                            return l2.f10208a;
                        }
                        if (!(sVar instanceof nk.s.a)) {
                            if (sVar instanceof nk.s.c) {
                                return l2.f10208a;
                            }
                            throw new lm.i0();
                        }
                        hVar = new h(objE);
                    }
                    if (oVar != null) {
                        objV1 = fVar.v0(new a(sVar, hVar, oVar.f6682a, oVar.f6683b), dVar);
                        if (objV1 == wm.a.COROUTINE_SUSPENDED) {
                            return objV1;
                        }
                        return l2.f10208a;
                    }
                }
            }
        }
        return l2.f10208a;
    }
}
