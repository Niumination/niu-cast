package xa;

import com.transsion.connectx.sdk.TCCPSourceApi;
import k3.gc;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import li.g0;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends SuspendLambda implements Function2 {
    int label;

    public g(Continuation<? super g> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new g(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        gc.a("FileTransferProcessor", "removeListener");
        i.f10899k = null;
        TCCPSourceApi tCCPSourceApi = x7.f.f10882a;
        wa.d listener = wa.d.f10697b;
        Intrinsics.checkNotNullParameter(listener, "listener");
        gc.c("ConnectSdkProxy", "unregisterBackupFileListener");
        synchronized (x7.f.e) {
            gc.c("ConnectSdkProxy", "unregisterBackupFileListener :" + x7.f.f10885d);
            if (x7.f.f10885d) {
                x7.f.f10882a.unregisterBackupFileListener(listener);
                x7.f.f10885d = false;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((g) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
