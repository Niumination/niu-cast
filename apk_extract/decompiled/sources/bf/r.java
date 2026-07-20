package bf;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import ze.q2;
import ze.r2;

/* JADX INFO: loaded from: classes3.dex */
public final class r extends SuspendLambda implements Function2 {
    final /* synthetic */ Object $descriptor;
    final /* synthetic */ String $expected;
    final /* synthetic */ oi.h $this_singleOrStatusFlow;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(oi.h hVar, String str, Object obj, Continuation<? super r> continuation) {
        super(2, continuation);
        this.$this_singleOrStatusFlow = hVar;
        this.$expected = str;
        this.$descriptor = obj;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        r rVar = new r(this.$this_singleOrStatusFlow, this.$expected, this.$descriptor, continuation);
        rVar.L$0 = obj;
        return rVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws r2 {
        Ref.BooleanRef booleanRef;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            oi.i iVar = (oi.i) this.L$0;
            Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
            oi.h hVar = this.$this_singleOrStatusFlow;
            q qVar = new q(booleanRef2, iVar, this.$expected, this.$descriptor);
            this.L$0 = booleanRef2;
            this.label = 1;
            if (hVar.a(qVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            booleanRef = booleanRef2;
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            booleanRef = (Ref.BooleanRef) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        if (booleanRef.element) {
            return Unit.INSTANCE;
        }
        throw new r2(q2.f11410m.h("Expected one " + this.$expected + " for " + this.$descriptor + " but received none"));
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(oi.i iVar, Continuation<? super Unit> continuation) {
        return ((r) create(iVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
