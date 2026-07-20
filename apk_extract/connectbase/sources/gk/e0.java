package gk;

import kn.l1;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class e0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final b f6589b = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final fl.b<e0> f6590c = new fl.b<>("DoubleReceive");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final a f6591a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f6592a;

        public final boolean a() {
            return this.f6592a;
        }

        public final void b(boolean z10) {
            this.f6592a = z10;
        }
    }

    public static final class b implements dk.h<dk.a, a, e0> {

        @xm.f(c = "io.ktor.features.DoubleReceive$Feature$install$1", f = "DoubleReceive.kt", i = {1, 1, 1, 1, 2, 2, 2}, l = {60, 74, 86}, m = "invokeSuspend", n = {"$this$intercept", "request", "cache", "shouldReceiveEntirely", "$this$intercept", "request", "cache"}, s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2"})
        public static final class a extends xm.o implements jn.q<nl.f<uk.c, dk.b>, uk.c, um.d<? super l2>, Object> {
            final /* synthetic */ e0 $feature;
            int I$0;
            private /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            Object L$2;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(e0 e0Var, um.d<? super a> dVar) {
                super(3, dVar);
                this.$feature = e0Var;
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) throws Throwable {
                nl.f fVar;
                uk.c cVar;
                e eVarL;
                int i10;
                byte[] bArr;
                Object objC;
                uk.c cVar2;
                int i11;
                nl.f fVar2;
                Object obj2;
                Object objV0;
                e eVar;
                uk.c cVar3;
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i12 = this.label;
                Object objB = null;
                if (i12 == 0) {
                    lm.d1.n(obj);
                    fVar = (nl.f) this.L$0;
                    cVar = (uk.c) this.L$1;
                    if (kn.l0.g(wn.d.b(cVar.f16294a), l1.d(e.class))) {
                        throw new IllegalArgumentException("CachedTransformationResult can't be received");
                    }
                    eVarL = f0.l(((dk.b) fVar.getContext()).c());
                    boolean z10 = eVarL instanceof e.b;
                    if (z10 && kn.l0.g(eVarL.f6586a, cVar.f16294a)) {
                        uk.c cVar4 = new uk.c(eVarL.f6586a, ((e.b) eVarL).f6588b, false, 4, null);
                        this.L$0 = null;
                        this.label = 1;
                        if (fVar.v0(cVar4, this) == aVar) {
                            return aVar;
                        }
                        return l2.f10208a;
                    }
                    if (eVarL == null) {
                        f0.p(((dk.b) fVar.getContext()).c(), f0.f6598b);
                    }
                    f0.j(eVarL);
                    i10 = (this.$feature.f6591a.f6592a && (cVar.f16295b instanceof pl.k) && !f0.n(eVarL)) ? 1 : 0;
                    if (i10 != 0) {
                        pl.k kVar = (pl.k) cVar.f16295b;
                        this.L$0 = fVar;
                        this.L$1 = cVar;
                        this.L$2 = eVarL;
                        this.I$0 = i10;
                        this.label = 2;
                        objC = fl.k.c(kVar, this);
                        if (objC == aVar) {
                            return aVar;
                        }
                        int i13 = i10;
                        cVar2 = cVar;
                        i11 = i13;
                        bArr = (byte[]) objC;
                        uk.c cVar5 = cVar2;
                        i10 = i11;
                        cVar = cVar5;
                    } else {
                        e.b bVar = z10 ? (e.b) eVarL : null;
                        Object obj3 = bVar == null ? null : bVar.f6588b;
                        bArr = obj3 instanceof byte[] ? (byte[]) obj3 : null;
                    }
                } else {
                    if (i12 == 1) {
                        lm.d1.n(obj);
                        return l2.f10208a;
                    }
                    if (i12 != 2) {
                        if (i12 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        eVar = (e) this.L$2;
                        cVar = (uk.c) this.L$1;
                        fVar2 = (nl.f) this.L$0;
                        try {
                            lm.d1.n(obj);
                            objV0 = obj;
                            cVar3 = (uk.c) objV0;
                            f0.k(cVar3, cVar.f16294a);
                            if (cVar3.f16296c && f0.o(eVar)) {
                                f0.r(((dk.b) fVar2.getContext()).c(), cVar.f16294a, cVar3.f16295b);
                            }
                            return l2.f10208a;
                        } catch (Throwable th2) {
                            th = th2;
                            f0.q(((dk.b) fVar2.getContext()).c(), cVar.f16294a, th);
                            throw th;
                        }
                    }
                    i11 = this.I$0;
                    e eVar2 = (e) this.L$2;
                    cVar2 = (uk.c) this.L$1;
                    fVar = (nl.f) this.L$0;
                    lm.d1.n(obj);
                    eVarL = eVar2;
                    objC = obj;
                    bArr = (byte[]) objC;
                    uk.c cVar6 = cVar2;
                    i10 = i11;
                    cVar = cVar6;
                }
                if (i10 != 0) {
                    fl.c cVarC = ((dk.b) fVar.getContext()).c();
                    un.s sVarA = l1.A(byte[].class);
                    if (bArr == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.ByteArray");
                    }
                    f0.r(cVarC, sVarA, bArr);
                }
                if (bArr != null) {
                    try {
                        objB = pl.d.b(bArr);
                    } catch (Throwable th3) {
                        th = th3;
                        fVar2 = fVar;
                        f0.q(((dk.b) fVar2.getContext()).c(), cVar.f16294a, th);
                        throw th;
                    }
                }
                if (objB != null) {
                    obj2 = objB;
                } else if (eVarL == null) {
                    objB = cVar.f16295b;
                    obj2 = objB;
                } else {
                    obj2 = eVarL;
                }
                uk.c cVar7 = new uk.c(cVar.f16294a, obj2, false, 4, null);
                this.L$0 = fVar;
                this.L$1 = cVar;
                this.L$2 = eVarL;
                this.label = 3;
                objV0 = fVar.v0(cVar7, this);
                if (objV0 == aVar) {
                    return aVar;
                }
                fVar2 = fVar;
                eVar = eVarL;
                cVar3 = (uk.c) objV0;
                f0.k(cVar3, cVar.f16294a);
                if (cVar3.f16296c) {
                    f0.r(((dk.b) fVar2.getContext()).c(), cVar.f16294a, cVar3.f16295b);
                }
                return l2.f10208a;
            }

            @Override // jn.q
            @os.m
            public final Object invoke(@os.l nl.f<uk.c, dk.b> fVar, @os.l uk.c cVar, @os.m um.d<? super l2> dVar) {
                a aVar = new a(this.$feature, dVar);
                aVar.L$0 = fVar;
                aVar.L$1 = cVar;
                return aVar.invokeSuspend(l2.f10208a);
            }
        }

        public b() {
        }

        @Override // dk.h
        @os.l
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public e0 a(@os.l dk.a aVar, @os.l jn.l<? super a, l2> lVar) throws nl.c {
            kn.l0.p(aVar, "pipeline");
            kn.l0.p(lVar, "configure");
            a aVar2 = new a();
            lVar.invoke(aVar2);
            e0 e0Var = new e0(aVar2);
            uk.b bVar = aVar.f3712n;
            uk.b.f16289n.getClass();
            bVar.x(uk.b.f16290p, new a(e0Var, null));
            return e0Var;
        }

        @Override // dk.h
        @os.l
        public fl.b<e0> getKey() {
            return e0.f6590c;
        }

        public b(kn.w wVar) {
        }
    }

    public e0(@os.l a aVar) {
        kn.l0.p(aVar, "config");
        this.f6591a = aVar;
    }
}
