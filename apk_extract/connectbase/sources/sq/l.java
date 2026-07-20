package sq;

import java.util.Iterator;
import kn.r1;
import lm.d1;
import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nBuilders.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Builders.kt\nkotlinx/coroutines/flow/FlowKt__BuildersKt\n+ 2 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,354:1\n107#2:355\n107#2:356\n107#2:357\n107#2:358\n107#2:359\n107#2:360\n107#2:361\n107#2:362\n107#2:363\n107#2:364\n107#2:365\n107#2:366\n*S KotlinDebug\n*F\n+ 1 Builders.kt\nkotlinx/coroutines/flow/FlowKt__BuildersKt\n*L\n68#1:355\n82#1:356\n89#1:357\n98#1:358\n107#1:359\n122#1:360\n131#1:361\n153#1:362\n164#1:363\n175#1:364\n184#1:365\n193#1:366\n*E\n"})
public final /* synthetic */ class l {

    @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Builders.kt\nkotlinx/coroutines/flow/FlowKt__BuildersKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,113:1\n194#2:114\n195#2,2:116\n197#2:119\n1855#3:115\n1856#3:118\n*S KotlinDebug\n*F\n+ 1 Builders.kt\nkotlinx/coroutines/flow/FlowKt__BuildersKt\n*L\n194#1:115\n194#1:118\n*E\n"})
    public static final class a implements sq.i<Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ tn.o f15296a;

        /* JADX INFO: renamed from: sq.l$a$a, reason: collision with other inner class name */
        @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1$collect$1\n*L\n1#1,113:1\n*E\n"})
        @xm.f(c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10", f = "Builders.kt", i = {0}, l = {y5.a.f20724i0}, m = "collect", n = {"$this$asFlow_u24lambda_u2419"}, s = {"L$0"})
        public static final class C0387a extends xm.d {
            Object L$0;
            Object L$1;
            int label;
            /* synthetic */ Object result;

            public C0387a(um.d dVar) {
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

        public a(tn.o oVar) {
            this.f15296a = oVar;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // sq.i
        @os.m
        public Object a(@os.l sq.j<? super Long> jVar, @os.l um.d<? super l2> dVar) {
            C0387a c0387a;
            Iterator<Long> it;
            if (dVar instanceof C0387a) {
                c0387a = (C0387a) dVar;
                int i10 = c0387a.label;
                if ((i10 & Integer.MIN_VALUE) != 0) {
                    c0387a.label = i10 - Integer.MIN_VALUE;
                } else {
                    c0387a = new C0387a(dVar);
                }
            } else {
                c0387a = new C0387a(dVar);
            }
            Object obj = c0387a.result;
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i11 = c0387a.label;
            if (i11 == 0) {
                d1.n(obj);
                it = this.f15296a.iterator();
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it = (Iterator) c0387a.L$1;
                jVar = (sq.j) c0387a.L$0;
                d1.n(obj);
            }
            while (it.hasNext()) {
                Long l10 = new Long(((nm.w0) it).nextLong());
                c0387a.L$0 = jVar;
                c0387a.L$1 = it;
                c0387a.label = 1;
                if (jVar.emit(l10, c0387a) == aVar) {
                    return aVar;
                }
            }
            return l2.f10208a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Builders.kt\nkotlinx/coroutines/flow/FlowKt__BuildersKt\n*L\n1#1,113:1\n69#2,2:114\n*E\n"})
    public static final class b<T> implements sq.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ jn.a f15297a;

        public b(jn.a aVar) {
            this.f15297a = aVar;
        }

        @Override // sq.i
        @os.m
        public Object a(@os.l sq.j<? super T> jVar, @os.l um.d<? super l2> dVar) {
            Object objEmit = jVar.emit((Object) this.f15297a.invoke(), dVar);
            return objEmit == wm.a.COROUTINE_SUSPENDED ? objEmit : l2.f10208a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Builders.kt\nkotlinx/coroutines/flow/FlowKt__BuildersKt\n*L\n1#1,113:1\n83#2,2:114\n*E\n"})
    public static final class c<T> implements sq.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ jn.l f15298a;

        @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1$collect$1\n*L\n1#1,113:1\n*E\n"})
        @xm.f(c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2", f = "Builders.kt", i = {}, l = {y5.a.f20720g0, y5.a.f20720g0}, m = "collect", n = {}, s = {})
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
                return c.this.a(null, this);
            }
        }

        public c(jn.l lVar) {
            this.f15298a = lVar;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // sq.i
        @os.m
        public Object a(@os.l sq.j<? super T> jVar, @os.l um.d<? super l2> dVar) {
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
            if (i11 != 0) {
                if (i11 == 1) {
                    jVar = (sq.j) aVar.L$0;
                    d1.n(objInvoke);
                } else {
                    if (i11 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    d1.n(objInvoke);
                }
                return l2.f10208a;
            }
            d1.n(objInvoke);
            jn.l lVar = this.f15298a;
            aVar.L$0 = jVar;
            aVar.label = 1;
            objInvoke = lVar.invoke(aVar);
            if (objInvoke == aVar2) {
                return aVar2;
            }
            aVar.L$0 = null;
            aVar.label = 2;
            if (jVar.emit(objInvoke, aVar) == aVar2) {
                return aVar2;
            }
            return l2.f10208a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Builders.kt\nkotlinx/coroutines/flow/FlowKt__BuildersKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,113:1\n90#2:114\n91#2,2:116\n93#2:119\n1855#3:115\n1856#3:118\n*S KotlinDebug\n*F\n+ 1 Builders.kt\nkotlinx/coroutines/flow/FlowKt__BuildersKt\n*L\n90#1:115\n90#1:118\n*E\n"})
    public static final class d<T> implements sq.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterable f15299a;

        @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1$collect$1\n*L\n1#1,113:1\n*E\n"})
        @xm.f(c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3", f = "Builders.kt", i = {0}, l = {y5.a.f20724i0}, m = "collect", n = {"$this$asFlow_u24lambda_u243"}, s = {"L$0"})
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
                return d.this.a(null, this);
            }
        }

        public d(Iterable iterable) {
            this.f15299a = iterable;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // sq.i
        @os.m
        public Object a(@os.l sq.j<? super T> jVar, @os.l um.d<? super l2> dVar) {
            a aVar;
            Iterator<T> it;
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
                it = this.f15299a.iterator();
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it = (Iterator) aVar.L$1;
                jVar = (sq.j) aVar.L$0;
                d1.n(obj);
            }
            while (it.hasNext()) {
                T next = it.next();
                aVar.L$0 = jVar;
                aVar.L$1 = it;
                aVar.label = 1;
                if (jVar.emit(next, aVar) == aVar2) {
                    return aVar2;
                }
            }
            return l2.f10208a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Builders.kt\nkotlinx/coroutines/flow/FlowKt__BuildersKt\n+ 3 Iterators.kt\nkotlin/collections/CollectionsKt__IteratorsKt\n*L\n1#1,113:1\n99#2:114\n100#2,2:116\n102#2:119\n32#3:115\n33#3:118\n*S KotlinDebug\n*F\n+ 1 Builders.kt\nkotlinx/coroutines/flow/FlowKt__BuildersKt\n*L\n99#1:115\n99#1:118\n*E\n"})
    public static final class e<T> implements sq.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterator f15300a;

        @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1$collect$1\n*L\n1#1,113:1\n*E\n"})
        @xm.f(c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$4", f = "Builders.kt", i = {0}, l = {y5.a.f20724i0}, m = "collect", n = {"$this$asFlow_u24lambda_u245"}, s = {"L$0"})
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
                return e.this.a(null, this);
            }
        }

        public e(Iterator it) {
            this.f15300a = it;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // sq.i
        @os.m
        public Object a(@os.l sq.j<? super T> jVar, @os.l um.d<? super l2> dVar) {
            a aVar;
            Iterator it;
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
                it = this.f15300a;
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it = (Iterator) aVar.L$1;
                jVar = (sq.j) aVar.L$0;
                d1.n(obj);
            }
            while (it.hasNext()) {
                Object next = it.next();
                aVar.L$0 = jVar;
                aVar.L$1 = it;
                aVar.label = 1;
                if (jVar.emit(next, aVar) == aVar2) {
                    return aVar2;
                }
            }
            return l2.f10208a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Builders.kt\nkotlinx/coroutines/flow/FlowKt__BuildersKt\n+ 3 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,113:1\n108#2:114\n109#2,2:116\n111#2:119\n1295#3:115\n1296#3:118\n*S KotlinDebug\n*F\n+ 1 Builders.kt\nkotlinx/coroutines/flow/FlowKt__BuildersKt\n*L\n108#1:115\n108#1:118\n*E\n"})
    public static final class f<T> implements sq.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ gq.m f15301a;

        @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1$collect$1\n*L\n1#1,113:1\n*E\n"})
        @xm.f(c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$5", f = "Builders.kt", i = {0}, l = {y5.a.f20724i0}, m = "collect", n = {"$this$asFlow_u24lambda_u247"}, s = {"L$0"})
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
                return f.this.a(null, this);
            }
        }

        public f(gq.m mVar) {
            this.f15301a = mVar;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // sq.i
        @os.m
        public Object a(@os.l sq.j<? super T> jVar, @os.l um.d<? super l2> dVar) {
            a aVar;
            Iterator<T> it;
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
                it = this.f15301a.iterator();
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it = (Iterator) aVar.L$1;
                jVar = (sq.j) aVar.L$0;
                d1.n(obj);
            }
            while (it.hasNext()) {
                T next = it.next();
                aVar.L$0 = jVar;
                aVar.L$1 = it;
                aVar.label = 1;
                if (jVar.emit(next, aVar) == aVar2) {
                    return aVar2;
                }
            }
            return l2.f10208a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Builders.kt\nkotlinx/coroutines/flow/FlowKt__BuildersKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,113:1\n154#2:114\n155#2,2:116\n157#2:119\n13579#3:115\n13580#3:118\n*S KotlinDebug\n*F\n+ 1 Builders.kt\nkotlinx/coroutines/flow/FlowKt__BuildersKt\n*L\n154#1:115\n154#1:118\n*E\n"})
    public static final class g<T> implements sq.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object[] f15302a;

        @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1$collect$1\n*L\n1#1,113:1\n*E\n"})
        @xm.f(c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$6", f = "Builders.kt", i = {0, 0}, l = {y5.a.f20724i0}, m = "collect", n = {"$this$asFlow_u24lambda_u2411", "$this$forEach$iv"}, s = {"L$0", "L$1"})
        public static final class a extends xm.d {
            int I$0;
            int I$1;
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
                return g.this.a(null, this);
            }
        }

        public g(Object[] objArr) {
            this.f15302a = objArr;
        }

        /* JADX WARN: Code duplicated, block: B:16:0x004a  */
        /* JADX WARN: Code duplicated, block: B:18:0x005c A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r8v3 */
        /* JADX WARN: Type inference failed for: r8v4, types: [java.lang.Object, sq.j] */
        /* JADX WARN: Type inference failed for: r8v5 */
        /* JADX WARN: Type inference failed for: r8v6 */
        /* JADX WARN: Type inference failed for: r8v7 */
        /* JADX WARN: Type inference failed for: r8v8 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x005a -> B:19:0x005d). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // sq.i
        @os.m
        public java.lang.Object a(@os.l sq.j<? super T> r7, @os.l um.d<? super lm.l2> r8) {
            /*
                r6 = this;
                boolean r0 = r8 instanceof sq.l.g.a
                if (r0 == 0) goto L13
                r0 = r8
                sq.l$g$a r0 = (sq.l.g.a) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                sq.l$g$a r0 = new sq.l$g$a
                r0.<init>(r8)
            L18:
                java.lang.Object r8 = r0.result
                wm.a r1 = wm.a.COROUTINE_SUSPENDED
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L3c
                if (r2 != r3) goto L34
                int r6 = r0.I$1
                int r7 = r0.I$0
                java.lang.Object r2 = r0.L$1
                java.lang.Object[] r2 = (java.lang.Object[]) r2
                java.lang.Object r4 = r0.L$0
                sq.j r4 = (sq.j) r4
                lm.d1.n(r8)
                r8 = r4
                goto L5d
            L34:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L3c:
                lm.d1.n(r8)
                java.lang.Object[] r6 = r6.f15302a
                int r8 = r6.length
                r2 = 0
                r5 = r2
                r2 = r6
                r6 = r8
                r8 = r7
                r7 = r5
            L48:
                if (r7 >= r6) goto L5f
                r4 = r2[r7]
                r0.L$0 = r8
                r0.L$1 = r2
                r0.I$0 = r7
                r0.I$1 = r6
                r0.label = r3
                java.lang.Object r4 = r8.emit(r4, r0)
                if (r4 != r1) goto L5d
                return r1
            L5d:
                int r7 = r7 + r3
                goto L48
            L5f:
                lm.l2 r6 = lm.l2.f10208a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: sq.l.g.a(sq.j, um.d):java.lang.Object");
        }
    }

    @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Builders.kt\nkotlinx/coroutines/flow/FlowKt__BuildersKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,113:1\n165#2:114\n166#2,2:116\n168#2:119\n13600#3:115\n13601#3:118\n*S KotlinDebug\n*F\n+ 1 Builders.kt\nkotlinx/coroutines/flow/FlowKt__BuildersKt\n*L\n165#1:115\n165#1:118\n*E\n"})
    public static final class h implements sq.i<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int[] f15303a;

        @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1$collect$1\n*L\n1#1,113:1\n*E\n"})
        @xm.f(c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$7", f = "Builders.kt", i = {0, 0}, l = {y5.a.f20724i0}, m = "collect", n = {"$this$asFlow_u24lambda_u2413", "$this$forEach$iv"}, s = {"L$0", "L$1"})
        public static final class a extends xm.d {
            int I$0;
            int I$1;
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
                return h.this.a(null, this);
            }
        }

        public h(int[] iArr) {
            this.f15303a = iArr;
        }

        /* JADX WARN: Code duplicated, block: B:16:0x004a  */
        /* JADX WARN: Code duplicated, block: B:18:0x0061 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x005f -> B:19:0x0062). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // sq.i
        @os.m
        public java.lang.Object a(@os.l sq.j<? super java.lang.Integer> r8, @os.l um.d<? super lm.l2> r9) {
            /*
                r7 = this;
                boolean r0 = r9 instanceof sq.l.h.a
                if (r0 == 0) goto L13
                r0 = r9
                sq.l$h$a r0 = (sq.l.h.a) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                sq.l$h$a r0 = new sq.l$h$a
                r0.<init>(r9)
            L18:
                java.lang.Object r9 = r0.result
                wm.a r1 = wm.a.COROUTINE_SUSPENDED
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L3c
                if (r2 != r3) goto L34
                int r7 = r0.I$1
                int r8 = r0.I$0
                java.lang.Object r2 = r0.L$1
                int[] r2 = (int[]) r2
                java.lang.Object r4 = r0.L$0
                sq.j r4 = (sq.j) r4
                lm.d1.n(r9)
                r9 = r4
                goto L62
            L34:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L3c:
                lm.d1.n(r9)
                int[] r7 = r7.f15303a
                int r9 = r7.length
                r2 = 0
                r6 = r2
                r2 = r7
                r7 = r9
                r9 = r8
                r8 = r6
            L48:
                if (r8 >= r7) goto L64
                r4 = r2[r8]
                java.lang.Integer r5 = new java.lang.Integer
                r5.<init>(r4)
                r0.L$0 = r9
                r0.L$1 = r2
                r0.I$0 = r8
                r0.I$1 = r7
                r0.label = r3
                java.lang.Object r4 = r9.emit(r5, r0)
                if (r4 != r1) goto L62
                return r1
            L62:
                int r8 = r8 + r3
                goto L48
            L64:
                lm.l2 r7 = lm.l2.f10208a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: sq.l.h.a(sq.j, um.d):java.lang.Object");
        }
    }

    @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Builders.kt\nkotlinx/coroutines/flow/FlowKt__BuildersKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,113:1\n176#2:114\n177#2,2:116\n179#2:119\n13607#3:115\n13608#3:118\n*S KotlinDebug\n*F\n+ 1 Builders.kt\nkotlinx/coroutines/flow/FlowKt__BuildersKt\n*L\n176#1:115\n176#1:118\n*E\n"})
    public static final class i implements sq.i<Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long[] f15304a;

        @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1$collect$1\n*L\n1#1,113:1\n*E\n"})
        @xm.f(c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8", f = "Builders.kt", i = {0, 0}, l = {y5.a.f20724i0}, m = "collect", n = {"$this$asFlow_u24lambda_u2415", "$this$forEach$iv"}, s = {"L$0", "L$1"})
        public static final class a extends xm.d {
            int I$0;
            int I$1;
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
                return i.this.a(null, this);
            }
        }

        public i(long[] jArr) {
            this.f15304a = jArr;
        }

        /* JADX WARN: Code duplicated, block: B:16:0x004a  */
        /* JADX WARN: Code duplicated, block: B:18:0x0061 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x005f -> B:19:0x0062). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // sq.i
        @os.m
        public java.lang.Object a(@os.l sq.j<? super java.lang.Long> r9, @os.l um.d<? super lm.l2> r10) {
            /*
                r8 = this;
                boolean r0 = r10 instanceof sq.l.i.a
                if (r0 == 0) goto L13
                r0 = r10
                sq.l$i$a r0 = (sq.l.i.a) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                sq.l$i$a r0 = new sq.l$i$a
                r0.<init>(r10)
            L18:
                java.lang.Object r10 = r0.result
                wm.a r1 = wm.a.COROUTINE_SUSPENDED
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L3c
                if (r2 != r3) goto L34
                int r8 = r0.I$1
                int r9 = r0.I$0
                java.lang.Object r2 = r0.L$1
                long[] r2 = (long[]) r2
                java.lang.Object r4 = r0.L$0
                sq.j r4 = (sq.j) r4
                lm.d1.n(r10)
                r10 = r4
                goto L62
            L34:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L3c:
                lm.d1.n(r10)
                long[] r8 = r8.f15304a
                int r10 = r8.length
                r2 = 0
                r7 = r2
                r2 = r8
                r8 = r10
                r10 = r9
                r9 = r7
            L48:
                if (r9 >= r8) goto L64
                r4 = r2[r9]
                java.lang.Long r6 = new java.lang.Long
                r6.<init>(r4)
                r0.L$0 = r10
                r0.L$1 = r2
                r0.I$0 = r9
                r0.I$1 = r8
                r0.label = r3
                java.lang.Object r4 = r10.emit(r6, r0)
                if (r4 != r1) goto L62
                return r1
            L62:
                int r9 = r9 + r3
                goto L48
            L64:
                lm.l2 r8 = lm.l2.f10208a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: sq.l.i.a(sq.j, um.d):java.lang.Object");
        }
    }

    @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Builders.kt\nkotlinx/coroutines/flow/FlowKt__BuildersKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,113:1\n185#2:114\n186#2,2:116\n188#2:119\n1855#3:115\n1856#3:118\n*S KotlinDebug\n*F\n+ 1 Builders.kt\nkotlinx/coroutines/flow/FlowKt__BuildersKt\n*L\n185#1:115\n185#1:118\n*E\n"})
    public static final class j implements sq.i<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ tn.l f15305a;

        @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1$collect$1\n*L\n1#1,113:1\n*E\n"})
        @xm.f(c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9", f = "Builders.kt", i = {0}, l = {y5.a.f20724i0}, m = "collect", n = {"$this$asFlow_u24lambda_u2417"}, s = {"L$0"})
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
                return j.this.a(null, this);
            }
        }

        public j(tn.l lVar) {
            this.f15305a = lVar;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // sq.i
        @os.m
        public Object a(@os.l sq.j<? super Integer> jVar, @os.l um.d<? super l2> dVar) {
            a aVar;
            Iterator<Integer> it;
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
                it = this.f15305a.iterator();
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it = (Iterator) aVar.L$1;
                jVar = (sq.j) aVar.L$0;
                d1.n(obj);
            }
            while (it.hasNext()) {
                Integer num = new Integer(((nm.v0) it).nextInt());
                aVar.L$0 = jVar;
                aVar.L$1 = it;
                aVar.label = 1;
                if (jVar.emit(num, aVar) == aVar2) {
                    return aVar2;
                }
            }
            return l2.f10208a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Builders.kt\nkotlinx/coroutines/flow/FlowKt__BuildersKt\n*L\n1#1,113:1\n123#2,4:114\n*E\n"})
    public static final class k<T> implements sq.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object[] f15306a;

        @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1$collect$1\n*L\n1#1,113:1\n*E\n"})
        @xm.f(c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1", f = "Builders.kt", i = {0, 0}, l = {y5.a.f20722h0}, m = "collect", n = {"this", "$this$flowOf_u24lambda_u248"}, s = {"L$0", "L$1"})
        public static final class a extends xm.d {
            int I$0;
            int I$1;
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
                return k.this.a(null, this);
            }
        }

        public k(Object[] objArr) {
            this.f15306a = objArr;
        }

        /* JADX WARN: Code duplicated, block: B:16:0x0049  */
        /* JADX WARN: Code duplicated, block: B:18:0x005d A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:19:0x005e  */
        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r8v4 */
        /* JADX WARN: Type inference failed for: r8v5, types: [java.lang.Object, sq.j] */
        /* JADX WARN: Type inference failed for: r8v6 */
        /* JADX WARN: Type inference failed for: r8v7 */
        /* JADX WARN: Type inference failed for: r8v8 */
        /* JADX WARN: Type inference failed for: r8v9 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x005e -> B:20:0x0060). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // sq.i
        @os.m
        public java.lang.Object a(@os.l sq.j<? super T> r7, @os.l um.d<? super lm.l2> r8) {
            /*
                r6 = this;
                boolean r0 = r8 instanceof sq.l.k.a
                if (r0 == 0) goto L13
                r0 = r8
                sq.l$k$a r0 = (sq.l.k.a) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                sq.l$k$a r0 = new sq.l$k$a
                r0.<init>(r8)
            L18:
                java.lang.Object r8 = r0.result
                wm.a r1 = wm.a.COROUTINE_SUSPENDED
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L3c
                if (r2 != r3) goto L34
                int r6 = r0.I$1
                int r7 = r0.I$0
                java.lang.Object r2 = r0.L$1
                sq.j r2 = (sq.j) r2
                java.lang.Object r4 = r0.L$0
                sq.l$k r4 = (sq.l.k) r4
                lm.d1.n(r8)
                r8 = r2
                goto L60
            L34:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L3c:
                lm.d1.n(r8)
                java.lang.Object[] r8 = r6.f15306a
                int r8 = r8.length
                r2 = 0
                r5 = r7
                r7 = r6
                r6 = r8
                r8 = r5
            L47:
                if (r2 >= r6) goto L64
                java.lang.Object[] r4 = r7.f15306a
                r4 = r4[r2]
                r0.L$0 = r7
                r0.L$1 = r8
                r0.I$0 = r2
                r0.I$1 = r6
                r0.label = r3
                java.lang.Object r4 = r8.emit(r4, r0)
                if (r4 != r1) goto L5e
                return r1
            L5e:
                r4 = r7
                r7 = r2
            L60:
                int r2 = r7 + 1
                r7 = r4
                goto L47
            L64:
                lm.l2 r6 = lm.l2.f10208a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: sq.l.k.a(sq.j, um.d):java.lang.Object");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: sq.l$l, reason: collision with other inner class name */
    @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Builders.kt\nkotlinx/coroutines/flow/FlowKt__BuildersKt\n*L\n1#1,113:1\n136#2,2:114\n*E\n"})
    public static final class C0388l<T> implements sq.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f15307a;

        public C0388l(Object obj) {
            this.f15307a = obj;
        }

        @Override // sq.i
        @os.m
        public Object a(@os.l sq.j<? super T> jVar, @os.l um.d<? super l2> dVar) {
            Object objEmit = jVar.emit((Object) this.f15307a, dVar);
            return objEmit == wm.a.COROUTINE_SUSPENDED ? objEmit : l2.f10208a;
        }
    }

    @os.l
    public static final <T> sq.i<T> a(@os.l gq.m<? extends T> mVar) {
        return new f(mVar);
    }

    @os.l
    public static final <T> sq.i<T> b(@os.l Iterable<? extends T> iterable) {
        return new d(iterable);
    }

    @os.l
    public static final <T> sq.i<T> c(@os.l Iterator<? extends T> it) {
        return new e(it);
    }

    @os.l
    public static final <T> sq.i<T> d(@os.l jn.a<? extends T> aVar) {
        return new b(aVar);
    }

    @os.l
    public static final <T> sq.i<T> e(@os.l jn.l<? super um.d<? super T>, ? extends Object> lVar) {
        return new c(lVar);
    }

    @os.l
    public static final sq.i<Integer> f(@os.l tn.l lVar) {
        return new j(lVar);
    }

    @os.l
    public static final sq.i<Long> g(@os.l tn.o oVar) {
        return new a(oVar);
    }

    @os.l
    public static final sq.i<Integer> h(@os.l int[] iArr) {
        return new h(iArr);
    }

    @os.l
    public static final sq.i<Long> i(@os.l long[] jArr) {
        return new i(jArr);
    }

    @os.l
    public static final <T> sq.i<T> j(@os.l T[] tArr) {
        return new g(tArr);
    }

    @os.l
    public static final <T> sq.i<T> k(@lm.b @os.l jn.p<? super pq.d0<? super T>, ? super um.d<? super l2>, ? extends Object> pVar) {
        return new sq.b(pVar, null, 0, null, 14, null);
    }

    @os.l
    public static final <T> sq.i<T> l(@lm.b @os.l jn.p<? super pq.d0<? super T>, ? super um.d<? super l2>, ? extends Object> pVar) {
        return new sq.f(pVar, null, 0, null, 14, null);
    }

    @os.l
    public static final <T> sq.i<T> m() {
        return sq.h.f15278a;
    }

    @os.l
    public static final <T> sq.i<T> n(@lm.b @os.l jn.p<? super sq.j<? super T>, ? super um.d<? super l2>, ? extends Object> pVar) {
        return new i0(pVar);
    }

    @os.l
    public static final <T> sq.i<T> o(T t10) {
        return new C0388l(t10);
    }

    @os.l
    public static final <T> sq.i<T> p(@os.l T... tArr) {
        return new k(tArr);
    }
}
