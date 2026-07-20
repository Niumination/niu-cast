package gk;

import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @os.l
    public static final c f6621k = new c();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @os.l
    public static final fl.b<i> f6622l = new fl.b<>("Call Logging");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final ps.a f6623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final dk.f f6624b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final qs.c f6625c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final List<jn.l<dk.b, Boolean>> f6626d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final List<e> f6627e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public final jn.l<dk.b, String> f6628f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public final jn.l<dk.a, l2> f6629g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @os.l
    public final jn.l<dk.a, l2> f6630h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @os.l
    public final jn.l<dk.a, l2> f6631i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @os.l
    public jn.l<? super dk.a, l2> f6632j;

    public static final class a extends kn.n0 implements jn.l<dk.a, l2> {
        public a() {
            super(1);
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(dk.a aVar) {
            invoke2(aVar);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l dk.a aVar) {
            kn.l0.p(aVar, "it");
            i.this.k(kn.l0.C("Application stopped: ", aVar));
            i.this.f6624b.c(dk.k.b(), i.this.f6629g);
            i iVar = i.this;
            iVar.f6624b.c(dk.k.f3718b, iVar.f6630h);
            i iVar2 = i.this;
            iVar2.f6624b.c(dk.k.f3720d, iVar2.f6631i);
            i iVar3 = i.this;
            iVar3.f6624b.c(dk.k.f3721e, iVar3.f6632j);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final List<jn.l<dk.b, Boolean>> f6633a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public final List<e> f6634b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @os.l
        public jn.l<? super dk.b, String> f6635c = new a(this);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f6636d = true;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @os.l
        public qs.c f6637e = qs.c.INFO;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @os.m
        public ps.a f6638f;

        public /* synthetic */ class a extends kn.h0 implements jn.l<dk.b, String> {
            public a(Object obj) {
                super(1, obj, b.class, "defaultFormat", "defaultFormat(Lio/ktor/application/ApplicationCall;)Ljava/lang/String;", 0);
            }

            @Override // jn.l
            @os.l
            public final String invoke(@os.l dk.b bVar) {
                kn.l0.p(bVar, "p0");
                return ((b) this.receiver).d(bVar);
            }
        }

        public final String b(ik.r0 r0Var) {
            boolean zG;
            boolean zG2;
            boolean zG3;
            boolean zG4;
            boolean zG5;
            boolean zG6;
            boolean zG7;
            boolean zG8;
            try {
                if (!ks.c.h()) {
                    ks.c.m();
                }
            } catch (Throwable unused) {
                this.f6636d = false;
            }
            ik.r0.a aVar = ik.r0.f8158c;
            aVar.getClass();
            boolean zG9 = true;
            if (kn.l0.g(r0Var, ik.r0.f8175q)) {
                zG = true;
            } else {
                aVar.getClass();
                zG = kn.l0.g(r0Var, ik.r0.f8165g);
            }
            if (zG) {
                zG2 = true;
            } else {
                aVar.getClass();
                zG2 = kn.l0.g(r0Var, ik.r0.f8167i);
            }
            if (zG2) {
                zG3 = true;
            } else {
                aVar.getClass();
                zG3 = kn.l0.g(r0Var, ik.r0.f8166h);
            }
            if (zG3) {
                return c(r0Var, ks.a.d.GREEN);
            }
            aVar.getClass();
            if (kn.l0.g(r0Var, ik.r0.f8160d)) {
                zG4 = true;
            } else {
                aVar.getClass();
                zG4 = kn.l0.g(r0Var, ik.r0.f8164f);
            }
            if (zG4) {
                zG5 = true;
            } else {
                aVar.getClass();
                zG5 = kn.l0.g(r0Var, ik.r0.f8171m);
            }
            if (zG5) {
                zG6 = true;
            } else {
                aVar.getClass();
                zG6 = kn.l0.g(r0Var, ik.r0.f8177s);
            }
            if (zG6) {
                zG7 = true;
            } else {
                aVar.getClass();
                zG7 = kn.l0.g(r0Var, ik.r0.f8178t);
            }
            if (zG7) {
                zG8 = true;
            } else {
                aVar.getClass();
                zG8 = kn.l0.g(r0Var, ik.r0.S);
            }
            if (!zG8) {
                aVar.getClass();
                zG9 = kn.l0.g(r0Var, ik.r0.f8169k);
            }
            return zG9 ? c(r0Var, ks.a.d.YELLOW) : c(r0Var, ks.a.d.RED);
        }

        public final String c(Object obj, ks.a.d dVar) {
            if (!this.f6636d) {
                return obj.toString();
            }
            String string = ks.a.r().p0(dVar).k(obj).S0().toString();
            kn.l0.o(string, "ansi().fg(color).a(value).reset().toString()");
            return string;
        }

        public final String d(dk.b bVar) {
            ik.r0 r0VarStatus = bVar.e().status();
            if (r0VarStatus == null) {
                r0VarStatus = "Unhandled";
            }
            ik.r0.f8158c.getClass();
            if (kn.l0.g(r0VarStatus, ik.r0.f8175q)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(b(r0VarStatus));
                sb2.append(": ");
                sb2.append(s(bVar.d()));
                sb2.append(" -> ");
                vk.g gVarB = bVar.e().b();
                ik.j0.f8048a.getClass();
                sb2.append((Object) gVarB.f(ik.j0.P));
                return sb2.toString();
            }
            if (kn.l0.g(r0VarStatus, "Unhandled")) {
                return c(r0VarStatus, ks.a.d.RED) + ": " + s(bVar.d());
            }
            return b(r0VarStatus) + ": " + s(bVar.d());
        }

        public final void e() {
            this.f6636d = false;
        }

        public final void f(@os.l jn.l<? super dk.b, Boolean> lVar) {
            kn.l0.p(lVar, "predicate");
            this.f6633a.add(lVar);
        }

        public final void g(@os.l jn.l<? super dk.b, String> lVar) {
            kn.l0.p(lVar, "formatter");
            this.f6635c = lVar;
        }

        @os.l
        public final List<jn.l<dk.b, Boolean>> h() {
            return this.f6633a;
        }

        @os.l
        public final jn.l<dk.b, String> i() {
            return this.f6635c;
        }

        @os.l
        public final qs.c j() {
            return this.f6637e;
        }

        @os.m
        public final ps.a k() {
            return this.f6638f;
        }

        @os.l
        public final List<e> l() {
            return this.f6634b;
        }

        public final boolean m() {
            return this.f6636d;
        }

        public final void n(@os.l String str, @os.l jn.l<? super dk.b, String> lVar) {
            kn.l0.p(str, "name");
            kn.l0.p(lVar, "provider");
            this.f6634b.add(new e(str, lVar));
        }

        public final void o(boolean z10) {
            this.f6636d = z10;
        }

        public final void p(@os.l jn.l<? super dk.b, String> lVar) {
            kn.l0.p(lVar, "<set-?>");
            this.f6635c = lVar;
        }

        public final void q(@os.l qs.c cVar) {
            kn.l0.p(cVar, "<set-?>");
            this.f6637e = cVar;
        }

        public final void r(@os.m ps.a aVar) {
            this.f6638f = aVar;
        }

        @os.l
        public final String s(@os.l uk.d dVar) {
            kn.l0.p(dVar, "<this>");
            return c(uk.e.n(dVar).f8144a, ks.a.d.CYAN) + " - " + uk.e.v(dVar);
        }
    }

    public static final class c implements dk.h<dk.a, b, i> {

        @xm.f(c = "io.ktor.features.CallLogging$Feature$install$1", f = "CallLogging.kt", i = {0}, l = {182, 276}, m = "invokeSuspend", n = {"$this$intercept"}, s = {"L$0"})
        public static final class a extends xm.o implements jn.q<nl.f<l2, dk.b>, l2, um.d<? super l2>, Object> {
            final /* synthetic */ i $feature;
            private /* synthetic */ Object L$0;
            Object L$1;
            int label;

            /* JADX INFO: renamed from: gk.i$c$a$a, reason: collision with other inner class name */
            @xm.f(c = "io.ktor.features.CallLogging$Feature$install$1$invokeSuspend$$inlined$withMDC$1", f = "CallLogging.kt", i = {}, l = {273}, m = "invokeSuspend", n = {}, s = {})
            public static final class C0165a extends xm.o implements jn.p<nq.s0, um.d<? super l2>, Object> {
                final /* synthetic */ nl.f $$this$intercept$inlined;
                final /* synthetic */ i $feature;
                final /* synthetic */ i $feature$inlined;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0165a(i iVar, um.d dVar, nl.f fVar, i iVar2) {
                    super(2, dVar);
                    this.$feature = iVar;
                    this.$$this$intercept$inlined = fVar;
                    this.$feature$inlined = iVar2;
                }

                @Override // xm.a
                @os.l
                public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
                    return new C0165a(this.$feature, dVar, this.$$this$intercept$inlined, this.$feature$inlined);
                }

                @Override // xm.a
                @os.m
                public final Object invokeSuspend(@os.l Object obj) {
                    wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                    int i10 = this.label;
                    try {
                        if (i10 == 0) {
                            lm.d1.n(obj);
                            nl.f fVar = this.$$this$intercept$inlined;
                            this.label = 1;
                            if (fVar.J0(this) == aVar) {
                                return aVar;
                            }
                        } else {
                            if (i10 != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            lm.d1.n(obj);
                        }
                        this.$feature$inlined.l((dk.b) this.$$this$intercept$inlined.getContext());
                        this.$feature.j();
                        return l2.f10208a;
                    } catch (Throwable th2) {
                        this.$feature.j();
                        throw th2;
                    }
                }

                @Override // jn.p
                @os.m
                public final Object invoke(@os.l nq.s0 s0Var, @os.m um.d<? super l2> dVar) {
                    return ((C0165a) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(i iVar, um.d<? super a> dVar) {
                super(3, dVar);
                this.$feature = iVar;
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                nl.f fVar;
                i iVar;
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i10 = this.label;
                if (i10 == 0) {
                    lm.d1.n(obj);
                    nl.f fVar2 = (nl.f) this.L$0;
                    dk.b bVar = (dk.b) fVar2.getContext();
                    i iVar2 = this.$feature;
                    i iVar3 = (i) dk.i.b(bVar.a(), i.f6621k);
                    if (iVar3 == null) {
                        this.L$0 = fVar2;
                        this.L$1 = iVar2;
                        this.label = 1;
                        if (fVar2.J0(this) == aVar) {
                            return aVar;
                        }
                        fVar = fVar2;
                        iVar = iVar2;
                        iVar.l((dk.b) fVar.getContext());
                    } else {
                        n0 n0Var = new n0(iVar3.m(bVar));
                        C0165a c0165a = new C0165a(iVar3, null, fVar2, iVar2);
                        this.label = 2;
                        if (nq.k.g(n0Var, c0165a, this) == aVar) {
                            return aVar;
                        }
                    }
                } else if (i10 == 1) {
                    iVar = (i) this.L$1;
                    fVar = (nl.f) this.L$0;
                    lm.d1.n(obj);
                    iVar.l((dk.b) fVar.getContext());
                } else {
                    if (i10 != 2) {
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

        @xm.f(c = "io.ktor.features.CallLogging$Feature$install$2", f = "CallLogging.kt", i = {0}, l = {188}, m = "invokeSuspend", n = {"$this$intercept"}, s = {"L$0"})
        public static final class b extends xm.o implements jn.q<nl.f<l2, dk.b>, l2, um.d<? super l2>, Object> {
            final /* synthetic */ i $feature;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(i iVar, um.d<? super b> dVar) {
                super(3, dVar);
                this.$feature = iVar;
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                nl.f fVar;
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i10 = this.label;
                if (i10 == 0) {
                    lm.d1.n(obj);
                    nl.f fVar2 = (nl.f) this.L$0;
                    this.L$0 = fVar2;
                    this.label = 1;
                    if (fVar2.J0(this) == aVar) {
                        return aVar;
                    }
                    fVar = fVar2;
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    fVar = (nl.f) this.L$0;
                    lm.d1.n(obj);
                }
                this.$feature.l((dk.b) fVar.getContext());
                return l2.f10208a;
            }

            @Override // jn.q
            @os.m
            public final Object invoke(@os.l nl.f<l2, dk.b> fVar, @os.l l2 l2Var, @os.m um.d<? super l2> dVar) {
                b bVar = new b(this.$feature, dVar);
                bVar.L$0 = fVar;
                return bVar.invokeSuspend(l2.f10208a);
            }
        }

        public c() {
        }

        @Override // dk.h
        @os.l
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public i a(@os.l dk.a aVar, @os.l jn.l<? super b, l2> lVar) throws nl.c {
            kn.l0.p(aVar, "pipeline");
            kn.l0.p(lVar, "configure");
            nl.j jVar = new nl.j("Logging");
            b bVar = new b();
            lVar.invoke(bVar);
            ps.a aVarA = bVar.f6638f;
            if (aVarA == null) {
                aVarA = dk.j.a(aVar);
            }
            i iVar = new i(aVarA, aVar.I.c(), bVar.f6637e, nm.h0.V5(bVar.f6633a), nm.h0.V5(bVar.f6634b), bVar.f6635c);
            dk.c.f3706v.getClass();
            aVar.v(dk.c.f3708x, jVar);
            if (iVar.f6627e.isEmpty()) {
                aVar.x(jVar, new b(iVar, null));
            } else {
                aVar.x(jVar, new a(iVar, null));
            }
            return iVar;
        }

        @Override // dk.h
        @os.l
        public fl.b<i> getKey() {
            return i.f6622l;
        }

        public c(kn.w wVar) {
        }
    }

    @fl.t0
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public static final d f6639a = new d();

        @xm.f(c = "io.ktor.features.CallLogging$Internals$withMDCBlock$$inlined$withMDC$1", f = "CallLogging.kt", i = {}, l = {234}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends xm.o implements jn.p<nq.s0, um.d<? super l2>, Object> {
            final /* synthetic */ jn.l $block;
            final /* synthetic */ i $feature;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(jn.l lVar, i iVar, um.d dVar) {
                super(2, dVar);
                this.$block = lVar;
                this.$feature = iVar;
            }

            @Override // xm.a
            @os.l
            public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
                return new a(this.$block, this.$feature, dVar);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object, lm.l2] */
            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i10 = this.label;
                try {
                    if (i10 == 0) {
                        lm.d1.n(obj);
                        jn.l lVar = this.$block;
                        this.label = 1;
                        if (lVar.invoke(this) == aVar) {
                            return aVar;
                        }
                    } else {
                        if (i10 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        lm.d1.n(obj);
                    }
                    this.$feature.j();
                    this = l2.f10208a;
                    return this;
                } catch (Throwable th2) {
                    this.$feature.j();
                    throw th2;
                }
            }

            @Override // jn.p
            @os.m
            public final Object invoke(@os.l nq.s0 s0Var, @os.m um.d<? super l2> dVar) {
                return ((a) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
            }
        }

        @xm.f(c = "io.ktor.features.CallLogging$Internals$withMDCBlock$2", f = "CallLogging.kt", i = {}, l = {202}, m = "invokeSuspend", n = {}, s = {})
        public static final class b extends xm.o implements jn.l<um.d<? super l2>, Object> {
            final /* synthetic */ jn.p<C, um.d<? super l2>, Object> $block;

            /* JADX INFO: Incorrect field signature: TC; */
            final /* synthetic */ nl.f $this_withMDCBlock;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Incorrect types in method signature: (Ljn/p<-TC;-Lum/d<-Llm/l2;>;+Ljava/lang/Object;>;TC;Lum/d<-Lgk/i$d$b;>;)V */
            public b(jn.p pVar, nl.f fVar, um.d dVar) {
                super(1, dVar);
                this.$block = pVar;
                this.$this_withMDCBlock = fVar;
            }

            @Override // xm.a
            @os.l
            public final um.d<l2> create(@os.l um.d<?> dVar) {
                return new b(this.$block, this.$this_withMDCBlock, dVar);
            }

            /* JADX WARN: Type inference incomplete: some casts might be missing */
            /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
                jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to gk.i$d$b for r3v4 'this'  java.lang.Object
                	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
                	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
                	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
                	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
                	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
                */
            @Override // xm.a
            @os.m
            public final java.lang.Object invokeSuspend(@os.l java.lang.Object r4) {
                /*
                    r3 = this;
                    wm.a r0 = wm.a.COROUTINE_SUSPENDED
                    int r1 = r3.label
                    r2 = 1
                    if (r1 == 0) goto L15
                    if (r1 != r2) goto Ld
                    lm.d1.n(r4)
                    goto L25
                Ld:
                    java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
                    java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
                    r3.<init>(r4)
                    throw r3
                L15:
                    lm.d1.n(r4)
                    jn.p<C, um.d<? super lm.l2>, java.lang.Object> r4 = r3.$block
                    nl.f r1 = r3.$this_withMDCBlock
                    r3.label = r2
                    java.lang.Object r3 = r4.invoke(r1, r3)
                    if (r3 != r0) goto L25
                    return r0
                L25:
                    lm.l2 r3 = lm.l2.f10208a
                    return r3
                */
                throw new UnsupportedOperationException("Method not decompiled: gk.i.d.b.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // jn.l
            @os.m
            public final Object invoke(@os.m um.d<? super l2> dVar) {
                return ((b) create(dVar)).invokeSuspend(l2.f10208a);
            }
        }

        @os.m
        @fl.t0
        public final Object a(@os.l dk.b bVar, @os.l jn.l<? super um.d<? super l2>, ? extends Object> lVar, @os.l um.d<? super l2> dVar) throws Throwable {
            i iVar = (i) dk.i.b(bVar.a(), i.f6621k);
            if (iVar == null) {
                Object objInvoke = lVar.invoke(dVar);
                if (objInvoke == wm.a.COROUTINE_SUSPENDED) {
                    return objInvoke;
                }
            } else {
                Object objG = nq.k.g(new n0(iVar.m(bVar)), new a(lVar, iVar, null), dVar);
                if (objG == wm.a.COROUTINE_SUSPENDED) {
                    return objG;
                }
            }
            return l2.f10208a;
        }

        @os.m
        @fl.t0
        public final <C extends nl.f<?, dk.b>> Object b(@os.l C c10, @os.l jn.p<? super C, ? super um.d<? super l2>, ? extends Object> pVar, @os.l um.d<? super l2> dVar) throws Throwable {
            Object objA = a((dk.b) c10.getContext(), new b(pVar, c10, null), dVar);
            return objA == wm.a.COROUTINE_SUSPENDED ? objA : l2.f10208a;
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final String f6640a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public final jn.l<dk.b, String> f6641b;

        /* JADX WARN: Multi-variable type inference failed */
        public e(@os.l String str, @os.l jn.l<? super dk.b, String> lVar) {
            kn.l0.p(str, "name");
            kn.l0.p(lVar, "provider");
            this.f6640a = str;
            this.f6641b = lVar;
        }

        @os.l
        public final String a() {
            return this.f6640a;
        }

        @os.l
        public final jn.l<dk.b, String> b() {
            return this.f6641b;
        }
    }

    public /* synthetic */ class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6642a;

        static {
            int[] iArr = new int[qs.c.values().length];
            iArr[qs.c.ERROR.ordinal()] = 1;
            iArr[qs.c.WARN.ordinal()] = 2;
            iArr[qs.c.INFO.ordinal()] = 3;
            iArr[qs.c.DEBUG.ordinal()] = 4;
            iArr[qs.c.TRACE.ordinal()] = 5;
            f6642a = iArr;
        }
    }

    public static final class g extends kn.n0 implements jn.l<dk.a, l2> {
        public g() {
            super(1);
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(dk.a aVar) {
            invoke2(aVar);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l dk.a aVar) {
            kn.l0.p(aVar, "it");
            i.this.k(kn.l0.C("Application started: ", aVar));
        }
    }

    public static final class h extends kn.n0 implements jn.l<dk.a, l2> {
        public h() {
            super(1);
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(dk.a aVar) {
            invoke2(aVar);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l dk.a aVar) {
            kn.l0.p(aVar, "it");
            i.this.k(kn.l0.C("Application starting: ", aVar));
        }
    }

    /* JADX INFO: renamed from: gk.i$i, reason: collision with other inner class name */
    public static final class C0166i extends kn.n0 implements jn.l<dk.a, l2> {
        public static final C0166i INSTANCE = new C0166i();

        public C0166i() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l dk.a aVar) {
            kn.l0.p(aVar, "it");
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(dk.a aVar) {
            invoke2(aVar);
            return l2.f10208a;
        }
    }

    public static final class j extends kn.n0 implements jn.l<dk.a, l2> {
        public j() {
            super(1);
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(dk.a aVar) {
            invoke2(aVar);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l dk.a aVar) {
            kn.l0.p(aVar, "it");
            i.this.k(kn.l0.C("Application stopping: ", aVar));
        }
    }

    public /* synthetic */ i(ps.a aVar, dk.f fVar, qs.c cVar, List list, List list2, jn.l lVar, kn.w wVar) {
        this(aVar, fVar, cVar, list, list2, lVar);
    }

    public final void j() {
        Iterator<T> it = this.f6627e.iterator();
        while (it.hasNext()) {
            ps.c.h(((e) it.next()).f6640a);
        }
    }

    public final void k(String str) {
        int i10 = f.f6642a[this.f6625c.ordinal()];
        if (i10 == 1) {
            this.f6623a.error(str);
            return;
        }
        if (i10 == 2) {
            this.f6623a.warn(str);
            return;
        }
        if (i10 == 3) {
            this.f6623a.info(str);
        } else if (i10 == 4) {
            this.f6623a.debug(str);
        } else {
            if (i10 != 5) {
                throw new lm.i0();
            }
            this.f6623a.trace(str);
        }
    }

    public final void l(dk.b bVar) {
        if (!this.f6626d.isEmpty()) {
            List<jn.l<dk.b, Boolean>> list = this.f6626d;
            if ((list instanceof Collection) && list.isEmpty()) {
                return;
            }
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((Boolean) ((jn.l) it.next()).invoke(bVar)).booleanValue()) {
                }
            }
            return;
        }
        k(this.f6628f.invoke(bVar));
    }

    @os.l
    public final Map<String, String> m(@os.l dk.b bVar) {
        kn.l0.p(bVar, NotificationCompat.CATEGORY_CALL);
        HashMap map = new HashMap();
        for (e eVar : this.f6627e) {
            String strInvoke = eVar.f6641b.invoke(bVar);
            if (strInvoke != null) {
                map.put(eVar.f6640a, strInvoke);
            }
        }
        return map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i(ps.a aVar, dk.f fVar, qs.c cVar, List<? extends jn.l<? super dk.b, Boolean>> list, List<e> list2, jn.l<? super dk.b, String> lVar) {
        this.f6623a = aVar;
        this.f6624b = fVar;
        this.f6625c = cVar;
        this.f6626d = list;
        this.f6627e = list2;
        this.f6628f = lVar;
        h hVar = new h();
        this.f6629g = hVar;
        g gVar = new g();
        this.f6630h = gVar;
        j jVar = new j();
        this.f6631i = jVar;
        this.f6632j = C0166i.INSTANCE;
        this.f6632j = new a();
        fVar.b(dk.k.b(), hVar);
        fVar.b(dk.k.f3718b, gVar);
        fVar.b(dk.k.f3720d, jVar);
        fVar.b(dk.k.f3721e, this.f6632j);
    }
}
