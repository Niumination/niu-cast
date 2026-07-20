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

/* JADX INFO: loaded from: classes2.dex */
public final class b extends SuspendLambda implements Function2 {
    final /* synthetic */ q7.b $confirmReceiveFileBean;
    final /* synthetic */ String $json;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(q7.b bVar, String str, Continuation<? super b> continuation) {
        super(2, continuation);
        this.$confirmReceiveFileBean = bVar;
        this.$json = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new b(this.$confirmReceiveFileBean, this.$json, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            gc.a("FileTransferProcessor", "confirmReceiveFile:file info:" + this.$confirmReceiveFileBean);
            if (i.f10899k != null) {
                String str = this.$json;
                this.label = 1;
                gc.a("CastSourceFileTransfer", "confirm");
                q7.b bVar = (q7.b) na.b.a(str, q7.b.class);
                gc.a("CastSourceFileTransfer", "confirm:receiveFileBean " + bVar);
                if (bVar != null) {
                    TCCPSourceApi tCCPSourceApi = x7.f.f10882a;
                    List<String> files = bVar.getUrls();
                    String savePath = bVar.getSavePath();
                    boolean isReceive = bVar.getIsReceive();
                    String packageName = bVar.getSavePackage();
                    String id2 = bVar.getId();
                    if (id2 == null) {
                        id2 = "";
                    }
                    String id3 = id2;
                    Intrinsics.checkNotNullParameter(files, "files");
                    Intrinsics.checkNotNullParameter(savePath, "savePath");
                    Intrinsics.checkNotNullParameter(packageName, "packageName");
                    Intrinsics.checkNotNullParameter(id3, "id");
                    Intrinsics.checkNotNullParameter("ConnectSdkProxy", "tag");
                    Intrinsics.checkNotNullParameter("confirmReceiveFile", "log");
                    if (gc.f6462a <= 4) {
                        Log.i(gc.f6463b.concat("ConnectSdkProxy"), "confirmReceiveFile");
                    }
                    x7.f.f10882a.confirmReceiveFile(files, savePath, isReceive, packageName, id3);
                    gc.a("CastSourceFileTransfer", "confirm:confirmReceiveFile " + bVar);
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
        return ((b) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
