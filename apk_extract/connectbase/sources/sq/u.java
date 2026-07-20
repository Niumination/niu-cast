package sq;

import java.util.concurrent.CancellationException;
import kn.k1;
import kn.r1;
import lm.d1;
import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nErrors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Errors.kt\nkotlinx/coroutines/flow/FlowKt__ErrorsKt\n+ 2 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n*L\n1#1,224:1\n107#2:225\n107#2:227\n1#3:226\n163#4:228\n*S KotlinDebug\n*F\n+ 1 Errors.kt\nkotlinx/coroutines/flow/FlowKt__ErrorsKt\n*L\n58#1:225\n132#1:227\n221#1:228\n*E\n"})
public final /* synthetic */ class u {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Errors.kt\nkotlinx/coroutines/flow/FlowKt__ErrorsKt\n*L\n1#1,113:1\n59#2,3:114\n*E\n"})
    public static final class a<T> implements i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f15350a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ jn.q f15351b;

        /* JADX INFO: renamed from: sq.u$a$a, reason: collision with other inner class name */
        @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1$collect$1\n*L\n1#1,113:1\n*E\n"})
        @xm.f(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1", f = "Errors.kt", i = {0, 0}, l = {y5.a.f20720g0, y5.a.f20722h0}, m = "collect", n = {"this", "$this$catch_u24lambda_u240"}, s = {"L$0", "L$1"})
        public static final class C0396a extends xm.d {
            Object L$0;
            Object L$1;
            int label;
            /* synthetic */ Object result;

            public C0396a(um.d dVar) {
                super(dVar);
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return a.this.a(null, this);
            }
        }

        public a(i iVar, jn.q qVar) {
            this.f15350a = iVar;
            this.f15351b = qVar;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // sq.i
        @os.m
        public Object a(@os.l j<? super T> jVar, @os.l um.d<? super l2> dVar) throws Throwable {
            C0396a c0396a;
            if (dVar instanceof C0396a) {
                c0396a = (C0396a) dVar;
                int i10 = c0396a.label;
                if ((i10 & Integer.MIN_VALUE) != 0) {
                    c0396a.label = i10 - Integer.MIN_VALUE;
                } else {
                    c0396a = new C0396a(dVar);
                }
            } else {
                c0396a = new C0396a(dVar);
            }
            Object objB = c0396a.result;
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i11 = c0396a.label;
            if (i11 != 0) {
                if (i11 == 1) {
                    jVar = (j) c0396a.L$1;
                    this = (a) c0396a.L$0;
                    d1.n(objB);
                } else {
                    if (i11 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    d1.n(objB);
                }
                return l2.f10208a;
            }
            d1.n(objB);
            i iVar = this.f15350a;
            c0396a.L$0 = this;
            c0396a.L$1 = jVar;
            c0396a.label = 1;
            objB = u.b(iVar, jVar, c0396a);
            if (objB == aVar) {
                return aVar;
            }
            Throwable th2 = (Throwable) objB;
            if (th2 != null) {
                jn.q qVar = this.f15351b;
                c0396a.L$0 = null;
                c0396a.L$1 = null;
                c0396a.label = 2;
                if (qVar.invoke(jVar, th2, c0396a) == aVar) {
                    return aVar;
                }
            }
            return l2.f10208a;
        }
    }

    @xm.f(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt", f = "Errors.kt", i = {0}, l = {156}, m = "catchImpl", n = {"fromDownstream"}, s = {"L$0"})
    public static final class b<T> extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public b(um.d<? super b> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return u.b(null, null, this);
        }
    }

    public static final class c<T> implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j<T> f15352a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ k1.h<Throwable> f15353b;

        @xm.f(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2", f = "Errors.kt", i = {0}, l = {158}, m = "emit", n = {"this"}, s = {"L$0"})
        public static final class a extends xm.d {
            Object L$0;
            int label;
            /* synthetic */ Object result;
            final /* synthetic */ c<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public a(c<? super T> cVar, um.d<? super a> dVar) {
                super(dVar);
                this.this$0 = cVar;
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
        public c(j<? super T> jVar, k1.h<Throwable> hVar) {
            this.f15352a = jVar;
            this.f15353b = hVar;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        /* JADX WARN: Type inference failed for: r5v1, types: [T, java.lang.Throwable] */
        @Override // sq.j
        @os.m
        public final Object emit(T t10, @os.l um.d<? super l2> dVar) {
            a aVar;
            if (dVar instanceof a) {
                aVar = (a) dVar;
                int i10 = aVar.label;
                if ((i10 & Integer.MIN_VALUE) != 0) {
                    aVar.label = i10 - Integer.MIN_VALUE;
                } else {
                    aVar = new a(this, dVar);
                }
            } else {
                aVar = new a(this, dVar);
            }
            Object obj = aVar.result;
            wm.a aVar2 = wm.a.COROUTINE_SUSPENDED;
            int i11 = aVar.label;
            try {
                if (i11 == 0) {
                    d1.n(obj);
                    j<T> jVar = this.f15352a;
                    aVar.L$0 = this;
                    aVar.label = 1;
                    if (jVar.emit(t10, aVar) == aVar2) {
                        return aVar2;
                    }
                } else {
                    if (i11 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    d1.n(obj);
                }
                this = (c<T>) l2.f10208a;
                return this;
            } catch (Throwable 
            /*  JADX ERROR: Method code generation error
                java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getCodeVar()" because "ssaVar" is null
                	at jadx.core.codegen.RegionGen.makeCatchBlock(RegionGen.java:372)
                	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:335)
                	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                	at jadx.core.ProcessClass.process(ProcessClass.java:89)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
                	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
                */
            /*
                this = this;
                boolean r0 = r6 instanceof sq.u.c.a
                if (r0 == 0) goto L13
                r0 = r6
                sq.u$c$a r0 = (sq.u.c.a) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                sq.u$c$a r0 = new sq.u$c$a
                r0.<init>(r4, r6)
            L18:
                java.lang.Object r6 = r0.result
                wm.a r1 = wm.a.COROUTINE_SUSPENDED
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L35
                if (r2 != r3) goto L2d
                java.lang.Object r4 = r0.L$0
                sq.u$c r4 = (sq.u.c) r4
                lm.d1.n(r6)     // Catch: java.lang.Throwable -> L2b
                goto L45
            L2b:
                r5 = move-exception
                goto L48
            L2d:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L35:
                lm.d1.n(r6)
                sq.j<T> r6 = r4.f15352a     // Catch: java.lang.Throwable -> L2b
                r0.L$0 = r4     // Catch: java.lang.Throwable -> L2b
                r0.label = r3     // Catch: java.lang.Throwable -> L2b
                java.lang.Object r4 = r6.emit(r5, r0)     // Catch: java.lang.Throwable -> L2b
                if (r4 != r1) goto L45
                return r1
            L45:
                lm.l2 r4 = lm.l2.f10208a
                return r4
            L48:
                kn.k1$h<java.lang.Throwable> r4 = r4.f15353b
                r4.element = r5
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: sq.u.c.emit(java.lang.Object, um.d):java.lang.Object");
        }
    }

    @xm.f(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$1", f = "Errors.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends xm.o implements jn.p<Throwable, um.d<? super Boolean>, Object> {
        int label;

        public d(um.d<? super d> dVar) {
            super(2, dVar);
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            return new d(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d1.n(obj);
            return Boolean.TRUE;
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l Throwable th2, @os.m um.d<? super Boolean> dVar) {
            return ((d) create(th2, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @xm.f(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$3", f = "Errors.kt", i = {}, l = {da.b.f3634e}, m = "invokeSuspend", n = {}, s = {})
    public static final class e<T> extends xm.o implements jn.r<j<? super T>, Throwable, Long, um.d<? super Boolean>, Object> {
        final /* synthetic */ jn.p<Throwable, um.d<? super Boolean>, Object> $predicate;
        final /* synthetic */ long $retries;
        /* synthetic */ long J$0;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public e(long j10, jn.p<? super Throwable, ? super um.d<? super Boolean>, ? extends Object> pVar, um.d<? super e> dVar) {
            super(4, dVar);
            this.$retries = j10;
            this.$predicate = pVar;
        }

        @Override // jn.r
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Throwable th2, Long l10, um.d<? super Boolean> dVar) {
            return invoke((j) obj, th2, l10.longValue(), dVar);
        }

        /* JADX WARN: Code duplicated, block: B:16:0x0038  */
        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                Throwable th2 = (Throwable) this.L$0;
                if (this.J$0 < this.$retries) {
                    jn.p<Throwable, um.d<? super Boolean>, Object> pVar = this.$predicate;
                    this.label = 1;
                    obj = pVar.invoke(th2, this);
                    if (obj == aVar) {
                        return aVar;
                    }
                }
                return Boolean.valueOf(z);
            }
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d1.n(obj);
            boolean z10 = ((Boolean) obj).booleanValue();
            return Boolean.valueOf(z10);
        }

        @os.m
        public final Object invoke(@os.l j<? super T> jVar, @os.l Throwable th2, long j10, @os.m um.d<? super Boolean> dVar) {
            e eVar = new e(this.$retries, this.$predicate, dVar);
            eVar.L$0 = th2;
            eVar.J$0 = j10;
            return eVar.invokeSuspend(l2.f10208a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Errors.kt\nkotlinx/coroutines/flow/FlowKt__ErrorsKt\n*L\n1#1,113:1\n133#2,15:114\n*E\n"})
    public static final class f<T> implements i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f15354a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ jn.r f15355b;

        @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1$collect$1\n*L\n1#1,113:1\n*E\n"})
        @xm.f(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1", f = "Errors.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {y5.a.f20728k0, 120}, m = "collect", n = {"this", "$this$retryWhen_u24lambda_u242", "attempt", "shallRetry", "this", "$this$retryWhen_u24lambda_u242", "cause", "attempt"}, s = {"L$0", "L$1", "J$0", "I$0", "L$0", "L$1", "L$2", "J$0"})
        public static final class a extends xm.d {
            int I$0;
            long J$0;
            Object L$0;
            Object L$1;
            Object L$2;
            int label;
            /* synthetic */ Object result;

            public a(um.d dVar) {
                super(dVar);
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return f.this.a(null, this);
            }
        }

        public f(i iVar, jn.r rVar) {
            this.f15354a = iVar;
            this.f15355b = rVar;
        }

        /* JADX WARN: Code duplicated, block: B:19:0x0071 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:20:0x0072  */
        /* JADX WARN: Code duplicated, block: B:23:0x007a  */
        /* JADX WARN: Code duplicated, block: B:25:0x0091 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:26:0x0092  */
        /* JADX WARN: Code duplicated, block: B:33:0x00a9  */
        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0078 -> B:30:0x00a1). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0092 -> B:27:0x0095). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:23:0x007a
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // sq.i
        @os.m
        public java.lang.Object a(@os.l sq.j<? super T> r13, @os.l um.d<? super lm.l2> r14) {
            /*
                r12 = this;
                boolean r0 = r14 instanceof sq.u.f.a
                if (r0 == 0) goto L13
                r0 = r14
                sq.u$f$a r0 = (sq.u.f.a) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                sq.u$f$a r0 = new sq.u$f$a
                r0.<init>(r14)
            L18:
                java.lang.Object r14 = r0.result
                wm.a r1 = wm.a.COROUTINE_SUSPENDED
                int r2 = r0.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L56
                if (r2 == r4) goto L40
                if (r2 != r3) goto L38
                long r12 = r0.J$0
                java.lang.Object r2 = r0.L$2
                java.lang.Throwable r2 = (java.lang.Throwable) r2
                java.lang.Object r5 = r0.L$1
                sq.j r5 = (sq.j) r5
                java.lang.Object r6 = r0.L$0
                sq.u$f r6 = (sq.u.f) r6
                lm.d1.n(r14)
                goto L95
            L38:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r13)
                throw r12
            L40:
                int r12 = r0.I$0
                long r5 = r0.J$0
                java.lang.Object r13 = r0.L$1
                sq.j r13 = (sq.j) r13
                java.lang.Object r2 = r0.L$0
                sq.u$f r2 = (sq.u.f) r2
                lm.d1.n(r14)
                r9 = r2
                r2 = r12
                r10 = r5
                r5 = r13
                r6 = r9
                r12 = r10
                goto L76
            L56:
                lm.d1.n(r14)
                r5 = 0
            L5b:
                sq.i r14 = r12.f15354a
                r0.L$0 = r12
                r0.L$1 = r13
                r2 = 0
                r0.L$2 = r2
                r0.J$0 = r5
                r2 = 0
                r0.I$0 = r2
                r0.label = r4
                java.lang.Object r14 = sq.u.b(r14, r13, r0)
                if (r14 != r1) goto L72
                return r1
            L72:
                r9 = r5
                r6 = r12
                r5 = r13
                r12 = r9
            L76:
                java.lang.Throwable r14 = (java.lang.Throwable) r14
                if (r14 == 0) goto La1
                jn.r r2 = r6.f15355b
                java.lang.Long r7 = new java.lang.Long
                r7.<init>(r12)
                r0.L$0 = r6
                r0.L$1 = r5
                r0.L$2 = r14
                r0.J$0 = r12
                r0.label = r3
                java.lang.Object r2 = r2.invoke(r5, r14, r7, r0)
                if (r2 != r1) goto L92
                return r1
            L92:
                r9 = r2
                r2 = r14
                r14 = r9
            L95:
                java.lang.Boolean r14 = (java.lang.Boolean) r14
                boolean r14 = r14.booleanValue()
                if (r14 == 0) goto La6
                r7 = 1
                long r12 = r12 + r7
                r2 = r4
            La1:
                r9 = r12
                r13 = r5
                r12 = r6
                r5 = r9
                goto La7
            La6:
                throw r2
            La7:
                if (r2 != 0) goto L5b
                lm.l2 r12 = lm.l2.f10208a
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: sq.u.f.a(sq.j, um.d):java.lang.Object");
        }
    }

    @os.l
    public static final <T> i<T> a(@os.l i<? extends T> iVar, @os.l jn.q<? super j<? super T>, ? super Throwable, ? super um.d<? super l2>, ? extends Object> qVar) {
        return new a(iVar, qVar);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @os.m
    public static final <T> Object b(@os.l i<? extends T> iVar, @os.l j<? super T> jVar, @os.l um.d<? super Throwable> dVar) throws Throwable {
        b bVar;
        k1.h hVar;
        if (dVar instanceof b) {
            bVar = (b) dVar;
            int i10 = bVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                bVar.label = i10 - Integer.MIN_VALUE;
            } else {
                bVar = new b(dVar);
            }
        } else {
            bVar = new b(dVar);
        }
        Object obj = bVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = bVar.label;
        if (i11 == 0) {
            d1.n(obj);
            k1.h hVar2 = new k1.h();
            try {
                j<? super Object> cVar = new c<>(jVar, hVar2);
                bVar.L$0 = hVar2;
                bVar.label = 1;
                if (iVar.a(cVar, bVar) == aVar) {
                    return aVar;
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                hVar = hVar2;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            hVar = (k1.h) bVar.L$0;
            try {
                d1.n(obj);
                return null;
            } catch (Throwable th3) {
                th = th3;
            }
        }
        Throwable th4 = (Throwable) hVar.element;
        if (d(th, th4) || c(th, bVar.getContext())) {
            throw th;
        }
        if (th4 == null) {
            return th;
        }
        if (th instanceof CancellationException) {
            lm.p.a(th4, th);
            throw th4;
        }
        lm.p.a(th, th4);
        throw th;
    }

    public static final boolean c(Throwable th2, um.g gVar) {
        nq.l2 l2Var = (nq.l2) gVar.get(nq.l2.f11882k);
        if (l2Var == null || !l2Var.isCancelled()) {
            return false;
        }
        return d(th2, l2Var.O());
    }

    public static final boolean d(Throwable th2, Throwable th3) {
        return th3 != null && kn.l0.g(th3, th2);
    }

    @os.l
    public static final <T> i<T> e(@os.l i<? extends T> iVar, long j10, @os.l jn.p<? super Throwable, ? super um.d<? super Boolean>, ? extends Object> pVar) {
        if (j10 > 0) {
            return new f(iVar, new e(j10, pVar, null));
        }
        throw new IllegalArgumentException(h0.b.a("Expected positive amount of retries, but had ", j10).toString());
    }

    public static i f(i iVar, long j10, jn.p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = Long.MAX_VALUE;
        }
        if ((i10 & 2) != 0) {
            pVar = new d(null);
        }
        return e(iVar, j10, pVar);
    }

    @os.l
    public static final <T> i<T> g(@os.l i<? extends T> iVar, @os.l jn.r<? super j<? super T>, ? super Throwable, ? super Long, ? super um.d<? super Boolean>, ? extends Object> rVar) {
        return new f(iVar, rVar);
    }
}
