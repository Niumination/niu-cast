package sq;

import com.transsion.widgetslib.widget.OSMaskImageView;
import kn.k1;
import kn.r1;
import lm.d1;
import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nLimit.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,141:1\n1#2:142\n107#3:143\n107#3:144\n107#3:145\n107#3:146\n*S KotlinDebug\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt\n*L\n22#1:143\n33#1:144\n52#1:145\n83#1:146\n*E\n"})
public final /* synthetic */ class v {

    @r1({"SMAP\nLimit.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$1\n*L\n1#1,141:1\n*E\n"})
    @xm.f(c = "kotlinx.coroutines.flow.FlowKt__LimitKt", f = "Limit.kt", i = {0}, l = {136}, m = "collectWhile", n = {"collector"}, s = {"L$0"})
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
            return v.b(null, null, this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @r1({"SMAP\nLimit.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1\n*L\n1#1,141:1\n*E\n"})
    public static final class b<T> implements sq.j<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ jn.p<T, um.d<? super Boolean>, Object> f15356a;

        @r1({"SMAP\nLimit.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1$emit$1\n*L\n1#1,141:1\n*E\n"})
        @xm.f(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$collector$1", f = "Limit.kt", i = {0}, l = {OSMaskImageView.f2731x}, m = "emit", n = {"this"}, s = {"L$0"})
        public static final class a extends xm.d {
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
                return b.this.emit(null, this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(jn.p<? super T, ? super um.d<? super Boolean>, ? extends Object> pVar) {
            this.f15356a = pVar;
        }

        @os.m
        public Object a(T t10, @os.l um.d<? super l2> dVar) {
            new a(dVar);
            if (((Boolean) this.f15356a.invoke(t10, dVar)).booleanValue()) {
                return l2.f10208a;
            }
            throw new tq.a(this);
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
                jn.p<T, um.d<? super Boolean>, Object> pVar = this.f15356a;
                aVar.L$0 = this;
                aVar.label = 1;
                objInvoke = pVar.invoke(t10, aVar);
                if (objInvoke == aVar2) {
                    return aVar2;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                this = (b) aVar.L$0;
                d1.n(objInvoke);
            }
            if (((Boolean) objInvoke).booleanValue()) {
                return l2.f10208a;
            }
            throw new tq.a(this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt\n*L\n1#1,113:1\n23#2,5:114\n*E\n"})
    public static final class c<T> implements sq.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ sq.i f15357a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f15358b;

        public c(sq.i iVar, int i10) {
            this.f15357a = iVar;
            this.f15358b = i10;
        }

        @Override // sq.i
        @os.m
        public Object a(@os.l sq.j<? super T> jVar, @os.l um.d<? super l2> dVar) {
            Object objA = this.f15357a.a(new d(new k1.f(), this.f15358b, jVar), dVar);
            return objA == wm.a.COROUTINE_SUSPENDED ? objA : l2.f10208a;
        }
    }

    public static final class d<T> implements sq.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k1.f f15359a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f15360b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ sq.j<T> f15361c;

        @xm.f(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$drop$2$1", f = "Limit.kt", i = {}, l = {25}, m = "emit", n = {}, s = {})
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
        public d(k1.f fVar, int i10, sq.j<? super T> jVar) {
            this.f15359a = fVar;
            this.f15360b = i10;
            this.f15361c = jVar;
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
                k1.f fVar = this.f15359a;
                int i12 = fVar.element;
                if (i12 < this.f15360b) {
                    fVar.element = i12 + 1;
                    return l2.f10208a;
                }
                sq.j<T> jVar = this.f15361c;
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
    @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt\n*L\n1#1,113:1\n34#2,10:114\n*E\n"})
    public static final class e<T> implements sq.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ sq.i f15362a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ jn.p f15363b;

        public e(sq.i iVar, jn.p pVar) {
            this.f15362a = iVar;
            this.f15363b = pVar;
        }

        @Override // sq.i
        @os.m
        public Object a(@os.l sq.j<? super T> jVar, @os.l um.d<? super l2> dVar) {
            Object objA = this.f15362a.a(new f(new k1.a(), jVar, this.f15363b), dVar);
            return objA == wm.a.COROUTINE_SUSPENDED ? objA : l2.f10208a;
        }
    }

    public static final class f<T> implements sq.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k1.a f15364a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ sq.j<T> f15365b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ jn.p<T, um.d<? super Boolean>, Object> f15366c;

        @xm.f(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1", f = "Limit.kt", i = {1, 1}, l = {37, 38, 40}, m = "emit", n = {"this", "value"}, s = {"L$0", "L$1"})
        public static final class a extends xm.d {
            Object L$0;
            Object L$1;
            int label;
            /* synthetic */ Object result;
            final /* synthetic */ f<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public a(f<? super T> fVar, um.d<? super a> dVar) {
                super(dVar);
                this.this$0 = fVar;
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
        public f(k1.a aVar, sq.j<? super T> jVar, jn.p<? super T, ? super um.d<? super Boolean>, ? extends Object> pVar) {
            this.f15364a = aVar;
            this.f15365b = jVar;
            this.f15366c = pVar;
        }

        /* JADX WARN: Code duplicated, block: B:30:0x0071  */
        /* JADX WARN: Code duplicated, block: B:32:0x0084 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:35:0x0088  */
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
            sq.j<T> jVar;
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
            Object objInvoke = aVar.result;
            wm.a aVar2 = wm.a.COROUTINE_SUSPENDED;
            int i11 = aVar.label;
            if (i11 == 0) {
                d1.n(objInvoke);
                if (this.f15364a.element) {
                    sq.j<T> jVar2 = this.f15365b;
                    aVar.label = 1;
                    if (jVar2.emit(t10, aVar) == aVar2) {
                        return aVar2;
                    }
                    return l2.f10208a;
                }
                jn.p<T, um.d<? super Boolean>, Object> pVar = this.f15366c;
                aVar.L$0 = this;
                aVar.L$1 = t10;
                aVar.label = 2;
                objInvoke = pVar.invoke(t10, aVar);
                if (objInvoke == aVar2) {
                    return aVar2;
                }
                if (!((Boolean) objInvoke).booleanValue()) {
                    return l2.f10208a;
                }
                this.f15364a.element = true;
                jVar = this.f15365b;
                aVar.L$0 = null;
                aVar.L$1 = null;
                aVar.label = 3;
                if (jVar.emit(t10, aVar) == aVar2) {
                    return aVar2;
                }
            } else {
                if (i11 == 1) {
                    d1.n(objInvoke);
                    return l2.f10208a;
                }
                if (i11 == 2) {
                    t10 = (T) aVar.L$1;
                    this = (f) aVar.L$0;
                    d1.n(objInvoke);
                    if (!((Boolean) objInvoke).booleanValue()) {
                        return l2.f10208a;
                    }
                    this.f15364a.element = true;
                    jVar = this.f15365b;
                    aVar.L$0 = null;
                    aVar.L$1 = null;
                    aVar.label = 3;
                    if (jVar.emit(t10, aVar) == aVar2) {
                        return aVar2;
                    }
                } else {
                    if (i11 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    d1.n(objInvoke);
                }
            }
            return l2.f10208a;
        }
    }

    @xm.f(c = "kotlinx.coroutines.flow.FlowKt__LimitKt", f = "Limit.kt", i = {0}, l = {73}, m = "emitAbort$FlowKt__LimitKt", n = {"$this$emitAbort"}, s = {"L$0"})
    public static final class g<T> extends xm.d {
        Object L$0;
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
            return v.f(null, null, this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt\n*L\n1#1,113:1\n53#2,3:114\n66#2,4:117\n*E\n"})
    public static final class h<T> implements sq.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ sq.i f15367a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f15368b;

        @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1$collect$1\n*L\n1#1,113:1\n*E\n"})
        @xm.f(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1", f = "Limit.kt", i = {0}, l = {y5.a.f20724i0}, m = "collect", n = {"$this$take_u24lambda_u244"}, s = {"L$0"})
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
                return h.this.a(null, this);
            }
        }

        public h(sq.i iVar, int i10) {
            this.f15367a = iVar;
            this.f15368b = i10;
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
            Object obj = aVar.result;
            wm.a aVar2 = wm.a.COROUTINE_SUSPENDED;
            int i11 = aVar.label;
            try {
                if (i11 == 0) {
                    d1.n(obj);
                    k1.f fVar = new k1.f();
                    sq.i iVar = this.f15367a;
                    i iVar2 = new i(fVar, this.f15368b, jVar);
                    aVar.L$0 = jVar;
                    aVar.label = 1;
                    if (iVar.a(iVar2, aVar) == aVar2) {
                        return aVar2;
                    }
                } else {
                    if (i11 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    jVar = (sq.j) aVar.L$0;
                    d1.n(obj);
                }
            } catch (tq.a e10) {
                tq.q.b(e10, jVar);
            }
            return l2.f10208a;
        }
    }

    public static final class i<T> implements sq.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k1.f f15369a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f15370b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ sq.j<T> f15371c;

        @xm.f(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$take$2$1", f = "Limit.kt", i = {}, l = {61, 63}, m = "emit", n = {}, s = {})
        public static final class a extends xm.d {
            int label;
            /* synthetic */ Object result;
            final /* synthetic */ i<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public a(i<? super T> iVar, um.d<? super a> dVar) {
                super(dVar);
                this.this$0 = iVar;
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
        public i(k1.f fVar, int i10, sq.j<? super T> jVar) {
            this.f15369a = fVar;
            this.f15370b = i10;
            this.f15371c = jVar;
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
            if (i11 != 0) {
                if (i11 == 1) {
                    d1.n(obj);
                    return l2.f10208a;
                }
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
                return l2.f10208a;
            }
            d1.n(obj);
            k1.f fVar = this.f15369a;
            int i12 = fVar.element + 1;
            fVar.element = i12;
            if (i12 < this.f15370b) {
                sq.j<T> jVar = this.f15371c;
                aVar.label = 1;
                if (jVar.emit(t10, aVar) == aVar2) {
                    return aVar2;
                }
                return l2.f10208a;
            }
            sq.j<T> jVar2 = this.f15371c;
            aVar.label = 2;
            if (v.f(jVar2, t10, aVar) == aVar2) {
                return aVar2;
            }
            return l2.f10208a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt\n*L\n1#1,113:1\n85#2:114\n126#2,15:115\n*S KotlinDebug\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt\n*L\n85#1:115,15\n*E\n"})
    public static final class j<T> implements sq.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ sq.i f15372a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ jn.p f15373b;

        @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1$collect$1\n*L\n1#1,113:1\n*E\n"})
        @xm.f(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1", f = "Limit.kt", i = {0}, l = {125}, m = "collect", n = {"collector$iv"}, s = {"L$0"})
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
                return j.this.a(null, this);
            }
        }

        public j(sq.i iVar, jn.p pVar) {
            this.f15372a = iVar;
            this.f15373b = pVar;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // sq.i
        @os.m
        public Object a(@os.l sq.j<? super T> jVar, @os.l um.d<? super l2> dVar) {
            a aVar;
            k kVar;
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
                sq.i iVar = this.f15372a;
                k kVar2 = new k(this.f15373b, jVar);
                try {
                    aVar.L$0 = kVar2;
                    aVar.label = 1;
                    if (iVar.a(kVar2, aVar) == aVar2) {
                        return aVar2;
                    }
                } catch (tq.a e10) {
                    e = e10;
                    kVar = kVar2;
                    tq.q.b(e, kVar);
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kVar = (k) aVar.L$0;
                try {
                    d1.n(obj);
                } catch (tq.a e11) {
                    e = e11;
                    tq.q.b(e, kVar);
                }
            }
            return l2.f10208a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @r1({"SMAP\nLimit.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1\n+ 2 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt\n*L\n1#1,141:1\n86#2,5:142\n*E\n"})
    public static final class k<T> implements sq.j<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ jn.p f15374a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ sq.j f15375b;

        @r1({"SMAP\nLimit.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1$emit$1\n*L\n1#1,141:1\n*E\n"})
        @xm.f(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1", f = "Limit.kt", i = {0, 0, 1}, l = {142, 143}, m = "emit", n = {"this", "value", "this"}, s = {"L$0", "L$1", "L$0"})
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
                return k.this.emit(null, this);
            }
        }

        public k(jn.p pVar, sq.j jVar) {
            this.f15374a = pVar;
            this.f15375b = jVar;
        }

        /* JADX WARN: Code duplicated, block: B:26:0x006d  */
        /* JADX WARN: Code duplicated, block: B:28:0x0070  */
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
            boolean z10 = true;
            if (i11 != 0) {
                if (i11 == 1) {
                    t10 = (T) aVar.L$1;
                    this = (k) aVar.L$0;
                    d1.n(objInvoke);
                } else {
                    if (i11 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    this = (k) aVar.L$0;
                    d1.n(objInvoke);
                }
                if (z10) {
                    return l2.f10208a;
                }
                throw new tq.a(this);
            }
            d1.n(objInvoke);
            jn.p pVar = this.f15374a;
            aVar.L$0 = this;
            aVar.L$1 = t10;
            aVar.label = 1;
            objInvoke = pVar.invoke(t10, aVar);
            if (objInvoke == aVar2) {
                return aVar2;
            }
            if (((Boolean) objInvoke).booleanValue()) {
                sq.j jVar = this.f15375b;
                aVar.L$0 = this;
                aVar.L$1 = null;
                aVar.label = 2;
                if (jVar.emit(t10, aVar) == aVar2) {
                    return aVar2;
                }
            } else {
                z10 = false;
            }
            if (z10) {
                return l2.f10208a;
            }
            throw new tq.a(this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    @r1({"SMAP\nLimit.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt$transformWhile$1\n+ 2 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt\n*L\n1#1,141:1\n126#2,15:142\n*S KotlinDebug\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt$transformWhile$1\n*L\n119#1:142,15\n*E\n"})
    @xm.f(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$transformWhile$1", f = "Limit.kt", i = {0}, l = {152}, m = "invokeSuspend", n = {"collector$iv"}, s = {"L$0"})
    public static final class l<R> extends xm.o implements jn.p<sq.j<? super R>, um.d<? super l2>, Object> {
        final /* synthetic */ sq.i<T> $this_transformWhile;
        final /* synthetic */ jn.q<sq.j<? super R>, T, um.d<? super Boolean>, Object> $transform;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: Add missing generic type declarations: [T] */
        @r1({"SMAP\nLimit.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1\n+ 2 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt$transformWhile$1\n*L\n1#1,141:1\n120#2:142\n*E\n"})
        public static final class a<T> implements sq.j<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ jn.q f15376a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ sq.j f15377b;

            /* JADX INFO: renamed from: sq.v$l$a$a, reason: collision with other inner class name */
            @r1({"SMAP\nLimit.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1$emit$1\n*L\n1#1,141:1\n*E\n"})
            @xm.f(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1", f = "Limit.kt", i = {0}, l = {142}, m = "emit", n = {"this"}, s = {"L$0"})
            public static final class C0397a extends xm.d {
                Object L$0;
                int label;
                /* synthetic */ Object result;

                public C0397a(um.d dVar) {
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

            public a(jn.q qVar, sq.j jVar) {
                this.f15376a = qVar;
                this.f15377b = jVar;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            @Override // sq.j
            @os.m
            public Object emit(T t10, @os.l um.d<? super l2> dVar) {
                C0397a c0397a;
                if (dVar instanceof C0397a) {
                    c0397a = (C0397a) dVar;
                    int i10 = c0397a.label;
                    if ((i10 & Integer.MIN_VALUE) != 0) {
                        c0397a.label = i10 - Integer.MIN_VALUE;
                    } else {
                        c0397a = new C0397a(dVar);
                    }
                } else {
                    c0397a = new C0397a(dVar);
                }
                Object objInvoke = c0397a.result;
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i11 = c0397a.label;
                if (i11 == 0) {
                    d1.n(objInvoke);
                    jn.q qVar = this.f15376a;
                    sq.j jVar = this.f15377b;
                    c0397a.L$0 = this;
                    c0397a.label = 1;
                    objInvoke = qVar.invoke(jVar, t10, c0397a);
                    if (objInvoke == aVar) {
                        return aVar;
                    }
                } else {
                    if (i11 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    this = (a) c0397a.L$0;
                    d1.n(objInvoke);
                }
                if (((Boolean) objInvoke).booleanValue()) {
                    return l2.f10208a;
                }
                throw new tq.a(this);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public l(sq.i<? extends T> iVar, jn.q<? super sq.j<? super R>, ? super T, ? super um.d<? super Boolean>, ? extends Object> qVar, um.d<? super l> dVar) {
            super(2, dVar);
            this.$this_transformWhile = iVar;
            this.$transform = qVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            l lVar = new l(this.$this_transformWhile, this.$transform, dVar);
            lVar.L$0 = obj;
            return lVar;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type um.d to sq.v$l<R> for r5v8 'this'  um.d
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
                if (r1 == 0) goto L1b
                if (r1 != r2) goto L13
                java.lang.Object r5 = r5.L$0
                sq.v$l$a r5 = (sq.v.l.a) r5
                lm.d1.n(r6)     // Catch: tq.a -> L11
                goto L3b
            L11:
                r6 = move-exception
                goto L38
            L13:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L1b:
                lm.d1.n(r6)
                java.lang.Object r6 = r5.L$0
                sq.j r6 = (sq.j) r6
                sq.i<T> r1 = r5.$this_transformWhile
                jn.q<sq.j<? super R>, T, um.d<? super java.lang.Boolean>, java.lang.Object> r3 = r5.$transform
                sq.v$l$a r4 = new sq.v$l$a
                r4.<init>(r3, r6)
                r5.L$0 = r4     // Catch: tq.a -> L36
                r5.label = r2     // Catch: tq.a -> L36
                java.lang.Object r5 = r1.a(r4, r5)     // Catch: tq.a -> L36
                if (r5 != r0) goto L3b
                return r0
            L36:
                r6 = move-exception
                r5 = r4
            L38:
                tq.q.b(r6, r5)
            L3b:
                lm.l2 r5 = lm.l2.f10208a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: sq.v.l.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l sq.j<? super R> jVar, @os.m um.d<? super l2> dVar) {
            return ((l) create(jVar, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @os.m
    public static final <T> Object b(@os.l sq.i<? extends T> iVar, @os.l jn.p<? super T, ? super um.d<? super Boolean>, ? extends Object> pVar, @os.l um.d<? super l2> dVar) {
        a aVar;
        sq.j<? super Object> jVar;
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
            sq.j<? super Object> bVar = new b<>(pVar);
            try {
                aVar.L$0 = bVar;
                aVar.label = 1;
                if (iVar.a(bVar, aVar) == aVar2) {
                    return aVar2;
                }
            } catch (tq.a e10) {
                e = e10;
                jVar = bVar;
                tq.q.b(e, jVar);
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            jVar = (b) aVar.L$0;
            try {
                d1.n(obj);
            } catch (tq.a e11) {
                e = e11;
                tq.q.b(e, jVar);
            }
        }
        return l2.f10208a;
    }

    public static final <T> Object c(sq.i<? extends T> iVar, jn.p<? super T, ? super um.d<? super Boolean>, ? extends Object> pVar, um.d<? super l2> dVar) {
        b bVar = new b(pVar);
        try {
            iVar.a(bVar, dVar);
        } catch (tq.a e10) {
            tq.q.b(e10, bVar);
        }
        return l2.f10208a;
    }

    @os.l
    public static final <T> sq.i<T> d(@os.l sq.i<? extends T> iVar, int i10) {
        if (i10 >= 0) {
            return new c(iVar, i10);
        }
        throw new IllegalArgumentException(h.a.a("Drop count should be non-negative, but had ", i10).toString());
    }

    @os.l
    public static final <T> sq.i<T> e(@os.l sq.i<? extends T> iVar, @os.l jn.p<? super T, ? super um.d<? super Boolean>, ? extends Object> pVar) {
        return new e(iVar, pVar);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final <T> Object f(sq.j<? super T> jVar, T t10, um.d<? super l2> dVar) {
        g gVar;
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
            gVar.L$0 = jVar;
            gVar.label = 1;
            if (jVar.emit(t10, gVar) == aVar) {
                return aVar;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            jVar = (sq.j) gVar.L$0;
            d1.n(obj);
        }
        throw new tq.a(jVar);
    }

    @os.l
    public static final <T> sq.i<T> g(@os.l sq.i<? extends T> iVar, int i10) {
        if (i10 > 0) {
            return new h(iVar, i10);
        }
        throw new IllegalArgumentException(k.b.a("Requested element count ", i10, " should be positive").toString());
    }

    @os.l
    public static final <T> sq.i<T> h(@os.l sq.i<? extends T> iVar, @os.l jn.p<? super T, ? super um.d<? super Boolean>, ? extends Object> pVar) {
        return new j(iVar, pVar);
    }

    @os.l
    public static final <T, R> sq.i<R> i(@os.l sq.i<? extends T> iVar, @lm.b @os.l jn.q<? super sq.j<? super R>, ? super T, ? super um.d<? super Boolean>, ? extends Object> qVar) {
        return new i0(new l(iVar, qVar, null));
    }
}
