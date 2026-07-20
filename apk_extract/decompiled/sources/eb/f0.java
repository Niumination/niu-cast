package eb;

import android.util.Log;
import com.transsion.iotservice.multiscreen.pc.service.KeepLiveService;
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
public final class f0 extends SuspendLambda implements Function2 {
    final /* synthetic */ Device $device;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f0(Device device, Continuation<? super f0> continuation) {
        super(2, continuation);
        this.$device = device;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new f0(this.$device, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0056 A[PHI: r2
      0x0056: PHI (r2v7 java.lang.String) = (r2v4 java.lang.String), (r2v5 java.lang.String), (r2v6 java.lang.String), (r2v8 java.lang.String) binds: [B:31:0x0075, B:28:0x006c, B:24:0x005e, B:20:0x0053] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Device device;
        int i8;
        String str;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = this.label;
        try {
            if (i9 != 0) {
                if (i9 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i9 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            y yVar = y.f4799a;
            this.label = 1;
            if (yVar.d(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            i8 = Integer.parseInt(device.f2949c);
        } catch (Exception unused) {
            Intrinsics.checkNotNullParameter("MultiConnectManager", "tag");
            Intrinsics.checkNotNullParameter("getConnectableDevice type error", "log");
            if (gc.f6462a <= 6) {
                Log.e(gc.f6463b.concat("MultiConnectManager"), "getConnectableDevice type error");
            }
            i8 = -1;
        }
        li.g2 g2Var = KeepLiveService.f2675b;
        if (g2Var != null) {
            g2Var.h(null);
        }
        g0 g0Var = g0.f4753a;
        device = this.$device;
        this.label = 2;
        k1 k1Var = k1.f4765a;
        String connectType = g0.f4755c.getConnectType();
        String str2 = "ble";
        switch (connectType.hashCode()) {
            case -144503053:
                str = "ble_from_peer";
                if (connectType.equals("ble_from_peer")) {
                    str2 = str;
                }
                break;
            case 3617:
                str = "qr";
                if (connectType.equals("qr")) {
                    str2 = str;
                }
                break;
            case 97627:
                connectType.equals("ble");
                break;
            case 108971:
                str = "nfc";
                if (connectType.equals("nfc")) {
                    str2 = str;
                }
                break;
            case 94415933:
                str = "cable";
                if (connectType.equals("cable")) {
                    str2 = str;
                }
                break;
        }
        k1.j(str2);
        hc.c device2 = new hc.c();
        String str3 = device.f2948b;
        Intrinsics.checkNotNullParameter(str3, "<set-?>");
        device2.f5287b = str3;
        String str4 = device.f2947a;
        Intrinsics.checkNotNullParameter(str4, "<set-?>");
        device2.f5286a = str4;
        device2.f = i8;
        Intrinsics.checkNotNullParameter(str4, "<set-?>");
        device2.f5288c = str4;
        String ip = device.f2950d;
        Intrinsics.checkNotNullParameter(device2, "device");
        Intrinsics.checkNotNullParameter(ip, "ip");
        k1.e = device2;
        k1.f4767c = ip;
        Object objE = y.f4799a.e(device, this);
        if (objE != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            objE = Unit.INSTANCE;
        }
        if (objE == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(li.g0 g0Var, Continuation<? super Unit> continuation) {
        return ((f0) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
