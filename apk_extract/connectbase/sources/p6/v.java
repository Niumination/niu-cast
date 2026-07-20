package p6;

import android.app.WallpaperColors;
import java.lang.reflect.Method;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class v implements bf.r {
    @Override // bf.r
    public Map<Integer, Integer> a(WallpaperColors wallpaperColors) {
        Method methodG = cc.a.g(WallpaperColors.class, "getAllColors", new Class[0]);
        if (methodG != null) {
            return (Map) cc.a.j(methodG, wallpaperColors, new Object[0]);
        }
        return null;
    }
}
