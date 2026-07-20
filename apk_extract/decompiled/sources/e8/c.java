package e8;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.util.Log;
import com.transsion.athena.data.TrackDataWrapper;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f4718a;

    public c(b bVar) {
        this.f4718a = bVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        k6.b bVar;
        b bVar2 = this.f4718a;
        try {
            int i8 = p6.a.f8700b;
            if (iBinder == null) {
                bVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.transsion.athena.IAthenaTrackInterface");
                if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof k6.b)) {
                    k6.a aVar = new k6.a();
                    aVar.f6779b = iBinder;
                    bVar = aVar;
                } else {
                    bVar = (k6.b) iInterfaceQueryLocalInterface;
                }
            }
            bVar2.f4717d = bVar;
            bVar2.f4714a = true;
            z6.a.e("AthenaTrackService onServiceConnected");
            CopyOnWriteArrayList<TrackDataWrapper> copyOnWriteArrayList = (CopyOnWriteArrayList) bVar2.e;
            for (TrackDataWrapper trackDataWrapper : copyOnWriteArrayList) {
                if (trackDataWrapper.f2322b.h() < 524288) {
                    String str = trackDataWrapper.f2321a;
                    if (str == null) {
                        str = "";
                    }
                    bVar2.i(str, trackDataWrapper.f2322b, trackDataWrapper.f2323c);
                } else {
                    z6.a.c("TrackData size is too large, ignored !!");
                }
            }
            copyOnWriteArrayList.clear();
        } catch (Exception e) {
            z6.a.c(Log.getStackTraceString(e));
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f4718a.f4714a = false;
        z6.a.e("AthenaTrackService onServiceDisconnected");
    }
}
