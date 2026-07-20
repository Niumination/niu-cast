package mc;

import android.appwidget.AppWidgetProviderInfo;
import android.os.RemoteException;
import com.android.internal.annotations.VisibleForTesting;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.appwidget.ITranAppWidgetManager;
import dc.e;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a implements ff.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f10630b = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranAppWidgetManager f10631a = ITranAppWidgetManager.Stub.asInterface(TranServiceManager.getServiceIBinder("appwidget"));

    @Override // ff.a
    public List<AppWidgetProviderInfo> a(int i10) {
        try {
            return this.f10631a.getInstalledProviders(i10);
        } catch (RemoteException e10) {
            e.o(f10630b, "getInstalledProviders: ", e10);
            return Collections.EMPTY_LIST;
        }
    }

    @VisibleForTesting
    public void b(ITranAppWidgetManager iTranAppWidgetManager) {
        this.f10631a = iTranAppWidgetManager;
    }
}
