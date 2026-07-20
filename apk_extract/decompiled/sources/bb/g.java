package bb;

import android.util.Log;
import k3.gc;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class g extends FunctionReferenceImpl implements Function1 {
    public g(Object obj) {
        super(1, obj, l.class, "onSwitchToCopyPaste", "onSwitchToCopyPaste(Z)V", 0);
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
        Intrinsics.checkNotNullParameter("onSwitchToShareNetwork", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("BaseSettingActivity"), "onSwitchToShareNetwork");
        }
        ob.b.f8417b.f8437a.getClass();
        tj.w.X("iot_multi_con_shareclipboard_settings_switch", tj.w.D());
        if (Intrinsics.areEqual(Boolean.valueOf(z2), lVar.f1239a.n().e.getValue())) {
            return;
        }
        lb.a.e("clipboard_shared_enabled", z2);
        String log = "toggleCopyPasteSwitch: newState=" + z2;
        Intrinsics.checkNotNullParameter("SettingViewModel", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("SettingViewModel"), log);
        }
    }
}
