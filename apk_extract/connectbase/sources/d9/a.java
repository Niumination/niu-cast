package d9;

import android.app.WallpaperInfo;
import android.app.WallpaperManager;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import dc.e;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class a implements nh.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f3628c = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f3629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WallpaperManager f3630b;

    public a() {
        Context contextA = bc.a.a();
        this.f3629a = contextA;
        this.f3630b = (WallpaperManager) contextA.getSystemService("wallpaper");
    }

    @Override // nh.a
    public Bitmap a(int i10, boolean z10, int i11) {
        Class<?> cls = this.f3630b.getClass();
        Class cls2 = Integer.TYPE;
        Method methodG = cc.a.g(cls, "getBitmapAsUser", cls2, Boolean.TYPE, cls2);
        if (methodG != null) {
            return (Bitmap) cc.a.j(methodG, this.f3630b, Integer.valueOf(i10), Boolean.valueOf(z10), Integer.valueOf(i11));
        }
        return null;
    }

    @Override // nh.a
    public WallpaperInfo b(int i10) {
        try {
            return (WallpaperInfo) cc.a.j(cc.a.g(this.f3630b.getClass(), "getWallpaperInfo", Integer.TYPE), this.f3630b, Integer.valueOf(i10));
        } catch (Exception e10) {
            e.n(f3628c, "getWallpaperInfo: e = " + e10);
            return null;
        }
    }

    @Override // nh.a
    public void c(ComponentName componentName) {
        cc.a.j(cc.a.g(this.f3630b.getClass(), "setWallpaperComponent", ComponentName.class), this.f3630b, componentName);
    }
}
