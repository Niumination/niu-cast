package eb;

import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.transsion.iotservice.scan.bean.ScannedDevice;
import k3.gc;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: loaded from: classes2.dex */
public final class e1 implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ li.l f4751b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f4752c;

    public /* synthetic */ e1(Object obj, li.l lVar, int i8) {
        this.f4750a = i8;
        this.f4752c = obj;
        this.f4751b = lVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.f4750a) {
            case 0:
                ScannedDevice device = (ScannedDevice) obj;
                Intrinsics.checkNotNullParameter(device, "device");
                String deviceMac = device.getDeviceMac();
                hc.a aVar = (hc.a) this.f4752c;
                if (StringsKt__StringsJVMKt.equals(deviceMac, aVar.f5288c, true)) {
                    Intrinsics.checkNotNullParameter("PhysicalConnectManager", "tag");
                    Intrinsics.checkNotNullParameter("findTargetNfcDevice found", "log");
                    if (gc.f6462a <= 4) {
                        Log.i(gc.f6463b.concat("PhysicalConnectManager"), "findTargetNfcDevice found");
                    }
                    aVar.a(device.getDeviceMac());
                    na.a.b(this.f4751b, device);
                }
                break;
            default:
                boolean zBooleanValue = ((Boolean) obj).booleanValue();
                li.g2 g2Var = ((ic.r) this.f4752c).f5742b;
                if (g2Var != null) {
                    g2Var.h(null);
                }
                li.l lVar = this.f4751b;
                if (zBooleanValue) {
                    na.a.b(lVar, new hc.b(true, null, null, null, 0, null, 0, 0, null, TypedValues.PositionType.TYPE_POSITION_TYPE));
                } else {
                    na.a.b(lVar, new hc.b(false, null, null, null, 0, null, 0, 0, null, TypedValues.PositionType.TYPE_POSITION_TYPE));
                }
                break;
        }
        return Unit.INSTANCE;
    }
}
