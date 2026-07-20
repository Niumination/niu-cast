package ic;

import android.app.WallpaperColors;
import com.transsion.hubsdk.app.TranWallpaperColors;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class r1 implements bf.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TranWallpaperColors f7889a = new TranWallpaperColors();

    @Override // bf.r
    public Map<Integer, Integer> a(WallpaperColors wallpaperColors) {
        TranWallpaperColors tranWallpaperColors = this.f7889a;
        if (tranWallpaperColors != null) {
            return tranWallpaperColors.getAllColors(wallpaperColors);
        }
        return null;
    }
}
