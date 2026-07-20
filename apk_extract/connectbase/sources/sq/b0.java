package sq;

import kn.k1;
import kn.r1;
import lm.d1;
import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nTransform.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 2 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 3 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,136:1\n21#1:143\n23#1:147\n21#1:148\n23#1:152\n50#2:137\n55#2:139\n50#2:140\n55#2:142\n50#2:144\n55#2:146\n50#2:149\n55#2:151\n50#2:153\n55#2:155\n50#2:156\n55#2:158\n50#2:159\n55#2:161\n50#2:163\n55#2:165\n107#3:138\n107#3:141\n107#3:145\n107#3:150\n107#3:154\n107#3:157\n107#3:160\n107#3:162\n107#3:164\n107#3:166\n107#3:167\n*S KotlinDebug\n*F\n+ 1 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n36#1:143\n36#1:147\n41#1:148\n41#1:152\n21#1:137\n21#1:139\n28#1:140\n28#1:142\n36#1:144\n36#1:146\n41#1:149\n41#1:151\n46#1:153\n46#1:155\n53#1:156\n53#1:158\n60#1:159\n60#1:161\n78#1:163\n78#1:165\n21#1:138\n28#1:141\n36#1:145\n41#1:150\n46#1:154\n53#1:157\n60#1:160\n68#1:162\n78#1:164\n105#1:166\n125#1:167\n*E\n"})
public final /* synthetic */ class b0 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n*L\n1#1,113:1\n51#2,5:114\n*E\n"})
    public static final class a<T> implements sq.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ sq.i f15207a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ jn.p f15208b;

        /* JADX INFO: renamed from: sq.b0$a$a, reason: collision with other inner class name */
        @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1$collect$1\n*L\n1#1,113:1\n*E\n"})
        public static final class C0378a extends xm.d {
            int label;
            /* synthetic */ Object result;

            public C0378a(um.d dVar) {
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

        @r1({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,222:1\n22#2,2:223\n*E\n"})
        public static final class b<T> implements sq.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ sq.j f15209a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ jn.p f15210b;

            /* JADX INFO: renamed from: sq.b0$a$b$a, reason: collision with other inner class name */
            @r1({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
            @xm.f(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2", f = "Transform.kt", i = {0, 0}, l = {223, 223}, m = "emit", n = {"value", "$this$filter_u24lambda_u240"}, s = {"L$0", "L$1"})
            public static final class C0379a extends xm.d {
                Object L$0;
                Object L$1;
                int label;
                /* synthetic */ Object result;

                public C0379a(um.d dVar) {
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

            public b(sq.j jVar, jn.p pVar) {
                this.f15209a = jVar;
                this.f15210b = pVar;
            }

            @os.m
            public final Object a(Object obj, @os.l um.d dVar) {
                new C0379a(dVar);
                sq.j jVar = this.f15209a;
                if (((Boolean) this.f15210b.invoke(obj, dVar)).booleanValue()) {
                    jVar.emit(obj, dVar);
                }
                return l2.f10208a;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            @Override // sq.j
            @os.m
            public final Object emit(T t10, @os.l um.d<? super l2> dVar) {
                C0379a c0379a;
                sq.j jVar;
                if (dVar instanceof C0379a) {
                    c0379a = (C0379a) dVar;
                    int i10 = c0379a.label;
                    if ((i10 & Integer.MIN_VALUE) != 0) {
                        c0379a.label = i10 - Integer.MIN_VALUE;
                    } else {
                        c0379a = new C0379a(dVar);
                    }
                } else {
                    c0379a = new C0379a(dVar);
                }
                Object obj = c0379a.result;
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i11 = c0379a.label;
                if (i11 != 0) {
                    if (i11 == 1) {
                        jVar = (sq.j) c0379a.L$1;
                        t10 = (T) c0379a.L$0;
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
                sq.j jVar2 = this.f15209a;
                jn.p pVar = this.f15210b;
                c0379a.L$0 = t10;
                c0379a.L$1 = jVar2;
                c0379a.label = 1;
                Object objInvoke = pVar.invoke(t10, c0379a);
                if (objInvoke == aVar) {
                    return aVar;
                }
                obj = objInvoke;
                jVar = jVar2;
                if (((Boolean) obj).booleanValue()) {
                    c0379a.L$0 = null;
                    c0379a.L$1 = null;
                    c0379a.label = 2;
                    if (jVar.emit(t10, c0379a) == aVar) {
                        return aVar;
                    }
                }
                return l2.f10208a;
            }
        }

        public a(sq.i iVar, jn.p pVar) {
            this.f15207a = iVar;
            this.f15208b = pVar;
        }

        @Override // sq.i
        @os.m
        public Object a(@os.l sq.j jVar, @os.l um.d dVar) {
            Object objA = this.f15207a.a(new b(jVar, this.f15208b), dVar);
            return objA == wm.a.COROUTINE_SUSPENDED ? objA : l2.f10208a;
        }

        @os.m
        public Object g(@os.l sq.j jVar, @os.l um.d dVar) {
            new C0378a(dVar);
            this.f15207a.a(new b(jVar, this.f15208b), dVar);
            return l2.f10208a;
        }
    }

    @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n*L\n1#1,113:1\n51#2,5:114\n*E\n"})
    public static final class b implements sq.i<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ sq.i f15211a;

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
                return b.this.a(null, this);
            }
        }

        /* JADX INFO: renamed from: sq.b0$b$b, reason: collision with other inner class name */
        @r1({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,222:1\n22#2:223\n36#2:224\n23#2:225\n*E\n"})
        public static final class C0380b<T> implements sq.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ sq.j f15212a;

            /* JADX INFO: renamed from: sq.b0$b$b$a */
            @r1({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
            @xm.f(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2", f = "Transform.kt", i = {}, l = {223}, m = "emit", n = {}, s = {})
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
                    return C0380b.this.emit(null, this);
                }
            }

            public C0380b(sq.j jVar) {
                this.f15212a = jVar;
            }

            @os.m
            public final Object a(Object obj, @os.l um.d dVar) {
                new a(dVar);
                sq.j jVar = this.f15212a;
                kn.l0.P();
                if (obj != null) {
                    jVar.emit(obj, dVar);
                }
                return l2.f10208a;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            @Override // sq.j
            @os.m
            public final Object emit(Object obj, @os.l um.d dVar) {
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
                Object obj2 = aVar.result;
                wm.a aVar2 = wm.a.COROUTINE_SUSPENDED;
                int i11 = aVar.label;
                if (i11 == 0) {
                    d1.n(obj2);
                    sq.j jVar = this.f15212a;
                    kn.l0.P();
                    if (obj != null) {
                        aVar.label = 1;
                        if (jVar.emit(obj, aVar) == aVar2) {
                            return aVar2;
                        }
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

        public b(sq.i iVar) {
            this.f15211a = iVar;
        }

        @Override // sq.i
        @os.m
        public Object a(@os.l sq.j<? super Object> jVar, @os.l um.d dVar) {
            sq.i iVar = this.f15211a;
            kn.l0.P();
            Object objA = iVar.a(new C0380b(jVar), dVar);
            return objA == wm.a.COROUTINE_SUSPENDED ? objA : l2.f10208a;
        }

        @os.m
        public Object g(@os.l sq.j jVar, @os.l um.d dVar) {
            new a(dVar);
            sq.i iVar = this.f15211a;
            kn.l0.P();
            iVar.a(new C0380b(jVar), dVar);
            return l2.f10208a;
        }
    }

    @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n*L\n1#1,113:1\n51#2,5:114\n*E\n"})
    public static final class c implements sq.i<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ sq.i f15213a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ un.d f15214b;

        @r1({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,222:1\n22#2:223\n41#2:224\n23#2:225\n*E\n"})
        public static final class a<T> implements sq.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ sq.j f15215a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ un.d f15216b;

            /* JADX INFO: renamed from: sq.b0$c$a$a, reason: collision with other inner class name */
            @r1({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
            @xm.f(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$2$2", f = "Transform.kt", i = {}, l = {223}, m = "emit", n = {}, s = {})
            public static final class C0381a extends xm.d {
                Object L$0;
                Object L$1;
                int label;
                /* synthetic */ Object result;

                public C0381a(um.d dVar) {
                    super(dVar);
                }

                @Override // xm.a
                @os.m
                public final Object invokeSuspend(@os.l Object obj) {
                    this.result = obj;
                    this.label |= Integer.MIN_VALUE;
                    return a.this.emit(null, this);
                }
            }

            public a(sq.j jVar, un.d dVar) {
                this.f15215a = jVar;
                this.f15216b = dVar;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            @Override // sq.j
            @os.m
            public final Object emit(Object obj, @os.l um.d dVar) {
                C0381a c0381a;
                if (dVar instanceof C0381a) {
                    c0381a = (C0381a) dVar;
                    int i10 = c0381a.label;
                    if ((i10 & Integer.MIN_VALUE) != 0) {
                        c0381a.label = i10 - Integer.MIN_VALUE;
                    } else {
                        c0381a = new C0381a(dVar);
                    }
                } else {
                    c0381a = new C0381a(dVar);
                }
                Object obj2 = c0381a.result;
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i11 = c0381a.label;
                if (i11 == 0) {
                    d1.n(obj2);
                    sq.j jVar = this.f15215a;
                    if (this.f15216b.r(obj)) {
                        c0381a.label = 1;
                        if (jVar.emit(obj, c0381a) == aVar) {
                            return aVar;
                        }
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

        public c(sq.i iVar, un.d dVar) {
            this.f15213a = iVar;
            this.f15214b = dVar;
        }

        @Override // sq.i
        @os.m
        public Object a(@os.l sq.j<? super Object> jVar, @os.l um.d dVar) {
            Object objA = this.f15213a.a(new a(jVar, this.f15214b), dVar);
            return objA == wm.a.COROUTINE_SUSPENDED ? objA : l2.f10208a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n*L\n1#1,113:1\n51#2,5:114\n*E\n"})
    public static final class d<T> implements sq.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ sq.i f15217a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ jn.p f15218b;

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
                return d.this.a(null, this);
            }
        }

        @r1({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,222:1\n29#2,2:223\n*E\n"})
        public static final class b<T> implements sq.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ sq.j f15219a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ jn.p f15220b;

            @r1({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
            @xm.f(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$filterNot$$inlined$unsafeTransform$1$2", f = "Transform.kt", i = {0, 0}, l = {223, 223}, m = "emit", n = {"value", "$this$filterNot_u24lambda_u241"}, s = {"L$0", "L$1"})
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

            public b(sq.j jVar, jn.p pVar) {
                this.f15219a = jVar;
                this.f15220b = pVar;
            }

            @os.m
            public final Object a(Object obj, @os.l um.d dVar) {
                new a(dVar);
                sq.j jVar = this.f15219a;
                if (!((Boolean) this.f15220b.invoke(obj, dVar)).booleanValue()) {
                    jVar.emit(obj, dVar);
                }
                return l2.f10208a;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            @Override // sq.j
            @os.m
            public final Object emit(T t10, @os.l um.d<? super l2> dVar) {
                a aVar;
                sq.j jVar;
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
                if (i11 != 0) {
                    if (i11 == 1) {
                        jVar = (sq.j) aVar.L$1;
                        t10 = (T) aVar.L$0;
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
                sq.j jVar2 = this.f15219a;
                jn.p pVar = this.f15220b;
                aVar.L$0 = t10;
                aVar.L$1 = jVar2;
                aVar.label = 1;
                Object objInvoke = pVar.invoke(t10, aVar);
                if (objInvoke == aVar2) {
                    return aVar2;
                }
                obj = objInvoke;
                jVar = jVar2;
                if (!((Boolean) obj).booleanValue()) {
                    aVar.L$0 = null;
                    aVar.L$1 = null;
                    aVar.label = 2;
                    if (jVar.emit(t10, aVar) == aVar2) {
                        return aVar2;
                    }
                }
                return l2.f10208a;
            }
        }

        public d(sq.i iVar, jn.p pVar) {
            this.f15217a = iVar;
            this.f15218b = pVar;
        }

        @Override // sq.i
        @os.m
        public Object a(@os.l sq.j jVar, @os.l um.d dVar) {
            Object objA = this.f15217a.a(new b(jVar, this.f15218b), dVar);
            return objA == wm.a.COROUTINE_SUSPENDED ? objA : l2.f10208a;
        }

        @os.m
        public Object g(@os.l sq.j jVar, @os.l um.d dVar) {
            new a(dVar);
            this.f15217a.a(new b(jVar, this.f15218b), dVar);
            return l2.f10208a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n*L\n1#1,113:1\n51#2,5:114\n*E\n"})
    public static final class e<T> implements sq.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ sq.i f15221a;

        @r1({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,222:1\n47#2,2:223\n*E\n"})
        public static final class a<T> implements sq.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ sq.j f15222a;

            /* JADX INFO: renamed from: sq.b0$e$a$a, reason: collision with other inner class name */
            @r1({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
            @xm.f(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2", f = "Transform.kt", i = {}, l = {223}, m = "emit", n = {}, s = {})
            public static final class C0382a extends xm.d {
                int label;
                /* synthetic */ Object result;

                public C0382a(um.d dVar) {
                    super(dVar);
                }

                @Override // xm.a
                @os.m
                public final Object invokeSuspend(@os.l Object obj) {
                    this.result = obj;
                    this.label |= Integer.MIN_VALUE;
                    return a.this.emit(null, this);
                }
            }

            public a(sq.j jVar) {
                this.f15222a = jVar;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            @Override // sq.j
            @os.m
            public final Object emit(T t10, @os.l um.d<? super l2> dVar) {
                C0382a c0382a;
                if (dVar instanceof C0382a) {
                    c0382a = (C0382a) dVar;
                    int i10 = c0382a.label;
                    if ((i10 & Integer.MIN_VALUE) != 0) {
                        c0382a.label = i10 - Integer.MIN_VALUE;
                    } else {
                        c0382a = new C0382a(dVar);
                    }
                } else {
                    c0382a = new C0382a(dVar);
                }
                Object obj = c0382a.result;
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i11 = c0382a.label;
                if (i11 == 0) {
                    d1.n(obj);
                    sq.j jVar = this.f15222a;
                    if (t10 != null) {
                        c0382a.label = 1;
                        if (jVar.emit(t10, c0382a) == aVar) {
                            return aVar;
                        }
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

        public e(sq.i iVar) {
            this.f15221a = iVar;
        }

        @Override // sq.i
        @os.m
        public Object a(@os.l sq.j jVar, @os.l um.d dVar) {
            Object objA = this.f15221a.a(new a(jVar), dVar);
            return objA == wm.a.COROUTINE_SUSPENDED ? objA : l2.f10208a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n*L\n1#1,113:1\n51#2,5:114\n*E\n"})
    public static final class f<R> implements sq.i<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ sq.i f15223a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ jn.p f15224b;

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
                return f.this.a(null, this);
            }
        }

        @r1({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,222:1\n54#2:223\n*E\n"})
        public static final class b<T> implements sq.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ sq.j f15225a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ jn.p f15226b;

            @r1({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
            @xm.f(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2", f = "Transform.kt", i = {}, l = {223, 223}, m = "emit", n = {}, s = {})
            public static final class a extends xm.d {
                Object L$0;
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

            public b(sq.j jVar, jn.p pVar) {
                this.f15225a = jVar;
                this.f15226b = pVar;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @os.m
            public final Object a(Object obj, @os.l um.d dVar) {
                new a(dVar);
                this.f15225a.emit(this.f15226b.invoke(obj, dVar), dVar);
                return l2.f10208a;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            @Override // sq.j
            @os.m
            public final Object emit(T t10, @os.l um.d<? super l2> dVar) {
                a aVar;
                sq.j jVar;
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
                Object obj2 = wm.a.COROUTINE_SUSPENDED;
                int i11 = aVar.label;
                if (i11 != 0) {
                    if (i11 == 1) {
                        sq.j jVar2 = (sq.j) aVar.L$0;
                        d1.n(obj);
                        jVar = jVar2;
                    } else {
                        if (i11 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        d1.n(obj);
                    }
                    return l2.f10208a;
                }
                d1.n(obj);
                sq.j jVar3 = this.f15225a;
                jn.p pVar = this.f15226b;
                aVar.L$0 = jVar3;
                aVar.label = 1;
                Object objInvoke = pVar.invoke(t10, aVar);
                if (objInvoke == obj2) {
                    return obj2;
                }
                obj = objInvoke;
                jVar = jVar3;
                aVar.L$0 = null;
                aVar.label = 2;
                if (jVar.emit(obj, aVar) == obj2) {
                    return obj2;
                }
                return l2.f10208a;
            }
        }

        public f(sq.i iVar, jn.p pVar) {
            this.f15223a = iVar;
            this.f15224b = pVar;
        }

        @Override // sq.i
        @os.m
        public Object a(@os.l sq.j jVar, @os.l um.d dVar) {
            Object objA = this.f15223a.a(new b(jVar, this.f15224b), dVar);
            return objA == wm.a.COROUTINE_SUSPENDED ? objA : l2.f10208a;
        }

        @os.m
        public Object g(@os.l sq.j jVar, @os.l um.d dVar) {
            new a(dVar);
            this.f15223a.a(new b(jVar, this.f15224b), dVar);
            return l2.f10208a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n*L\n1#1,113:1\n51#2,5:114\n*E\n"})
    public static final class g<R> implements sq.i<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ sq.i f15227a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ jn.p f15228b;

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

        @r1({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,222:1\n61#2,2:223\n*E\n"})
        public static final class b<T> implements sq.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ sq.j f15229a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ jn.p f15230b;

            @r1({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
            @xm.f(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2", f = "Transform.kt", i = {0}, l = {223, 224}, m = "emit", n = {"$this$mapNotNull_u24lambda_u246"}, s = {"L$0"})
            public static final class a extends xm.d {
                Object L$0;
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

            public b(sq.j jVar, jn.p pVar) {
                this.f15229a = jVar;
                this.f15230b = pVar;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @os.m
            public final Object a(Object obj, @os.l um.d dVar) {
                new a(dVar);
                sq.j jVar = this.f15229a;
                Object objInvoke = this.f15230b.invoke(obj, dVar);
                if (objInvoke != null) {
                    jVar.emit(objInvoke, dVar);
                }
                return l2.f10208a;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            @Override // sq.j
            @os.m
            public final Object emit(T t10, @os.l um.d<? super l2> dVar) {
                a aVar;
                sq.j jVar;
                sq.j jVar2;
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
                Object obj2 = wm.a.COROUTINE_SUSPENDED;
                int i11 = aVar.label;
                if (i11 != 0) {
                    if (i11 == 1) {
                        jVar2 = (sq.j) aVar.L$0;
                        d1.n(obj);
                    } else {
                        if (i11 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        d1.n(obj);
                    }
                    jVar = jVar2;
                    jVar = jVar2;
                    return l2.f10208a;
                }
                d1.n(obj);
                sq.j jVar3 = this.f15229a;
                jn.p pVar = this.f15230b;
                aVar.L$0 = jVar3;
                aVar.label = 1;
                Object objInvoke = pVar.invoke(t10, aVar);
                if (objInvoke == obj2) {
                    return obj2;
                }
                obj = objInvoke;
                jVar = jVar3;
                if (obj != null) {
                    aVar.L$0 = null;
                    aVar.label = 2;
                    if (jVar.emit(obj, aVar) == obj2) {
                        jVar = jVar2;
                        return obj2;
                    }
                }
                jVar = jVar2;
                jVar = jVar2;
                return l2.f10208a;
            }
        }

        public g(sq.i iVar, jn.p pVar) {
            this.f15227a = iVar;
            this.f15228b = pVar;
        }

        @Override // sq.i
        @os.m
        public Object a(@os.l sq.j jVar, @os.l um.d dVar) {
            Object objA = this.f15227a.a(new b(jVar, this.f15228b), dVar);
            return objA == wm.a.COROUTINE_SUSPENDED ? objA : l2.f10208a;
        }

        @os.m
        public Object g(@os.l sq.j jVar, @os.l um.d dVar) {
            new a(dVar);
            this.f15227a.a(new b(jVar, this.f15228b), dVar);
            return l2.f10208a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n*L\n1#1,113:1\n51#2,5:114\n*E\n"})
    public static final class h<T> implements sq.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ sq.i f15231a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ jn.p f15232b;

        @r1({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,222:1\n79#2,2:223\n*E\n"})
        public static final class a<T> implements sq.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ sq.j f15233a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ jn.p f15234b;

            /* JADX INFO: renamed from: sq.b0$h$a$a, reason: collision with other inner class name */
            @r1({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
            @xm.f(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2", f = "Transform.kt", i = {0, 0}, l = {223, 224}, m = "emit", n = {"value", "$this$onEach_u24lambda_u248"}, s = {"L$0", "L$1"})
            public static final class C0383a extends xm.d {
                Object L$0;
                Object L$1;
                int label;
                /* synthetic */ Object result;

                public C0383a(um.d dVar) {
                    super(dVar);
                }

                @Override // xm.a
                @os.m
                public final Object invokeSuspend(@os.l Object obj) {
                    this.result = obj;
                    this.label |= Integer.MIN_VALUE;
                    return a.this.emit(null, this);
                }
            }

            public a(sq.j jVar, jn.p pVar) {
                this.f15233a = jVar;
                this.f15234b = pVar;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            @Override // sq.j
            @os.m
            public final Object emit(T t10, @os.l um.d<? super l2> dVar) {
                C0383a c0383a;
                sq.j jVar;
                if (dVar instanceof C0383a) {
                    c0383a = (C0383a) dVar;
                    int i10 = c0383a.label;
                    if ((i10 & Integer.MIN_VALUE) != 0) {
                        c0383a.label = i10 - Integer.MIN_VALUE;
                    } else {
                        c0383a = new C0383a(dVar);
                    }
                } else {
                    c0383a = new C0383a(dVar);
                }
                Object obj = c0383a.result;
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i11 = c0383a.label;
                if (i11 != 0) {
                    if (i11 == 1) {
                        jVar = (sq.j) c0383a.L$1;
                        t10 = (T) c0383a.L$0;
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
                sq.j jVar2 = this.f15233a;
                jn.p pVar = this.f15234b;
                c0383a.L$0 = t10;
                c0383a.L$1 = jVar2;
                c0383a.label = 1;
                if (pVar.invoke(t10, c0383a) == aVar) {
                    return aVar;
                }
                jVar = jVar2;
                c0383a.L$0 = null;
                c0383a.L$1 = null;
                c0383a.label = 2;
                if (jVar.emit(t10, c0383a) == aVar) {
                    return aVar;
                }
                return l2.f10208a;
            }
        }

        public h(sq.i iVar, jn.p pVar) {
            this.f15231a = iVar;
            this.f15232b = pVar;
        }

        @Override // sq.i
        @os.m
        public Object a(@os.l sq.j jVar, @os.l um.d dVar) {
            Object objA = this.f15231a.a(new a(jVar, this.f15232b), dVar);
            return objA == wm.a.COROUTINE_SUSPENDED ? objA : l2.f10208a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,113:1\n106#2,7:114\n*E\n"})
    public static final class i<R> implements sq.i<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f15235a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ sq.i f15236b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ jn.q f15237c;

        @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1$collect$1\n*L\n1#1,113:1\n*E\n"})
        @xm.f(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1", f = "Transform.kt", i = {0, 0, 0}, l = {y5.a.f20722h0, y5.a.f20724i0}, m = "collect", n = {"this", "$this$runningFold_u24lambda_u249", "accumulator"}, s = {"L$0", "L$1", "L$2"})
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
                return i.this.a(null, this);
            }
        }

        public i(Object obj, sq.i iVar, jn.q qVar) {
            this.f15235a = obj;
            this.f15236b = iVar;
            this.f15237c = qVar;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Object] */
        @Override // sq.i
        @os.m
        public Object a(@os.l sq.j<? super R> jVar, @os.l um.d<? super l2> dVar) {
            a aVar;
            k1.h hVar;
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
            if (i11 != 0) {
                if (i11 == 1) {
                    k1.h hVar2 = (k1.h) aVar.L$2;
                    jVar = (sq.j) aVar.L$1;
                    i<R> iVar = (i) aVar.L$0;
                    d1.n(obj);
                    hVar = hVar2;
                    this = iVar;
                } else {
                    if (i11 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    d1.n(obj);
                }
                return l2.f10208a;
            }
            d1.n(obj);
            hVar = new k1.h();
            ?? r10 = (Object) this.f15235a;
            hVar.element = r10;
            aVar.L$0 = this;
            aVar.L$1 = jVar;
            aVar.L$2 = hVar;
            aVar.label = 1;
            if (jVar.emit(r10, aVar) == aVar2) {
                return aVar2;
            }
            sq.i iVar2 = this.f15236b;
            j jVar2 = new j(hVar, this.f15237c, jVar);
            aVar.L$0 = null;
            aVar.L$1 = null;
            aVar.L$2 = null;
            aVar.label = 2;
            if (iVar2.a(jVar2, aVar) == aVar2) {
                return aVar2;
            }
            return l2.f10208a;
        }
    }

    public static final class j<T> implements sq.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k1.h<R> f15238a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ jn.q<R, T, um.d<? super R>, Object> f15239b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ sq.j<R> f15240c;

        @xm.f(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$1$1", f = "Transform.kt", i = {0}, l = {109, 110}, m = "emit", n = {"this"}, s = {"L$0"})
        public static final class a extends xm.d {
            Object L$0;
            Object L$1;
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
        public j(k1.h<R> hVar, jn.q<? super R, ? super T, ? super um.d<? super R>, ? extends Object> qVar, sq.j<? super R> jVar) {
            this.f15238a = hVar;
            this.f15239b = qVar;
            this.f15240c = jVar;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // sq.j
        @os.m
        public final Object emit(T t10, @os.l um.d<? super l2> dVar) {
            a aVar;
            j<T> jVar;
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
            if (i11 != 0) {
                if (i11 == 1) {
                    hVar = (k1.h) aVar.L$1;
                    jVar = (j) aVar.L$0;
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
            k1.h hVar2 = this.f15238a;
            jn.q<R, T, um.d<? super R>, Object> qVar = this.f15239b;
            T t11 = hVar2.element;
            aVar.L$0 = this;
            aVar.L$1 = hVar2;
            aVar.label = 1;
            Object objInvoke = qVar.invoke((R) t11, t10, aVar);
            if (objInvoke == obj2) {
                return obj2;
            }
            jVar = this;
            hVar = hVar2;
            obj = (T) objInvoke;
            hVar.element = (T) obj;
            sq.j<R> jVar2 = jVar.f15240c;
            T t12 = jVar.f15238a.element;
            aVar.L$0 = null;
            aVar.L$1 = null;
            aVar.label = 2;
            if (jVar2.emit((R) t12, aVar) == obj2) {
                return obj2;
            }
            return l2.f10208a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,113:1\n126#2,10:114\n*E\n"})
    public static final class k<T> implements sq.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ sq.i f15241a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ jn.q f15242b;

        public k(sq.i iVar, jn.q qVar) {
            this.f15241a = iVar;
            this.f15242b = qVar;
        }

        @Override // sq.i
        @os.m
        public Object a(@os.l sq.j<? super T> jVar, @os.l um.d<? super l2> dVar) {
            k1.h hVar = new k1.h();
            hVar.element = (T) tq.u.f16062a;
            Object objA = this.f15241a.a(new l(hVar, this.f15242b, jVar), dVar);
            return objA == wm.a.COROUTINE_SUSPENDED ? objA : l2.f10208a;
        }
    }

    public static final class l<T> implements sq.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k1.h<Object> f15243a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ jn.q<T, T, um.d<? super T>, Object> f15244b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ sq.j<T> f15245c;

        @xm.f(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$runningReduce$1$1", f = "Transform.kt", i = {0}, l = {131, 133}, m = "emit", n = {"this"}, s = {"L$0"})
        public static final class a extends xm.d {
            Object L$0;
            Object L$1;
            int label;
            /* synthetic */ Object result;
            final /* synthetic */ l<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public a(l<? super T> lVar, um.d<? super a> dVar) {
                super(dVar);
                this.this$0 = lVar;
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
        public l(k1.h<Object> hVar, jn.q<? super T, ? super T, ? super um.d<? super T>, ? extends Object> qVar, sq.j<? super T> jVar) {
            this.f15243a = hVar;
            this.f15244b = qVar;
            this.f15245c = jVar;
        }

        /* JADX WARN: Code duplicated, block: B:26:0x0076 A[RETURN] */
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
            l<T> lVar;
            k1.h<Object> hVar2;
            sq.j<T> jVar;
            T t11;
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
            if (i11 != 0) {
                if (i11 == 1) {
                    hVar2 = (k1.h) aVar.L$1;
                    lVar = (l) aVar.L$0;
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
            hVar = this.f15243a;
            Object obj2 = hVar.element;
            if (obj2 != tq.u.f16062a) {
                jn.q<T, T, um.d<? super T>, Object> qVar = this.f15244b;
                aVar.L$0 = this;
                aVar.L$1 = hVar;
                aVar.label = 1;
                Object objInvoke = qVar.invoke((T) obj2, t10, aVar);
                if (objInvoke == aVar2) {
                    return aVar2;
                }
                lVar = this;
                hVar2 = hVar;
                obj = objInvoke;
            }
            hVar.element = t10;
            jVar = this.f15245c;
            t11 = this.f15243a.element;
            aVar.L$0 = null;
            aVar.L$1 = null;
            aVar.label = 2;
            if (jVar.emit(t11, aVar) == aVar2) {
                return aVar2;
            }
            return l2.f10208a;
            Object obj3 = obj;
            hVar = hVar2;
            this = lVar;
            t10 = (T) obj3;
            hVar.element = t10;
            jVar = this.f15245c;
            t11 = this.f15243a.element;
            aVar.L$0 = null;
            aVar.L$1 = null;
            aVar.label = 2;
            if (jVar.emit(t11, aVar) == aVar2) {
                return aVar2;
            }
            return l2.f10208a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,113:1\n69#2,5:114\n*E\n"})
    public static final class m<T> implements sq.i<nm.s0<? extends T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ sq.i f15246a;

        public m(sq.i iVar) {
            this.f15246a = iVar;
        }

        @Override // sq.i
        @os.m
        public Object a(@os.l sq.j<? super nm.s0<? extends T>> jVar, @os.l um.d<? super l2> dVar) {
            Object objA = this.f15246a.a(new n(jVar, new k1.f()), dVar);
            return objA == wm.a.COROUTINE_SUSPENDED ? objA : l2.f10208a;
        }
    }

    @r1({"SMAP\nTransform.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt$withIndex$1$1\n+ 2 FlowExceptions.common.kt\nkotlinx/coroutines/flow/internal/FlowExceptions_commonKt\n*L\n1#1,136:1\n32#2,4:137\n*S KotlinDebug\n*F\n+ 1 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt$withIndex$1$1\n*L\n71#1:137,4\n*E\n"})
    public static final class n<T> implements sq.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ sq.j<nm.s0<? extends T>> f15247a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ k1.f f15248b;

        @xm.f(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$withIndex$1$1", f = "Transform.kt", i = {}, l = {71}, m = "emit", n = {}, s = {})
        public static final class a extends xm.d {
            int label;
            /* synthetic */ Object result;
            final /* synthetic */ n<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public a(n<? super T> nVar, um.d<? super a> dVar) {
                super(dVar);
                this.this$0 = nVar;
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
        public n(sq.j<? super nm.s0<? extends T>> jVar, k1.f fVar) {
            this.f15247a = jVar;
            this.f15248b = fVar;
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
                sq.j<nm.s0<? extends T>> jVar = this.f15247a;
                k1.f fVar = this.f15248b;
                int i12 = fVar.element;
                fVar.element = i12 + 1;
                if (i12 < 0) {
                    throw new ArithmeticException("Index overflow has happened");
                }
                nm.s0<? extends T> s0Var = new nm.s0<>(i12, t10);
                aVar.label = 1;
                if (jVar.emit(s0Var, aVar) == aVar2) {
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

    @os.l
    public static final <T> sq.i<T> a(@os.l sq.i<? extends T> iVar, @os.l jn.p<? super T, ? super um.d<? super Boolean>, ? extends Object> pVar) {
        return new a(iVar, pVar);
    }

    public static final <R> sq.i<R> b(sq.i<?> iVar) {
        kn.l0.P();
        return new b(iVar);
    }

    @os.l
    public static final <R> sq.i<R> c(@os.l sq.i<?> iVar, @os.l un.d<R> dVar) {
        return new c(iVar, dVar);
    }

    @os.l
    public static final <T> sq.i<T> d(@os.l sq.i<? extends T> iVar, @os.l jn.p<? super T, ? super um.d<? super Boolean>, ? extends Object> pVar) {
        return new d(iVar, pVar);
    }

    @os.l
    public static final <T> sq.i<T> e(@os.l sq.i<? extends T> iVar) {
        return new e(iVar);
    }

    @os.l
    public static final <T, R> sq.i<R> f(@os.l sq.i<? extends T> iVar, @os.l jn.p<? super T, ? super um.d<? super R>, ? extends Object> pVar) {
        return new f(iVar, pVar);
    }

    @os.l
    public static final <T, R> sq.i<R> g(@os.l sq.i<? extends T> iVar, @os.l jn.p<? super T, ? super um.d<? super R>, ? extends Object> pVar) {
        return new g(iVar, pVar);
    }

    @os.l
    public static final <T> sq.i<T> h(@os.l sq.i<? extends T> iVar, @os.l jn.p<? super T, ? super um.d<? super l2>, ? extends Object> pVar) {
        return new h(iVar, pVar);
    }

    @os.l
    public static final <T, R> sq.i<R> i(@os.l sq.i<? extends T> iVar, R r10, @lm.b @os.l jn.q<? super R, ? super T, ? super um.d<? super R>, ? extends Object> qVar) {
        return new i(r10, iVar, qVar);
    }

    @os.l
    public static final <T> sq.i<T> j(@os.l sq.i<? extends T> iVar, @os.l jn.q<? super T, ? super T, ? super um.d<? super T>, ? extends Object> qVar) {
        return new k(iVar, qVar);
    }

    @os.l
    public static final <T, R> sq.i<R> k(@os.l sq.i<? extends T> iVar, R r10, @lm.b @os.l jn.q<? super R, ? super T, ? super um.d<? super R>, ? extends Object> qVar) {
        return new i(r10, iVar, qVar);
    }

    @os.l
    public static final <T> sq.i<nm.s0<T>> l(@os.l sq.i<? extends T> iVar) {
        return new m(iVar);
    }
}
