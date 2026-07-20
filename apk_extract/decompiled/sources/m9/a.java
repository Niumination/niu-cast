package m9;

import android.app.ActivityManager;
import android.os.RemoteException;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.app.ITranActivityTaskManager;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements x9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ITranActivityTaskManager f7951a = ITranActivityTaskManager.Stub.asInterface(TranServiceManager.getServiceIBinder("activity_task"));

    @Override // x9.a
    public final ActivityManager.RunningTaskInfo a() {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7951a;
        if (iTranActivityTaskManager == null) {
            return null;
        }
        try {
            return iTranActivityTaskManager.getTopTask(0);
        } catch (RemoteException e) {
            j9.a.b("a", "getTopTask fail " + e);
            return null;
        }
    }

    public final /* synthetic */ Boolean b() {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7951a;
        return iTranActivityTaskManager != null ? Boolean.valueOf(iTranActivityTaskManager.isSplitScreen()) : Boolean.FALSE;
    }

    @Override // x9.a
    public final boolean hasMultiWindow() {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7951a;
        if (iTranActivityTaskManager == null) {
            return false;
        }
        try {
            return iTranActivityTaskManager.hasMultiWindow();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // x9.a
    public final boolean isSplitScreen() {
        Boolean boolB;
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            boolB = b();
        } catch (RemoteException e) {
            g9.a.d("activity_task", e);
            boolB = null;
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        if (jCurrentTimeMillis2 >= 200) {
            g9.a.e("activity_task", jCurrentTimeMillis2);
        }
        boolean zBooleanValue = boolB.booleanValue();
        j9.a.c("a", "isSplitScreen :" + zBooleanValue);
        return zBooleanValue;
    }
}
