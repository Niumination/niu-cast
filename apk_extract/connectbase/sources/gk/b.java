package gk;

import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements dk.h<dk.c, l2, l2> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final b f6526a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final nl.j f6527b = new nl.j("HEAD");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final fl.b<l2> f6528c = new fl.b<>("Automatic Head Response");

    public static final class a extends nk.s.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public final nk.s f6529b;

        public a(@os.l nk.s sVar) {
            kn.l0.p(sVar, "original");
            this.f6529b = sVar;
        }

        @Override // nk.s
        @os.m
        public Long b() {
            return this.f6529b.b();
        }

        @Override // nk.s
        @os.m
        public ik.i c() {
            return this.f6529b.c();
        }

        @Override // nk.s
        @os.l
        public ik.b0 e() {
            return this.f6529b.e();
        }

        @Override // nk.s
        @os.m
        public <T> T f(@os.l fl.b<T> bVar) {
            kn.l0.p(bVar, cb.b.c.f1408o);
            return (T) this.f6529b.f(bVar);
        }

        @Override // nk.s
        @os.m
        public ik.r0 g() {
            return this.f6529b.g();
        }

        @Override // nk.s
        public <T> void i(@os.l fl.b<T> bVar, @os.m T t10) {
            kn.l0.p(bVar, cb.b.c.f1408o);
            this.f6529b.i(bVar, t10);
        }

        @os.l
        public final nk.s j() {
            return this.f6529b;
        }
    }

    /* JADX INFO: renamed from: gk.b$b, reason: collision with other inner class name */
    @xm.f(c = "io.ktor.features.AutoHeadResponse$install$1", f = "AutoHeadResponse.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C0159b extends xm.o implements jn.q<nl.f<l2, dk.b>, l2, um.d<? super l2>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: gk.b$b$a */
        @xm.f(c = "io.ktor.features.AutoHeadResponse$install$1$1", f = "AutoHeadResponse.kt", i = {}, l = {30}, m = "invokeSuspend", n = {}, s = {})
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
                    lm.d1.n(obj);
                    nl.f fVar = (nl.f) this.L$0;
                    Object obj2 = this.L$1;
                    if ((obj2 instanceof nk.s) && !(obj2 instanceof nk.s.b)) {
                        a aVar2 = new a((nk.s) obj2);
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
                a aVar = new a(dVar);
                aVar.L$0 = fVar;
                aVar.L$1 = obj;
                return aVar.invokeSuspend(l2.f10208a);
            }
        }

        public C0159b(um.d<? super C0159b> dVar) {
            super(3, dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) throws nl.c {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            lm.d1.n(obj);
            nl.f fVar = (nl.f) this.L$0;
            ik.p0 method = ((dk.b) fVar.getContext()).d().g().getMethod();
            ik.p0.a aVar2 = ik.p0.f8135b;
            aVar2.getClass();
            if (kn.l0.g(method, ik.p0.f8141h)) {
                vk.d dVarC = ((dk.b) fVar.getContext()).e().c();
                vk.d.f17581n.getClass();
                dVarC.v(vk.d.f17586y, b.f6527b);
                ((dk.b) fVar.getContext()).e().c().x(b.f6527b, new a(null));
                q0 q0VarB = u0.b((dk.b) fVar.getContext());
                aVar2.getClass();
                q0VarB.f(ik.p0.f8136c);
            }
            return l2.f10208a;
        }

        @Override // jn.q
        @os.m
        public final Object invoke(@os.l nl.f<l2, dk.b> fVar, @os.l l2 l2Var, @os.m um.d<? super l2> dVar) {
            C0159b c0159b = new C0159b(dVar);
            c0159b.L$0 = fVar;
            return c0159b.invokeSuspend(l2.f10208a);
        }
    }

    @Override // dk.h
    public /* bridge */ /* synthetic */ l2 a(nl.e eVar, jn.l<? super l2, l2> lVar) throws nl.c {
        c((dk.c) eVar, lVar);
        return l2.f10208a;
    }

    public void c(@os.l dk.c cVar, @os.l jn.l<? super l2, l2> lVar) throws nl.c {
        kn.l0.p(cVar, "pipeline");
        kn.l0.p(lVar, "configure");
        lVar.invoke(l2.f10208a);
        dk.c.f3706v.getClass();
        cVar.x(dk.c.f3709y, new C0159b(null));
    }

    @Override // dk.h
    @os.l
    public fl.b<l2> getKey() {
        return f6528c;
    }
}
