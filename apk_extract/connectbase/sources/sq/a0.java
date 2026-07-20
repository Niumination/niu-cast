package sq;

import kn.k1;
import kn.r1;
import lm.d1;
import lm.l2;
import nq.r2;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nShare.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Share.kt\nkotlinx/coroutines/flow/FlowKt__ShareKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,426:1\n1#2:427\n*E\n"})
public final /* synthetic */ class a0 {

    @xm.f(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1", f = "Share.kt", i = {}, l = {214, 218, 219, 225}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends xm.o implements jn.p<nq.s0, um.d<? super l2>, Object> {
        final /* synthetic */ T $initialValue;
        final /* synthetic */ e0<T> $shared;
        final /* synthetic */ p0 $started;
        final /* synthetic */ i<T> $upstream;
        int label;

        /* JADX INFO: renamed from: sq.a0$a$a, reason: collision with other inner class name */
        @xm.f(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1", f = "Share.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C0376a extends xm.o implements jn.p<Integer, um.d<? super Boolean>, Object> {
            /* synthetic */ int I$0;
            int label;

            public C0376a(um.d<? super C0376a> dVar) {
                super(2, dVar);
            }

            @Override // xm.a
            @os.l
            public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
                C0376a c0376a = new C0376a(dVar);
                c0376a.I$0 = ((Number) obj).intValue();
                return c0376a;
            }

            @os.m
            public final Object invoke(int i10, @os.m um.d<? super Boolean> dVar) {
                return ((C0376a) create(Integer.valueOf(i10), dVar)).invokeSuspend(l2.f10208a);
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
                return Boolean.valueOf(this.I$0 > 0);
            }

            @Override // jn.p
            public /* bridge */ /* synthetic */ Object invoke(Integer num, um.d<? super Boolean> dVar) {
                return invoke(num.intValue(), dVar);
            }
        }

        @xm.f(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2", f = "Share.kt", i = {}, l = {227}, m = "invokeSuspend", n = {}, s = {})
        public static final class b extends xm.o implements jn.p<n0, um.d<? super l2>, Object> {
            final /* synthetic */ T $initialValue;
            final /* synthetic */ e0<T> $shared;
            final /* synthetic */ i<T> $upstream;
            /* synthetic */ Object L$0;
            int label;

            /* JADX INFO: renamed from: sq.a0$a$b$a, reason: collision with other inner class name */
            public /* synthetic */ class C0377a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f15201a;

                static {
                    int[] iArr = new int[n0.values().length];
                    try {
                        iArr[n0.START.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[n0.STOP.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[n0.STOP_AND_RESET_REPLAY_CACHE.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    f15201a = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public b(i<? extends T> iVar, e0<T> e0Var, T t10, um.d<? super b> dVar) {
                super(2, dVar);
                this.$upstream = iVar;
                this.$shared = e0Var;
                this.$initialValue = t10;
            }

            @Override // xm.a
            @os.l
            public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
                b bVar = new b(this.$upstream, this.$shared, this.$initialValue, dVar);
                bVar.L$0 = obj;
                return bVar;
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
            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i10 = this.label;
                if (i10 == 0) {
                    d1.n(obj);
                    int i11 = C0377a.f15201a[((n0) this.L$0).ordinal()];
                    if (i11 == 1) {
                        i<T> iVar = this.$upstream;
                        Object obj2 = this.$shared;
                        this.label = 1;
                        if (iVar.a(obj2, this) == aVar) {
                            return aVar;
                        }
                    } else if (i11 == 3) {
                        T t10 = this.$initialValue;
                        if (t10 == l0.f15308a) {
                            this.$shared.f();
                        } else {
                            this.$shared.b(t10);
                        }
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
            public final Object invoke(@os.l n0 n0Var, @os.m um.d<? super l2> dVar) {
                return ((b) create(n0Var, dVar)).invokeSuspend(l2.f10208a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(p0 p0Var, i<? extends T> iVar, e0<T> e0Var, T t10, um.d<? super a> dVar) {
            super(2, dVar);
            this.$started = p0Var;
            this.$upstream = iVar;
            this.$shared = e0Var;
            this.$initialValue = t10;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            return new a(this.$started, this.$upstream, this.$shared, this.$initialValue, dVar);
        }

        /* JADX WARN: Code duplicated, block: B:25:0x0068 A[RETURN] */
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
        public final Object invokeSuspend(@os.l Object obj) {
            i<T> iVar;
            Object obj2;
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 == 2) {
                        d1.n(obj);
                        iVar = this.$upstream;
                        obj2 = this.$shared;
                        this.label = 3;
                        if (iVar.a(obj2, this) == aVar) {
                            return aVar;
                        }
                    } else if (i10 != 3 && i10 != 4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
                d1.n(obj);
            } else {
                d1.n(obj);
                p0 p0Var = this.$started;
                p0.a aVar2 = p0.f15321a;
                aVar2.getClass();
                if (p0Var == p0.a.f15323b) {
                    i<T> iVar2 = this.$upstream;
                    Object obj3 = this.$shared;
                    this.label = 1;
                    if (iVar2.a(obj3, this) == aVar) {
                        return aVar;
                    }
                } else {
                    p0 p0Var2 = this.$started;
                    aVar2.getClass();
                    if (p0Var2 == p0.a.f15324c) {
                        u0<Integer> u0VarD = this.$shared.d();
                        C0376a c0376a = new C0376a(null);
                        this.label = 2;
                        if (z.a(u0VarD, c0376a, this) == aVar) {
                            return aVar;
                        }
                        iVar = this.$upstream;
                        obj2 = this.$shared;
                        this.label = 3;
                        if (iVar.a(obj2, this) == aVar) {
                            return aVar;
                        }
                    } else {
                        i iVarA = s.a(this.$started.a(this.$shared.d()));
                        b bVar = new b(this.$upstream, this.$shared, this.$initialValue, null);
                        this.label = 4;
                        if (n.f(iVarA, bVar, this) == aVar) {
                            return aVar;
                        }
                    }
                }
            }
            return l2.f10208a;
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l nq.s0 s0Var, @os.m um.d<? super l2> dVar) {
            return ((a) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @xm.f(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharingDeferred$1", f = "Share.kt", i = {}, l = {340}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends xm.o implements jn.p<nq.s0, um.d<? super l2>, Object> {
        final /* synthetic */ nq.y<u0<T>> $result;
        final /* synthetic */ i<T> $upstream;
        private /* synthetic */ Object L$0;
        int label;

        @r1({"SMAP\nShare.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Share.kt\nkotlinx/coroutines/flow/FlowKt__ShareKt$launchSharingDeferred$1$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,426:1\n1#2:427\n*E\n"})
        public static final class a<T> implements j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ k1.h<f0<T>> f15202a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ nq.s0 f15203b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ nq.y<u0<T>> f15204c;

            public a(k1.h<f0<T>> hVar, nq.s0 s0Var, nq.y<u0<T>> yVar) {
                this.f15202a = hVar;
                this.f15203b = s0Var;
                this.f15204c = yVar;
            }

            /* JADX WARN: Type inference failed for: r3v1, types: [T, sq.f0, sq.u0] */
            @Override // sq.j
            @os.m
            public final Object emit(T t10, @os.l um.d<? super l2> dVar) {
                l2 l2Var;
                f0<T> f0Var = this.f15202a.element;
                if (f0Var != null) {
                    f0Var.setValue(t10);
                    l2Var = l2.f10208a;
                } else {
                    l2Var = null;
                }
                if (l2Var == null) {
                    nq.s0 s0Var = this.f15203b;
                    k1.h<f0<T>> hVar = this.f15202a;
                    nq.y<u0<T>> yVar = this.f15204c;
                    ?? r10 = (T) w0.a(t10);
                    yVar.l0(new h0(r10, r2.z(s0Var.getCoroutineContext())));
                    hVar.element = r10;
                }
                return l2.f10208a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(i<? extends T> iVar, nq.y<u0<T>> yVar, um.d<? super b> dVar) {
            super(2, dVar);
            this.$upstream = iVar;
            this.$result = yVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            b bVar = new b(this.$upstream, this.$result, dVar);
            bVar.L$0 = obj;
            return bVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v4, types: [java.lang.Object, lm.l2] */
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
        /*  JADX ERROR: JadxRuntimeException in pass: FinishTypeInference
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r4v1 boolean
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
            */
        @Override // xm.a
        @os.m
        public final java.lang.Object invokeSuspend(@os.l java.lang.Object r7) {
            /*
                r6 = this;
                wm.a r0 = wm.a.COROUTINE_SUSPENDED
                int r1 = r6.label
                r2 = 1
                if (r1 == 0) goto L17
                if (r1 != r2) goto Lf
                lm.d1.n(r7)     // Catch: java.lang.Throwable -> Ld
                goto L35
            Ld:
                r7 = move-exception
                goto L38
            Lf:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L17:
                lm.d1.n(r7)
                java.lang.Object r7 = r6.L$0
                nq.s0 r7 = (nq.s0) r7
                kn.k1$h r1 = new kn.k1$h     // Catch: java.lang.Throwable -> Ld
                r1.<init>()     // Catch: java.lang.Throwable -> Ld
                sq.i<T> r3 = r6.$upstream     // Catch: java.lang.Throwable -> Ld
                sq.a0$b$a r4 = new sq.a0$b$a     // Catch: java.lang.Throwable -> Ld
                nq.y<sq.u0<T>> r5 = r6.$result     // Catch: java.lang.Throwable -> Ld
                r4.<init>(r1, r7, r5)     // Catch: java.lang.Throwable -> Ld
                r6.label = r2     // Catch: java.lang.Throwable -> Ld
                java.lang.Object r6 = r3.a(r4, r6)     // Catch: java.lang.Throwable -> Ld
                if (r6 != r0) goto L35
                return r0
            L35:
                lm.l2 r6 = lm.l2.f10208a
                return r6
            L38:
                nq.y<sq.u0<T>> r6 = r6.$result
                r6.k(r7)
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: sq.a0.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l nq.s0 s0Var, @os.m um.d<? super l2> dVar) {
            return ((b) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @os.l
    public static final <T> j0<T> a(@os.l e0<T> e0Var) {
        return new g0(e0Var, null);
    }

    @os.l
    public static final <T> u0<T> b(@os.l f0<T> f0Var) {
        return new h0(f0Var, null);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0030  */
    public static final <T> o0<T> c(i<? extends T> iVar, int i10) {
        tq.e eVar;
        i<T> iVarK;
        pq.l.f13292l.getClass();
        int i11 = pq.l.b.f13306h;
        if (i10 >= i11) {
            i11 = i10;
        }
        int i12 = i11 - i10;
        if (!(iVar instanceof tq.e) || (iVarK = (eVar = (tq.e) iVar).k()) == null) {
            return new o0<>(iVar, i12, pq.i.SUSPEND, um.i.INSTANCE);
        }
        int i13 = eVar.f16030b;
        if (i13 != -3 && i13 != -2 && i13 != 0) {
            i12 = i13;
        } else if (eVar.f16031c == pq.i.SUSPEND) {
            if (i13 == 0) {
                i12 = 0;
            }
        } else if (i10 == 0) {
            i12 = 1;
        } else {
            i12 = 0;
        }
        return new o0<>(iVarK, i12, eVar.f16031c, eVar.f16029a);
    }

    public static final <T> nq.l2 d(nq.s0 s0Var, um.g gVar, i<? extends T> iVar, e0<T> e0Var, p0 p0Var, T t10) {
        p0.f15321a.getClass();
        return nq.k.e(s0Var, gVar, kn.l0.g(p0Var, p0.a.f15323b) ? nq.u0.DEFAULT : nq.u0.UNDISPATCHED, new a(p0Var, iVar, e0Var, t10, null));
    }

    public static final <T> void e(nq.s0 s0Var, um.g gVar, i<? extends T> iVar, nq.y<u0<T>> yVar) {
        nq.k.f(s0Var, gVar, null, new b(iVar, yVar, null), 2, null);
    }

    @os.l
    public static final <T> j0<T> f(@os.l j0<? extends T> j0Var, @os.l jn.p<? super j<? super T>, ? super um.d<? super l2>, ? extends Object> pVar) {
        return new z0(j0Var, pVar);
    }

    @os.l
    public static final <T> j0<T> g(@os.l i<? extends T> iVar, @os.l nq.s0 s0Var, @os.l p0 p0Var, int i10) {
        o0 o0VarC = c(iVar, i10);
        e0 e0VarA = l0.a(i10, o0VarC.f15318b, o0VarC.f15319c);
        return new g0(e0VarA, d(s0Var, o0VarC.f15320d, o0VarC.f15317a, e0VarA, p0Var, l0.f15308a));
    }

    public static j0 h(i iVar, nq.s0 s0Var, p0 p0Var, int i10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        return g(iVar, s0Var, p0Var, i10);
    }

    @os.m
    public static final <T> Object i(@os.l i<? extends T> iVar, @os.l nq.s0 s0Var, @os.l um.d<? super u0<? extends T>> dVar) {
        o0 o0VarC = c(iVar, 1);
        nq.y yVarC = nq.a0.c(null, 1, null);
        e(s0Var, o0VarC.f15320d, o0VarC.f15317a, yVarC);
        return yVarC.O0(dVar);
    }

    @os.l
    public static final <T> u0<T> j(@os.l i<? extends T> iVar, @os.l nq.s0 s0Var, @os.l p0 p0Var, T t10) {
        o0 o0VarC = c(iVar, 1);
        f0 f0VarA = w0.a(t10);
        return new h0(f0VarA, d(s0Var, o0VarC.f15320d, o0VarC.f15317a, f0VarA, p0Var, t10));
    }
}
