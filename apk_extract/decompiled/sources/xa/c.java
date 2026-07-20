package xa;

import android.util.Log;
import com.transsion.connectx.sdk.TCCPSourceApi;
import java.util.List;
import k3.gc;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import li.g0;
import li.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends SuspendLambda implements Function2 {
    final /* synthetic */ q7.c $confirmSendFileBean;
    final /* synthetic */ String $json;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(q7.c cVar, String str, Continuation<? super c> continuation) {
        super(2, continuation);
        this.$confirmSendFileBean = cVar;
        this.$json = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new c(this.$confirmSendFileBean, this.$json, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            String log = "confirmSendFile:confirmSendFileBean:" + this.$confirmSendFileBean;
            Intrinsics.checkNotNullParameter("FileTransferProcessor", "tag");
            Intrinsics.checkNotNullParameter(log, "log");
            if (gc.f6462a <= 3) {
                Log.d(gc.f6463b.concat("FileTransferProcessor"), log);
            }
            if (i.f10899k != null) {
                String str = this.$json;
                this.label = 1;
                q7.c cVar = (q7.c) na.b.a(str, q7.c.class);
                if (cVar != null) {
                    TCCPSourceApi tCCPSourceApi = x7.f.f10882a;
                    List files = cVar.getUrls();
                    int transferMode = cVar.getTransferMode();
                    String filePackageName = cVar.getFileFromPackage();
                    String key = cVar.getKey();
                    Intrinsics.checkNotNullParameter(files, "files");
                    Intrinsics.checkNotNullParameter(filePackageName, "filePackageName");
                    Intrinsics.checkNotNullParameter(key, "key");
                    Intrinsics.checkNotNullParameter("ConnectSdkProxy", "tag");
                    Intrinsics.checkNotNullParameter("sendFile", "log");
                    if (gc.f6462a <= 4) {
                        Log.i(gc.f6463b.concat("ConnectSdkProxy"), "sendFile");
                    }
                    l0.p(x7.f.f10884c, null, null, new x7.b(files, transferMode, filePackageName, key, null), 3);
                }
                if (Unit.INSTANCE == coroutine_suspended) {
                    return coroutine_suspended;
                }
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
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((c) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
