package eo;

import op.h;

/* JADX INFO: loaded from: classes3.dex */
public final class x0<T extends op.h> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final e f4648a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final jn.l<wp.g, T> f4649b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final wp.g f4650c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final up.i f4651d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ un.o<Object>[] f4647f = {kn.l1.f9319a.n(new kn.g1(kn.l1.d(x0.class), "scopeForOwnerModule", "getScopeForOwnerModule()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;"))};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public static final a f4646e = new a();

    public static final class a {
        public a() {
        }

        @os.l
        public final <T extends op.h> x0<T> a(@os.l e eVar, @os.l up.n nVar, @os.l wp.g gVar, @os.l jn.l<? super wp.g, ? extends T> lVar) {
            kn.l0.p(eVar, "classDescriptor");
            kn.l0.p(nVar, "storageManager");
            kn.l0.p(gVar, "kotlinTypeRefinerForOwnerModule");
            kn.l0.p(lVar, "scopeFactory");
            return new x0<>(eVar, nVar, lVar, gVar);
        }

        public a(kn.w wVar) {
        }
    }

    public static final class b extends kn.n0 implements jn.a<T> {
        final /* synthetic */ wp.g $kotlinTypeRefiner;
        final /* synthetic */ x0<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(x0<T> x0Var, wp.g gVar) {
            super(0);
            this.this$0 = x0Var;
            this.$kotlinTypeRefiner = gVar;
        }

        @Override // jn.a
        @os.l
        public final T invoke() {
            return (T) this.this$0.f4649b.invoke(this.$kotlinTypeRefiner);
        }
    }

    public static final class c extends kn.n0 implements jn.a<T> {
        final /* synthetic */ x0<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(x0<T> x0Var) {
            super(0);
            this.this$0 = x0Var;
        }

        @Override // jn.a
        @os.l
        public final T invoke() {
            return (T) this.this$0.f4649b.invoke(this.this$0.f4650c);
        }
    }

    public /* synthetic */ x0(e eVar, up.n nVar, jn.l lVar, wp.g gVar, kn.w wVar) {
        this(eVar, nVar, lVar, gVar);
    }

    @os.l
    public final T c(@os.l wp.g gVar) {
        kn.l0.p(gVar, "kotlinTypeRefiner");
        if (!gVar.d(lp.a.l(this.f4648a))) {
            return (T) d();
        }
        vp.a1 a1VarI = this.f4648a.i();
        kn.l0.o(a1VarI, "classDescriptor.typeConstructor");
        return !gVar.e(a1VarI) ? (T) d() : (T) gVar.c(this.f4648a, new b(this, gVar));
    }

    public final T d() {
        return (T) up.m.a(this.f4651d, this, f4647f[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public x0(e eVar, up.n nVar, jn.l<? super wp.g, ? extends T> lVar, wp.g gVar) {
        this.f4648a = eVar;
        this.f4649b = lVar;
        this.f4650c = gVar;
        this.f4651d = nVar.h(new c(this));
    }
}
