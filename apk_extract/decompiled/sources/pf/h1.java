package pf;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes3.dex */
public final class h1 extends SuspendLambda implements Function3 {
    final /* synthetic */ Function3<vf.c, Object, Continuation<? super cg.j>, Object> $handler;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public h1(Function3<? super vf.c, Object, ? super Continuation<? super cg.j>, ? extends Object> function3, Continuation<? super h1> continuation) {
        super(3, continuation);
        this.$handler = function3;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(hh.f fVar, Object obj, Continuation<? super Unit> continuation) {
        h1 h1Var = new h1(this.$handler, continuation);
        h1Var.L$0 = fVar;
        h1Var.L$1 = obj;
        return h1Var.invokeSuspend(Unit.INSTANCE);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to pf.h1 for r6v4 'this'  java.lang.Object
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L22
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.throwOnFailure(r7)
            goto L4b
        L12:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L1a:
            java.lang.Object r1 = r6.L$0
            hh.f r1 = (hh.f) r1
            kotlin.ResultKt.throwOnFailure(r7)
            goto L3b
        L22:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.Object r7 = r6.L$0
            r1 = r7
            hh.f r1 = (hh.f) r1
            java.lang.Object r7 = r6.L$1
            kotlin.jvm.functions.Function3<vf.c, java.lang.Object, kotlin.coroutines.Continuation<? super cg.j>, java.lang.Object> r4 = r6.$handler
            java.lang.Object r5 = r1.f5401a
            r6.L$0 = r1
            r6.label = r3
            java.lang.Object r7 = r4.invoke(r5, r7, r6)
            if (r7 != r0) goto L3b
            return r0
        L3b:
            cg.j r7 = (cg.j) r7
            if (r7 == 0) goto L4b
            r3 = 0
            r6.L$0 = r3
            r6.label = r2
            java.lang.Object r6 = r1.f(r7, r6)
            if (r6 != r0) goto L4b
            return r0
        L4b:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: pf.h1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
