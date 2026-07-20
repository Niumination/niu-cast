package jf;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends SuspendLambda implements Function3 {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ d this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(d dVar, Continuation<? super b> continuation) {
        super(3, continuation);
        this.this$0 = dVar;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(hh.f fVar, wf.c cVar, Continuation<? super Unit> continuation) {
        b bVar = new b(this.this$0, continuation);
        bVar.L$0 = fVar;
        return bVar.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        hh.f fVar;
        Throwable cause;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            hh.f fVar2 = (hh.f) this.L$0;
            try {
                this.L$0 = fVar2;
                this.label = 1;
                Object objE = fVar2.e(this);
                if (objE == coroutine_suspended) {
                    return coroutine_suspended;
                }
                fVar = fVar2;
                obj = objE;
            } catch (Throwable th2) {
                fVar = fVar2;
                cause = th2;
                yf.c cVar = this.this$0.f6263l;
                yf.a aVar = xf.a.f10922d;
                wf.b response = ((kf.c) fVar.f5401a).e();
                Intrinsics.checkNotNullParameter(response, "response");
                Intrinsics.checkNotNullParameter(cause, "cause");
                cVar.a(aVar, new se.d());
                throw cause;
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            fVar = (hh.f) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th3) {
                cause = th3;
                yf.c cVar2 = this.this$0.f6263l;
                yf.a aVar2 = xf.a.f10922d;
                wf.b response2 = ((kf.c) fVar.f5401a).e();
                Intrinsics.checkNotNullParameter(response2, "response");
                Intrinsics.checkNotNullParameter(cause, "cause");
                cVar2.a(aVar2, new se.d());
                throw cause;
            }
        }
        return Unit.INSTANCE;
    }
}
