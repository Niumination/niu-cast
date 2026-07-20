package androidx.window.layout;

import android.view.DisplayCutout;
import androidx.annotation.RequiresApi;
import kn.l0;
import os.l;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(28)
public final class DisplayCompatHelperApi28 {

    @l
    public static final DisplayCompatHelperApi28 INSTANCE = new DisplayCompatHelperApi28();

    private DisplayCompatHelperApi28() {
    }

    public final int safeInsetBottom(@l DisplayCutout displayCutout) {
        l0.p(displayCutout, "displayCutout");
        return displayCutout.getSafeInsetBottom();
    }

    public final int safeInsetLeft(@l DisplayCutout displayCutout) {
        l0.p(displayCutout, "displayCutout");
        return displayCutout.getSafeInsetLeft();
    }

    public final int safeInsetRight(@l DisplayCutout displayCutout) {
        l0.p(displayCutout, "displayCutout");
        return displayCutout.getSafeInsetRight();
    }

    public final int safeInsetTop(@l DisplayCutout displayCutout) {
        l0.p(displayCutout, "displayCutout");
        return displayCutout.getSafeInsetTop();
    }
}
