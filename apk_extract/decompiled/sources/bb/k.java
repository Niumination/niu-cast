package bb;

import android.os.Bundle;
import android.util.Log;
import k3.gc;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class k extends FunctionReferenceImpl implements Function1 {
    public k(Object obj) {
        super(1, obj, l.class, "onSwitchToShareSms", "onSwitchToShareSms(Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z2) {
        l lVar = (l) this.receiver;
        lVar.getClass();
        Intrinsics.checkNotNullParameter("BaseSettingActivity", "tag");
        Intrinsics.checkNotNullParameter("onSwitchToShareSms", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("BaseSettingActivity"), "onSwitchToShareSms");
        }
        ob.b bVar = ob.b.f8417b;
        bVar.getClass();
        String switchTo = z2 ? "turn_on" : "turn_off";
        Intrinsics.checkNotNullParameter(switchTo, "switchTo");
        bVar.f8437a.getClass();
        Intrinsics.checkNotNullParameter(switchTo, "switchTo");
        Bundle bundleD = tj.w.D();
        bundleD.putString("turn_on_or_off", switchTo);
        tj.w.X("iot_multi_con_settings_message_switch_click", bundleD);
        if (Intrinsics.areEqual(Boolean.valueOf(z2), lVar.f1239a.n().f2867g.getValue())) {
            return;
        }
        lb.a.e("multi_device_connection.share_sms", z2);
        String log = "toggleSmsSharingSwitch: newState=" + z2;
        Intrinsics.checkNotNullParameter("SettingViewModel", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("SettingViewModel"), log);
        }
    }
}
