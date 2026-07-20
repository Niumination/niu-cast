package nf;

import jh.j0;
import jh.z0;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final class u extends SuspendLambda implements Function2 {
    final /* synthetic */ ag.r $connectionType;
    final /* synthetic */ long $contentLength;
    final /* synthetic */ jh.o $input;
    final /* synthetic */ String $transferEncoding;
    final /* synthetic */ zf.y $version;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(zf.y yVar, long j8, String str, ag.r rVar, jh.o oVar, Continuation<? super u> continuation) {
        super(2, continuation);
        this.$version = yVar;
        this.$contentLength = j8;
        this.$transferEncoding = str;
        this.$connectionType = rVar;
        this.$input = oVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        u uVar = new u(this.$version, this.$contentLength, this.$transferEncoding, this.$connectionType, this.$input, continuation);
        uVar.L$0 = obj;
        return uVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            z0 z0Var = (z0) this.L$0;
            zf.y yVar = this.$version;
            long j8 = this.$contentLength;
            String str = this.$transferEncoding;
            ag.r rVar = this.$connectionType;
            jh.o oVar = this.$input;
            j0 j0Var = z0Var.f6313a;
            this.label = 1;
            if (ag.s.b(yVar, j8, str, rVar, oVar, j0Var, this) == coroutine_suspended) {
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
    public final Object invoke(z0 z0Var, Continuation<? super Unit> continuation) {
        return ((u) create(z0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
