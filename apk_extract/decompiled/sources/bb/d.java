package bb;

import android.util.Log;
import android.view.View;
import com.transsion.iotservice.multiscreen.pc.helper.BaseSettingActivity;
import k3.gc;
import k3.pb;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class d implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BaseSettingActivity f1232b;

    public /* synthetic */ d(BaseSettingActivity baseSettingActivity, int i8) {
        this.f1231a = i8;
        this.f1232b = baseSettingActivity;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        BaseSettingActivity baseSettingActivity = this.f1232b;
        switch (this.f1231a) {
            case 0:
                int iIntValue = ((Integer) obj).intValue();
                int i8 = BaseSettingActivity.f2662k;
                baseSettingActivity.n().getClass();
                lb.a.f(iIntValue, "multi_device_connection.share_sms_pad");
                String log = "<saveSmsPadSharingSwitch> :" + iIntValue;
                Intrinsics.checkNotNullParameter("SettingViewModel", "tag");
                Intrinsics.checkNotNullParameter(log, "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("SettingViewModel"), log);
                }
                baseSettingActivity.n().f(pb.a());
                break;
            case 1:
                int iIntValue2 = ((Integer) obj).intValue();
                int i9 = BaseSettingActivity.f2662k;
                baseSettingActivity.n().getClass();
                lb.a.f(iIntValue2, "multi_device_connection.share_call_pad");
                String log2 = "<saveCallSharingSwitch> :" + iIntValue2;
                Intrinsics.checkNotNullParameter("SettingViewModel", "tag");
                Intrinsics.checkNotNullParameter(log2, "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("SettingViewModel"), log2);
                }
                baseSettingActivity.n().e(pb.a());
                break;
            case 2:
                View it = (View) obj;
                int i10 = BaseSettingActivity.f2662k;
                Intrinsics.checkNotNullParameter(it, "it");
                baseSettingActivity.getOnBackPressedDispatcher().onBackPressed();
                break;
            default:
                boolean zBooleanValue = ((Boolean) obj).booleanValue();
                int i11 = BaseSettingActivity.f2662k;
                baseSettingActivity.n().getClass();
                lb.a.e("multi_device_connection.allow_find", zBooleanValue);
                String log3 = "<saveDevicesAllowFind> :" + zBooleanValue;
                Intrinsics.checkNotNullParameter("SettingViewModel", "tag");
                Intrinsics.checkNotNullParameter(log3, "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("SettingViewModel"), log3);
                }
                baseSettingActivity.n().d(pb.a());
                break;
        }
        return Unit.INSTANCE;
    }
}
