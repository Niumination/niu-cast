package db;

import android.app.Application;
import bb.s;
import com.transsion.iotcardsdk.SdkInit;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import li.g0;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends SuspendLambda implements Function2 {
    final /* synthetic */ Application $application;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Application application, Continuation<? super e> continuation) {
        super(2, continuation);
        this.$application = application;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new e(this.$application, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        f.f4395a = this.$application.getPackageName();
        SdkInit.initAppDevices$default(SdkInit.INSTANCE, this.$application, new s(1), false, 4, null);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((e) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
