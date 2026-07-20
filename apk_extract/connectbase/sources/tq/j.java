package tq;

import kn.k1;
import kn.r1;
import lm.d1;
import lm.l2;
import nq.s0;
import nq.t0;
import nq.u0;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nMerge.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Merge.kt\nkotlinx/coroutines/flow/internal/ChannelFlowTransformLatest\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,100:1\n1#2:101\n*E\n"})
public final class j<T, R> extends h<T, R> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final jn.q<sq.j<? super R>, T, um.d<? super l2>, Object> f16039e;

    @xm.f(c = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3", f = "Merge.kt", i = {}, l = {27}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends xm.o implements jn.p<s0, um.d<? super l2>, Object> {
        final /* synthetic */ sq.j<R> $collector;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ j<T, R> this$0;

        /* JADX INFO: renamed from: tq.j$a$a, reason: collision with other inner class name */
        public static final class C0418a<T> implements sq.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ k1.h<nq.l2> f16040a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ s0 f16041b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ j<T, R> f16042c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ sq.j<R> f16043d;

            /* JADX INFO: renamed from: tq.j$a$a$a, reason: collision with other inner class name */
            @xm.f(c = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$2", f = "Merge.kt", i = {}, l = {34}, m = "invokeSuspend", n = {}, s = {})
            public static final class C0419a extends xm.o implements jn.p<s0, um.d<? super l2>, Object> {
                final /* synthetic */ sq.j<R> $collector;
                final /* synthetic */ T $value;
                int label;
                final /* synthetic */ j<T, R> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public C0419a(j<T, R> jVar, sq.j<? super R> jVar2, T t10, um.d<? super C0419a> dVar) {
                    super(2, dVar);
                    this.this$0 = jVar;
                    this.$collector = jVar2;
                    this.$value = t10;
                }

                @Override // xm.a
                @os.l
                public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
                    return new C0419a(this.this$0, this.$collector, this.$value, dVar);
                }

                /* JADX WARN: Type inference incomplete: some casts might be missing */
                /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
                    jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to tq.j$a$a$a for r4v4 'this'  java.lang.Object
                    	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
                    	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
                    	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
                    	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
                    	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
                    */
                @Override // xm.a
                @os.m
                public final java.lang.Object invokeSuspend(@os.l java.lang.Object r5) {
                    /*
                        r4 = this;
                        wm.a r0 = wm.a.COROUTINE_SUSPENDED
                        int r1 = r4.label
                        r2 = 1
                        if (r1 == 0) goto L15
                        if (r1 != r2) goto Ld
                        lm.d1.n(r5)
                        goto L29
                    Ld:
                        java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                        java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                        r4.<init>(r5)
                        throw r4
                    L15:
                        lm.d1.n(r5)
                        tq.j<T, R> r5 = r4.this$0
                        jn.q<sq.j<? super R>, T, um.d<? super lm.l2>, java.lang.Object> r5 = r5.f16039e
                        sq.j<R> r1 = r4.$collector
                        T r3 = r4.$value
                        r4.label = r2
                        java.lang.Object r4 = r5.invoke(r1, r3, r4)
                        if (r4 != r0) goto L29
                        return r0
                    L29:
                        lm.l2 r4 = lm.l2.f10208a
                        return r4
                    */
                    throw new UnsupportedOperationException("Method not decompiled: tq.j.a.C0418a.C0419a.invokeSuspend(java.lang.Object):java.lang.Object");
                }

                @Override // jn.p
                @os.m
                public final Object invoke(@os.l s0 s0Var, @os.m um.d<? super l2> dVar) {
                    return ((C0419a) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
                }
            }

            /* JADX INFO: renamed from: tq.j$a$a$b */
            @xm.f(c = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1", f = "Merge.kt", i = {0, 0}, l = {30}, m = "emit", n = {"this", "value"}, s = {"L$0", "L$1"})
            public static final class b extends xm.d {
                Object L$0;
                Object L$1;
                Object L$2;
                int label;
                /* synthetic */ Object result;
                final /* synthetic */ C0418a<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public b(C0418a<? super T> c0418a, um.d<? super b> dVar) {
                    super(dVar);
                    this.this$0 = c0418a;
                }

                @Override // xm.a
                @os.m
                public final Object invokeSuspend(@os.l Object obj) {
                    this.result = obj;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.emit(null, this);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            public C0418a(k1.h<nq.l2> hVar, s0 s0Var, j<T, R> jVar, sq.j<? super R> jVar2) {
                this.f16040a = hVar;
                this.f16041b = s0Var;
                this.f16042c = jVar;
                this.f16043d = jVar2;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            @Override // sq.j
            @os.m
            public final Object emit(T t10, @os.l um.d<? super l2> dVar) {
                b bVar;
                if (dVar instanceof b) {
                    bVar = (b) dVar;
                    int i10 = bVar.label;
                    if ((i10 & Integer.MIN_VALUE) != 0) {
                        bVar.label = i10 - Integer.MIN_VALUE;
                    } else {
                        bVar = new b(this, dVar);
                    }
                } else {
                    bVar = new b(this, dVar);
                }
                Object obj = bVar.result;
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i11 = bVar.label;
                if (i11 == 0) {
                    d1.n(obj);
                    nq.l2 l2Var = this.f16040a.element;
                    if (l2Var != null) {
                        l2Var.b(new l());
                        bVar.L$0 = this;
                        bVar.L$1 = t10;
                        bVar.L$2 = l2Var;
                        bVar.label = 1;
                        if (l2Var.t(bVar) == aVar) {
                            return aVar;
                        }
                    }
                } else {
                    if (i11 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    t10 = (T) bVar.L$1;
                    this = (C0418a) bVar.L$0;
                    d1.n(obj);
                }
                this.f16040a.element = (T) nq.k.f(this.f16041b, null, u0.UNDISPATCHED, new C0419a(this.f16042c, this.f16043d, t10, null), 1, null);
                return l2.f10208a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(j<T, R> jVar, sq.j<? super R> jVar2, um.d<? super a> dVar) {
            super(2, dVar);
            this.this$0 = jVar;
            this.$collector = jVar2;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            a aVar = new a(this.this$0, this.$collector, dVar);
            aVar.L$0 = obj;
            return aVar;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type um.d to tq.j$a for r7v4 'this'  um.d
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // xm.a
        @os.m
        public final java.lang.Object invokeSuspend(@os.l java.lang.Object r8) {
            /*
                r7 = this;
                wm.a r0 = wm.a.COROUTINE_SUSPENDED
                int r1 = r7.label
                r2 = 1
                if (r1 == 0) goto L15
                if (r1 != r2) goto Ld
                lm.d1.n(r8)
                goto L35
            Ld:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L15:
                lm.d1.n(r8)
                java.lang.Object r8 = r7.L$0
                nq.s0 r8 = (nq.s0) r8
                kn.k1$h r1 = new kn.k1$h
                r1.<init>()
                tq.j<T, R> r3 = r7.this$0
                sq.i<S> r4 = r3.f16038d
                tq.j$a$a r5 = new tq.j$a$a
                sq.j<R> r6 = r7.$collector
                r5.<init>(r1, r8, r3, r6)
                r7.label = r2
                java.lang.Object r7 = r4.a(r5, r7)
                if (r7 != r0) goto L35
                return r0
            L35:
                lm.l2 r7 = lm.l2.f10208a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: tq.j.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l s0 s0Var, @os.m um.d<? super l2> dVar) {
            return ((a) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    public /* synthetic */ j(jn.q qVar, sq.i iVar, um.g gVar, int i10, pq.i iVar2, int i11, kn.w wVar) {
        this(qVar, iVar, (i11 & 4) != 0 ? um.i.INSTANCE : gVar, (i11 & 8) != 0 ? -2 : i10, (i11 & 16) != 0 ? pq.i.SUSPEND : iVar2);
    }

    @Override // tq.e
    @os.l
    public e<R> j(@os.l um.g gVar, int i10, @os.l pq.i iVar) {
        return new j(this.f16039e, this.f16038d, gVar, i10, iVar);
    }

    @Override // tq.h
    @os.m
    public Object s(@os.l sq.j<? super R> jVar, @os.l um.d<? super l2> dVar) {
        Object objG = t0.g(new a(this, jVar, null), dVar);
        return objG == wm.a.COROUTINE_SUSPENDED ? objG : l2.f10208a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j(@os.l jn.q<? super sq.j<? super R>, ? super T, ? super um.d<? super l2>, ? extends Object> qVar, @os.l sq.i<? extends T> iVar, @os.l um.g gVar, int i10, @os.l pq.i iVar2) {
        super(iVar, gVar, i10, iVar2);
        this.f16039e = qVar;
    }
}
