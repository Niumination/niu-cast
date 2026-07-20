package eb;

import android.app.NotificationManager;
import android.os.Handler;
import android.util.Log;
import com.transsion.connectx.sdk.TCCPListener;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.CastControlViewModel;
import k3.gc;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class s1 extends TCCPListener.Stub {
    @Override // com.transsion.connectx.sdk.TCCPListener
    public final void onEnd() {
        Intrinsics.checkNotNullParameter("SocketClientManager", "tag");
        Intrinsics.checkNotNullParameter("castExtend onEnd", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("SocketClientManager"), "castExtend onEnd");
        }
        CastControlViewModel.f2716m = false;
        y yVar = y.f4799a;
        y.s(false);
        bb.v.c(false, false);
    }

    @Override // com.transsion.connectx.sdk.TCCPListener
    public final void onError(int i8) {
    }

    @Override // com.transsion.connectx.sdk.TCCPListener
    public final void onStart() {
        Intrinsics.checkNotNullParameter("SocketClientManager", "tag");
        Intrinsics.checkNotNullParameter("castExtend onStart", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("SocketClientManager"), "castExtend onStart");
        }
        CastControlViewModel.f2716m = true;
        y yVar = y.f4799a;
        y.s(true);
        NotificationManager notificationManager = bb.v.f1256a;
        ((Handler) bb.v.f1260g.getValue()).post(new bb.u(true, false, true));
    }
}
