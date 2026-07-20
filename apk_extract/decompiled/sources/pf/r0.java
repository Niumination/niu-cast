package pf;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import li.i2;
import li.r1;

/* JADX INFO: loaded from: classes3.dex */
public final class r0 extends SuspendLambda implements Function3 {
    final /* synthetic */ qf.b $this_createClientPlugin;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r0(qf.b bVar, Continuation<? super r0> continuation) {
        super(3, continuation);
        this.$this_createClientPlugin = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Throwable th2;
        li.s sVar;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 != 0) {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            sVar = (li.s) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                ((r1) sVar).r0();
                return Unit.INSTANCE;
            } catch (Throwable th3) {
                th2 = th3;
                try {
                    ((r1) sVar).s0(th2);
                    throw th2;
                } catch (Throwable th4) {
                    ((r1) sVar).r0();
                    throw th4;
                }
            }
        }
        ResultKt.throwOnFailure(obj);
        vf.c cVar = (vf.c) this.L$0;
        Function1 function1 = (Function1) this.L$1;
        i2 i2Var = new i2(cVar.e);
        CoroutineContext.Element element = this.$this_createClientPlugin.f9042a.f6258d.get(li.o1.f7483a);
        Intrinsics.checkNotNull(element);
        vj.b bVar = s0.f8868a;
        i2Var.A(new ag.d0(((li.p1) element).A(new ag.d0(i2Var, 24)), 25));
        try {
            Intrinsics.checkNotNullParameter(i2Var, "<set-?>");
            cVar.e = i2Var;
            try {
                this.L$0 = i2Var;
                this.label = 1;
                if (function1.invoke(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                sVar = i2Var;
                ((r1) sVar).r0();
                return Unit.INSTANCE;
            } catch (Throwable th5) {
                th2 = th5;
                sVar = i2Var;
                ((r1) sVar).s0(th2);
                throw th2;
            }
        } catch (Throwable th6) {
            th2 = th6;
        }
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(vf.c cVar, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super Unit> continuation) {
        r0 r0Var = new r0(this.$this_createClientPlugin, continuation);
        r0Var.L$0 = cVar;
        r0Var.L$1 = function1;
        return r0Var.invokeSuspend(Unit.INSTANCE);
    }
}
