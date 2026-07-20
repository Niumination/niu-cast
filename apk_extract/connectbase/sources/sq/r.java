package sq;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kn.k1;
import kn.r1;
import lm.l2;
import nq.b2;
import nq.d1;
import nq.v3;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,415:1\n1#2:416\n*E\n"})
public final /* synthetic */ class r {

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class a<T> extends kn.n0 implements jn.l<T, Long> {
        final /* synthetic */ long $timeoutMillis;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(long j10) {
            super(1);
            this.$timeoutMillis = j10;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.l
        @os.l
        public final Long invoke(T t10) {
            return Long.valueOf(this.$timeoutMillis);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class b<T> extends kn.n0 implements jn.l<T, Long> {
        final /* synthetic */ jn.l<T, lq.e> $timeout;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(jn.l<? super T, lq.e> lVar) {
            super(1);
            this.$timeout = lVar;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.l
        @os.l
        public final Long invoke(T t10) {
            return Long.valueOf(d1.e(this.$timeout.invoke(t10).f10251a));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @r1({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$debounceInternal$1\n+ 2 Symbol.kt\nkotlinx/coroutines/internal/Symbol\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Select.kt\nkotlinx/coroutines/selects/SelectKt\n*L\n1#1,415:1\n18#2:416\n18#2:418\n1#3:417\n55#4,8:419\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$debounceInternal$1\n*L\n218#1:416\n221#1:418\n228#1:419,8\n*E\n"})
    @xm.f(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1", f = "Delay.kt", i = {0, 0, 0, 0, 1, 1, 1}, l = {221, 426}, m = "invokeSuspend", n = {"downstream", "values", "lastValue", "timeoutMillis", "downstream", "values", "lastValue"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2"})
    public static final class c<T> extends xm.o implements jn.q<nq.s0, j<? super T>, um.d<? super l2>, Object> {
        final /* synthetic */ i<T> $this_debounceInternal;
        final /* synthetic */ jn.l<T, Long> $timeoutMillisSelector;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        Object L$2;
        Object L$3;
        int label;

        @r1({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$debounceInternal$1$3$1\n+ 2 Symbol.kt\nkotlinx/coroutines/internal/Symbol\n*L\n1#1,415:1\n18#2:416\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$debounceInternal$1$3$1\n*L\n232#1:416\n*E\n"})
        @xm.f(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$1", f = "Delay.kt", i = {}, l = {232}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends xm.o implements jn.l<um.d<? super l2>, Object> {
            final /* synthetic */ j<T> $downstream;
            final /* synthetic */ k1.h<Object> $lastValue;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public a(j<? super T> jVar, k1.h<Object> hVar, um.d<? super a> dVar) {
                super(1, dVar);
                this.$downstream = jVar;
                this.$lastValue = hVar;
            }

            @Override // xm.a
            @os.l
            public final um.d<l2> create(@os.l um.d<?> dVar) {
                return new a(this.$downstream, this.$lastValue, dVar);
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i10 = this.label;
                if (i10 == 0) {
                    lm.d1.n(obj);
                    j<T> jVar = this.$downstream;
                    vq.u0 u0Var = tq.u.f16062a;
                    T t10 = this.$lastValue.element;
                    if (t10 == u0Var) {
                        t10 = null;
                    }
                    this.label = 1;
                    if (jVar.emit(t10, this) == aVar) {
                        return aVar;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    lm.d1.n(obj);
                }
                this.$lastValue.element = null;
                return l2.f10208a;
            }

            @Override // jn.l
            @os.m
            public final Object invoke(@os.m um.d<? super l2> dVar) {
                return ((a) create(dVar)).invokeSuspend(l2.f10208a);
            }
        }

        @r1({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$debounceInternal$1$3$2\n+ 2 Channel.kt\nkotlinx/coroutines/channels/ChannelKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Symbol.kt\nkotlinx/coroutines/internal/Symbol\n*L\n1#1,415:1\n514#2,6:416\n530#2,4:422\n534#2:428\n1#3:426\n18#4:427\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$debounceInternal$1$3$2\n*L\n238#1:416,6\n239#1:422,4\n239#1:428\n242#1:427\n*E\n"})
        @xm.f(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$2", f = "Delay.kt", i = {0}, l = {242}, m = "invokeSuspend", n = {"$this$onFailure_u2dWpGqRn0$iv"}, s = {"L$0"})
        public static final class b extends xm.o implements jn.p<pq.p<? extends Object>, um.d<? super l2>, Object> {
            final /* synthetic */ j<T> $downstream;
            final /* synthetic */ k1.h<Object> $lastValue;
            /* synthetic */ Object L$0;
            Object L$1;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public b(k1.h<Object> hVar, j<? super T> jVar, um.d<? super b> dVar) {
                super(2, dVar);
                this.$lastValue = hVar;
                this.$downstream = jVar;
            }

            @Override // xm.a
            @os.l
            public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
                b bVar = new b(this.$lastValue, this.$downstream, dVar);
                bVar.L$0 = obj;
                return bVar;
            }

            @Override // jn.p
            public /* synthetic */ Object invoke(pq.p<? extends Object> pVar, um.d<? super l2> dVar) {
                return m72invokeWpGqRn0(pVar.f13310a, dVar);
            }

            @os.m
            /* JADX INFO: renamed from: invoke-WpGqRn0, reason: not valid java name */
            public final Object m72invokeWpGqRn0(@os.l Object obj, @os.m um.d<? super l2> dVar) {
                return ((b) create(pq.p.b(obj), dVar)).invokeSuspend(l2.f10208a);
            }

            /* JADX WARN: Type inference incomplete: some casts might be missing */
            /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
                jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type um.d to sq.r$c$b for r6v9 'this'  um.d
                	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
                	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
                	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
                	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
                	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
                */
            @Override // xm.a
            @os.m
            public final java.lang.Object invokeSuspend(@os.l java.lang.Object r7) {
                /*
                    r6 = this;
                    wm.a r0 = wm.a.COROUTINE_SUSPENDED
                    int r1 = r6.label
                    r2 = 1
                    if (r1 == 0) goto L19
                    if (r1 != r2) goto L11
                    java.lang.Object r6 = r6.L$1
                    kn.k1$h r6 = (kn.k1.h) r6
                    lm.d1.n(r7)
                    goto L4b
                L11:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r7)
                    throw r6
                L19:
                    lm.d1.n(r7)
                    java.lang.Object r7 = r6.L$0
                    pq.p r7 = (pq.p) r7
                    java.lang.Object r7 = r7.f13310a
                    kn.k1$h<java.lang.Object> r1 = r6.$lastValue
                    boolean r3 = r7 instanceof pq.p.c
                    if (r3 != 0) goto L2a
                    r1.element = r7
                L2a:
                    sq.j<T> r4 = r6.$downstream
                    if (r3 == 0) goto L52
                    java.lang.Throwable r3 = pq.p.f(r7)
                    if (r3 != 0) goto L51
                    T r3 = r1.element
                    if (r3 == 0) goto L4c
                    vq.u0 r5 = tq.u.f16062a
                    if (r3 != r5) goto L3d
                    r3 = 0
                L3d:
                    r6.L$0 = r7
                    r6.L$1 = r1
                    r6.label = r2
                    java.lang.Object r6 = r4.emit(r3, r6)
                    if (r6 != r0) goto L4a
                    return r0
                L4a:
                    r6 = r1
                L4b:
                    r1 = r6
                L4c:
                    vq.u0 r6 = tq.u.f16064c
                    r1.element = r6
                    goto L52
                L51:
                    throw r3
                L52:
                    lm.l2 r6 = lm.l2.f10208a
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: sq.r.c.b.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* JADX INFO: renamed from: sq.r$c$c, reason: collision with other inner class name */
        @xm.f(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1", f = "Delay.kt", i = {}, l = {210}, m = "invokeSuspend", n = {}, s = {})
        public static final class C0390c extends xm.o implements jn.p<pq.d0<? super Object>, um.d<? super l2>, Object> {
            final /* synthetic */ i<T> $this_debounceInternal;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX INFO: renamed from: sq.r$c$c$a */
            public static final class a<T> implements j {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ pq.d0<Object> f15328a;

                /* JADX INFO: renamed from: sq.r$c$c$a$a, reason: collision with other inner class name */
                @xm.f(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1$1", f = "Delay.kt", i = {}, l = {210}, m = "emit", n = {}, s = {})
                public static final class C0391a extends xm.d {
                    int label;
                    /* synthetic */ Object result;
                    final /* synthetic */ a<T> this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    public C0391a(a<? super T> aVar, um.d<? super C0391a> dVar) {
                        super(dVar);
                        this.this$0 = aVar;
                    }

                    @Override // xm.a
                    @os.m
                    public final Object invokeSuspend(@os.l Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return this.this$0.emit(null, this);
                    }
                }

                public a(pq.d0<Object> d0Var) {
                    this.f15328a = d0Var;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
                @Override // sq.j
                @os.m
                public final Object emit(T t10, @os.l um.d<? super l2> dVar) {
                    C0391a c0391a;
                    if (dVar instanceof C0391a) {
                        c0391a = (C0391a) dVar;
                        int i10 = c0391a.label;
                        if ((i10 & Integer.MIN_VALUE) != 0) {
                            c0391a.label = i10 - Integer.MIN_VALUE;
                        } else {
                            c0391a = new C0391a(this, dVar);
                        }
                    } else {
                        c0391a = new C0391a(this, dVar);
                    }
                    Object obj = c0391a.result;
                    wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                    int i11 = c0391a.label;
                    if (i11 == 0) {
                        lm.d1.n(obj);
                        pq.d0<Object> d0Var = this.f15328a;
                        if (t10 == null) {
                            t10 = (T) tq.u.f16062a;
                        }
                        c0391a.label = 1;
                        if (d0Var.L(t10, c0391a) == aVar) {
                            return aVar;
                        }
                    } else {
                        if (i11 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        lm.d1.n(obj);
                    }
                    return l2.f10208a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C0390c(i<? extends T> iVar, um.d<? super C0390c> dVar) {
                super(2, dVar);
                this.$this_debounceInternal = iVar;
            }

            @Override // xm.a
            @os.l
            public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
                C0390c c0390c = new C0390c(this.$this_debounceInternal, dVar);
                c0390c.L$0 = obj;
                return c0390c;
            }

            @Override // jn.p
            public /* bridge */ /* synthetic */ Object invoke(pq.d0<? super Object> d0Var, um.d<? super l2> dVar) {
                return invoke2((pq.d0<Object>) d0Var, dVar);
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i10 = this.label;
                if (i10 == 0) {
                    lm.d1.n(obj);
                    pq.d0 d0Var = (pq.d0) this.L$0;
                    i<T> iVar = this.$this_debounceInternal;
                    a aVar2 = new a(d0Var);
                    this.label = 1;
                    if (iVar.a(aVar2, this) == aVar) {
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

            @os.m
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(@os.l pq.d0<Object> d0Var, @os.m um.d<? super l2> dVar) {
                return ((C0390c) create(d0Var, dVar)).invokeSuspend(l2.f10208a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public c(jn.l<? super T, Long> lVar, i<? extends T> iVar, um.d<? super c> dVar) {
            super(3, dVar);
            this.$timeoutMillisSelector = lVar;
            this.$this_debounceInternal = iVar;
        }

        /* JADX WARN: Code duplicated, block: B:14:0x0064  */
        /* JADX WARN: Code duplicated, block: B:16:0x006d  */
        /* JADX WARN: Code duplicated, block: B:18:0x0073  */
        /* JADX WARN: Code duplicated, block: B:21:0x0086  */
        /* JADX WARN: Code duplicated, block: B:23:0x008a  */
        /* JADX WARN: Code duplicated, block: B:25:0x008e  */
        /* JADX WARN: Code duplicated, block: B:28:0x009f A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:31:0x00a7  */
        /* JADX WARN: Code duplicated, block: B:35:0x00bc  */
        /* JADX WARN: Code duplicated, block: B:38:0x00e2 A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00e0 -> B:7:0x001c). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:38:0x00e2
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // xm.a
        @os.m
        public final java.lang.Object invokeSuspend(@os.l java.lang.Object r15) {
            /*
                Method dump skipped, instruction units count: 230
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: sq.r.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // jn.q
        @os.m
        public final Object invoke(@os.l nq.s0 s0Var, @os.l j<? super T> jVar, @os.m um.d<? super l2> dVar) {
            c cVar = new c(this.$timeoutMillisSelector, this.$this_debounceInternal, dVar);
            cVar.L$0 = s0Var;
            cVar.L$1 = jVar;
            return cVar.invokeSuspend(l2.f10208a);
        }
    }

    @xm.f(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$fixedPeriodTicker$3", f = "Delay.kt", i = {0, 1, 2}, l = {TypedValues.AttributesType.TYPE_PATH_ROTATE, TypedValues.AttributesType.TYPE_PIVOT_TARGET, 319}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "$this$produce"}, s = {"L$0", "L$0", "L$0"})
    public static final class d extends xm.o implements jn.p<pq.d0<? super l2>, um.d<? super l2>, Object> {
        final /* synthetic */ long $delayMillis;
        final /* synthetic */ long $initialDelayMillis;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(long j10, long j11, um.d<? super d> dVar) {
            super(2, dVar);
            this.$initialDelayMillis = j10;
            this.$delayMillis = j11;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            d dVar2 = new d(this.$initialDelayMillis, this.$delayMillis, dVar);
            dVar2.L$0 = obj;
            return dVar2;
        }

        /* JADX WARN: Code duplicated, block: B:17:0x004d A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:20:0x005a A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0058 -> B:15:0x003d). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:20:0x005a
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // xm.a
        @os.m
        public final java.lang.Object invokeSuspend(@os.l java.lang.Object r8) {
            /*
                r7 = this;
                wm.a r0 = wm.a.COROUTINE_SUSPENDED
                int r1 = r7.label
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L28
                if (r1 == r4) goto L20
                if (r1 == r3) goto L18
                if (r1 != r2) goto L10
                goto L20
            L10:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L18:
                java.lang.Object r1 = r7.L$0
                pq.d0 r1 = (pq.d0) r1
                lm.d1.n(r8)
                goto L4e
            L20:
                java.lang.Object r1 = r7.L$0
                pq.d0 r1 = (pq.d0) r1
                lm.d1.n(r8)
                goto L3d
            L28:
                lm.d1.n(r8)
                java.lang.Object r8 = r7.L$0
                r1 = r8
                pq.d0 r1 = (pq.d0) r1
                long r5 = r7.$initialDelayMillis
                r7.L$0 = r1
                r7.label = r4
                java.lang.Object r8 = nq.d1.b(r5, r7)
                if (r8 != r0) goto L3d
                return r0
            L3d:
                pq.g0 r8 = r1.a()
                lm.l2 r4 = lm.l2.f10208a
                r7.L$0 = r1
                r7.label = r3
                java.lang.Object r8 = r8.L(r4, r7)
                if (r8 != r0) goto L4e
                return r0
            L4e:
                long r4 = r7.$delayMillis
                r7.L$0 = r1
                r7.label = r2
                java.lang.Object r8 = nq.d1.b(r4, r7)
                if (r8 != r0) goto L3d
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: sq.r.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l pq.d0<? super l2> d0Var, @os.m um.d<? super l2> dVar) {
            return ((d) create(d0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @r1({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$sample$2\n+ 2 Select.kt\nkotlinx/coroutines/selects/SelectKt\n*L\n1#1,415:1\n55#2,8:416\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$sample$2\n*L\n284#1:416,8\n*E\n"})
    @xm.f(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2", f = "Delay.kt", i = {0, 0, 0, 0}, l = {TypedValues.CycleType.TYPE_WAVE_PERIOD}, m = "invokeSuspend", n = {"downstream", "values", "lastValue", "ticker"}, s = {"L$0", "L$1", "L$2", "L$3"})
    public static final class e<T> extends xm.o implements jn.q<nq.s0, j<? super T>, um.d<? super l2>, Object> {
        final /* synthetic */ long $periodMillis;
        final /* synthetic */ i<T> $this_sample;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        Object L$2;
        Object L$3;
        int label;

        @r1({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$sample$2$1$1\n+ 2 Channel.kt\nkotlinx/coroutines/channels/ChannelKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,415:1\n514#2,6:416\n530#2,4:422\n534#2:427\n1#3:426\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$sample$2$1$1\n*L\n287#1:416,6\n288#1:422,4\n288#1:427\n*E\n"})
        @xm.f(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$1$1", f = "Delay.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends xm.o implements jn.p<pq.p<? extends Object>, um.d<? super l2>, Object> {
            final /* synthetic */ k1.h<Object> $lastValue;
            final /* synthetic */ pq.f0<l2> $ticker;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(k1.h<Object> hVar, pq.f0<l2> f0Var, um.d<? super a> dVar) {
                super(2, dVar);
                this.$lastValue = hVar;
                this.$ticker = f0Var;
            }

            @Override // xm.a
            @os.l
            public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
                a aVar = new a(this.$lastValue, this.$ticker, dVar);
                aVar.L$0 = obj;
                return aVar;
            }

            @Override // jn.p
            public /* synthetic */ Object invoke(pq.p<? extends Object> pVar, um.d<? super l2> dVar) {
                return m73invokeWpGqRn0(pVar.f13310a, dVar);
            }

            @os.m
            /* JADX INFO: renamed from: invoke-WpGqRn0, reason: not valid java name */
            public final Object m73invokeWpGqRn0(@os.l Object obj, @os.m um.d<? super l2> dVar) {
                return ((a) create(pq.p.b(obj), dVar)).invokeSuspend(l2.f10208a);
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) throws Throwable {
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                lm.d1.n(obj);
                T t10 = (T) ((pq.p) this.L$0).f13310a;
                k1.h<Object> hVar = this.$lastValue;
                boolean z10 = t10 instanceof pq.p.c;
                if (!z10) {
                    hVar.element = t10;
                }
                pq.f0<l2> f0Var = this.$ticker;
                if (z10) {
                    Throwable thF = pq.p.f(t10);
                    if (thF != null) {
                        throw thF;
                    }
                    f0Var.b(new tq.l());
                    hVar.element = (T) tq.u.f16064c;
                }
                return l2.f10208a;
            }
        }

        @r1({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$sample$2$1$2\n+ 2 Symbol.kt\nkotlinx/coroutines/internal/Symbol\n*L\n1#1,415:1\n18#2:416\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$sample$2$1$2\n*L\n299#1:416\n*E\n"})
        @xm.f(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$1$2", f = "Delay.kt", i = {}, l = {299}, m = "invokeSuspend", n = {}, s = {})
        public static final class b extends xm.o implements jn.p<l2, um.d<? super l2>, Object> {
            final /* synthetic */ j<T> $downstream;
            final /* synthetic */ k1.h<Object> $lastValue;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public b(k1.h<Object> hVar, j<? super T> jVar, um.d<? super b> dVar) {
                super(2, dVar);
                this.$lastValue = hVar;
                this.$downstream = jVar;
            }

            @Override // xm.a
            @os.l
            public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
                return new b(this.$lastValue, this.$downstream, dVar);
            }

            /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
                jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type um.d to sq.r$e$b for r5v5 'this'  um.d
                	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
                	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
                	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
                	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
                	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
                */
            @Override // xm.a
            @os.m
            public final java.lang.Object invokeSuspend(@os.l java.lang.Object r6) {
                /*
                    r5 = this;
                    wm.a r0 = wm.a.COROUTINE_SUSPENDED
                    int r1 = r5.label
                    r2 = 1
                    if (r1 == 0) goto L15
                    if (r1 != r2) goto Ld
                    lm.d1.n(r6)
                    goto L34
                Ld:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L15:
                    lm.d1.n(r6)
                    kn.k1$h<java.lang.Object> r6 = r5.$lastValue
                    T r1 = r6.element
                    if (r1 != 0) goto L21
                    lm.l2 r5 = lm.l2.f10208a
                    return r5
                L21:
                    r3 = 0
                    r6.element = r3
                    sq.j<T> r6 = r5.$downstream
                    vq.u0 r4 = tq.u.f16062a
                    if (r1 != r4) goto L2b
                    r1 = r3
                L2b:
                    r5.label = r2
                    java.lang.Object r5 = r6.emit(r1, r5)
                    if (r5 != r0) goto L34
                    return r0
                L34:
                    lm.l2 r5 = lm.l2.f10208a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: sq.r.e.b.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // jn.p
            @os.m
            public final Object invoke(@os.l l2 l2Var, @os.m um.d<? super l2> dVar) {
                return ((b) create(l2Var, dVar)).invokeSuspend(l2.f10208a);
            }
        }

        @xm.f(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$values$1", f = "Delay.kt", i = {}, l = {279}, m = "invokeSuspend", n = {}, s = {})
        public static final class c extends xm.o implements jn.p<pq.d0<? super Object>, um.d<? super l2>, Object> {
            final /* synthetic */ i<T> $this_sample;
            private /* synthetic */ Object L$0;
            int label;

            public static final class a<T> implements j {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ pq.d0<Object> f15329a;

                /* JADX INFO: renamed from: sq.r$e$c$a$a, reason: collision with other inner class name */
                @xm.f(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$values$1$1", f = "Delay.kt", i = {}, l = {279}, m = "emit", n = {}, s = {})
                public static final class C0392a extends xm.d {
                    int label;
                    /* synthetic */ Object result;
                    final /* synthetic */ a<T> this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    public C0392a(a<? super T> aVar, um.d<? super C0392a> dVar) {
                        super(dVar);
                        this.this$0 = aVar;
                    }

                    @Override // xm.a
                    @os.m
                    public final Object invokeSuspend(@os.l Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return this.this$0.emit(null, this);
                    }
                }

                public a(pq.d0<Object> d0Var) {
                    this.f15329a = d0Var;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
                @Override // sq.j
                @os.m
                public final Object emit(T t10, @os.l um.d<? super l2> dVar) {
                    C0392a c0392a;
                    if (dVar instanceof C0392a) {
                        c0392a = (C0392a) dVar;
                        int i10 = c0392a.label;
                        if ((i10 & Integer.MIN_VALUE) != 0) {
                            c0392a.label = i10 - Integer.MIN_VALUE;
                        } else {
                            c0392a = new C0392a(this, dVar);
                        }
                    } else {
                        c0392a = new C0392a(this, dVar);
                    }
                    Object obj = c0392a.result;
                    wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                    int i11 = c0392a.label;
                    if (i11 == 0) {
                        lm.d1.n(obj);
                        pq.d0<Object> d0Var = this.f15329a;
                        if (t10 == null) {
                            t10 = (T) tq.u.f16062a;
                        }
                        c0392a.label = 1;
                        if (d0Var.L(t10, c0392a) == aVar) {
                            return aVar;
                        }
                    } else {
                        if (i11 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        lm.d1.n(obj);
                    }
                    return l2.f10208a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public c(i<? extends T> iVar, um.d<? super c> dVar) {
                super(2, dVar);
                this.$this_sample = iVar;
            }

            @Override // xm.a
            @os.l
            public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
                c cVar = new c(this.$this_sample, dVar);
                cVar.L$0 = obj;
                return cVar;
            }

            @Override // jn.p
            public /* bridge */ /* synthetic */ Object invoke(pq.d0<? super Object> d0Var, um.d<? super l2> dVar) {
                return invoke2((pq.d0<Object>) d0Var, dVar);
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i10 = this.label;
                if (i10 == 0) {
                    lm.d1.n(obj);
                    pq.d0 d0Var = (pq.d0) this.L$0;
                    i<T> iVar = this.$this_sample;
                    a aVar2 = new a(d0Var);
                    this.label = 1;
                    if (iVar.a(aVar2, this) == aVar) {
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

            @os.m
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(@os.l pq.d0<Object> d0Var, @os.m um.d<? super l2> dVar) {
                return ((c) create(d0Var, dVar)).invokeSuspend(l2.f10208a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public e(long j10, i<? extends T> iVar, um.d<? super e> dVar) {
            super(3, dVar);
            this.$periodMillis = j10;
            this.$this_sample = iVar;
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            j jVar;
            pq.f0 f0Var;
            k1.h hVar;
            pq.f0 f0VarG;
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                lm.d1.n(obj);
                nq.s0 s0Var = (nq.s0) this.L$0;
                j jVar2 = (j) this.L$1;
                pq.f0 f0VarF = pq.b0.f(s0Var, null, -1, new c(this.$this_sample, null), 1, null);
                k1.h hVar2 = new k1.h();
                jVar = jVar2;
                f0Var = f0VarF;
                hVar = hVar2;
                f0VarG = r.g(s0Var, this.$periodMillis, 0L, 2, null);
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                f0VarG = (pq.f0) this.L$3;
                hVar = (k1.h) this.L$2;
                f0Var = (pq.f0) this.L$1;
                jVar = (j) this.L$0;
                lm.d1.n(obj);
            }
            while (hVar.element != tq.u.f16064c) {
                yq.l lVar = new yq.l(getContext());
                lVar.e(f0Var.B(), new a(hVar, f0VarG, null));
                lVar.e(f0VarG.x(), new b(hVar, jVar, null));
                this.L$0 = jVar;
                this.L$1 = f0Var;
                this.L$2 = hVar;
                this.L$3 = f0VarG;
                this.label = 1;
                if (yq.l.z(lVar, this) == aVar) {
                    return aVar;
                }
            }
            return l2.f10208a;
        }

        @Override // jn.q
        @os.m
        public final Object invoke(@os.l nq.s0 s0Var, @os.l j<? super T> jVar, @os.m um.d<? super l2> dVar) {
            e eVar = new e(this.$periodMillis, this.$this_sample, dVar);
            eVar.L$0 = s0Var;
            eVar.L$1 = jVar;
            return eVar.invokeSuspend(l2.f10208a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @r1({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$timeoutInternal$1\n+ 2 WhileSelect.kt\nkotlinx/coroutines/selects/WhileSelectKt\n+ 3 Select.kt\nkotlinx/coroutines/selects/SelectKt\n*L\n1#1,415:1\n31#2:416\n32#2:425\n55#3,8:417\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$timeoutInternal$1\n*L\n401#1:416\n401#1:425\n401#1:417,8\n*E\n"})
    @xm.f(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1", f = "Delay.kt", i = {0, 0}, l = {TypedValues.CycleType.TYPE_WAVE_OFFSET}, m = "invokeSuspend", n = {"downStream", "values"}, s = {"L$0", "L$1"})
    public static final class f<T> extends xm.o implements jn.q<nq.s0, j<? super T>, um.d<? super l2>, Object> {
        final /* synthetic */ i<T> $this_timeoutInternal;
        final /* synthetic */ long $timeout;
        long J$0;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        @r1({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$timeoutInternal$1$1$1\n+ 2 Channel.kt\nkotlinx/coroutines/channels/ChannelKt\n*L\n1#1,415:1\n514#2,6:416\n548#2,5:422\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$timeoutInternal$1$1$1\n*L\n403#1:416,6\n405#1:422,5\n*E\n"})
        @xm.f(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1$1$1", f = "Delay.kt", i = {0}, l = {404}, m = "invokeSuspend", n = {"$this$onSuccess_u2dWpGqRn0$iv"}, s = {"L$0"})
        public static final class a extends xm.o implements jn.p<pq.p<? extends T>, um.d<? super Boolean>, Object> {
            final /* synthetic */ j<T> $downStream;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public a(j<? super T> jVar, um.d<? super a> dVar) {
                super(2, dVar);
                this.$downStream = jVar;
            }

            @Override // xm.a
            @os.l
            public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
                a aVar = new a(this.$downStream, dVar);
                aVar.L$0 = obj;
                return aVar;
            }

            @Override // jn.p
            public /* synthetic */ Object invoke(Object obj, um.d<? super Boolean> dVar) {
                return m74invokeWpGqRn0(((pq.p) obj).f13310a, dVar);
            }

            @os.m
            /* JADX INFO: renamed from: invoke-WpGqRn0, reason: not valid java name */
            public final Object m74invokeWpGqRn0(@os.l Object obj, @os.m um.d<? super Boolean> dVar) {
                return ((a) create(pq.p.b(obj), dVar)).invokeSuspend(l2.f10208a);
            }

            /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
                jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type um.d to sq.r$f$a for r4v9 'this'  um.d
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
                    if (r1 == 0) goto L17
                    if (r1 != r2) goto Lf
                    java.lang.Object r4 = r4.L$0
                    lm.d1.n(r5)
                    goto L32
                Lf:
                    java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                    java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                    r4.<init>(r5)
                    throw r4
                L17:
                    lm.d1.n(r5)
                    java.lang.Object r5 = r4.L$0
                    pq.p r5 = (pq.p) r5
                    java.lang.Object r5 = r5.f13310a
                    sq.j<T> r1 = r4.$downStream
                    boolean r3 = r5 instanceof pq.p.c
                    if (r3 != 0) goto L33
                    r4.L$0 = r5
                    r4.label = r2
                    java.lang.Object r4 = r1.emit(r5, r4)
                    if (r4 != r0) goto L31
                    return r0
                L31:
                    r4 = r5
                L32:
                    r5 = r4
                L33:
                    boolean r4 = r5 instanceof pq.p.a
                    if (r4 == 0) goto L3d
                    pq.p.f(r5)
                    java.lang.Boolean r4 = java.lang.Boolean.FALSE
                    return r4
                L3d:
                    java.lang.Boolean r4 = java.lang.Boolean.TRUE
                    return r4
                */
                throw new UnsupportedOperationException("Method not decompiled: sq.r.f.a.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        @xm.f(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1$1$2", f = "Delay.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class b extends xm.o implements jn.l<um.d<?>, Object> {
            final /* synthetic */ long $timeout;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(long j10, um.d<? super b> dVar) {
                super(1, dVar);
                this.$timeout = j10;
            }

            @Override // xm.a
            @os.l
            public final um.d<l2> create(@os.l um.d<?> dVar) {
                return new b(this.$timeout, dVar);
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                lm.d1.n(obj);
                throw new v3("Timed out waiting for " + ((Object) lq.e.v0(this.$timeout)));
            }

            @Override // jn.l
            @os.m
            public final Object invoke(@os.m um.d<?> dVar) {
                return ((b) create(dVar)).invokeSuspend(l2.f10208a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public f(long j10, i<? extends T> iVar, um.d<? super f> dVar) {
            super(3, dVar);
            this.$timeout = j10;
            this.$this_timeoutInternal = iVar;
        }

        /* JADX WARN: Code duplicated, block: B:13:0x0077 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:16:0x0080  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0075 -> B:14:0x0078). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:0:?
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // xm.a
        @os.m
        public final java.lang.Object invokeSuspend(@os.l java.lang.Object r10) {
            /*
                r9 = this;
                wm.a r0 = wm.a.COROUTINE_SUSPENDED
                int r1 = r9.label
                r2 = 1
                r3 = 0
                if (r1 == 0) goto L20
                if (r1 != r2) goto L18
                long r4 = r9.J$0
                java.lang.Object r1 = r9.L$1
                pq.f0 r1 = (pq.f0) r1
                java.lang.Object r6 = r9.L$0
                sq.j r6 = (sq.j) r6
                lm.d1.n(r10)
                goto L78
            L18:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L20:
                lm.d1.n(r10)
                java.lang.Object r10 = r9.L$0
                nq.s0 r10 = (nq.s0) r10
                java.lang.Object r1 = r9.L$1
                sq.j r1 = (sq.j) r1
                long r4 = r9.$timeout
                lq.e$a r6 = lq.e.f10247b
                r6.getClass()
                long r6 = lq.e.d()
                int r4 = lq.e.m(r4, r6)
                if (r4 <= 0) goto L83
                sq.i<T> r4 = r9.$this_timeoutInternal
                r5 = 0
                r6 = 2
                sq.i r4 = sq.p.d(r4, r5, r3, r6, r3)
                pq.f0 r10 = sq.m.f(r4, r10)
                long r4 = r9.$timeout
                r6 = r1
                r1 = r10
            L4c:
                yq.l r10 = new yq.l
                um.g r7 = r9.getContext()
                r10.<init>(r7)
                yq.g r7 = r1.B()
                sq.r$f$a r8 = new sq.r$f$a
                r8.<init>(r6, r3)
                r10.e(r7, r8)
                sq.r$f$b r7 = new sq.r$f$b
                r7.<init>(r4, r3)
                yq.b.b(r10, r4, r7)
                r9.L$0 = r6
                r9.L$1 = r1
                r9.J$0 = r4
                r9.label = r2
                java.lang.Object r10 = yq.l.z(r10, r9)
                if (r10 != r0) goto L78
                return r0
            L78:
                java.lang.Boolean r10 = (java.lang.Boolean) r10
                boolean r10 = r10.booleanValue()
                if (r10 != 0) goto L4c
                lm.l2 r9 = lm.l2.f10208a
                return r9
            L83:
                nq.v3 r9 = new nq.v3
                java.lang.String r10 = "Timed out immediately"
                r9.<init>(r10)
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: sq.r.f.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // jn.q
        @os.m
        public final Object invoke(@os.l nq.s0 s0Var, @os.l j<? super T> jVar, @os.m um.d<? super l2> dVar) {
            f fVar = new f(this.$timeout, this.$this_timeoutInternal, dVar);
            fVar.L$0 = s0Var;
            fVar.L$1 = jVar;
            return fVar.invokeSuspend(l2.f10208a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @b2
    @os.l
    public static final <T> i<T> a(@os.l i<? extends T> iVar, long j10) {
        if (j10 >= 0) {
            return j10 == 0 ? iVar : e(iVar, new a(j10));
        }
        throw new IllegalArgumentException("Debounce timeout should not be negative");
    }

    @lm.s0
    @b2
    @os.l
    public static final <T> i<T> b(@os.l i<? extends T> iVar, @os.l jn.l<? super T, Long> lVar) {
        return e(iVar, lVar);
    }

    @b2
    @os.l
    public static final <T> i<T> c(@os.l i<? extends T> iVar, long j10) {
        return a(iVar, d1.e(j10));
    }

    @lm.s0
    @in.i(name = "debounceDuration")
    @b2
    @os.l
    public static final <T> i<T> d(@os.l i<? extends T> iVar, @os.l jn.l<? super T, lq.e> lVar) {
        return e(iVar, new b(lVar));
    }

    public static final <T> i<T> e(i<? extends T> iVar, jn.l<? super T, Long> lVar) {
        return new tq.p.a(new c(lVar, iVar, null));
    }

    @os.l
    public static final pq.f0<l2> f(@os.l nq.s0 s0Var, long j10, long j11) {
        if (j10 < 0) {
            throw new IllegalArgumentException(j1.g.a("Expected non-negative delay, but has ", j10, " ms").toString());
        }
        if (j11 >= 0) {
            return pq.b0.f(s0Var, null, 0, new d(j11, j10, null), 1, null);
        }
        throw new IllegalArgumentException(j1.g.a("Expected non-negative initial delay, but has ", j11, " ms").toString());
    }

    public static pq.f0 g(nq.s0 s0Var, long j10, long j11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j11 = j10;
        }
        return f(s0Var, j10, j11);
    }

    @b2
    @os.l
    public static final <T> i<T> h(@os.l i<? extends T> iVar, long j10) {
        if (j10 > 0) {
            return new tq.p.a(new e(j10, iVar, null));
        }
        throw new IllegalArgumentException("Sample period should be positive");
    }

    @b2
    @os.l
    public static final <T> i<T> i(@os.l i<? extends T> iVar, long j10) {
        return h(iVar, d1.e(j10));
    }

    @b2
    @os.l
    public static final <T> i<T> j(@os.l i<? extends T> iVar, long j10) {
        return k(iVar, j10);
    }

    public static final <T> i<T> k(i<? extends T> iVar, long j10) {
        return new tq.p.a(new f(j10, iVar, null));
    }
}
