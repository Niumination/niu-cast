package wm;

import jn.l;
import jn.p;
import jn.q;
import kn.l0;
import kn.r1;
import kn.u1;
import lm.d1;
import lm.f1;
import lm.l2;
import lm.z0;
import os.m;
import um.i;
import xm.j;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nIntrinsicsJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IntrinsicsJvm.kt\nkotlin/coroutines/intrinsics/IntrinsicsKt__IntrinsicsJvmKt\n*L\n1#1,269:1\n204#1,4:270\n225#1:274\n204#1,4:275\n225#1:279\n*S KotlinDebug\n*F\n+ 1 IntrinsicsJvm.kt\nkotlin/coroutines/intrinsics/IntrinsicsKt__IntrinsicsJvmKt\n*L\n130#1:270,4\n130#1:274\n165#1:275,4\n165#1:279\n*E\n"})
public class c {

    @r1({"SMAP\nIntrinsicsJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IntrinsicsJvm.kt\nkotlin/coroutines/intrinsics/IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$1\n*L\n1#1,269:1\n*E\n"})
    public static final class a extends j {
        final /* synthetic */ l<um.d<? super T>, Object> $block;
        private int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(um.d<? super T> dVar, l<? super um.d<? super T>, ? extends Object> lVar) {
            super(dVar);
            this.$block = lVar;
            l0.n(dVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to wm.c$a for r2v2 'this'  java.lang.Object
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // xm.a
        @os.m
        public java.lang.Object invokeSuspend(@os.l java.lang.Object r3) {
            /*
                r2 = this;
                int r0 = r2.label
                r1 = 1
                if (r0 == 0) goto L16
                if (r0 != r1) goto Le
                r0 = 2
                r2.label = r0
                lm.d1.n(r3)
                goto L21
            Le:
                java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
                java.lang.String r3 = "This coroutine had already completed"
                r2.<init>(r3)
                throw r2
            L16:
                r2.label = r1
                lm.d1.n(r3)
                jn.l<um.d<? super T>, java.lang.Object> r3 = r2.$block
                java.lang.Object r3 = r3.invoke(r2)
            L21:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: wm.c.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @r1({"SMAP\nIntrinsicsJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IntrinsicsJvm.kt\nkotlin/coroutines/intrinsics/IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$2\n*L\n1#1,269:1\n*E\n"})
    public static final class b extends xm.d {
        final /* synthetic */ l<um.d<? super T>, Object> $block;
        private int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(um.d<? super T> dVar, um.g gVar, l<? super um.d<? super T>, ? extends Object> lVar) {
            super(dVar, gVar);
            this.$block = lVar;
            l0.n(dVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to wm.c$b for r2v2 'this'  java.lang.Object
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // xm.a
        @os.m
        public java.lang.Object invokeSuspend(@os.l java.lang.Object r3) {
            /*
                r2 = this;
                int r0 = r2.label
                r1 = 1
                if (r0 == 0) goto L16
                if (r0 != r1) goto Le
                r0 = 2
                r2.label = r0
                lm.d1.n(r3)
                goto L21
            Le:
                java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
                java.lang.String r3 = "This coroutine had already completed"
                r2.<init>(r3)
                throw r2
            L16:
                r2.label = r1
                lm.d1.n(r3)
                jn.l<um.d<? super T>, java.lang.Object> r3 = r2.$block
                java.lang.Object r3 = r3.invoke(r2)
            L21:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: wm.c.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: wm.c$c, reason: collision with other inner class name */
    @r1({"SMAP\nIntrinsicsJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IntrinsicsJvm.kt\nkotlin/coroutines/intrinsics/IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$1\n+ 2 IntrinsicsJvm.kt\nkotlin/coroutines/intrinsics/IntrinsicsKt__IntrinsicsJvmKt\n*L\n1#1,269:1\n131#2:270\n*E\n"})
    public static final class C0485c extends j {
        final /* synthetic */ l $this_createCoroutineUnintercepted$inlined;
        private int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0485c(um.d dVar, l lVar) {
            super(dVar);
            this.$this_createCoroutineUnintercepted$inlined = lVar;
            l0.n(dVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        @Override // xm.a
        @m
        public Object invokeSuspend(@os.l Object obj) {
            int i10 = this.label;
            if (i10 == 0) {
                this.label = 1;
                d1.n(obj);
                l0.n(this.$this_createCoroutineUnintercepted$inlined, "null cannot be cast to non-null type kotlin.Function1<kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$0>, kotlin.Any?>");
                return ((l) u1.q(this.$this_createCoroutineUnintercepted$inlined, 1)).invoke(this);
            }
            if (i10 != 1) {
                throw new IllegalStateException("This coroutine had already completed");
            }
            this.label = 2;
            d1.n(obj);
            return obj;
        }
    }

    @r1({"SMAP\nIntrinsicsJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IntrinsicsJvm.kt\nkotlin/coroutines/intrinsics/IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$2\n+ 2 IntrinsicsJvm.kt\nkotlin/coroutines/intrinsics/IntrinsicsKt__IntrinsicsJvmKt\n*L\n1#1,269:1\n131#2:270\n*E\n"})
    public static final class d extends xm.d {
        final /* synthetic */ l $this_createCoroutineUnintercepted$inlined;
        private int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(um.d dVar, um.g gVar, l lVar) {
            super(dVar, gVar);
            this.$this_createCoroutineUnintercepted$inlined = lVar;
            l0.n(dVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        @Override // xm.a
        @m
        public Object invokeSuspend(@os.l Object obj) {
            int i10 = this.label;
            if (i10 == 0) {
                this.label = 1;
                d1.n(obj);
                l0.n(this.$this_createCoroutineUnintercepted$inlined, "null cannot be cast to non-null type kotlin.Function1<kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$0>, kotlin.Any?>");
                return ((l) u1.q(this.$this_createCoroutineUnintercepted$inlined, 1)).invoke(this);
            }
            if (i10 != 1) {
                throw new IllegalStateException("This coroutine had already completed");
            }
            this.label = 2;
            d1.n(obj);
            return obj;
        }
    }

    @r1({"SMAP\nIntrinsicsJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IntrinsicsJvm.kt\nkotlin/coroutines/intrinsics/IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$1\n+ 2 IntrinsicsJvm.kt\nkotlin/coroutines/intrinsics/IntrinsicsKt__IntrinsicsJvmKt\n*L\n1#1,269:1\n166#2:270\n*E\n"})
    public static final class e extends j {
        final /* synthetic */ Object $receiver$inlined;
        final /* synthetic */ p $this_createCoroutineUnintercepted$inlined;
        private int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(um.d dVar, p pVar, Object obj) {
            super(dVar);
            this.$this_createCoroutineUnintercepted$inlined = pVar;
            this.$receiver$inlined = obj;
            l0.n(dVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        @Override // xm.a
        @m
        public Object invokeSuspend(@os.l Object obj) {
            int i10 = this.label;
            if (i10 == 0) {
                this.label = 1;
                d1.n(obj);
                l0.n(this.$this_createCoroutineUnintercepted$inlined, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1>, kotlin.Any?>");
                return ((p) u1.q(this.$this_createCoroutineUnintercepted$inlined, 2)).invoke(this.$receiver$inlined, this);
            }
            if (i10 != 1) {
                throw new IllegalStateException("This coroutine had already completed");
            }
            this.label = 2;
            d1.n(obj);
            return obj;
        }
    }

    @r1({"SMAP\nIntrinsicsJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IntrinsicsJvm.kt\nkotlin/coroutines/intrinsics/IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$2\n+ 2 IntrinsicsJvm.kt\nkotlin/coroutines/intrinsics/IntrinsicsKt__IntrinsicsJvmKt\n*L\n1#1,269:1\n166#2:270\n*E\n"})
    public static final class f extends xm.d {
        final /* synthetic */ Object $receiver$inlined;
        final /* synthetic */ p $this_createCoroutineUnintercepted$inlined;
        private int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(um.d dVar, um.g gVar, p pVar, Object obj) {
            super(dVar, gVar);
            this.$this_createCoroutineUnintercepted$inlined = pVar;
            this.$receiver$inlined = obj;
            l0.n(dVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        @Override // xm.a
        @m
        public Object invokeSuspend(@os.l Object obj) {
            int i10 = this.label;
            if (i10 == 0) {
                this.label = 1;
                d1.n(obj);
                l0.n(this.$this_createCoroutineUnintercepted$inlined, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1>, kotlin.Any?>");
                return ((p) u1.q(this.$this_createCoroutineUnintercepted$inlined, 2)).invoke(this.$receiver$inlined, this);
            }
            if (i10 != 1) {
                throw new IllegalStateException("This coroutine had already completed");
            }
            this.label = 2;
            d1.n(obj);
            return obj;
        }
    }

    public static final class g extends j {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(um.d<? super T> dVar) {
            super(dVar);
            l0.n(dVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        @Override // xm.a
        @m
        public Object invokeSuspend(@os.l Object obj) {
            d1.n(obj);
            return obj;
        }
    }

    public static final class h extends xm.d {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(um.d<? super T> dVar, um.g gVar) {
            super(dVar, gVar);
            l0.n(dVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        @Override // xm.a
        @m
        public Object invokeSuspend(@os.l Object obj) {
            d1.n(obj);
            return obj;
        }
    }

    @f1(version = "1.3")
    public static final <T> um.d<l2> a(um.d<? super T> dVar, l<? super um.d<? super T>, ? extends Object> lVar) {
        um.g context = dVar.getContext();
        return context == i.INSTANCE ? new a(dVar, lVar) : new b(dVar, context, lVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @f1(version = "1.3")
    @os.l
    public static <T> um.d<l2> b(@os.l l<? super um.d<? super T>, ? extends Object> lVar, @os.l um.d<? super T> dVar) {
        l0.p(lVar, "<this>");
        l0.p(dVar, "completion");
        l0.p(dVar, "completion");
        if (lVar instanceof xm.a) {
            return ((xm.a) lVar).create(dVar);
        }
        um.g context = dVar.getContext();
        return context == i.INSTANCE ? new C0485c(dVar, lVar) : new d(dVar, context, lVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @f1(version = "1.3")
    @os.l
    public static <R, T> um.d<l2> c(@os.l p<? super R, ? super um.d<? super T>, ? extends Object> pVar, R r10, @os.l um.d<? super T> dVar) {
        l0.p(pVar, "<this>");
        l0.p(dVar, "completion");
        l0.p(dVar, "completion");
        if (pVar instanceof xm.a) {
            return ((xm.a) pVar).create(r10, dVar);
        }
        um.g context = dVar.getContext();
        return context == i.INSTANCE ? new e(dVar, pVar, r10) : new f(dVar, context, pVar, r10);
    }

    public static final <T> um.d<T> d(um.d<? super T> dVar) {
        um.g context = dVar.getContext();
        return context == i.INSTANCE ? new g(dVar) : new h(dVar, context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @f1(version = "1.3")
    @os.l
    public static <T> um.d<T> e(@os.l um.d<? super T> dVar) {
        um.d<T> dVar2;
        l0.p(dVar, "<this>");
        xm.d dVar3 = dVar instanceof xm.d ? (xm.d) dVar : null;
        return (dVar3 == null || (dVar2 = (um.d<T>) dVar3.intercepted()) == null) ? dVar : dVar2;
    }

    @f1(version = "1.3")
    @an.f
    public static final <T> Object f(l<? super um.d<? super T>, ? extends Object> lVar, um.d<? super T> dVar) {
        l0.p(lVar, "<this>");
        l0.p(dVar, "completion");
        return !(lVar instanceof xm.a) ? i(lVar, dVar) : ((l) u1.q(lVar, 1)).invoke(dVar);
    }

    @f1(version = "1.3")
    @an.f
    public static final <R, T> Object g(p<? super R, ? super um.d<? super T>, ? extends Object> pVar, R r10, um.d<? super T> dVar) {
        l0.p(pVar, "<this>");
        l0.p(dVar, "completion");
        return !(pVar instanceof xm.a) ? j(pVar, r10, dVar) : ((p) u1.q(pVar, 2)).invoke(r10, dVar);
    }

    @an.f
    public static final <R, P, T> Object h(q<? super R, ? super P, ? super um.d<? super T>, ? extends Object> qVar, R r10, P p10, um.d<? super T> dVar) {
        l0.p(qVar, "<this>");
        l0.p(dVar, "completion");
        return !(qVar instanceof xm.a) ? k(qVar, r10, p10, dVar) : ((q) u1.q(qVar, 3)).invoke(r10, p10, dVar);
    }

    @m
    @z0
    public static final <T> Object i(@os.l l<? super um.d<? super T>, ? extends Object> lVar, @os.l um.d<? super T> dVar) {
        l0.p(lVar, "<this>");
        l0.p(dVar, "completion");
        l0.p(dVar, "completion");
        return ((l) u1.q(lVar, 1)).invoke(d(dVar));
    }

    @m
    @z0
    public static final <R, T> Object j(@os.l p<? super R, ? super um.d<? super T>, ? extends Object> pVar, R r10, @os.l um.d<? super T> dVar) {
        l0.p(pVar, "<this>");
        l0.p(dVar, "completion");
        l0.p(dVar, "completion");
        return ((p) u1.q(pVar, 2)).invoke(r10, d(dVar));
    }

    @m
    @z0
    public static <R, P, T> Object k(@os.l q<? super R, ? super P, ? super um.d<? super T>, ? extends Object> qVar, R r10, P p10, @os.l um.d<? super T> dVar) {
        l0.p(qVar, "<this>");
        l0.p(dVar, "completion");
        l0.p(dVar, "completion");
        return ((q) u1.q(qVar, 3)).invoke(r10, p10, d(dVar));
    }
}
