package bf;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import ze.p1;
import ze.r1;

/* JADX INFO: loaded from: classes3.dex */
public final class m extends SuspendLambda implements Function2 {
    final /* synthetic */ ze.f $callOptions;
    final /* synthetic */ ze.g $channel;
    final /* synthetic */ p1 $headers;
    final /* synthetic */ r1 $method;
    final /* synthetic */ g $request;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(ze.g gVar, r1 r1Var, ze.f fVar, p1 p1Var, g gVar2, Continuation<? super m> continuation) {
        super(2, continuation);
        this.$channel = gVar;
        this.$method = r1Var;
        this.$callOptions = fVar;
        this.$headers = p1Var;
        this.$request = gVar2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        m mVar = new m(this.$channel, this.$method, this.$callOptions, this.$headers, this.$request, continuation);
        mVar.L$0 = obj;
        return mVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            l lVar = new l(this.$channel, this.$method, this.$callOptions, this.$headers, (oi.i) this.L$0, this.$request, null);
            this.label = 1;
            if (li.h0.c(lVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(oi.i iVar, Continuation<? super Unit> continuation) {
        return ((m) create(iVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
