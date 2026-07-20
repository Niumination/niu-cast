package tq;

import java.util.concurrent.atomic.AtomicInteger;
import kn.l0;
import kn.n0;
import kn.r1;
import lm.d1;
import lm.l2;
import lm.z0;
import nq.d4;
import nq.r2;
import nq.s0;
import nq.t0;
import pq.d0;
import pq.f0;
import pq.g0;
import vq.a1;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nCombine.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Combine.kt\nkotlinx/coroutines/flow/internal/CombineKt\n+ 2 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,143:1\n107#2:144\n*S KotlinDebug\n*F\n+ 1 Combine.kt\nkotlinx/coroutines/flow/internal/CombineKt\n*L\n86#1:144\n*E\n"})
public final class m {

    @xm.f(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2", f = "Combine.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {54, en.a.f4563i, 79}, m = "invokeSuspend", n = {"latestValues", "resultChannel", "lastReceivedEpoch", "remainingAbsentValues", "currentEpoch", "latestValues", "resultChannel", "lastReceivedEpoch", "remainingAbsentValues", "currentEpoch", "latestValues", "resultChannel", "lastReceivedEpoch", "remainingAbsentValues", "currentEpoch"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1"})
    public static final class a extends xm.o implements jn.p<s0, um.d<? super l2>, Object> {
        final /* synthetic */ jn.a<T[]> $arrayFactory;
        final /* synthetic */ sq.i<T>[] $flows;
        final /* synthetic */ sq.j<R> $this_combineInternal;
        final /* synthetic */ jn.q<sq.j<? super R>, T[], um.d<? super l2>, Object> $transform;
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX INFO: renamed from: tq.m$a$a, reason: collision with other inner class name */
        @xm.f(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1", f = "Combine.kt", i = {}, l = {31}, m = "invokeSuspend", n = {}, s = {})
        public static final class C0420a extends xm.o implements jn.p<s0, um.d<? super l2>, Object> {
            final /* synthetic */ sq.i<T>[] $flows;
            final /* synthetic */ int $i;
            final /* synthetic */ AtomicInteger $nonClosed;
            final /* synthetic */ pq.l<nm.s0<Object>> $resultChannel;
            int label;

            /* JADX INFO: renamed from: tq.m$a$a$a, reason: collision with other inner class name */
            public static final class C0421a<T> implements sq.j {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ pq.l<nm.s0<Object>> f16045a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ int f16046b;

                /* JADX INFO: renamed from: tq.m$a$a$a$a, reason: collision with other inner class name */
                @xm.f(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1", f = "Combine.kt", i = {}, l = {32, 33}, m = "emit", n = {}, s = {})
                public static final class C0422a extends xm.d {
                    int label;
                    /* synthetic */ Object result;
                    final /* synthetic */ C0421a<T> this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    public C0422a(C0421a<? super T> c0421a, um.d<? super C0422a> dVar) {
                        super(dVar);
                        this.this$0 = c0421a;
                    }

                    @Override // xm.a
                    @os.m
                    public final Object invokeSuspend(@os.l Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return this.this$0.emit(null, this);
                    }
                }

                public C0421a(pq.l<nm.s0<Object>> lVar, int i10) {
                    this.f16045a = lVar;
                    this.f16046b = i10;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                @Override // sq.j
                @os.m
                public final Object emit(T t10, @os.l um.d<? super l2> dVar) {
                    C0422a c0422a;
                    if (dVar instanceof C0422a) {
                        c0422a = (C0422a) dVar;
                        int i10 = c0422a.label;
                        if ((i10 & Integer.MIN_VALUE) != 0) {
                            c0422a.label = i10 - Integer.MIN_VALUE;
                        } else {
                            c0422a = new C0422a(this, dVar);
                        }
                    } else {
                        c0422a = new C0422a(this, dVar);
                    }
                    Object obj = c0422a.result;
                    wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                    int i11 = c0422a.label;
                    if (i11 != 0) {
                        if (i11 == 1) {
                            d1.n(obj);
                        } else {
                            if (i11 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            d1.n(obj);
                        }
                        return l2.f10208a;
                    }
                    d1.n(obj);
                    pq.l<nm.s0<Object>> lVar = this.f16045a;
                    nm.s0<Object> s0Var = new nm.s0<>(this.f16046b, t10);
                    c0422a.label = 1;
                    if (lVar.L(s0Var, c0422a) == aVar) {
                        return aVar;
                    }
                    c0422a.label = 2;
                    if (d4.a(c0422a) == aVar) {
                        return aVar;
                    }
                    return l2.f10208a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C0420a(sq.i<? extends T>[] iVarArr, int i10, AtomicInteger atomicInteger, pq.l<nm.s0<Object>> lVar, um.d<? super C0420a> dVar) {
                super(2, dVar);
                this.$flows = iVarArr;
                this.$i = i10;
                this.$nonClosed = atomicInteger;
                this.$resultChannel = lVar;
            }

            @Override // xm.a
            @os.l
            public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
                return new C0420a(this.$flows, this.$i, this.$nonClosed, this.$resultChannel, dVar);
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i10 = this.label;
                try {
                    if (i10 == 0) {
                        d1.n(obj);
                        sq.i[] iVarArr = this.$flows;
                        int i11 = this.$i;
                        sq.i iVar = iVarArr[i11];
                        C0421a c0421a = new C0421a(this.$resultChannel, i11);
                        this.label = 1;
                        if (iVar.a(c0421a, this) == aVar) {
                            return aVar;
                        }
                    } else {
                        if (i10 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        d1.n(obj);
                    }
                    if (this.$nonClosed.decrementAndGet() == 0) {
                        g0.a.a(this.$resultChannel, null, 1, null);
                    }
                    return l2.f10208a;
                } catch (Throwable th2) {
                    if (this.$nonClosed.decrementAndGet() == 0) {
                        g0.a.a(this.$resultChannel, null, 1, null);
                    }
                    throw th2;
                }
            }

            @Override // jn.p
            @os.m
            public final Object invoke(@os.l s0 s0Var, @os.m um.d<? super l2> dVar) {
                return ((C0420a) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(sq.i<? extends T>[] iVarArr, jn.a<T[]> aVar, jn.q<? super sq.j<? super R>, ? super T[], ? super um.d<? super l2>, ? extends Object> qVar, sq.j<? super R> jVar, um.d<? super a> dVar) {
            super(2, dVar);
            this.$flows = iVarArr;
            this.$arrayFactory = aVar;
            this.$transform = qVar;
            this.$this_combineInternal = jVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            a aVar = new a(this.$flows, this.$arrayFactory, this.$transform, this.$this_combineInternal, dVar);
            aVar.L$0 = obj;
            return aVar;
        }

        /* JADX WARN: Code duplicated, block: B:22:0x00bb A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:23:0x00bc  */
        /* JADX WARN: Code duplicated, block: B:26:0x00c5  */
        /* JADX WARN: Code duplicated, block: B:28:0x00c8 A[LOOP:0: B:28:0x00c8->B:48:?, LOOP_START, PHI: r6 r10
          0x00c8: PHI (r6v6 int) = (r6v5 int), (r6v7 int) binds: [B:25:0x00c3, B:48:?] A[DONT_GENERATE, DONT_INLINE]
          0x00c8: PHI (r10v8 nm.s0) = (r10v7 nm.s0), (r10v21 nm.s0) binds: [B:25:0x00c3, B:48:?] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:30:0x00d4  */
        /* JADX WARN: Code duplicated, block: B:33:0x00da  */
        /* JADX WARN: Code duplicated, block: B:36:0x00eb  */
        /* JADX WARN: Code duplicated, block: B:38:0x00f5  */
        /* JADX WARN: Code duplicated, block: B:40:0x010b A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:41:0x010c  */
        /* JADX WARN: Code duplicated, block: B:43:0x012e A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:46:0x00e9 A[EDGE_INSN: B:46:0x00e9->B:35:0x00e9 BREAK  A[LOOP:0: B:28:0x00c8->B:48:?], SYNTHETIC] */
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
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x012f -> B:45:0x0131). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // xm.a
        @os.m
        public final java.lang.Object invokeSuspend(@os.l java.lang.Object r24) {
            /*
                Method dump skipped, instruction units count: 308
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: tq.m.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l s0 s0Var, @os.m um.d<? super l2> dVar) {
            return ((a) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Combine.kt\nkotlinx/coroutines/flow/internal/CombineKt\n*L\n1#1,113:1\n87#2:114\n142#2:115\n*E\n"})
    public static final class b<R> implements sq.i<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ sq.i f16047a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ sq.i f16048b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ jn.q f16049c;

        public b(sq.i iVar, sq.i iVar2, jn.q qVar) {
            this.f16047a = iVar;
            this.f16048b = iVar2;
            this.f16049c = qVar;
        }

        @Override // sq.i
        @os.m
        public Object a(@os.l sq.j<? super R> jVar, @os.l um.d<? super l2> dVar) {
            Object objG = t0.g(new c(jVar, this.f16047a, this.f16048b, this.f16049c, null), dVar);
            return objG == wm.a.COROUTINE_SUSPENDED ? objG : l2.f10208a;
        }
    }

    @xm.f(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1", f = "Combine.kt", i = {0}, l = {126}, m = "invokeSuspend", n = {y1.o.r.f20674f}, s = {"L$0"})
    public static final class c extends xm.o implements jn.p<s0, um.d<? super l2>, Object> {
        final /* synthetic */ sq.i<T1> $flow;
        final /* synthetic */ sq.i<T2> $flow2;
        final /* synthetic */ sq.j<R> $this_unsafeFlow;
        final /* synthetic */ jn.q<T1, T2, um.d<? super R>, Object> $transform;
        private /* synthetic */ Object L$0;
        int label;

        public static final class a extends n0 implements jn.l<Throwable, l2> {
            final /* synthetic */ nq.b0 $collectJob;
            final /* synthetic */ sq.j<R> $this_unsafeFlow;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public a(nq.b0 b0Var, sq.j<? super R> jVar) {
                super(1);
                this.$collectJob = b0Var;
                this.$this_unsafeFlow = jVar;
            }

            @Override // jn.l
            public /* bridge */ /* synthetic */ l2 invoke(Throwable th2) {
                invoke2(th2);
                return l2.f10208a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@os.m Throwable th2) {
                if (this.$collectJob.isActive()) {
                    this.$collectJob.b(new tq.a(this.$this_unsafeFlow));
                }
            }
        }

        @xm.f(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2", f = "Combine.kt", i = {}, l = {127}, m = "invokeSuspend", n = {}, s = {})
        public static final class b extends xm.o implements jn.p<l2, um.d<? super l2>, Object> {
            final /* synthetic */ Object $cnt;
            final /* synthetic */ sq.i<T1> $flow;
            final /* synthetic */ um.g $scopeContext;
            final /* synthetic */ f0<Object> $second;
            final /* synthetic */ sq.j<R> $this_unsafeFlow;
            final /* synthetic */ jn.q<T1, T2, um.d<? super R>, Object> $transform;
            int label;

            public static final class a<T> implements sq.j {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ um.g f16050a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ Object f16051b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                public final /* synthetic */ f0<Object> f16052c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                public final /* synthetic */ sq.j<R> f16053d;

                /* JADX INFO: renamed from: e, reason: collision with root package name */
                public final /* synthetic */ jn.q<T1, T2, um.d<? super R>, Object> f16054e;

                /* JADX INFO: renamed from: tq.m$c$b$a$a, reason: collision with other inner class name */
                @r1({"SMAP\nCombine.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Combine.kt\nkotlinx/coroutines/flow/internal/CombineKt$zipImpl$1$1$2$1$1\n+ 2 Channel.kt\nkotlinx/coroutines/channels/ChannelKt\n+ 3 Symbol.kt\nkotlinx/coroutines/internal/Symbol\n*L\n1#1,143:1\n501#2,5:144\n18#3:149\n*S KotlinDebug\n*F\n+ 1 Combine.kt\nkotlinx/coroutines/flow/internal/CombineKt$zipImpl$1$1$2$1$1\n*L\n129#1:144,5\n132#1:149\n*E\n"})
                @xm.f(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$1", f = "Combine.kt", i = {}, l = {129, 132, 132}, m = "invokeSuspend", n = {}, s = {})
                public static final class C0423a extends xm.o implements jn.p<l2, um.d<? super l2>, Object> {
                    final /* synthetic */ f0<Object> $second;
                    final /* synthetic */ sq.j<R> $this_unsafeFlow;
                    final /* synthetic */ jn.q<T1, T2, um.d<? super R>, Object> $transform;
                    final /* synthetic */ T1 $value;
                    Object L$0;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    public C0423a(f0<? extends Object> f0Var, sq.j<? super R> jVar, jn.q<? super T1, ? super T2, ? super um.d<? super R>, ? extends Object> qVar, T1 t10, um.d<? super C0423a> dVar) {
                        super(2, dVar);
                        this.$second = f0Var;
                        this.$this_unsafeFlow = jVar;
                        this.$transform = qVar;
                        this.$value = t10;
                    }

                    @Override // xm.a
                    @os.l
                    public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
                        return new C0423a(this.$second, this.$this_unsafeFlow, this.$transform, this.$value, dVar);
                    }

                    /* JADX WARN: Code duplicated, block: B:29:0x006a A[RETURN] */
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
                    @Override // xm.a
                    @os.m
                    public final Object invokeSuspend(@os.l Object obj) throws Throwable {
                        Object objS;
                        sq.j jVar;
                        Object obj2 = wm.a.COROUTINE_SUSPENDED;
                        int i10 = this.label;
                        if (i10 != 0) {
                            if (i10 == 1) {
                                d1.n(obj);
                                objS = ((pq.p) obj).f13310a;
                            } else if (i10 == 2) {
                                sq.j jVar2 = (sq.j) this.L$0;
                                d1.n(obj);
                                jVar = jVar2;
                                this.L$0 = null;
                                this.label = 3;
                                if (jVar.emit(obj, this) == obj2) {
                                    return obj2;
                                }
                            } else {
                                if (i10 != 3) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                d1.n(obj);
                            }
                            return l2.f10208a;
                        }
                        d1.n(obj);
                        f0<Object> f0Var = this.$second;
                        this.label = 1;
                        objS = f0Var.s(this);
                        if (objS == obj2) {
                            return obj2;
                        }
                        sq.j jVar3 = this.$this_unsafeFlow;
                        if (objS instanceof pq.p.c) {
                            Throwable thF = pq.p.f(objS);
                            if (thF == null) {
                                throw new tq.a(jVar3);
                            }
                            throw thF;
                        }
                        jn.q<T1, T2, um.d<? super R>, Object> qVar = this.$transform;
                        T1 t10 = this.$value;
                        if (objS == u.f16062a) {
                            objS = null;
                        }
                        this.L$0 = jVar3;
                        this.label = 2;
                        obj = qVar.invoke(t10, objS, this);
                        jVar = jVar3;
                        if (obj == obj2) {
                            return obj2;
                        }
                        this.L$0 = null;
                        this.label = 3;
                        if (jVar.emit(obj, this) == obj2) {
                            return obj2;
                        }
                        return l2.f10208a;
                    }

                    @Override // jn.p
                    @os.m
                    public final Object invoke(@os.l l2 l2Var, @os.m um.d<? super l2> dVar) {
                        return ((C0423a) create(l2Var, dVar)).invokeSuspend(l2.f10208a);
                    }
                }

                /* JADX INFO: renamed from: tq.m$c$b$a$b, reason: collision with other inner class name */
                @xm.f(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1", f = "Combine.kt", i = {}, l = {128}, m = "emit", n = {}, s = {})
                public static final class C0424b extends xm.d {
                    int label;
                    /* synthetic */ Object result;
                    final /* synthetic */ a<T> this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    public C0424b(a<? super T> aVar, um.d<? super C0424b> dVar) {
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

                /* JADX WARN: Multi-variable type inference failed */
                public a(um.g gVar, Object obj, f0<? extends Object> f0Var, sq.j<? super R> jVar, jn.q<? super T1, ? super T2, ? super um.d<? super R>, ? extends Object> qVar) {
                    this.f16050a = gVar;
                    this.f16051b = obj;
                    this.f16052c = f0Var;
                    this.f16053d = jVar;
                    this.f16054e = qVar;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                @Override // sq.j
                @os.m
                public final Object emit(T1 t10, @os.l um.d<? super l2> dVar) {
                    C0424b c0424b;
                    if (dVar instanceof C0424b) {
                        c0424b = (C0424b) dVar;
                        int i10 = c0424b.label;
                        if ((i10 & Integer.MIN_VALUE) != 0) {
                            c0424b.label = i10 - Integer.MIN_VALUE;
                        } else {
                            c0424b = new C0424b(this, dVar);
                        }
                    } else {
                        c0424b = new C0424b(this, dVar);
                    }
                    Object obj = c0424b.result;
                    wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                    int i11 = c0424b.label;
                    if (i11 == 0) {
                        d1.n(obj);
                        um.g gVar = this.f16050a;
                        l2 l2Var = l2.f10208a;
                        Object obj2 = this.f16051b;
                        C0423a c0423a = new C0423a(this.f16052c, this.f16053d, this.f16054e, t10, null);
                        c0424b.label = 1;
                        if (f.c(gVar, l2Var, obj2, c0423a, c0424b) == aVar) {
                            return aVar;
                        }
                    } else {
                        if (i11 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        d1.n(obj);
                    }
                    return l2.f10208a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public b(sq.i<? extends T1> iVar, um.g gVar, Object obj, f0<? extends Object> f0Var, sq.j<? super R> jVar, jn.q<? super T1, ? super T2, ? super um.d<? super R>, ? extends Object> qVar, um.d<? super b> dVar) {
                super(2, dVar);
                this.$flow = iVar;
                this.$scopeContext = gVar;
                this.$cnt = obj;
                this.$second = f0Var;
                this.$this_unsafeFlow = jVar;
                this.$transform = qVar;
            }

            @Override // xm.a
            @os.l
            public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
                return new b(this.$flow, this.$scopeContext, this.$cnt, this.$second, this.$this_unsafeFlow, this.$transform, dVar);
            }

            /* JADX WARN: Type inference incomplete: some casts might be missing */
            /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
                jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type um.d to tq.m$c$b for r9v4 'this'  um.d
                	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
                	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
                	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
                	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
                	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
                */
            @Override // xm.a
            @os.m
            public final java.lang.Object invokeSuspend(@os.l java.lang.Object r10) {
                /*
                    r9 = this;
                    wm.a r0 = wm.a.COROUTINE_SUSPENDED
                    int r1 = r9.label
                    r2 = 1
                    if (r1 == 0) goto L15
                    if (r1 != r2) goto Ld
                    lm.d1.n(r10)
                    goto L33
                Ld:
                    java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                    java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                    r9.<init>(r10)
                    throw r9
                L15:
                    lm.d1.n(r10)
                    sq.i<T1> r10 = r9.$flow
                    tq.m$c$b$a r1 = new tq.m$c$b$a
                    um.g r4 = r9.$scopeContext
                    java.lang.Object r5 = r9.$cnt
                    pq.f0<java.lang.Object> r6 = r9.$second
                    sq.j<R> r7 = r9.$this_unsafeFlow
                    jn.q<T1, T2, um.d<? super R>, java.lang.Object> r8 = r9.$transform
                    r3 = r1
                    r3.<init>(r4, r5, r6, r7, r8)
                    r9.label = r2
                    java.lang.Object r9 = r10.a(r1, r9)
                    if (r9 != r0) goto L33
                    return r0
                L33:
                    lm.l2 r9 = lm.l2.f10208a
                    return r9
                */
                throw new UnsupportedOperationException("Method not decompiled: tq.m.c.b.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // jn.p
            @os.m
            public final Object invoke(@os.l l2 l2Var, @os.m um.d<? super l2> dVar) {
                return ((b) create(l2Var, dVar)).invokeSuspend(l2.f10208a);
            }
        }

        /* JADX INFO: renamed from: tq.m$c$c, reason: collision with other inner class name */
        @xm.f(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1", f = "Combine.kt", i = {}, l = {89}, m = "invokeSuspend", n = {}, s = {})
        public static final class C0425c extends xm.o implements jn.p<d0<? super Object>, um.d<? super l2>, Object> {
            final /* synthetic */ sq.i<T2> $flow2;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX INFO: renamed from: tq.m$c$c$a */
            public static final class a<T> implements sq.j {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ d0<Object> f16055a;

                /* JADX INFO: renamed from: tq.m$c$c$a$a, reason: collision with other inner class name */
                @xm.f(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1$1", f = "Combine.kt", i = {}, l = {90}, m = "emit", n = {}, s = {})
                public static final class C0426a extends xm.d {
                    int label;
                    /* synthetic */ Object result;
                    final /* synthetic */ a<T> this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    public C0426a(a<? super T> aVar, um.d<? super C0426a> dVar) {
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

                public a(d0<Object> d0Var) {
                    this.f16055a = d0Var;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                @Override // sq.j
                @os.m
                public final Object emit(T2 t10, @os.l um.d<? super l2> dVar) {
                    C0426a c0426a;
                    Object obj;
                    if (dVar instanceof C0426a) {
                        c0426a = (C0426a) dVar;
                        int i10 = c0426a.label;
                        if ((i10 & Integer.MIN_VALUE) != 0) {
                            c0426a.label = i10 - Integer.MIN_VALUE;
                        } else {
                            c0426a = new C0426a(this, dVar);
                        }
                    } else {
                        c0426a = new C0426a(this, dVar);
                    }
                    Object obj2 = c0426a.result;
                    wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                    int i11 = c0426a.label;
                    if (i11 == 0) {
                        d1.n(obj2);
                        g0<Object> g0VarA = this.f16055a.a();
                        if (t10 == 0) {
                            obj = t10;
                            obj = u.f16062a;
                        }
                        obj = t10;
                        c0426a.label = 1;
                        if (g0VarA.L(obj, c0426a) == aVar) {
                            return aVar;
                        }
                    } else {
                        if (i11 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        d1.n(obj2);
                    }
                    return l2.f10208a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C0425c(sq.i<? extends T2> iVar, um.d<? super C0425c> dVar) {
                super(2, dVar);
                this.$flow2 = iVar;
            }

            @Override // xm.a
            @os.l
            public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
                C0425c c0425c = new C0425c(this.$flow2, dVar);
                c0425c.L$0 = obj;
                return c0425c;
            }

            @Override // jn.p
            public /* bridge */ /* synthetic */ Object invoke(d0<? super Object> d0Var, um.d<? super l2> dVar) {
                return invoke2((d0<Object>) d0Var, dVar);
            }

            /* JADX WARN: Type inference incomplete: some casts might be missing */
            /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
                jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type um.d to tq.m$c$c for r4v4 'this'  um.d
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
                    goto L2c
                Ld:
                    java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                    java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                    r4.<init>(r5)
                    throw r4
                L15:
                    lm.d1.n(r5)
                    java.lang.Object r5 = r4.L$0
                    pq.d0 r5 = (pq.d0) r5
                    sq.i<T2> r1 = r4.$flow2
                    tq.m$c$c$a r3 = new tq.m$c$c$a
                    r3.<init>(r5)
                    r4.label = r2
                    java.lang.Object r4 = r1.a(r3, r4)
                    if (r4 != r0) goto L2c
                    return r0
                L2c:
                    lm.l2 r4 = lm.l2.f10208a
                    return r4
                */
                throw new UnsupportedOperationException("Method not decompiled: tq.m.c.C0425c.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @os.m
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(@os.l d0<Object> d0Var, @os.m um.d<? super l2> dVar) {
                return ((C0425c) create(d0Var, dVar)).invokeSuspend(l2.f10208a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public c(sq.j<? super R> jVar, sq.i<? extends T2> iVar, sq.i<? extends T1> iVar2, jn.q<? super T1, ? super T2, ? super um.d<? super R>, ? extends Object> qVar, um.d<? super c> dVar) {
            super(2, dVar);
            this.$this_unsafeFlow = jVar;
            this.$flow2 = iVar;
            this.$flow = iVar2;
            this.$transform = qVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            c cVar = new c(this.$this_unsafeFlow, this.$flow2, this.$flow, this.$transform, dVar);
            cVar.L$0 = obj;
            return cVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1 */
        /* JADX WARN: Type inference failed for: r1v10 */
        /* JADX WARN: Type inference failed for: r1v12, types: [pq.f0] */
        /* JADX WARN: Type inference failed for: r1v13 */
        /* JADX WARN: Type inference failed for: r1v17 */
        /* JADX WARN: Type inference failed for: r1v18 */
        /* JADX WARN: Type inference failed for: r1v2, types: [pq.f0] */
        /* JADX WARN: Type inference failed for: r1v5 */
        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) throws Throwable {
            f0 f0Var;
            f0 f0Var2;
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            ?? r10 = this.label;
            try {
                if (r10 != 0) {
                    if (r10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    f0Var2 = (f0) this.L$0;
                    try {
                        d1.n(obj);
                        r10 = f0Var2;
                    } catch (tq.a e10) {
                        e = e10;
                        q.b(e, this.$this_unsafeFlow);
                        r10 = f0Var2;
                    }
                    f0.a.b(r10, null, 1, null);
                    return l2.f10208a;
                }
                d1.n(obj);
                s0 s0Var = (s0) this.L$0;
                f0 f0VarF = pq.b0.f(s0Var, null, 0, new C0425c(this.$flow2, null), 3, null);
                nq.b0 b0VarC = r2.c(null, 1, null);
                l0.n(f0VarF, "null cannot be cast to non-null type kotlinx.coroutines.channels.SendChannel<*>");
                ((g0) f0VarF).i(new a(b0VarC, this.$this_unsafeFlow));
                try {
                    um.g coroutineContext = s0Var.getCoroutineContext();
                    Object objB = a1.b(coroutineContext);
                    um.g gVarPlus = s0Var.getCoroutineContext().plus(b0VarC);
                    l2 l2Var = l2.f10208a;
                    b bVar = new b(this.$flow, coroutineContext, objB, f0VarF, this.$this_unsafeFlow, this.$transform, null);
                    this.L$0 = f0VarF;
                    this.label = 1;
                    f0Var = f0VarF;
                    try {
                        if (f.d(gVarPlus, l2Var, null, bVar, this, 4, null) == aVar) {
                            return aVar;
                        }
                        r10 = f0Var;
                        f0.a.b(r10, null, 1, null);
                        return l2.f10208a;
                    } catch (tq.a e11) {
                        e = e11;
                        f0Var2 = f0Var;
                        q.b(e, this.$this_unsafeFlow);
                        r10 = f0Var2;
                    } catch (Throwable th2) {
                        th = th2;
                        r10 = f0Var;
                        f0.a.b(r10, null, 1, null);
                        throw th;
                    }
                } catch (tq.a e12) {
                    e = e12;
                    f0Var = f0VarF;
                } catch (Throwable th3) {
                    th = th3;
                    f0Var = f0VarF;
                }
                q.b(e, this.$this_unsafeFlow);
                r10 = f0Var2;
                f0.a.b(r10, null, 1, null);
                return l2.f10208a;
            } catch (Throwable th4) {
                th = th4;
            }
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l s0 s0Var, @os.m um.d<? super l2> dVar) {
            return ((c) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @os.m
    @z0
    public static final <R, T> Object a(@os.l sq.j<? super R> jVar, @os.l sq.i<? extends T>[] iVarArr, @os.l jn.a<T[]> aVar, @os.l jn.q<? super sq.j<? super R>, ? super T[], ? super um.d<? super l2>, ? extends Object> qVar, @os.l um.d<? super l2> dVar) {
        Object objA = p.a(new a(iVarArr, aVar, qVar, jVar, null), dVar);
        return objA == wm.a.COROUTINE_SUSPENDED ? objA : l2.f10208a;
    }

    @os.l
    public static final <T1, T2, R> sq.i<R> b(@os.l sq.i<? extends T1> iVar, @os.l sq.i<? extends T2> iVar2, @os.l jn.q<? super T1, ? super T2, ? super um.d<? super R>, ? extends Object> qVar) {
        return new b(iVar2, iVar, qVar);
    }
}
