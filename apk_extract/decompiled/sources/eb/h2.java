package eb;

import android.util.Log;
import com.transsion.connectx.sdk.TCCPListener;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.CastControlViewModel;
import k3.gc;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class h2 extends TCCPListener.Stub {
    @Override // com.transsion.connectx.sdk.TCCPListener
    public final void onEnd() {
        Intrinsics.checkNotNullParameter("SocketServerManager", "tag");
        Intrinsics.checkNotNullParameter("ExtendScreen onEnd", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("SocketServerManager"), "ExtendScreen onEnd");
        }
        CastControlViewModel.f2716m = false;
        bb.v.c(false, false);
        y yVar = y.f4799a;
        y.s(false);
    }

    @Override // com.transsion.connectx.sdk.TCCPListener
    public final void onError(int i8) {
    }

    @Override // com.transsion.connectx.sdk.TCCPListener
    public final void onStart() {
        Intrinsics.checkNotNullParameter("SocketServerManager", "tag");
        Intrinsics.checkNotNullParameter("ExtendScreen onStart", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("SocketServerManager"), "ExtendScreen onStart");
        }
        CastControlViewModel.f2716m = true;
        bb.v.c(true, false);
        y yVar = y.f4799a;
        y.s(true);
        ob.b.f8417b.m();
    }
}
