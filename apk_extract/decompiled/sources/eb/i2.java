package eb;

import android.util.Log;
import com.transsion.connectx.sdk.TCCPListener;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.CastControlViewModel;
import k3.gc;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class i2 extends TCCPListener.Stub {
    @Override // com.transsion.connectx.sdk.TCCPListener
    public final void onEnd() {
        Intrinsics.checkNotNullParameter("SocketServerManager", "tag");
        Intrinsics.checkNotNullParameter("MirrorCast onEnd", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("SocketServerManager"), "MirrorCast onEnd");
        }
        CastControlViewModel.f2715l = false;
        bb.v.c(false, true);
        y yVar = y.f4799a;
        y.u(false);
    }

    @Override // com.transsion.connectx.sdk.TCCPListener
    public final void onError(int i8) {
    }

    @Override // com.transsion.connectx.sdk.TCCPListener
    public final void onStart() {
        Intrinsics.checkNotNullParameter("SocketServerManager", "tag");
        Intrinsics.checkNotNullParameter("MirrorCast onStart", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("SocketServerManager"), "MirrorCast onStart");
        }
        CastControlViewModel.f2715l = true;
        bb.v.c(true, true);
        y yVar = y.f4799a;
        y.u(true);
    }
}
