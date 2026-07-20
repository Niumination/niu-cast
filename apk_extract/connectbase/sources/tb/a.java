package tb;

import android.app.WallpaperInfo;
import android.content.ComponentName;
import android.graphics.Bitmap;
import dc.e;
import te.b;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f15550c = "a";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f15551d = "package name should not be null";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f15552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d9.a f15553b;

    public Bitmap a(int i10, boolean z10, int i11) {
        return b(fc.b.a.f6001u).a(i10, z10, i11);
    }

    public nh.a b(String str) {
        if (fc.b.b(str)) {
            e.f(f15550c, "TranThubWallpaperManager");
            b bVar = this.f15552a;
            if (bVar != null) {
                return bVar;
            }
            b bVar2 = new b();
            this.f15552a = bVar2;
            return bVar2;
        }
        e.f(f15550c, "TranAospWallpaperManager");
        d9.a aVar = this.f15553b;
        if (aVar != null) {
            return aVar;
        }
        d9.a aVar2 = new d9.a();
        this.f15553b = aVar2;
        return aVar2;
    }

    public WallpaperInfo c(int i10) {
        return b(fc.b.a.f5989i).b(i10);
    }

    @yb.a(level = 1)
    public void d(ComponentName componentName) {
        if (componentName == null) {
            throw new IllegalArgumentException("package name should not be null");
        }
        b(fc.b.a.f5989i).c(componentName);
    }
}
