package eb;

import android.util.Log;
import com.transsion.connectx.sdk.TCCPListener;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.CastControlViewModel;
import k3.gc;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class v1 extends TCCPListener.Stub {
    @Override // com.transsion.connectx.sdk.TCCPListener
    public final void onEnd() {
        Intrinsics.checkNotNullParameter("SocketClientManager", "tag");
        Intrinsics.checkNotNullParameter("video onEnd", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("SocketClientManager"), "video onEnd");
        }
        CastControlViewModel.f2715l = false;
        y yVar = y.f4799a;
        y.u(false);
        bb.v.c(false, true);
    }

    @Override // com.transsion.connectx.sdk.TCCPListener
    public final void onError(int i8) {
    }

    @Override // com.transsion.connectx.sdk.TCCPListener
    public final void onStart() {
        Intrinsics.checkNotNullParameter("SocketClientManager", "tag");
        Intrinsics.checkNotNullParameter("video onStart", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("SocketClientManager"), "video onStart");
        }
        CastControlViewModel.f2715l = true;
        y yVar = y.f4799a;
        y.u(true);
        bb.v.c(true, true);
    }
}
