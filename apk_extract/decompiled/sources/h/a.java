package h;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.core.app.NotificationCompat;
import com.transsion.flamboyant.FoldableDeviceManager;
import com.transsion.iotservice.multiscreen.pc.state.DeviceConnectState;
import dc.h;
import java.util.concurrent.Executor;
import k3.gc;
import k3.pb;
import kotlin.jvm.internal.Intrinsics;
import ob.b;
import tj.w;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5226a;

    public /* synthetic */ a(int i8) {
        this.f5226a = i8;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        String status;
        switch (this.f5226a) {
            case 0:
                ArchTaskExecutor.lambda$static$0(runnable);
                break;
            case 1:
                ArchTaskExecutor.lambda$static$1(runnable);
                break;
            case 2:
                Application context = pb.a();
                Intrinsics.checkNotNullParameter(context, "context");
                try {
                    h.f4410b = FoldableDeviceManager.get(context);
                } catch (Exception e) {
                    Intrinsics.checkNotNullParameter("FoldableDeviceManagerPr", "tag");
                    Intrinsics.checkNotNullParameter(e, "e");
                    Log.e(gc.f6463b.concat("FoldableDeviceManagerPr"), e.getMessage(), e);
                }
                FoldableDeviceManager foldableDeviceManager = h.f4410b;
                int currentFoldState = foldableDeviceManager != null ? foldableDeviceManager.getCurrentFoldState() : 0;
                b bVar = b.f8417b;
                bVar.getClass();
                if (!b.h()) {
                    status = DeviceConnectState.INSTANCE.isConnected() ? "others" : "casting";
                }
                if (currentFoldState == 0 || currentFoldState == 2) {
                    Intrinsics.checkNotNullParameter(status, "status");
                    bVar.f8437a.getClass();
                    Intrinsics.checkNotNullParameter(status, "status");
                    Bundle bundle = new Bundle();
                    bundle.putString(NotificationCompat.CATEGORY_STATUS, status);
                    bundle.putString("switch_to", w.z());
                    w.X("iot_pc_con_fold_or_unfold", bundle);
                }
                break;
            default:
                runnable.run();
                break;
        }
    }
}
