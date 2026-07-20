package eb;

import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.transsion.connectx.sdk.TCCPSourceApi;
import com.transsion.pcconnect.invoke.bridge.Device;
import k3.gc;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c0 extends SuspendLambda implements Function2 {
    final /* synthetic */ Device $device;
    final /* synthetic */ boolean $enable;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(Device device, boolean z2, Continuation<? super c0> continuation) {
        super(2, continuation);
        this.$device = device;
        this.$enable = z2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new c0(this.$device, this.$enable, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (li.r0.a(500L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        Device device = g0.f;
        if (device != null) {
            if (Intrinsics.areEqual(device.f2950d, this.$device.f2950d)) {
                String strO = o.d.o("changeAlbumBackupState enable:", this.$enable, "MultiConnectManager", "tag", "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("MultiConnectManager"), strO);
                }
                if (Intrinsics.areEqual(this.$device.f2949c, ExifInterface.GPS_MEASUREMENT_3D)) {
                    TCCPSourceApi tCCPSourceApi = x7.f.f10882a;
                    x7.f.f("SERIVCE_CAPABILITY_ALBUM_BACKUP", String.valueOf(this.$enable));
                }
                return Unit.INSTANCE;
            }
        }
        Intrinsics.checkNotNullParameter("MultiConnectManager", "tag");
        Intrinsics.checkNotNullParameter("changeAlbumBackupState device not connect", "log");
        if (gc.f6462a <= 6) {
            Log.e(gc.f6463b.concat("MultiConnectManager"), "changeAlbumBackupState device not connect");
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(li.g0 g0Var, Continuation<? super Unit> continuation) {
        return ((c0) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
