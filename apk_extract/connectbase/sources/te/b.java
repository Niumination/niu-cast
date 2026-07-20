package te;

import android.app.WallpaperInfo;
import android.content.ComponentName;
import android.graphics.Bitmap;
import android.os.RemoteException;
import com.android.internal.annotations.VisibleForTesting;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.app.ITranWallpaperManager;
import dc.e;
import zb.f;

/* JADX INFO: loaded from: classes2.dex */
public class b implements nh.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f15559b = "b";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranWallpaperManager f15560a = ITranWallpaperManager.Stub.asInterface(TranServiceManager.getServiceIBinder("wallpaper"));

    @Override // nh.a
    public Bitmap a(int i10, boolean z10, int i11) {
        try {
            ITranWallpaperManager iTranWallpaperManager = this.f15560a;
            if (iTranWallpaperManager != null) {
                return iTranWallpaperManager.getBitmapAsUser(i10, z10, i11);
            }
            return null;
        } catch (RemoteException e10) {
            e.d(f15559b, "getBitmapAsUser: ", e10);
            return null;
        }
    }

    @Override // nh.a
    public WallpaperInfo b(int i10) {
        try {
            return this.f15560a.getWallpaperInfo(i10);
        } catch (RemoteException e10) {
            e.o(f15559b, "getWallpaperInfo: ", e10);
            return null;
        }
    }

    @Override // nh.a
    public void c(final ComponentName componentName) {
        new f().c(new f.b() { // from class: te.a
            @Override // zb.f.b
            public final Object run() {
                return this.f15557a.e(componentName);
            }
        }, "wallpaper");
        e.a(f15559b, "setWallpaperComponent name:" + componentName);
    }

    public final /* synthetic */ Object e(ComponentName componentName) throws RemoteException {
        ITranWallpaperManager iTranWallpaperManager = this.f15560a;
        if (iTranWallpaperManager == null) {
            return null;
        }
        iTranWallpaperManager.setWallpaperComponent(componentName);
        return null;
    }

    @VisibleForTesting
    public void f(ITranWallpaperManager iTranWallpaperManager) {
        this.f15560a = iTranWallpaperManager;
    }
}
