package eb;

import android.util.Log;
import com.transsion.capability.bean.FileInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import k3.gc;
import k3.pb;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class v extends SuspendLambda implements Function2 {
    final /* synthetic */ List<FileInfo> $fileList;
    final /* synthetic */ int $transferType;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(List<FileInfo> list, int i8, Continuation<? super v> continuation) {
        super(2, continuation);
        this.$fileList = list;
        this.$transferType = i8;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new v(this.$fileList, this.$transferType, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        List<FileInfo> list = this.$fileList;
        int i8 = this.$transferType;
        ArrayList arrayList = new ArrayList(list);
        String packageName = pb.a().getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
        q7.h fileInfoBean = new q7.h(arrayList, packageName, i8, "");
        sj.a aVar = xa.i.f10891a;
        Intrinsics.checkNotNullParameter(fileInfoBean, "fileInfoBean");
        if (fileInfoBean.getType() == 3 && !o7.a.c("com.transsion.transfer_files_with_gesture")) {
            Intrinsics.checkNotNullParameter("FileTransferProcessor", "tag");
            Intrinsics.checkNotNullParameter("sendFileInfo:no gesture transfer ability", "log");
            if (gc.f6462a <= 6) {
                Log.e(gc.f6463b.concat("FileTransferProcessor"), "sendFileInfo:no gesture transfer ability");
            }
            m3.u.c(pb.a());
        } else if (fileInfoBean.getType() != 5 || o7.a.c("com.transsion.copy_files_with_gesture")) {
            gc.a("FileTransferProcessor", "sendFileInfo:type: " + fileInfoBean.getType() + "," + fileInfoBean.getFileInfoList());
            ConcurrentLinkedQueue concurrentLinkedQueue = xa.i.e;
            concurrentLinkedQueue.add(fileInfoBean);
            if (concurrentLinkedQueue.size() == 1 && xa.i.f10895g.isEmpty()) {
                gc.a("FileTransferProcessor", "sendFileInfo--->executeTask");
                xa.i.d();
            } else {
                gc.a("FileTransferProcessor", "sendFileInfo");
                if (fileInfoBean.getType() == 3 || fileInfoBean.getType() == 5) {
                    gc.a("FileTransferProcessor", "sendFileInfo--->toastQueueing");
                    m3.u.d(pb.a());
                }
            }
        } else {
            Intrinsics.checkNotNullParameter("FileTransferProcessor", "tag");
            Intrinsics.checkNotNullParameter("sendFileInfo:no gesture copy ability", "log");
            if (gc.f6462a <= 6) {
                Log.e(gc.f6463b.concat("FileTransferProcessor"), "sendFileInfo:no gesture copy ability");
            }
            m3.u.c(pb.a());
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(li.g0 g0Var, Continuation<? super Unit> continuation) {
        return ((v) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
