package e8;

import android.os.RemoteException;
import androidx.camera.core.CameraX;
import androidx.camera.core.impl.DeferrableSurfaces;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.transsion.athena.data.TrackData;
import java.util.Locale;
import java.util.concurrent.Executor;
import m4.l;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f4707b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f4708c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f4709d;
    public final /* synthetic */ Object e;

    public /* synthetic */ a(CameraX cameraX, Executor executor, long j8, CallbackToFutureAdapter.Completer completer) {
        this.f4706a = 1;
        this.f4708c = cameraX;
        this.f4709d = executor;
        this.f4707b = j8;
        this.e = completer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4706a) {
            case 0:
                String str = (String) this.f4709d;
                TrackData trackData = (TrackData) this.e;
                long j8 = this.f4707b;
                b bVar = (b) this.f4708c;
                bVar.getClass();
                try {
                    ((k6.b) bVar.f4717d).f(str, trackData, j8);
                    z6.a.a(String.format(Locale.getDefault(), "TrackByAidl tid : %d, eventName : %s", Long.valueOf(j8), str));
                } catch (RemoteException e) {
                    z6.a.c("TrackByAidl " + e.getMessage());
                    return;
                }
                break;
            case 1:
                ((CameraX) this.f4708c).lambda$initAndRetryRecursively$1((Executor) this.f4709d, this.f4707b, (CallbackToFutureAdapter.Completer) this.e);
                break;
            default:
                DeferrableSurfaces.lambda$surfaceListWithTimeout$1((Executor) this.f4708c, (l) this.f4709d, (CallbackToFutureAdapter.Completer) this.e, this.f4707b);
                break;
        }
    }

    public /* synthetic */ a(Object obj, Object obj2, Object obj3, long j8, int i8) {
        this.f4706a = i8;
        this.f4708c = obj;
        this.f4709d = obj2;
        this.e = obj3;
        this.f4707b = j8;
    }
}
