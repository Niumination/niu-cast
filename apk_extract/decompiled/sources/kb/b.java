package kb;

import android.provider.Settings;
import android.util.Log;
import com.transsion.connectx.sdk.TCCPSourceApi;
import com.transsion.iotservice.multiscreen.pc.service.KeepLiveService;
import eb.k1;
import jb.h;
import k3.gc;
import k3.o1;
import k3.pb;
import k3.rb;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import li.g0;
import li.g2;
import o.d;
import x7.f;
import x7.i;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends SuspendLambda implements Function2 {
    int label;
    final /* synthetic */ KeepLiveService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(KeepLiveService keepLiveService, Continuation<? super b> continuation) {
        super(2, continuation);
        this.this$0 = keepLiveService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new b(this.this$0, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x007c  */
    /* JADX WARN: Code duplicated, block: B:25:0x0089  */
    /* JADX WARN: Code duplicated, block: B:27:0x0095  */
    /* JADX WARN: Code duplicated, block: B:30:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:32:0x00a6 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        KeepLiveService keepLiveService;
        Unit unitI;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            i iVar = i.f10886a;
            boolean z2 = Settings.Global.getInt(pb.a().getContentResolver(), "connectx.cast.status.service.enabled", 0) == 1;
            String strO = d.o("resetConnectionState:is pc connect: ", z2, "KeepLiveService", "tag", "log");
            if (gc.f6462a <= 3) {
                Log.d(gc.f6463b.concat("KeepLiveService"), strO);
            }
            rb.b();
            if (z2) {
                TCCPSourceApi tCCPSourceApi = f.f10882a;
                this.label = 1;
                if (f.e(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                f.k();
                keepLiveService = this.this$0;
                this.label = 2;
                g2 g2Var = KeepLiveService.f2675b;
                keepLiveService.getClass();
                if (o1.a(keepLiveService, CollectionsKt.listOf(h.f6139b)).isEmpty()) {
                    k1 k1Var = k1.f4765a;
                    unitI = k1.i();
                    if (unitI != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        unitI = Unit.INSTANCE;
                    }
                } else {
                    Intrinsics.checkNotNullParameter("KeepLiveService", "tag");
                    Intrinsics.checkNotNullParameter("resetConnection:no permission to reset p2p device", "log");
                    if (gc.f6462a <= 6) {
                        Log.e(gc.f6463b.concat("KeepLiveService"), "resetConnection:no permission to reset p2p device");
                    }
                    unitI = Unit.INSTANCE;
                }
                if (unitI == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i8 == 1) {
            ResultKt.throwOnFailure(obj);
            f.k();
            keepLiveService = this.this$0;
            this.label = 2;
            g2 g2Var2 = KeepLiveService.f2675b;
            keepLiveService.getClass();
            if (o1.a(keepLiveService, CollectionsKt.listOf(h.f6139b)).isEmpty()) {
                Intrinsics.checkNotNullParameter("KeepLiveService", "tag");
                Intrinsics.checkNotNullParameter("resetConnection:no permission to reset p2p device", "log");
                if (gc.f6462a <= 6) {
                    Log.e(gc.f6463b.concat("KeepLiveService"), "resetConnection:no permission to reset p2p device");
                }
                unitI = Unit.INSTANCE;
            } else {
                k1 k1Var2 = k1.f4765a;
                unitI = k1.i();
                if (unitI != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    unitI = Unit.INSTANCE;
                }
            }
            if (unitI == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i8 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        i iVar2 = i.f10886a;
        i.a(pb.a());
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((b) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
