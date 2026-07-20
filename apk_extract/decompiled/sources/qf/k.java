package qf;

import jh.o;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;

/* JADX INFO: loaded from: classes3.dex */
public final class k extends SuspendLambda implements Function3 {
    final /* synthetic */ Function5<j, wf.b, o, ih.a, Continuation<Object>, Object> $handler;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public k(Function5<? super j, ? super wf.b, ? super o, ? super ih.a, ? super Continuation<Object>, ? extends Object> function5, Continuation<? super k> continuation) {
        super(3, continuation);
        this.$handler = function5;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(hh.f fVar, wf.c cVar, Continuation<? super Unit> continuation) {
        k kVar = new k(this.$handler, continuation);
        kVar.L$0 = fVar;
        return kVar.invokeSuspend(Unit.INSTANCE);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to qf.k for r11v7 'this'  java.lang.Object
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L27
            if (r1 == r3) goto L1b
            if (r1 != r2) goto L13
            kotlin.ResultKt.throwOnFailure(r12)
            goto La1
        L13:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L1b:
            java.lang.Object r1 = r11.L$1
            ih.a r1 = (ih.a) r1
            java.lang.Object r3 = r11.L$0
            hh.f r3 = (hh.f) r3
            kotlin.ResultKt.throwOnFailure(r12)
            goto L60
        L27:
            kotlin.ResultKt.throwOnFailure(r12)
            java.lang.Object r12 = r11.L$0
            hh.f r12 = (hh.f) r12
            java.lang.Object r1 = r12.d()
            wf.c r1 = (wf.c) r1
            ih.a r10 = r1.f10742a
            java.lang.Object r7 = r1.f10743b
            boolean r1 = r7 instanceof jh.o
            if (r1 != 0) goto L3f
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L3f:
            kotlin.jvm.functions.Function5<qf.j, wf.b, jh.o, ih.a, kotlin.coroutines.Continuation<java.lang.Object>, java.lang.Object> r4 = r11.$handler
            qf.j r5 = new qf.j
            r5.<init>()
            java.lang.Object r1 = r12.f5401a
            kf.c r1 = (kf.c) r1
            wf.b r6 = r1.e()
            r11.L$0 = r12
            r11.L$1 = r10
            r11.label = r3
            r8 = r10
            r9 = r11
            java.lang.Object r1 = r4.invoke(r5, r6, r7, r8, r9)
            if (r1 != r0) goto L5d
            return r0
        L5d:
            r3 = r12
            r12 = r1
            r1 = r10
        L60:
            if (r12 != 0) goto L65
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L65:
            boolean r4 = r12 instanceof cg.e
            if (r4 != 0) goto L8e
            kotlin.reflect.KClass r4 = r1.f5872a
            boolean r4 = r4.isInstance(r12)
            if (r4 == 0) goto L72
            goto L8e
        L72:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "transformResponseBody returned "
            r0.<init>(r2)
            r0.append(r12)
            java.lang.String r12 = " but expected value of type "
            r0.append(r12)
            r0.append(r1)
            java.lang.String r12 = r0.toString()
            r11.<init>(r12)
            throw r11
        L8e:
            wf.c r4 = new wf.c
            r4.<init>(r1, r12)
            r12 = 0
            r11.L$0 = r12
            r11.L$1 = r12
            r11.label = r2
            java.lang.Object r11 = r3.f(r4, r11)
            if (r11 != r0) goto La1
            return r0
        La1:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: qf.k.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
