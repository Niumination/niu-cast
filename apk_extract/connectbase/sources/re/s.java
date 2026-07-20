package re;

import android.graphics.Bitmap;
import android.os.RemoteException;
import android.view.WindowManager;
import com.android.internal.annotations.VisibleForTesting;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.view.ITranWindowManager;
import com.transsion.hubsdk.view.TranWindowManager;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class s implements lh.p {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f14489c = "s";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranWindowManager f14490a = ITranWindowManager.Stub.asInterface(TranServiceManager.getServiceIBinder("window"));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TranWindowManager.TranLayoutParams f14491b;

    @Override // lh.p
    public void b(final WindowManager.LayoutParams layoutParams) {
        new zb.f().c(new zb.f.b() { // from class: re.p
            @Override // zb.f.b
            public final Object run() {
                return this.f14481a.u(layoutParams);
            }
        }, "window");
    }

    @Override // lh.p
    public void c(WindowManager.LayoutParams layoutParams, int i10) {
        r().setInputFeatures(layoutParams, i10);
    }

    @Override // lh.p
    public String d() {
        ITranWindowManager iTranWindowManager = this.f14490a;
        if (iTranWindowManager == null) {
            return "";
        }
        try {
            return iTranWindowManager.getRefreshRateConfigList();
        } catch (RemoteException e10) {
            dc.e.d(f14489c, "getRefreshRateConfigList RemoteException: ", e10);
            return "";
        }
    }

    @Override // lh.p
    public void e(String str) {
        ITranWindowManager iTranWindowManager = this.f14490a;
        if (iTranWindowManager != null) {
            try {
                iTranWindowManager.setRefreshRateConfigList(str);
            } catch (RemoteException e10) {
                dc.e.d(f14489c, "getRefreshRateConfigList RemoteException: ", e10);
            }
        }
    }

    @Override // lh.p
    public int[] f() {
        ITranWindowManager iTranWindowManager = this.f14490a;
        if (iTranWindowManager == null) {
            return null;
        }
        try {
            return iTranWindowManager.getTranPictureSupportMode();
        } catch (RemoteException e10) {
            j7.b.a("getTranPictureSupportMode fail:", e10, f14489c);
            return null;
        }
    }

    @Override // lh.p
    public void g(int i10, String str) {
        ITranWindowManager iTranWindowManager = this.f14490a;
        if (iTranWindowManager != null) {
            try {
                iTranWindowManager.setTranPictureMode(i10, str);
            } catch (RemoteException e10) {
                j7.b.a("setTranPictureMode fail:", e10, f14489c);
            }
        }
    }

    @Override // lh.p
    public void h(final WindowManager.LayoutParams layoutParams, final int i10) {
        new zb.f().c(new zb.f.b() { // from class: re.q
            @Override // zb.f.b
            public final Object run() {
                return this.f14483a.t(layoutParams, i10);
            }
        }, "window");
    }

    @Override // lh.p
    public boolean i() {
        try {
            ITranWindowManager iTranWindowManager = this.f14490a;
            if (iTranWindowManager != null) {
                return iTranWindowManager.isOccluded();
            }
            return false;
        } catch (RemoteException e10) {
            dc.e.c(f14489c, "isOccluded error: " + e10.getMessage());
            return false;
        }
    }

    @Override // lh.p
    public String j() {
        ITranWindowManager iTranWindowManager = this.f14490a;
        if (iTranWindowManager == null) {
            return "";
        }
        try {
            return iTranWindowManager.getDefaultRefreshRateConfigList();
        } catch (RemoteException e10) {
            dc.e.d(f14489c, "getDefaultRefreshRateConfigList RemoteException: ", e10);
            return "";
        }
    }

    @Override // lh.p
    public int k(String str) {
        ITranWindowManager iTranWindowManager = this.f14490a;
        if (iTranWindowManager == null) {
            return 0;
        }
        try {
            return iTranWindowManager.getAppRefreshRate(str);
        } catch (RemoteException e10) {
            dc.e.d(f14489c, "getAppRefreshRate RemoteException: ", e10);
            return 0;
        }
    }

    @Override // lh.p
    public int l(WindowManager.LayoutParams layoutParams) {
        return r().getPrivateFlags(layoutParams);
    }

    @Override // lh.p
    public void m(final WindowManager.LayoutParams layoutParams, final int i10) {
        new zb.f().c(new zb.f.b() { // from class: re.r
            @Override // zb.f.b
            public final Object run() {
                return this.f14486a.s(layoutParams, i10);
            }
        }, "window");
    }

    @Override // lh.p
    public Bitmap n() {
        ITranWindowManager iTranWindowManager = this.f14490a;
        if (iTranWindowManager == null) {
            return null;
        }
        try {
            return iTranWindowManager.tranScreenshotWallpaperLocked();
        } catch (RemoteException e10) {
            j7.b.a("tranScreenshotWallpaperLocked fail", e10, f14489c);
            return null;
        }
    }

    @Override // lh.p
    public List<String> o(int i10) {
        ITranWindowManager iTranWindowManager = this.f14490a;
        if (iTranWindowManager == null) {
            return null;
        }
        try {
            return iTranWindowManager.getTranPictureList(i10);
        } catch (RemoteException e10) {
            j7.b.a("getTranPictureList fail:", e10, f14489c);
            return null;
        }
    }

    public final TranWindowManager.TranLayoutParams r() {
        if (this.f14491b == null) {
            this.f14491b = new TranWindowManager.TranLayoutParams();
        }
        return this.f14491b;
    }

    public final /* synthetic */ Object s(WindowManager.LayoutParams layoutParams, int i10) throws RemoteException {
        r().setCutoutMode(layoutParams, i10);
        return null;
    }

    public final /* synthetic */ Object t(WindowManager.LayoutParams layoutParams, int i10) throws RemoteException {
        r().setPrivateFlags(layoutParams, i10);
        return null;
    }

    public final /* synthetic */ Object u(WindowManager.LayoutParams layoutParams) throws RemoteException {
        r().setTrustedOverlay(layoutParams);
        return null;
    }

    @VisibleForTesting
    public void v(ITranWindowManager iTranWindowManager) {
        this.f14490a = iTranWindowManager;
    }
}
