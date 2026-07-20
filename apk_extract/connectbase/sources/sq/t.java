package sq;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.lang.reflect.InvocationTargetException;
import kn.k1;
import kn.r1;
import lm.d1;
import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 2 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n+ 3 Exceptions.kt\nkotlinx/coroutines/ExceptionsKt\n*L\n1#1,222:1\n107#2:223\n107#2:224\n107#2:225\n107#2:226\n75#3:227\n*S KotlinDebug\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n*L\n50#1:223\n76#1:224\n146#1:225\n181#1:226\n218#1:227\n*E\n"})
public final /* synthetic */ class t {

    @xm.f(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt", f = "Emitters.kt", i = {0}, l = {216}, m = "invokeSafely$FlowKt__EmittersKt", n = {"cause"}, s = {"L$0"})
    public static final class a<T> extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public a(um.d<? super a> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return t.c(null, null, null, this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 3 CoroutineScope.kt\nkotlinx/coroutines/CoroutineScopeKt\n*L\n1#1,113:1\n147#2,13:114\n160#2,6:128\n329#3:127\n*S KotlinDebug\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n*L\n159#1:127\n*E\n"})
    public static final class b<T> implements i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f15334a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ jn.q f15335b;

        @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1$collect$1\n*L\n1#1,113:1\n*E\n"})
        @xm.f(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1", f = "Emitters.kt", i = {0, 0, 1, 2}, l = {y5.a.f20722h0, y5.a.f20736o0, 129}, m = "collect", n = {"this", "$this$onCompletion_u24lambda_u242", "e", "sc"}, s = {"L$0", "L$1", "L$0", "L$0"})
        public static final class a extends xm.d {
            Object L$0;
            Object L$1;
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
                return b.this.a(null, this);
            }
        }

        public b(i iVar, jn.q qVar) {
            this.f15334a = iVar;
            this.f15335b = qVar;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // sq.i
        @os.m
        public Object a(@os.l j<? super T> jVar, @os.l um.d<? super l2> dVar) throws Throwable {
            a aVar;
            tq.v vVar;
            tq.v vVar2;
            if (dVar instanceof a) {
                aVar = (a) dVar;
                int i10 = aVar.label;
                if ((i10 & Integer.MIN_VALUE) != 0) {
                    aVar.label = i10 - Integer.MIN_VALUE;
                } else {
                    aVar = new a(dVar);
                }
            } else {
                aVar = new a(dVar);
            }
            Object obj = aVar.result;
            wm.a aVar2 = wm.a.COROUTINE_SUSPENDED;
            int i11 = aVar.label;
            try {
                try {
                    if (i11 == 0) {
                        d1.n(obj);
                        i iVar = this.f15334a;
                        aVar.L$0 = this;
                        aVar.L$1 = jVar;
                        aVar.label = 1;
                        if (iVar.a(jVar, aVar) == aVar2) {
                            return aVar2;
                        }
                    } else {
                        if (i11 != 1) {
                            if (i11 == 2) {
                                Throwable th2 = (Throwable) aVar.L$0;
                                d1.n(obj);
                                throw th2;
                            }
                            if (i11 != 3) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            vVar2 = (tq.v) aVar.L$0;
                            try {
                                d1.n(obj);
                                vVar2.releaseIntercepted();
                                return l2.f10208a;
                            } catch (Throwable th3) {
                                th = th3;
                                vVar2.releaseIntercepted();
                                throw th;
                            }
                        }
                        jVar = (j) aVar.L$1;
                        this = (b) aVar.L$0;
                        d1.n(obj);
                    }
                    jn.q qVar = this.f15335b;
                    aVar.L$0 = vVar;
                    aVar.L$1 = null;
                    aVar.label = 3;
                    if (qVar.invoke(vVar, null, aVar) == aVar2) {
                        return aVar2;
                    }
                    vVar2 = vVar;
                    vVar2.releaseIntercepted();
                    return l2.f10208a;
                } catch (Throwable th4) {
                    th = th4;
                    vVar2 = vVar;
                    vVar2.releaseIntercepted();
                    throw th;
                }
                vVar = new tq.v(jVar, aVar.getContext());
            } catch (Throwable th5) {
                b<T> bVar = this;
                a1 a1Var = new a1(th5);
                jn.q qVar2 = bVar.f15335b;
                aVar.L$0 = th5;
                aVar.L$1 = null;
                aVar.label = 2;
                if (t.c(a1Var, qVar2, th5, aVar) == aVar2) {
                    return aVar2;
                }
                throw th5;
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 3 CoroutineScope.kt\nkotlinx/coroutines/CoroutineScopeKt\n*L\n1#1,113:1\n182#2,7:114\n189#2,7:122\n329#3:121\n*S KotlinDebug\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n*L\n188#1:121\n*E\n"})
    public static final class c<T> implements i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f15336a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ jn.p f15337b;

        @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1$collect$1\n*L\n1#1,113:1\n*E\n"})
        @xm.f(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1", f = "Emitters.kt", i = {0, 0, 0, 1}, l = {y5.a.f20722h0, 123}, m = "collect", n = {"this", "$this$onEmpty_u24lambda_u243", "isEmpty", "collector"}, s = {"L$0", "L$1", "L$2", "L$0"})
        public static final class a extends xm.d {
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
                return c.this.a(null, this);
            }
        }

        public c(i iVar, jn.p pVar) {
            this.f15336a = iVar;
            this.f15337b = pVar;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v3 */
        /* JADX WARN: Type inference failed for: r2v4, types: [sq.t$c] */
        /* JADX WARN: Type inference failed for: r2v7 */
        /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.Object, sq.t$c, sq.t$c<T>] */
        /* JADX WARN: Type inference failed for: r6v1, types: [tq.v] */
        /* JADX WARN: Type inference failed for: r6v15 */
        /* JADX WARN: Type inference failed for: r6v16 */
        /* JADX WARN: Type inference failed for: r6v7, types: [tq.v] */
        @Override // sq.i
        @os.m
        public Object a(@os.l j<? super T> jVar, @os.l um.d<? super l2> dVar) {
            a aVar;
            ?? r10;
            k1.a aVar2;
            if (dVar instanceof a) {
                aVar = (a) dVar;
                int i10 = aVar.label;
                if ((i10 & Integer.MIN_VALUE) != 0) {
                    aVar.label = i10 - Integer.MIN_VALUE;
                } else {
                    aVar = new a(dVar);
                }
            } else {
                aVar = new a(dVar);
            }
            Object obj = aVar.result;
            wm.a aVar3 = wm.a.COROUTINE_SUSPENDED;
            int i11 = aVar.label;
            try {
                if (i11 != 0) {
                    if (i11 == 1) {
                        aVar2 = (k1.a) aVar.L$2;
                        jVar = (j) aVar.L$1;
                        c cVar = (c) aVar.L$0;
                        d1.n(obj);
                        r10 = cVar;
                    } else {
                        if (i11 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        boolean z10 = (c<T>) ((tq.v) aVar.L$0);
                        d1.n(obj);
                        this = z10;
                    }
                    ((tq.v) this).releaseIntercepted();
                    return l2.f10208a;
                }
                d1.n(obj);
                k1.a aVar4 = new k1.a();
                aVar4.element = true;
                i iVar = this.f15336a;
                d dVar2 = new d(aVar4, jVar);
                aVar.L$0 = this;
                aVar.L$1 = jVar;
                aVar.L$2 = aVar4;
                aVar.label = 1;
                if (iVar.a(dVar2, aVar) == aVar3) {
                    return aVar3;
                }
                r10 = this;
                aVar2 = aVar4;
                if (aVar2.element) {
                    tq.v vVar = new tq.v(jVar, aVar.getContext());
                    jn.p pVar = r10.f15337b;
                    aVar.L$0 = vVar;
                    aVar.L$1 = null;
                    aVar.L$2 = null;
                    aVar.label = 2;
                    Object objInvoke = pVar.invoke(vVar, aVar);
                    this = vVar;
                    if (objInvoke == aVar3) {
                        return aVar3;
                    }
                    ((tq.v) this).releaseIntercepted();
                }
                return l2.f10208a;
            } catch (Throwable th2) {
                this.releaseIntercepted();
                throw th2;
            }
        }
    }

    public static final class d<T> implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k1.a f15338a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j<T> f15339b;

        @xm.f(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$onEmpty$1$1", f = "Emitters.kt", i = {}, l = {185}, m = "emit", n = {}, s = {})
        public static final class a extends xm.d {
            int label;
            /* synthetic */ Object result;
            final /* synthetic */ d<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public a(d<? super T> dVar, um.d<? super a> dVar2) {
                super(dVar2);
                this.this$0 = dVar;
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
        public d(k1.a aVar, j<? super T> jVar) {
            this.f15338a = aVar;
            this.f15339b = jVar;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
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
            if (i11 == 0) {
                d1.n(obj);
                this.f15338a.element = false;
                j<T> jVar = this.f15339b;
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
            return l2.f10208a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 3 CoroutineScope.kt\nkotlinx/coroutines/CoroutineScopeKt\n*L\n1#1,113:1\n77#2:114\n78#2,7:116\n329#3:115\n*S KotlinDebug\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n*L\n77#1:115\n*E\n"})
    public static final class e<T> implements i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ jn.p f15340a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i f15341b;

        @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1$collect$1\n*L\n1#1,113:1\n*E\n"})
        @xm.f(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1", f = "Emitters.kt", i = {0, 0, 0}, l = {y5.a.f20726j0, 121}, m = "collect", n = {"this", "$this$onStart_u24lambda_u241", "safeCollector"}, s = {"L$0", "L$1", "L$2"})
        public static final class a extends xm.d {
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
                return e.this.a(null, this);
            }
        }

        public e(jn.p pVar, i iVar) {
            this.f15340a = pVar;
            this.f15341b = iVar;
        }

        /* JADX WARN: Code duplicated, block: B:27:0x0077 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // sq.i
        @os.m
        public Object a(@os.l j<? super T> jVar, @os.l um.d<? super l2> dVar) throws Throwable {
            a aVar;
            tq.v vVar;
            e<T> eVar;
            i iVar;
            if (dVar instanceof a) {
                aVar = (a) dVar;
                int i10 = aVar.label;
                if ((i10 & Integer.MIN_VALUE) != 0) {
                    aVar.label = i10 - Integer.MIN_VALUE;
                } else {
                    aVar = new a(dVar);
                }
            } else {
                aVar = new a(dVar);
            }
            Object obj = aVar.result;
            wm.a aVar2 = wm.a.COROUTINE_SUSPENDED;
            int i11 = aVar.label;
            if (i11 == 0) {
                d1.n(obj);
                tq.v vVar2 = new tq.v(jVar, aVar.getContext());
                try {
                    jn.p pVar = this.f15340a;
                    aVar.L$0 = this;
                    aVar.L$1 = jVar;
                    aVar.L$2 = vVar2;
                    aVar.label = 1;
                    if (pVar.invoke(vVar2, aVar) == aVar2) {
                        return aVar2;
                    }
                    eVar = this;
                    vVar = vVar2;
                    vVar.releaseIntercepted();
                    iVar = eVar.f15341b;
                    aVar.L$0 = null;
                    aVar.L$1 = null;
                    aVar.L$2 = null;
                    aVar.label = 2;
                    if (iVar.a(jVar, aVar) == aVar2) {
                        return aVar2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    vVar = vVar2;
                    vVar.releaseIntercepted();
                    throw th;
                }
            } else if (i11 == 1) {
                vVar = (tq.v) aVar.L$2;
                jVar = (j) aVar.L$1;
                eVar = (e) aVar.L$0;
                try {
                    d1.n(obj);
                    vVar.releaseIntercepted();
                    iVar = eVar.f15341b;
                    aVar.L$0 = null;
                    aVar.L$1 = null;
                    aVar.L$2 = null;
                    aVar.label = 2;
                    if (iVar.a(jVar, aVar) == aVar2) {
                        return aVar2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    vVar.releaseIntercepted();
                    throw th;
                }
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
            }
            return l2.f10208a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    @r1({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$transform$1\n*L\n1#1,222:1\n*E\n"})
    @xm.f(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1", f = "Emitters.kt", i = {}, l = {40}, m = "invokeSuspend", n = {}, s = {})
    public static final class f<R> extends xm.o implements jn.p<j<? super R>, um.d<? super l2>, Object> {
        final /* synthetic */ i<T> $this_transform;
        final /* synthetic */ jn.q<j<? super R>, T, um.d<? super l2>, Object> $transform;
        private /* synthetic */ Object L$0;
        int label;

        @r1({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$transform$1$1\n*L\n1#1,222:1\n*E\n"})
        public static final class a<T> implements j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ jn.q<j<? super R>, T, um.d<? super l2>, Object> f15342a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ j<R> f15343b;

            /* JADX INFO: renamed from: sq.t$f$a$a, reason: collision with other inner class name */
            @r1({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$transform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
            @xm.f(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1$1", f = "Emitters.kt", i = {}, l = {42}, m = "emit", n = {}, s = {})
            public static final class C0395a extends xm.d {
                int label;
                /* synthetic */ Object result;
                final /* synthetic */ a<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public C0395a(a<? super T> aVar, um.d<? super C0395a> dVar) {
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
            public a(jn.q<? super j<? super R>, ? super T, ? super um.d<? super l2>, ? extends Object> qVar, j<? super R> jVar) {
                this.f15342a = qVar;
                this.f15343b = jVar;
            }

            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @os.m
            public final Object a(T t10, @os.l um.d<? super l2> dVar) {
                new C0395a(this, dVar);
                this.f15342a.invoke((j<? super R>) this.f15343b, t10, dVar);
                return l2.f10208a;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Override // sq.j
            @os.m
            public final Object emit(T t10, @os.l um.d<? super l2> dVar) {
                C0395a c0395a;
                if (dVar instanceof C0395a) {
                    c0395a = (C0395a) dVar;
                    int i10 = c0395a.label;
                    if ((i10 & Integer.MIN_VALUE) != 0) {
                        c0395a.label = i10 - Integer.MIN_VALUE;
                    } else {
                        c0395a = new C0395a(this, dVar);
                    }
                } else {
                    c0395a = new C0395a(this, dVar);
                }
                Object obj = c0395a.result;
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i11 = c0395a.label;
                if (i11 == 0) {
                    d1.n(obj);
                    jn.q<j<? super R>, T, um.d<? super l2>, Object> qVar = this.f15342a;
                    j<R> jVar = this.f15343b;
                    c0395a.label = 1;
                    if (qVar.invoke((j<? super R>) jVar, t10, c0395a) == aVar) {
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
        public f(i<? extends T> iVar, jn.q<? super j<? super R>, ? super T, ? super um.d<? super l2>, ? extends Object> qVar, um.d<? super f> dVar) {
            super(2, dVar);
            this.$this_transform = iVar;
            this.$transform = qVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            f fVar = new f(this.$this_transform, this.$transform, dVar);
            fVar.L$0 = obj;
            return fVar;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type um.d to sq.t$f<R> for r5v4 'this'  um.d
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
                goto L2e
            Ld:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L15:
                lm.d1.n(r6)
                java.lang.Object r6 = r5.L$0
                sq.j r6 = (sq.j) r6
                sq.i<T> r1 = r5.$this_transform
                sq.t$f$a r3 = new sq.t$f$a
                jn.q<sq.j<? super R>, T, um.d<? super lm.l2>, java.lang.Object> r4 = r5.$transform
                r3.<init>(r4, r6)
                r5.label = r2
                java.lang.Object r5 = r1.a(r3, r5)
                if (r5 != r0) goto L2e
                return r0
            L2e:
                lm.l2 r5 = lm.l2.f10208a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: sq.t.f.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type um.d to sq.t$f<R> for r3v2 'this'  um.d
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @os.m
        public final java.lang.Object invokeSuspend$$forInline(@os.l java.lang.Object r4) {
            /*
                r3 = this;
                java.lang.Object r4 = r3.L$0
                sq.j r4 = (sq.j) r4
                sq.i<T> r0 = r3.$this_transform
                sq.t$f$a r1 = new sq.t$f$a
                jn.q<sq.j<? super R>, T, um.d<? super lm.l2>, java.lang.Object> r2 = r3.$transform
                r1.<init>(r2, r4)
                r0.a(r1, r3)
                lm.l2 r3 = lm.l2.f10208a
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: sq.t.f.invokeSuspend$$forInline(java.lang.Object):java.lang.Object");
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l j<? super R> jVar, @os.m um.d<? super l2> dVar) {
            return ((f) create(jVar, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n*L\n1#1,113:1\n51#2,5:114\n*E\n"})
    public static final class g<R> implements i<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f15344a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ jn.q f15345b;

        @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1$collect$1\n*L\n1#1,113:1\n*E\n"})
        public static final class a extends xm.d {
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
                return g.this.a(null, this);
            }
        }

        public g(i iVar, jn.q qVar) {
            this.f15344a = iVar;
            this.f15345b = qVar;
        }

        @Override // sq.i
        @os.m
        public Object a(@os.l j<? super R> jVar, @os.l um.d<? super l2> dVar) {
            Object objA = this.f15344a.a(new h(this.f15345b, jVar), dVar);
            return objA == wm.a.COROUTINE_SUSPENDED ? objA : l2.f10208a;
        }

        @os.m
        public Object g(@os.l j jVar, @os.l um.d dVar) {
            new a(dVar);
            this.f15344a.a(new h(this.f15345b, jVar), dVar);
            return l2.f10208a;
        }
    }

    @r1({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n*L\n1#1,222:1\n*E\n"})
    public static final class h<T> implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ jn.q<j<? super R>, T, um.d<? super l2>, Object> f15346a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j<R> f15347b;

        @r1({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
        @xm.f(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$unsafeTransform$1$1", f = "Emitters.kt", i = {}, l = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF}, m = "emit", n = {}, s = {})
        public static final class a extends xm.d {
            int label;
            /* synthetic */ Object result;
            final /* synthetic */ h<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public a(h<? super T> hVar, um.d<? super a> dVar) {
                super(dVar);
                this.this$0 = hVar;
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
        public h(jn.q<? super j<? super R>, ? super T, ? super um.d<? super l2>, ? extends Object> qVar, j<? super R> jVar) {
            this.f15346a = qVar;
            this.f15347b = jVar;
        }

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
        @os.m
        public final Object a(T t10, @os.l um.d<? super l2> dVar) {
            new a(this, dVar);
            this.f15346a.invoke(this.f15347b, t10, dVar);
            return l2.f10208a;
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
            Object obj2 = wm.a.COROUTINE_SUSPENDED;
            int i11 = aVar.label;
            if (i11 == 0) {
                d1.n(obj);
                jn.q<j<? super R>, T, um.d<? super l2>, Object> qVar = this.f15346a;
                Object obj3 = this.f15347b;
                aVar.label = 1;
                if (qVar.invoke(obj3, t10, aVar) == obj2) {
                    return obj2;
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

    public static final void b(@os.l j<?> jVar) {
        if (jVar instanceof a1) {
            throw ((a1) jVar).f15205a;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final <T> Object c(j<? super T> jVar, jn.q<? super j<? super T>, ? super Throwable, ? super um.d<? super l2>, ? extends Object> qVar, Throwable th2, um.d<? super l2> dVar) throws IllegalAccessException, InvocationTargetException {
        a aVar;
        if (dVar instanceof a) {
            aVar = (a) dVar;
            int i10 = aVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                aVar.label = i10 - Integer.MIN_VALUE;
            } else {
                aVar = new a(dVar);
            }
        } else {
            aVar = new a(dVar);
        }
        Object obj = aVar.result;
        wm.a aVar2 = wm.a.COROUTINE_SUSPENDED;
        int i11 = aVar.label;
        try {
            if (i11 == 0) {
                d1.n(obj);
                aVar.L$0 = th2;
                aVar.label = 1;
                if (qVar.invoke(jVar, th2, aVar) == aVar2) {
                    return aVar2;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                th2 = (Throwable) aVar.L$0;
                d1.n(obj);
            }
            return l2.f10208a;
        } catch (Throwable th3) {
            if (th2 != null && th2 != th3) {
                lm.p.a(th3, th2);
            }
            throw th3;
        }
    }

    @os.l
    public static final <T> i<T> d(@os.l i<? extends T> iVar, @os.l jn.q<? super j<? super T>, ? super Throwable, ? super um.d<? super l2>, ? extends Object> qVar) {
        return new b(iVar, qVar);
    }

    @os.l
    public static final <T> i<T> e(@os.l i<? extends T> iVar, @os.l jn.p<? super j<? super T>, ? super um.d<? super l2>, ? extends Object> pVar) {
        return new c(iVar, pVar);
    }

    @os.l
    public static final <T> i<T> f(@os.l i<? extends T> iVar, @os.l jn.p<? super j<? super T>, ? super um.d<? super l2>, ? extends Object> pVar) {
        return new e(pVar, iVar);
    }

    @os.l
    public static final <T, R> i<R> g(@os.l i<? extends T> iVar, @lm.b @os.l jn.q<? super j<? super R>, ? super T, ? super um.d<? super l2>, ? extends Object> qVar) {
        return new i0(new f(iVar, qVar, null));
    }

    @lm.z0
    @os.l
    public static final <T, R> i<R> h(@os.l i<? extends T> iVar, @lm.b @os.l jn.q<? super j<? super R>, ? super T, ? super um.d<? super l2>, ? extends Object> qVar) {
        return new g(iVar, qVar);
    }
}
