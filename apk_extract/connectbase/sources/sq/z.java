package sq;

import java.util.NoSuchElementException;
import kn.k1;
import kn.r1;
import lm.d1;
import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nReduce.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Reduce.kt\nkotlinx/coroutines/flow/FlowKt__ReduceKt\n+ 2 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt\n*L\n1#1,172:1\n126#2,15:173\n126#2,15:188\n126#2,15:203\n126#2,15:218\n126#2,15:233\n*S KotlinDebug\n*F\n+ 1 Reduce.kt\nkotlinx/coroutines/flow/FlowKt__ReduceKt\n*L\n72#1:173,15\n92#1:188,15\n106#1:203,15\n124#1:218,15\n137#1:233,15\n*E\n"})
public final /* synthetic */ class z {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @r1({"SMAP\nLimit.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1\n+ 2 Reduce.kt\nkotlinx/coroutines/flow/FlowKt__ReduceKt\n*L\n1#1,141:1\n93#2,2:142\n*E\n"})
    public static final class a<T> implements sq.j<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k1.h f15396a;

        public a(k1.h hVar) {
            this.f15396a = hVar;
        }

        @Override // sq.j
        @os.m
        public Object emit(T t10, @os.l um.d<? super l2> dVar) {
            this.f15396a.element = t10;
            throw new tq.a(this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @r1({"SMAP\nLimit.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1\n+ 2 Reduce.kt\nkotlinx/coroutines/flow/FlowKt__ReduceKt\n*L\n1#1,141:1\n107#2,5:142\n*E\n"})
    public static final class b<T> implements sq.j<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ jn.p f15397a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ k1.h f15398b;

        @r1({"SMAP\nLimit.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1$emit$1\n*L\n1#1,141:1\n*E\n"})
        @xm.f(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$2", f = "Reduce.kt", i = {0, 0}, l = {142}, m = "emit", n = {"this", "it"}, s = {"L$0", "L$1"})
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
                return b.this.emit(null, this);
            }
        }

        public b(jn.p pVar, k1.h hVar) {
            this.f15397a = pVar;
            this.f15398b = hVar;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // sq.j
        @os.m
        public Object emit(T t10, @os.l um.d<? super l2> dVar) {
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
            Object objInvoke = aVar.result;
            wm.a aVar2 = wm.a.COROUTINE_SUSPENDED;
            int i11 = aVar.label;
            if (i11 == 0) {
                d1.n(objInvoke);
                jn.p pVar = this.f15397a;
                aVar.L$0 = this;
                aVar.L$1 = t10;
                aVar.label = 1;
                objInvoke = pVar.invoke(t10, aVar);
                if (objInvoke == aVar2) {
                    return aVar2;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                t10 = (T) aVar.L$1;
                this = (b) aVar.L$0;
                d1.n(objInvoke);
            }
            if (!((Boolean) objInvoke).booleanValue()) {
                return l2.f10208a;
            }
            this.f15398b.element = t10;
            throw new tq.a(this);
        }
    }

    @xm.f(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0, 0}, l = {183}, m = "first", n = {"result", "collector$iv"}, s = {"L$0", "L$1"})
    public static final class c<T> extends xm.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public c(um.d<? super c> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return z.b(null, this);
        }
    }

    @xm.f(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0, 0, 0}, l = {183}, m = "first", n = {"predicate", "result", "collector$iv"}, s = {"L$0", "L$1", "L$2"})
    public static final class d<T> extends xm.d {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public d(um.d<? super d> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return z.a(null, null, this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @r1({"SMAP\nLimit.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1\n+ 2 Reduce.kt\nkotlinx/coroutines/flow/FlowKt__ReduceKt\n*L\n1#1,141:1\n125#2,2:142\n*E\n"})
    public static final class e<T> implements sq.j<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k1.h f15399a;

        public e(k1.h hVar) {
            this.f15399a = hVar;
        }

        @Override // sq.j
        @os.m
        public Object emit(T t10, @os.l um.d<? super l2> dVar) {
            this.f15399a.element = t10;
            throw new tq.a(this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @r1({"SMAP\nLimit.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1\n+ 2 Reduce.kt\nkotlinx/coroutines/flow/FlowKt__ReduceKt\n*L\n1#1,141:1\n138#2,5:142\n*E\n"})
    public static final class f<T> implements sq.j<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ jn.p f15400a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ k1.h f15401b;

        @r1({"SMAP\nLimit.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1$emit$1\n*L\n1#1,141:1\n*E\n"})
        @xm.f(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2", f = "Reduce.kt", i = {0, 0}, l = {142}, m = "emit", n = {"this", "it"}, s = {"L$0", "L$1"})
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
                return f.this.emit(null, this);
            }
        }

        public f(jn.p pVar, k1.h hVar) {
            this.f15400a = pVar;
            this.f15401b = hVar;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // sq.j
        @os.m
        public Object emit(T t10, @os.l um.d<? super l2> dVar) {
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
            Object objInvoke = aVar.result;
            wm.a aVar2 = wm.a.COROUTINE_SUSPENDED;
            int i11 = aVar.label;
            if (i11 == 0) {
                d1.n(objInvoke);
                jn.p pVar = this.f15400a;
                aVar.L$0 = this;
                aVar.L$1 = t10;
                aVar.label = 1;
                objInvoke = pVar.invoke(t10, aVar);
                if (objInvoke == aVar2) {
                    return aVar2;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                t10 = (T) aVar.L$1;
                this = (f) aVar.L$0;
                d1.n(objInvoke);
            }
            if (!((Boolean) objInvoke).booleanValue()) {
                return l2.f10208a;
            }
            this.f15401b.element = t10;
            throw new tq.a(this);
        }
    }

    @xm.f(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0, 0}, l = {183}, m = "firstOrNull", n = {"result", "collector$iv"}, s = {"L$0", "L$1"})
    public static final class g<T> extends xm.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public g(um.d<? super g> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return z.d(null, this);
        }
    }

    @xm.f(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0, 0}, l = {183}, m = "firstOrNull", n = {"result", "collector$iv"}, s = {"L$0", "L$1"})
    public static final class h<T> extends xm.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public h(um.d<? super h> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return z.c(null, null, this);
        }
    }

    @r1({"SMAP\nReduce.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Reduce.kt\nkotlinx/coroutines/flow/FlowKt__ReduceKt$fold$1\n*L\n1#1,172:1\n*E\n"})
    @xm.f(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0}, l = {44}, m = "fold", n = {"accumulator"}, s = {"L$0"})
    public static final class i<T, R> extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public i(um.d<? super i> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return z.e(null, null, null, this);
        }
    }

    @r1({"SMAP\nReduce.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Reduce.kt\nkotlinx/coroutines/flow/FlowKt__ReduceKt$fold$2\n*L\n1#1,172:1\n*E\n"})
    public static final class j<T> implements sq.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k1.h<R> f15402a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ jn.q<R, T, um.d<? super R>, Object> f15403b;

        @r1({"SMAP\nReduce.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Reduce.kt\nkotlinx/coroutines/flow/FlowKt__ReduceKt$fold$2$emit$1\n*L\n1#1,172:1\n*E\n"})
        @xm.f(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$2", f = "Reduce.kt", i = {}, l = {45}, m = "emit", n = {}, s = {})
        public static final class a extends xm.d {
            Object L$0;
            int label;
            /* synthetic */ Object result;
            final /* synthetic */ j<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public a(j<? super T> jVar, um.d<? super a> dVar) {
                super(dVar);
                this.this$0 = jVar;
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
        public j(k1.h<R> hVar, jn.q<? super R, ? super T, ? super um.d<? super R>, ? extends Object> qVar) {
            this.f15402a = hVar;
            this.f15403b = qVar;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @os.m
        public final Object a(T t10, @os.l um.d<? super l2> dVar) {
            new a(this, dVar);
            k1.h<R> hVar = this.f15402a;
            hVar.element = (T) this.f15403b.invoke((R) hVar.element, t10, (um.d<? super R>) dVar);
            return l2.f10208a;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // sq.j
        @os.m
        public final Object emit(T t10, @os.l um.d<? super l2> dVar) {
            a aVar;
            k1.h hVar;
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
                k1.h hVar2 = this.f15402a;
                jn.q<R, T, um.d<? super R>, Object> qVar = this.f15403b;
                T t11 = hVar2.element;
                aVar.L$0 = hVar2;
                aVar.label = 1;
                Object objInvoke = qVar.invoke((R) t11, t10, aVar);
                if (objInvoke == obj2) {
                    return obj2;
                }
                obj = (T) objInvoke;
                hVar = hVar2;
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                hVar = (k1.h) aVar.L$0;
                d1.n(obj);
            }
            hVar.element = (T) obj;
            return l2.f10208a;
        }
    }

    @xm.f(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0}, l = {155}, m = "last", n = {"result"}, s = {"L$0"})
    public static final class k<T> extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public k(um.d<? super k> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return z.g(null, this);
        }
    }

    public static final class l<T> implements sq.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k1.h<Object> f15404a;

        public l(k1.h<Object> hVar) {
            this.f15404a = hVar;
        }

        @Override // sq.j
        @os.m
        public final Object emit(T t10, @os.l um.d<? super l2> dVar) {
            this.f15404a.element = t10;
            return l2.f10208a;
        }
    }

    @xm.f(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0}, l = {167}, m = "lastOrNull", n = {"result"}, s = {"L$0"})
    public static final class m<T> extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public m(um.d<? super m> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return z.h(null, this);
        }
    }

    public static final class n<T> implements sq.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k1.h<T> f15405a;

        public n(k1.h<T> hVar) {
            this.f15405a = hVar;
        }

        @Override // sq.j
        @os.m
        public final Object emit(T t10, @os.l um.d<? super l2> dVar) {
            this.f15405a.element = t10;
            return l2.f10208a;
        }
    }

    @xm.f(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0}, l = {22}, m = "reduce", n = {"accumulator"}, s = {"L$0"})
    public static final class o<S, T extends S> extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public o(um.d<? super o> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return z.i(null, null, this);
        }
    }

    public static final class p<T> implements sq.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k1.h<Object> f15406a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ jn.q<S, T, um.d<? super S>, Object> f15407b;

        @xm.f(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$2", f = "Reduce.kt", i = {}, l = {25}, m = "emit", n = {}, s = {})
        public static final class a extends xm.d {
            Object L$0;
            int label;
            /* synthetic */ Object result;
            final /* synthetic */ p<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public a(p<? super T> pVar, um.d<? super a> dVar) {
                super(dVar);
                this.this$0 = pVar;
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
        public p(k1.h<Object> hVar, jn.q<? super S, ? super T, ? super um.d<? super S>, ? extends Object> qVar) {
            this.f15406a = hVar;
            this.f15407b = qVar;
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
            k1.h<Object> hVar;
            Object obj;
            k1.h<Object> hVar2;
            Object obj2;
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
            Object obj3 = aVar.result;
            Object obj4 = wm.a.COROUTINE_SUSPENDED;
            int i11 = aVar.label;
            if (i11 == 0) {
                d1.n(obj3);
                hVar = this.f15406a;
                Object obj5 = hVar.element;
                if (obj5 != tq.u.f16062a) {
                    jn.q<S, T, um.d<? super S>, Object> qVar = this.f15407b;
                    aVar.L$0 = hVar;
                    aVar.label = 1;
                    Object objInvoke = qVar.invoke((S) obj5, t10, aVar);
                    if (objInvoke == obj4) {
                        obj2 = t10;
                        return obj4;
                    }
                    obj2 = t10;
                    obj = objInvoke;
                    hVar2 = hVar;
                }
                obj2 = t10;
                hVar.element = (T) obj2;
                return l2.f10208a;
            }
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            hVar2 = (k1.h) aVar.L$0;
            d1.n(obj3);
            obj = (T) obj3;
            hVar = hVar2;
            obj2 = obj;
            obj2 = t10;
            hVar.element = (T) obj2;
            return l2.f10208a;
        }
    }

    @xm.f(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0}, l = {57}, m = "single", n = {"result"}, s = {"L$0"})
    public static final class q<T> extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public q(um.d<? super q> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return z.j(null, this);
        }
    }

    @r1({"SMAP\nReduce.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Reduce.kt\nkotlinx/coroutines/flow/FlowKt__ReduceKt$single$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,172:1\n1#2:173\n*E\n"})
    public static final class r<T> implements sq.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k1.h<Object> f15408a;

        public r(k1.h<Object> hVar) {
            this.f15408a = hVar;
        }

        @Override // sq.j
        @os.m
        public final Object emit(T t10, @os.l um.d<? super l2> dVar) {
            k1.h<Object> hVar = this.f15408a;
            if (hVar.element != tq.u.f16062a) {
                throw new IllegalArgumentException("Flow has more than one element");
            }
            hVar.element = t10;
            return l2.f10208a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @r1({"SMAP\nLimit.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1\n+ 2 Reduce.kt\nkotlinx/coroutines/flow/FlowKt__ReduceKt\n*L\n1#1,141:1\n74#2,7:142\n*E\n"})
    public static final class s<T> implements sq.j<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k1.h f15409a;

        public s(k1.h hVar) {
            this.f15409a = hVar;
        }

        @Override // sq.j
        @os.m
        public Object emit(T t10, @os.l um.d<? super l2> dVar) {
            k1.h hVar = this.f15409a;
            T t11 = hVar.element;
            T t12 = (T) tq.u.f16062a;
            if (t11 == t12) {
                hVar.element = t10;
                return l2.f10208a;
            }
            hVar.element = t12;
            throw new tq.a(this);
        }
    }

    @xm.f(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0, 0}, l = {183}, m = "singleOrNull", n = {"result", "collector$iv"}, s = {"L$0", "L$1"})
    public static final class t<T> extends xm.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public t(um.d<? super t> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return z.k(null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @os.m
    public static final <T> Object a(@os.l sq.i<? extends T> iVar, @os.l jn.p<? super T, ? super um.d<? super Boolean>, ? extends Object> pVar, @os.l um.d<? super T> dVar) {
        d dVar2;
        jn.p<? super T, ? super um.d<? super Boolean>, ? extends Object> pVar2;
        k1.h hVar;
        tq.a e10;
        sq.j<? super Object> jVar;
        if (dVar instanceof d) {
            dVar2 = (d) dVar;
            int i10 = dVar2.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                dVar2.label = i10 - Integer.MIN_VALUE;
            } else {
                dVar2 = new d(dVar);
            }
        } else {
            dVar2 = new d(dVar);
        }
        Object obj = dVar2.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = dVar2.label;
        if (i11 == 0) {
            d1.n(obj);
            k1.h hVar2 = new k1.h();
            hVar2.element = (T) tq.u.f16062a;
            sq.j<? super Object> bVar = new b<>(pVar, hVar2);
            try {
                dVar2.L$0 = pVar;
                dVar2.L$1 = hVar2;
                dVar2.L$2 = bVar;
                dVar2.label = 1;
                if (iVar.a(bVar, dVar2) == aVar) {
                    return aVar;
                }
                pVar2 = pVar;
                hVar = hVar2;
            } catch (tq.a e11) {
                pVar2 = pVar;
                hVar = hVar2;
                e10 = e11;
                jVar = bVar;
                tq.q.b(e10, jVar);
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            jVar = (b) dVar2.L$2;
            hVar = (k1.h) dVar2.L$1;
            pVar2 = (jn.p) dVar2.L$0;
            try {
                d1.n(obj);
            } catch (tq.a e12) {
                e10 = e12;
                tq.q.b(e10, jVar);
            }
        }
        T t10 = hVar.element;
        if (t10 != tq.u.f16062a) {
            return t10;
        }
        throw new NoSuchElementException("Expected at least one element matching the predicate " + pVar2);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @os.m
    public static final <T> Object b(@os.l sq.i<? extends T> iVar, @os.l um.d<? super T> dVar) {
        c cVar;
        k1.h hVar;
        tq.a e10;
        sq.j<? super Object> jVar;
        if (dVar instanceof c) {
            cVar = (c) dVar;
            int i10 = cVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                cVar.label = i10 - Integer.MIN_VALUE;
            } else {
                cVar = new c(dVar);
            }
        } else {
            cVar = new c(dVar);
        }
        Object obj = cVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = cVar.label;
        if (i11 == 0) {
            d1.n(obj);
            k1.h hVar2 = new k1.h();
            hVar2.element = (T) tq.u.f16062a;
            sq.j<? super Object> aVar2 = new a<>(hVar2);
            try {
                cVar.L$0 = hVar2;
                cVar.L$1 = aVar2;
                cVar.label = 1;
                if (iVar.a(aVar2, cVar) == aVar) {
                    return aVar;
                }
                hVar = hVar2;
            } catch (tq.a e11) {
                hVar = hVar2;
                e10 = e11;
                jVar = aVar2;
                tq.q.b(e10, jVar);
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            jVar = (a) cVar.L$1;
            hVar = (k1.h) cVar.L$0;
            try {
                d1.n(obj);
            } catch (tq.a e12) {
                e10 = e12;
                tq.q.b(e10, jVar);
            }
        }
        T t10 = hVar.element;
        if (t10 != tq.u.f16062a) {
            return t10;
        }
        throw new NoSuchElementException("Expected at least one element");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @os.m
    public static final <T> Object c(@os.l sq.i<? extends T> iVar, @os.l jn.p<? super T, ? super um.d<? super Boolean>, ? extends Object> pVar, @os.l um.d<? super T> dVar) {
        h hVar;
        k1.h hVar2;
        tq.a e10;
        sq.j<? super Object> jVar;
        if (dVar instanceof h) {
            hVar = (h) dVar;
            int i10 = hVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                hVar.label = i10 - Integer.MIN_VALUE;
            } else {
                hVar = new h(dVar);
            }
        } else {
            hVar = new h(dVar);
        }
        Object obj = hVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = hVar.label;
        if (i11 == 0) {
            d1.n(obj);
            k1.h hVar3 = new k1.h();
            sq.j<? super Object> fVar = new f<>(pVar, hVar3);
            try {
                hVar.L$0 = hVar3;
                hVar.L$1 = fVar;
                hVar.label = 1;
                if (iVar.a(fVar, hVar) == aVar) {
                    return aVar;
                }
                hVar2 = hVar3;
            } catch (tq.a e11) {
                hVar2 = hVar3;
                e10 = e11;
                jVar = fVar;
                tq.q.b(e10, jVar);
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            jVar = (f) hVar.L$1;
            hVar2 = (k1.h) hVar.L$0;
            try {
                d1.n(obj);
            } catch (tq.a e12) {
                e10 = e12;
                tq.q.b(e10, jVar);
            }
        }
        return hVar2.element;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @os.m
    public static final <T> Object d(@os.l sq.i<? extends T> iVar, @os.l um.d<? super T> dVar) {
        g gVar;
        k1.h hVar;
        tq.a e10;
        sq.j<? super Object> jVar;
        if (dVar instanceof g) {
            gVar = (g) dVar;
            int i10 = gVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                gVar.label = i10 - Integer.MIN_VALUE;
            } else {
                gVar = new g(dVar);
            }
        } else {
            gVar = new g(dVar);
        }
        Object obj = gVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = gVar.label;
        if (i11 == 0) {
            d1.n(obj);
            k1.h hVar2 = new k1.h();
            sq.j<? super Object> eVar = new e<>(hVar2);
            try {
                gVar.L$0 = hVar2;
                gVar.L$1 = eVar;
                gVar.label = 1;
                if (iVar.a(eVar, gVar) == aVar) {
                    return aVar;
                }
                hVar = hVar2;
            } catch (tq.a e11) {
                hVar = hVar2;
                e10 = e11;
                jVar = eVar;
                tq.q.b(e10, jVar);
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            jVar = (e) gVar.L$1;
            hVar = (k1.h) gVar.L$0;
            try {
                d1.n(obj);
            } catch (tq.a e12) {
                e10 = e12;
                tq.q.b(e10, jVar);
            }
        }
        return hVar.element;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    @os.m
    public static final <T, R> Object e(@os.l sq.i<? extends T> iVar, R r10, @os.l jn.q<? super R, ? super T, ? super um.d<? super R>, ? extends Object> qVar, @os.l um.d<? super R> dVar) {
        i iVar2;
        k1.h hVar;
        if (dVar instanceof i) {
            iVar2 = (i) dVar;
            int i10 = iVar2.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                iVar2.label = i10 - Integer.MIN_VALUE;
            } else {
                iVar2 = new i(dVar);
            }
        } else {
            iVar2 = new i(dVar);
        }
        Object obj = iVar2.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = iVar2.label;
        if (i11 == 0) {
            d1.n(obj);
            k1.h hVar2 = new k1.h();
            hVar2.element = r10;
            sq.j<? super Object> jVar = new j<>(hVar2, qVar);
            iVar2.L$0 = hVar2;
            iVar2.label = 1;
            if (iVar.a(jVar, iVar2) == aVar) {
                return aVar;
            }
            hVar = hVar2;
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            hVar = (k1.h) iVar2.L$0;
            d1.n(obj);
        }
        return hVar.element;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, R> Object f(sq.i<? extends T> iVar, R r10, jn.q<? super R, ? super T, ? super um.d<? super R>, ? extends Object> qVar, um.d<? super R> dVar) {
        k1.h hVar = new k1.h();
        hVar.element = r10;
        iVar.a(new j(hVar, qVar), dVar);
        return hVar.element;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @os.m
    public static final <T> Object g(@os.l sq.i<? extends T> iVar, @os.l um.d<? super T> dVar) {
        k kVar;
        k1.h hVar;
        if (dVar instanceof k) {
            kVar = (k) dVar;
            int i10 = kVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                kVar.label = i10 - Integer.MIN_VALUE;
            } else {
                kVar = new k(dVar);
            }
        } else {
            kVar = new k(dVar);
        }
        Object obj = kVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = kVar.label;
        if (i11 == 0) {
            d1.n(obj);
            k1.h hVar2 = new k1.h();
            hVar2.element = (T) tq.u.f16062a;
            sq.j<? super Object> lVar = new l<>(hVar2);
            kVar.L$0 = hVar2;
            kVar.label = 1;
            if (iVar.a(lVar, kVar) == aVar) {
                return aVar;
            }
            hVar = hVar2;
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            hVar = (k1.h) kVar.L$0;
            d1.n(obj);
        }
        T t10 = hVar.element;
        if (t10 != tq.u.f16062a) {
            return t10;
        }
        throw new NoSuchElementException("Expected at least one element");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @os.m
    public static final <T> Object h(@os.l sq.i<? extends T> iVar, @os.l um.d<? super T> dVar) {
        m mVar;
        k1.h hVar;
        if (dVar instanceof m) {
            mVar = (m) dVar;
            int i10 = mVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                mVar.label = i10 - Integer.MIN_VALUE;
            } else {
                mVar = new m(dVar);
            }
        } else {
            mVar = new m(dVar);
        }
        Object obj = mVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = mVar.label;
        if (i11 == 0) {
            d1.n(obj);
            k1.h hVar2 = new k1.h();
            sq.j<? super Object> nVar = new n<>(hVar2);
            mVar.L$0 = hVar2;
            mVar.label = 1;
            if (iVar.a(nVar, mVar) == aVar) {
                return aVar;
            }
            hVar = hVar2;
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            hVar = (k1.h) mVar.L$0;
            d1.n(obj);
        }
        return hVar.element;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, vq.u0] */
    @os.m
    public static final <S, T extends S> Object i(@os.l sq.i<? extends T> iVar, @os.l jn.q<? super S, ? super T, ? super um.d<? super S>, ? extends Object> qVar, @os.l um.d<? super S> dVar) {
        o oVar;
        k1.h hVar;
        if (dVar instanceof o) {
            oVar = (o) dVar;
            int i10 = oVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                oVar.label = i10 - Integer.MIN_VALUE;
            } else {
                oVar = new o(dVar);
            }
        } else {
            oVar = new o(dVar);
        }
        Object obj = oVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = oVar.label;
        if (i11 == 0) {
            d1.n(obj);
            k1.h hVar2 = new k1.h();
            hVar2.element = tq.u.f16062a;
            sq.j<? super Object> pVar = new p<>(hVar2, qVar);
            oVar.L$0 = hVar2;
            oVar.label = 1;
            if (iVar.a(pVar, oVar) == aVar) {
                return aVar;
            }
            hVar = hVar2;
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            hVar = (k1.h) oVar.L$0;
            d1.n(obj);
        }
        T t10 = hVar.element;
        if (t10 != tq.u.f16062a) {
            return t10;
        }
        throw new NoSuchElementException("Empty flow can't be reduced");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @os.m
    public static final <T> Object j(@os.l sq.i<? extends T> iVar, @os.l um.d<? super T> dVar) {
        q qVar;
        k1.h hVar;
        if (dVar instanceof q) {
            qVar = (q) dVar;
            int i10 = qVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                qVar.label = i10 - Integer.MIN_VALUE;
            } else {
                qVar = new q(dVar);
            }
        } else {
            qVar = new q(dVar);
        }
        Object obj = qVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = qVar.label;
        if (i11 == 0) {
            d1.n(obj);
            k1.h hVar2 = new k1.h();
            hVar2.element = (T) tq.u.f16062a;
            sq.j<? super Object> rVar = new r<>(hVar2);
            qVar.L$0 = hVar2;
            qVar.label = 1;
            if (iVar.a(rVar, qVar) == aVar) {
                return aVar;
            }
            hVar = hVar2;
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            hVar = (k1.h) qVar.L$0;
            d1.n(obj);
        }
        T t10 = hVar.element;
        if (t10 != tq.u.f16062a) {
            return t10;
        }
        throw new NoSuchElementException("Flow is empty");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @os.m
    public static final <T> Object k(@os.l sq.i<? extends T> iVar, @os.l um.d<? super T> dVar) {
        t tVar;
        k1.h hVar;
        tq.a e10;
        sq.j<? super Object> jVar;
        if (dVar instanceof t) {
            tVar = (t) dVar;
            int i10 = tVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                tVar.label = i10 - Integer.MIN_VALUE;
            } else {
                tVar = new t(dVar);
            }
        } else {
            tVar = new t(dVar);
        }
        Object obj = tVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = tVar.label;
        if (i11 == 0) {
            d1.n(obj);
            k1.h hVar2 = new k1.h();
            hVar2.element = (T) tq.u.f16062a;
            sq.j<? super Object> sVar = new s<>(hVar2);
            try {
                tVar.L$0 = hVar2;
                tVar.L$1 = sVar;
                tVar.label = 1;
                if (iVar.a(sVar, tVar) == aVar) {
                    return aVar;
                }
                hVar = hVar2;
            } catch (tq.a e11) {
                hVar = hVar2;
                e10 = e11;
                jVar = sVar;
                tq.q.b(e10, jVar);
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            jVar = (s) tVar.L$1;
            hVar = (k1.h) tVar.L$0;
            try {
                d1.n(obj);
            } catch (tq.a e12) {
                e10 = e12;
                tq.q.b(e10, jVar);
            }
        }
        T t10 = hVar.element;
        if (t10 == tq.u.f16062a) {
            return null;
        }
        return t10;
    }
}
