package k6;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.transsion.athena.data.TrackDataWrapper;

/* JADX INFO: loaded from: classes2.dex */
public class h implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f9130a;

    public h(g gVar) {
        this.f9130a = gVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            this.f9130a.f9122c = l3.a.AbstractBinderC0253a.O(iBinder);
            this.f9130a.f9123d = true;
            y3.b.f("AthenaTrackService onServiceConnected");
            for (TrackDataWrapper trackDataWrapper : this.f9130a.f9124e) {
                if (trackDataWrapper.c().s() < 524288) {
                    this.f9130a.G(trackDataWrapper.a(), trackDataWrapper.c(), trackDataWrapper.b());
                } else {
                    y3.b.d("TrackData size is too large, ignored !!");
                }
            }
            this.f9130a.f9124e.clear();
        } catch (Exception e10) {
            y3.b.d(Log.getStackTraceString(e10));
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f9130a.f9123d = false;
        y3.b.f("AthenaTrackService onServiceDisconnected");
    }
}
