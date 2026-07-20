package xa;

import android.os.SystemClock;
import android.util.Log;
import com.transsion.capability.bean.FileInfo;
import java.util.ArrayList;
import java.util.UUID;
import k3.gc;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import li.g0;
import v4.q;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends SuspendLambda implements Function2 {
    final /* synthetic */ q7.h $fileInfo;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(q7.h hVar, Continuation<? super h> continuation) {
        super(2, continuation);
        this.$fileInfo = hVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new h(this.$fileInfo, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            String strM = o.d.m("setFileIdToSendFileInfo: fileInfoBean type: ", "FileTransferProcessor", "tag", "log", this.$fileInfo.getType());
            if (gc.f6462a <= 3) {
                Log.d(gc.f6463b.concat("FileTransferProcessor"), strM);
            }
            i.f10896h = 0L;
            boolean z2 = this.$fileInfo.getType() == 5 || this.$fileInfo.getType() == 3;
            if (z2 || this.$fileInfo.getType() == 1) {
                for (FileInfo fileInfo : this.$fileInfo.getFileInfoList()) {
                    fileInfo.g(UUID.randomUUID().toString());
                    long j8 = i.f10896h;
                    if (j8 <= 10000000) {
                        i.f10896h = fileInfo.getFileSize() + j8;
                    }
                    String strN = o.d.n("setFileIdToSendFileInfo: fileId:", fileInfo.getId(), "FileTransferProcessor", "tag", "log");
                    if (gc.f6462a <= 3) {
                        Log.d(gc.f6463b.concat("FileTransferProcessor"), strN);
                    }
                }
                if (z2) {
                    ob.b bVar = ob.b.f8417b;
                    ArrayList fileInfoList = this.$fileInfo.getFileInfoList();
                    bVar.getClass();
                    if (fileInfoList != null && !fileInfoList.isEmpty()) {
                        ob.b.f8429r = fileInfoList;
                        ob.b.p = SystemClock.elapsedRealtime();
                        ArrayList arrayList = ob.b.f8429r;
                        ob.b.q = arrayList != null ? arrayList.size() : 0;
                        ob.b.u = ob.b.f(fileInfoList);
                    }
                }
                q qVar = na.b.f8132a;
                String strB = na.b.b(this.$fileInfo);
                s7.d dVar = (s7.d) o7.a.b("com.transsion.file");
                if (dVar != null) {
                    this.label = 1;
                    if (dVar.c(strB) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
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
        return ((h) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
