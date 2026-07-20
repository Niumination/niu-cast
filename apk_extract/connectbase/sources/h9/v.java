package h9;

import android.app.WallpaperColors;
import ic.r1;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class v {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f7074c = "v";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public r1 f7075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p6.v f7076b;

    public Map<Integer, Integer> a(WallpaperColors wallpaperColors) {
        if (wallpaperColors != null) {
            return b(fc.b.a.f6001u).a(wallpaperColors);
        }
        throw new IllegalArgumentException("wallpaperColors is null");
    }

    public bf.r b(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f7074c, "TranThubWallpaperColors");
            r1 r1Var = this.f7075a;
            if (r1Var != null) {
                return r1Var;
            }
            r1 r1Var2 = new r1();
            this.f7075a = r1Var2;
            return r1Var2;
        }
        dc.e.f(f7074c, "TranAospWallpaperColors");
        p6.v vVar = this.f7076b;
        if (vVar != null) {
            return vVar;
        }
        p6.v vVar2 = new p6.v();
        this.f7076b = vVar2;
        return vVar2;
    }
}
