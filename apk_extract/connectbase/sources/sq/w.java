package sq;

import kn.r1;
import lm.d1;
import lm.l2;
import nq.a2;
import nq.b2;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nMerge.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Merge.kt\nkotlinx/coroutines/flow/FlowKt__MergeKt\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 4 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,218:1\n53#2:219\n55#2:223\n53#2:224\n55#2:228\n50#3:220\n55#3:222\n50#3:225\n55#3:227\n107#4:221\n107#4:226\n107#4:229\n1#5:230\n*S KotlinDebug\n*F\n+ 1 Merge.kt\nkotlinx/coroutines/flow/FlowKt__MergeKt\n*L\n47#1:219\n47#1:223\n74#1:224\n74#1:228\n47#1:220\n47#1:222\n74#1:225\n74#1:227\n47#1:221\n74#1:226\n82#1:229\n*E\n"})
public final /* synthetic */ class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f15380a = vq.z0.a(k.f15282a, 16, 1, Integer.MAX_VALUE);

    /* JADX INFO: Add missing generic type declarations: [R] */
    @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n*L\n1#1,113:1\n51#2,5:114\n*E\n"})
    public static final class a<R> implements i<i<? extends R>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f15381a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ jn.p f15382b;

        /* JADX INFO: renamed from: sq.w$a$a, reason: collision with other inner class name */
        @r1({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,222:1\n54#2:223\n*E\n"})
        public static final class C0398a<T> implements j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ j f15383a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ jn.p f15384b;

            /* JADX INFO: renamed from: sq.w$a$a$a, reason: collision with other inner class name */
            @r1({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
            @xm.f(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2", f = "Merge.kt", i = {}, l = {223, 223}, m = "emit", n = {}, s = {})
            public static final class C0399a extends xm.d {
                Object L$0;
                int label;
                /* synthetic */ Object result;

                public C0399a(um.d dVar) {
                    super(dVar);
                }

                @Override // xm.a
                @os.m
                public final Object invokeSuspend(@os.l Object obj) {
                    this.result = obj;
                    this.label |= Integer.MIN_VALUE;
                    return C0398a.this.emit(null, this);
                }
            }

            public C0398a(j jVar, jn.p pVar) {
                this.f15383a = jVar;
                this.f15384b = pVar;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            @Override // sq.j
            @os.m
            public final Object emit(Object obj, @os.l um.d dVar) {
                C0399a c0399a;
                j jVar;
                if (dVar instanceof C0399a) {
                    c0399a = (C0399a) dVar;
                    int i10 = c0399a.label;
                    if ((i10 & Integer.MIN_VALUE) != 0) {
                        c0399a.label = i10 - Integer.MIN_VALUE;
                    } else {
                        c0399a = new C0399a(dVar);
                    }
                } else {
                    c0399a = new C0399a(dVar);
                }
                Object obj2 = c0399a.result;
                Object obj3 = wm.a.COROUTINE_SUSPENDED;
                int i11 = c0399a.label;
                if (i11 != 0) {
                    if (i11 == 1) {
                        j jVar2 = (j) c0399a.L$0;
                        d1.n(obj2);
                        jVar = jVar2;
                    } else {
                        if (i11 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        d1.n(obj2);
                    }
                    return l2.f10208a;
                }
                d1.n(obj2);
                j jVar3 = this.f15383a;
                jn.p pVar = this.f15384b;
                c0399a.L$0 = jVar3;
                c0399a.label = 1;
                Object objInvoke = pVar.invoke(obj, c0399a);
                if (objInvoke == obj3) {
                    return obj3;
                }
                obj2 = objInvoke;
                jVar = jVar3;
                c0399a.L$0 = null;
                c0399a.label = 2;
                if (jVar.emit(obj2, c0399a) == obj3) {
                    return obj3;
                }
                return l2.f10208a;
            }
        }

        public a(i iVar, jn.p pVar) {
            this.f15381a = iVar;
            this.f15382b = pVar;
        }

        @Override // sq.i
        @os.m
        public Object a(@os.l j jVar, @os.l um.d dVar) {
            Object objA = this.f15381a.a(new C0398a(jVar, this.f15382b), dVar);
            return objA == wm.a.COROUTINE_SUSPENDED ? objA : l2.f10208a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R, T] */
    @r1({"SMAP\nMerge.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Merge.kt\nkotlinx/coroutines/flow/FlowKt__MergeKt$flatMapLatest$1\n*L\n1#1,218:1\n*E\n"})
    @xm.f(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapLatest$1", f = "Merge.kt", i = {}, l = {193, 193}, m = "invokeSuspend", n = {}, s = {})
    public static final class b<R, T> extends xm.o implements jn.q<j<? super R>, T, um.d<? super l2>, Object> {
        final /* synthetic */ jn.p<T, um.d<? super i<? extends R>>, Object> $transform;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(jn.p<? super T, ? super um.d<? super i<? extends R>>, ? extends Object> pVar, um.d<? super b> dVar) {
            super(3, dVar);
            this.$transform = pVar;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to sq.w$b<R, T> for r5v4 'this'  java.lang.Object
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
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L20
                if (r1 == r3) goto L18
                if (r1 != r2) goto L10
                lm.d1.n(r6)
                goto L45
            L10:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L18:
                java.lang.Object r1 = r5.L$0
                sq.j r1 = (sq.j) r1
                lm.d1.n(r6)
                goto L37
            L20:
                lm.d1.n(r6)
                java.lang.Object r6 = r5.L$0
                r1 = r6
                sq.j r1 = (sq.j) r1
                java.lang.Object r6 = r5.L$1
                jn.p<T, um.d<? super sq.i<? extends R>>, java.lang.Object> r4 = r5.$transform
                r5.L$0 = r1
                r5.label = r3
                java.lang.Object r6 = r4.invoke(r6, r5)
                if (r6 != r0) goto L37
                return r0
            L37:
                sq.i r6 = (sq.i) r6
                r3 = 0
                r5.L$0 = r3
                r5.label = r2
                java.lang.Object r5 = sq.n.g(r1, r6, r5)
                if (r5 != r0) goto L45
                return r0
            L45:
                lm.l2 r5 = lm.l2.f10208a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: sq.w.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to sq.w$b<R, T> for r2v2 'this'  java.lang.Object
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @os.m
        public final java.lang.Object invokeSuspend$$forInline(@os.l java.lang.Object r3) {
            /*
                r2 = this;
                java.lang.Object r3 = r2.L$0
                sq.j r3 = (sq.j) r3
                java.lang.Object r0 = r2.L$1
                jn.p<T, um.d<? super sq.i<? extends R>>, java.lang.Object> r1 = r2.$transform
                java.lang.Object r0 = r1.invoke(r0, r2)
                sq.i r0 = (sq.i) r0
                sq.n.g(r3, r0, r2)
                lm.l2 r2 = lm.l2.f10208a
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: sq.w.b.invokeSuspend$$forInline(java.lang.Object):java.lang.Object");
        }

        @Override // jn.q
        @os.m
        public final Object invoke(@os.l j<? super R> jVar, T t10, @os.m um.d<? super l2> dVar) {
            b bVar = new b(this.$transform, dVar);
            bVar.L$0 = jVar;
            bVar.L$1 = t10;
            return bVar.invokeSuspend(l2.f10208a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n*L\n1#1,113:1\n51#2,5:114\n*E\n"})
    public static final class c<R> implements i<i<? extends R>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f15385a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ jn.p f15386b;

        @r1({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,222:1\n54#2:223\n*E\n"})
        public static final class a<T> implements j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ j f15387a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ jn.p f15388b;

            /* JADX INFO: renamed from: sq.w$c$a$a, reason: collision with other inner class name */
            @r1({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
            @xm.f(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2", f = "Merge.kt", i = {}, l = {223, 223}, m = "emit", n = {}, s = {})
            public static final class C0400a extends xm.d {
                Object L$0;
                int label;
                /* synthetic */ Object result;

                public C0400a(um.d dVar) {
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

            public a(j jVar, jn.p pVar) {
                this.f15387a = jVar;
                this.f15388b = pVar;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            @Override // sq.j
            @os.m
            public final Object emit(Object obj, @os.l um.d dVar) {
                C0400a c0400a;
                j jVar;
                if (dVar instanceof C0400a) {
                    c0400a = (C0400a) dVar;
                    int i10 = c0400a.label;
                    if ((i10 & Integer.MIN_VALUE) != 0) {
                        c0400a.label = i10 - Integer.MIN_VALUE;
                    } else {
                        c0400a = new C0400a(dVar);
                    }
                } else {
                    c0400a = new C0400a(dVar);
                }
                Object obj2 = c0400a.result;
                Object obj3 = wm.a.COROUTINE_SUSPENDED;
                int i11 = c0400a.label;
                if (i11 != 0) {
                    if (i11 == 1) {
                        j jVar2 = (j) c0400a.L$0;
                        d1.n(obj2);
                        jVar = jVar2;
                    } else {
                        if (i11 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        d1.n(obj2);
                    }
                    return l2.f10208a;
                }
                d1.n(obj2);
                j jVar3 = this.f15387a;
                jn.p pVar = this.f15388b;
                c0400a.L$0 = jVar3;
                c0400a.label = 1;
                Object objInvoke = pVar.invoke(obj, c0400a);
                if (objInvoke == obj3) {
                    return obj3;
                }
                obj2 = objInvoke;
                jVar = jVar3;
                c0400a.L$0 = null;
                c0400a.label = 2;
                if (jVar.emit(obj2, c0400a) == obj3) {
                    return obj3;
                }
                return l2.f10208a;
            }
        }

        public c(i iVar, jn.p pVar) {
            this.f15385a = iVar;
            this.f15386b = pVar;
        }

        @Override // sq.i
        @os.m
        public Object a(@os.l j jVar, @os.l um.d dVar) {
            Object objA = this.f15385a.a(new a(jVar, this.f15386b), dVar);
            return objA == wm.a.COROUTINE_SUSPENDED ? objA : l2.f10208a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @r1({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Merge.kt\nkotlinx/coroutines/flow/FlowKt__MergeKt\n*L\n1#1,113:1\n83#2,2:114\n*E\n"})
    public static final class d<T> implements i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f15389a;

        public d(i iVar) {
            this.f15389a = iVar;
        }

        @Override // sq.i
        @os.m
        public Object a(@os.l j<? super T> jVar, @os.l um.d<? super l2> dVar) {
            Object objA = this.f15389a.a(new e(jVar), dVar);
            return objA == wm.a.COROUTINE_SUSPENDED ? objA : l2.f10208a;
        }
    }

    public static final class e<T> implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j<T> f15390a;

        @xm.f(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$flattenConcat$1$1", f = "Merge.kt", i = {}, l = {83}, m = "emit", n = {}, s = {})
        public static final class a extends xm.d {
            int label;
            /* synthetic */ Object result;
            final /* synthetic */ e<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public a(e<? super T> eVar, um.d<? super a> dVar) {
                super(dVar);
                this.this$0 = eVar;
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
        public e(j<? super T> jVar) {
            this.f15390a = jVar;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // sq.j
        @os.m
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(@os.l i<? extends T> iVar, @os.l um.d<? super l2> dVar) {
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
                j<T> jVar = this.f15390a;
                aVar.label = 1;
                if (n.g(jVar, iVar, aVar) == aVar2) {
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

    /* JADX INFO: Add missing generic type declarations: [R, T] */
    @xm.f(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$mapLatest$1", f = "Merge.kt", i = {}, l = {217, 217}, m = "invokeSuspend", n = {}, s = {})
    public static final class f<R, T> extends xm.o implements jn.q<j<? super R>, T, um.d<? super l2>, Object> {
        final /* synthetic */ jn.p<T, um.d<? super R>, Object> $transform;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public f(jn.p<? super T, ? super um.d<? super R>, ? extends Object> pVar, um.d<? super f> dVar) {
            super(3, dVar);
            this.$transform = pVar;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to sq.w$f<R, T> for r5v4 'this'  java.lang.Object
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
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L20
                if (r1 == r3) goto L18
                if (r1 != r2) goto L10
                lm.d1.n(r6)
                goto L43
            L10:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L18:
                java.lang.Object r1 = r5.L$0
                sq.j r1 = (sq.j) r1
                lm.d1.n(r6)
                goto L37
            L20:
                lm.d1.n(r6)
                java.lang.Object r6 = r5.L$0
                r1 = r6
                sq.j r1 = (sq.j) r1
                java.lang.Object r6 = r5.L$1
                jn.p<T, um.d<? super R>, java.lang.Object> r4 = r5.$transform
                r5.L$0 = r1
                r5.label = r3
                java.lang.Object r6 = r4.invoke(r6, r5)
                if (r6 != r0) goto L37
                return r0
            L37:
                r3 = 0
                r5.L$0 = r3
                r5.label = r2
                java.lang.Object r5 = r1.emit(r6, r5)
                if (r5 != r0) goto L43
                return r0
            L43:
                lm.l2 r5 = lm.l2.f10208a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: sq.w.f.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // jn.q
        @os.m
        public final Object invoke(@os.l j<? super R> jVar, T t10, @os.m um.d<? super l2> dVar) {
            f fVar = new f(this.$transform, dVar);
            fVar.L$0 = jVar;
            fVar.L$1 = t10;
            return fVar.invokeSuspend(l2.f10208a);
        }
    }

    @a2
    @os.l
    public static final <T, R> i<R> a(@os.l i<? extends T> iVar, @os.l jn.p<? super T, ? super um.d<? super i<? extends R>>, ? extends Object> pVar) {
        return e(new a(iVar, pVar));
    }

    @a2
    @os.l
    public static final <T, R> i<R> b(@os.l i<? extends T> iVar, @lm.b @os.l jn.p<? super T, ? super um.d<? super i<? extends R>>, ? extends Object> pVar) {
        return n(iVar, new b(pVar, null));
    }

    @a2
    @os.l
    public static final <T, R> i<R> c(@os.l i<? extends T> iVar, int i10, @os.l jn.p<? super T, ? super um.d<? super i<? extends R>>, ? extends Object> pVar) {
        return f(new c(iVar, pVar), i10);
    }

    public static i d(i iVar, int i10, jn.p pVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = f15380a;
        }
        return c(iVar, i10, pVar);
    }

    @a2
    @os.l
    public static final <T> i<T> e(@os.l i<? extends i<? extends T>> iVar) {
        return new d(iVar);
    }

    @a2
    @os.l
    public static final <T> i<T> f(@os.l i<? extends i<? extends T>> iVar, int i10) {
        if (i10 <= 0) {
            throw new IllegalArgumentException(h.a.a("Expected positive concurrency level, but had ", i10).toString());
        }
        if (i10 == 1) {
            return e(iVar);
        }
        return new tq.g(iVar, i10, null, 0, null, 28, null);
    }

    public static i g(i iVar, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = f15380a;
        }
        return f(iVar, i10);
    }

    public static final int h() {
        return f15380a;
    }

    @b2
    public static /* synthetic */ void i() {
    }

    @b2
    public static /* synthetic */ void j() {
    }

    @a2
    @os.l
    public static final <T, R> i<R> k(@os.l i<? extends T> iVar, @lm.b @os.l jn.p<? super T, ? super um.d<? super R>, ? extends Object> pVar) {
        return n(iVar, new f(pVar, null));
    }

    @os.l
    public static final <T> i<T> l(@os.l Iterable<? extends i<? extends T>> iterable) {
        return new tq.k(iterable, null, 0, null, 14, null);
    }

    @os.l
    public static final <T> i<T> m(@os.l i<? extends T>... iVarArr) {
        return l(nm.r.B5(iVarArr));
    }

    @a2
    @os.l
    public static final <T, R> i<R> n(@os.l i<? extends T> iVar, @lm.b @os.l jn.q<? super j<? super R>, ? super T, ? super um.d<? super l2>, ? extends Object> qVar) {
        return new tq.j(qVar, iVar, null, 0, null, 28, null);
    }
}
