package pf;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends SuspendLambda implements Function2 {
    /* synthetic */ Object L$0;
    int label;

    public e(Continuation<? super e> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        e eVar = new e(continuation);
        eVar.L$0 = obj;
        return eVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        if (((wf.b) this.L$0).b().d().i().d(f.f8841b) == null) {
            return null;
        }
        throw new ClassCastException();
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(wf.b bVar, Continuation<? super wf.b> continuation) {
        return ((e) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
