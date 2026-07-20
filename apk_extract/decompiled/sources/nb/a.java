package nb;

import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.transsion.flamboyant.FoldableDeviceManager;
import com.transsion.iotservice.multiscreen.pc.state.DeviceConnectState;
import kotlin.jvm.internal.Intrinsics;
import tj.w;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements FoldableDeviceManager.StateChangedListener {
    @Override // com.transsion.flamboyant.FoldableDeviceManager.StateChangedListener
    public final void onStateChangedListener(int i8, int i9) {
        String status;
        ob.b bVar = ob.b.f8417b;
        bVar.getClass();
        if (ob.b.h()) {
            status = "casting";
        } else if (!DeviceConnectState.INSTANCE.isConnected()) {
            return;
        } else {
            status = "others";
        }
        if (i9 == 0 || i9 == 2) {
            Intrinsics.checkNotNullParameter(status, "status");
            bVar.f8437a.getClass();
            Intrinsics.checkNotNullParameter(status, "status");
            Bundle bundle = new Bundle();
            bundle.putString(NotificationCompat.CATEGORY_STATUS, status);
            bundle.putString("switch_to", w.z());
            w.X("iot_pc_con_fold_or_unfold", bundle);
        }
    }
}
