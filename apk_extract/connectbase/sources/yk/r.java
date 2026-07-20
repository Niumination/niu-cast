package yk;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import fl.z0;
import gk.c1;
import ik.r0;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.channels.ClosedChannelException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeoutException;
import kn.l0;
import kn.l1;
import kn.n0;
import lm.d1;
import lm.l2;
import nq.v3;

/* JADX INFO: loaded from: classes2.dex */
public final class r {

    public static final class a extends n0 implements jn.l<h0.b, l2> {
        final /* synthetic */ String $url;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str) {
            super(1);
            this.$url = str;
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(h0.b bVar) {
            invoke2(bVar);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l h0.b bVar) {
            l0.p(bVar, "$this$install");
            bVar.d(this.$url);
        }
    }

    @xm.f(c = "io.ktor.server.engine.DefaultEnginePipelineKt$defaultEnginePipeline$2", f = "DefaultEnginePipeline.kt", i = {0, 2, 4}, l = {127, ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX, 41, ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX, 46, ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX, ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX}, m = "invokeSuspend", n = {"$this$intercept", "$this$intercept", "$this$intercept"}, s = {"L$0", "L$0", "L$0"})
    public static final class b extends xm.o implements jn.q<nl.f<l2, dk.b>, l2, um.d<? super l2>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        @xm.f(c = "io.ktor.server.engine.DefaultEnginePipelineKt$defaultEnginePipeline$2$1$1", f = "DefaultEnginePipeline.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends xm.o implements jn.l<um.d<? super l2>, Object> {
            final /* synthetic */ nl.f<l2, dk.b> $$this$intercept;
            final /* synthetic */ gl.c $error;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(nl.f<l2, dk.b> fVar, gl.c cVar, um.d<? super a> dVar) {
                super(1, dVar);
                this.$$this$intercept = fVar;
                this.$error = cVar;
            }

            @Override // xm.a
            @os.l
            public final um.d<l2> create(@os.l um.d<?> dVar) {
                return new a(this.$$this$intercept, this.$error, dVar);
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
                r.g(this.$$this$intercept.getContext().a().I, this.$$this$intercept.getContext(), this.$error);
                return l2.f10208a;
            }

            @Override // jn.l
            @os.m
            public final Object invoke(@os.m um.d<? super l2> dVar) {
                return ((a) create(dVar)).invokeSuspend(l2.f10208a);
            }
        }

        public b(um.d<? super b> dVar) {
            super(3, dVar);
        }

        /* JADX WARN: Code duplicated, block: B:32:0x0082 A[RETURN] */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, nl.f] */
        /* JADX WARN: Type inference failed for: r1v10, types: [nl.f] */
        /* JADX WARN: Type inference failed for: r1v15 */
        /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object, nl.f] */
        /* JADX WARN: Type inference failed for: r1v22 */
        /* JADX WARN: Type inference failed for: r1v23 */
        /* JADX WARN: Type inference failed for: r1v24 */
        /* JADX WARN: Type inference failed for: r1v25 */
        /* JADX WARN: Type inference failed for: r1v26 */
        /* JADX WARN: Type inference failed for: r1v27 */
        /* JADX WARN: Type inference failed for: r1v3, types: [nl.f] */
        /* JADX WARN: Type inference failed for: r1v7, types: [pl.k] */
        /* JADX WARN: Type inference failed for: r1v8, types: [nl.f] */
        /* JADX WARN: Type inference failed for: r5v2, types: [gk.i$d] */
        /* JADX WARN: Type inference failed for: r8v0, types: [um.d, yk.r$b] */
        /* JADX WARN: Type inference failed for: r8v1, types: [um.d, yk.r$b] */
        /* JADX WARN: Type inference failed for: r8v11, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r8v15 */
        /* JADX WARN: Type inference failed for: r8v16 */
        /* JADX WARN: Type inference failed for: r8v17 */
        /* JADX WARN: Type inference failed for: r8v18 */
        /* JADX WARN: Type inference failed for: r8v2, types: [um.d, yk.r$b] */
        /* JADX WARN: Type inference failed for: r8v3, types: [um.d, yk.r$b] */
        /* JADX WARN: Type inference failed for: r8v6, types: [um.d, yk.r$b] */
        /* JADX WARN: Type inference failed for: r8v8, types: [um.d, yk.r$b] */
        /* JADX WARN: Type inference failed for: r9v10, types: [pl.k] */
        /* JADX WARN: Type inference failed for: r9v14, types: [pl.k] */
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
        public final Object invokeSuspend(@os.l Object obj) throws Throwable {
            ?? r10;
            ?? r11;
            ?? r12;
            ?? r13;
            nl.f fVar;
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            ?? r14 = this.label;
            try {
                try {
                    try {
                        switch (r14) {
                            case 0:
                                d1.n(obj);
                                fVar = (nl.f) this.L$0;
                                dk.a aVarA = ((dk.b) fVar.getContext()).a();
                                dk.b bVar = (dk.b) fVar.getContext();
                                l2 l2Var = l2.f10208a;
                                this.L$0 = fVar;
                                this.label = 1;
                                if (aVarA.g(bVar, l2Var, this) == aVar) {
                                    return aVar;
                                }
                                pl.k kVarI = ((dk.b) fVar.getContext()).d().i();
                                this.L$0 = null;
                                r14 = 2;
                                r14 = 2;
                                r14 = 2;
                                this.label = 2;
                                this = kVarI.P(Long.MAX_VALUE, this);
                                if (this == aVar) {
                                    return aVar;
                                }
                                return l2.f10208a;
                            case 1:
                                fVar = (nl.f) this.L$0;
                                d1.n(obj);
                                pl.k kVarI2 = ((dk.b) fVar.getContext()).d().i();
                                this.L$0 = null;
                                r14 = 2;
                                r14 = 2;
                                r14 = 2;
                                this.label = 2;
                                this = kVarI2.P(Long.MAX_VALUE, this);
                                if (this == aVar) {
                                    return aVar;
                                }
                                return l2.f10208a;
                            case 2:
                            case 4:
                            case 6:
                                d1.n(obj);
                                return l2.f10208a;
                            case 3:
                                nl.f fVar2 = (nl.f) this.L$0;
                                d1.n(obj);
                                r11 = fVar2;
                                this = this;
                                ?? I = ((dk.b) r11.getContext()).d().i();
                                r10.L$0 = null;
                                r10.label = 4;
                                if (I.P(Long.MAX_VALUE, r10) == aVar) {
                                    return aVar;
                                }
                                return l2.f10208a;
                            case 5:
                                nl.f fVar3 = (nl.f) this.L$0;
                                d1.n(obj);
                                r13 = fVar3;
                                this = this;
                                ?? I2 = ((dk.b) r13.getContext()).d().i();
                                r12.L$0 = null;
                                r12.label = 6;
                                if (I2.P(Long.MAX_VALUE, r12) == aVar) {
                                    return aVar;
                                }
                                return l2.f10208a;
                            case 7:
                                Throwable th2 = (Throwable) this.L$0;
                                try {
                                    d1.n(obj);
                                    throw th2;
                                } catch (Throwable unused) {
                                    throw th2;
                                }
                            default:
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } catch (Throwable unused2) {
                    }
                } catch (Throwable th3) {
                    try {
                        ?? I3 = ((dk.b) r14.getContext()).d().i();
                        this.L$0 = th3;
                        this.label = 7;
                        if (I3.P(Long.MAX_VALUE, this) == aVar) {
                            return aVar;
                        }
                    } catch (Throwable unused3) {
                    }
                    throw th3;
                }
            } catch (gl.c e10) {
                ?? r15 = gk.i.d.f6639a;
                dk.b bVar2 = (dk.b) r14.getContext();
                a aVar2 = new a(r14, e10, null);
                this.L$0 = r14;
                this.label = 3;
                Object objA = r15.a(bVar2, aVar2, this);
                r11 = r14;
                r10 = this;
                if (objA == aVar) {
                    return aVar;
                }
            } catch (Throwable th4) {
                dk.b bVar3 = (dk.b) r14.getContext();
                this.L$0 = r14;
                this.label = 5;
                Object objE = r.e(bVar3, th4, this);
                r13 = r14;
                r12 = this;
                if (objE == aVar) {
                    return aVar;
                }
            }
        }

        @Override // jn.q
        @os.m
        public final Object invoke(@os.l nl.f<l2, dk.b> fVar, @os.l l2 l2Var, @os.m um.d<? super l2> dVar) {
            b bVar = new b(dVar);
            bVar.L$0 = fVar;
            return bVar.invokeSuspend(l2.f10208a);
        }
    }

    @xm.f(c = "io.ktor.server.engine.DefaultEnginePipelineKt", f = "DefaultEnginePipeline.kt", i = {0, 0}, l = {60, 61}, m = "handleFailure", n = {NotificationCompat.CATEGORY_CALL, "error"}, s = {"L$0", "L$1"})
    public static final class c extends xm.d {
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
            return r.e(null, null, this);
        }
    }

    @xm.f(c = "io.ktor.server.engine.DefaultEnginePipelineKt$logError$2$1", f = "DefaultEnginePipeline.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends xm.o implements jn.l<um.d<? super l2>, Object> {
        final /* synthetic */ dk.b $call;
        final /* synthetic */ Throwable $error;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(dk.b bVar, Throwable th2, um.d<? super d> dVar) {
            super(1, dVar);
            this.$call = bVar;
            this.$error = th2;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.l um.d<?> dVar) {
            return new d(this.$call, this.$error, dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d1.n(obj);
            r.g(this.$call.a().I, this.$call, this.$error);
            return l2.f10208a;
        }

        @Override // jn.l
        @os.m
        public final Object invoke(@os.m um.d<? super l2> dVar) {
            return ((d) create(dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @xm.f(c = "io.ktor.server.engine.DefaultEnginePipelineKt", f = "DefaultEnginePipeline.kt", i = {}, l = {133}, m = "tryRespondError", n = {}, s = {})
    public static final class e extends xm.d {
        int label;
        /* synthetic */ Object result;

        public e(um.d<? super e> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return r.h(null, null, this);
        }
    }

    @v
    @os.l
    public static final a0 c(@os.l dk.e eVar) throws nl.c {
        String string;
        l0.p(eVar, "environment");
        a0 a0Var = new a0(eVar.h());
        ek.b bVarC = eVar.b().c("ktor.deployment.shutdown.url");
        if (bVarC != null && (string = bVarC.getString()) != null) {
        }
        a0.f21359v.getClass();
        a0Var.x(a0.f21361x, new b(null));
        return a0Var;
    }

    @os.m
    @v
    public static final r0 d(@os.l Throwable th2) {
        l0.p(th2, "cause");
        if (th2 instanceof gk.c) {
            r0.f8158c.getClass();
            return r0.f8182x;
        }
        if (th2 instanceof gk.r0) {
            r0.f8158c.getClass();
            return r0.B;
        }
        if (th2 instanceof c1) {
            r0.f8158c.getClass();
            return r0.M;
        }
        if (!(th2 instanceof TimeoutException ? true : th2 instanceof v3)) {
            return null;
        }
        r0.f8158c.getClass();
        return r0.Z;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @os.m
    @v
    public static final Object e(@os.l dk.b bVar, @os.l Throwable th2, @os.l um.d<? super l2> dVar) {
        c cVar;
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
        if (i11 != 0) {
            if (i11 == 1) {
                th2 = (Throwable) cVar.L$1;
                bVar = (dk.b) cVar.L$0;
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
        cVar.L$0 = bVar;
        cVar.L$1 = th2;
        cVar.label = 1;
        if (f(bVar, th2, cVar) == aVar) {
            return aVar;
        }
        r0 r0VarD = d(th2);
        if (r0VarD == null) {
            r0.f8158c.getClass();
            r0VarD = r0.V;
        }
        cVar.L$0 = null;
        cVar.L$1 = null;
        cVar.label = 2;
        if (h(bVar, r0VarD, cVar) == aVar) {
            return aVar;
        }
        return l2.f10208a;
    }

    @os.m
    @v
    public static final Object f(@os.l dk.b bVar, @os.l Throwable th2, @os.l um.d<? super l2> dVar) throws Throwable {
        Object objA = gk.i.d.f6639a.a(bVar, new d(bVar, th2, null), dVar);
        return objA == wm.a.COROUTINE_SUSPENDED ? objA : l2.f10208a;
    }

    public static final void g(dk.e eVar, dk.b bVar, Throwable th2) {
        String strA;
        try {
            try {
                Object objStatus = bVar.e().status();
                if (objStatus == null) {
                    objStatus = "Unhandled";
                }
                try {
                    strA = gk.j.a(bVar.d());
                } catch (Throwable th3) {
                    strA = "(request error: " + th3 + ')';
                }
                String str = objStatus + ": " + strA + ". Exception " + l1.d(th2.getClass()) + ": " + ((Object) th2.getMessage()) + ']';
                boolean z10 = true;
                if (!(th2 instanceof CancellationException ? true : th2 instanceof ClosedChannelException ? true : th2 instanceof gl.c ? true : th2 instanceof IOException ? true : th2 instanceof gk.c ? true : th2 instanceof gk.r0)) {
                    z10 = th2 instanceof c1;
                }
                if (z10) {
                    eVar.i().debug(str, th2);
                    return;
                }
                eVar.i().error(objStatus + ": " + strA, th2);
            } catch (OutOfMemoryError unused) {
                z0.a(eVar.i(), th2);
            }
        } catch (OutOfMemoryError unused2) {
            PrintStream printStream = System.err;
            printStream.print("OutOfMemoryError: ");
            printStream.println(th2.getMessage());
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object h(dk.b bVar, r0 r0Var, um.d<? super l2> dVar) {
        e eVar;
        if (dVar instanceof e) {
            eVar = (e) dVar;
            int i10 = eVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                eVar.label = i10 - Integer.MIN_VALUE;
            } else {
                eVar = new e(dVar);
            }
        } else {
            eVar = new e(dVar);
        }
        Object obj = eVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = eVar.label;
        try {
            if (i11 == 0) {
                d1.n(obj);
                if (bVar.e().status() == null) {
                    if (!(r0Var instanceof byte[])) {
                        try {
                            vk.i.b(bVar.e(), l1.A(r0.class));
                        } catch (Throwable unused) {
                        }
                    }
                    vk.d dVarC = bVar.e().c();
                    eVar.label = 1;
                    if (dVarC.g(bVar, r0Var, eVar) == aVar) {
                        return aVar;
                    }
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
            }
        } catch (l.e unused2) {
        }
        return l2.f10208a;
    }
}
