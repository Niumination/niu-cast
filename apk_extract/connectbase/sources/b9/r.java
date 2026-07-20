package b9;

import android.graphics.Rect;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.IScrollCaptureConnection;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f791a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IScrollCaptureConnection f792b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Rect f793c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Rect f794d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f795e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f796f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ArrayList<String> f797g = new ArrayList<>();

    public void a() {
        IScrollCaptureConnection iScrollCaptureConnection = this.f792b;
        if (iScrollCaptureConnection != null) {
            try {
                iScrollCaptureConnection.close();
            } catch (RemoteException unused) {
            }
            this.f792b = null;
        }
    }

    public Rect b() {
        return this.f794d;
    }

    public Object c() {
        return this.f792b;
    }

    public IBinder d() {
        IScrollCaptureConnection iScrollCaptureConnection = this.f792b;
        if (iScrollCaptureConnection != null) {
            return iScrollCaptureConnection.asBinder();
        }
        return null;
    }

    public boolean e() {
        return this.f792b == null;
    }

    public String f() {
        return this.f791a;
    }

    public ArrayList<String> g() {
        return this.f797g;
    }

    public String h() {
        return this.f796f;
    }

    public Rect i() {
        return this.f793c;
    }

    public String j() {
        return this.f795e;
    }

    public boolean k() {
        IScrollCaptureConnection iScrollCaptureConnection = this.f792b;
        return iScrollCaptureConnection != null && iScrollCaptureConnection.asBinder().isBinderAlive();
    }
}
