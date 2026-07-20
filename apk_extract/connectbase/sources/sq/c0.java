package sq;

import kn.r1;
import lm.d1;
import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt\n+ 2 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,332:1\n272#1,3:334\n272#1,3:337\n261#1:340\n263#1:342\n272#1,3:343\n261#1:346\n263#1:348\n272#1,3:349\n261#1:352\n263#1:354\n272#1,3:355\n107#2:333\n107#2:341\n107#2:347\n107#2:353\n107#2:358\n107#2:359\n107#2:362\n37#3,2:360\n37#3,2:363\n*S KotlinDebug\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt\n*L\n75#1:334,3\n103#1:337,3\n119#1:340\n119#1:342\n138#1:343,3\n156#1:346\n156#1:348\n177#1:349,3\n197#1:352\n197#1:354\n220#1:355,3\n32#1:333\n119#1:341\n156#1:347\n197#1:353\n237#1:358\n261#1:359\n288#1:362\n287#1:360,2\n306#1:363,2\n*E\n"})
public final /* synthetic */ class c0 {

    /* JADX INFO: Add missing generic type declarations: [R] */
    @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt\n*L\n1#1,113:1\n262#2,2:114\n*E\n"})
    public static final class a<R> implements sq.i<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ sq.i[] f15249a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ jn.r f15250b;

        /* JADX INFO: renamed from: sq.c0$a$a, reason: collision with other inner class name */
        @r1({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineUnsafe$1$1\n+ 2 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt\n*L\n1#1,332:1\n120#2,4:333\n*E\n"})
        @xm.f(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1$2", f = "Zip.kt", i = {}, l = {333, 262}, m = "invokeSuspend", n = {}, s = {})
        public static final class C0384a extends xm.o implements jn.q<sq.j<? super R>, Object[], um.d<? super l2>, Object> {
            final /* synthetic */ jn.r $transform$inlined;
            private /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0384a(um.d dVar, jn.r rVar) {
                super(3, dVar);
                this.$transform$inlined = rVar;
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                sq.j jVar;
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i10 = this.label;
                if (i10 != 0) {
                    if (i10 == 1) {
                        jVar = (sq.j) this.L$0;
                        d1.n(obj);
                    } else {
                        if (i10 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        d1.n(obj);
                    }
                    return l2.f10208a;
                }
                d1.n(obj);
                jVar = (sq.j) this.L$0;
                Object[] objArr = (Object[]) this.L$1;
                jn.r rVar = this.$transform$inlined;
                Object obj2 = objArr[0];
                Object obj3 = objArr[1];
                Object obj4 = objArr[2];
                this.L$0 = jVar;
                this.label = 1;
                obj = rVar.invoke(obj2, obj3, obj4, this);
                if (obj == aVar) {
                    return aVar;
                }
                this.L$0 = null;
                this.label = 2;
                if (jVar.emit(obj, this) == aVar) {
                    return aVar;
                }
                return l2.f10208a;
            }

            @Override // jn.q
            @os.m
            public final Object invoke(@os.l sq.j<? super R> jVar, @os.l Object[] objArr, @os.m um.d<? super l2> dVar) {
                C0384a c0384a = new C0384a(dVar, this.$transform$inlined);
                c0384a.L$0 = jVar;
                c0384a.L$1 = objArr;
                return c0384a.invokeSuspend(l2.f10208a);
            }
        }

        public a(sq.i[] iVarArr, jn.r rVar) {
            this.f15249a = iVarArr;
            this.f15250b = rVar;
        }

        @Override // sq.i
        @os.m
        public Object a(@os.l sq.j jVar, @os.l um.d dVar) {
            Object objA = tq.m.a(jVar, this.f15249a, v.INSTANCE, new C0384a(null, this.f15250b), dVar);
            return objA == wm.a.COROUTINE_SUSPENDED ? objA : l2.f10208a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt\n*L\n1#1,113:1\n262#2,2:114\n*E\n"})
    public static final class b<R> implements sq.i<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ sq.i[] f15251a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ jn.s f15252b;

        @r1({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineUnsafe$1$1\n+ 2 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt\n*L\n1#1,332:1\n157#2,5:333\n*E\n"})
        @xm.f(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2$2", f = "Zip.kt", i = {}, l = {333, 262}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends xm.o implements jn.q<sq.j<? super R>, Object[], um.d<? super l2>, Object> {
            final /* synthetic */ jn.s $transform$inlined;
            private /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(um.d dVar, jn.s sVar) {
                super(3, dVar);
                this.$transform$inlined = sVar;
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                sq.j jVar;
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i10 = this.label;
                if (i10 != 0) {
                    if (i10 == 1) {
                        jVar = (sq.j) this.L$0;
                        d1.n(obj);
                    } else {
                        if (i10 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        d1.n(obj);
                    }
                    return l2.f10208a;
                }
                d1.n(obj);
                jVar = (sq.j) this.L$0;
                Object[] objArr = (Object[]) this.L$1;
                jn.s sVar = this.$transform$inlined;
                Object obj2 = objArr[0];
                Object obj3 = objArr[1];
                Object obj4 = objArr[2];
                Object obj5 = objArr[3];
                this.L$0 = jVar;
                this.label = 1;
                obj = sVar.invoke(obj2, obj3, obj4, obj5, this);
                if (obj == aVar) {
                    return aVar;
                }
                this.L$0 = null;
                this.label = 2;
                if (jVar.emit(obj, this) == aVar) {
                    return aVar;
                }
                return l2.f10208a;
            }

            @Override // jn.q
            @os.m
            public final Object invoke(@os.l sq.j<? super R> jVar, @os.l Object[] objArr, @os.m um.d<? super l2> dVar) {
                a aVar = new a(dVar, this.$transform$inlined);
                aVar.L$0 = jVar;
                aVar.L$1 = objArr;
                return aVar.invokeSuspend(l2.f10208a);
            }
        }

        public b(sq.i[] iVarArr, jn.s sVar) {
            this.f15251a = iVarArr;
            this.f15252b = sVar;
        }

        @Override // sq.i
        @os.m
        public Object a(@os.l sq.j jVar, @os.l um.d dVar) {
            Object objA = tq.m.a(jVar, this.f15251a, v.INSTANCE, new a(null, this.f15252b), dVar);
            return objA == wm.a.COROUTINE_SUSPENDED ? objA : l2.f10208a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt\n*L\n1#1,113:1\n262#2,2:114\n*E\n"})
    public static final class c<R> implements sq.i<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ sq.i[] f15253a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ jn.t f15254b;

        @r1({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineUnsafe$1$1\n+ 2 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt\n*L\n1#1,332:1\n198#2,6:333\n*E\n"})
        @xm.f(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$3$2", f = "Zip.kt", i = {}, l = {333, 262}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends xm.o implements jn.q<sq.j<? super R>, Object[], um.d<? super l2>, Object> {
            final /* synthetic */ jn.t $transform$inlined;
            private /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(um.d dVar, jn.t tVar) {
                super(3, dVar);
                this.$transform$inlined = tVar;
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                sq.j jVar;
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i10 = this.label;
                if (i10 != 0) {
                    if (i10 == 1) {
                        jVar = (sq.j) this.L$0;
                        d1.n(obj);
                    } else {
                        if (i10 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        d1.n(obj);
                    }
                    return l2.f10208a;
                }
                d1.n(obj);
                jVar = (sq.j) this.L$0;
                Object[] objArr = (Object[]) this.L$1;
                jn.t tVar = this.$transform$inlined;
                Object obj2 = objArr[0];
                Object obj3 = objArr[1];
                Object obj4 = objArr[2];
                Object obj5 = objArr[3];
                Object obj6 = objArr[4];
                this.L$0 = jVar;
                this.label = 1;
                obj = tVar.invoke(obj2, obj3, obj4, obj5, obj6, this);
                if (obj == aVar) {
                    return aVar;
                }
                this.L$0 = null;
                this.label = 2;
                if (jVar.emit(obj, this) == aVar) {
                    return aVar;
                }
                return l2.f10208a;
            }

            @Override // jn.q
            @os.m
            public final Object invoke(@os.l sq.j<? super R> jVar, @os.l Object[] objArr, @os.m um.d<? super l2> dVar) {
                a aVar = new a(dVar, this.$transform$inlined);
                aVar.L$0 = jVar;
                aVar.L$1 = objArr;
                return aVar.invokeSuspend(l2.f10208a);
            }
        }

        public c(sq.i[] iVarArr, jn.t tVar) {
            this.f15253a = iVarArr;
            this.f15254b = tVar;
        }

        @Override // sq.i
        @os.m
        public Object a(@os.l sq.j jVar, @os.l um.d dVar) {
            Object objA = tq.m.a(jVar, this.f15253a, v.INSTANCE, new a(null, this.f15254b), dVar);
            return objA == wm.a.COROUTINE_SUSPENDED ? objA : l2.f10208a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt\n*L\n1#1,113:1\n33#2,2:114\n*E\n"})
    public static final class d<R> implements sq.i<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ sq.i f15255a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ sq.i f15256b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ jn.q f15257c;

        public d(sq.i iVar, sq.i iVar2, jn.q qVar) {
            this.f15255a = iVar;
            this.f15256b = iVar2;
            this.f15257c = qVar;
        }

        @Override // sq.i
        @os.m
        public Object a(@os.l sq.j<? super R> jVar, @os.l um.d<? super l2> dVar) {
            Object objA = tq.m.a(jVar, new sq.i[]{this.f15255a, this.f15256b}, v.INSTANCE, new g(this.f15257c, null), dVar);
            return objA == wm.a.COROUTINE_SUSPENDED ? objA : l2.f10208a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt\n*L\n1#1,113:1\n238#2,2:114\n*E\n"})
    public static final class e<R> implements sq.i<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ sq.i[] f15258a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ jn.p f15259b;

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
                return e.this.a(null, this);
            }
        }

        public e(sq.i[] iVarArr, jn.p pVar) {
            this.f15258a = iVarArr;
            this.f15259b = pVar;
        }

        @Override // sq.i
        @os.m
        public Object a(@os.l sq.j<? super R> jVar, @os.l um.d<? super l2> dVar) {
            sq.i[] iVarArr = this.f15258a;
            kn.l0.P();
            h hVar = new h(this.f15258a);
            kn.l0.P();
            Object objA = tq.m.a(jVar, iVarArr, hVar, new i(this.f15259b, null), dVar);
            return objA == wm.a.COROUTINE_SUSPENDED ? objA : l2.f10208a;
        }

        @os.m
        public Object g(@os.l sq.j jVar, @os.l um.d dVar) {
            new a(dVar);
            sq.i[] iVarArr = this.f15258a;
            kn.l0.P();
            h hVar = new h(this.f15258a);
            kn.l0.P();
            tq.m.a(jVar, iVarArr, hVar, new i(this.f15259b, null), dVar);
            return l2.f10208a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt\n*L\n1#1,113:1\n289#2,5:114\n*E\n"})
    public static final class f<R> implements sq.i<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ sq.i[] f15260a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ jn.p f15261b;

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

        public f(sq.i[] iVarArr, jn.p pVar) {
            this.f15260a = iVarArr;
            this.f15261b = pVar;
        }

        @Override // sq.i
        @os.m
        public Object a(@os.l sq.j<? super R> jVar, @os.l um.d<? super l2> dVar) {
            sq.i[] iVarArr = this.f15260a;
            kn.l0.P();
            j jVar2 = new j(this.f15260a);
            kn.l0.P();
            Object objA = tq.m.a(jVar, iVarArr, jVar2, new k(this.f15261b, null), dVar);
            return objA == wm.a.COROUTINE_SUSPENDED ? objA : l2.f10208a;
        }

        @os.m
        public Object g(@os.l sq.j jVar, @os.l um.d dVar) {
            new a(dVar);
            sq.i[] iVarArr = this.f15260a;
            kn.l0.P();
            j jVar2 = new j(this.f15260a);
            kn.l0.P();
            tq.m.a(jVar, iVarArr, jVar2, new k(this.f15261b, null), dVar);
            return l2.f10208a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    @xm.f(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$1$1", f = "Zip.kt", i = {}, l = {33, 33}, m = "invokeSuspend", n = {}, s = {})
    public static final class g<R> extends xm.o implements jn.q<sq.j<? super R>, Object[], um.d<? super l2>, Object> {
        final /* synthetic */ jn.q<T1, T2, um.d<? super R>, Object> $transform;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public g(jn.q<? super T1, ? super T2, ? super um.d<? super R>, ? extends Object> qVar, um.d<? super g> dVar) {
            super(3, dVar);
            this.$transform = qVar;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to sq.c0$g<R> for r6v4 'this'  java.lang.Object
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
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L20
                if (r1 == r3) goto L18
                if (r1 != r2) goto L10
                lm.d1.n(r7)
                goto L4a
            L10:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L18:
                java.lang.Object r1 = r6.L$0
                sq.j r1 = (sq.j) r1
                lm.d1.n(r7)
                goto L3e
            L20:
                lm.d1.n(r7)
                java.lang.Object r7 = r6.L$0
                r1 = r7
                sq.j r1 = (sq.j) r1
                java.lang.Object r7 = r6.L$1
                java.lang.Object[] r7 = (java.lang.Object[]) r7
                jn.q<T1, T2, um.d<? super R>, java.lang.Object> r4 = r6.$transform
                r5 = 0
                r5 = r7[r5]
                r7 = r7[r3]
                r6.L$0 = r1
                r6.label = r3
                java.lang.Object r7 = r4.invoke(r5, r7, r6)
                if (r7 != r0) goto L3e
                return r0
            L3e:
                r3 = 0
                r6.L$0 = r3
                r6.label = r2
                java.lang.Object r6 = r1.emit(r7, r6)
                if (r6 != r0) goto L4a
                return r0
            L4a:
                lm.l2 r6 = lm.l2.f10208a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: sq.c0.g.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // jn.q
        @os.m
        public final Object invoke(@os.l sq.j<? super R> jVar, @os.l Object[] objArr, @os.m um.d<? super l2> dVar) {
            g gVar = new g(this.$transform, dVar);
            gVar.L$0 = jVar;
            gVar.L$1 = objArr;
            return gVar.invokeSuspend(l2.f10208a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @r1({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combine$5$1\n*L\n1#1,332:1\n*E\n"})
    public static final class h<T> extends kn.n0 implements jn.a<T[]> {
        final /* synthetic */ sq.i<T>[] $flows;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public h(sq.i<? extends T>[] iVarArr) {
            super(0);
            this.$flows = iVarArr;
        }

        @Override // jn.a
        @os.m
        public final T[] invoke() {
            int length = this.$flows.length;
            kn.l0.P();
            return (T[]) new Object[length];
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R, T] */
    @r1({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combine$5$2\n*L\n1#1,332:1\n*E\n"})
    @xm.f(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$5$2", f = "Zip.kt", i = {}, l = {238, 238}, m = "invokeSuspend", n = {}, s = {})
    public static final class i<R, T> extends xm.o implements jn.q<sq.j<? super R>, T[], um.d<? super l2>, Object> {
        final /* synthetic */ jn.p<T[], um.d<? super R>, Object> $transform;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public i(jn.p<? super T[], ? super um.d<? super R>, ? extends Object> pVar, um.d<? super i> dVar) {
            super(3, dVar);
            this.$transform = pVar;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
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
        public final Object invokeSuspend(@os.l Object obj) {
            sq.j jVar;
            sq.j jVar2;
            Object obj2 = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    sq.j jVar3 = (sq.j) this.L$0;
                    d1.n(obj);
                    jVar2 = jVar3;
                } else {
                    if (i10 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    d1.n(obj);
                }
                return l2.f10208a;
            }
            d1.n(obj);
            jVar = (sq.j) this.L$0;
            Object[] objArr = (Object[]) this.L$1;
            jn.p<T[], um.d<? super R>, Object> pVar = this.$transform;
            this.L$0 = jVar;
            this.label = 1;
            obj = pVar.invoke(objArr, this);
            if (obj == obj2) {
                jVar2 = jVar;
                return obj2;
            }
            jVar2 = jVar;
            this.L$0 = null;
            this.label = 2;
            if (jVar2.emit(obj, this) == obj2) {
                return obj2;
            }
            return l2.f10208a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @os.m
        public final Object invokeSuspend$$forInline(@os.l Object obj) {
            ((sq.j) this.L$0).emit(this.$transform.invoke((Object[]) this.L$1, this), this);
            return l2.f10208a;
        }

        @Override // jn.q
        @os.m
        public final Object invoke(@os.l sq.j<? super R> jVar, @os.l T[] tArr, @os.m um.d<? super l2> dVar) {
            kn.l0.P();
            i iVar = new i(this.$transform, dVar);
            iVar.L$0 = jVar;
            iVar.L$1 = tArr;
            return iVar.invokeSuspend(l2.f10208a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @r1({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combine$6$1\n*L\n1#1,332:1\n*E\n"})
    public static final class j<T> extends kn.n0 implements jn.a<T[]> {
        final /* synthetic */ sq.i<T>[] $flowArray;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(sq.i<T>[] iVarArr) {
            super(0);
            this.$flowArray = iVarArr;
        }

        @Override // jn.a
        @os.m
        public final T[] invoke() {
            int length = this.$flowArray.length;
            kn.l0.P();
            return (T[]) new Object[length];
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R, T] */
    @r1({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combine$6$2\n*L\n1#1,332:1\n*E\n"})
    @xm.f(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$6$2", f = "Zip.kt", i = {}, l = {292, 292}, m = "invokeSuspend", n = {}, s = {})
    public static final class k<R, T> extends xm.o implements jn.q<sq.j<? super R>, T[], um.d<? super l2>, Object> {
        final /* synthetic */ jn.p<T[], um.d<? super R>, Object> $transform;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public k(jn.p<? super T[], ? super um.d<? super R>, ? extends Object> pVar, um.d<? super k> dVar) {
            super(3, dVar);
            this.$transform = pVar;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
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
        public final Object invokeSuspend(@os.l Object obj) {
            sq.j jVar;
            sq.j jVar2;
            Object obj2 = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    sq.j jVar3 = (sq.j) this.L$0;
                    d1.n(obj);
                    jVar2 = jVar3;
                } else {
                    if (i10 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    d1.n(obj);
                }
                return l2.f10208a;
            }
            d1.n(obj);
            jVar = (sq.j) this.L$0;
            Object[] objArr = (Object[]) this.L$1;
            jn.p<T[], um.d<? super R>, Object> pVar = this.$transform;
            this.L$0 = jVar;
            this.label = 1;
            obj = pVar.invoke(objArr, this);
            if (obj == obj2) {
                jVar2 = jVar;
                return obj2;
            }
            jVar2 = jVar;
            this.L$0 = null;
            this.label = 2;
            if (jVar2.emit(obj, this) == obj2) {
                return obj2;
            }
            return l2.f10208a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @os.m
        public final Object invokeSuspend$$forInline(@os.l Object obj) {
            ((sq.j) this.L$0).emit(this.$transform.invoke((Object[]) this.L$1, this), this);
            return l2.f10208a;
        }

        @Override // jn.q
        @os.m
        public final Object invoke(@os.l sq.j<? super R> jVar, @os.l T[] tArr, @os.m um.d<? super l2> dVar) {
            kn.l0.P();
            k kVar = new k(this.$transform, dVar);
            kVar.L$0 = jVar;
            kVar.L$1 = tArr;
            return kVar.invokeSuspend(l2.f10208a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    @r1({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineTransformUnsafe$1\n*L\n1#1,332:1\n*E\n"})
    @xm.f(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$1", f = "Zip.kt", i = {}, l = {273}, m = "invokeSuspend", n = {}, s = {})
    public static final class l<R> extends xm.o implements jn.p<sq.j<? super R>, um.d<? super l2>, Object> {
        final /* synthetic */ sq.i[] $flows;
        final /* synthetic */ jn.r $transform$inlined;
        private /* synthetic */ Object L$0;
        int label;

        @r1({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineTransformUnsafe$1$1\n+ 2 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt\n*L\n1#1,332:1\n76#2,5:333\n*E\n"})
        @xm.f(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$1$1", f = "Zip.kt", i = {}, l = {333}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends xm.o implements jn.q<sq.j<? super R>, Object[], um.d<? super l2>, Object> {
            final /* synthetic */ jn.r $transform$inlined;
            private /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(um.d dVar, jn.r rVar) {
                super(3, dVar);
                this.$transform$inlined = rVar;
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i10 = this.label;
                if (i10 == 0) {
                    d1.n(obj);
                    sq.j jVar = (sq.j) this.L$0;
                    Object[] objArr = (Object[]) this.L$1;
                    jn.r rVar = this.$transform$inlined;
                    Object obj2 = objArr[0];
                    Object obj3 = objArr[1];
                    this.label = 1;
                    if (rVar.invoke(jVar, obj2, obj3, this) == aVar) {
                        return aVar;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    d1.n(obj);
                }
                return l2.f10208a;
            }

            @Override // jn.q
            @os.m
            public final Object invoke(@os.l sq.j<? super R> jVar, @os.l Object[] objArr, @os.m um.d<? super l2> dVar) {
                a aVar = new a(dVar, this.$transform$inlined);
                aVar.L$0 = jVar;
                aVar.L$1 = objArr;
                return aVar.invokeSuspend(l2.f10208a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(sq.i[] iVarArr, um.d dVar, jn.r rVar) {
            super(2, dVar);
            this.$flows = iVarArr;
            this.$transform$inlined = rVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            l lVar = new l(this.$flows, dVar, this.$transform$inlined);
            lVar.L$0 = obj;
            return lVar;
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                sq.j jVar = (sq.j) this.L$0;
                sq.i[] iVarArr = this.$flows;
                v vVar = v.INSTANCE;
                a aVar2 = new a(null, this.$transform$inlined);
                this.label = 1;
                if (tq.m.a(jVar, iVarArr, vVar, aVar2, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
            }
            return l2.f10208a;
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l sq.j<? super R> jVar, @os.m um.d<? super l2> dVar) {
            return ((l) create(jVar, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    @r1({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineTransformUnsafe$1\n*L\n1#1,332:1\n*E\n"})
    @xm.f(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$2", f = "Zip.kt", i = {}, l = {273}, m = "invokeSuspend", n = {}, s = {})
    public static final class m<R> extends xm.o implements jn.p<sq.j<? super R>, um.d<? super l2>, Object> {
        final /* synthetic */ sq.i[] $flows;
        final /* synthetic */ jn.r $transform$inlined;
        private /* synthetic */ Object L$0;
        int label;

        @r1({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineTransformUnsafe$1$1\n+ 2 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt\n*L\n1#1,332:1\n104#2,5:333\n*E\n"})
        @xm.f(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$2$1", f = "Zip.kt", i = {}, l = {333}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends xm.o implements jn.q<sq.j<? super R>, Object[], um.d<? super l2>, Object> {
            final /* synthetic */ jn.r $transform$inlined;
            private /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(um.d dVar, jn.r rVar) {
                super(3, dVar);
                this.$transform$inlined = rVar;
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i10 = this.label;
                if (i10 == 0) {
                    d1.n(obj);
                    sq.j jVar = (sq.j) this.L$0;
                    Object[] objArr = (Object[]) this.L$1;
                    jn.r rVar = this.$transform$inlined;
                    Object obj2 = objArr[0];
                    Object obj3 = objArr[1];
                    this.label = 1;
                    if (rVar.invoke(jVar, obj2, obj3, this) == aVar) {
                        return aVar;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    d1.n(obj);
                }
                return l2.f10208a;
            }

            @Override // jn.q
            @os.m
            public final Object invoke(@os.l sq.j<? super R> jVar, @os.l Object[] objArr, @os.m um.d<? super l2> dVar) {
                a aVar = new a(dVar, this.$transform$inlined);
                aVar.L$0 = jVar;
                aVar.L$1 = objArr;
                return aVar.invokeSuspend(l2.f10208a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(sq.i[] iVarArr, um.d dVar, jn.r rVar) {
            super(2, dVar);
            this.$flows = iVarArr;
            this.$transform$inlined = rVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            m mVar = new m(this.$flows, dVar, this.$transform$inlined);
            mVar.L$0 = obj;
            return mVar;
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                sq.j jVar = (sq.j) this.L$0;
                sq.i[] iVarArr = this.$flows;
                v vVar = v.INSTANCE;
                a aVar2 = new a(null, this.$transform$inlined);
                this.label = 1;
                if (tq.m.a(jVar, iVarArr, vVar, aVar2, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
            }
            return l2.f10208a;
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l sq.j<? super R> jVar, @os.m um.d<? super l2> dVar) {
            return ((m) create(jVar, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    @r1({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineTransformUnsafe$1\n*L\n1#1,332:1\n*E\n"})
    @xm.f(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$3", f = "Zip.kt", i = {}, l = {273}, m = "invokeSuspend", n = {}, s = {})
    public static final class n<R> extends xm.o implements jn.p<sq.j<? super R>, um.d<? super l2>, Object> {
        final /* synthetic */ sq.i[] $flows;
        final /* synthetic */ jn.s $transform$inlined;
        private /* synthetic */ Object L$0;
        int label;

        @r1({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineTransformUnsafe$1$1\n+ 2 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt\n*L\n1#1,332:1\n139#2,6:333\n*E\n"})
        @xm.f(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$3$1", f = "Zip.kt", i = {}, l = {333}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends xm.o implements jn.q<sq.j<? super R>, Object[], um.d<? super l2>, Object> {
            final /* synthetic */ jn.s $transform$inlined;
            private /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(um.d dVar, jn.s sVar) {
                super(3, dVar);
                this.$transform$inlined = sVar;
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i10 = this.label;
                if (i10 == 0) {
                    d1.n(obj);
                    sq.j jVar = (sq.j) this.L$0;
                    Object[] objArr = (Object[]) this.L$1;
                    jn.s sVar = this.$transform$inlined;
                    Object obj2 = objArr[0];
                    Object obj3 = objArr[1];
                    Object obj4 = objArr[2];
                    this.label = 1;
                    if (sVar.invoke(jVar, obj2, obj3, obj4, this) == aVar) {
                        return aVar;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    d1.n(obj);
                }
                return l2.f10208a;
            }

            @Override // jn.q
            @os.m
            public final Object invoke(@os.l sq.j<? super R> jVar, @os.l Object[] objArr, @os.m um.d<? super l2> dVar) {
                a aVar = new a(dVar, this.$transform$inlined);
                aVar.L$0 = jVar;
                aVar.L$1 = objArr;
                return aVar.invokeSuspend(l2.f10208a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(sq.i[] iVarArr, um.d dVar, jn.s sVar) {
            super(2, dVar);
            this.$flows = iVarArr;
            this.$transform$inlined = sVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            n nVar = new n(this.$flows, dVar, this.$transform$inlined);
            nVar.L$0 = obj;
            return nVar;
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                sq.j jVar = (sq.j) this.L$0;
                sq.i[] iVarArr = this.$flows;
                v vVar = v.INSTANCE;
                a aVar2 = new a(null, this.$transform$inlined);
                this.label = 1;
                if (tq.m.a(jVar, iVarArr, vVar, aVar2, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
            }
            return l2.f10208a;
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l sq.j<? super R> jVar, @os.m um.d<? super l2> dVar) {
            return ((n) create(jVar, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    @r1({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineTransformUnsafe$1\n*L\n1#1,332:1\n*E\n"})
    @xm.f(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$4", f = "Zip.kt", i = {}, l = {273}, m = "invokeSuspend", n = {}, s = {})
    public static final class o<R> extends xm.o implements jn.p<sq.j<? super R>, um.d<? super l2>, Object> {
        final /* synthetic */ sq.i[] $flows;
        final /* synthetic */ jn.t $transform$inlined;
        private /* synthetic */ Object L$0;
        int label;

        @r1({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineTransformUnsafe$1$1\n+ 2 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt\n*L\n1#1,332:1\n178#2,7:333\n*E\n"})
        @xm.f(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$4$1", f = "Zip.kt", i = {}, l = {333}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends xm.o implements jn.q<sq.j<? super R>, Object[], um.d<? super l2>, Object> {
            final /* synthetic */ jn.t $transform$inlined;
            private /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(um.d dVar, jn.t tVar) {
                super(3, dVar);
                this.$transform$inlined = tVar;
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i10 = this.label;
                if (i10 == 0) {
                    d1.n(obj);
                    sq.j jVar = (sq.j) this.L$0;
                    Object[] objArr = (Object[]) this.L$1;
                    jn.t tVar = this.$transform$inlined;
                    Object obj2 = objArr[0];
                    Object obj3 = objArr[1];
                    Object obj4 = objArr[2];
                    Object obj5 = objArr[3];
                    this.label = 1;
                    if (tVar.invoke(jVar, obj2, obj3, obj4, obj5, this) == aVar) {
                        return aVar;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    d1.n(obj);
                }
                return l2.f10208a;
            }

            @Override // jn.q
            @os.m
            public final Object invoke(@os.l sq.j<? super R> jVar, @os.l Object[] objArr, @os.m um.d<? super l2> dVar) {
                a aVar = new a(dVar, this.$transform$inlined);
                aVar.L$0 = jVar;
                aVar.L$1 = objArr;
                return aVar.invokeSuspend(l2.f10208a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(sq.i[] iVarArr, um.d dVar, jn.t tVar) {
            super(2, dVar);
            this.$flows = iVarArr;
            this.$transform$inlined = tVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            o oVar = new o(this.$flows, dVar, this.$transform$inlined);
            oVar.L$0 = obj;
            return oVar;
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                sq.j jVar = (sq.j) this.L$0;
                sq.i[] iVarArr = this.$flows;
                v vVar = v.INSTANCE;
                a aVar2 = new a(null, this.$transform$inlined);
                this.label = 1;
                if (tq.m.a(jVar, iVarArr, vVar, aVar2, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
            }
            return l2.f10208a;
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l sq.j<? super R> jVar, @os.m um.d<? super l2> dVar) {
            return ((o) create(jVar, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    @r1({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineTransformUnsafe$1\n*L\n1#1,332:1\n*E\n"})
    @xm.f(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$5", f = "Zip.kt", i = {}, l = {273}, m = "invokeSuspend", n = {}, s = {})
    public static final class p<R> extends xm.o implements jn.p<sq.j<? super R>, um.d<? super l2>, Object> {
        final /* synthetic */ sq.i[] $flows;
        final /* synthetic */ jn.u $transform$inlined;
        private /* synthetic */ Object L$0;
        int label;

        @r1({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineTransformUnsafe$1$1\n+ 2 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt\n*L\n1#1,332:1\n221#2,8:333\n*E\n"})
        @xm.f(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$5$1", f = "Zip.kt", i = {}, l = {333}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends xm.o implements jn.q<sq.j<? super R>, Object[], um.d<? super l2>, Object> {
            final /* synthetic */ jn.u $transform$inlined;
            private /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(um.d dVar, jn.u uVar) {
                super(3, dVar);
                this.$transform$inlined = uVar;
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i10 = this.label;
                if (i10 == 0) {
                    d1.n(obj);
                    sq.j jVar = (sq.j) this.L$0;
                    Object[] objArr = (Object[]) this.L$1;
                    jn.u uVar = this.$transform$inlined;
                    Object obj2 = objArr[0];
                    Object obj3 = objArr[1];
                    Object obj4 = objArr[2];
                    Object obj5 = objArr[3];
                    Object obj6 = objArr[4];
                    this.label = 1;
                    if (uVar.invoke(jVar, obj2, obj3, obj4, obj5, obj6, this) == aVar) {
                        return aVar;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    d1.n(obj);
                }
                return l2.f10208a;
            }

            @Override // jn.q
            @os.m
            public final Object invoke(@os.l sq.j<? super R> jVar, @os.l Object[] objArr, @os.m um.d<? super l2> dVar) {
                a aVar = new a(dVar, this.$transform$inlined);
                aVar.L$0 = jVar;
                aVar.L$1 = objArr;
                return aVar.invokeSuspend(l2.f10208a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(sq.i[] iVarArr, um.d dVar, jn.u uVar) {
            super(2, dVar);
            this.$flows = iVarArr;
            this.$transform$inlined = uVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            p pVar = new p(this.$flows, dVar, this.$transform$inlined);
            pVar.L$0 = obj;
            return pVar;
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                sq.j jVar = (sq.j) this.L$0;
                sq.i[] iVarArr = this.$flows;
                v vVar = v.INSTANCE;
                a aVar2 = new a(null, this.$transform$inlined);
                this.label = 1;
                if (tq.m.a(jVar, iVarArr, vVar, aVar2, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
            }
            return l2.f10208a;
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l sq.j<? super R> jVar, @os.m um.d<? super l2> dVar) {
            return ((p) create(jVar, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    @r1({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineTransform$6\n*L\n1#1,332:1\n*E\n"})
    @xm.f(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$6", f = "Zip.kt", i = {}, l = {251}, m = "invokeSuspend", n = {}, s = {})
    public static final class q<R> extends xm.o implements jn.p<sq.j<? super R>, um.d<? super l2>, Object> {
        final /* synthetic */ sq.i<T>[] $flows;
        final /* synthetic */ jn.q<sq.j<? super R>, T[], um.d<? super l2>, Object> $transform;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: Add missing generic type declarations: [T] */
        @r1({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineTransform$6$1\n*L\n1#1,332:1\n*E\n"})
        public static final class a<T> extends kn.n0 implements jn.a<T[]> {
            final /* synthetic */ sq.i<T>[] $flows;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public a(sq.i<? extends T>[] iVarArr) {
                super(0);
                this.$flows = iVarArr;
            }

            @Override // jn.a
            @os.m
            public final T[] invoke() {
                int length = this.$flows.length;
                kn.l0.P();
                return (T[]) new Object[length];
            }
        }

        /* JADX INFO: Add missing generic type declarations: [T] */
        @r1({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineTransform$6$2\n*L\n1#1,332:1\n*E\n"})
        @xm.f(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$6$2", f = "Zip.kt", i = {}, l = {251}, m = "invokeSuspend", n = {}, s = {})
        public static final class b<T> extends xm.o implements jn.q<sq.j<? super R>, T[], um.d<? super l2>, Object> {
            final /* synthetic */ jn.q<sq.j<? super R>, T[], um.d<? super l2>, Object> $transform;
            private /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public b(jn.q<? super sq.j<? super R>, ? super T[], ? super um.d<? super l2>, ? extends Object> qVar, um.d<? super b> dVar) {
                super(3, dVar);
                this.$transform = qVar;
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
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
            public final Object invokeSuspend(@os.l Object obj) {
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i10 = this.label;
                if (i10 == 0) {
                    d1.n(obj);
                    sq.j<? super R> jVar = (sq.j) this.L$0;
                    Object[] objArr = (Object[]) this.L$1;
                    jn.q<sq.j<? super R>, T[], um.d<? super l2>, Object> qVar = this.$transform;
                    this.L$0 = null;
                    this.label = 1;
                    if (qVar.invoke(jVar, objArr, this) == aVar) {
                        return aVar;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    d1.n(obj);
                }
                return l2.f10208a;
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @os.m
            public final Object invokeSuspend$$forInline(@os.l Object obj) {
                this.$transform.invoke((sq.j) this.L$0, (Object[]) this.L$1, this);
                return l2.f10208a;
            }

            @Override // jn.q
            @os.m
            public final Object invoke(@os.l sq.j<? super R> jVar, @os.l T[] tArr, @os.m um.d<? super l2> dVar) {
                kn.l0.P();
                b bVar = new b(this.$transform, dVar);
                bVar.L$0 = jVar;
                bVar.L$1 = tArr;
                return bVar.invokeSuspend(l2.f10208a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public q(sq.i<? extends T>[] iVarArr, jn.q<? super sq.j<? super R>, ? super T[], ? super um.d<? super l2>, ? extends Object> qVar, um.d<? super q> dVar) {
            super(2, dVar);
            this.$flows = iVarArr;
            this.$transform = qVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            q qVar = new q(this.$flows, this.$transform, dVar);
            qVar.L$0 = obj;
            return qVar;
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                sq.j jVar = (sq.j) this.L$0;
                sq.i<T>[] iVarArr = this.$flows;
                kn.l0.P();
                a aVar2 = new a(this.$flows);
                kn.l0.P();
                b bVar = new b(this.$transform, null);
                this.label = 1;
                if (tq.m.a(jVar, iVarArr, aVar2, bVar, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
            }
            return l2.f10208a;
        }

        @os.m
        public final Object invokeSuspend$$forInline(@os.l Object obj) {
            sq.j jVar = (sq.j) this.L$0;
            sq.i<T>[] iVarArr = this.$flows;
            kn.l0.P();
            a aVar = new a(this.$flows);
            kn.l0.P();
            tq.m.a(jVar, iVarArr, aVar, new b(this.$transform, null), this);
            return l2.f10208a;
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l sq.j<? super R> jVar, @os.m um.d<? super l2> dVar) {
            return ((q) create(jVar, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    @r1({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineTransform$7\n*L\n1#1,332:1\n*E\n"})
    @xm.f(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$7", f = "Zip.kt", i = {}, l = {308}, m = "invokeSuspend", n = {}, s = {})
    public static final class r<R> extends xm.o implements jn.p<sq.j<? super R>, um.d<? super l2>, Object> {
        final /* synthetic */ sq.i<T>[] $flowArray;
        final /* synthetic */ jn.q<sq.j<? super R>, T[], um.d<? super l2>, Object> $transform;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: Add missing generic type declarations: [T] */
        @r1({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineTransform$7$1\n*L\n1#1,332:1\n*E\n"})
        public static final class a<T> extends kn.n0 implements jn.a<T[]> {
            final /* synthetic */ sq.i<T>[] $flowArray;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(sq.i<T>[] iVarArr) {
                super(0);
                this.$flowArray = iVarArr;
            }

            @Override // jn.a
            @os.m
            public final T[] invoke() {
                int length = this.$flowArray.length;
                kn.l0.P();
                return (T[]) new Object[length];
            }
        }

        /* JADX INFO: Add missing generic type declarations: [T] */
        @r1({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineTransform$7$2\n*L\n1#1,332:1\n*E\n"})
        @xm.f(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$7$2", f = "Zip.kt", i = {}, l = {308}, m = "invokeSuspend", n = {}, s = {})
        public static final class b<T> extends xm.o implements jn.q<sq.j<? super R>, T[], um.d<? super l2>, Object> {
            final /* synthetic */ jn.q<sq.j<? super R>, T[], um.d<? super l2>, Object> $transform;
            private /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public b(jn.q<? super sq.j<? super R>, ? super T[], ? super um.d<? super l2>, ? extends Object> qVar, um.d<? super b> dVar) {
                super(3, dVar);
                this.$transform = qVar;
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
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
            public final Object invokeSuspend(@os.l Object obj) {
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i10 = this.label;
                if (i10 == 0) {
                    d1.n(obj);
                    sq.j<? super R> jVar = (sq.j) this.L$0;
                    Object[] objArr = (Object[]) this.L$1;
                    jn.q<sq.j<? super R>, T[], um.d<? super l2>, Object> qVar = this.$transform;
                    this.L$0 = null;
                    this.label = 1;
                    if (qVar.invoke(jVar, objArr, this) == aVar) {
                        return aVar;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    d1.n(obj);
                }
                return l2.f10208a;
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @os.m
            public final Object invokeSuspend$$forInline(@os.l Object obj) {
                this.$transform.invoke((sq.j) this.L$0, (Object[]) this.L$1, this);
                return l2.f10208a;
            }

            @Override // jn.q
            @os.m
            public final Object invoke(@os.l sq.j<? super R> jVar, @os.l T[] tArr, @os.m um.d<? super l2> dVar) {
                kn.l0.P();
                b bVar = new b(this.$transform, dVar);
                bVar.L$0 = jVar;
                bVar.L$1 = tArr;
                return bVar.invokeSuspend(l2.f10208a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public r(sq.i<T>[] iVarArr, jn.q<? super sq.j<? super R>, ? super T[], ? super um.d<? super l2>, ? extends Object> qVar, um.d<? super r> dVar) {
            super(2, dVar);
            this.$flowArray = iVarArr;
            this.$transform = qVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            r rVar = new r(this.$flowArray, this.$transform, dVar);
            rVar.L$0 = obj;
            return rVar;
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                sq.j jVar = (sq.j) this.L$0;
                sq.i<T>[] iVarArr = this.$flowArray;
                kn.l0.P();
                a aVar2 = new a(this.$flowArray);
                kn.l0.P();
                b bVar = new b(this.$transform, null);
                this.label = 1;
                if (tq.m.a(jVar, iVarArr, aVar2, bVar, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
            }
            return l2.f10208a;
        }

        @os.m
        public final Object invokeSuspend$$forInline(@os.l Object obj) {
            sq.j jVar = (sq.j) this.L$0;
            sq.i<T>[] iVarArr = this.$flowArray;
            kn.l0.P();
            a aVar = new a(this.$flowArray);
            kn.l0.P();
            tq.m.a(jVar, iVarArr, aVar, new b(this.$transform, null), this);
            return l2.f10208a;
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l sq.j<? super R> jVar, @os.m um.d<? super l2> dVar) {
            return ((r) create(jVar, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    @r1({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineTransformUnsafe$1\n*L\n1#1,332:1\n*E\n"})
    @xm.f(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransformUnsafe$1", f = "Zip.kt", i = {}, l = {273}, m = "invokeSuspend", n = {}, s = {})
    public static final class s<R> extends xm.o implements jn.p<sq.j<? super R>, um.d<? super l2>, Object> {
        final /* synthetic */ sq.i<T>[] $flows;
        final /* synthetic */ jn.q<sq.j<? super R>, T[], um.d<? super l2>, Object> $transform;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: Add missing generic type declarations: [T] */
        @r1({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineTransformUnsafe$1$1\n*L\n1#1,332:1\n*E\n"})
        @xm.f(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransformUnsafe$1$1", f = "Zip.kt", i = {}, l = {273}, m = "invokeSuspend", n = {}, s = {})
        public static final class a<T> extends xm.o implements jn.q<sq.j<? super R>, T[], um.d<? super l2>, Object> {
            final /* synthetic */ jn.q<sq.j<? super R>, T[], um.d<? super l2>, Object> $transform;
            private /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public a(jn.q<? super sq.j<? super R>, ? super T[], ? super um.d<? super l2>, ? extends Object> qVar, um.d<? super a> dVar) {
                super(3, dVar);
                this.$transform = qVar;
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
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
            public final Object invokeSuspend(@os.l Object obj) {
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i10 = this.label;
                if (i10 == 0) {
                    d1.n(obj);
                    sq.j<? super R> jVar = (sq.j) this.L$0;
                    Object[] objArr = (Object[]) this.L$1;
                    jn.q<sq.j<? super R>, T[], um.d<? super l2>, Object> qVar = this.$transform;
                    this.L$0 = null;
                    this.label = 1;
                    if (qVar.invoke(jVar, objArr, this) == aVar) {
                        return aVar;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    d1.n(obj);
                }
                return l2.f10208a;
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @os.m
            public final Object invokeSuspend$$forInline(@os.l Object obj) {
                this.$transform.invoke((sq.j) this.L$0, (Object[]) this.L$1, this);
                return l2.f10208a;
            }

            @Override // jn.q
            @os.m
            public final Object invoke(@os.l sq.j<? super R> jVar, @os.l T[] tArr, @os.m um.d<? super l2> dVar) {
                kn.l0.P();
                a aVar = new a(this.$transform, dVar);
                aVar.L$0 = jVar;
                aVar.L$1 = tArr;
                return aVar.invokeSuspend(l2.f10208a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public s(sq.i<? extends T>[] iVarArr, jn.q<? super sq.j<? super R>, ? super T[], ? super um.d<? super l2>, ? extends Object> qVar, um.d<? super s> dVar) {
            super(2, dVar);
            this.$flows = iVarArr;
            this.$transform = qVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            s sVar = new s(this.$flows, this.$transform, dVar);
            sVar.L$0 = obj;
            return sVar;
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                sq.j jVar = (sq.j) this.L$0;
                sq.i<T>[] iVarArr = this.$flows;
                v vVar = v.INSTANCE;
                kn.l0.P();
                a aVar2 = new a(this.$transform, null);
                this.label = 1;
                if (tq.m.a(jVar, iVarArr, vVar, aVar2, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
            }
            return l2.f10208a;
        }

        @os.m
        public final Object invokeSuspend$$forInline(@os.l Object obj) {
            sq.j jVar = (sq.j) this.L$0;
            sq.i<T>[] iVarArr = this.$flows;
            v vVar = v.INSTANCE;
            kn.l0.P();
            tq.m.a(jVar, iVarArr, vVar, new a(this.$transform, null), this);
            return l2.f10208a;
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l sq.j<? super R> jVar, @os.m um.d<? super l2> dVar) {
            return ((s) create(jVar, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt\n*L\n1#1,113:1\n262#2,2:114\n*E\n"})
    public static final class t<R> implements sq.i<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ sq.i[] f15262a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ jn.p f15263b;

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
                return t.this.a(null, this);
            }
        }

        public t(sq.i[] iVarArr, jn.p pVar) {
            this.f15262a = iVarArr;
            this.f15263b = pVar;
        }

        @Override // sq.i
        @os.m
        public Object a(@os.l sq.j<? super R> jVar, @os.l um.d<? super l2> dVar) {
            sq.i[] iVarArr = this.f15262a;
            v vVar = v.INSTANCE;
            kn.l0.P();
            Object objA = tq.m.a(jVar, iVarArr, vVar, new u(this.f15263b, null), dVar);
            return objA == wm.a.COROUTINE_SUSPENDED ? objA : l2.f10208a;
        }

        @os.m
        public Object g(@os.l sq.j jVar, @os.l um.d dVar) {
            new a(dVar);
            sq.i[] iVarArr = this.f15262a;
            v vVar = v.INSTANCE;
            kn.l0.P();
            tq.m.a(jVar, iVarArr, vVar, new u(this.f15263b, null), dVar);
            return l2.f10208a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R, T] */
    @r1({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineUnsafe$1$1\n*L\n1#1,332:1\n*E\n"})
    @xm.f(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineUnsafe$1$1", f = "Zip.kt", i = {}, l = {262, 262}, m = "invokeSuspend", n = {}, s = {})
    public static final class u<R, T> extends xm.o implements jn.q<sq.j<? super R>, T[], um.d<? super l2>, Object> {
        final /* synthetic */ jn.p<T[], um.d<? super R>, Object> $transform;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public u(jn.p<? super T[], ? super um.d<? super R>, ? extends Object> pVar, um.d<? super u> dVar) {
            super(3, dVar);
            this.$transform = pVar;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
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
        public final Object invokeSuspend(@os.l Object obj) {
            sq.j jVar;
            sq.j jVar2;
            Object obj2 = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    sq.j jVar3 = (sq.j) this.L$0;
                    d1.n(obj);
                    jVar2 = jVar3;
                } else {
                    if (i10 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    d1.n(obj);
                }
                return l2.f10208a;
            }
            d1.n(obj);
            jVar = (sq.j) this.L$0;
            Object[] objArr = (Object[]) this.L$1;
            jn.p<T[], um.d<? super R>, Object> pVar = this.$transform;
            this.L$0 = jVar;
            this.label = 1;
            obj = pVar.invoke(objArr, this);
            if (obj == obj2) {
                jVar2 = jVar;
                return obj2;
            }
            jVar2 = jVar;
            this.L$0 = null;
            this.label = 2;
            if (jVar2.emit(obj, this) == obj2) {
                return obj2;
            }
            return l2.f10208a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @os.m
        public final Object invokeSuspend$$forInline(@os.l Object obj) {
            ((sq.j) this.L$0).emit(this.$transform.invoke((Object[]) this.L$1, this), this);
            return l2.f10208a;
        }

        @Override // jn.q
        @os.m
        public final Object invoke(@os.l sq.j<? super R> jVar, @os.l T[] tArr, @os.m um.d<? super l2> dVar) {
            kn.l0.P();
            u uVar = new u(this.$transform, dVar);
            uVar.L$0 = jVar;
            uVar.L$1 = tArr;
            return uVar.invokeSuspend(l2.f10208a);
        }
    }

    public static final class v extends kn.n0 implements jn.a {
        public static final v INSTANCE = new v();

        public v() {
            super(0);
        }

        @Override // jn.a
        @os.m
        public final Void invoke() {
            return null;
        }
    }

    public static final jn.a a() {
        return v.INSTANCE;
    }

    public static final <T, R> sq.i<R> b(Iterable<? extends sq.i<? extends T>> iterable, jn.p<? super T[], ? super um.d<? super R>, ? extends Object> pVar) {
        sq.i[] iVarArr = (sq.i[]) nm.h0.V5(iterable).toArray(new sq.i[0]);
        kn.l0.P();
        return new f(iVarArr, pVar);
    }

    @os.l
    public static final <T1, T2, R> sq.i<R> c(@os.l sq.i<? extends T1> iVar, @os.l sq.i<? extends T2> iVar2, @os.l jn.q<? super T1, ? super T2, ? super um.d<? super R>, ? extends Object> qVar) {
        return new d(iVar, iVar2, qVar);
    }

    @os.l
    public static final <T1, T2, T3, R> sq.i<R> d(@os.l sq.i<? extends T1> iVar, @os.l sq.i<? extends T2> iVar2, @os.l sq.i<? extends T3> iVar3, @lm.b @os.l jn.r<? super T1, ? super T2, ? super T3, ? super um.d<? super R>, ? extends Object> rVar) {
        return new a(new sq.i[]{iVar, iVar2, iVar3}, rVar);
    }

    @os.l
    public static final <T1, T2, T3, T4, R> sq.i<R> e(@os.l sq.i<? extends T1> iVar, @os.l sq.i<? extends T2> iVar2, @os.l sq.i<? extends T3> iVar3, @os.l sq.i<? extends T4> iVar4, @os.l jn.s<? super T1, ? super T2, ? super T3, ? super T4, ? super um.d<? super R>, ? extends Object> sVar) {
        return new b(new sq.i[]{iVar, iVar2, iVar3, iVar4}, sVar);
    }

    @os.l
    public static final <T1, T2, T3, T4, T5, R> sq.i<R> f(@os.l sq.i<? extends T1> iVar, @os.l sq.i<? extends T2> iVar2, @os.l sq.i<? extends T3> iVar3, @os.l sq.i<? extends T4> iVar4, @os.l sq.i<? extends T5> iVar5, @os.l jn.t<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super um.d<? super R>, ? extends Object> tVar) {
        return new c(new sq.i[]{iVar, iVar2, iVar3, iVar4, iVar5}, tVar);
    }

    public static final <T, R> sq.i<R> g(sq.i<? extends T>[] iVarArr, jn.p<? super T[], ? super um.d<? super R>, ? extends Object> pVar) {
        kn.l0.P();
        return new e(iVarArr, pVar);
    }

    public static final <T, R> sq.i<R> h(Iterable<? extends sq.i<? extends T>> iterable, @lm.b jn.q<? super sq.j<? super R>, ? super T[], ? super um.d<? super l2>, ? extends Object> qVar) {
        sq.i[] iVarArr = (sq.i[]) nm.h0.V5(iterable).toArray(new sq.i[0]);
        kn.l0.P();
        return new i0(new r(iVarArr, qVar, null));
    }

    @os.l
    public static final <T1, T2, R> sq.i<R> i(@os.l sq.i<? extends T1> iVar, @os.l sq.i<? extends T2> iVar2, @lm.b @os.l jn.r<? super sq.j<? super R>, ? super T1, ? super T2, ? super um.d<? super l2>, ? extends Object> rVar) {
        return new i0(new m(new sq.i[]{iVar, iVar2}, null, rVar));
    }

    @os.l
    public static final <T1, T2, T3, R> sq.i<R> j(@os.l sq.i<? extends T1> iVar, @os.l sq.i<? extends T2> iVar2, @os.l sq.i<? extends T3> iVar3, @lm.b @os.l jn.s<? super sq.j<? super R>, ? super T1, ? super T2, ? super T3, ? super um.d<? super l2>, ? extends Object> sVar) {
        return new i0(new n(new sq.i[]{iVar, iVar2, iVar3}, null, sVar));
    }

    @os.l
    public static final <T1, T2, T3, T4, R> sq.i<R> k(@os.l sq.i<? extends T1> iVar, @os.l sq.i<? extends T2> iVar2, @os.l sq.i<? extends T3> iVar3, @os.l sq.i<? extends T4> iVar4, @lm.b @os.l jn.t<? super sq.j<? super R>, ? super T1, ? super T2, ? super T3, ? super T4, ? super um.d<? super l2>, ? extends Object> tVar) {
        return new i0(new o(new sq.i[]{iVar, iVar2, iVar3, iVar4}, null, tVar));
    }

    @os.l
    public static final <T1, T2, T3, T4, T5, R> sq.i<R> l(@os.l sq.i<? extends T1> iVar, @os.l sq.i<? extends T2> iVar2, @os.l sq.i<? extends T3> iVar3, @os.l sq.i<? extends T4> iVar4, @os.l sq.i<? extends T5> iVar5, @lm.b @os.l jn.u<? super sq.j<? super R>, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super um.d<? super l2>, ? extends Object> uVar) {
        return new i0(new p(new sq.i[]{iVar, iVar2, iVar3, iVar4, iVar5}, null, uVar));
    }

    public static final <T, R> sq.i<R> m(sq.i<? extends T>[] iVarArr, @lm.b jn.q<? super sq.j<? super R>, ? super T[], ? super um.d<? super l2>, ? extends Object> qVar) {
        kn.l0.P();
        return new i0(new q(iVarArr, qVar, null));
    }

    public static final <T, R> sq.i<R> n(sq.i<? extends T>[] iVarArr, @lm.b jn.q<? super sq.j<? super R>, ? super T[], ? super um.d<? super l2>, ? extends Object> qVar) {
        kn.l0.P();
        return new i0(new s(iVarArr, qVar, null));
    }

    public static final <T, R> sq.i<R> o(sq.i<? extends T>[] iVarArr, jn.p<? super T[], ? super um.d<? super R>, ? extends Object> pVar) {
        kn.l0.P();
        return new t(iVarArr, pVar);
    }

    @in.i(name = "flowCombine")
    @os.l
    public static final <T1, T2, R> sq.i<R> p(@os.l sq.i<? extends T1> iVar, @os.l sq.i<? extends T2> iVar2, @os.l jn.q<? super T1, ? super T2, ? super um.d<? super R>, ? extends Object> qVar) {
        return new d(iVar, iVar2, qVar);
    }

    @in.i(name = "flowCombineTransform")
    @os.l
    public static final <T1, T2, R> sq.i<R> q(@os.l sq.i<? extends T1> iVar, @os.l sq.i<? extends T2> iVar2, @lm.b @os.l jn.r<? super sq.j<? super R>, ? super T1, ? super T2, ? super um.d<? super l2>, ? extends Object> rVar) {
        return new i0(new l(new sq.i[]{iVar, iVar2}, null, rVar));
    }

    public static final <T> jn.a<T[]> r() {
        return v.INSTANCE;
    }

    @os.l
    public static final <T1, T2, R> sq.i<R> s(@os.l sq.i<? extends T1> iVar, @os.l sq.i<? extends T2> iVar2, @os.l jn.q<? super T1, ? super T2, ? super um.d<? super R>, ? extends Object> qVar) {
        return new tq.m.b(iVar2, iVar, qVar);
    }
}
